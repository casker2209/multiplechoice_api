package vn.usth.internship.api.object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    private ExamRepository examRepository;

    @GetMapping(value="/")
    public List<Exam> getAllExam(){
        return examRepository.findAll();
    }

    @PreAuthorize("hasRole")
    @GetMapping(value = "/id/{id}")
    public Exam getExambyID(@PathVariable String id){
        return examRepository.findById(id).get();
    }


    @GetMapping(value = "/name/{name}")
        public List<Exam> getExambyName(@PathVariable String name){
        return examRepository.findByNameContaining(name);
    }
    @GetMapping(value = "/name")
    public List<String> getExamName(){
        List<Exam> examList = examRepository.findAll();
        ArrayList<String> List = new ArrayList<>();
        for(Exam exam: examList){
            List.add(exam.getName());
        }
        return List;
    }

}
