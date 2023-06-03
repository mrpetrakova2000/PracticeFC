package ru.etu.worldbank.dto;

public record ChildrenOutOfSchoolDto (
        String countryName,
        String countryCode,
        int year,
        Long value
)
{
}
