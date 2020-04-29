package ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static {
		try {
			System.out.println("Procurando o driver...");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver encontrado com sucesso!");
		} catch (ClassNotFoundException ex) {
			System.err.println("O driver nao foi encontrado");
		}
	}
	
	
	public static Connection conectar() {
		try {
			return DriverManager
					.getConnection("jdbc:mysql://localhost/noticiario_danilherme?useTimezone=true&serverTimezone=UTC&useSSL=false", 
							"root", "guilherme1904");
		} catch (SQLException ex) {
			System.err.println("Nao foi possivel se conectar ao driver!");
			ex.printStackTrace();
			return null;
		}
		
	}
	
		
}
