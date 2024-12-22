package com.example.demo.model;

//Clase POJO
public class Customer {
    // Atributos
    private int ID;
    private String name;
    private String username;
    private String password;

    // Constructor
    public Customer(int ID, String name, String usarname, String password) {
        this.ID = ID;
        this.name = name;
        this.username = usarname;
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String usarname) {
        this.username = usarname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
