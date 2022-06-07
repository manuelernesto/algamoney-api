package io.github.manuelernesto.money.api.service;

import io.github.manuelernesto.money.api.model.Address;
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
public record PersonService(PersonRepository personRepository) {

    public Person updatePerson(Long id, Person person) {
        Person personToUpdate = findPersonByID(id);
        BeanUtils.copyProperties(person, personToUpdate, "id");
        return personRepository.save(personToUpdate);
    }


    public void updateStatus(Long id, Boolean active) {
        Person personToUpdate = findPersonByID(id);
        personToUpdate.setActive(active);
        personRepository.save(personToUpdate);
    }

    public void updateAddress(Long id, Address address) {
        Person personToUpdate = findPersonByID(id);
        personToUpdate.setAddress(address);
        personRepository.save(personToUpdate);
    }

    private Person findPersonByID(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }
}
