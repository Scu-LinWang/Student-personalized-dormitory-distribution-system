package com.dormitory.springboot.mapper;

import com.dormitory.springboot.entity.Visit_record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface Visit_recordMapper {
    /**
     * 进行分页查询
     */

    //获取总条数
    public Integer totalCount(@Param("d_did")Integer d_did, @Param("v_id")String v_id,
                               @Param("v_intime") Date v_intime);

    //获取访问记录列表
    public List<Visit_record> getVisit_recordList(@Param("d_did")Integer d_did, @Param("v_id")String v_id, @Param("v_intime") Date v_intime,
                                                  @Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

    public int addVisit_record(Visit_record visit_record);//添加访问记录信息
    public int deleteVisit_record(@Param("d_did") Integer d_did, @Param("v_id")String v_id, @Param("v_intime")Date v_intime);//删除访问记录信息
    public int updateVisit_record(Visit_record visit_record); //修改访问记录信息
    public Visit_record findVisit_recordByDid(Integer d_did);//查看围合访问信息

    public List<Visit_record> getAll();
}
