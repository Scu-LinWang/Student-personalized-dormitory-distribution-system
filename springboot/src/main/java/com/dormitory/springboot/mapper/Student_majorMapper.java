package com.dormitory.springboot.mapper;

import com.dormitory.springboot.entity.Student_major;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Student_majorMapper {
    /**
     * 进行分页查询
     */

    //获取总条数
    public Integer totalCount(String s_sid);

    //获取学生专业列表
    public List<Student_major> getStudent_majorList(@Param("s_sid")String s_sid,
                                                    @Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

    public int addStudent_major(Student_major student_major);//添加学生专业信息
    public int deleteStudent_major(String s_sid);//删除学生专业信息
    public int updateStudent_major(Student_major student_major); //修改学生专业信息
    public List<Student_major> getAll();
}
