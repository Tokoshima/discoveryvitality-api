package za.ac.nwu.accountsystem.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.accountsystem.domain.dto.AccountTransactionDto;
import za.ac.nwu.accountsystem.domain.dto.AccountTypeDto;
import za.ac.nwu.accountsystem.domain.persistence.AccountTransaction;
import za.ac.nwu.accountsystem.domain.persistence.AccountType;
import za.ac.nwu.accountsystem.logic.flow.FetchAccountTransactionFlow;
import za.ac.nwu.accountsystem.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.accountsystem.translator.AccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class FetchAccountTransactionFlowImpl  implements FetchAccountTransactionFlow {
    private AccountTransactionTranslator translator;

    public FetchAccountTransactionFlowImpl(AccountTransactionTranslator translator){
        this.translator = translator;
    }

    @Override
    public List<AccountTransactionDto> getAllAccountTransactions() {
        List<AccountTransactionDto> accountTransactionDtos = new ArrayList<>();
        for (AccountTransaction accountTransaction : translator.getAllAccountTransactions()){
            accountTransactionDtos.add(new AccountTransactionDto(accountTransaction));
        }
        return accountTransactionDtos;
    }

    @Override
    public AccountTransactionDto getAccountTransactionById(Long transactionId) {
        AccountTransaction accountTransaction = translator.getAccountTransactionByPk(transactionId);
        return null != accountTransaction ? new AccountTransactionDto(accountTransaction) : null;
    }




}
