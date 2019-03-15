package atm;

import static atm.AtmInterface.n;

import java.util.Arrays;


class Account {

	private int[] cardNumber ;
	private int[] pin; 
	private String[] history = new String[n];
	private double balance;


	Account(int[] cardNumber, int[] pinCode, double initialBalance) {
		if (initialBalance > 0.0) {
			this.balance = initialBalance;
			this.setHistory(initialBalance + "\t" + "Cr");
		}
		this.cardNumber = Arrays.copyOf(cardNumber, cardNumber.length) ;
		this.pin = Arrays.copyOf(pinCode, pinCode.length) ;
	}

	void setPin(int[] newPin) {
		this.pin = Arrays.copyOf(newPin, newPin.length) ;
	}

	boolean checkPin(int[] pin) {
		return Arrays.equals(pin, this.pin);
	}

	void setBalance(double balance) {
		this.balance = balance;
	}

	double getBalance() {
		return balance;
	}

	void changeBalance(double balance) {
		this.balance += balance;
	}

	boolean checkCardNumber(int[] cardNumber) {
		return Arrays.equals(cardNumber, this.cardNumber);
	}

	void setHistory(String history) {
		// shifting all transactions
		if (this.history[0] != null) {
			System.arraycopy(this.history, 0, this.history, 1, n - 1);
		}
		// last history is then inserted in array index 0
		this.history[0] = history;
	}
	
	int[] getCardNumber() {
		return cardNumber;
	}
	int[] getPinNumber() {
		return pin;
	}

	String getHistory(int n) {
		return history[n];
	}

}
