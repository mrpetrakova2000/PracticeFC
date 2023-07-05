package ru.etu.worldbank.service;

import org.springframework.stereotype.Service;
import ru.etu.worldbank.repository.ChildrenOutOfSchoolRepository;
import ru.etu.worldbank.tables.pojos.ChildrenOutOfSchoolDm;

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
