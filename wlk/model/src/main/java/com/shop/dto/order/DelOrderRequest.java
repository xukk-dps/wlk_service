package com.shop.dto.order;

import com.shop.annonation.NotBlank;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class DelOrderRequest {


    private List<Long> id;

    @NotBlank(message = "用户id", maxLen = 11)
    private Long userId;

    public DelOrderRequest setId(List<Long> id) {
        this.id = id;
        return this;
    }

    public DelOrderRequest setUserId(Long userId) {
        this.userId = userId;
        return this;
    }
}