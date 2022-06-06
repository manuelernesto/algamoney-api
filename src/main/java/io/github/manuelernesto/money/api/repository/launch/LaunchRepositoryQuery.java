package io.github.manuelernesto.money.api.repository.launch;

import io.github.manuelernesto.money.api.model.Launch;
import io.github.manuelernesto.money.api.repository.filter.LaunchFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manuel Ernesto (manuelernest0)
 * @version 1.0
 * @date 06/06/22 9:18 PM
 */
public interface LaunchRepositoryQuery {
    List<Launch> filter(LaunchFilter filter);
}
