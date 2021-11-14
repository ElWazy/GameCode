package com.lutrias.projectunit2_matiasmarchant_santiagofierro.objects;

public class Administrator {

    private int id;
    private String username;
    private String password;

    public Administrator() {
        username = "admin";
        password = "admin";
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
