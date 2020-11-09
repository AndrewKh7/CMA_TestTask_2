package com.testtask.actions;


import com.testtask.entity.Student;
import com.testtask.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

@Component
public class CreateStudentAction implements Action {

    private StudentService studentService;
    private Scanner scanner;
    private final String name = "Create new Student.";

    @Autowired
    public CreateStudentAction(StudentService studentService, Scanner scanner) {
        this.studentService = studentService;
        this.scanner = scanner;
    }

    @Override
    public int start() {
        Student student = new Student();
        System.out.println();
        System.out.println("Enter Student name:");
        student.setName( scanner.nextLine() );
        System.out.println("Enter Student surname:");
        student.setSurname( scanner.nextLine() );
        System.out.println("Enter Student Patronymic:");
        student.setPatronymic( scanner.nextLine());
        System.out.println("Enter Student birthday (yyyy-mm-dd):");
        try {
            student.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse( scanner.nextLine()));
        } catch (ParseException e) {
            System.out.println("Wrong date format! Please try again!");
            return 1;
        }
        System.out.println("Enter Student group:");
        student.setStudentGroup( scanner.nextInt() );
        scanner.nextLine();

        System.out.println("Save this student (y/n)? ");
        String answer = scanner.nextLine();
        if(!answer.startsWith("y")) return 1;
        System.out.println("Saving...");
        studentService.save(student);

        return 0;
    }

    @Override
    public String getActionName() {
        return this.name;
    }
}
