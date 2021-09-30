package vn.usth.internship.api.object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private ExamContentRepository examContentRepository;
    @Autowired
    private ExamInfoRepository examInfoRepository;
    @GetMapping(value="/")
    public List<ExamInfo> getAllExam(){
        List<Exam> examList = examRepository.findAll();
        List<ExamInfo> examInfoList = new ArrayList<>();
        for(Exam exam : examList){
            examInfoList.add(exam.getInfo());
        }
        return examInfoList;
    }

    @PreAuthorize("hasRole")
    @GetMapping(value = "/id/{id}")
    public Exam getExambyID(@PathVariable String id){
        return examRepository.findById(id).get();
    }
    @PostMapping("/add")
    @PreAuthorize("hasRole('CONTRIBUTOR') or hasRole('ADMIN')")
    public String addExam(@RequestBody Exam exam){
        examRepository.save(exam);
        return "New exam added";
    }
    @PostMapping("/remove")
    @PreAuthorize("hasRole('CONTRIBUTOR') or hasRole('ADMIN')")
    public String removeExam(@RequestBody Exam exam)
    {
        Exam examF = examRepository.findById(exam.getId()).get();
        System.out.println(examF.getName());
        System.out.println(exam.getId());
        examRepository.delete(exam);
        return "Exam deleted";
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
    @GetMapping(value="/{id}")
    public ExamContent findExambyId(@PathVariable String id){
        Exam exam = examRepository.findById(id).get();
        return exam.getContent();
    }

}
