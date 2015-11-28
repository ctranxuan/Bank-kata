using System.Collections.Generic;

namespace BankAccount
{
	public class AccountStatement : IStatement
	{
		private readonly List<StatementItem> _statement;

		public AccountStatement(List<StatementItem> statement)
		{
			_statement = statement;
		}

		public void Accept(IStatementVisitor printerVisitor)
		{
			printerVisitor.Visit(this);
			foreach (var statementItem in _statement)
			{
				statementItem.Accept(printerVisitor);
			}
		}
	}
}