package com.dormitory.springboot.controller;

import com.dormitory.springboot.entity.Student_major;
import com.dormitory.springboot.service.Student_majorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("student_major")
public class Student_majorController {
    @Autowired
    private Student_majorService student_majorService;

    /**
     * 分页查询
     */
    @GetMapping(value = "/findStudent_major")
    @ResponseBody
    public Map<String, Object> findStudent_major(String s_sid, Integer pageIndex,
                                                     Integer pageSize, Model model) {

        Map<String, Object> res = student_majorService.findPageInfo(s_sid,
                pageIndex,pageSize);
        model.addAttribute("res",res);
        return res;
    }

    /**
     * 导出Excel
     */
    @GetMapping(value = "/exportStudent_majorlist")
    @ResponseBody
    public List<Student_major> exportStudent_major(){
        List<Student_major> student_major = student_majorService.getAll();
        return student_major;
    }

    /**
     * 添加学生专业信息
     */
    @PostMapping(value = "/addStudent_major")
    @ResponseBody
    public String addStudent_major(@RequestBody Student_major student_major){
        int s = student_majorService.addStudent_major(student_major);
        return "student_major_list";
    }

    /**
     * 删除学生专业信息
     */
    @DeleteMapping(value = "/deleteStudent_major")
    @ResponseBody
    public String deleteStudent_major(String s_sid){
        int s = student_majorService.deleteStudent_major(s_sid);
        return "student_major_list";
    }

    /**
     * 修改学生专业信息
     */
    @PutMapping(value = "/updateStudent_major")
    @ResponseBody
    public String updateStudent_major(@RequestBody Student_major student_major){
        int s = student_majorService.updateStudent_major(student_major);
        return "redirect:/findStudent_major";
    }

}
