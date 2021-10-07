package za.ac.nwu.accountsystem.logic.flow;

import za.ac.nwu.accountsystem.domain.dto.AccountTransactionDto;
import za.ac.nwu.accountsystem.domain.persistence.AccountTransaction;

public interface AddTransactionFlow {
    public AccountTransactionDto addMiles(String mnemonic, Long amount);
}
