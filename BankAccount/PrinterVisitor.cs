using System;
using System.Globalization;

namespace BankAccount
{
	public class PrinterVisitor : IStatementVisitor
	{
		private readonly IPrinter _printer;

		public PrinterVisitor(IPrinter printer)
		{
			_printer = printer;
		}

		public void Visit(AccountStatement accountStatement)
		{
			_printer.WriteLine("DATE|AMOUNT|BALANCE");
		}

		public void Visit(StatementItem statementItem)
		{
			_printer.WriteLine(String.Format("{0:d}|{1}|{2}", statementItem.Time, statementItem.Amount.ToString("F2", new CultureInfo("en-us")), statementItem.Balance.ToString("F2", new CultureInfo("en-us"))));
		}
	}
}