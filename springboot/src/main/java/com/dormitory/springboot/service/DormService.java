package com.dormitory.springboot.service;

import com.dormitory.springboot.entity.Dorm;
import com.dormitory.springboot.mapper.DormMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DormService {

    @Autowired
    private DormMapper dormMapper;

    public Map<String, Object> findPageInfo(Integer d_did, Integer pageIndex, Integer pageSize) {
        Map<String, Object> res = new HashMap<>();
        //获取总条数
        Integer totalCount = dormMapper.totalCount(d_did);
        res.put("total", totalCount);
        if (totalCount>0){
            //每一页显示围合信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Dorm> dormList = dormMapper.getDormList(d_did,
                    (pageIndex -1)*pageSize, pageSize);
            res.put("dormList", dormList);
        }
        return res;
    }

    public List<Dorm> getAll(){
        List<Dorm> dormList = dormMapper.getAll();
        return dormList;
    }

    //添加访客信息
    public int addDorm(Dorm dorm) {
        return dormMapper.addDorm(dorm);
    }

    //删除访客信息
    public int deleteDorm(Integer d_did) {
        return dormMapper.deleteDorm(d_did);
    }

    //修改访客信息
    public int updateDorm(Dorm dorm) {
        return dormMapper.updateDorm(dorm);
    }

    public Dorm findDormByDid(Integer d_did) {
        Dorm d = dormMapper.findDormByDid(d_did);
        return d;
    }
}
