package coupons.core.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import coupons.core.beans.Category;
import coupons.core.beans.Coupon;
import coupons.core.exceptions.CouponSystemException;

public class CouponsDBDAO implements CouponsDAO {

	private ConnectionPool connectionPool;

	@Override
	public boolean isCouponExists(int companyId, String title) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "select * from coupons where company_id = ?, title = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, companyId);
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			throw new CouponSystemException("isCouponExists failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

	@Override
	public boolean isCouponExists(int id) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "select * from coupons where id = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			throw new CouponSystemException("isCouponExists failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

	@Override
	public boolean isCouponPurchaseExists(int couponId) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "select * from customers_vs_coupons where coupon_id = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, couponId);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			throw new CouponSystemException("isCouponPurchaseExists failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

	@Override
	public boolean isCouponPurchaseExists(int customerId, int couponId) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "select * from customers_vs_coupons where customer_id =? and coupon_id = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, customerId);
			pstmt.setInt(2, couponId);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			throw new CouponSystemException("isCouponPurchaseExists failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

	@Override
	public int addCoupon(Coupon coupon) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
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
			throw new CouponSystemException("addCoupon failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}

	}

	@Override
	public void updateCoupon(Coupon coupon) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
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
			throw new CouponSystemException("updateCoupon failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

	@Override
	public void deleteCoupon(int couponId) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "delete from coupons where id = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, couponId);
			int rowCount = pstmt.executeUpdate();
			if (rowCount == 0) {
				throw new CouponSystemException("deleteCoupon " + couponId + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("deleteCoupon failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

	@Override
	public ArrayList<Coupon> getAllCoupons() throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "select * from coupons";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Coupon> coupons = new ArrayList<>();
			while (rs.next()) {
				Coupon coup = new Coupon(rs.getInt(1), rs.getInt(2), Category.valueOf(rs.getString(3)), rs.getString(4),
						rs.getString(5), rs.getDate(6).toLocalDate(), rs.getDate(7).toLocalDate(), rs.getInt(8),
						rs.getFloat(9), rs.getString(10));
				coupons.add(coup);
			}
			return coupons;
		} catch (Exception e) {
			throw new CouponSystemException("getAllCoupons failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

	@Override
	public ArrayList<Coupon> getAllCouponsForCompany(int companyId) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "select * from coupons where company_id = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, companyId);
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Coupon> coupons = new ArrayList<>();
			while (rs.next()) {
				Coupon coup = new Coupon(rs.getInt(1), rs.getInt(2), Category.valueOf(rs.getString(3)), rs.getString(4),
						rs.getString(5), rs.getDate(6).toLocalDate(), rs.getDate(7).toLocalDate(), rs.getInt(8),
						rs.getFloat(9), rs.getString(10));
				coupons.add(coup);
			}
			return coupons;
		} catch (Exception e) {
			throw new CouponSystemException("getAllCouponsForCompany failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

	@Override
	public ArrayList<Coupon> getAllCouponsInCategoryForCompany(int companyId, Category category)
			throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "select * from coupons where company_id = ? and category = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, companyId);
			pstmt.setString(2, category.toString());
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Coupon> coupons = new ArrayList<>();
			while (rs.next()) {
				Coupon coup = new Coupon(rs.getInt(1), rs.getInt(2), Category.valueOf(rs.getString(3)), rs.getString(4),
						rs.getString(5), rs.getDate(6).toLocalDate(), rs.getDate(7).toLocalDate(), rs.getInt(8),
						rs.getFloat(9), rs.getString(10));
				coupons.add(coup);
			}
			return coupons;
		} catch (Exception e) {
			throw new CouponSystemException("getAllCouponsInCategoryForCompany failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

	@Override
	public ArrayList<Coupon> getAllCouponsForCompanyMax(int companyId, double maxPrice) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "select * from coupons where company_id = ? and price < ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, companyId);
			pstmt.setDouble(2, maxPrice);
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Coupon> coupons = new ArrayList<>();
			while (rs.next()) {
				Coupon coup = new Coupon(rs.getInt(1), rs.getInt(2), Category.valueOf(rs.getString(3)), rs.getString(4),
						rs.getString(5), rs.getDate(6).toLocalDate(), rs.getDate(7).toLocalDate(), rs.getInt(8),
						rs.getFloat(9), rs.getString(10));
				coupons.add(coup);
			}
			return coupons;
		} catch (Exception e) {
			throw new CouponSystemException("getAllCouponsForCompanyMax failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

	@Override
	public ArrayList<Coupon> getAllCouponsForCustomer(int customerId) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "select * from coupons where coupon_id in (select id from customers_vs_coupons values where customer_id = ?)";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Coupon> coupons = new ArrayList<>();
			while (rs.next()) {
				Coupon coup = new Coupon(rs.getInt(1), rs.getInt(2), Category.valueOf(rs.getString(3)), rs.getString(4),
						rs.getString(5), rs.getDate(6).toLocalDate(), rs.getDate(7).toLocalDate(), rs.getInt(8),
						rs.getFloat(9), rs.getString(10));
				coupons.add(coup);
			}
			return coupons;
		} catch (Exception e) {
			throw new CouponSystemException("getAllCouponsForCustomer failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

	@Override
	public ArrayList<Coupon> getAllCouponsInCategoryForCustomer(int customerId, Category category)
			throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "select * from coupons where coupon_id in (select id from customers_vs_coupons values where customer_id = ?) and category = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, customerId);
			pstmt.setString(2, category.toString());
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Coupon> coupons = new ArrayList<>();
			while (rs.next()) {
				Coupon coup = new Coupon(rs.getInt(1), rs.getInt(2), Category.valueOf(rs.getString(3)), rs.getString(4),
						rs.getString(5), rs.getDate(6).toLocalDate(), rs.getDate(7).toLocalDate(), rs.getInt(8),
						rs.getFloat(9), rs.getString(10));
				coupons.add(coup);
			}
			return coupons;
		} catch (Exception e) {
			throw new CouponSystemException("getAllCouponsInCategoryForCustomer failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

	@Override
	public ArrayList<Coupon> getAllCouponsForCustomerMax(int customerId, double maxPrice) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "select * from coupons where coupon_id in (select id from customers_vs_coupons values where customer_id = ?) and price < ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, customerId);
			pstmt.setDouble(2, maxPrice);
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Coupon> coupons = new ArrayList<>();
			while (rs.next()) {
				Coupon coup = new Coupon(rs.getInt(1), rs.getInt(2), Category.valueOf(rs.getString(3)), rs.getString(4),
						rs.getString(5), rs.getDate(6).toLocalDate(), rs.getDate(7).toLocalDate(), rs.getInt(8),
						rs.getFloat(9), rs.getString(10));
				coupons.add(coup);
			}
			return coupons;
		} catch (Exception e) {
			throw new CouponSystemException("getAllCouponsForCustomerMax failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

	@Override
	public Coupon getOneCoupon(int couponId) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "select * from coupons where id = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, couponId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Coupon coup = new Coupon(rs.getInt(1), rs.getInt(2), Category.valueOf(rs.getString(3)), rs.getString(4),
						rs.getString(5), rs.getDate(6).toLocalDate(), rs.getDate(7).toLocalDate(), rs.getInt(8),
						rs.getFloat(9), rs.getString(10));
				return coup;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new CouponSystemException("getOneCoupon failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

	@Override
	public void addCouponPurchase(int customerId, int couponId) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "insert into customers_vs_coupons values(?, ?)";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, customerId);
			pstmt.setInt(2, couponId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new CouponSystemException("addCouponPurchase failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

	@Override
	public void deleteCouponPurchase(int customerId, int couponId) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "delete from customers_vs_coupons where customer_id = ?, coupon_id = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, customerId);
			pstmt.setInt(2, couponId);
			int rowCount = pstmt.executeUpdate();
			if (rowCount == 0) {
				throw new CouponSystemException(
						"deleteCouponPurchase " + couponId + "for customer " + customerId + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("deleteCouponPurchase failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

	@Override
	public void deleteCouponPurchase(int couponId) throws CouponSystemException {
		Connection c = connectionPool.getConnection();
		String sql = "delete from customers_vs_coupons where coupon_id = ?";
		try (PreparedStatement pstmt = c.prepareStatement(sql)) {
			pstmt.setInt(1, couponId);
			int rowCount = pstmt.executeUpdate();
			if (rowCount == 0) {
				throw new CouponSystemException("deleteCouponPurchase " + couponId + " failed - not found");
			}
		} catch (SQLException e) {
			throw new CouponSystemException("deleteCouponPurchase failed", e);
		} finally {
			connectionPool.restoreConnection(c);
		}
	}

}
