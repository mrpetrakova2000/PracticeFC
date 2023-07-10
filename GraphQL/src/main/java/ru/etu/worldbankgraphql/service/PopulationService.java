package ru.etu.worldbankgraphql.service;

import org.springframework.stereotype.Service;
import ru.etu.worldbankgraphql.repository.PopulationRepository;
import ru.etu.worldbankgraphql.tables.pojos.PopulationDm;

import java.util.List;
import java.util.Optional;

@Service
public class PopulationService {
    private final PopulationRepository repository;
    public PopulationService(PopulationRepository repository) {
        this.repository = repository;
    }

    public List<PopulationDm> get(Optional<String> countryCode){
        return repository.get(countryCode);
    }

}
