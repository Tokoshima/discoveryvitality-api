package za.ac.nwu.accountsystem.logic.flow;

import za.ac.nwu.accountsystem.domain.dto.AccountTransactionDto;
import za.ac.nwu.accountsystem.domain.persistence.AccountTransaction;

import java.util.List;

public interface FetchAccountTransactionFlow {

    List<AccountTransactionDto> getAllAccountTransactions();

    AccountTransactionDto getAccountTransactionById(Long transactionId);
}
