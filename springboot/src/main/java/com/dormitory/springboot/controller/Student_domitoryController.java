package com.dormitory.springboot.controller;

import com.dormitory.springboot.entity.Student_dormitory;
import com.dormitory.springboot.service.Student_dormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student_dormitory")
public class Student_domitoryController {
    @Autowired
    private Student_dormitoryService student_dormitoryService;

    /**
     * 分页查询
     */
    @GetMapping(value = "/findStudent_dormitory")
    @ResponseBody
    public Map<String, Object> findStudent_dormitory(String s_sid, Integer pageIndex,
                                               Integer pageSize, Model model) {

        Map<String, Object> res = student_dormitoryService.findPageInfo(s_sid,
                pageIndex,pageSize);
        model.addAttribute("res",res);
        return res;
    }

    /**
     * 导出Excel
     */
    @GetMapping(value = "/exportStudent_dormitorylist")
    @ResponseBody
    public List<Student_dormitory> exportStudent_dormitory(){
        List<Student_dormitory> student_dormitory = student_dormitoryService.getAll();
        return student_dormitory;
    }

    /**
     * 添加学生宿舍信息
     */
    @PostMapping(value = "/addStudent_dormitory")
    @ResponseBody
    public String addStudent_dormitory(@RequestBody Student_dormitory student_dormitory){
        int s = student_dormitoryService.addStudent_dormitory(student_dormitory);
        return "student_dormitory_list";
    }

    /**
     * 删除学生宿舍信息
     */
    @DeleteMapping(value = "/deleteStudent_dormitory")
    @ResponseBody
    public String deleteStudent_dormitory(String s_sid){
        int s = student_dormitoryService.deleteStudent_dormitory(s_sid);
        return "student_dormitory_list";
    }

    /**
     * 修改学生宿舍信息
     */
    @PutMapping(value = "/updateStudent_dormitory")
    @ResponseBody
    public String updateStudent_dormitory(@RequestBody Student_dormitory student_dormitory){
        int s = student_dormitoryService.updateStudent_dormitory(student_dormitory);
        return "redirect:/findStudent_dormitory";
    }
    
}
