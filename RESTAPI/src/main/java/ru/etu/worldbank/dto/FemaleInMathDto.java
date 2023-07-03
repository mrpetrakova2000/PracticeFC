package ru.etu.worldbank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FemaleInMathDto(
    String countryName,
    String countryCode,
    int year,
    Double value
)
{
}
