package za.ac.nwu.accountsystem.translator;

import za.ac.nwu.accountsystem.dto.AccountTypeDto;

import java.util.List;

public interface AccountTypeTranslator {

    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto create(AccountTypeDto accountType);
}
