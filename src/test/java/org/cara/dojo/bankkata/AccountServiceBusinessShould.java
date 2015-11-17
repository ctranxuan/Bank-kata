package org.cara.dojo.bankkata;

import org.cara.dojo.bankkata.Money.CURRENCY;
import org.fest.assertions.Assertions;
import org.junit.Test;


public class AccountServiceBusinessShould {


  @Test
  public void add_Given_Amount_When_Deposit()
  {
    // Given
    IBankAccountBusiness accountServiceBusiness = new AccountServiceBusiness();
    Money amountDeposit = new Money(110.00);
    Money balance = accountServiceBusiness.balance();
    Money expectedBalance = balance.add(amountDeposit);

    // When
    accountServiceBusiness.deposit(amountDeposit);
    Money actualBalance = accountServiceBusiness.balance();

    // Then
    Assertions.assertThat(actualBalance).isEqualTo(expectedBalance);
  }

}
