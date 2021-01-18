package com.example.aplicatieshop;

public class UserModel {

    private int ID;

    private String Username;

    private String Password;
    UserModel(int ID, String username, String password){
        this.ID = ID;
        this.Username = username;
        this.Password = password;
    }

    UserModel(){}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "ID=" + ID +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
