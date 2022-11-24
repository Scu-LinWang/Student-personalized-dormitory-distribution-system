package com.dormitory.springboot.controller;

import com.dormitory.springboot.entity.Admin;
import com.dormitory.springboot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 用户登录
     */
    /**
     * 将提交数据(a_aid,a_password)写入Admin对象
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(@RequestBody Admin admin, Model model, HttpSession session, HttpServletRequest request) {
        // 通过账号和密码查询用户
        Admin ad = adminService.findAdmin(admin);
        if(ad!=null){
            session.setAttribute("ad", ad);
            return "homepage";
        }
        model.addAttribute("msg", "用户名或密码错误，请重新登录！");
        return "login";
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "/loginOut")
    public String loginOut(@RequestBody  Admin admin, Model model, HttpSession session) {
        session.invalidate();
        return "login";
    }

    /**
     * 分页查询
     */
    @RequestMapping(value = "/findAdmin")
    @ResponseBody
    public Map<String, Object> findAdmin(String a_aid, String a_name,Integer pageIndex,
                            Integer pageSize, Model model) {

        Map<String, Object> res = adminService.findPageInfo(a_aid, a_name,
                pageIndex,pageSize);
        model.addAttribute("res",res);
        return res;
    }

    /**
     * 导出Excel
     */
    @GetMapping("/exportAdminlist")
    //等价于@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    //与@Contoller使用表示返回json，不加@ResponBody则返回页面
    public List<Admin> exportAdmin(){
        List<Admin> adminList = adminService.getAll();
        return adminList;
    }

    /**
     * 添加管理员信息
     */
    @PostMapping("/addAdmin")
    //等价于@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String addAdmin(@RequestBody Admin admin){
        //@RequestBody接收前端传来的json数据
        int a = adminService.addAdmin(admin);
        return "admin_list";
    }

    /**
     * 删除管理员信息
     */
    @DeleteMapping("/deleteAdmin")
    @ResponseBody
    //等价于@RequestMapping(method = RequestMethod.DELETE)
    public String deleteAdmin(String a_aid){
        int a = adminService.deleteAdmin(a_aid);
        return "admin_list";
    }

    /**
     * 修改管理员信息
     */
    @PutMapping("/updateAdmin")
    @ResponseBody
    //与PostMapping差别不大
    //等价于@RequestMapping(method = RequestMethod.PUT)
    public String updateAdmin(@RequestBody Admin admin){
        int a = adminService.updateAdmin(admin);
        return "redirect:/findAdmin";
    }


    /**
     * 根据管理员Aid搜索;将请求数据a_aid写入参数a_aid
     */
    @GetMapping( "/findAdminByAid")
    @ResponseBody
    public Admin findAdminByAid(String a_aid, HttpSession session) {
        Admin a= adminService.findAdminByAid(a_aid);
        session.setAttribute("a",a);
        return a;
    }
}
