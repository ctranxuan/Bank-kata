package org.cara.dojo.bankkata;

import org.junit.Test;

import static org.cara.dojo.bankkata.IConsole.EOF;
import static org.fest.assertions.Assertions.assertThat;


public class BankAT {

  @Test
  public void statementFormat(){
    // Given
    ConsoleShould console;
    console = new ConsoleShould();

    Statement statement;
    statement = new Statement();

    IBankAccount accountService;
    accountService = new AccountService(statement, console);

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

    assertThat(console.printedLines()).isEqualTo(expectedPrint);
  }

}
