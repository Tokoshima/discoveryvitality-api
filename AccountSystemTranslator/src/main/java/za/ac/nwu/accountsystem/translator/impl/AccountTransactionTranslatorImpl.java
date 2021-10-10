package za.ac.nwu.accountsystem.translator.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.accountsystem.domain.dto.AccountTransactionDto;
import za.ac.nwu.accountsystem.domain.persistence.AccountTransaction;
import za.ac.nwu.accountsystem.domain.persistence.AccountType;
import za.ac.nwu.accountsystem.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.accountsystem.translator.AccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountTransactionTranslatorImpl.class);


    private AccountTransactionRepository repo;

    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository){
        this.repo = accountTransactionRepository;
    }

    @Override
    public AccountTransaction save(AccountTransaction accountTransaction) {
        //TODO EXCEPTIONS
        try {
            return repo.save(accountTransaction);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }

    }

    @Override
    public List<AccountTransaction> getAllAccountTransactions() {
        //TODO EXCEPTIONS
        List<AccountTransaction> accountTransactions;
        try{
            accountTransactions = new ArrayList<>(repo.findAll());
        } catch (Exception e){
            throw new RuntimeException("Unable to get AccountTransactions from the DB", e);
        }

        return accountTransactions;
    }

    @Override
    public AccountTransaction getAccountTransactionByPk(Long transactionId) {
        //TODO EXCEPTIONS
        try{
            return repo.findById(transactionId).orElse(null);
        } catch (Exception e){
            throw new RuntimeException("Unable to read PK from AccountTransaction the DB", e);
        }

    }

//    @Override
//    public AccountTransaction UpdateAccountTypeAmount(Long amount, String mnemonic) {
//        LOGGER.info("TRANSACTION TRANSLATOR UpdateAccountTypeAmount: amount = {} , mnemonic = {}",amount,mnemonic);
//        AccountTransaction accountTransactionDto = repo.updateAccountTypeFromTransactionEvent(amount, mnemonic);
//        return null;
//        return repo.updateAccountTypeFromTransactionEvent(amount, mnemonic);
//    }
//
//
////        Customer customerToUpdate = customerRepository.getOne(id);
////        customerToUpdate.setName(customerDto.getName);
////        customerRepository.save(customerToUpdate);
//
//


}
