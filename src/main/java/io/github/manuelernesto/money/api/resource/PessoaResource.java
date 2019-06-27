package io.github.manuelernesto.money.api.resource;

import io.github.manuelernesto.money.api.event.RecursoCriadoEvento;
import io.github.manuelernesto.money.api.model.Pessoa;
import io.github.manuelernesto.money.api.repository.PessoaRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

    private final PessoaRepository pessoaRepository;
    private final ApplicationEventPublisher publisher;

    public PessoaResource(PessoaRepository pessoaRepository, ApplicationEventPublisher publisher) {
        this.pessoaRepository = pessoaRepository;
        this.publisher = publisher;
    }

    @GetMapping
    public List<Pessoa> listAll() {
        return pessoaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Pessoa> save(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {

        Pessoa pessoaSalva = pessoaRepository.save(pessoa);

        publisher.publishEvent(
                new RecursoCriadoEvento(this, response, pessoaSalva.getCodigo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    @GetMapping("/{codigo}")
    public Pessoa findByCode(@PathVariable Long codigo) {
        Optional<Pessoa> result = pessoaRepository.findById(codigo);
        return result.orElseThrow();
    }

}
