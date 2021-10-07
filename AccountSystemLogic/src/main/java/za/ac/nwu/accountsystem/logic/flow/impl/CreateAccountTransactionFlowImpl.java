package za.ac.nwu.accountsystem.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.accountsystem.domain.dto.AccountTransactionDto;
import za.ac.nwu.accountsystem.domain.dto.AccountTypeDto;
import za.ac.nwu.accountsystem.domain.persistence.AccountTransaction;
import za.ac.nwu.accountsystem.domain.persistence.AccountType;
import za.ac.nwu.accountsystem.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.accountsystem.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.accountsystem.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.accountsystem.translator.AccountTransactionTranslator;

@Component
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {
    private final AccountTransactionTranslator accountTransactionTranslator;
    private final FetchAccountTypeFlow fetchAccountTypeFlow;

    public CreateAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator,
                                            FetchAccountTypeFlow fetchAccountTypeFlow){
        this.accountTransactionTranslator = accountTransactionTranslator;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
    }

    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto){
        accountTransactionDto.setTransactionId(null);

        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(accountTransactionDto.getAccountTypeMnemonic());
        AccountTransaction accountTransaction = accountTransactionDto.buildAccountTransaction(accountType);

        AccountTransaction createdAccountTransaction = accountTransactionTranslator.save(accountTransaction);

//        AccountTransaction AccountTypeAmount = accountTransactionTranslator.UpdateAccountTypeAmount(createdAccountTransaction.getAmount(),accountTransactionDto.getAccountTypeMnemonic());


        return new AccountTransactionDto(createdAccountTransaction);
    }
    //TODO
}
