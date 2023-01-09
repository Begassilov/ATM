package com.company.controllers;


import com.company.repositories.interfaces.IAccountRepositiry;
import otherClass.Account;

public class AccountController {
    private final IAccountRepositiry accountRepositiry;

    public AccountController(IAccountRepositiry accountRepositiry) {
        this.accountRepositiry = accountRepositiry;
    }

    public String addAccount(String name, int customerID, double balance){
        boolean add = accountRepositiry.addAccount(new Account(name, customerID, balance));

        if (add) return "otherClass.Account was added!";
        return "otherClass.Account was not added!";

    }
}
