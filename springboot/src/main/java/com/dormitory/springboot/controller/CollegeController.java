package com.dormitory.springboot.controller;

import com.dormitory.springboot.entity.College;
import com.dormitory.springboot.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    /**
     *查找学院
     */
    @GetMapping(value = "/findCollege")
    @ResponseBody
    public Map<String, Object> findCollege(String college_name, String college_major, Integer pageIndex,
                                           Integer pageSize, Model model) {

        Map<String, Object> res = collegeService.findPageInfo(college_name,college_major, pageIndex, pageSize);
        model.addAttribute("res",res);
        return res;
    }

    /**
     * 导出Excel
     */
    @GetMapping(value = "/exportCollegelist")
    @ResponseBody
    public List<College> exportCollege(){
        List<College> college = collegeService.getAll();
        return college;
    }

    /**
     * 添加学院信息
     */
    @PostMapping(value = "/addCollege")
    @ResponseBody
    public String addCollege( @RequestBody College college) {
        int c = collegeService.addCollege(college);
        return "college_list";
    }

    /**
     * 删除学院信息
     */
    @DeleteMapping(value = "/deleteCollege")
    @ResponseBody
    public String deleteCollege(String college_name, String college_major) {
        int c = collegeService.deleteCollege(college_name, college_major);
        return "college_list";
    }

    /**
     * 修改学院信息
     */
    @PutMapping(value = "/updateCollege")
    @ResponseBody
    public String updateCollege(@RequestBody College college) {
        int c = collegeService.updateCollege(college);
        return "redirect:/findCollege";
    }

}
