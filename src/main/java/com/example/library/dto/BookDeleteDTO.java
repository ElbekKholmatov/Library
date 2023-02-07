package com.example.library.dto;

public record BookDeleteDTO(String title, String author, String description, Long categoriesId, boolean active) {
}
