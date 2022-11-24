package com.dormitory.springboot.entity;

import lombok.Data;

@Data
public class Dorm {
    private Integer d_did;//围合号
    private String d_college;//围合住宿学院
    private String d_sex;//围合住宿性别
    private Integer d_unitnum;//单元数
    private Integer d_bedroomnum;//小寝数
    private Integer d_bednum;//床位数

}
