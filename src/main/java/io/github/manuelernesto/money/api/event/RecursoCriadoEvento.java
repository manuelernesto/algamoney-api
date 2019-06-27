package io.github.manuelernesto.money.api.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class RecursoCriadoEvento extends ApplicationEvent {

    private HttpServletResponse response;
    private Long codigo;

    public RecursoCriadoEvento(
            Object source,
            HttpServletResponse response,
            Long codigo) {
        super(source);
        this.codigo = codigo;
        this.response = response;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public Long getCodigo() {
        return codigo;
    }
}
