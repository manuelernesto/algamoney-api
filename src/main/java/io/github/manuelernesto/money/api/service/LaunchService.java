package io.github.manuelernesto.money.api.service;

import io.github.manuelernesto.money.api.model.Launch;
import io.github.manuelernesto.money.api.repository.CategoryRepository;
import io.github.manuelernesto.money.api.repository.LaunchRepository;
import io.github.manuelernesto.money.api.repository.PersonRepository;
import io.github.manuelernesto.money.api.service.exception.PersonNotFoundOrInactiveException;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
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
    private final PersonRepository personRepository;

    public Launch save(Launch launch) {
        var person = personRepository.findById(launch.getPerson().getId()).orElseThrow(PersonNotFoundOrInactiveException::new);
        if (!person.getActive())
            throw new PersonNotFoundOrInactiveException();

        return launchRepository.save(launch);
    }

    public void delete(Long id) {
        launchRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        launchRepository.deleteById(id);
    }

    public Launch findById(Long id) {
        return launchRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }
}
