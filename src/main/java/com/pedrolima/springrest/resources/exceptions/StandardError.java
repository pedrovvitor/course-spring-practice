package com.pedrolima.springrest.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String msg;
	private String moment;

	public StandardError(Integer status, String msg, String moment) {
		super();
		this.status = status;
		this.msg = msg;
		this.moment = moment;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getInstant() {
		return moment;
	}

	public void setInstant(String moment) {
		this.moment = moment;
	}

}
