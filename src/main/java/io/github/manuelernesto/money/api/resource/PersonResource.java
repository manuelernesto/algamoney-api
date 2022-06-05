package io.github.manuelernesto.money.api.resource;

import io.github.manuelernesto.money.api.event.ResourceCreatedEvent;
import io.github.manuelernesto.money.api.model.Address;
import io.github.manuelernesto.money.api.model.Person;
import io.github.manuelernesto.money.api.repository.PersonRepository;
import io.github.manuelernesto.money.api.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/person")
public class PersonResource {

    private final PersonRepository personRepository;
    private final PersonService personService;
    private final ApplicationEventPublisher publisher;


    @GetMapping
    public List<Person> listAll() {
        return personRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person, HttpServletResponse response) {

        Person savedPerson = personRepository.save(person);

        publisher.publishEvent(
                new ResourceCreatedEvent(this, response, savedPerson.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id) {
        return personRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOne(@PathVariable Long id) {
        personRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @Valid @RequestBody Person person) {
        return ResponseEntity.ok(personService.updatePerson(id, person));
    }

    @PutMapping("/{id}/active")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void UpdateStatus(@PathVariable Long id, @RequestBody Boolean active) {
        personService.updateStatus(id, active);
    }

    @PutMapping("/{id}/address")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void UpdateAddress(@PathVariable Long id, @RequestBody Address address) {
        personService.updateAddress(id, address);
    }

}
