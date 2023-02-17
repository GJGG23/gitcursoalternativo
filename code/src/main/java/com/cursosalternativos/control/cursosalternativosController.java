package com.cursosalternativos.control;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cursosalternativos.DTO.Request.requestActualizaMateriaDto;
import com.cursosalternativos.DTO.Request.requestAltaMateriaDto;
import com.cursosalternativos.DTO.Request.requestEliminaMateriaDto;
import com.cursosalternativos.DTO.Request.requestgetcalificacionesDto;
import com.cursosalternativos.DTO.Valida.validaAltaDto;
import com.cursosalternativos.Services.cursosalternativosService;
import com.cursosalternativos.Services.Impl.cursosalternativosImpl;

@Path("/cursos")
public class cursosalternativosController {

	@GET
	@Path("/version")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public String version() {
		String version = "Version 23.0.1";
		return version;
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/altacalificacion")
	public Response altacalificacion(requestAltaMateriaDto request) {
		
		cursosalternativosService bi = new cursosalternativosImpl();

		Response response = bi.altacalificacion(request);

		return response;
	}
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/actualizacalificacion")
	public Response actualizacalificacion(requestActualizaMateriaDto request) {

		cursosalternativosService bi = new cursosalternativosImpl();
		Response response = bi.actualizacalificacion(request);

		return response;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/eliminacalificacion")
	public Response eliminacalificacion(requestEliminaMateriaDto request) {
		cursosalternativosService bi = new cursosalternativosImpl();
		Response response = bi.eliminacalificacion(request);

		return response;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/getcalificaciones")
	public Response getcalificaciones(requestgetcalificacionesDto request) {
		cursosalternativosService bi = new cursosalternativosImpl();
		Response response = bi.getcalificaciones(request);

		return response;
	}
	
}
