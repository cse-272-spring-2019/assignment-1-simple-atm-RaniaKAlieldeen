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
public class MiniSTFrame extends JFrame {


	public MiniSTFrame(Account account,Transaction t) {
		
		setTitle("Mini Statement Page");
		setSize(AtmHomeFrame.size);
		setLayout(new BorderLayout());
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(AtmHomeFrame.color);
//-----------------------------------------------------------------------------
		
		JLabel label = new JLabel("MINI STATEMENT");
		label.setPreferredSize(new Dimension(160,50));
		label.setFont(new Font("calibri", Font.PLAIN, 20));
		add(panel);
		
		
		String str = t.miniStatement(account);
		JLabel minist = new JLabel(str);
		//System.out.println(str);
		minist.setPreferredSize(new Dimension(160,160));
		minist.setFont(new Font("calibri", Font.PLAIN, 20));
		
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
		
		gc.anchor = GridBagConstraints.CENTER;
		gc.fill = GridBagConstraints.CENTER;
		gc.gridy=0;
		gc.gridx=0;
		panel.add(label,gc);
		gc.gridy++;
		panel.add(minist,gc);
		
		gc.gridy++;
		panel.add(back,gc);
		
		
	}
}
