package atm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings({ "serial", "unused" })
public class MenuFrame extends JFrame {

	public MenuFrame(Account account, Transaction t) {

		setTitle("MENU PAGE");
		setSize(AtmHomeFrame.size);
		setLayout(new BorderLayout());
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel(new GridBagLayout());
		add(panel, BorderLayout.CENTER);
		panel.setBackground(AtmHomeFrame.color);
//-----------------------------------------------------------------------------
		JButton withdrawB = new JButton("WITHDRAW");
		withdrawB.setPreferredSize(AtmHomeFrame.btnsize);
		withdrawB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new WithdrawFrame(account, t);
			}
		});

		JButton depositB = new JButton("DEPOSIT");
		depositB.setPreferredSize(AtmHomeFrame.btnsize);
		depositB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new DepositFrame(account, t);
			}
		});
		JButton miniStatB = new JButton("MINI STATEMENT");
		miniStatB.setPreferredSize(AtmHomeFrame.btnsize);
		miniStatB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new MiniSTFrame(account, t);
			}
		});

		JButton balanceB = new JButton("BALANCE");
		balanceB.setPreferredSize(AtmHomeFrame.btnsize);
		balanceB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new BalanceInqFrame(account, t);
			}
		});

		JButton prevB = new JButton("PREV");
		prevB.setPreferredSize(AtmHomeFrame.btnsize);
		prevB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new HistoryFrame(account, t, 0);
			}
		});
		JButton nextB = new JButton("NEXT");
		nextB.setPreferredSize(AtmHomeFrame.btnsize);
		nextB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new HistoryFrame(account, t, 1);
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
		gc.insets = new Insets(20, 20, 20, 20);
		gc.anchor = GridBagConstraints.LINE_START;
		panel.add(withdrawB, gc);
		gc.gridy++;
		panel.add(depositB, gc);
		gc.gridy++;
		panel.add(miniStatB, gc);
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		panel.add(nextB, gc);
		gc.gridy++;
		panel.add(prevB, gc);
		gc.gridy++;
		panel.add(balanceB, gc);
		gc.gridy++;
		panel.add(back, gc);
		// pack();

	}
}
