package groupB.newbankV5.customercare.interfaces;

import groupB.newbankV5.customercare.components.dto.AccountCreationDto;
import groupB.newbankV5.customercare.entities.Account;

import java.math.BigDecimal;

public interface AccountRegistration {

    Account createAccount(AccountCreationDto accountCreationDto);
    void deleteAccount(Account account);

}
