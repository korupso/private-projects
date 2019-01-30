package ch.meccariello.M226.b.organigram;

import java.time.LocalDate;

public class Person {
	
	private String firstName;
	private String lastName;
	private LocalDate birthdate;
	
	public Person(String firstName, String lastName, String birthdate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = LocalDate.parse(birthdate);
	}

	public void talk() {
		System.out.println("Bla bla bla..");
	}

	public String toString() {
		return "[firstName: " + firstName + ", lastName: " + lastName + ", birthdate: " + birthdate.toString() + "]";
	}
	
	// Getters and setters
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

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	
}
