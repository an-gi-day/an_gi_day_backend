package com.bqtankiet.angiday.interfaces.http.v1.category;

/**
 * @author bqtankiet
 */
public record CategoryResponseDto(
        Long id,
        String name,
        String imageUrl
) {
}