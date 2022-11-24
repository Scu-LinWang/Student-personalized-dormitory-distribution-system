package com.dormitory.springboot.service;

import com.dormitory.springboot.entity.Admin;
import com.dormitory.springboot.entity.Visitor;
import com.dormitory.springboot.mapper.VisitorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VisitorService {
    @Autowired
    private VisitorMapper visitorMapper;

    public Map<String, Object> findPageInfo(String v_id, String v_name, Integer pageIndex, Integer pageSize) {
        Map<String, Object> res = new HashMap<>();
        //获取总条数
        Integer totalCount = visitorMapper.totalCount(v_id, v_name);
        res.put("total", totalCount);
        if (totalCount>0){
            //每一页显示访客信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Visitor> visitorList = visitorMapper.getVisitorList(v_id, v_name,
                    (pageIndex -1)*pageSize, pageSize);
            res.put("visitorList", visitorList);
        }
        return res;
    }

    public List<Visitor> getAll(){
        List<Visitor> visitorList = visitorMapper.getAll();
        return visitorList;
    }

    //添加访客信息
    public int addVisitor(Visitor visitor) {
        return visitorMapper.addVisitor(visitor);
    }

    //删除访客信息
    public int deleteVisitor(String v_id) {
        return visitorMapper.deleteVisitor(v_id);
    }

    //修改访客信息
    public int updateVisitor(Visitor visitor) {
        return visitorMapper.updateVisitor(visitor);
    }
    
    public Visitor findVisitorById(String v_id) {
        Visitor v = visitorMapper.findVisitorById(v_id);
        return v;
    }
}
