package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilsDB {
	
	private static Connection connection; //Si ponemos estática este atributo, todos los objetos creados a partir de esta clase compartiran este atributo.
	
	
	
	//==========================================================================================================================
	//Vamos a crear los métodos estáticos para poder llamarlos directamente con su clase, sin necesidad de crear un objeto.	
	//==========================================================================================================================
	
	
	
	//Creamos un método para abrir conexión con nuestras credenciales propias que a su vez va a llamar al metodo que lo sobrecarga donde además se 
	//comprueba que no exista una conexión previa.
	public static Connection getInstance() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/bibliotecas?serverTimezone=Europe/Madrid";
		String username = "root";
		String password = "password";
		connection = getInstance(url, username, password);
		return connection;
	}
	
	
	
	public static Connection getInstanceOracle() throws SQLException{
		String urlConDatos = "jdbc:oracle:thin:cuso/password@localhost:1521:XE";
		String url2 = "jdbc:oracle:thin@localhost:1521:XE";
		String username = "curso";
		String password = "password";
		connection = getInstance(url2, username, password);
		return connection;
	}
	
	
	
	// Sobrecargamos el metodo que usamos para conectarnos con nuestras credenciales con otro método que declaramos con 3 parámetros, url, user y pass
	// Este método sera llamado cuando queramos conectarnos a otra base de datos que tenga otras credenciales diferentes a las nuestras.
	public static Connection getInstance(String url, String username, String password) throws SQLException{
		
		if(connection==null) {
			connection = DriverManager.getConnection(url, username, password);
		}
		
		return connection;
	}

	//Creamos un método para cerrar la conexión. aunque si declaramos un try catch with resources no haría falta cerrarlo.
	public static void getOffInstance() throws SQLException{
		
		if(connection!=null) {
			connection.close();
			connection=null;
		}
	}
}
