package com.multithreading;
/**
 * https://www.javatpoint.com/inter-thread-communication-example
 * @author Devendra Singraul
 *
 */
public class InterThreadComm {
	public static void main(String args[]) {
		final CustomerDemo c = new CustomerDemo();
		// creating 1st thread
		new Thread() {
			public void run() {
				c.withdraw(15000);
			}
		}.start();

		// creating 2nd thread
		new Thread() {
			public void run() {
				c.deposit(10000);
			}
		}.start();

	}

}

class CustomerDemo {
	int amount = 10000;

	synchronized void withdraw(int amount) {
		System.out.println("going to withdraw...");

		if (this.amount < amount) {
			System.out.println("Less balance; waiting for deposit...");
			try {
				wait();
			} catch (Exception e) {
			}
		}
		this.amount -= amount;
		System.out.println("withdraw completed...");
	}

	synchronized void deposit(int amount) {
		System.out.println("going to deposit...");
		this.amount += amount;
		System.out.println("deposit completed... ");
		notify();
	}
}
