package io.github.manuelernesto.money.api.resource;

import io.github.manuelernesto.money.api.model.Launch;
import io.github.manuelernesto.money.api.repository.LaunchRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Manuel Ernesto (manuelernest0)
 * @version 1.0
 * @date 05/06/22 4:16 PM
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/launches")
public class LaunchResource {

    private final LaunchRepository launchRepository;

    @GetMapping
    public List<Launch> getAll() {
        return launchRepository.findAll();
    }

    @GetMapping("/{id}")
    public Launch getById(@PathVariable Long id) {
        return launchRepository.findById(id).orElseThrow();
    }
}
