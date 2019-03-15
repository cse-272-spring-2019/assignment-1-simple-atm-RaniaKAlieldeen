package atm;
@SuppressWarnings("unused")

public interface AtmInterface {
	int n = 5;
	int accountInfo = 7;//5 history, 1 card number, 1 balance
	boolean deposit(Account account,double amount);
	boolean withdraw(Account account,double amount);
	String balanceInquiry(Account account);
	String previousHistory(Account account);
	String nextHistory(Account account);
	String miniStatement(Account account);
	void changePin(Account account, int[] newPinCode);
	boolean checkPin(Account account, int[] PinCode);
	boolean checkCardNumber(Account account,int[] cardNumber);
	}
