package io.github.manuelernesto.money.api.resource;

import io.github.manuelernesto.money.api.event.ResourceCreatedEvent;
import io.github.manuelernesto.money.api.model.Category;
import io.github.manuelernesto.money.api.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/categories")
public record CategoryResource(CategoryRepository categoryRepository, ApplicationEventPublisher publisher) {

    @GetMapping
    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Category> save(@Valid @RequestBody Category category, HttpServletResponse response) {

        Category savedCategory = categoryRepository.save(category);

        publisher.publishEvent(new ResourceCreatedEvent(this, response, savedCategory.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @GetMapping("/{id}")
    public Category findByCode(@PathVariable Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

}
