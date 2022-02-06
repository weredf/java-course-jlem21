package app.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * spring beans (@Component, @Bean) are managed by spring context (spring container) 
 * JPA Entities (@Entity) are managed by hibernate session context (hibernate container)
 * */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // managed by hibernate
public class Address {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String country;
	private String city;
	private String street;
	@Column(name = "apt_number") // column name in the database
	private int aptNumber;
}
