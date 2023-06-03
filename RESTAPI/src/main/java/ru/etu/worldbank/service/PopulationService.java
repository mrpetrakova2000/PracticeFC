package ru.etu.worldbank.service;

import org.springframework.stereotype.Service;
import ru.etu.worldbank.repository.PopulationRepository;
import ru.etu.worldbank.tables.pojos.PopulationDm;

import java.util.List;
import java.util.Optional;

@Service
public class PopulationService {
    private final PopulationRepository repository;
    public PopulationService(PopulationRepository repository) {
        this.repository = repository;
    }

    public List<PopulationDm> get(Optional<String> country_code){
        return repository.get(country_code);
    }

}
