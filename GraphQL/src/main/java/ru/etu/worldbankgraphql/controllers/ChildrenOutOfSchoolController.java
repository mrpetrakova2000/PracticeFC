package ru.etu.worldbankgraphql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import ru.etu.worldbankgraphql.dto.ChildrenOutOfSchoolDto;
import ru.etu.worldbankgraphql.service.ChildrenOutOfSchoolService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class ChildrenOutOfSchoolController {
    @Autowired
    private ChildrenOutOfSchoolService service;

    @QueryMapping
    public List<ChildrenOutOfSchoolDto> getChildrenOutOfSchool(@Argument Optional<String> countryCode) {
        return this.service.get(countryCode).stream()
                .map(pojo ->
                        new ChildrenOutOfSchoolDto(
                                pojo.countryName(),
                                pojo.countryCode(),
                                pojo.year(),
                                pojo.value()
                        )
                )
                .collect(Collectors.toList());
    }
}
