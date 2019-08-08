package com.dhandapani.hibernate.models;

import java.util.List;

public class ApiResponse {
	private boolean status;
	private Object responseData;
	private List<Object> responseDataList;
	private String responseMessage;
	private boolean isException;

	public ApiResponse() {
		super();
	}

	public ApiResponse(boolean status, Object responseData, List<Object> responseDataList, String responseMessage,
			boolean isException) {
		super();
		this.status = status;
		this.responseData = responseData;
		this.responseDataList = responseDataList;
		this.responseMessage = responseMessage;
		this.isException = isException;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Object getResponseData() {
		return responseData;
	}

	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}

	public List<Object> getResponseDataList() {
		return responseDataList;
	}

	public void setResponseDataList(List<Object> responseDataList) {
		this.responseDataList = responseDataList;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public boolean isException() {
		return isException;
	}

	public void setException(boolean isException) {
		this.isException = isException;
	}

}
