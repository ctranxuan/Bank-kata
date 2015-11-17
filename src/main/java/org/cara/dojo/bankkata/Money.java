package org.cara.dojo.bankkata;

public class Money {
  private double amount;


  public enum CURRENCY {
    EUR

  }

  public Money(double amount) {
    this.amount = amount;
  }


    public Money add(Money amountDeposit) {
      return new Money(amount + amountDeposit.amount);

  }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      long temp;
      temp = Double.doubleToLongBits(amount);
      result = prime * result + (int) (temp ^ (temp >>> 32));
      return result;
    }


    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Money other = (Money) obj;
      if (Double.doubleToLongBits(amount) != Double
          .doubleToLongBits(other.amount))
        return false;
      return true;
    }

}
