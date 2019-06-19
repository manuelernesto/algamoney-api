package io.github.manuelernesto.money.api.resource;

import io.github.manuelernesto.money.api.model.Categoria;
import io.github.manuelernesto.money.api.repository.CategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    private final CategoriaRepository categoriaRepository;

    public CategoriaResource(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
    public List<Categoria> listAll() {
        return categoriaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria, HttpServletResponse response) {

        Categoria categoriaSalva = categoriaRepository.save(categoria);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(categoriaSalva.getCodigo()).toUri();

        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(categoriaSalva);
    }

    @GetMapping("/{codigo}")
    public Categoria findByCode(@PathVariable Long codigo) {
        Optional<Categoria> result = categoriaRepository.findById(codigo);
        return result.orElse(null);
    }

//    @GetMapping
//    public ResponseEntity<?> listar() {
//        List<Categoria> categorias = categoriaRepository.findAll();
//        return !categorias.isEmpty() ? ResponseEntity.ok(categorias) : ResponseEntity.noContent().build();
//    }
}
