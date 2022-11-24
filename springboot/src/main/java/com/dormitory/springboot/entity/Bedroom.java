package com.dormitory.springboot.entity;

import lombok.Data;

import java.util.List;

@Data
public class Bedroom {
    private Integer b_bid;//小寝识别号用于宿舍分配
    private Integer b_unit;//所属单元
    private Integer b_house;//所属大寝
    private char b_bedroom;//小寝号
    private boolean b_bed;//床位
}
