package com.example.securingweb.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {

	private Long id;

	private String name;

	private LocalDate dateOfBirth;

	private Person() {
	}

	@Getter
	@Setter
	public static class Builder {

		private Long id;

		private String name;

		private LocalDate dateOfBirth;

		public Builder(Long id) {
			this.id = id;
		}

		public Builder withFullName(String firstName, String lastName) {
			this.name = firstName + " " + lastName;
			return this;
		}

		public Builder withDateOfBirth(LocalDate dob) {
			this.dateOfBirth = dob;
			return this;
		}

		public Person build() {
			Person person = new Person();
			person.setId(this.id);
			person.setName(this.name);
			person.setDateOfBirth(this.dateOfBirth);
			return person;
		}
	}

}
