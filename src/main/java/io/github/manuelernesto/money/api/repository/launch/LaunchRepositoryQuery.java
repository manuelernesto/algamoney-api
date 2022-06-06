package io.github.manuelernesto.money.api.repository.launch;

import io.github.manuelernesto.money.api.model.Launch;
import io.github.manuelernesto.money.api.repository.filter.LaunchFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Manuel Ernesto (manuelernest0)
 * @version 1.0
 * @date 06/06/22 9:18 PM
 */
public interface LaunchRepositoryQuery {
    Page<Launch> filter(LaunchFilter filter, Pageable pageable);
}
