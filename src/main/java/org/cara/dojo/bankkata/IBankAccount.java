package org.cara.dojo.bankkata;

/**
 * @author ctranxuan
 */
public interface IBankAccount {
    void deposit(double aDeposit);

    void withdraw(double aWithDraw);

    void printStatement();
}
