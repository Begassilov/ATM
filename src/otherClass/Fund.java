package otherClass;

import java.util.Scanner;

import static java.lang.System.exit;
import com.company.Start;

public class Fund {
    private int ID;
    private int ATMID;
    private int cardNumber;
    private double amount;

    public Fund() {
    }

    public Fund(int ATMID, int cardNumber, double amount) {
        this.ATMID = ATMID;
        this.cardNumber = cardNumber;
        this.amount = amount;
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

    public double getamount() {
        return amount;
    }

    public void setamount(double amount) {
        this.amount = amount;
    }


    public static void fund(Card card){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter amount to fund");
        double amount = scan.nextDouble();
        card.getAccount().fund(amount);
        System.out.println("Processing...");
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Success");
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
        return "Funds{" +
                "ID=" + ID +
                ", ATMID=" + ATMID +
                ", cardNumber=" + cardNumber +
                ", amount=" + amount +
                '}';
    }
}
