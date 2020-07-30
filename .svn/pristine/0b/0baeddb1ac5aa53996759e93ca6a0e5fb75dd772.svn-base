package com.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@ToString
@Setter
@Getter
@Table(name = "product_type")
public class ProductType extends BaseDO {
    /**
     * 主键id
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 分类名称
     */
    @Column(name = "type_name")
    private String typeName;

    /**
     * 分类logo
     */
    @Column(name = "type_logo")
    private String typeLogo;

    /**
     * 分类状态0:无效，1:有效
     */
    @Column(name = "type_status")
    private Integer typeStatus;

}