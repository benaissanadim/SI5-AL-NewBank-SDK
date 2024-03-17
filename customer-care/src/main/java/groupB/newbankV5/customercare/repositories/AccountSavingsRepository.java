package groupB.newbankV5.customercare.repositories;

import groupB.newbankV5.customercare.entities.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountSavingsRepository extends JpaRepository<SavingsAccount, Long> {

}

