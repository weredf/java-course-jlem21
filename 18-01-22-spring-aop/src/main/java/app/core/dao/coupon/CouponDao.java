package app.core.dao.coupon;

import org.springframework.stereotype.Component;

@Component	// singleton bean
public class CouponDao {

	public void addCoupon() {
		System.out.println("coupon added");
	}
	
	public void doWork() {
		System.out.println("doing work at CouponDao");
	}
}
