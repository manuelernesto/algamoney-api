package io.github.manuelernesto.money.api.event.listener;

import io.github.manuelernesto.money.api.event.RecursoCriadoEvento;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvento> {

    @Override
    public void onApplicationEvent(RecursoCriadoEvento recurso) {
        HttpServletResponse response = recurso.getResponse();
        Long codigo = recurso.getCodigo();

        addHeaderLocation(response, codigo);
    }

    private void addHeaderLocation(HttpServletResponse response, Long codigo) {

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(codigo).toUri();

        response.setHeader("Location", uri.toASCIIString());
    }
}
