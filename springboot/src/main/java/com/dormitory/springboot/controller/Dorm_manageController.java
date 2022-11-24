package com.dormitory.springboot.controller;

import com.dormitory.springboot.entity.Dorm_manage;
import com.dormitory.springboot.service.Dorm_manageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dorm_manage")
public class Dorm_manageController {
    @Autowired
    private Dorm_manageService dorm_manageService;

    /**
     * 分页查询
     */
    @GetMapping(value = "/findDorm_manage")
    @ResponseBody
    public Map<String, Object> findDorm_manage(String a_aid, Integer d_did, Integer pageIndex,
                                                Integer pageSize, Model model) {

        Map<String, Object> res = dorm_manageService.findPageInfo(a_aid, d_did,
                pageIndex,pageSize);
        model.addAttribute("res",res);
        return res;
    }

    /**
     * 导出Excel
     */
    @GetMapping(value = "/exportDorm_managelist")
    @ResponseBody
    public List<Dorm_manage> exportDorm_manage(){
        List<Dorm_manage> dorm_manage = dorm_manageService.getAll();
        return dorm_manage;
    }

    /**
     * 添加围合管理信息
     */
    @PostMapping(value = "/addDorm_manage")
    @ResponseBody
    public String addDorm_manage(@RequestBody Dorm_manage dorm_manage){
        int d = dorm_manageService.addDorm_manage(dorm_manage);
        return "dorm_manage_list";
    }

    /**
     * 删除围合管理信息
     */
    @DeleteMapping(value = "/deleteDorm_manage")
    @ResponseBody
    public String deleteDorm_manage(String a_aid, Integer d_did){
        int d = dorm_manageService.deleteDorm_manage(a_aid, d_did);
        return "dorm_manage_list";
    }

    /**
     * 修改围合管理信息
     */
    @PutMapping(value = "/updateDorm_manage")
    @ResponseBody
    public String updateDorm_manage(@RequestBody Dorm_manage dorm_manage){
        int d = dorm_manageService.updateDorm_manage(dorm_manage);
        return "redirect:/findDorm_manage";
    }
}
