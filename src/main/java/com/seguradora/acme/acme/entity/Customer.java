package com.seguradora.acme.acme.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Customer {

    @JsonProperty("document_number")
    private String documentNumber;

    private String name;
    private String type;
    private String gender;

    @JsonProperty("date_of_birth")
    private LocalDate dateOfBirth;
    private String email;

    @JsonProperty("phone_number")
    private Long phoneNumber;
}
