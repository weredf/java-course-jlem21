package app.core.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"reviews", "customers"})
@Entity
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // eager is heavier on resources than lazy (default)
	@JoinColumn(name = "coupon_id") // the foreign key is generated in review table (always the many point to the one, opposite from database)
	private List<Review> reviews;
	
	// the customers that bought this coupon
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "customer_coupon", joinColumns = @JoinColumn(name = "coupon_id"), inverseJoinColumns = @JoinColumn(name="customer_id"))
	private List<Customer> customers;
	
	public void addCustomer(Customer customer) {
		if(this.customers == null) {
			customers = new ArrayList<>();
		}
		customers.add(customer);
	}
}
