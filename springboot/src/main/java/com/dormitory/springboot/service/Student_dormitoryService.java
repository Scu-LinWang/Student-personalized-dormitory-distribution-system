package com.dormitory.springboot.service;

import com.dormitory.springboot.entity.Student_dormitory;
import com.dormitory.springboot.mapper.Student_dormitoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Student_dormitoryService {
    @Autowired
    private Student_dormitoryMapper student_dormitoryMapper;


    public Map<String, Object> findPageInfo(String s_sid, 
                                            Integer pageIndex, Integer pageSize) {
        Map<String, Object> res = new HashMap<>();
        //获取总条数
        Integer totalCount = student_dormitoryMapper.totalCount(s_sid);
        res.put("total", totalCount);
        if (totalCount>0){
            //每一页显示学生宿舍信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Student_dormitory> student_dormitoryList = student_dormitoryMapper.getStudent_dormitoryList(s_sid,
                    (pageIndex -1)*pageSize, pageSize);
            res.put("student_dormitoryList", student_dormitoryList);
        }
        return res;
    }


    public int addStudent_dormitory(Student_dormitory student_dormitory) {
        return student_dormitoryMapper.addStudent_dormitory(student_dormitory);
    }


    public int deleteStudent_dormitory(String s_sid) {
        return student_dormitoryMapper.deleteStudent_dormitory(s_sid);
    }


    public int updateStudent_dormitory(Student_dormitory student_dormitory) {
        return student_dormitoryMapper.updateStudent_dormitory(student_dormitory);
    }


    public List<Student_dormitory> getAll() {
        List<Student_dormitory> student_dormitorylist = student_dormitoryMapper.getAll();
        return student_dormitorylist;
    }
}
