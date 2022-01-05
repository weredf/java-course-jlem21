package b.school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/db3?createDatabaseIfNotExist=true";
	private String user = "root";
	private String password = "1234";

	public void create() {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "create table student(id int primary key auto_increment, school_id int, name varchar(25), email varchar(25), foreign key (school_id) references school(id))";
			Statement stmt = con.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void save(Student student) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "insert into student values(?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student.getId());
			pstmt.setInt(2, student.getSchoolId());
			pstmt.setString(3, student.getName());
			pstmt.setString(4, student.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("save student failed", e);
		}
	}
	
	public Student get(int id) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "select * from student where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Student st = new Student(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
				return st;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException("read student failed", e);
		}
	}
	
	public void update(Student student) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "update student set school_id =?, name = ?, email = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student.getSchoolId());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("update student failed", e);
		}
	}
	
	public void delete(int id) {
		try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
			String sql = "delete from student where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			int rowCount = pstmt.executeUpdate();
			if (rowCount == 0) {
				throw new RuntimeException("delete student " + id + " failed - not found");
			}
		} catch (SQLException e) {
			throw new RuntimeException("delete student failed", e);
		}
	}


}
