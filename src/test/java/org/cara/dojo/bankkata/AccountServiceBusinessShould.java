package org.cara.dojo.bankkata;

import org.fest.assertions.Assertions;
import org.junit.Test;


public class AccountServiceBusinessShould {


  @Test
  public void increases_Balance_When_Deposit()
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

  @Test
  public void decreases_Balance_Withdraw()
  {
    // Given
    IBankAccountBusiness accountServiceBusiness = new AccountServiceBusiness();
    Money amountWithdraw = new Money(80.00);
    Money balance = accountServiceBusiness.balance();
    Money expectedBalance = balance.substract(amountWithdraw);

    // When
    accountServiceBusiness.withdraw(amountWithdraw);
    Money actualBalance = accountServiceBusiness.balance();

    // Then
    Assertions.assertThat(actualBalance).isEqualTo(expectedBalance);
  }

}
