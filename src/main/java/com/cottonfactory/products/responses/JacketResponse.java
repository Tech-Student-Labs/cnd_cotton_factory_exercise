package com.cottonfactory.products.responses;

public class JacketResponse extends BaseResponse {
	
	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public JacketResponse() {
		super();
	}
	
	public JacketResponse(Object data) {
		super();
		this.data = data;
	}

}
