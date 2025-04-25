package project1.random_name;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ran extends JFrame{
	
	public Ran() {
		
		JFrame frame = new JFrame("test");
		frame.setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		frame.setSize(450, 450);
		frame.setResizable(false);
		
		JPanel panel=new JPanel();
		panel.setLayout(null);
		panel.add(new JButton("랜덤박스"));
		frame.add(panel);
		frame.setLocationRelativeTo(null);

		JButton button=new JButton(new ImageIcon("image/ran.png"));
		button.setBounds(17, 5, 400, 400);
		frame.add(button);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new next();
				
			}
		});
		
	}

}
