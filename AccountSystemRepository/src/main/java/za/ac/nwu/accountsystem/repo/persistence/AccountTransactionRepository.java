package za.ac.nwu.accountsystem.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.accountsystem.domain.persistence.AccountTransaction;
import za.ac.nwu.accountsystem.domain.persistence.AccountType;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
    @Query(value = "SELECT" +
            "             at       " +
            "   FROM               " +
            "      AccountType at  " +
            "   WHERE at.mnemonic = :mnemonic")
    AccountType getAccountTypeByMnemonic(String mnemonic);



    @Query(value = " UPDATE" +
            "ACCOUNT_TYPE"+
            "SET"+
            "AMOUNT_TOTAL = :amount"+
            "WHERE MNEMONIC = :mnemonic")
    AccountTransaction updateAccountTypeFromTransactionEvent(Long amount, String mnemonic);
//    UPDATE
//            parts
//    SET
//            cost = 130
//    WHERE
//            part_id = 1;

}
