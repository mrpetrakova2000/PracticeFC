package ru.etu.worldbank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.etu.worldbank.dto.PopulationDto;
import ru.etu.worldbank.service.PopulationService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/population")
public class PopulationController {
    @Autowired
    private PopulationService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<PopulationDto> getPopulation(@RequestParam(value = "country-code", required = false) Optional<String> countryCode){
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