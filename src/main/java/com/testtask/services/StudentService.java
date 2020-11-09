package com.testtask.services;



import com.testtask.entity.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);
    List<Student> findAll();
    void delete(Long id);
    Student findById(Long id);
}

