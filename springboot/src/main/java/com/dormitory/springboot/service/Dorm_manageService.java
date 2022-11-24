package com.dormitory.springboot.service;

import com.dormitory.springboot.entity.Dorm_manage;
import com.dormitory.springboot.mapper.Dorm_manageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Dorm_manageService {
    @Autowired
    private Dorm_manageMapper dorm_manageMapper;


    public Map<String, Object> findPageInfo(String a_aid, Integer d_did,
                                            Integer pageIndex, Integer pageSize) {
        Map<String, Object> res = new HashMap<>();
        //获取总条数
        Integer totalCount = dorm_manageMapper.totalCount(a_aid, d_did);
        res.put("total", totalCount);
        if (totalCount>0){
            //每一页显示宿舍管理信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Dorm_manage> dorm_manageList = dorm_manageMapper.getDorm_manageList(a_aid, d_did,
                    (pageIndex -1)*pageSize, pageSize);
            res.put("dorm_manageList", dorm_manageList);
        }
        return res;
    }


    public int addDorm_manage(Dorm_manage dorm_manage) {
        return dorm_manageMapper.addDorm_manage(dorm_manage);
    }


    public int deleteDorm_manage(String a_aid, Integer d_did) {
        return dorm_manageMapper.deleteDorm_manage(a_aid, d_did);
    }


    public int updateDorm_manage(Dorm_manage dorm_manage) {
        return dorm_manageMapper.updateDorm_manage(dorm_manage);
    }


    public List<Dorm_manage> getAll() {
        List<Dorm_manage> dorm_managelist = dorm_manageMapper.getAll();
        return dorm_managelist;
    }
}
