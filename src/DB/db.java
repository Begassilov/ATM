package DB;

import com.company.controllers.AccountController;
import controller.CustomerController;
import controller.FundController;
import controller.WithdrawalController;


import java.util.Scanner;

public class db {
    private final AccountController accountController;
    private final CustomerController customerController;
    private final WithdrawalController withdrawalController;
    private final FundController fundController;
    private final Scanner scan;

    public db(AccountController accountController, CustomerController customerController, WithdrawalController withdrawalController, FundController fundController) {
        this.accountController = accountController;
        this.customerController = customerController;
        this.withdrawalController = withdrawalController;
        this.fundController = fundController;
        scan = new Scanner(System.in);
    }


    public void start(){
        while(true) {
            System.out.println("Choose option.");
            System.out.println("1. See withdrawals\n" +
                    "2. See funds\n" +
                    "3. See customers\n" +
                    "4. Add customer\n" +
                    "5. Exit\n");
            int op = scan.nextInt();
            switch (op) {
                case 1:
                    System.out.println(withdrawalController.showWithdrawals());
                    break;
                case 2:
                    System.out.println(fundController.showFunds());
                    break;
                case 3:
                    System.out.println(customerController.showCustomers());
                    break;
                case 4:
                    addCustomer();
                    break;
                case 5:
                    System.out.println("Bye bye!");
                    return;
            }
        }
    }

    public void addCustomer(){
        System.out.println("Enter customer name:");
        String name = scan.next();
        System.out.println("Enter customer last name: ");
        String lastName = scan.next();
        System.out.println("Enter customer phone:");
        String phone = scan.next();
        System.out.println(customerController.addCustomer(name, lastName, phone));

    }




}
