package org.cara.dojo.bankkata;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.time.LocalDate;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author ctranxuan
 */
public class Statement {
    private final List<Operation> operations;
    private double balance;

    public Statement(final double aBalance) {
        balance = aBalance;
        operations = Lists.newArrayList();
    }


    public void addOperation(final LocalDate aDate, final double aAmount) {
        checkNotNull(aDate, "aDate cannot be null");
        balance = balance + aAmount;
        operations.add(new Operation(aDate, aAmount, balance));
    }

    public ImmutableList<Operation> getOperations() {
        return ImmutableList.copyOf(operations);
    }
}
