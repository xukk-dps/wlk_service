package com.shop.dto;

import com.shop.annonation.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UserAccountRequest extends BaseDTO{


	/** 账号 **/
	@NotBlank(message = "account is null or more length",maxLen = 50)
	private String account;
	/** 密码 **/
	@NotBlank(message = "password is null or more length",maxLen = 50)
	private String password;
	/** 主体名称 **/
	@NotBlank(message = "ztmc is null or more length",maxLen = 50)
	private String ztmc;
	/** 统一代码 **/
	@NotBlank(message = "tydm is null or more length",maxLen = 50)
	private String tydm;
	/** ip地址 **/
	private String ipAddress;

	public UserAccountRequest() {
	}

	public UserAccountRequest(String account, String password, String ipAddress) {
		this.account = account;
		this.password = password;
		this.ipAddress = ipAddress;
	}
}
