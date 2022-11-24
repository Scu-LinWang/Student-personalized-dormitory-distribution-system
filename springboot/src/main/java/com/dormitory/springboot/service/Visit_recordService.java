package com.dormitory.springboot.service;

import com.dormitory.springboot.entity.Visit_record;
import com.dormitory.springboot.mapper.Visit_recordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Visit_recordService {
    @Autowired
    private Visit_recordMapper visit_recordMapper;

    public Map<String, Object> findPageInfo(Integer d_did, String v_id, Date v_intime,
                                            Integer pageIndex, Integer pageSize) {
        Map<String, Object> res = new HashMap<>();
        //获取总条数
        Integer totalCount = visit_recordMapper.totalCount(d_did, v_id, v_intime);
        res.put("total", totalCount);
        if (totalCount>0){
            //每一页显示围合访问信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Visit_record> visit_recordList = visit_recordMapper.getVisit_recordList(d_did, v_id, v_intime,
                    (pageIndex -1)*pageSize, pageSize);
            res.put("visitor_recordList", visit_recordList);
        }
        return res;
    }
    
    public int addVisit_record(Visit_record visit_record) {
        return visit_recordMapper.addVisit_record(visit_record);
    }
    
    public int deleteVisit_record(Integer d_did, String v_id, Date v_intime) {
        return visit_recordMapper.deleteVisit_record(d_did, v_id, v_intime);
    }
    
    public int updateVisit_record(Visit_record visit_record) {
        return visit_recordMapper.updateVisit_record(visit_record);
    }
    
    public Visit_record findVisit_recordByDid(Integer d_did) {
        Visit_record v = visit_recordMapper.findVisit_recordByDid(d_did);
        return v;
    }
    
    public List<Visit_record> getAll() {
        List<Visit_record> visit_recordlist = visit_recordMapper.getAll();
        return visit_recordlist;
    }
}
