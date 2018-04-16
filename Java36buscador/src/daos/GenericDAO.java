package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//solo para herredar, no se puede usar

public abstract class GenericDAO {

	protected Connection miConnection = null;

	// carga del drive de conexion con jdbc
	static {
		// bloque especial que se ejecuta una unica vez
		// a lo largo de la aplicacion la primera
		// vez que esta clase es usada

		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("no encuentro el driver-libreria de mysql");

		}

	}// end static

	protected void conectar() {
		try {
			miConnection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd_productos_categorias", "root",
					"jeveris");
		} catch (SQLException e) {
			System.out.println("no pude conectarme a la base de datos");
			System.out.println("comprobar ruta de la base de datos");
			System.out.println("comprobar nombre de usuario y contraseña");
		}

	}// end conectar

	protected void desconectar() {

		try {
			miConnection.close();
		} catch (SQLException e) {
			System.out.println("no pude realizar la desconexion");
		}

	}// end desconectar
}// end class
