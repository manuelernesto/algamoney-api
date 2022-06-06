package io.github.manuelernesto.money.api.resource;

import io.github.manuelernesto.money.api.event.ResourceCreatedEvent;
import io.github.manuelernesto.money.api.model.Category;
import io.github.manuelernesto.money.api.model.Launch;
import io.github.manuelernesto.money.api.repository.LaunchRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
    private final ApplicationEventPublisher publisher;

    @PostMapping
    public ResponseEntity<Launch> save(@Valid @RequestBody Launch launch, HttpServletResponse response) {

        Launch launchSaved = launchRepository.save(launch);

        publisher.publishEvent(new ResourceCreatedEvent(this, response, launchSaved.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(launchSaved);
    }

    @GetMapping
    public List<Launch> getAll() {
        return launchRepository.findAll();
    }

    @GetMapping("/{id}")
    public Launch getById(@PathVariable Long id) {
        return launchRepository.findById(id).orElseThrow();
    }
}
