package atm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

@SuppressWarnings({ "serial", "unused" })
public class AtmHomeFrame extends JFrame {
	int[] card = { 1, 1, 1, 1, 2, 2, 2, 2, 3, 3 };
	int[] pin = { 1, 2, 3, 4 };
	Account account = new Account(card, pin, 0);
	Transaction t = new Transaction();

	static Dimension size = new Dimension(450, 450);
	static Dimension btnsize = new Dimension(150, 50);
	static Color color = Color.LIGHT_GRAY;

	public void closeFrame() {
		this.dispose();
	}

	public AtmHomeFrame() {

		setTitle("ATM HOME PAGE");
		setSize(size);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());

		JPanel panel = new JPanel(new GridBagLayout());

		add(panel);
		panel.setBackground(color);
		GridBagConstraints gc = new GridBagConstraints();
//-----------------------------------------------------------------------------
		JLabel welcomelbl = new JLabel(" Welcome To ATM Prototype");
		welcomelbl.setFont(new Font("calibri", Font.BOLD, 20));
		welcomelbl.setPreferredSize(new Dimension(250, 50));

		JLabel cardlbl = new JLabel(" CARD NUMBER");
		cardlbl.setFont(new Font("calibri", Font.PLAIN, 22));
		cardlbl.setPreferredSize(new Dimension(150, 50));

		JTextField cardField = new JTextField();
		cardField.setPreferredSize(new Dimension(130, 30));
		cardField.setFont(new Font("calibri", Font.PLAIN, 20));

		JLabel error = new JLabel("ERROR: Incorrect Card Number");
		error.setPreferredSize(new Dimension(200, 50));
		error.setForeground(Color.YELLOW);
		error.setVisible(false);
		error.setFont(new Font("calibri", Font.PLAIN, 15));

		JLabel error2 = new JLabel("ERROR: Incorrect Input Format");
		error2.setPreferredSize(new Dimension(200, 50));
		error2.setForeground(Color.RED);
		error2.setVisible(false);
		error2.setFont(new Font("calibri", Font.BOLD, 15));
//------------------------------------------------------------------------------
		JButton enterButton = new JButton("ENTER");
		enterButton.setPreferredSize(btnsize);
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cardString = cardField.getText();
				try {

					int[] card = new int[10];
					for (int i = 0; i < cardString.length(); i++) {
						card[i] = cardString.charAt(i) - '0';
					}
					if (t.checkCardNumber(account, card)) {
						setVisible(false);
						new PinFrame(account, t);
					} else {
						error2.setVisible(false);
						error.setVisible(true);
					}
				} catch (NumberFormatException e1) {
					error2.setVisible(true);
					error.setVisible(false);
				}catch (IndexOutOfBoundsException e1) {
					error.setVisible(true);
					error2.setVisible(false);
				}
			}
		});

		JButton exit = new JButton("EXIT");
		exit.setPreferredSize(btnsize);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeFrame();
			}
		});

//---------------------------------------------------------------------------------
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 2;
		gc.insets = new Insets(10, 10, 10, 10);
		panel.add(welcomelbl, gc);
		gc.gridy++;
		panel.add(cardlbl, gc);
		gc.gridy++;
		panel.add(cardField, gc);
		gc.gridy++;
		panel.add(enterButton, gc);
		gc.gridy++;
		panel.add(exit, gc);
		gc.gridy++;
		panel.add(error, gc);
		panel.add(error2, gc);

	}

}
