package atm;
//import static atm.AtmInterface.n;

@SuppressWarnings("unused")
public class Transaction implements AtmInterface {

	private int current = 0;
	private int prevflag = 0;
	private int nextflag = 0;

	public boolean deposit(Account account, double amount) {
		if(amount!=0) {
		account.changeBalance(amount);
		account.setHistory(amount + "\tCr");
		return true;
		} return false;
	}

	public boolean withdraw(Account account, double amount) {
		if (amount != 0) {
			if (amount > account.getBalance()) {
				return false;
			} else {
				account.changeBalance(-amount);
				account.setHistory(amount + "\tDr");
				return true;
			}
		} return false;
	}

	public String balanceInquiry(Account account) {
		// System.out.println("Balance: " + account.getBalance());
		// account.setHistory(account.getBalance()+"\t"+"Balance Inquiry");
		String str = "" + account.getBalance();
		return str;
	}

	public String miniStatement(Account account) {

		String str = new String("<html>");
		for (int i = 0; i < n; i++) {
			if (account.getHistory(i) != null) {
				// System.out.println(account.getHistory(i));
				str += account.getHistory(i);
				str += "<br/>";
			}
		}
		// System.out.println(str);
		str += "</html>";
		return str;
	}

	public void changePin(Account account, int[] newPinCode) {
		account.setPin(newPinCode);
	}

	public String previousHistory(Account account) {
		String str = new String();
		if (prevflag == 0) {
			prevflag = 1;
			str = account.getHistory(current);
			// System.out.print(str+"\n");
			return str;
		}
		if (current < (n - 1) && account.getHistory(current + 1) != null) {
			str = account.getHistory(++current);
			// System.out.print(str+"\n");
			nextflag = 0;
			
		} else {
			// System.out.println("earliest history");
			str = "oldest history reached";
		}
		return str;

	}

	public String nextHistory(Account account) {
		String str = new String();
		if (nextflag == 0) {
			nextflag = 1;
			str = account.getHistory(current);
			// System.out.print(str+"\n");
			return str;
		}
		if (current > 0) {
			str = account.getHistory(--current);
			// System.out.print(str+"\n");
			prevflag = 0;
			
		} else {
			// System.out.println("no more previous history");
			str = "newest history reached";
			// current++;
		}
		return str;
	}

	public boolean checkPin(Account account, int[] Pin) {
		return account.checkPin(Pin);
	}

	public boolean checkCardNumber(Account account, int[] cardNumber) {
		return account.checkCardNumber(cardNumber);
	}

}
