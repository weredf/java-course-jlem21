package app.core.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity//(name = "Student") // this is not a component but an entity - managed by JPA EntityManager
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String email;
	@Enumerated(EnumType.STRING)
	@Column(name = "the_gender")
	private Gender gender; // in database gets ordinal number of enum (int)
	private LocalDate enrolled;
	private boolean active;

	public enum Gender {
		M, F;
	}
}
