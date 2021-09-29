package za.ac.nwu.accountsystem.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.nwu.accountsystem.dto.AccountTypeDto;
import za.ac.nwu.accountsystem.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.accountsystem.translator.AccountTypeTranslator;

import java.util.List;

public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator = accountTypeTranslator;
    }


    @Override
    public List<AccountTypeDto> getAllAccountTypes() {
        return accountTypeTranslator.getAllAccountTypes();
    }
}
