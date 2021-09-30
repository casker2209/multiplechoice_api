package vn.usth.internship.api.security.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import vn.usth.internship.api.object.ExamHistory;
import vn.usth.internship.api.object.UserInfo;
import vn.usth.internship.api.object.UserInfoRepository;
import vn.usth.internship.api.security.Role;
import vn.usth.internship.api.security.User;
import vn.usth.internship.api.security.UserDetailsImpl;
import vn.usth.internship.api.security.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static vn.usth.internship.api.security.RoleEnum.ROLE_ADMIN;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    UserInfoRepository userInfoRepository;
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public UserInfo userAccess(@PathVariable("id") String userId){
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDetails.getUser();
        if(userDetails.getId().equals(userId)){
            return userInfoRepository.findByUser(user).get();
        }
        else if(user.getRoles().contains(new Role(ROLE_ADMIN))){
            User notadmin =  userRepository.findById(userId).get();
            return userInfoRepository.findByUser(notadmin).get();
        }
        else throw new AccessDeniedException("Access Denied.");
    }
    @PostMapping("/user/{id}/exam")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String sendExamHistory(@PathVariable("id") String userId,@RequestBody ExamHistory examHistory){
        UserInfo userInfo = userAccess(userId);
        ArrayList<ExamHistory> history = (ArrayList<ExamHistory>) userInfo.getExamHistory();
        history.add(examHistory);
        userInfo.setExamHistory(history);
        userInfoRepository.save(userInfo);
        return "Updated";
    }

    @GetMapping("/user/{id}/exam/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<ExamHistory> getExamHistory(@PathVariable("id") String userId){
        UserInfo userInfo = userAccess(userId);
        ArrayList<ExamHistory> history = (ArrayList<ExamHistory>) userInfo.getExamHistory();
        return history;
    }


    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

}