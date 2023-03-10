package otherClass;

import com.company.Start;

import java.sql.Date;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.setOut;

public class Withdrawal {
    private int ID;
    private int ATMID;
    private int cardNumber;
    private double amount;
    private Date date;

    public Withdrawal() {
    }

    public Withdrawal(int ATMID, int cardNumber, double amount, Date date) {
        this.ATMID = ATMID;
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getATMID() {
        return ATMID;
    }

    public void setATMID(int ATMID) {
        this.ATMID = ATMID;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static void withdrawal(Card card){
        Scanner scan = new Scanner(System.in);
        System.out.println("1. 1000 KZT\n" +
                "2. 5000 KZT\n" +
                "3. 10000 KZT\n" +
                "4. Other");
        int option = scan.nextInt();
        switch(option){
            case 1:
                if (card.getAccount().checkBalance(1000)){
                    card.getAccount().withdrawal(1000);
                    System.out.println("Processing...");
                    try{
                        Thread.sleep(2000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                else{
                    System.out.println("Insufficient funds.");
                    withdrawal(card);
                }
                break;
            case 2:
                if (card.getAccount().checkBalance(5000)){
                    card.getAccount().withdrawal(5000);
                    System.out.println("Processing...");
                    try{
                        Thread.sleep(1500);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                else{
                    System.out.println("Insufficient funds.");
                    withdrawal(card);
                }
                break;
            case 3:
                if (card.getAccount().checkBalance(10000)){
                    card.getAccount().withdrawal(10000);
                    System.out.println("Processing...");
                    try{
                        Thread.sleep(1500);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                else{
                    System.out.println("Insufficient funds.");
                    withdrawal(card);
                }
                break;
            case 4:
                System.out.println("Enter amount: ");
                double amount = scan.nextDouble();
                if (card.getAccount().checkBalance(amount)){
                    card.getAccount().withdrawal(amount);
                    System.out.println("Processing...");
                    try{
                        Thread.sleep(1500);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                else{
                    System.out.println("Insufficient funds.");
                    withdrawal(card);
                }
                break;

        }
        System.out.println("Success!");
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
        return "Withdrawal{" +
                "ID=" + ID +
                ", ATMID=" + ATMID +
                ", cardNumber=" + cardNumber +
                ", amount=" + amount +
                '}';
    }
}
