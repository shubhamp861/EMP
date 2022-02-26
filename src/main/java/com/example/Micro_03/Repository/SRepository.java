package com.example.Micro_03.Repository;
import com.example.Micro_03.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SRepository extends JpaRepository<Student, Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO student (student_id,student_name,student_email,student_branch) values (:student_id,:student_name,:student_email,:student_branch)", nativeQuery = true)
    public Integer saveStudent
            (@Param("student_id") Integer student_id, @Param("student_name") String student_name, @Param("student_email") String student_email,
             @Param("student_branch") String student_branch);

    @Query(value = "SELECT * FROM student", nativeQuery = true)
    public List<Student> getStudents();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM student WHERE student_id = :id", nativeQuery = true)
    public Integer deleteStudent(@Param("id") Integer id);

    @Query(value = "SELECT * FROM student WHERE student_id = :id", nativeQuery = true)
    public Student getStudentByID(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "Update student set student_id = :student_id,student_name = :student_name,student_email = :student_email,student_branch = :student_branch where student_id = :id", nativeQuery = true)
    public Integer updateStudent(@Param("student_id") Integer student_id, @Param("student_name") String student_name, @Param("student_email") String student_email,
                                 @Param("student_branch") String student_branch, @Param("id") Integer id);
}
