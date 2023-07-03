package ru.etu.worldbank.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "User")
public record UserDTO(
        @Schema(title = "Name", example = "name")
        String username,
        @Schema(title = "Password", example = "12345")
        String password) {
}