package com.dormitory.springboot.controller;

import com.dormitory.springboot.entity.Visit_record;
import com.dormitory.springboot.service.Visit_recordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/visit_record")
public class Visit_recordController {
    @Autowired
    private Visit_recordService visit_recordService;


    /**
     * 分页查询
     */
    @RequestMapping(value = "/findVisit_record")
    @ResponseBody
    public Map<String, Object> findVisit_record(Integer d_did, String v_id, Date v_intime,Integer pageIndex,
                                                Integer pageSize, Model model) {

        Map<String, Object> res = visit_recordService.findPageInfo(d_did, v_id, v_intime,
                pageIndex,pageSize);
        model.addAttribute("res",res);
        return res;
    }

    /**
     * 导出Excel
     */
    @GetMapping("/exportVisit_recordlist")
    //等价于@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    //与@Contoller使用表示返回json，不加@ResponBody则返回页面
    public List<Visit_record> exportVisit_record(){
        List<Visit_record> visit_recordList = visit_recordService.getAll();
        return visit_recordList;
    }

    /**
     * 添加访客信息
     */
    @PostMapping("/addVisit_record")
    //等价于@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String addVisit_record(@RequestBody Visit_record visit_record){
        //@RequestBody接收前端传来的json数据
        int v = visit_recordService.addVisit_record(visit_record);
        return "visit_record_list";
    }

    /**
     * 删除访客信息
     */
    @DeleteMapping("/deleteVisit_record")
    @ResponseBody
    //等价于@RequestMapping(method = RequestMethod.DELETE)
    public String deleteVisit_record(Integer d_did, String v_id, Date v_intime){
        int v = visit_recordService.deleteVisit_record(d_did, v_id, v_intime);
        return "visit_record_list";
    }

    /**
     * 修改访客信息
     */
    @PutMapping("/updateVisit_record")
    @ResponseBody
    //与PostMapping差别不大
    //等价于@RequestMapping(method = RequestMethod.PUT)
    public String updateVisit_record(@RequestBody Visit_record visit_record){
        int v = visit_recordService.updateVisit_record(visit_record);
        return "redirect:/findVisit_record";
    }


    /**
     * 根据围合Did搜索;将请求数据d_did写入参数d_did
     */
    @GetMapping( "/findVisit_recordByDid")
    @ResponseBody
    public Visit_record findVisit_recordByDId(Integer d_did, HttpSession session) {
        Visit_record v= visit_recordService.findVisit_recordByDid(d_did);
        session.setAttribute("v",v);
        return v;
    }
}
