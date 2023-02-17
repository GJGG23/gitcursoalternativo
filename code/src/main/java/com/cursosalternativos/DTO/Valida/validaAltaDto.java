package com.cursosalternativos.DTO.Valida;

import com.cursosalternativos.DTO.Request.requestAltaMateriaDto;
import com.cursosalternativos.DTO.Response.responseErrorMsjDto;

public class validaAltaDto {

	public responseErrorMsjDto validaalta(requestAltaMateriaDto request) {
		responseErrorMsjDto msjerror = new responseErrorMsjDto();
		
		if(request.equals(null)) {			
			msjerror.setError("error");
			msjerror.setMsj("la peticion debe de tener un request valido");
			msjerror.setDetalle("la peticion debe de tener el id de la materia, el id del usuario y su calificacion");
			return msjerror;
		}
		
		if(request.getIdalumno() < 1) {
			msjerror.setError("error");
			msjerror.setMsj("el parametro idalumno no puedo ir vacio");
			msjerror.setDetalle("la peticion debe de tener idalumno valido para poder proseguir con el alta");
			return msjerror;
		}
		
		if(request.getIdmateria() < 1) {
			msjerror.setError("error");
			msjerror.setMsj("el parametro idmateria no puedo ir vacio");
			msjerror.setDetalle("la peticion debe de tener idmateria valido para poder proseguir con el alta");
			return msjerror;
		}
		
		if(request.getCalificacion() < 1) {
			msjerror.setError("error");
			msjerror.setMsj("el parametro calificacion no puedo ir vacio");
			msjerror.setDetalle("la peticion debe de tener una calificacion valida para poder proseguir con el alta");
			return msjerror;
		}
		
		
		return null;
		
		
	}
}
