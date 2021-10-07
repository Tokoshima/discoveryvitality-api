package za.ac.nwu.accountsystem.logic.flow.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.accountsystem.domain.dto.AccountTransactionDto;
import za.ac.nwu.accountsystem.domain.dto.AccountTypeDto;
import za.ac.nwu.accountsystem.domain.persistence.AccountTransaction;
import za.ac.nwu.accountsystem.domain.persistence.AccountType;
import za.ac.nwu.accountsystem.logic.flow.AddTransactionFlow;
import za.ac.nwu.accountsystem.translator.AccountTransactionTranslator;

import java.time.LocalDate;

@Transactional
@Component
public class AddTransactionFlowImpl implements AddTransactionFlow {

    private AccountTransactionTranslator translator;


    @Override
    public AccountTransactionDto addMiles(String mnemonic, Long amount) {
//        AccountTransaction accountTransaction = translator.get


        return null;
    }

//    @Override
//    public AccountTypeDto create(AccountTypeDto accountType) {
//        if (null == accountType.getCreationDate()){
//            accountType.setCreationDate(LocalDate.now());
//        }
//        return accountTypeTranslator.create(accountType);
//    }

//    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto){
//        accountTransactionDto.setTransactionId(null);
//
//        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(accountTransactionDto.getAccountTypeMnemonic());
//        AccountTransaction accountTransaction = accountTransactionDto.buildAccountTransaction(accountType);
//
//        AccountTransaction createdAccountTransaction = accountTransactionTranslator.save(accountTransaction);
//
//        return new AccountTransactionDto(createdAccountTransaction);
//    }


//    @Override
//    public List<AccountTransactionDto> getAllAccountTransactions() {
//        List<AccountTransactionDto> accountTransactionDtos = new ArrayList<>();
//        for (AccountTransaction accountTransaction : translator.getAllAccountTransactions()){
//            accountTransactionDtos.add(new AccountTransactionDto(accountTransaction));
//        }
//        return accountTransactionDtos;
//    }
//
//    @Override
//    public AccountTransactionDto getAccountTransactionById(Long transactionId) {
//        AccountTransaction accountTransaction = translator.getAccountTransactionByPk(transactionId);
//        return null != accountTransaction ? new AccountTransactionDto(accountTransaction) : null;
//    }

}
