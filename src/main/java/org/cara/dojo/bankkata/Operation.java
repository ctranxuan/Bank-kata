package org.cara.dojo.bankkata;

import java.time.LocalDate;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author ctranxuan
 */
public class Operation {
    private final LocalDate date;
    private final float amount;
    private final float balance;

    public Operation(final LocalDate aDate, final float aAmount, final float aBalance) {
        date = checkNotNull(aDate, "aDate cannot be null");
        amount = aAmount;
        balance = aBalance;
    }

    public LocalDate getDate() {
        return date;
    }

    public float getAmount() {
        return amount;
    }

    public float getBalance() {
        return balance;
    }
}
