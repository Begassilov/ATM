package com.company.repositories.interfaces;

import otherClass.Withdrawal;

import java.util.ArrayList;

public interface IWithdrawalRepository {
    ArrayList<Withdrawal> showWithdrawals();
    boolean addWithdrawal(Withdrawal withdrawal);
}
