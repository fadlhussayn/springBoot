package com.fadl.sandbox.Controller;

import com.fadl.sandbox.Entity.Student;
import com.fadl.sandbox.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by fadl on 2017-04-10.
 */
@RestController
@RequestMapping("/students")
public class studentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents(){

        return studentService.getAllStudents();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id){

        return this.studentService.getStudentById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String deleteStudentById(@PathVariable("id") int id){
        this.studentService.deleteStudentById(id);

        return "Removed";
    }

    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student updateStudentById(@RequestBody Student student){
        this.studentService.updateStudentById(student);
        return  student;
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student addStudent(@RequestBody Student student){
        this.studentService.addStudent(student);
        return  student;
    }

}
