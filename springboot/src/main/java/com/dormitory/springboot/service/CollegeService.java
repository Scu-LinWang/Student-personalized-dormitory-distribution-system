package com.dormitory.springboot.service;

import com.dormitory.springboot.entity.College;
import com.dormitory.springboot.mapper.CollegeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CollegeService {
    @Autowired
    private CollegeMapper collegeMapper;

    public Map<String, Object> findPageInfo(String college_name, String college_major,
                                            Integer pageIndex, Integer pageSize) {
        Map<String, Object> res = new HashMap<>();
        //获取总条数
        Integer totalCount = collegeMapper.totalCount(college_name, college_major);
        res.put("total", totalCount);
        if (totalCount>0){
            //每一页显示学院信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<College> collegeList = collegeMapper.getCollegeList(college_name, college_major,
                    (pageIndex -1)*pageSize, pageSize);
            res.put("collegeList", collegeList);
        }
        return res;
    }

    public List<College> getAll(){
        List<College> collegeList = collegeMapper.getAll();
        return collegeList;
    }

    //添加学院信息
    public int addCollege(College college) {
        return collegeMapper.addCollege(college);
    }

    //删除学院信息
    public int deleteCollege(String college_name, String college_major) {
        return collegeMapper.deleteCollege(college_name, college_major);
    }

    //修改学院信息
    public int updateCollege(College college) {
        return collegeMapper.updateCollege(college);
    }
}
