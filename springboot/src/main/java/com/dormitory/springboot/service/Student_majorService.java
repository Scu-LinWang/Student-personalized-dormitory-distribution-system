package com.dormitory.springboot.service;

import com.dormitory.springboot.entity.Student_major;
import com.dormitory.springboot.mapper.Student_majorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Student_majorService {
    @Autowired
    private Student_majorMapper student_majorMapper;


    public Map<String, Object> findPageInfo(String s_sid,
                                            Integer pageIndex, Integer pageSize) {
        Map<String, Object> res = new HashMap<>();
        //获取总条数
        Integer totalCount = student_majorMapper.totalCount(s_sid);
        res.put("total", totalCount);
        if (totalCount>0){
            //每一页显示学生专业信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Student_major> student_majorList = student_majorMapper.getStudent_majorList(s_sid,
                    (pageIndex -1)*pageSize, pageSize);
            res.put("student_majorList", student_majorList);
        }
        return res;
    }


    public int addStudent_major(Student_major student_major) {
        return student_majorMapper.addStudent_major(student_major);
    }


    public int deleteStudent_major(String s_sid) {
        return student_majorMapper.deleteStudent_major(s_sid);
    }


    public int updateStudent_major(Student_major student_major) {
        return student_majorMapper.updateStudent_major(student_major);
    }


    public List<Student_major> getAll() {
        List<Student_major> student_majorlist = student_majorMapper.getAll();
        return student_majorlist;
    }
}
