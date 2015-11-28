using BankAccount;
using FakeItEasy;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace BankAccountTest
{
	[TestClass]
	public class PrintServiceShould
	{
		private IPrinter _printer =  A.Fake<IPrinter>();
		private IStatementProvider _statementService;

		[TestInitialize]
		public void TestInitialize()
		{
			_statementService = A.Fake<IStatementProvider>();
		}

		[TestMethod]
		public void print_header()
		{
			var printService = Create();
			
			printService.PrintStatement();

			A.CallTo(() => _printer.WriteLine("DATE|AMOUNT|BALANCE")).MustHaveHappened(Repeated.Exactly.Once);
		}

		[TestMethod]
		public void print_deposit_operation()
		{
			var statement = new StatementBuilder()
				.Add("10/11/2015", 100.0, 200.0)
				.Add("09/11/2015", 100.0, 100.0)
				.Build();
			A.CallTo(() => _statementService.GetStatements()).Returns(statement);

			var printService = Create();

			using (var scope = Fake.CreateScope())
			{
				printService.PrintStatement();

				using (scope.OrderedAssertions())
				{
					A.CallTo(() => _printer.WriteLine("DATE|AMOUNT|BALANCE")).MustHaveHappened(Repeated.Exactly.Once);
					A.CallTo(() => _printer.WriteLine("10/11/2015|100.00|200.00")).MustHaveHappened(Repeated.Exactly.Once);
					A.CallTo(() => _printer.WriteLine("09/11/2015|100.00|100.00")).MustHaveHappened(Repeated.Exactly.Once);
				}
			}	
		}

		private PrintService Create()
		{
			var printService = new PrintService(_printer, _statementService);
			return printService;
		}
	}
}