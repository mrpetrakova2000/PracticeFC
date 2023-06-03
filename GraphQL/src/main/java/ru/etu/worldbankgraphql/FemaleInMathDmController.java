package ru.etu.worldbankgraphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import ru.etu.worldbankgraphql.dto.FemaleInMathDto;
import ru.etu.worldbankgraphql.service.FemaleInMathDmService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class FemaleInMathDmController {

    @Autowired
    private FemaleInMathDmService femaleInMathDmService;

    @QueryMapping
    public List<FemaleInMathDto> getFemaleInMath(@Argument Optional<String> countryCode) {
        return this.femaleInMathDmService.get(countryCode).stream()
                .map(pojo ->
                        new FemaleInMathDto(
                                pojo.countryName(),
                                pojo.countryCode(),
                                pojo.year(),
                                pojo.value()
                        )
                )
                .collect(Collectors.toList());
    }
}