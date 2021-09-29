package za.ac.nwu.accountsystem.logic.flow;

import za.ac.nwu.accountsystem.dto.AccountTypeDto;

public interface CreateAccountTypeFlow {
    AccountTypeDto create(AccountTypeDto accountType);
}
