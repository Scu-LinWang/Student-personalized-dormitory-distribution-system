package com.dormitory.springboot.mapper;

import com.dormitory.springboot.entity.Visitor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VisitorMapper {
    /**
     * 进行分页查询
     */

    //获取总条数
    Integer totalCount(@Param("v_id") String v_id, @Param("v_name") String v_name);
    //获取用户列表
    List<Visitor> getVisitorList( @Param("v_id") String v_id, @Param("v_name") String v_name,
                                        @Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

    int addVisitor(Visitor visitor);//添加访客信息
    int deleteVisitor(String v_id);//删除访客信息
    int updateVisitor(Visitor visitor); //修改访客信息
    Visitor findVisitorById(String v_id);
    List<Visitor> getAll();
}
