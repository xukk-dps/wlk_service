package com.shop.dto.product;

import com.shop.annonation.NotBlank;
import com.shop.dto.PageRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AddressRequest extends PageRequest {


    @NotBlank(message = "id",maxLen = 11)
    private Integer id;

    /**
     * 用户id
     */
    @NotBlank(message = "useId",maxLen = 11)
    private Long userId;
    /**
     * 订单id （更换地址的时候如果顺便把订单中的地址也更换掉）
     */
    private Long orderId;


}