package ru.etu.worldbankgraphql.dto;

public record ChildrenOutOfSchoolDto(
        String countryName,
        String countryCode,
        int year,
        Long value
)
{
}
