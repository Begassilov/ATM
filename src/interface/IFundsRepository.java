package com.company.repositories.interfaces;

import otherClass.Fund;

import java.util.ArrayList;

public interface IFundsRepository {
    ArrayList<Fund> showFunds();
    boolean addFund(Fund fund);

}
