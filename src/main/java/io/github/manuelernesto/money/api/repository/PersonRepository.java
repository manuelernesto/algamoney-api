package io.github.manuelernesto.money.api.repository;

import io.github.manuelernesto.money.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
