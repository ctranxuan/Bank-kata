using System;

namespace BankAccount
{
	public class StatementItem : IStatement
	{
		public DateTime Time { get; private set; }
		public double Amount { get; private set; }
		public double Balance { get; private set; }

		public StatementItem(DateTime dateTime, double amount, double balance)
		{
			Time = dateTime;
			Amount = amount;
			Balance = balance;
		}

		public void Accept(IStatementVisitor printerVisitor)
		{
			printerVisitor.Visit(this);
		}
	}
}