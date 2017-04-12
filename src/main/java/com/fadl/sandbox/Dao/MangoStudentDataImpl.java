package com.fadl.sandbox.Dao;

import com.fadl.sandbox.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by fadl on 2017-04-12.
 */
@Repository
@Qualifier("mangoData")
public class MangoStudentDataImpl implements StudentDao {

    @Override
    public Collection<Student> getAllStudents() {
        return new ArrayList<Student>(){
            {
                add(new Student(1, "Mario", "Economics"));
            }
        };
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public Boolean checkStudentById(int id) {
        return null;
    }

    @Override
    public void deleteStudentById(int id) {

    }

    @Override
    public Student updateStudentById(Student student) {
        return null;
    }

    @Override
    public Student addStudent(Student student) {
        return null;
    }
}
