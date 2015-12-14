package org.cara.dojo.bankkata;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;

import java.time.LocalDate;

/**
 * @author ctranxuan
 */
class DateCreator implements IDateCreator {

    private final UnmodifiableIterator<LocalDate> iterator;

    public DateCreator(LocalDate... aDates) {
        iterator = ImmutableList.copyOf(aDates).iterator();
    }
    @Override
    public LocalDate now() {
        return iterator.next();
    }
}
