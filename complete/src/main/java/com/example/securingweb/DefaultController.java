package com.example.securingweb;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.securingweb.Access.HasInternalAccess;
import com.example.securingweb.model.Person;

@Controller
public class DefaultController {

	@GetMapping(value = "/person/_get")
	public ResponseEntity<Person> get() {		
		return ResponseEntity.ok(createPerson(2L, "John"));
	}
	
	@HasInternalAccess
	@GetMapping(value = "/person/list/_get")
	public ResponseEntity<List<Person>> getList() {
		List<Person> persons = new ArrayList<>();
		persons.add(createPerson(2L, "John"));
		persons.add(createPerson(3L, "Jenny"));
		return ResponseEntity.ok(persons);
	}
	
	private Person createPerson(Long id, String firstName) {
		return new Person.Builder(id).withFullName(firstName, "Doe")
				.withDateOfBirth(LocalDate.of(1925, Month.APRIL, 14)).build();

	}
}
