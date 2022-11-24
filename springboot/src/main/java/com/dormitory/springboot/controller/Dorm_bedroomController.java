package com.dormitory.springboot.controller;

import com.dormitory.springboot.entity.Dorm_bedroom;
import com.dormitory.springboot.service.Dorm_bedroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dorm_bedroom")
public class Dorm_bedroomController {
    @Autowired
    private Dorm_bedroomService dorm_bedroomService;

    /**
     * 分页查询
     */
    @GetMapping(value = "/findDorm_bedroom")
    @ResponseBody
    public Map<String, Object> findDorm_bedroom(Integer d_did, Integer b_bid, Integer pageIndex,
                                                Integer pageSize, Model model) {

        Map<String, Object> res = dorm_bedroomService.findPageInfo(d_did, b_bid,
                pageIndex,pageSize);
        model.addAttribute("res",res);
        return res;
    }

    /**
     * 导出Excel
     */
    @GetMapping(value = "/exportDorm_bedroomlist")
    @ResponseBody
    public List<Dorm_bedroom> exportDorm_bedroom(){
        List<Dorm_bedroom> dorm_bedroom = dorm_bedroomService.getAll();
        return dorm_bedroom;
    }

    /**
     * 添加围合小寝信息
     */
    @PostMapping(value = "/addDorm_bedroom")
    @ResponseBody
    public String addDorm_bedroom(@RequestBody Dorm_bedroom dorm_bedroom){
        int d = dorm_bedroomService.addDorm_bedroom(dorm_bedroom);
        return "dorm_bedroom_list";
    }

    /**
     * 删除围合小寝信息
     */
    @DeleteMapping(value = "/deleteDorm_bedroom")
    @ResponseBody
    public String deleteDorm_bedroom(Integer d_did, Integer b_bid){
        int d = dorm_bedroomService.deleteDorm_bedroom(d_did, b_bid);
        return "dorm_bedroom_list";
    }

    /**
     * 修改围合小寝信息
     */
    @PutMapping(value = "/updateDorm_bedroom")
    @ResponseBody
    public String updateDorm_bedroom(@RequestBody Dorm_bedroom dorm_bedroom){
        int d = dorm_bedroomService.updateDorm_bedroom(dorm_bedroom);
        return "redirect:/findDorm_bedroom";
    }

}
