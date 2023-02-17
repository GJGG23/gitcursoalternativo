package com.cursosalternativos.DTO.Response;

import java.util.List;

public class responseListCalifacacionesDto {
	
	private List<detallecalificacionesDto> listacalificaciones;
	private float promedio;
	
	public List<detallecalificacionesDto> getListacalificaciones() {
		return listacalificaciones;
	}
	
	public void setListacalificaciones(List<detallecalificacionesDto> listacalificaciones) {
		this.listacalificaciones = listacalificaciones;
	}
	
	public float getPromedio() {
		return promedio;
	}
	
	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}
	
	
}

