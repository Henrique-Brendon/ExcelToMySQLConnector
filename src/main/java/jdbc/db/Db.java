package jdbc.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;

public class Db {

	private static Connection connection;
	
	private static Properties carregarPropriedades() {
		try(FileInputStream file = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(file);
			return props;
		}catch(IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static Connection getConnection() {
		if(connection == null) {
			try {
				Properties props = carregarPropriedades();
				String url = props.getProperty("dburl");
				String nome = props.getProperty("user");
				String senha = props.getProperty("password");
				connection = DriverManager.getConnection(url, nome, senha);
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return connection;
	}
	
	public static void closeConnection() {
		if(connection != null) {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			}catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResulSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
