package com.dormitory.springboot.service;

import com.dormitory.springboot.entity.Admin;
import com.dormitory.springboot.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    //查找管理员
    public Admin findAdmin(Admin admin){
        Admin a = adminMapper.findAdmin(admin);
        return a;
    }

    public Map<String, Object> findPageInfo(String a_aid, String a_name, Integer pageIndex, Integer pageSize) {
        Map<String, Object> res = new HashMap<>();
        //获取总条数
        Integer totalCount = adminMapper.totalCount(a_aid, a_name);
        res.put("total", totalCount);
        if (totalCount>0){
            //每一页显示管理员信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Admin> adminList =	adminMapper.getAdminList(a_aid, a_name,
                    (pageIndex -1)*pageSize, pageSize);
            res.put("adminList", adminList);
        }
        return res;
    }

    //添加管理员信息
    public int addAdmin(Admin admin){
        return adminMapper.addAdmin(admin);
    }

    //删除管理员信息
    public int deleteAdmin(String a_aid){
        return adminMapper.deleteAdmin(a_aid);
    }

    //修改管理员信息
    public int updateAdmin(Admin admin){
        return adminMapper.updateAdmin(admin);
    }

    public Admin findAdminByAid(String a_aid){
        Admin a = adminMapper.findAdminByAid(a_aid);
        return a;
    }

    public List<Admin> getAll(){
        List<Admin> adminList = adminMapper.getAll();
        return adminList;
    }
}
