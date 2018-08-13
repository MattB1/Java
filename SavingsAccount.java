/**
	Author: Matthew Bubb
	Date: 4th of September, 2017
 */
/**
 * SavingsAccount
 * A class that extends the BankAccount class. The SavingsAccount class 
 * has a status field isActive which represents an active or inactive account.
 * The account is active if the balance is over $25 and inactive when it is below $25.
 * Withdrawals cannot be made again until the balance is raised above $25, at which
 * point the account becomes active again.
 */

public class SavingsAccount extends BankAccount 
{
	
	/**
	 * Constructor 
	 * @param bal initialises a starting balance
	 * @param rate initialises an interest rate
	 * @param monService initialises a monthly service charge
	 */	
	
	public SavingsAccount(double bal, double rate, double monService)
	{
		super(bal, rate, monService);
	}
	
	/**
	 * isActive
	 * A method that returns the status of the account depending on the balance
	 * of the account.
	 * @return true or false
	 */
	
	public boolean isActive()
	{
		if (balance >= 25.0)
			return true;
		else
			return false;
	}
	

	/**
	 * withdraw
	 * A method that overrides the withdraw method in BankAccount. It accepts
	 * an argument of amount, determines if the account is active and only withdraws
	 * from the balance if it is indeed active.
	 * @param amount the amount to withdraw from balance
	 * 
	 */
	public void withdraw(double amount)
	{
		if (isActive() == true)
		{
			super.withdraw(amount);
			isActive();
		}

	}
	
	/**
	 * deposit
	 * A method that determines if the account is active and then adds the amount
	 * to the account.
	 */
	
	public void deposit(double amount)
	{
		if (isActive() == false)
			{
			if (amount + balance > 25)
				isActive();
				super.deposit(amount);				
			}	
		else
			super.deposit(amount);
					
	}
	
	/**
	 * monthlyProcess
	 * A method that checks the number of withdrawals. If the number of withdrawals for 
	 * the month is more than 4, a service charge of $1 for each withdrawal above 4
	 * is added to the superclass field that holds the monthly service charge. It then
	 * calls the superclass monthlyProcess, and returns the monthly service charge to
	 * the original amount.
	 */
	public void monthlyProcess()
	{
		if (numWithdraw > 4)
		{
			while (numWithdraw > 4)
			{
				monthlyServiceCharge++;
				numWithdraw--;
			}
			super.monthlyProcess();
			isActive();
			super.setMonthlyServiceCharges(monthlyServiceCharge);
		}	
		super.monthlyProcess();
		isActive();
		super.setMonthlyServiceCharges(monthlyServiceCharge);
	}
	
}
