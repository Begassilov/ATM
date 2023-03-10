package otherClass;

import java.util.Scanner;

public class ATM {
    private static ATM instance;
    private Card insertedCard;
    private String location;
    private int id;


    private ATM(Card card) {
        insertedCard = card;
    }


    public static ATM getInstance(Card card) {
        if (instance == null){
            instance = new ATM(card);
        }
        return instance;
    }

    public void startSession(){
        System.out.println("Bla-Bla");
        //TODO
    }

    public boolean validateCard(String PIN){
        return PIN.equals(insertedCard.getPIN());
    }

    public static void insertCard(Card card){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter PIN: ");
        String PIN = scan.nextLine();
        checkPIN(PIN, card, 0);
    }

    public static void checkPIN(String PIN, Card card, int errors){
        Scanner scan = new Scanner(System.in);
        if (!PIN.equals(card.getPIN())){
            System.out.println("ERROR! Wring PIN. Try again");
            String newPIN = scan.nextLine();
            errors++;
            if (errors == 3){
                System.out.println("You made 3 unsuccessful tries. otherClass.Card is blocked.");
                return;
            }
            checkPIN(newPIN, card, errors);
        }
        else System.out.println("Success!");
    }

}