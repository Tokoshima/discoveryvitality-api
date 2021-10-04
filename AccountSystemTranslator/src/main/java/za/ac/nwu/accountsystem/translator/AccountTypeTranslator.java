package za.ac.nwu.accountsystem.translator;

import za.ac.nwu.accountsystem.domain.dto.AccountTypeDto;

import java.util.List;

public interface AccountTypeTranslator {

    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto create(AccountTypeDto accountType);

    AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic);

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

//    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);
}
