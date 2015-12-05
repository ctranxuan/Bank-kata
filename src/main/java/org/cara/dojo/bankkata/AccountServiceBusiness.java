package org.cara.dojo.bankkata;


public class AccountServiceBusiness implements IBankAccountBusiness {

  private Money balance;

  public AccountServiceBusiness() {
    super();
    this.balance = new Money(0);
  }

  @Override
  public Money balance() {
    return balance;
  }

  @Override
  public void deposit(Money amount) {
    balance = balance.add(amount);
  }

  @Override
  public void withdraw(Money amount) {
    balance = balance.substract(amount);
  }

  @Override
  public Statement printStatement() {
    return null;
  }


}
