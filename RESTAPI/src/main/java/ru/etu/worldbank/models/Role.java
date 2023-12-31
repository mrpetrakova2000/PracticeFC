package ru.etu.worldbank.models;

public class Role { //implements GrantedAuthority {
    private int id;
    private String name;

    public Role(){};
    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    @Override
    public String getAuthority() {
        return getName();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
