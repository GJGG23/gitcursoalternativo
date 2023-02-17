package com.cursosalternativos.DTO.Response;

public class responseErrorMsjDto {
	private String error;
	private String msj;
	private String Detalle;
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}

	public String getDetalle() {
		return Detalle;
	}

	public void setDetalle(String detalle) {
		Detalle = detalle;
	}

	public responseErrorMsjDto() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "responseErrordto [error=" + error + ", msj=" + msj + ", Detalle=" + Detalle + "]";
	}
}
