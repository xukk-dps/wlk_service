package com.shop.dto.car;

import com.shop.annonation.NotBlank;
import com.shop.dto.BaseDTO;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@ToString
@Getter
public class DelCarRequest {


    private List<Long> proIds;

//    @NotBlank(message = "用户id为空或长度超出限制",maxLen = 11)
    private Long userId;

    public DelCarRequest setId(List<Long> proIds) {
        this.proIds = proIds;
        return this;
    }

    public DelCarRequest setUserId(Long userId) {
        this.userId = userId;
        return this;
    }
}