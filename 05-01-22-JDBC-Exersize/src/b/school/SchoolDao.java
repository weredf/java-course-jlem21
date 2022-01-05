package b.school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SchoolDao {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/db3?createDatabaseIfNotExist=true";
	private String user = "root";
	private String password = "1234";

	public void create() {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "create table school(id int primary key auto_increment, name varchar(25), address varchar(25))";
			Statement stmt = con.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void save(School school) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "insert into school values(?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, school.getId());
			pstmt.setString(2, school.getName());
			pstmt.setString(3, school.getAddress());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("save school failed", e);
		}
	}
	
	public School get(int id) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "select * from school where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				School s = new School(rs.getInt(1), rs.getString(2), rs.getString(3));
				return s;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException("read school failed", e);
		}
	}
	
	public void update(School school) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "update school set name = ?, address = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, school.getName());
			pstmt.setString(2, school.getAddress());
			pstmt.setInt(3, school.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("update school failed", e);
		}
	}
	
	public void delete(int id) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "delete from school where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			int rowCount = pstmt.executeUpdate();
			if (rowCount == 0) {
				throw new RuntimeException("delete school " + id + " failed - not found");
			}
		} catch (SQLException e) {
			throw new RuntimeException("delete school failed", e);
		}
	}

}
