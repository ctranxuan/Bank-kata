package org.cara.dojo.bankkata;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author ctranxuan
 */
public class AccountServiceShould {

    @Test
    public void testDeposit() throws Exception {
        // Given
        Statement statement;
        statement = new Statement(900);

        LocalDate date;
        date = LocalDate.of(2014, Month.APRIL, 10);

        DateCreator dateCreator;
        dateCreator = new DateCreator(date);

        Console console;
        console = new Console();

        AccountService accountService;
        accountService = new AccountService(statement, dateCreator, console);

        // When
        accountService.deposit(500);

        // Then
        ImmutableList<Operation> operations;
        operations = statement.getOperations();

        assertThat(operations).hasSize(1);
        assertThat(operations.iterator().next()).isEqualTo(new Operation(date, 500, 1400));
    }

    @Test
    public void testWithdraw() throws Exception {
        // Given
        Statement statement;
        statement = new Statement(900);

        LocalDate date;
        date = LocalDate.of(2014, Month.APRIL, 10);

        DateCreator dateCreator;
        dateCreator = new DateCreator(date);

        Console console;
        console = new Console();

        AccountService accountService;
        accountService = new AccountService(statement, dateCreator, console);

        // When
        accountService.withdraw(500);

        // Then
        ImmutableList<Operation> operations;
        operations = statement.getOperations();

        assertThat(operations).hasSize(1);
        assertThat(operations.iterator().next()).isEqualTo(new Operation(date, -500, 400));
    }

    @Test
    public void testPrintStatement() throws Exception {
        // Given
        Statement statement = new Statement(900);
        LocalDate date = LocalDate.of(2014, Month.APRIL, 10);
        DateCreator dateCreator = new DateCreator(date);
        Console console = new Console();
        AccountService accountService = new AccountService(statement, dateCreator, console);

        statement.addOperation(date, 500);

        // When
        accountService.printStatement();

        // Then
        String expectedPrint;
        expectedPrint = "DATE      | AMOUNT | BALANCE" + IConsole.EOF
                + "10/04/2014 |  500,00 | 1400,00 ";
        assertThat(console.printedLines()).isEqualTo(expectedPrint);
    }
}