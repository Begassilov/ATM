package otherClass;

import java.util.Scanner;

import static java.lang.System.exit;
import com.company.Start;

public class Account {
    private int ID;
    private String name;
    private int customerID;
    private double balance;

    public Account() {
        ID = 1;
        name = "Smith J.";
        customerID = 1;
        balance = 1000000;

    }

    public Account(int ID, String name, int customerID, double balance) {
        this.ID = ID;
        this.name = name;
        this.customerID = customerID;
        this.balance = balance;
    }

    public Account(String name, int customerID, double balance) {
        this.name = name;
        this.customerID = customerID;
        this.balance = balance;
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

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean checkBalance(double balance){
        if (balance < this.balance) return true;
        return false;
    }

    public void withdrawal(double balance){
        this.balance -= balance;
    }

    public void fund(double amout){
        this.balance += amout;
    }

    public void showBalance(){
        Scanner scan = new Scanner(System.in);
        System.out.println("otherClass.Account holder: " + this.name);
        System.out.println("otherClass.Account ID:" + customerID);
        System.out.println("Balance: " + balance);
        System.out.println("Want more actions?\n" +
                "1. Yes\n" +
                "2. Exit\n");
        int op = scan.nextInt();
        if (op == 1) Start.start();
        else {
            System.out.println("Good bye!");
            exit(0);
        }
    }

    @Override
    public String toString() {
        return "otherClass.Account{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", CustomerID=" + customerID +
                ", balance=" + balance +
                '}';
    }
}
