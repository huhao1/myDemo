package com.example.common.response;

import java.io.Serializable;

/**
 * @ClassName ResponseVo
 * @Description 返回Vo类
 * @Author hao
 * @Date 2019/3/27 10:52
 **/
public class ResponseVo<T> implements Serializable{
	
	private static final long serialVersionUID = 7213095123438097838L;

	private Integer code;

	private String msg;

	private T data;

	private String action;

	public Integer getCode() {
		return code;
	}

	public ResponseVo setCode(Integer code) {
		this.code = code;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public ResponseVo setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public T getData() {
		return data;
	}

	public ResponseVo setData(T data) {
		this.data = data;
		return this;
	}

	public String getAction() {
		return action;
	}

	public ResponseVo setAction(String action) {
		this.action = action;
		return this;
	}

	public static ResponseVo getInstance(){
		return new ResponseVo();
	}
}
