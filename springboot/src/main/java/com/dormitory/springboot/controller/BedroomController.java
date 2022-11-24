package com.dormitory.springboot.controller;

import com.dormitory.springboot.entity.Bedroom;
import com.dormitory.springboot.service.BedroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/bedroom")
public class BedroomController {
    @Autowired
    private BedroomService bedroomService;


    /**
     * 分页查询
     */
    @RequestMapping(value = "/findBedroom")
    @ResponseBody
    public Map<String, Object> findBedroom(Integer b_bid, Integer pageIndex,
                                           Integer pageSize, Model model) {

        Map<String, Object> res = bedroomService.findPageInfo(b_bid,
                pageIndex,pageSize);
        model.addAttribute("res",res);
        return res;
    }

    /**
     * 导出Excel
     */
    @GetMapping("/exportBedroomlist")
    //等价于@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    //与@Contoller使用表示返回json，不加@ResponBody则返回页面
    public List<Bedroom> exportBedroom(){
        List<Bedroom> bedroomList = bedroomService.getAll();
        return bedroomList;
    }

    /**
     * 添加寝室信息
     */
    @PostMapping("/addBedroom")
    //等价于@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String addBedroom(@RequestBody Bedroom bedroom){
        //@RequestBody接收前端传来的json数据
        int b = bedroomService.addBedroom(bedroom);
        return "bedroom_list";
    }

    /**
     * 删除寝室信息
     */
    @DeleteMapping("/deleteBedroom")
    @ResponseBody
    //等价于@RequestMapping(method = RequestMethod.DELETE)
    public String deleteBedroom(Integer b_bid){
        int b = bedroomService.deleteBedroom(b_bid);
        return "bedroom_list";
    }

    /**
     * 修改寝室信息
     */
    @PutMapping("/updateBedroom")
    @ResponseBody
    //与PostMapping差别不大
    //等价于@RequestMapping(method = RequestMethod.PUT)
    public String updateBedroom(@RequestBody Bedroom bedroom){
        int b = bedroomService.updateBedroom(bedroom);
        return "redirect:/findBedroom";
    }


    /**
     * 根据寝室Id搜索;将请求数据b_bid写入参数b_bid
     */
    @GetMapping( "/findBedroomByBid")
    @ResponseBody
    public Bedroom findBedroomByBid(Integer b_bid, HttpSession session) {
        Bedroom b= bedroomService.findBedroomByBid(b_bid);
        session.setAttribute("b",b);
        return b;
    }
}
