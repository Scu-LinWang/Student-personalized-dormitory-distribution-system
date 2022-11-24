package com.dormitory.springboot.service;

import com.dormitory.springboot.entity.Bedroom;
import com.dormitory.springboot.mapper.BedroomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BedroomService {
    @Autowired
    private BedroomMapper bedroomMapper;

    public Map<String, Object> findPageInfo(Integer b_bid, Integer pageIndex, Integer pageSize) {
        Map<String, Object> res = new HashMap<>();
        //获取总条数
        Integer totalCount = bedroomMapper.totalCount(b_bid);
        res.put("total", totalCount);
        if (totalCount>0){
            //每一页显示寝室信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Bedroom> bedroomList = bedroomMapper.getBedroomList(b_bid,
                    (pageIndex -1)*pageSize, pageSize);
            res.put("bedroomList", bedroomList);
        }
        return res;
    }

    public List<Bedroom> getAll(){
        List<Bedroom> bedroomList = bedroomMapper.getAll();
        return bedroomList;
    }

    //添加寝室信息
    public int addBedroom(Bedroom bedroom) {
        return bedroomMapper.addBedroom(bedroom);
    }

    //删除寝室信息
    public int deleteBedroom(Integer b_bid) {
        return bedroomMapper.deleteBedroom(b_bid);
    }

    //修改寝室信息
    public int updateBedroom(Bedroom bedroom) {
        return bedroomMapper.updateBedroom(bedroom);
    }

    public Bedroom findBedroomByBid(Integer b_bid) {
        Bedroom b = bedroomMapper.findBedroomByBid(b_bid);
        return b;
    }
}
