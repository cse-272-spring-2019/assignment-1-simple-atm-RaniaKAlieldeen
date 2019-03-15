# prog2_atm
ATM PROJECT
This is a program that acts as an ATM machine.
It has users data (currently only one) and it takes card number instead of physical card.

PAGES:

	Home Page: the first page that is shown when the program is launched, where it asks for the card number.
	if the card number is wrong, it will be display an error, otherwise it will continue to Pin Page.

	Pin Page: the page where it asks for pin number if card number was correct. If the pin is wrong, it will display 
	an error, otherwise it will continu to Menu Page.

	Menu Page: the menu page has seven buttons: (each button represents a page on its own)

			Withdraw: it takes you to withdrawal page, where you enter the amount you want to withdraw, 
			and it checks if the amount is available in account, if available, the transaction will be successful 
			and will be saved in history.

			Deposit: it takes you to deposit page, where you enter the amount you want to deposit, 
			and the transaction will be succesful and will be saved in history.

			Balance: it take you to balance inquiry page, where it shows the current available balance.
			The balance is always positive.

			MiniStatement: it takes you to mini statement page, where it shows the last 5 successful transactions.

			Next: it takes you to a history page with next and prev buttons, to toggle between 5 history transactions.
			next button allows you to go from oldest to newest history.

			Prev: it takes you to a history page with next and prev buttons, to toggle between 5 history transactions.
			prev button allows you to go from newest to oldest history.

			Back: back button in menu page page logs out the user to the home page.
					
To exit the program, simply click the x button at the top right corner, or go back to home page and click the exit button
at the bottom of the page.
# assignment-1-simple-atm-RaniaKAlieldeen
