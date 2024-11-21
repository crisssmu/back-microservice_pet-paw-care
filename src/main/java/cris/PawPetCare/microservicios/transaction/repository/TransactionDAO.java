package cris.PawPetCare.microservicios.transaction.repository;

import java.util.List;

import cris.PawPetCare.microservicios.transaction.Transaction;

public interface TransactionDAO {
    void addTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
    long getTransactionId(long idCustomer, long idService);
}
