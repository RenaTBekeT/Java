package com.movieApp.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TrailerDto {

    /**
     * YouTube video ID (např. dQw4w9WgXcQ)
     * Když se trailer nenajde, je null
     */
    private String videoId;
}