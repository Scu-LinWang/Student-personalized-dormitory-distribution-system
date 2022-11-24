package com.dormitory.springboot.controller;

import com.dormitory.springboot.entity.Message;
import com.dormitory.springboot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    /**
     *查找消息
     */
    @RequestMapping(value = "/findMessage")
    @ResponseBody
    public Map<String, Object> findMessage(String a_aid, String s_sid, Date m_time, Integer pageIndex,
                                           Integer pageSize, Model model) {

        Map<String, Object> res = messageService.findPageInfo(a_aid, s_sid, m_time, pageIndex, pageSize);
        model.addAttribute("res",res);
        return res;
    }

    /**
     * 导出Excel
     */
    @GetMapping(value = "/exportMessagelist")
    @ResponseBody
    public List<Message> exportMessage(){
        List<Message> message = messageService.getAll();
        return message;
    }

    /**
     * 添加消息信息
     */
    @PostMapping(value = "/addMessage")
    @ResponseBody
    public String addMessage(@RequestBody Message message) {
        int m = messageService.addMessage(message);
        return "message_list";
    }

    /**
     * 删除消息信息
     */
    @DeleteMapping(value = "/deleteMessage")
    @ResponseBody
    public String deleteMessage(String a_aid, String s_sid, Date m_time) {
        int m = messageService.deleteMessage(a_aid, s_sid, m_time);
        return "message_list";
    }

    /**
     * 修改消息信息
     */
    @PutMapping(value = "/updateMessage")
    @ResponseBody
    public String updateMessage(@RequestBody Message message) {
        int m = messageService.updateMessage(message);
        return "message_list";
    }

    /**
     * 查询某个时段消息
     */
    @GetMapping(value = "/findMessageByTime")
    @ResponseBody
    public List<Message> findMessageByTime(String a_aid, String s_sid, Date stime, Date etime, HttpSession session){
        List<Message> ms = messageService.findMessageByTime(a_aid, s_sid, stime, etime);
        session.setAttribute("ms", ms);
        return ms;
    }
}
