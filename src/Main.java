

import com.company.controllers.AccountController;
import com.company.repositories.CustomerRepository;
import com.company.repositories.FundsRepository;
import com.company.repositories.WithdrawalRepository;
import com.company.repositories.interfaces.IAccountRepositiry;
import com.company.repositories.interfaces.ICustomerRepository;
import com.company.repositories.interfaces.IFundsRepository;
import com.company.repositories.interfaces.IWithdrawalRepository;
import controller.CustomerController;
import controller.FundController;
import controller.WithdrawalController;
import otherClass.Account;
import otherClass.Bank;
import otherClass.Card;
import otherClass.Customer;
import repository.AccountRepository;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Aligazy and Nursultan End Term project!");
        start();

    }

    public static void start(){
        IDBManager idbManager = new DBManager();
        IWithdrawalRepository withdrawalRepository = new WithdrawalRepository(idbManager);
        WithdrawalController withdrawalController = new WithdrawalController(withdrawalRepository);

        IAccountRepositiry accountRepositiry = new AccountRepository(idbManager);
        AccountController accountController = new AccountController(accountRepositiry);

        ICustomerRepository customerRepository = new CustomerRepository(idbManager);
        CustomerController customerController = new CustomerController(customerRepository);

        IFundsRepository fundsRepository = new FundsRepository(idbManager);
        FundController fundController = new FundController(fundsRepository);


        Scanner scan = new Scanner(System.in);
        Bank bank = new Bank();
        Customer customer = new Customer();
        Card card = new Card();
        Account account = new Account();
        card.setAccount(account);
        System.out.println("Choose option");
        System.out.println("1. otherClass.ATM ");
        System.out.println("2. Database");
        System.out.println("3. Exit");
        int op = scan.nextInt();

        if (op == 1) {
            Start start = new Start(bank, card, customer);
            Start.start();
        }
        else if (op == 2){
            DB db = new DB(accountController, customerController, withdrawalController, fundController);
            db.start();
        }
        else return;
    }
}
