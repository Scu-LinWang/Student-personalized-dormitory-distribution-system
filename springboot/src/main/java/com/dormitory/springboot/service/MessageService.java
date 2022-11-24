package com.dormitory.springboot.service;

import com.dormitory.springboot.entity.Message;
import com.dormitory.springboot.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;
    
    public Map<String, Object> findPageInfo(String a_aid, String s_sid, Date m_time, Integer pageIndex, Integer pageSize) {
        Map<String, Object> res = new HashMap<>();
        //获取总条数
        Integer totalCount = messageMapper.totalCount(a_aid, s_sid, m_time);
        res.put("total", totalCount);
        if (totalCount>0){
            //每一页显示消息信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Message> messageList = messageMapper.getMessageList(a_aid, s_sid, m_time,
                    (pageIndex -1)*pageSize, pageSize);
            res.put("messageList", messageList);
        }
        return res;
    }

    
    public int addMessage(Message message) {
        return messageMapper.addMessage(message);
    }

    
    public int deleteMessage(String a_aid, String s_sid, Date m_time) {
        return messageMapper.deleteMessage(a_aid, s_sid, m_time);
    }

    
    public int updateMessage(Message message) {
        return messageMapper.updateMessage(message);
    }


    
    public List<Message> findMessageByTime(String a_aid, String s_sid, Date stime, Date etime) {
        List<Message> messages = messageMapper.findMessageByTime(a_aid, s_sid, stime, etime);
        return messages;
    }

    
    public List<Message> getAll() {
        List<Message> messagelist = messageMapper.getAll();
        return messagelist;
    }
}
