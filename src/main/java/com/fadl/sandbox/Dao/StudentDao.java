package com.fadl.sandbox.Dao;

import com.fadl.sandbox.Entity.Student;

import java.util.Collection;

/**
 * Created by fadl on 2017-04-12.
 */
public interface StudentDao {
    Collection<Student> getAllStudents();

    Student getStudentById(int id);

    Boolean checkStudentById(int id);

    void deleteStudentById(int id);

    Student updateStudentById(Student student);

    Student addStudent(Student student);
}
