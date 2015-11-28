using System;
using System.Text;
using System.Collections.Generic;
using System.Runtime.InteropServices;
using BankAccount;
using FakeItEasy;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace BankAccountTest
{
	[TestClass]
	public class AccountServiceShould
	{
		private IOperationService _operationService;
		private IPrintService _printService;

		private AccountService Create()
		{
			var accountService = new AccountService(_operationService, _printService);
			return accountService;
		}

		[TestInitialize]
		public void TestInitialize()
		{
			_operationService = A.Fake<IOperationService>();
			_printService = A.Fake<IPrintService>();
		}

		[TestMethod]
		public void store_deposit_operation()
		{
			var accountService = Create();

			// when
			int amount = 100;
			accountService.Deposit(amount);

			// then
			A.CallTo(() => _operationService.StoreDeposit(amount)).MustHaveHappened(Repeated.Exactly.Once);
		}

		[TestMethod]
		public void store_withdraw_operation()
		{
			var accountService = Create();

			// when
			int amount = 100;
			accountService.Withdraw(amount);

			// then
			A.CallTo(() => _operationService.StoreWithdraw(amount)).MustHaveHappened(Repeated.Exactly.Once);
		}

		[TestMethod]
		public void tells_to_printservice_to_printstatement()
		{
			var accountServce = Create();

			accountServce.PrintStatement();

			A.CallTo(() => _printService.PrintStatement()).MustHaveHappened(Repeated.Exactly.Once);
		}
	}
}
