package io.github.manuelernesto.money.api.repository;

import io.github.manuelernesto.money.api.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
