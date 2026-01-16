package com.movieApp.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class YoutubeSearchResponse {
    @JsonProperty("items")
    private List<YoutubeSearchItem> items;
}