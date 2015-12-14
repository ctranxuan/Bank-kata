package org.cara.dojo.bankkata;

import org.fest.assertions.Assertions;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

/**
 * @author ctranxuan
 */
public class AccountServiceShould {

    //    @Test
    public void testDeposit() throws Exception {

    }

//    @Test
    public void testWithdraw() throws Exception {

    }

    @Test
    public void testPrintStatement() throws Exception {
        // Given
        ConsoleShould console;
        console = new ConsoleShould();

        Statement statement;
        statement = new Statement();
        statement.addOperation(LocalDate.of(2014, Month.APRIL, 10), 500, 1400);

        AccountService accountService;
        accountService = new AccountService(statement, console);

        // When
        accountService.printStatement();

        // Then
        String expectedPrint;
        expectedPrint = "DATE      | AMOUNT | BALANCE" + IConsole.EOF
                + "10/04/2014 |  500,00 | 1400,00 ";
        System.out.println("AccountServiceShould.testPrintStatement: " + console.printedLines());
        Assertions.assertThat(console.printedLines()).isEqualTo(expectedPrint);
    }
}