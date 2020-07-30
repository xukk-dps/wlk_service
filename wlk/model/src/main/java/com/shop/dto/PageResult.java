package com.shop.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gary
 * @date 2019-04-15 19:30
 */
@Getter
@Setter
public class PageResult<T> {

    private Integer pageNum;

    private Integer pageSize;

    private Long total;

    private List<T> list = new ArrayList<>();
}
