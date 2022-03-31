package com.codegym.model;
/*
    Created by Trinh Khai
    Date: 30/03/2022
    Time: 21:47
*/

public class Login {
    private String account;
    private String password;

    public Login() {
    }

    public Login(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
