package com.example.Micro_03.Service;
import com.example.Micro_03.Model.Student;
import com.example.Micro_03.Repository.SRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SService {

    @Autowired
    SRepository sRepository;

    public Integer saveStudent(Student student) {
        return sRepository.saveStudent(student.getStudent_id(), student.getStudent_name(), student.getStudent_email(), student.getStudent_branch());
    }

    public Integer update(Student student, Integer id) {
        return sRepository.updateStudent(student.getStudent_id(), student.getStudent_name(), student.getStudent_email(), student.getStudent_branch(), id);
    }

    public List<Student> getStudents() {
        return sRepository.getStudents();
    }

    public Integer deleteStudent(Integer id) {
        return sRepository.deleteStudent(id);
    }

    public Student getStudentByID(Integer id) {
        return sRepository.getStudentByID(id);
    }
}
