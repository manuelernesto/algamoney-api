package io.github.manuelernesto.money.api.event.listener;

import io.github.manuelernesto.money.api.event.ResourceCreatedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class ResourceCreatedListener implements ApplicationListener<ResourceCreatedEvent> {

    @Override
    public void onApplicationEvent(ResourceCreatedEvent resource) {
        HttpServletResponse response = resource.getResponse();
        Long id = resource.getId();

        addHeaderLocation(response, id);
    }

    private void addHeaderLocation(HttpServletResponse response, Long id) {

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(id).toUri();

        response.setHeader("Location", uri.toASCIIString());
    }
}
