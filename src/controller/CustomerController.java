package controller;


import otherClass.Customer;

public class CustomerController {
    private final com.company.repositories.interfaces.ICustomerRepository customerRepository;

    public CustomerController(com.company.repositories.interfaces.ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String addCustomer(String name, String lastName, String phone){
        boolean add = customerRepository.addCustomer(new Customer(name, lastName, phone));

        if(add) return "otherClass.Customer was added!";
        return "otherClass.Customer was not added!";

    }

    public String showCustomers(){
        String result = customerRepository.showCustomers().toString();
        return result;
    }
}