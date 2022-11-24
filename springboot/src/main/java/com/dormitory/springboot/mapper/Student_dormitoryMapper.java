package com.dormitory.springboot.mapper;

import com.dormitory.springboot.entity.Student_dormitory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Student_dormitoryMapper {
    /**
     * 进行分页查询
     */

    //获取总条数
    public Integer totalCount(String s_sid);

    //获取学生住宿列表
    public List<Student_dormitory> getStudent_dormitoryList(@Param("s_sid")String s_sid,
                                                            @Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

    public int addStudent_dormitory(Student_dormitory student_dormitory);//添加学生住宿信息
    public int deleteStudent_dormitory(String s_sid);//删除学生住宿信息
    public int updateStudent_dormitory(Student_dormitory student_dormitory); //修改学生住宿信息
    public List<Student_dormitory> getAll();
}

