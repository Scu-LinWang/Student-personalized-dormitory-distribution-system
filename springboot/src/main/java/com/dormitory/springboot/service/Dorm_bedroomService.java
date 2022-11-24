package com.dormitory.springboot.service;

import com.dormitory.springboot.entity.Dorm_bedroom;
import com.dormitory.springboot.mapper.Dorm_bedroomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Dorm_bedroomService {
    
    @Autowired
    private Dorm_bedroomMapper dorm_bedroomMapper;


    public Map<String, Object> findPageInfo(Integer d_did, Integer b_bid, 
                                            Integer pageIndex, Integer pageSize) {
        Map<String, Object> res = new HashMap<>();
        //获取总条数
        Integer totalCount = dorm_bedroomMapper.totalCount(d_did, b_bid);
        res.put("total", totalCount);
        if (totalCount>0){
            //每一页显示宿舍寝室信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Dorm_bedroom> dorm_bedroomList = dorm_bedroomMapper.getDorm_bedroomList(d_did, b_bid,
                    (pageIndex -1)*pageSize, pageSize);
            res.put("dorm_bedroomList", dorm_bedroomList);
        }
        return res;
    }

    
    public int addDorm_bedroom(Dorm_bedroom dorm_bedroom) {
        return dorm_bedroomMapper.addDorm_bedroom(dorm_bedroom);
    }

    
    public int deleteDorm_bedroom(Integer d_did, Integer b_bid) {
        return dorm_bedroomMapper.deleteDorm_bedroom(d_did, b_bid);
    }

    
    public int updateDorm_bedroom(Dorm_bedroom dorm_bedroom) {
        return dorm_bedroomMapper.updateDorm_bedroom(dorm_bedroom);
    }

    
    public List<Dorm_bedroom> getAll() {
        List<Dorm_bedroom> dorm_bedroomlist = dorm_bedroomMapper.getAll();
        return dorm_bedroomlist;
    }
}
