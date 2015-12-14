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
    private List<Operation> operations = Lists.newArrayList();

    public void addOperation(final LocalDate aDate, final float aAmount, final float aBalance) {
        checkNotNull(aDate, "aDate cannot be null");
        operations.add(new Operation(aDate, aAmount, aBalance));
    }

    public ImmutableList<Operation> getOperations() {
        return ImmutableList.copyOf(operations);
    }
}
