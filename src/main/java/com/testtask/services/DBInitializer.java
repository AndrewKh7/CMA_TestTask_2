package com.testtask.services;

import com.testtask.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class DBInitializer {
    @Autowired
    StudentService studentService;

    @PostConstruct
    public void initDB() throws ParseException {
        Student st = new Student();
        st.setName("Андрей");
        st.setSurname("Храпков");
        st.setPatronymic("Игоревич");
        st.setStudentGroup(3491);
        st.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1994-11-30"));
        studentService.save(st);
    }
}

