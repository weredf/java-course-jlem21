package c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RunSqlStatements {

	public static void main(String[] args) {

		String dbUrl = "jdbc:mysql://localhost:3306/db2";
		String user = "root";
		String password = "1234";
		
		// CRUD Create, Read, Update, Delete
		
		// Create
		String sqlCreate = "insert into person values(301, 'Ami')";
		// Update
		String sqlUpdate = "update person set name = 'NEW' where id  = 250";
		// Delete
		String sqlDelete = "delete from person where id = 260";
		
		// Driver - database implementation
		// Connection - connection to the database
		// Statement - object for executing sql statements Statement. stmt.executeUpdate(..)
		
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			Statement stmt = con.createStatement();
			stmt.execute(sqlCreate);
			System.out.println(sqlCreate);
			
			stmt.execute(sqlUpdate);
			System.out.println(sqlUpdate);
			
			stmt.execute(sqlDelete);
			System.out.println(sqlDelete);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
