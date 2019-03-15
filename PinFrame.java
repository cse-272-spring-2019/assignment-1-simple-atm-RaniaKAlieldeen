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
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class PinFrame extends JFrame {

	public PinFrame(Account account, Transaction t) {

		setTitle("PIN PAGE");
		setSize(AtmHomeFrame.size);
		setLayout(new BorderLayout());
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(AtmHomeFrame.color);
		add(panel, BorderLayout.CENTER);
//-----------------------------------------------------------------------------

		JLabel label = new JLabel("PIN CODE");
		label.setFont(new Font("calibri", Font.PLAIN, 22));
		label.setPreferredSize(new Dimension(88, 50));

		JPasswordField pinField = new JPasswordField();
		pinField.setPreferredSize(new Dimension(50, 30));
		pinField.setFont(new Font("calibri", Font.PLAIN, 22));

		JLabel error = new JLabel("ERROR: Incorrect Pin");
		error.setVisible(false);
		error.setForeground(Color.YELLOW);
		error.setFont(new Font("calibri", Font.BOLD, 15));

		JLabel error2 = new JLabel("ERROR: Incorrect Input Format");
		error2.setPreferredSize(new Dimension(200, 50));
		error2.setForeground(Color.RED);
		error2.setVisible(false);
		error2.setFont(new Font("calibri", Font.PLAIN, 15));
//-----------------------------------------------------------------------------
		JButton enterButton = new JButton("ENTER");
		enterButton.setPreferredSize(AtmHomeFrame.btnsize);
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				char[] password = pinField.getPassword();
				try {
					int[] pincode = new int[4];
					for (int i = 0; i < password.length; i++)
						pincode[i] = password[i] - '0';
					if (t.checkPin(account, pincode)) {
						setVisible(false);
						new MenuFrame(account, t);
					} else {
						error.setVisible(true);
						error2.setVisible(false);
					}
				} catch (NumberFormatException e1) {
					error2.setVisible(true);
					error.setVisible(false);
				} catch (IndexOutOfBoundsException e1) {
					error.setVisible(true);
					error2.setVisible(false);
				}
			}

		});

		JButton back = new JButton("BACK");
		back.setPreferredSize(AtmHomeFrame.btnsize);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AtmHomeFrame();
			}
		});
//-----------------------------------------------------------------------------
		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 2;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets = new Insets(10, 10, 10, 10);
		panel.add(label, gc);
		gc.gridy++;
		panel.add(pinField, gc);
		gc.gridy++;
		panel.add(enterButton, gc);
		gc.gridy++;
		panel.add(back, gc);
		gc.gridy++;
		panel.add(error, gc);
		panel.add(error2, gc);

	}
}
