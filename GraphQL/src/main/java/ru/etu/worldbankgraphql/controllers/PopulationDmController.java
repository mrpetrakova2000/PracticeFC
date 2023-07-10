package ru.etu.worldbankgraphql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import ru.etu.worldbankgraphql.dto.PopulationDto;
import ru.etu.worldbankgraphql.service.PopulationService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class PopulationDmController {
    @Autowired
    private PopulationService service;

    @QueryMapping
    public List<PopulationDto> getPopulation(@Argument Optional<String> countryCode) {
        return this.service.get(countryCode).stream()
                .map(pojo ->
                        new PopulationDto(
                                pojo.countryName(),
                                pojo.countryCode(),
                                pojo.year(),
                                pojo.value()
                        )
                )
                .collect(Collectors.toList());
    }
}
