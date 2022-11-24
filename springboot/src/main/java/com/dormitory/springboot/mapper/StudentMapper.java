package com.dormitory.springboot.mapper;

import com.dormitory.springboot.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    /**
     * 通过账号和密码查询学生
     */
    Student findStudent(Student student);

    /**
     * 进行分页查询
     */
    //获取总条数
    Integer totalCount(@Param("s_sid") String s_sid, @Param("s_name")String s_name);
    //获取用户列表
    List<Student> getStudentList(@Param("s_sid") String s_sid, @Param("s_name")String s_name,
                                 @Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

    int addStudent(Student student);   //添加学生信息
    int deleteStudent(String s_sid);   //删除学生信息
    int updateStudent(Student student); //修改学生信息
    Student findStudentBySid(String s_sid);
    List<Student> getAll();
}
