package ru.etu.worldbankgraphql.dto;

public record FemaleInMathDto(
    String countryName,
    String countryCode,
    int year,
    Double value
)
{
}
