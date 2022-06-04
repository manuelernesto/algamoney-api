package io.github.manuelernesto.money.api.repository;

import io.github.manuelernesto.money.api.model.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Long> {
}
