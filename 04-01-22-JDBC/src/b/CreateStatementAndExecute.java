package b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStatementAndExecute {

	public static void main(String[] args) {

		String dbUrl = "jdbc:mysql://localhost:3306/db2?createDatabaseIfNotExist=true";
		String user = "root";
		String password = "1234";
		// define an sql as String
		String sql1 = "create table person(id int primary key auto_increment, name varchar(25))";
		/*
		// execute the sql
		stmt.execute(sql);
		 */
		String sql2 = "insert into person values(0, 'aaa')";
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)){
			// use the connection to get a Statement object
			Statement stmt = con.createStatement();
			// execute the sql
			stmt.execute(sql1);
			// execute the sql - insert
			for (int i = 0; i < 10; i++) {
				stmt.executeUpdate(sql2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
