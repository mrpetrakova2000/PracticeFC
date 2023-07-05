package ru.etu.worldbank.repository;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.etu.worldbank.Tables;
import ru.etu.worldbank.tables.pojos.ChildrenOutOfSchoolDm;

import java.util.List;
import java.util.Optional;

@Repository
public class ChildrenOutOfSchoolRepository {
    @Autowired
    public DSLContext context;

    public List<ChildrenOutOfSchoolDm> get(Optional<String> country_code) {
        return country_code
                .map(s ->
                        context.selectFrom(Tables.CHILDREN_OUT_OF_SCHOOL_DM)
                                .where(Tables.CHILDREN_OUT_OF_SCHOOL_DM.COUNTRY_CODE.eq(s))
                                .fetchInto(ChildrenOutOfSchoolDm.class))
                .orElseGet(() ->
                        context.selectFrom(Tables.CHILDREN_OUT_OF_SCHOOL_DM)
                                .fetchInto(ChildrenOutOfSchoolDm.class)
                );
    }
}
