package io.github.manuelernesto.money.api.service;

import io.github.manuelernesto.money.api.model.Person;
import io.github.manuelernesto.money.api.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 * @author Manuel Ernesto (manuelernest0)
 * @version 1.0
 * @date 05/06/22 1:10 PM
 */
@Service
@AllArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public Person updatePerson(Long id, Person person) {
        var personToUpdate = personRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        BeanUtils.copyProperties(person, personToUpdate, "id");
        return personRepository.save(personToUpdate);
    }
}
