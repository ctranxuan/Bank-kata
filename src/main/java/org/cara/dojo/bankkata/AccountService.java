package org.cara.dojo.bankkata;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author ctranxuan
 */
public class AccountService implements IBankAccount {

    private final Statement statement;
    private final IDateCreator dateCreator;
    private final IConsole console;

    public AccountService(final Statement aStatement, final IDateCreator aDateCreator, final IConsole aConsole) {
        statement = checkNotNull(aStatement, "aStatement cannot be null");
        dateCreator = checkNotNull(aDateCreator, "aDateCreator cannot be null");
        console = checkNotNull(aConsole, "aConsole cannot be null");
    }

    @Override
    public void deposit(final double aDeposit) {
        statement.addOperation(dateCreator.now(), aDeposit);
    }

    @Override
    public void withdraw(final double aWithDraw) {
        deposit(-aWithDraw);
    }

    @Override
    public void printStatement() {
       console.print(statement);
    }
}
