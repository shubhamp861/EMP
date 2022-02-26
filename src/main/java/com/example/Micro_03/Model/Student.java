package com.example.Micro_03.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="student")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int student_id;
    private String student_name;
    private String student_email;
    private String student_branch;
}
