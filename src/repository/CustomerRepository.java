package com.company.repositories;

import com.company.data.interfaces.IDBManager;
import com.company.entities.Customer;
import com.company.entities.Fund;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerRepository implements ICustomerRepository {
    private final IDBManager dbManager;

    public CustomerRepository(IDBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public ArrayList<Customer> showCustomers() {
        try{
            Connection connection = null;
            connection = dbManager.getConnection();
            String sql = "SELECT * FROM customers";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Customer> list = new ArrayList<Customer>();
            while(resultSet.next()){
                Customer customer = new Customer(resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getString("phone"));
                list.add(customer);
            }
            return list;

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        try{
            Connection connection = null;
            connection = dbManager.getConnection();
            String sql = "INSERT INTO customers(name, lastName, phone) VALUES (?,?,?)";
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setString(1, customer.getName());
            stat.setString(2, customer.getLastName());
            stat.setString(3, customer.getPhone());
            stat.executeUpdate();
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
