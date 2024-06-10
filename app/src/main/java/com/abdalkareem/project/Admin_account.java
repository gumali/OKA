package com.abdalkareem.project;

public class Admin_account {
    String name ,password;

    public Admin_account() {
    }

    public Admin_account(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
