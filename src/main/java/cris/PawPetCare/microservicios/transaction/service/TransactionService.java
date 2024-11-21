package cris.PawPetCare.microservicios.transaction.service;

import java.util.List;

import cris.PawPetCare.microservicios.transaction.Transaction;
import cris.PawPetCare.microservicios.transaction.repository.TransactionRepository;

public class TransactionService implements ITransactionService {
    TransactionRepository transactionRepository = new TransactionRepository();

    @Override
    public void registerTransaction(Transaction transaction) {
        transactionRepository.addTransaction(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.getAllTransactions();
    }

    @Override
    public long getTransactionId(long idCustomer, long idService) {
        return transactionRepository.getTransactionId(idCustomer, idService);
    }
}
