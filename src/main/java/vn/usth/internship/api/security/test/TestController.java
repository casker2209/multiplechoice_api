package vn.usth.internship.api.security.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import vn.usth.internship.api.object.ExamHistory;
import vn.usth.internship.api.object.UserInfo;
import vn.usth.internship.api.object.UserInfoRepository;
import vn.usth.internship.api.security.Role;
import vn.usth.internship.api.security.User;
import vn.usth.internship.api.security.UserDetailsImpl;
import vn.usth.internship.api.security.UserRepository;

import java.util.ArrayList;

import static vn.usth.internship.api.security.RoleEnum.ROLE_ADMIN;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    UserInfoRepository userInfoRepository;
    UserRepository userRepository;
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

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

    @GetMapping("/mod")
    @PreAuthorize("hasRole('CONTRIBUTOR')")
    public String moderatorAccess() {
        return "Contributor Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

}