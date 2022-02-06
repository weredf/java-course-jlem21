package app.core.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/*
 * spring beans (@Component, @Bean) are managed by spring context (spring container) 
 * JPA Entities (@Entity) are managed by hibernate session context (hibernate container)
 * */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "address")
@Entity
public class Company {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	// cascade: saving/deleting Company will save/delete CompanyAddress as well
	@OneToOne(cascade = CascadeType.ALL) // unidirectional
	@JoinColumn(name = "address_id") // foreign key column in company table, owner of relationship
	private Address address;
}
