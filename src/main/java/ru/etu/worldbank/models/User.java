package ru.etu.worldbank.models;


public class User {
    private int id;
    private String username;
    private String password;

    public User() { }

    public User(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void viewUser(){
        System.out.println(this.getId() + " " + this.getUsername() + " " + this.getPassword());
    }
}
