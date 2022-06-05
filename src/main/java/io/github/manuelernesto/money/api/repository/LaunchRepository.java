package io.github.manuelernesto.money.api.repository;

import io.github.manuelernesto.money.api.model.Launch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Manuel Ernesto (manuelernest0)
 * @version 1.0
 * @date 05/06/22 4:12 PM
 */
@Repository
public interface LaunchRepository extends JpaRepository<Launch, Long> {
}
