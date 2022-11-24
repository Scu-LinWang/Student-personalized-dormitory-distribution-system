package com.dormitory.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data//该注解用于设置所有属性的get和set方法
public class Admin {
    private String a_aid;//工号
    private String a_name;//姓名
    private String a_sex;//性别
    private String a_id;//身份证
    private String a_dept;//部门单位信息
    //@JsonProperty(value="a_password", access = JsonProperty.Access.WRITE_ONLY)//展示时忽略密码
    private String a_password;//密码
    private String a_phone;//联系电话
}
