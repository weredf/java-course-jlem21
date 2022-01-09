package coupons.core.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import coupons.core.beans.Category;
//import coupons.core.beans.Company;
import coupons.core.beans.Coupon;
//import coupons.core.beans.Customer;
import coupons.core.exceptions.CouponSystemException;

public class CouponsDBDAO implements CouponsDAO{
	
	private ConnectionPool connectionPool;

	@Override
	public int addCoupon(Coupon coupon) throws CouponSystemException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		String sql = "insert into coupons values(0, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, coupon.getCompany());
			pstmt.setString(2, coupon.getCategory().toString());
			pstmt.setString(3, coupon.getTitle());
			pstmt.setString(4, coupon.getDescription());
			pstmt.setDate(5, Date.valueOf(coupon.getStartDate()));
			pstmt.setDate(6, Date.valueOf(coupon.getEndDate()));
			pstmt.setInt(7, coupon.getAmount());
			pstmt.setDouble(8, coupon.getPrice());
			pstmt.setString(9, coupon.getImage());
			pstmt.executeUpdate();
			ResultSet rsId = pstmt.getGeneratedKeys();
			rsId.next();
			int id = rsId.getInt(1);
			coupon.setId(id);
			return id;
		} catch (SQLException e) {
			throw new CouponSystemException("add coupon failed", e);
		} finally {
			cp.restoreConnection(c);
		}
		
	}

	@Override
	public void updateCoupon(Coupon coupon) throws CouponSystemException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		String sql = "update coupons set company_id = ?, category = ?, title = ? , description = ?, start_date = ?, end_date = ?, amount = ?, price = ?, image = ? where id = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, coupon.getCompany());
			pstmt.setString(2, coupon.getCategory().toString());
			pstmt.setString(3, coupon.getTitle());
			pstmt.setString(4, coupon.getDescription());
			pstmt.setDate(5, Date.valueOf(coupon.getStartDate()));
			pstmt.setDate(6, Date.valueOf(coupon.getEndDate()));
			pstmt.setInt(7, coupon.getAmount());
			pstmt.setDouble(8, coupon.getPrice());
			pstmt.setString(9, coupon.getImage());
			pstmt.setInt(10, coupon.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new CouponSystemException("update coupon failed", e);
		} finally {
			cp.restoreConnection(c);
		}
	}

	@Override
	public void deleteCoupon(int couponId) throws CouponSystemException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		String sql = "delete from coupons where id = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, couponId);
			int rowCount = pstmt.executeUpdate();
			if (rowCount == 0) {
				throw new CouponSystemException("delete coupon " + couponId + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("delete coupon failed", e);
		} finally {
			cp.restoreConnection(c);
		}
	}

	@Override
	public ArrayList<Coupon> getAllCoupons() throws CouponSystemException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		String sql = "select * from coupons";
		try (PreparedStatement pstmt = c.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Coupon> coupons = new ArrayList<>();
			while (rs.next()) {
				Coupon coup = new Coupon(rs.getInt(1), rs.getInt(2), Category.valueOf(rs.getString(3)), rs.getString(4), rs.getString(5), rs.getDate(6).toLocalDate(), rs.getDate(7).toLocalDate(), rs.getInt(8), rs.getFloat(9), rs.getString(10));
				coupons.add(coup);
			}
			return coupons;
		} catch (Exception e) {
			throw new CouponSystemException("get all coupons failed", e);
		} finally {
			cp.restoreConnection(c);
		}
	}

	@Override
	public Coupon getOneCoupon(int couponId) throws CouponSystemException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
		String sql = "select * from coupons where id = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, couponId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Coupon coup = new Coupon(rs.getInt(1), rs.getInt(2), Category.valueOf(rs.getString(3)), rs.getString(4), rs.getString(5), rs.getDate(6).toLocalDate(), rs.getDate(7).toLocalDate(), rs.getInt(8), rs.getFloat(9), rs.getString(10));
				return coup;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new CouponSystemException("get coupon failed", e);
		} finally {
			cp.restoreConnection(c);
		}
	}

	@Override
	public void addCouponPurchase(int customerId, int couponId) throws CouponSystemException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
//		Coupon coup = getOneCoupon(couponId);
//		CustomersDBDAO dbdao = new CustomersDBDAO();
//		Customer cus = dbdao.getOneCustomer(customerId);
		String sql = "insert into customers_vs_coupons values(?, ?)";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, customerId);
			pstmt.setInt(2, couponId);
			pstmt.executeUpdate();
			ResultSet rsId = pstmt.getGeneratedKeys();
			rsId.next();
			int coupid = rsId.getInt(1);
			int cusid = rsId.getInt(2);
//			coupon.setId(id);
//			return id;
		} catch (SQLException e) {
			throw new CouponSystemException("add coupon failed", e);
		} finally {
			cp.restoreConnection(c);
		}
	}

	@Override
	public void deleteCouponPurchase(int customerId, int couponId) throws CouponSystemException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection c = cp.getConnection();
//		Coupon coup = getOneCoupon(couponId);
//		CustomersDBDAO dbdao = new CustomersDBDAO();
//		Customer cus = dbdao.getOneCustomer(customerId);
		String sql = "delete from customers_vs_coupons where customer_id = ?, coupon_id = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, customerId);
			pstmt.setInt(2, couponId);
			int rowCount = pstmt.executeUpdate();
			if (rowCount == 0) {
				throw new CouponSystemException("delete coupon " + couponId + "for customer " + customerId + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("delete coupon failed", e);
		} finally {
			cp.restoreConnection(c);
		}
	}

	
}
