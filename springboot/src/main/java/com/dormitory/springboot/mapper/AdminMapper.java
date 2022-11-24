package com.dormitory.springboot.mapper;

import com.dormitory.springboot.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {
    /**
     * 通过账号和密码查询管理员
     */
    Admin findAdmin(Admin admin);
    //获取总条数
    Integer totalCount(@Param("a_aid") String a_aid, @Param("a_name") String a_name);
    //获取用户列表
    List<Admin> getAdminList(@Param("a_aid") String a_aid, @Param("a_name") String a_name,
                                        @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    int addAdmin(Admin admin);    //添加管理员信息
    int deleteAdmin(String a_aid);   //删除管理员信息
    int updateAdmin(Admin admin); //修改管理员信息
    Admin findAdminByAid(String a_aid);
    List<Admin> getAll();
}
