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
       console.print(statement);
    }
}
