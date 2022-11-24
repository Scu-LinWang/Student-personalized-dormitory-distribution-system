package com.dormitory.springboot.mapper;

import com.dormitory.springboot.entity.Dorm_bedroom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Dorm_bedroomMapper {
    //获取总条数
    Integer totalCount(@Param("d_did") Integer d_did, @Param("b_bid") Integer b_bid);
    //获取学院专业列表
    List<Dorm_bedroom> getDorm_bedroomList(@Param("d_did") Integer d_did, @Param("b_bid") Integer b_bid,
                                 @Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

    int addDorm_bedroom(Dorm_bedroom Dorm_bedroom);//添加学院信息
    int deleteDorm_bedroom(@Param("d_did") Integer d_did, @Param("b_bid") Integer b_bid);//删除学院信息
    int updateDorm_bedroom(Dorm_bedroom Dorm_bedroom); //修改学院信息

    List<Dorm_bedroom> getAll();
}
