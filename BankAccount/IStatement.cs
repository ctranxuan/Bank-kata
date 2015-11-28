namespace BankAccount
{
	public interface IStatement
	{
		void Accept(IStatementVisitor printerVisitor);
	}
}