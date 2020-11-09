package com.testtask.actions;

import com.testtask.entity.Student;
import com.testtask.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class DeleteStudentAction implements Action {

    private StudentService studentService;
    private Scanner scanner;
    private final String name = "Delete Student by id.";

    @Autowired
    public DeleteStudentAction(StudentService studentService, Scanner scanner) {
        this.studentService = studentService;
        this.scanner = scanner;
    }

    @Override
    public int start() {
        System.out.println();
        System.out.println("Enter id to remove student");
        Long id;
        try{
            id = scanner.nextLong();
            scanner.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Wrong id format");
            return 1;
        }


        Student st= studentService.findById(id);
        if(st == null){
            System.out.println("No such student existed. (press enter to exit)");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 1;
        }

        System.out.println("Delete this student (y/n)? " + st);
        String answer = scanner.nextLine();
        if(!answer.startsWith("y")) return 1;
        studentService.delete(id);
        System.out.println("Successful");
        System.out.println("press enter to exit.");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String getActionName() {
        return this.name;
    }
}

