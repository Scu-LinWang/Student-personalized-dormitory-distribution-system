package com.dormitory.springboot.controller;

import com.dormitory.springboot.entity.Visitor;
import com.dormitory.springboot.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/visitor")
public class VisitorController {
    @Autowired
    private VisitorService visitorService;
    

    /**
     * 分页查询
     */
    @RequestMapping(value = "/findVisitor")
    @ResponseBody
    public Map<String, Object> findVisitor(String v_id, String v_name, Integer pageIndex,
                                         Integer pageSize, Model model) {

        Map<String, Object> res = visitorService.findPageInfo(v_id, v_name,
                pageIndex,pageSize);
        model.addAttribute("res",res);
        return res;
    }

    /**
     * 导出Excel
     */
    @GetMapping("/exportVisitorlist")
    //等价于@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    //与@Contoller使用表示返回json，不加@ResponBody则返回页面
    public List<Visitor> exportVisitor(){
        List<Visitor> visitorList = visitorService.getAll();
        return visitorList;
    }

    /**
     * 添加访客信息
     */
    @PostMapping("/addVisitor")
    //等价于@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String addVisitor(@RequestBody Visitor visitor){
        //@RequestBody接收前端传来的json数据
        int v = visitorService.addVisitor(visitor);
        return "visitor_list";
    }

    /**
     * 删除访客信息
     */
    @DeleteMapping("/deleteVisitor")
    @ResponseBody
    //等价于@RequestMapping(method = RequestMethod.DELETE)
    public String deleteVisitor(String v_id){
        int v = visitorService.deleteVisitor(v_id);
        return "visitor_list";
    }

    /**
     * 修改访客信息
     */
    @PutMapping("/updateVisitor")
    @ResponseBody
    //与PostMapping差别不大
    //等价于@RequestMapping(method = RequestMethod.PUT)
    public String updateVisitor(@RequestBody Visitor visitor){
        int v = visitorService.updateVisitor(visitor);
        return "redirect:/findVisitor";
    }


    /**
     * 根据访客Id搜索;将请求数据v_id写入参数v_id
     */
    @GetMapping( "/findVisitorById")
    @ResponseBody
    public Visitor findVisitorById(String v_id, HttpSession session) {
        Visitor v= visitorService.findVisitorById(v_id);
        session.setAttribute("v",v);
        return v;
    }
}
