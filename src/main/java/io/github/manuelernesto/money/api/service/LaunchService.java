package io.github.manuelernesto.money.api.service;

import io.github.manuelernesto.money.api.model.Launch;
import io.github.manuelernesto.money.api.repository.LaunchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Manuel Ernesto (manuelernest0)
 * @version 1.0
 * @date 06/06/22 1:35 AM
 */
@AllArgsConstructor
@Service
public class LaunchService {
    private final LaunchRepository launchRepository;

    public Launch save(Launch launch) {
        return launchRepository.save(launch);
    }
}
