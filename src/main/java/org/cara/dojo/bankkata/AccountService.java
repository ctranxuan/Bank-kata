package org.cara.dojo.bankkata;

public class AccountService implements IBankAccount {

  private IConsole console;

  public AccountService(IConsole console) {
    this.console = console;
    // TODO Auto-generated constructor stub
  }

  public void deposit(double amount) {
    // TODO Auto-generated method stub

  }

  public void withdraw(double amount) {
    // TODO Auto-generated method stub

  }

  public void printStatement() {
    console.println("");
  }

}
