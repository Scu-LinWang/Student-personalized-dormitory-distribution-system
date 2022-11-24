package com.dormitory.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Student {
    private String s_sid;//学号
    private String s_name;//姓名
    private String s_sex;//性别
    private String s_id;//身份证
    private Integer s_age;//年龄
    private String s_phone;//电话
    //@JsonIgnore//展示时忽略密码
    private String s_password;//密码

    private Integer d;
    private Integer i;
    private Integer s;
    private Integer c;
    private Integer sleep_time;
    private Integer get_time;
    private Integer hobby;
    private Integer activity;
}
