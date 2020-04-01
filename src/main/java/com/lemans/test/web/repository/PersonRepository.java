package com.lemans.test.web.repository;

import com.lemans.test.web.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
