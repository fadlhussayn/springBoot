package com.fadl.sandbox.Service;

import com.fadl.sandbox.Dao.StudentDao;
import com.fadl.sandbox.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by fadl on 2017-04-10.
 */
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Collection<Student> getAllStudents(){
        return this.studentDao.getAllStudents();
    }

    public Student getStudentById(int id){
        //this.studentDao.checkStudentById(id);
        return this.studentDao.getStudentById(id);
    }


    public void deleteStudentById(int id) {
        this.studentDao.deleteStudentById(id);
    }

    public Student updateStudentById(Student student){
        this.studentDao.updateStudentById(student);
        return  student;
    }

    public Student addStudent(Student student) {
        this.studentDao.addStudent(student);
        return student;
    }
}
