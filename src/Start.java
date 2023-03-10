import com.company.repositories.WithdrawalRepository;
import com.company.repositories.interfaces.IWithdrawalRepository;
import controller.WithdrawalController;
import otherClass.*;

import java.util.Scanner;

public class Start {
    static Bank bank;
    static Card card;
    static Customer customer;
    IDBManager dbManager = new DBManager();
    IWithdrawalRepository withdrawalRepository = new WithdrawalRepository(dbManager);
    WithdrawalController withdrawalController = new WithdrawalController(withdrawalRepository);

    public Start(Bank bank, Card card, Customer customer) {
        Start.bank = bank;
        Start.card = card;
        Start.customer = customer;

    }

    public static void start(){
        Scanner scan = new Scanner(System.in);
        ATM.insertCard(card);
        while(true){
            System.out.println("1. Withdrawal\n" +
                    "2. otherClass.Fund\n" +
                    "3. Check balance\n" +
                    "4. Exit");
            int operation = scan.nextInt();
            switch(operation){
                case 1:
                    Withdrawal.withdrawal(card);
                case 2:
                    Fund.fund(card);
                case 3:
                    card.getAccount().showBalance();
                case 4:
                    System.out.println("Bye bye!");
                    return;

            }
        }
    }
}
