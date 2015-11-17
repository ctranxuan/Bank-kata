package org.cara.dojo.bankkata;

public interface IBankAccount {

  void withdraw(double amount);
  void deposit(double amount);
  void printStatement();

}
