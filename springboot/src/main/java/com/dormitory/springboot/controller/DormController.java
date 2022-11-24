package com.dormitory.springboot.controller;

import com.dormitory.springboot.entity.Dorm;
import com.dormitory.springboot.service.DormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dorm")
public class DormController {
    @Autowired
    private DormService dormService;

    /**
     * 分页查询
     */
    @RequestMapping(value = "/findDorm")
    @ResponseBody
    public Map<String, Object> findDorm(Integer d_did, Integer pageIndex,
                                           Integer pageSize, Model model) {

        Map<String, Object> res = dormService.findPageInfo(d_did,
                pageIndex,pageSize);
        model.addAttribute("res",res);
        return res;
    }

    /**
     * 导出Excel
     */
    @GetMapping("/exportDormlist")
    //等价于@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    //与@Contoller使用表示返回json，不加@ResponBody则返回页面
    public List<Dorm> exportDorm(){
        List<Dorm> dormList = dormService.getAll();
        return dormList;
    }

    /**
     * 添加围合信息
     */
    @PostMapping("/addDorm")
    //等价于@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String addDorm(@RequestBody Dorm dorm){
        //@RequestBody接收前端传来的json数据
        int d = dormService.addDorm(dorm);
        return "dorm_list";
    }

    /**
     * 删除围合信息
     */
    @DeleteMapping("/deleteDorm")
    @ResponseBody
    //等价于@RequestMapping(method = RequestMethod.DELETE)
    public String deleteDorm(Integer d_did){
        int d = dormService.deleteDorm(d_did);
        return "dorm_list";
    }

    /**
     * 修改围合信息
     */
    @PutMapping("/updateDorm")
    @ResponseBody
    //与PostMapping差别不大
    //等价于@RequestMapping(method = RequestMethod.PUT)
    public String updateDorm(@RequestBody Dorm dorm){
        int d = dormService.updateDorm(dorm);
        return "redirect:/findDorm";
    }


    /**
     * 根据围合Id搜索;将请求数据v_id写入参数v_id
     */
    @GetMapping( "/findDormByDid")
    @ResponseBody
    public Dorm findDormByDid(Integer d_did, HttpSession session) {
        Dorm d = dormService.findDormByDid(d_did);
        session.setAttribute("d",d);
        return d;
    }
}
