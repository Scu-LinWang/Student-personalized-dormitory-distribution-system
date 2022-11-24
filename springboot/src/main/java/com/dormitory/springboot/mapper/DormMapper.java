package com.dormitory.springboot.mapper;

import com.dormitory.springboot.entity.Dorm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DormMapper {
    /**
     * 进行分页查询
     */

    //获取总条数
    Integer totalCount(Integer d_did);
    //获取围合列表
    List<Dorm> getDormList(@Param("d_did") Integer d_did,
                                  @Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

    int addDorm(Dorm dorm);//添加围合信息
    int deleteDorm(Integer d_did);//删除围合信息
    int updateDorm(Dorm dorm); //修改围合信息
    Dorm findDormByDid(Integer d_did);
    List<Dorm> getAll();
}
