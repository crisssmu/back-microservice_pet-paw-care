package cris.PawPetCare.microservicios.transaction.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import cris.PawPetCare.database.DatabaseConfig;
import cris.PawPetCare.database.IDatabase;
import cris.PawPetCare.microservicios.transaction.Transaction;

public class TransactionRepository implements TransactionDAO {
    private IDatabase db;
    private Connection connection;

    public TransactionRepository() {
    }

    public TransactionRepository(IDatabase db, DatabaseConfig config) {
        this.db = db;
        this.db.configure(config.getUrl(), config.getUsername(), config.getPassword());
        this.db.connect();
        this.connection = db.getConnection();
    }

    @Override
    public void addTransaction(Transaction transaction) {
        String query = "INSERT INTO transactions(idCustomer, dateTranst, amount, idService) VALUES(?,?,?,?)";
        try(PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setLong(1, transaction.getIdCustomer());
            pstmt.setDate(2, (Date) transaction.getDateTransaction());
            pstmt.setFloat(3, transaction.getAmount());
            pstmt.setLong(4, transaction.getIdService());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT idCustomer, dateTranst, amount, idService FROM transactions";
        try(PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.executeQuery();
            while(pstmt.getResultSet().next()) {
                Transaction transaction = new Transaction();
                transaction.setIdCustomer(pstmt.getResultSet().getLong("idCustomer"));
                transaction.setDateTransaction(pstmt.getResultSet().getDate("dateTranst"));
                transaction.setAmount(pstmt.getResultSet().getFloat("amount"));
                transaction.setIdService(pstmt.getResultSet().getLong("idService"));
                transactions.add(transaction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactions;
    }

    @Override
    public long getTransactionId(long idCustomer, long idService) {
        String query = "SELECT idTransaction FROM transactions WHERE idCustomer = ? AND idService = ?";
        try(PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setLong(1, idCustomer);
            pstmt.setLong(2, idService);
            pstmt.executeQuery();
            while(pstmt.getResultSet().next()) {
                return pstmt.getResultSet().getLong("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }


}
