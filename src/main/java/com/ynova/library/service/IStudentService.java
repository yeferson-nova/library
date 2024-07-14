package com.ynova.library.service;

import java.util.List;
import java.util.Optional;

import com.ynova.library.model.Student;

public interface IStudentService {
    
    void registerStudent(Student student);

    List<Student> getAllStudent();

    Optional<Student> findStundentByDNI(String dni);

}
