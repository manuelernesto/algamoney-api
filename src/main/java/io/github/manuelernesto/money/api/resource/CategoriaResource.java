package io.github.manuelernesto.money.api.resource;

import io.github.manuelernesto.money.api.event.RecursoCriadoEvento;
import io.github.manuelernesto.money.api.model.Categoria;
import io.github.manuelernesto.money.api.repository.CategoriaRepository;
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
public class CategoriaResource {

    private final CategoriaRepository categoriaRepository;
    private final ApplicationEventPublisher publisher;

    public CategoriaResource(
            CategoriaRepository categoriaRepository,
            ApplicationEventPublisher publisher
    ) {
        this.categoriaRepository = categoriaRepository;
        this.publisher = publisher;
    }

    @GetMapping
    public List<Categoria> listAll() {
        return categoriaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Categoria> save(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {

        Categoria categoriaSalva = categoriaRepository.save(categoria);

        publisher.publishEvent(
                new RecursoCriadoEvento(this, response, categoriaSalva.getCodigo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }

    @GetMapping("/{codigo}")
    public Categoria findByCode(@PathVariable Long codigo) {
        Optional<Categoria> result = categoriaRepository.findById(codigo);
        return result.orElseThrow();
    }

}
