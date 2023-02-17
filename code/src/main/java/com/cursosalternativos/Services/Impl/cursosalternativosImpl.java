package com.cursosalternativos.Services.Impl;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.cursosalternativos.DTO.Request.requestActualizaMateriaDto;
import com.cursosalternativos.DTO.Request.requestAltaMateriaDto;
import com.cursosalternativos.DTO.Request.requestEliminaMateriaDto;
import com.cursosalternativos.DTO.Request.requestgetcalificacionesDto;
import com.cursosalternativos.DTO.Response.responseErrorMsjDto;
import com.cursosalternativos.DTO.Response.responseListCalifacacionesDto;
import com.cursosalternativos.DTO.Response.responseMsjDto;
import com.cursosalternativos.DTO.Valida.validaActualizaDto;
import com.cursosalternativos.DTO.Valida.validaAltaDto;
import com.cursosalternativos.Persistencia.Dao.cursoalternativoDAO;
import com.cursosalternativos.Services.cursosalternativosService;
import com.sun.jersey.core.spi.factory.ResponseBuilderImpl;

public class cursosalternativosImpl implements cursosalternativosService {

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response altacalificacion(requestAltaMateriaDto request) {
		cursoalternativoDAO dao = new cursoalternativoDAO();
		validaAltaDto valida = new validaAltaDto();
		responseErrorMsjDto reserror = new responseErrorMsjDto();
		ResponseBuilder response = new ResponseBuilderImpl();
		Object obj = null;
		
		reserror = valida.validaalta(request);
		
		if(reserror != null) {
			response.status(Response.Status.CONFLICT);
			response.entity(reserror);
			return response.build();
		}else {
			obj = dao.altacalificacionDAO(request);

	    	if (obj instanceof responseMsjDto) {
				response.status(Response.Status.OK);
				response.entity(obj);
			} else {
				response.status(Response.Status.CONFLICT);
				response.entity(obj);
			}  
	    	return response.build();
		}
				
	}

	@Override
	public Response actualizacalificacion(requestActualizaMateriaDto request) {
		cursoalternativoDAO dao = new cursoalternativoDAO();
		ResponseBuilder response = new ResponseBuilderImpl();
		validaActualizaDto valida = new validaActualizaDto();
		Object obj = null;
		
		responseErrorMsjDto reserror = new responseErrorMsjDto();
		reserror = valida.validaactualizacion(request);
		
		if(reserror != null) {
			response.status(Response.Status.CONFLICT);
			response.entity(reserror);
			return response.build();
		}else {
			obj = dao.actualizacalificacionDAO(request);

	    	if (obj instanceof responseMsjDto) {
				response.status(Response.Status.OK);
				response.entity(obj);
			} else {
				response.status(Response.Status.CONFLICT);
				response.entity(obj);
			}  
			
			return response.build();
		}
		
		
	}

	@Override
	public Response eliminacalificacion(requestEliminaMateriaDto request) {
		cursoalternativoDAO dao = new cursoalternativoDAO();
		ResponseBuilder response = new ResponseBuilderImpl();
		Object obj = null;
		obj = dao.eliminarcalificacionDAO(request);

    	if (obj instanceof responseMsjDto) {
			response.status(Response.Status.OK);
			response.entity(obj);
		} else {
			response.status(Response.Status.CONFLICT);
			response.entity(obj);
		}  
		
		return response.build();
	}
	
	@Override
	public Response getcalificaciones(requestgetcalificacionesDto request) {
		cursoalternativoDAO dao = new cursoalternativoDAO();
		ResponseBuilder response = new ResponseBuilderImpl();
		Object obj = null;
		obj = dao.listacalificacionDAO(request);

    	if (obj instanceof responseListCalifacacionesDto) {
			response.status(Response.Status.OK);
			response.entity(obj);
		} else {
			response.status(Response.Status.CONFLICT);
			response.entity(obj);
		}  
		
		return response.build();
	}

}
