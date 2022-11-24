package com.dormitory.springboot.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Visit_record {
    private Integer d_did;//访问围合
    private String v_id;//访问者身份证
    private Date v_intime;//访问时间
    private Date v_outtime;//离开时间
    private String v_reason;//访问原因
}
