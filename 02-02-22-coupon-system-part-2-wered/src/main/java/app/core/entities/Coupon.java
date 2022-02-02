package app.core.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
@ToString(exclude = "customers")//(exclude = "customer")
@Entity
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@ManyToOne
//	@JoinColumn(name = "company_id")
//	private int companyId;
	@ManyToOne(cascade =  { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "company_id")
	@NonNull
	private Company company;
	@NonNull
	private Category category;
	@NonNull
	private String title;
	@NonNull
	private String description;
	@NonNull
	private LocalDate startDate;
	@NonNull
	private LocalDate endDate;
	private int amount;
	private double price;
	@NonNull
	private String image;
//	@ManyToOne
//	@JoinColumn(name = "customer_id")
//	private Customer customer;
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "customer_vs_coupon", joinColumns = @JoinColumn(name = "coupon_id"), inverseJoinColumns = @JoinColumn(name = "customer_id"))
	private List<Customer> customers;
	
	public void addCustomer(Customer customer) {
		if (customers == null) {
			customers = new ArrayList<>();
		}
		customers.add(customer);
	}

	public Coupon(int i, Company c, app.core.entities.Category food, String string, String string2, LocalDate of,
			LocalDate of2, int j, double d, String string3, Object object) {
		// TODO Auto-generated constructor stub
	}
}
