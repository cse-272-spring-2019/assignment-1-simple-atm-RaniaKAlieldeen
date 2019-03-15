package atm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings({ "serial", "unused" })
public class HistoryFrame extends JFrame {

	
	public HistoryFrame(Account account,Transaction t, int flag) {
		
		setTitle("History Page");
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
		
		JLabel label = new JLabel("HISTORY");
		label.setPreferredSize(new Dimension(80,50));
		label.setFont(new Font("calibri", Font.PLAIN, 20));
		
		String str1 = new String();//t.previousHistory(account);
		final JLabel prev = new JLabel(str1);
		prev.setPreferredSize(new Dimension(200,50));
		prev.setFont(new Font("calibri", Font.PLAIN, 20));
		
		String str2 = new String();//t.nextHistory(account);
		final JLabel next = new JLabel(str2);
		next.setPreferredSize(new Dimension(200,50));
		next.setFont(new Font("calibri", Font.PLAIN, 20));
		
//-----------------------------------------------------------------------------
		
		if(flag ==0)
			next.setVisible(false);
		else
			prev.setVisible(false);
		
		JButton prevB = new JButton("PREV");
		prevB.setPreferredSize(AtmHomeFrame.btnsize);
		prevB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = t.previousHistory(account);
				prev.setText(str);
				prev.setVisible(true);
				next.setVisible(false);
				
			}
			
		});
		
//-------------------------------------------------------------------------

		
		
		JButton nextB = new JButton("NEXT");
		nextB.setPreferredSize(AtmHomeFrame.btnsize);
		nextB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = t.nextHistory(account);
				next.setText(str);
				prev.setVisible(false);
				next.setVisible(true);
			}
		});

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
		gc.insets = new Insets(10, 10, 10, 10);
		panel.add(label,gc);
		gc.gridy ++;
		panel.add(prev,gc);
		panel.add(next,gc);
		gc.gridy ++;
		panel.add(prevB,gc);
		gc.gridx ++;
		panel.add(nextB,gc);
		gc.gridy ++;
		gc.gridx --;
		gc.gridwidth = 3;
		panel.add(back,gc);
		

		
	}
}
