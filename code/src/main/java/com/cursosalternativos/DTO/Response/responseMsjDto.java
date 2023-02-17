package com.cursosalternativos.DTO.Response;

public class responseMsjDto {
	private String success;	
	private String msg;
	
	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public responseMsjDto() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "responsemsjdto [success=" + success + ", msg=" + msg + "]";
	}
}
