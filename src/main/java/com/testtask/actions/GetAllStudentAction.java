package com.testtask.actions;

import com.testtask.services.StudentService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class GetAllStudentAction implements Action {

    StudentService studentService;
    String name = "Show all students";

    public GetAllStudentAction(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public int start() {
        System.out.println();
        studentService.findAll().forEach(System.out::println);
        return 0;
    }

    @Override
    public String getActionName() {
        return this.name;
    }
}

