package io.github.manuelernesto.money.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Address {
    @Column(name = "public_place")
    @JsonProperty("public_place")
    private String publicPlace;
    private String number;
    private String complement;
    private String cep;
    private String district;
    private String city;
    private String state;
}
