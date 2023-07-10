package ru.etu.worldbankgraphql.service;

import org.springframework.stereotype.Service;
import ru.etu.worldbankgraphql.repository.ChildrenOutOfSchoolRepository;
import ru.etu.worldbankgraphql.tables.pojos.ChildrenOutOfSchoolDm;

import java.util.List;
import java.util.Optional;

@Service
public class ChildrenOutOfSchoolService {
    private final ChildrenOutOfSchoolRepository repository;
    public ChildrenOutOfSchoolService(ChildrenOutOfSchoolRepository repository) {
        this.repository = repository;
    }

    public List<ChildrenOutOfSchoolDm> get(Optional<String> country_code){
        return repository.get(country_code);
    }
}
