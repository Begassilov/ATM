package com.company.repositories;

import com.company.data.interfaces.IDBManager;
import otherClass.Withdrawal;
import com.company.repositories.interfaces.IWithdrawalRepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class WithdrawalRepository implements IWithdrawalRepository {
    private final IDBManager dbManager;

    public WithdrawalRepository(IDBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public ArrayList<Withdrawal> showWithdrawals() {
        try{
            Connection connection = null;
            connection = dbManager.getConnection();
            String sql = "SELECT * FROM withdrawals";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Withdrawal> list = new ArrayList<Withdrawal>();

            while(resultSet.next()){
                Withdrawal withdrawal = new Withdrawal(resultSet.getInt("ATMID"),
                        resultSet.getInt("cardNumber"),
                        resultSet.getDouble("amount"),
                        resultSet.getDate("date"));
                list.add(withdrawal);
            }
            return list;

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addWithdrawal(Withdrawal withdrawal) {
        try{
            Connection connection = null;
            connection = dbManager.getConnection();
            String sql = "INSERT INTO withdrawals(ATMID, cardNumber, amount, date) VALUES (?,?,?,?)";
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setInt(1, withdrawal.getATMID());
            stat.setInt(2, withdrawal.getCardNumber());
            stat.setDouble(3, withdrawal.getAmount());
            stat.setDate(4, withdrawal.getDate());
            stat.executeUpdate();
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
