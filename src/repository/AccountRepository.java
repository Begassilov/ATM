package repository;

import otherClass.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AccountRepository {
    public class AccountRepository implements com.company.repositories.interfaces.IAccountRepositiry {
        private final IDBManager dbManager;

        public AccountRepository(IDBManager dbManager) {
            this.dbManager = dbManager;
        }

        @Override
        public boolean addAccount(Account account) {
            try{
                Connection connection = null;
                connection = dbManager.getConnection();
                String sql = "INSERT INTO accounts(name, customerID, balance) VALUES (?,?,?)";
                PreparedStatement stat = connection.prepareStatement(sql);
                stat.setString(1, account.getName());
                stat.setInt(2, account.getCustomerID());
                stat.setDouble(3, account.getBalance());
                stat.executeUpdate();
                connection.close();
            } catch (Exception e){
                e.printStackTrace();
            }
            return false;
        }
    }
}
