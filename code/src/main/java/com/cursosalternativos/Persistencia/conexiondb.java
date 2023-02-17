package com.cursosalternativos.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class conexiondb {

	Connection conn = null;
	String url = "jdbc:postgresql://localhost:5432/DBCursosA";
	String usuario = "postgres";
	String clave = "root1234";

	public Connection conectar() {
		try {
			
			Class.forName("org.postgresql.Driver");
		
			conn = DriverManager.getConnection(url, usuario, clave);
			System.out.println("Conexion a la base correctamente");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		return conn;
	}
}
