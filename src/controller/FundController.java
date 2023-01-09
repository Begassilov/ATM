package controller;

import otherClass.Fund;

public class FundController {
    private final com.company.repositories.interfaces.IFundsRepository fundsRepository;

    public FundController(com.company.repositories.interfaces.IFundsRepository fundsRepository) {
        this.fundsRepository = fundsRepository;
    }

    public String showFunds(){
        String result = fundsRepository.showFunds().toString();
        return result;
    }

    public String addFund(int cardNumber, int ATMID, double amount){

        boolean add = fundsRepository.addFund(new Fund(cardNumber, ATMID, amount));

        if (add) return "otherClass.Fund was added!";
        return "otherClass.Fund was not added!";

    }
}