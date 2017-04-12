package com.fadl.sandbox.Dao;

import com.fadl.sandbox.Entity.Student;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sun.font.TrueTypeFont;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fadl on 2017-04-10.
 */
@Repository
public class StudentDao {
    @Autowired
    private static Map<Integer, Student> students;

    static {

        students = new HashMap<Integer, Student>(){

            {
                put(1, new Student(1, "said", "Computer Science"));
                put(2, new Student(2, "Alex", "Math"));
                put(3, new Student(3, "Anna", "English lit"));
                put(4, new Student(4, "abbas", "7arakit amal"));
            }
        };
    }

    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    public Student getStudentById(int id){
        return this.students.get(id);
    }

    public Boolean checkStudentById(int id){

        if(this.students.get(id) == null){
            // student does not exist
            throw new IllegalArgumentException("could not find student with ID: " + id);
        }
        return true;
    }


    public void deleteStudentById(int id) {
        this.students.remove(id);
    }

    public Student updateStudentById(Student student){
        Student s = this.students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        this.students.put(s.getId(), s);
        return  student;
    }

    public Student addStudent(Student student) {
        this.students.put(student.getId(), student);
        return student;
    }
}
