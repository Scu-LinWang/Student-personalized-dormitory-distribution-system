package com.dormitory.springboot.service;

import com.dormitory.springboot.entity.Student;
import com.dormitory.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    //查找学生
    public Student findStudent(Student student){
        Student s = studentMapper.findStudent(student);
        return s;
    }

    public Map<String, Object> findPageInfo(String s_sid, String s_name, Integer pageIndex, Integer pageSize) {
        Map<String, Object> res = new HashMap<>();
        //获取总条数
        Integer totalCount = studentMapper.totalCount(s_sid, s_name);
        res.put("total", totalCount);
        if (totalCount>0){
            //每一页显示学生信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Student> studentList =	studentMapper.getStudentList(s_sid, s_name,
                    (pageIndex -1)*pageSize, pageSize);
            res.put("studentList", studentList);
        }
        return res;
    }

    //添加学生信息
    public int addStudent(Student student){
        return studentMapper.addStudent(student);
    }

    //删除学生信息
    public int deleteStudent(String s_sid){
        return studentMapper.deleteStudent(s_sid);
    }

    //修改学生信息
    public int updateStudent(Student student){
        return studentMapper.updateStudent(student);
    }

    public Student findStudentBySid(String s_sid){
        Student s = studentMapper.findStudentBySid(s_sid);
        return s;
    }

    public List<Student> getAll(){
        List<Student> studentList = studentMapper.getAll();
        return studentList;
    }
}
