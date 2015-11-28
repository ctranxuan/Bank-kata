namespace BankAccount
{
	public interface IStatementVisitor
	{
		void Visit(AccountStatement accountStatement);
		void Visit(StatementItem statementItem);
	}
}