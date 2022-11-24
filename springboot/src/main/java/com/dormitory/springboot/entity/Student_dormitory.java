package com.dormitory.springboot.entity;

import lombok.Data;

@Data
public class Student_dormitory {
    private String s_sid;//学号
    private Integer d_did;//围合
    private Integer s_unit;//单元
    private Integer s_house;//大寝
    private char s_bedroom;//小寝
}
