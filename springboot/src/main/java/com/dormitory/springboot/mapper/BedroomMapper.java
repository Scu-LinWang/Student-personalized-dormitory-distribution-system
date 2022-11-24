package com.dormitory.springboot.mapper;

import com.dormitory.springboot.entity.Bedroom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BedroomMapper {
    /**
     * 进行分页查询
     */

    //获取总条数
    Integer totalCount(Integer b_bid);
    //获取用户列表
    List<Bedroom> getBedroomList(@Param("b_bid") Integer b_bid,
                                 @Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

    int addBedroom(Bedroom Bedroom);    //添加小寝信息
    int deleteBedroom(Integer b_bid);   //删除小寝信息
    int updateBedroom(Bedroom bedroom); //修改小寝信息
    Bedroom findBedroomByBid(Integer b_bid);
    List<Bedroom> getAll();
}

