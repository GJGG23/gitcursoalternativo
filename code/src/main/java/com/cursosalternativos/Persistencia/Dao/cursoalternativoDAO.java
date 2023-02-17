package com.cursosalternativos.Persistencia.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.cursosalternativos.DTO.Request.requestActualizaMateriaDto;
import com.cursosalternativos.DTO.Request.requestAltaMateriaDto;
import com.cursosalternativos.DTO.Request.requestEliminaMateriaDto;
import com.cursosalternativos.DTO.Request.requestgetcalificacionesDto;
import com.cursosalternativos.DTO.Response.detallecalificacionesDto;
import com.cursosalternativos.DTO.Response.responseErrorMsjDto;
import com.cursosalternativos.DTO.Response.responseListCalifacacionesDto;
import com.cursosalternativos.DTO.Response.responseMsjDto;
import com.cursosalternativos.Persistencia.conexiondb;


public class cursoalternativoDAO {

	public Object altacalificacionDAO(requestAltaMateriaDto request) {

		responseMsjDto resp = new responseMsjDto();
		conexiondb db = new conexiondb();
		String query = null;

		PreparedStatement cstmt = null;

		try {
			Connection conn = db.conectar();
			query = "CALL public.addcalificacion(?,?,?)";
			cstmt = conn.prepareCall(query);
			boolean reg;
			((CallableStatement) cstmt).setInt(1, request.getIdmateria());
			((CallableStatement) cstmt).setInt(2, request.getIdalumno());
			((CallableStatement) cstmt).setFloat(3, request.getCalificacion());
			reg = cstmt.execute();

			resp.setSuccess("OK");
			resp.setMsg("calificacion registrada");
			conn.close();
			return resp;

		} catch (Exception e) {
			System.out.println("error al dar de alta la calificacion: " + e);
			responseErrorMsjDto msjerror = new responseErrorMsjDto();
			msjerror.setError("error en db");
			msjerror.setMsj("error al dar de alta la calificacion.");
			msjerror.setDetalle(e.getMessage());
			return msjerror;
		}
	}

	public Object actualizacalificacionDAO(requestActualizaMateriaDto request) {

		responseMsjDto resp = new responseMsjDto();
		conexiondb db = new conexiondb();
		String query = null;

		PreparedStatement cstmt = null;

		try {
			Connection conn = db.conectar();
			query = "CALL public.actualizacalificacion(?,?,?)";
			cstmt = conn.prepareCall(query);
			int reg;
			((CallableStatement) cstmt).setInt(1, request.getIdmateria());
			((CallableStatement) cstmt).setInt(2, request.getIdalumno());
			((CallableStatement) cstmt).setFloat(3, request.getCalificacion());
			reg = cstmt.executeUpdate();

			resp.setSuccess("OK");
			resp.setMsg("calificacion actualizada");
			conn.close();
			return resp;

		} catch (Exception e) {
			System.out.println("error al actualizar la calificacion: " + e);
			responseErrorMsjDto msjerror = new responseErrorMsjDto();
			msjerror.setError("error en db");
			msjerror.setMsj("error al actualizar la calificacion");
			msjerror.setDetalle(e.getMessage());
			return msjerror;
		}
	}
	
	public Object eliminarcalificacionDAO(requestEliminaMateriaDto request) {

		responseMsjDto resp = new responseMsjDto();
		conexiondb db = new conexiondb();
		String query = null;

		PreparedStatement cstmt = null;

		try {
			Connection conn = db.conectar();
			query = "CALL public.eliminacalificacion(?,?)";
			cstmt = conn.prepareCall(query);
			boolean reg;
			((CallableStatement) cstmt).setInt(1, request.getIdmateria());
			((CallableStatement) cstmt).setInt(2, request.getIdalumno());
			reg = cstmt.execute();

			resp.setSuccess("OK");
			resp.setMsg("calificacion eliminada");
			conn.close();
			return resp;

		} catch (Exception e) {
			System.out.println("error al eliminar la calificacion: " + e);
			responseErrorMsjDto msjerror = new responseErrorMsjDto();
			msjerror.setError("error en db");
			msjerror.setMsj("error al eliminar la calificacion");
			msjerror.setDetalle(e.getMessage());
			return msjerror;
		}
	}
	
	public Object listacalificacionDAO(requestgetcalificacionesDto request){
		responseListCalifacacionesDto resp = new responseListCalifacacionesDto();
		conexiondb db = new conexiondb();
		String query = null;
		PreparedStatement cstmt = null;
		ResultSet rs;
		
		try {
			Connection conn = db.conectar();
			conn.setAutoCommit(false);
			query = "CALL public.readcalificaciones(?,?)";
			cstmt = conn.prepareCall(query);
			((CallableStatement) cstmt).setInt(1, request.getIdusuario());
			((CallableStatement) cstmt).registerOutParameter(2, Types.REF_CURSOR);
			cstmt.execute();
			rs = (ResultSet) ((CallableStatement) cstmt).getObject(2);
			if (rs != null) {
				List<detallecalificacionesDto> lrc = new ArrayList<detallecalificacionesDto>();
				int nummat = 0;
				float sumacal = 0;
			    while (rs.next()) {
			    	detallecalificacionesDto objdc = new detallecalificacionesDto();
			    	objdc.setId_t_usuario(rs.getInt(1));
			    	objdc.setNombre(rs.getString(2));
			    	objdc.setApellido(rs.getString(3));
			    	objdc.setMateria(rs.getString(4));
			    	objdc.setCalificacion(rs.getFloat(5));
			    	sumacal = sumacal + rs.getFloat(5);
			    	objdc.setFecha_registro(rs.getString(6));
			    	lrc.add(objdc);
			    	nummat++;
			   }
			    resp.setListacalificaciones(lrc);
			    resp.setPromedio(sumacal / nummat);
			}
			return resp;
		} catch (Exception e) {
			System.out.println("error al consular las calificaciones en la db: " + e);
			responseErrorMsjDto msjerror = new responseErrorMsjDto();
			msjerror.setError("error en db");
			msjerror.setMsj("error al consular las calificaciones en la db");
			msjerror.setDetalle(e.getMessage());
			return msjerror;
		}		
		
	}

}
