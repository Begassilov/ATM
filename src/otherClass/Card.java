package otherClass;

import otherClass.Account;

import java.util.Date;

public class Card {
    private String number;
    private int accountID;
    private Date expirationDate;
    private double withdrawalLimit;
    private String PIN;
    private Account account;

    public Card() {
        number = "4444 4444 4444 4444";
        accountID = 1;
        PIN = "0000";
    }

    public Card(String number, int accountID, Date expirationDate, double withdrawalLimit) {
        this.number = number;
        this.accountID = accountID;
        this.expirationDate = expirationDate;
        this.withdrawalLimit = withdrawalLimit;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public void setWithdrawalLimit(double withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    public String getPIN() {
        return PIN;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "otherClass.Card{" +
                "number='" + number + '\'' +
                ", accountID=" + accountID +
                ", expirationDate=" + expirationDate +
                ", withdrawalLimit=" + withdrawalLimit +
                '}';
    }
}
