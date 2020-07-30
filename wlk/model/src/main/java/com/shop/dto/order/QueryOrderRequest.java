package com.shop.dto.order;

import com.shop.dto.PageRequest;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class QueryOrderRequest extends PageRequest{


    private Integer status;

}