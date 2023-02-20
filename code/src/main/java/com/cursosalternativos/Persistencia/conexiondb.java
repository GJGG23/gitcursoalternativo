package com.cursosalternativos.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

import com.cursosalternativos.Tools.paramConstantes;
import com.cursosalternativos.Tools.propertiesTools;

public class conexiondb {

	Connection conn = null;
	propertiesTools tools = new propertiesTools();

	public Connection conectar() {
		try {
			
			Class.forName("org.postgresql.Driver");
			String urldb = tools.propertyValue(paramConstantes.URLBASE);
			String userdb = tools.propertyValue(paramConstantes.USUARIOBASE); 
			String passdb = tools.propertyValue(paramConstantes.PASSBASE);
		
			conn = DriverManager.getConnection(urldb, userdb, passdb);
			System.out.println("Conexion a la base correctamente");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		return conn;
	}
}
