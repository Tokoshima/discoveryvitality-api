package za.ac.nwu.accountsystem.translator;

import za.ac.nwu.accountsystem.domain.dto.AccountTransactionDto;
import za.ac.nwu.accountsystem.domain.persistence.AccountTransaction;
import za.ac.nwu.accountsystem.domain.persistence.AccountType;

import java.util.List;

public interface AccountTransactionTranslator {
    AccountTransaction save(AccountTransaction accountTransaction);

    List<AccountTransaction> getAllAccountTransactions();

    AccountTransaction getAccountTransactionByPk(Long transactionId);

    AccountTransaction UpdateAccountTypeAmount(Long amount, String mnemonic);
}
