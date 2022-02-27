package com.example.Micro_03.Controller;
import com.example.Micro_03.Model.Student;
import com.example.Micro_03.Service.SService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1")
@CrossOrigin("https://emp-front-p.vercel.app/")
@RestController
public class API {

    @Autowired
    SService sService;

    @PostMapping("/save")
    public Integer save(@RequestBody Student student) {
        return sService.saveStudent(student);
    }

    @PutMapping("/update/{id}")
    public Integer update(@PathVariable("id") Integer id, @RequestBody Student student) {
        return sService.update(student, id);
    }

    @GetMapping("/getAll")
    public List<Student> getAll() {
        return sService.getStudents();
    }

    @DeleteMapping("/delete/{id}")
    public Integer delete(@PathVariable("id") Integer id) {
        return sService.deleteStudent(id);
    }

    @GetMapping("getById/{id}")
    public Student getById(@PathVariable("id") Integer id) {
        return sService.getStudentByID(id);
    }

}
