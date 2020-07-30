package com.shop;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName: PageRequest
 * @description: 分页插件
 * @author: kangkang.xu
 * @date: Created in 13:49 2019/4/16
 * @Version: 1.0
 **/
@Getter
@Setter
public class PageRequest {

    private static Integer defaultPageNo   = 1;

    private static Integer defaultPageSize = 10;

    private Integer        pageNo;

    private Integer        pageSize;

    /**
     * 获取分页页码
     * 
     * @return Integer
     */
    public Integer getPageNo() {
        if (pageNo == null || pageNo < 1) {
            return defaultPageNo;
        }

        return pageNo;

    }

    /**
     * 获取每页显示条数
     * 
     * @return Integer
     */
    public Integer getPageSize() {
        if (null == pageSize || pageSize < 1) {
            return defaultPageSize;
        }
        if (pageSize > 1000) {
            return defaultPageSize;
        }
        return pageSize;
    }

    @Override
    public String toString() {
        return "Page{" + "pageNo=" + pageNo + ", pageSize=" + pageSize + '}';
    }
}
