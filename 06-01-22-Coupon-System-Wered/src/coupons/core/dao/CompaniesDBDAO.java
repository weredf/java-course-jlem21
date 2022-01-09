package coupons.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import coupons.core.beans.Company;
import coupons.core.exceptions.CouponSystemException;

public class CompaniesDBDAO implements CompaniesDAO {
	@Override
	public boolean isCompanyExists(String email, String password) throws CouponSystemException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		String sql = "select * from companies where email = ? and password = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			throw new CouponSystemException("isCompanyExists failed", e);
		} finally {
			cp.restoreConnection(c);
		}
	}
	@Override
	public int addCompany(Company company) throws CouponSystemException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		String sql = "insert into companies values(0, ?, ?, ?)";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setString(1, company.getName());
			pstmt.setString(2, company.getEmail());
			pstmt.setString(3, company.getPassword());
			pstmt.executeUpdate();
			ResultSet rsId = pstmt.getGeneratedKeys();
			rsId.next();
			int id = rsId.getInt(1);
			company.setId(id);
			return id;
		} catch (SQLException e) {
			throw new CouponSystemException("addCompany failed", e);
		} finally {
			cp.restoreConnection(c);
		}
	}

	@Override
	public void updateCompany(Company company) throws CouponSystemException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		String sql = "update companies set name = ?, email = ? , password = ? where id = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setString(1, company.getName());
			pstmt.setString(2, company.getEmail());
			pstmt.setString(3, company.getPassword());
			pstmt.setInt(4, company.getId());
			int rowCount = pstmt.executeUpdate();
			if (rowCount == 0) {
				throw new CouponSystemException("updateCompany " + company.getId() + "failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("updateCompany failed", e);
		} finally {
			cp.restoreConnection(c);
		}
	}

	@Override
	public void deleteCompany(int companyId) throws CouponSystemException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		String sql = "delete from companies where id = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, companyId);
			int rowCount = pstmt.executeUpdate();
			if (rowCount == 0) {
				throw new CouponSystemException("deleteCompany " + companyId + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("deleteCompany failed", e);
		} finally {
			cp.restoreConnection(c);
		}
	}

	@Override
	public ArrayList<Company> getAllCompanies() throws CouponSystemException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		String sql = "select * from companies";
		try (PreparedStatement pstmt = c.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Company> companies = new ArrayList<>();
			while (rs.next()) {
				Company com = new Company(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				companies.add(com);
			}
			return companies;
		} catch (Exception e) {
			throw new CouponSystemException("getAllCompanies failed", e);
		} finally {
			cp.restoreConnection(c);
		}
	}

	@Override
	public Company getOneCompany(int companyId) throws CouponSystemException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		String sql = "select * from companies where id = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, companyId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Company com = new Company(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				return com;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new CouponSystemException("getOneCompany failed", e);
		} finally {
			cp.restoreConnection(c);
		}
	}

}
