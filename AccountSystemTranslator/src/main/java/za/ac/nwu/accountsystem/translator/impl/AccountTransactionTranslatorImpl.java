package za.ac.nwu.accountsystem.translator.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.accountsystem.domain.persistence.AccountTransaction;
import za.ac.nwu.accountsystem.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.accountsystem.translator.AccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {

    private AccountTransactionRepository repo;

    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository){
        this.repo = accountTransactionRepository;
    }


    @Override
    public AccountTransaction save(AccountTransaction accountTransaction) {
        //TODO EXCEPTIONS

        return repo.save(accountTransaction);
    }

    @Override
    public List<AccountTransaction> getAllAccountTransactions() {
        //TODO EXCEPTIONS
        List<AccountTransaction> accountTransactions;

        accountTransactions = new ArrayList<>(repo.findAll());
        return accountTransactions;
    }

    @Override
    public AccountTransaction getAccountTransactionByPk(Long transactionId) {
        //TODO EXCEPTIONS

        return repo.findById(transactionId).orElse(null);
    }


}
