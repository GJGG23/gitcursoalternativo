package com.cursosalternativos.Tools;

import java.io.File;

public class paramConstantes {

	public static final String NOMBRE_WS = "NOMBRE_WS";
	public static final String VERSION_SERVICE = "VERSION_SERVICE";

	public static final String ARCHIVO_CONFIG = "WSCursosAlternativos.properties";
	public static final String CONFIG = "config";	
	public static final String LOG_HOME_CONFIG_DIR = getPathConfigDir();
	
	public static final String URLBASE = "urldb";
	public static final String USUARIOBASE = "userdb";
	public static final String PASSBASE = "passdb";
		
	public static final String SP_ALTACALIFICACION = "SP_ALTACALIFICACION";
	public static final String SP_ACTUALIZACALIFICACION = "SP_ACTUALIZACALIFICACION";
	public static final String SP_ELIMINACALIFICACION = "SP_ELIMINACALIFICACION";
	public static final String SP_LISTADOCALIFICACIONES = "SP_LISTADOCALIFICACIONES";
	
	
	private static final String getPathConfigDir()
			throws UnsatisfiedLinkError, NullPointerException, SecurityException {
		
		String pathFinal = System.getProperty("jboss.server.base.dir") + File.separator + CONFIG;
	
		return pathFinal;
	}
	
	
}
