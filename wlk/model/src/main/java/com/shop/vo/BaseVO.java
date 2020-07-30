package com.shop.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
@Setter
public class BaseVO {
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     * */
    private Date updateTime;
}
