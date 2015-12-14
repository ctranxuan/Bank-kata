package org.cara.dojo.bankkata;

import com.google.common.collect.ImmutableList;
import org.apache.commons.lang.NotImplementedException;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.String.format;

/**
 * @author ctranxuan
 */
public class AccountService implements IBankAccount {

    private final Statement statement;
    private final IConsole console;

    public AccountService(final Statement aStatement, final IConsole aConsole) {
        statement = checkNotNull(aStatement, "aStatement cannot be null");
        console = checkNotNull(aConsole, "aConsole cannot be null");
    }

    @Override
    public void deposit(final double aDeposit) {
        throw new NotImplementedException();
    }

    @Override
    public void withdraw(final double aWithDraw) {
        throw new NotImplementedException();
    }

    @Override
    public void printStatement() {
        String header;
        header = "DATE      | AMOUNT | BALANCE";

        console.print(header);

        ImmutableList<Operation> operations;
        operations = statement.getOperations();

        DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        operations.forEach(op -> {
            console.println();
            console.print(format(Locale.FRANCE, "%s |  %.2f | %.2f ",
                    op.getDate().format(formatter),
                    op.getAmount(),
                    op.getBalance()));
        });
    }
}
