package com.ynova.library.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ynova.library.execption.DuplicateBookException;
import com.ynova.library.execption.ErrorMessages;
import com.ynova.library.execption.StudentnotFoundExeption;
import com.ynova.library.model.Student;
import com.ynova.library.service.IStudentService;

public class StudentServiceImpl implements IStudentService {

    private final List<Student> students = new ArrayList<>();

    @Override
    public void registerStudent(Student student) {
        boolean isDuplicateStudent = students.stream()
                .anyMatch(existingStudent -> existingStudent.getDni().equals(student.getDni()));
        if (isDuplicateStudent) {
            throw new DuplicateBookException(
                    ErrorMessages.DUPLICATE_STUDENT.formatMessage(student.getName() + student.getDni()));
        }
        students.add(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return students;
    }

    @Override
    public Optional<Student> findStundentByDNI(String dni) {

        Optional<Student> optionalStudent = students.stream()
                .filter(student -> student.getDni().equals(dni))
                .findFirst();

        if (optionalStudent.isEmpty()) {
            throw new StudentnotFoundExeption(
                    ErrorMessages.STUDENT_NOT_FOUND.formatMessage(dni));
        }
        return optionalStudent;
    }

}
