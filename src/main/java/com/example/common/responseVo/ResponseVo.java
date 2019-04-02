package com.example.common.responseVo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ResponseVo implements Serializable{
	
	private static final long serialVersionUID = 7213095123438097838L;

	private int code;
	
	private String msg;
	
	private Long count;
	
	private Object data;

	private String action;

	public int getCode() {
		return code;
	}

	public ResponseVo setCode(int code) {
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

	public Long getCount() {
		return count;
	}

	public ResponseVo setCount(Long count) {
		this.count = count;
		return this;
	}

	public Object getData() {
		return data;
	}

	public ResponseVo setData(Object data) {
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

	@Override
	public String toString() {
		return "ResponseBo{" +
				"code=" + code +
				", msg='" + msg + '\'' +
				", count=" + count +
				", data=" + data +
				", action='" + action + '\'' +
				'}';
	}
}
