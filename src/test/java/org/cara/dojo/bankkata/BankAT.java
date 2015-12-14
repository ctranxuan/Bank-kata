package org.cara.dojo.bankkata;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.cara.dojo.bankkata.IConsole.EOF;
import static org.fest.assertions.Assertions.assertThat;


public class BankAT {

  @Test
  public void statementFormat(){
    // Given
    Console console;
    console = new Console();

    Statement statement;
    statement = new Statement(0);

    DateCreator dateCreator;
    dateCreator = new DateCreator(
            LocalDate.of(2014, Month.APRIL, 10),
            LocalDate.of(2014, Month.APRIL, 12),
            LocalDate.of(2014, Month.APRIL, 13)
    );

    IBankAccount accountService;
    accountService = new AccountService(statement, dateCreator, console);

    accountService.deposit(1000.00);
    accountService.withdraw(100.00);
    accountService.deposit(500.00);

    // When
    accountService.printStatement();

    // Then

    String expectedPrint = "DATE      | AMOUNT | BALANCE" + EOF
              + "13/04/2014 |  500,00 | 1400,00 " + EOF
              + "12/04/2014 | -100,00 |  900,00 " + EOF
              + "10/04/2014 | 1000,00 | 1000,00 " ;

    assertThat(console.printedLines()).isEqualTo(expectedPrint);
  }

}
