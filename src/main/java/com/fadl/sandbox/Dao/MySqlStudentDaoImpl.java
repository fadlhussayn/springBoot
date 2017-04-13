package com.fadl.sandbox.Dao;

import com.fadl.sandbox.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by fadl on 2017-04-12.
 */

@Repository("mysql")
@Qualifier("mysqlData")
public class MySqlStudentDaoImpl implements StudentDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    private static class StudentRowMapper implements RowMapper<Student>{

        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setCourse(resultSet.getString("course"));
            return student;
        }
    }
    
    
    @Override
    public Collection<Student> getAllStudents() {
        // gets all students from db
        final String sql = "select id, name, course from students";
        List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper());
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        // gets student where id is id
        final String sql = "select id, name, course from students where id= ?";
        Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
        return student;
    }

    @Override
    public Boolean checkStudentById(int id) {
        return null;
    }

    @Override
    public void deleteStudentById(int id) {
        final String sql = "delete from students where id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public Student updateStudentById(Student student) {
        final String sql = "update students set name=?, course=? where id =?";
        final int id = student.getId();
        final String name = student.getName();
        final String course = student.getCourse();
        jdbcTemplate.update(sql, new Object[]
                {
                        name,
                        course,
                        id
                });

        return null;
    }

    @Override
    public Student addStudent(Student student) {
        final String sql = "insert into students (name, course) values (?, ?)";
        final String name = student.getName();
        final String course = student.getCourse();
        jdbcTemplate.update(sql, new Object[]
                {
                        name,
                        course
                });
        return null;
    }
}
