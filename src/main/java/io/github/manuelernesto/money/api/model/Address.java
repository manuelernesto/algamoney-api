package io.github.manuelernesto.money.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Address {
    private String publicPlace;
    private String number;
    private String complement;
    private String cep;
    private String district;
    private String city;
    private String state;
}
