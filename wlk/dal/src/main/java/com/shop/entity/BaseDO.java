package com.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import java.util.Date;

@ToString
@Setter
@Getter
public class BaseDO {
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

}
