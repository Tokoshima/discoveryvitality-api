package za.ac.nwu.accountsystem.logic.flow;


import za.ac.nwu.accountsystem.domain.dto.AccountTypeDto;

import java.util.List;

public interface FetchAccountTypeFlow {
    List<AccountTypeDto>  getAllAccountTypes();

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

}
