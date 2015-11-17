package org.cara.dojo.bankkata;

import org.fest.assertions.Assertions;
import org.junit.Test;


public class BankAT {

  private static String EOF = System.getProperty("line.separator");

  @Test
  public void statementFormat(){
    // Given
    TestConsole console = new TestConsole();

    IBankAccount accountService = new AccountService(console);
    accountService.deposit(1000.00);
    accountService.withdraw(100.00);
    accountService.deposit(500.00);

    // When
    accountService.printStatement();

    // Then

    String expectedPrint = "DATE      | AMOUNT | BALANCE" + EOF
              + "10/04/2014 |  500,00 | 1400,00 " + EOF
              + "02/04/2014 | -100,00 |  900,00 " + EOF
              + "10/04/2014 | 1000,00 | 1000,00 " ;

    Assertions.assertThat(console.printedLines()).isEqualTo(expectedPrint);
  }

}
