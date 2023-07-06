package ru.etu.worldbank.dto;

public record PopulationDto (
        String countryName,
        String countryCode,
        int year,
        Long value
    )
{
}
