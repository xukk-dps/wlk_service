package com.shop.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UserAccountVO extends BaseVO{

	private static final long serialVersionUID = 1L;
	private String id;

	/**
	 * 用户领域类型（1：自然人，2：法人）
	 */
	private Integer type;

	/**
	 * 账号
	 */
	private String account;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 用户简称
	 */
	private String userName;

	/**
	 * 用户类型
	 */
	private Integer userType;

	/**
	 * 用户状态1：正常，0:注销
	 */
	private Integer status;

	/**
	 * 接口调用次数上限
	 */
	private Long maxMum;

	private Double price;

	/**
	 * 账单邮箱
	 */
	private String email;

	/**
	 * 是否开启手机号验证，1：开启，0：不开启
	 */
	private Integer verificationPhone;

	/**
	 * 地址
	 */
	private String ipAddress;

	/**
	 * 公司名称
	 */
	private String companyName;

	/**
	 * 每天最大调用限制
	 */
	private Integer dayMaxNum;

	/**
	 * 余额
	 */
	private Double balance;

	/**
	 * 剩余次数
	 */
	private Long surplusCount;
	/**
	 * 资源配置
	 */
	private String resources;

}
