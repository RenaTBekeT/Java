package com.movieApp.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YoutubeVideoId {
    @JsonProperty("videoId")
    private String videoId;
}