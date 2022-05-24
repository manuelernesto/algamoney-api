package io.github.manuelernesto.money.api.resource;

import io.github.manuelernesto.money.api.event.RecursoCriadoEvento;
import io.github.manuelernesto.money.api.model.Category;
import io.github.manuelernesto.money.api.repository.CategoryRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoryResource {

    private final CategoryRepository categoryRepository;
    private final ApplicationEventPublisher publisher;

    public CategoryResource(
            CategoryRepository categoryRepository,
            ApplicationEventPublisher publisher
    ) {
        this.categoryRepository = categoryRepository;
        this.publisher = publisher;
    }

    @GetMapping
    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Category> save(@Valid @RequestBody Category category, HttpServletResponse response) {

        Category savedCategory = categoryRepository.save(category);

        publisher.publishEvent(
                new RecursoCriadoEvento(this, response, savedCategory.getCodigo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @GetMapping("/{id}")
    public Category findByCode(@PathVariable Long id) {
        Optional<Category> result = categoryRepository.findById(id);
        return result.orElseThrow();
    }

}
