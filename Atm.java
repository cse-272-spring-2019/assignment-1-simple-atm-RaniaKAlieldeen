package atm;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings({ "serial", "unused" })
public class Atm extends JFrame {

	public static void main(String[] args){
		
		
		/*
		int[] card = { 1, 1, 1, 1, 2, 2, 2, 2, 3, 3 };
		int[] pin = { 0, 0, 0, 0 };
		Account account = new Account(card, pin, 0);
		//Account account = new Account(1065649569,0000,0) ;
		
		
		Transaction t = new Transaction();
		Scanner input = new Scanner(System.in);
		System.out.println("enter card number: ");
		
		String cardNumber = input.nextLine();
		int[] card1 = new int[10];
		for (int i = 0; i < cardNumber.length(); i++) {
				card1[i] = cardNumber.charAt(i)-'0';
				
		}
		
		if(t.checkCardNumber(account, card1)) {
			
		
			System.out.println("enter pin: ");
			String pinNumber = input.nextLine();
			int[] pin1 = new int[4];
			for (int i = 0; i < pinNumber.length(); i++) {
				pin1[i] = pinNumber.charAt(i)-'0';
			}
			input.close();
			
			
			if(t.checkPin(account, pin1)) {

					//t.balanceInquiry(account);
					t.deposit(account, 5000);
					t.withdraw(account, 2000);
					t.withdraw(account, 1000);
					//t.withdraw(account, 500);

					//t.deposit(account, 1000);
					t.balanceInquiry(account);
					t.previousHistory(account);
					t.previousHistory(account);
					t.nextHistory(account);
					t.nextHistory(account);
					t.miniStatement(account);
					int[] arr = {8,2,6,1}; 
					t.changePin(account, arr);
					System.out.println(t.checkPin(account, arr));

			} else {
				System.out.println("wrong pin");
			}
		} else {
			System.out.println("wrong card number");
		}*/
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new AtmHomeFrame();				
			}
		});
		

	}
	
	

	
























}
