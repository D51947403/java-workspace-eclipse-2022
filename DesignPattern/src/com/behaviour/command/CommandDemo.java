package com.behaviour.command;

import java.util.Collections;

import com.sun.tools.javac.util.List;

class BankAccount {
	private int balance;
	private int overdraftLimit = -500;

	public void deposite(int amount) {
		balance += amount;
		System.out.println("Deposited " + amount + " Now Balance is " + balance);
	}

	public boolean withdraw(int amount) {
		if (balance - amount >= overdraftLimit) {
			balance -= amount;
			System.out.println("Withdrew " + amount + " Now Balance is " + balance);
			return true;
		} else {
			System.out.println("Insufficient Balance" + balance+", withdraw amount is "+amount);
			return false;
		}
	}

	@Override
	public String toString() {
		return "BankAccount [balance=" + balance + "]";
	}

}

interface Command {
	void call();

	void undo();
}

class BankAccountCommand implements Command {
	private BankAccount account;
    private boolean succeeded;
	public enum Action {
		DEPOSITE, WITHDRAW
	}

	private Action action;
	private int amount;

	public BankAccountCommand(BankAccount account, Action action, int amount) {
		super();
		this.account = account;
		this.action = action;
		this.amount = amount;
	}

	@Override
	public void call() {
		switch (action) {
		case DEPOSITE:
			succeeded =true;
			account.deposite(amount);
			break;
		case WITHDRAW:
		succeeded=account.withdraw(amount);
			break;
		}
	}

	@Override
	public void undo() {
 if(!succeeded) return ;
		switch (action) {
		case DEPOSITE:
			account.withdraw(amount);
			break;
		case WITHDRAW:
			account.deposite(amount);
			break;
		}

	}

}

public class CommandDemo {

	public static void main(String[] args) {
		BankAccount ba = new BankAccount();
		System.out.println(ba);

		List<BankAccountCommand> bankCommands = List.of(
				new BankAccountCommand(ba, BankAccountCommand.Action.DEPOSITE, 100),
				new BankAccountCommand(ba, BankAccountCommand.Action.WITHDRAW, 1000));

		for (Command comm : bankCommands) {
			comm.call();
			System.out.println(ba);
		}
		System.out.println("Undo........");
		for (Command comm : bankCommands) {
			comm.undo();
			System.out.println(ba);
		}
	}
}
