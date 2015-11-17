package org.cara.dojo.bankkata;

public interface IBankAccountBusiness {

  Money balance();
  void withdraw(Money amount);
  void deposit(Money amount);
  Statement printStatement();

}
