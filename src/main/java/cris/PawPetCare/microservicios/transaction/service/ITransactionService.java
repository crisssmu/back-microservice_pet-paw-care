package cris.PawPetCare.microservicios.transaction.service;

import java.util.List;

import cris.PawPetCare.microservicios.transaction.Transaction;

public interface ITransactionService {
    void registerTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
    long getTransactionId(long idCustomer, long idService);
}
