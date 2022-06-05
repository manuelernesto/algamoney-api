package io.github.manuelernesto.money.api.resource;

import io.github.manuelernesto.money.api.event.ResourceCreatedEvent;
import io.github.manuelernesto.money.api.model.Person;
import io.github.manuelernesto.money.api.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/person")
public class PersonResource {

    private final PersonRepository personRepository;
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
        Optional<Person> result = personRepository.findById(id);
        return result.orElseThrow();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOne(@PathVariable Long id) {
        personRepository.deleteById(id);
    }

}
