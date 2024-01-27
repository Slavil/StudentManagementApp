package net.javaguides.sms.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	public Student() {

	}

	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Set<StudentsClass> getClasses() {
		return classes;
	}

	//public void setClasses(Set<StudentsClass> classes) {
	//	this.classes = classes;
	//}

	@ManyToMany
	@JoinTable(
			name = "student_classes",
			joinColumns = @JoinColumn(name = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "class_id")
	)
	private Set<StudentsClass> classes = new HashSet<>();

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
