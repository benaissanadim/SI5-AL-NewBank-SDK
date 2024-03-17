package groupB.newbankV5.customercare.repositories;

import groupB.newbankV5.customercare.entities.Account;
import groupB.newbankV5.customercare.entities.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByIBAN(String IBAN);
    Optional<Account> findByCreditCardsCardNumberAndCreditCardsExpiryDateAndCreditCardsCvv(
            String cardNumber, String expiryDate, String cvv);

    Optional<Account> findByType(AccountType accountType);
}

