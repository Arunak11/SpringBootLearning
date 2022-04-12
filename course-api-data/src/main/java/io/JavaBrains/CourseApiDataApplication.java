package io.JavaBrains;

import io.JavaBrains.model.Person;
import io.JavaBrains.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class CourseApiDataApplication {
	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(CourseApiDataApplication.class, args);
		PersonRepository personRepository = configurableApplicationContext.getBean(PersonRepository.class);
		Person myPerson = new Person("Arun", "Kumar");
		personRepository.save(myPerson);

	}
}

