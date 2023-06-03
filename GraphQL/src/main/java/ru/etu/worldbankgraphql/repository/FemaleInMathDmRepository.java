package ru.etu.worldbankgraphql.repository;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.etu.worldbankgraphql.Tables;
import ru.etu.worldbankgraphql.tables.pojos.FemaleInMathDm;

import java.util.List;
import java.util.Optional;

@Repository
public class FemaleInMathDmRepository {

    @Autowired
    public DSLContext context;

    public List<FemaleInMathDm> get(Optional<String> country_code) {
        return country_code
            .map(s ->
                context.selectFrom(Tables.FEMALE_IN_MATH_DM)
                .where(Tables.FEMALE_IN_MATH_DM.COUNTRY_CODE.eq(s))
                .fetchInto(FemaleInMathDm.class))
            .orElseGet(() ->
                context.selectFrom(Tables.FEMALE_IN_MATH_DM)
                .fetchInto(FemaleInMathDm.class)
            );
    }
}
