using System;
using System.Collections.Generic;
using BankAccount;

namespace BankAccountTest
{
	public class StatementBuilder
	{
		private List<StatementItem> _statement = new List<StatementItem>();
		public StatementBuilder Add(string date, double amount, double balance)
		{
			_statement.Add(new StatementItem(DateTime.Parse(date), amount, balance));
			return this;
		}

		public AccountStatement Build()
		{
			return new AccountStatement(_statement);
		}
	}
}