package io.github.manuelernesto.money.api.repository;

import io.github.manuelernesto.money.api.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
