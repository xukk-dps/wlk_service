package com.shop.dto.auth;

import com.shop.annonation.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class PhoneRequest {

    /**
     * encryptedData
     */
    @NotBlank(message = "encryptedData", maxLen = 500)
    private String encryptedData;

    /**
     * iv
     */
    @NotBlank(message = "iv", maxLen = 50)
    private String iv;

    /**
     * session_key
     */
    @NotBlank(message = "session_key", maxLen = 500)
    private String session_key;

    private Integer source;


}