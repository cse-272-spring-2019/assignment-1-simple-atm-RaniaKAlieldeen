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

@SuppressWarnings({ "serial", "unused" })
public class BalanceInqFrame extends JFrame {

	
	
	public BalanceInqFrame(Account account,Transaction t) {
		
		setTitle("Balance Page");
		setSize(AtmHomeFrame.size);
		setLayout(new BorderLayout());
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(AtmHomeFrame.color);
		panel.setLayout(new GridBagLayout());
		add(panel,BorderLayout.CENTER);
//-----------------------------------------------------------------------------		
		JLabel label = new JLabel("CURRENT BALANCE");
		label.setFont(new Font("calibri", Font.PLAIN, 22));
		label.setPreferredSize(new Dimension(180, 50));
		
		String str = t.balanceInquiry(account);
		JLabel balance = new JLabel(str);
		balance.setFont(new Font("calibri", Font.BOLD, 22));
		balance.setPreferredSize(new Dimension(100, 50));
//-----------------------------------------------------------------------------
		JButton back = new JButton("BACK");
		back.setPreferredSize(AtmHomeFrame.btnsize);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new MenuFrame(account,t);
			}
		});
		
//-----------------------------------------------------------------------------
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx=0;
		gc.gridy=0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets = new Insets(10,10,10,10);
		panel.add(label,gc);
		gc.gridy++;
		panel.add(balance,gc);
		gc.gridy++;
		panel.add(back,gc);
		

	}
}
