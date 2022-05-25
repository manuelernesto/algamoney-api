package io.github.manuelernesto.money.api.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class ResourceCreatedEvent extends ApplicationEvent {

    private final HttpServletResponse response;
    private final Long id;

    public ResourceCreatedEvent(
            Object source,
            HttpServletResponse response,
            Long id) {
        super(source);
        this.id = id;
        this.response = response;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public Long getId() {
        return id;
    }
}
