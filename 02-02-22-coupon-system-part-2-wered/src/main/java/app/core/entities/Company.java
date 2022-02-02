package app.core.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = "coupons")
@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	@Column(unique = true)
	private String name;
	@NonNull
	@Column(unique = true)
	private String email;
	@NonNull
	private String password;
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	private List<Coupon> coupons = new ArrayList<>();

	public void addCoupon(Coupon coupon) {
		if (this.coupons == null) {
			this.coupons = new ArrayList<>();
		}
		coupon.setCompany(this);
		this.coupons.add(coupon);
	}
}
