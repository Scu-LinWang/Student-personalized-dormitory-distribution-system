package com.dormitory.springboot.controller;

import com.dormitory.springboot.entity.Student;
import com.dormitory.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 用户登录
     */
    /**
     * 将提交数据(s_sid,s_password)写入Student对象
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(@RequestBody Student student, Model model, HttpSession session, HttpServletRequest request) {
        // 通过账号和密码查询用户
        Student ad = studentService.findStudent(student);
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
    public String loginOut(@RequestBody  Student student, Model model, HttpSession session) {
        session.invalidate();
        return "login";
    }

    /**
     * 分页查询
     */
    @RequestMapping(value = "/findStudent")
    @ResponseBody
    public Map<String, Object> findStudent(String s_sid, String s_name, Integer pageIndex,
                                         Integer pageSize, Model model) {

        Map<String, Object> res = studentService.findPageInfo(s_sid, s_name,
                pageIndex,pageSize);
        model.addAttribute("res",res);
        return res;
    }

    /**
     * 导出Excel
     */
    @GetMapping("/exportStudentlist")
    //等价于@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    //与@Contoller使用表示返回json，不加@ResponBody则返回页面
    public List<Student> exportStudent(){
        List<Student> studentList = studentService.getAll();
        return studentList;
    }

    /**
     * 添加学生信息
     */
    @PostMapping("/addStudent")
    //等价于@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String addStudent(@RequestBody Student student){
        //@RequestBody接收前端传来的json数据
        int s = studentService.addStudent(student);
        return "student_list";
    }

    /**
     * 删除学生信息
     */
    @DeleteMapping("/deleteStudent")
    @ResponseBody
    //等价于@RequestMapping(method = RequestMethod.DELETE)
    public String deleteStudent(String s_sid){
        int s = studentService.deleteStudent(s_sid);
        return "student_list";
    }

    /**
     * 修改学生信息
     */
    @PutMapping("/updateStudent")
    @ResponseBody
    //与PostMapping差别不大
    //等价于@RequestMapping(method = RequestMethod.PUT)
    public String updateStudent(@RequestBody Student student){
        int s = studentService.updateStudent(student);
        return "redirect:/findStudent";
    }


    /**
     * 根据学生Sid搜索;将请求数据s_sid写入参数s_sid
     */
    @GetMapping( "/findStudentBySid")
    @ResponseBody
    public Student findStudentBySid(String s_sid, HttpSession session) {
        Student s = studentService.findStudentBySid(s_sid);
        session.setAttribute("s",s);
        return s;
    }
}
