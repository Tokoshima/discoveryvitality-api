package za.ac.nwu.accountsystem.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.accountsystem.domain.dto.AccountTransactionDto;
import za.ac.nwu.accountsystem.domain.dto.AccountTypeDto;
import za.ac.nwu.accountsystem.domain.persistence.AccountTransaction;
import za.ac.nwu.accountsystem.domain.persistence.AccountType;
import za.ac.nwu.accountsystem.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.accountsystem.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.accountsystem.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.accountsystem.translator.AccountTransactionTranslator;
import za.ac.nwu.accountsystem.translator.impl.AccountTypeTranslatorImpl;

@Component
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTransactionFlowImpl.class);
//    LOGGER.info("{}",amount);

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

        LOGGER.info("Amount = {}    ,   accountTransactionDto.getAccountTypeMnemonic() = {}",createdAccountTransaction.getAmount(), accountTransactionDto.getAccountTypeMnemonic());
        LOGGER.info("Amount = {}    ,   createdAccountTransaction.getAccountType() = {}",createdAccountTransaction.getAmount(), createdAccountTransaction.getAccountType());
//        AccountTransaction AccountTypeAmount = accountTransactionTranslator.UpdateAccountTypeAmount(createdAccountTransaction.getAmount(),accountTransactionDto.getAccountTypeMnemonic());


        return new AccountTransactionDto(createdAccountTransaction);
    }
    //TODO
}
