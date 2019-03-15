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
public class DepositFrame extends JFrame {

	public DepositFrame(Account account, Transaction t) {

		//setting the frame and panel
		setTitle("Deposit Page");
		setSize(AtmHomeFrame.size);
		setLayout(new BorderLayout());// layout for the frame
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(AtmHomeFrame.color);
		add(panel);
		GridBagConstraints gc = new GridBagConstraints();
//---------------------------------------------------------------------------------
		//creating components on panel
		JLabel label = new JLabel("DEPOSIT AMOUNT");
		label.setPreferredSize(new Dimension(160, 50));
		label.setFont(new Font("calibri", Font.PLAIN, 20));

		JLabel done = new JLabel("Deposit successful");
		done.setPreferredSize(new Dimension(160, 50));
		done.setVisible(false);
		done.setFont(new Font("calibri", Font.PLAIN, 20));

		JLabel error = new JLabel("ERROR: Invalid Amount");
		error.setPreferredSize(new Dimension(200, 50));
		error.setForeground(Color.YELLOW);
		error.setVisible(false);
		error.setFont(new Font("calibri", Font.PLAIN, 20));

		JLabel error2 = new JLabel("ERROR: Incorrect Input Format");
		error2.setPreferredSize(new Dimension(200, 50));
		error2.setForeground(Color.RED);
		error2.setVisible(false);
		error2.setFont(new Font("calibri", Font.PLAIN, 17));

		JTextField amountField = new JTextField();
		amountField.setPreferredSize(new Dimension(80, 50));
		amountField.setFont(new Font("calibri", Font.PLAIN, 20));
//----------------------------------------------------------------------------------
		//buttons and their event handling
		JButton enterButton = new JButton("ENTER");
		enterButton.setPreferredSize(AtmHomeFrame.btnsize);
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String amountTxt = amountField.getText();
				// double amount = 0;
				try {
					double amount = Double.parseDouble(amountTxt);
					if (t.deposit(account, amount)) {
						done.setVisible(true);
						error2.setVisible(false);
						error.setVisible(false);
					} else {
						error.setVisible(true);
						error2.setVisible(false);
						done.setVisible(false);
					}
				} catch (NumberFormatException e1) {
					error2.setVisible(true);
					done.setVisible(false);
					error.setVisible(false);
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
//-----------------------------------------------------------------------------------
		//layout components in panel
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 2;
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
		panel.add(error2, gc);
		panel.add(error, gc);

	}
}
