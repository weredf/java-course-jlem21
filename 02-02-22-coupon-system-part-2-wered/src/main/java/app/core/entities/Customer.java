package app.core.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	@Column(unique = true)
	private String email;
	@NonNull
	private String password;
	@ManyToMany(cascade =  { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "customer_vs_coupon", joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name = "coupon_id"))
	private List<Coupon> coupons;
	
	public void addCoupon(Coupon coupon) {
		if (this.coupons == null) {
			this.coupons = new ArrayList<>();
		}
		this.coupons.add(coupon);
	}
	
}
