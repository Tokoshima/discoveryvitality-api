package za.ac.nwu.accountsystem.logic.flow;

import za.ac.nwu.accountsystem.domain.dto.AccountTypeDto;

public interface CreateAccountTypeFlow {
    AccountTypeDto create(AccountTypeDto accountType);

}
