package za.ac.nwu.accountsystem.repo.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.accountsystem.persistence.AccountType;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {
}
