package ru.etu.worldbankgraphql.service;

import org.springframework.stereotype.Service;
import ru.etu.worldbankgraphql.repository.FemaleInMathDmRepository;
import ru.etu.worldbankgraphql.tables.pojos.FemaleInMathDm;

import java.util.List;
import java.util.Optional;

@Service
public class FemaleInMathDmService {
    private final FemaleInMathDmRepository repository;
    public FemaleInMathDmService(FemaleInMathDmRepository repository) {
        this.repository = repository;
    }

    public List<FemaleInMathDm> get(Optional<String> country_code){
        return repository.get(country_code);
    }
}