package com.cursosalternativos.Services;

import javax.ws.rs.core.Response;

import com.cursosalternativos.DTO.Request.requestActualizaMateriaDto;
import com.cursosalternativos.DTO.Request.requestAltaMateriaDto;
import com.cursosalternativos.DTO.Request.requestEliminaMateriaDto;
import com.cursosalternativos.DTO.Request.requestgetcalificacionesDto;

public interface cursosalternativosService {

	String getVersion();
	
	Response  altacalificacion(requestAltaMateriaDto request);
	
	Response  actualizacalificacion(requestActualizaMateriaDto request);
	
	Response  eliminacalificacion(requestEliminaMateriaDto request); 
	
	Response getcalificaciones(requestgetcalificacionesDto request);
	
}
