package com.movieApp.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OmdbSearchResponse {

    @JsonProperty("Search")
    private List<OmdbSearchItem> search;

    @JsonProperty("Response")
    private String response;

    @JsonProperty("Error")
    private String error;
}