package org.cara.dojo.bankkata;

import java.time.LocalDate;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author ctranxuan
 */
public class Operation {
    private final LocalDate date;
    private final double amount;
    private final double balance;

    public Operation(final LocalDate aDate, final double aAmount, final double aBalance) {
        date = checkNotNull(aDate, "aDate cannot be null");
        amount = aAmount;
        balance = aBalance;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "date=" + date +
                ", amount=" + amount +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(final Object aO) {
        if (this == aO) return true;
        if (aO == null || getClass() != aO.getClass()) return false;
        Operation operation = (Operation) aO;
        return Double.compare(operation.amount, amount) == 0 &&
                Double.compare(operation.balance, balance) == 0 &&
                Objects.equals(date, operation.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, balance);
    }
}
