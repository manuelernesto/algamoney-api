package io.github.manuelernesto.money.api.resource;

import io.github.manuelernesto.money.api.event.ResourceCreatedEvent;
import io.github.manuelernesto.money.api.model.Launch;
import io.github.manuelernesto.money.api.repository.LaunchRepository;
import io.github.manuelernesto.money.api.repository.filter.LaunchFilter;
import io.github.manuelernesto.money.api.service.LaunchService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author Manuel Ernesto (manuelernest0)
 * @version 1.0
 * @date 05/06/22 4:16 PM
 */
@RestController
@RequestMapping("/api/v1/launches")
public record LaunchResource(LaunchRepository launchRepository, LaunchService launchService,
                             ApplicationEventPublisher publisher) {

    @GetMapping
    public Page<Launch> search(LaunchFilter launchFiltered, Pageable pageable) {
        return launchRepository.filter(launchFiltered, pageable);
    }

    @PostMapping
    public ResponseEntity<Launch> save(@Valid @RequestBody Launch launch, HttpServletResponse response) {

        Launch launchSaved = launchService.save(launch);

        publisher.publishEvent(new ResourceCreatedEvent(this, response, launchSaved.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(launchSaved);
    }

    @GetMapping("/{id}")
    public Launch getById(@PathVariable Long id) {
        return launchService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLaunch(@PathVariable Long id) {
        launchService.delete(id);
    }
}
