package com.example.demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class CompradorRequest {

    @CPForCNPJ
    @JsonProperty
    final String documento;

    @JsonCreator
    public CompradorRequest(String documento) {
        this.documento = documento;
    }
}
