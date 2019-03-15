package atm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class WithdrawFrame extends JFrame {

	public WithdrawFrame(Account account, Transaction t) {

		setTitle("Withdraw Page");
		setSize(AtmHomeFrame.size);
		setLayout(new BorderLayout());
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(AtmHomeFrame.color);
		add(panel);
		GridBagConstraints gc = new GridBagConstraints();
//---------------------------------------------------------------------------------
		JLabel label = new JLabel("WITHDRAW AMOUNT");
		label.setPreferredSize(new Dimension(190, 50));
		label.setFont(new Font("calibri", Font.PLAIN, 20));

		JLabel done = new JLabel("Withdraw Successful");
		done.setVisible(false);
		done.setFont(new Font("calibri", Font.PLAIN, 17));

		JLabel error = new JLabel("ERROR: Invalid Amount");
		error.setVisible(false);
		error.setFont(new Font("calibri", Font.PLAIN, 17));
		error.setForeground(Color.YELLOW);

		JLabel error2 = new JLabel("ERROR! Wrong Input Format");
		error2.setVisible(false);
		error2.setFont(new Font("calibri", Font.PLAIN, 17));
		error2.setForeground(Color.RED);

		JTextField amountField = new JTextField();
		amountField.setPreferredSize(new Dimension(80, 50));
		amountField.setFont(new Font("calibri", Font.PLAIN, 20));
//---------------------------------------------------------------------------------
		JButton enterButton = new JButton("ENTER");
		enterButton.setPreferredSize(AtmHomeFrame.btnsize);
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String amountTxt = amountField.getText();
				try {
					double amount = Double.parseDouble(amountTxt);
					if (t.withdraw(account, amount)) {
						done.setVisible(true);
						error2.setVisible(false);
						error.setVisible(false);
					} else {
						error.setVisible(true);
						error2.setVisible(false);
					}
				} catch (NumberFormatException e1) {
					error2.setVisible(true);
					error.setVisible(false);
					done.setVisible(false);
				}

			}
		});

		JButton back = new JButton("BACK");
		back.setPreferredSize(AtmHomeFrame.btnsize);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new MenuFrame(account, t);
			}
		});
//---------------------------------------------------------------------------------
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets = new Insets(10, 10, 10, 10);
		panel.add(label, gc);
		gc.gridy++;
		panel.add(amountField, gc);
		gc.gridy++;
		panel.add(enterButton, gc);
		gc.gridy++;
		panel.add(back, gc);
		gc.gridy++;
		panel.add(done, gc);
		panel.add(error, gc);
		panel.add(error2, gc);

	}

}
