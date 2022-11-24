package com.dormitory.springboot.mapper;

import com.dormitory.springboot.entity.College;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CollegeMapper {
    //获取总条数
    Integer totalCount(@Param("college_name") String college_name, @Param("college_major") String college_major);
    //获取学院专业列表
    List<College> getCollegeList(@Param("college_name") String college_name, @Param("college_major") String college_major,
                                        @Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

    int addCollege(College college);//添加学院信息
    int deleteCollege(@Param("college_name") String college_name,@Param("college_major") String college_major);//删除学院信息
    int updateCollege(College college); //修改学院信息

    List<College> getAll();
}
