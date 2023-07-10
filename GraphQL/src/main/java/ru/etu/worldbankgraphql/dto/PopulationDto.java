package ru.etu.worldbankgraphql.dto;

public record PopulationDto(
        String countryName,
        String countryCode,
        int year,
        Long value
    )
{
}
