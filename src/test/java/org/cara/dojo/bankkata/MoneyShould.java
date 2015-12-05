package org.cara.dojo.bankkata;

import org.fest.assertions.Assertions;
import org.junit.Test;


public class MoneyShould {

    @Test
    public void implement_Add_Operation() {
      // Given
      Money initial = new Money(13);
      Money moneyToAdd = new Money(42);

      // When
      Money actual = initial.add(moneyToAdd);

      // Then
      Assertions.assertThat(actual).isEqualTo(new Money(55));
    }

    @Test
    public void implement_Substract_Operation() {
      // Given
      Money initial = new Money(56);
      Money moneyToSubstract = new Money(17);

      // When
      Money actual = initial.substract(moneyToSubstract);

      // Then
      Assertions.assertThat(actual).isEqualTo(new Money(39));
    }
}
