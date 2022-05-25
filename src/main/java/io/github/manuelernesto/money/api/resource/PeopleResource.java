package io.github.manuelernesto.money.api.resource;

import io.github.manuelernesto.money.api.event.RecursoCriadoEvento;
import io.github.manuelernesto.money.api.model.People;
import io.github.manuelernesto.money.api.repository.PeopleRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/people")
public class PeopleResource {

    private final PeopleRepository peopleRepository;
    private final ApplicationEventPublisher publisher;

    public PeopleResource(PeopleRepository peopleRepository, ApplicationEventPublisher publisher) {
        this.peopleRepository = peopleRepository;
        this.publisher = publisher;
    }

    @GetMapping
    public List<People> listAll() {
        return peopleRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<People> save(@Valid @RequestBody People people, HttpServletResponse response) {

        People savedPeople = peopleRepository.save(people);

        publisher.publishEvent(
                new RecursoCriadoEvento(this, response, savedPeople.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(savedPeople);
    }

    @GetMapping("/{id}")
    public People findById(@PathVariable Long id) {
        Optional<People> result = peopleRepository.findById(id);
        return result.orElseThrow();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOne(@PathVariable Long id) {
        peopleRepository.deleteById(id);
    }

}