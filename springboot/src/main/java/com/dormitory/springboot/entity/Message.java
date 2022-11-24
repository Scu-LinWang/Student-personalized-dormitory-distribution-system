package com.dormitory.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Message {
    private String a_aid;//工号
    private String s_sid;//学号
    private String message;//留言
    private Date m_time;//留言时间
    private Integer receiver;//负数表示给老师，0表示给公屏，正数表示给学生
}
