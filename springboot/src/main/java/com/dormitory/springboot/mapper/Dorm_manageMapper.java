package com.dormitory.springboot.mapper;

import com.dormitory.springboot.entity.Dorm_manage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Dorm_manageMapper {
    //获取总条数
    Integer totalCount(@Param("a_aid") String a_aid, @Param("d_did") Integer d_did);
    //获取围合管理专业列表
    List<Dorm_manage> getDorm_manageList(@Param("a_aid") String a_aid, @Param("d_did") Integer d_did,
                                           @Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

    int addDorm_manage(Dorm_manage Dorm_manage);//添加围合管理信息
    int deleteDorm_manage(@Param("a_aid") String a_aid, @Param("d_did") Integer d_did);//删除围合管理信息
    int updateDorm_manage(Dorm_manage Dorm_manage); //修改围合管理信息

    List<Dorm_manage> getAll();
}
