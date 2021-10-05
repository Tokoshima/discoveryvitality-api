package za.ac.nwu.accountsystem.logic.flow;

import za.ac.nwu.accountsystem.domain.dto.AccountTransactionDto;

import java.util.List;

public interface CreateAccountTransactionFlow {
    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto);
}
