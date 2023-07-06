package ru.etu.worldbank.repository;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.etu.worldbank.Tables;
import ru.etu.worldbank.tables.pojos.PopulationDm;

import java.util.List;
import java.util.Optional;

@Repository
public class PopulationRepository {
    @Autowired
    public DSLContext context;

    public List<PopulationDm> get(Optional<String> country_code) {
        return country_code
                .map(s ->
                        context.selectFrom(Tables.POPULATION_DM)
                                .where(Tables.POPULATION_DM.COUNTRY_CODE.eq(s))
                                .fetchInto(PopulationDm.class))
                .orElseGet(() ->
                        context.selectFrom(Tables.POPULATION_DM)
                                .fetchInto(PopulationDm.class)
                );
    }
}
