package com.cursosalternativos.DTO.Request;

public class requestActualizaMateriaDto {
	private int idalumno;
	private int idmateria;
	private float calificacion;

	public int getIdalumno() {
		return idalumno;
	}

	public void setIdalumno(int idalumno) {
		this.idalumno = idalumno;
	}

	public int getIdmateria() {
		return idmateria;
	}

	public void setIdmateria(int idmateria) {
		this.idmateria = idmateria;
	}

	public float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}

	public requestActualizaMateriaDto() {
		// TODO Auto-generated constructor stub
	}
}
