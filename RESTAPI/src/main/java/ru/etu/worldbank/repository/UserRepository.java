package ru.etu.worldbank.repository;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.etu.worldbank.models.User;
import ru.etu.worldbank.Tables;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    public DSLContext context;

    private List<User> users;

    public UserRepository(){
        this.users = null;
    }

    public User addUser(User user) {
        return context.insertInto(Tables.USER)
                .set(Tables.USER.USERNAME, user.getUsername())
                .set(Tables.USER.PASSWORD, user.getPassword())
                .returning()
                .fetchOne()
                .into(User.class);
    }

    public User findById(int user_id){
        return context.selectFrom(Tables.USER)
                .where(Tables.USER.ID.eq(user_id))
                .fetchAny()
                .into(User.class);
    }

    public User findByUsername(String username){
        return context.selectFrom(Tables.USER)
                .where(Tables.USER.USERNAME.eq(username))
                .fetchAny()
                .into(User.class);
    }

    public List<User> getAll() {
        this.users = context.selectFrom(Tables.USER).fetchInto(User.class);
        return this.users;
    }
}
