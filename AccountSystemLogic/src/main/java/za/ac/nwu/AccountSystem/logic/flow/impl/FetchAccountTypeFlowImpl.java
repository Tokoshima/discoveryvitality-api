package za.ac.nwu.accountsystem.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.accountsystem.domain.dto.AccountTypeDto;
import za.ac.nwu.accountsystem.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.accountsystem.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes(){

        return accountTypeTranslator.getAllAccountTypes();
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic){
        return accountTypeTranslator.getAccountTypeByMnemonic(mnemonic);
    }

}