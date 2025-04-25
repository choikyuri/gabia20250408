package project1.dice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class DiceThread extends Thread {
	Dice dg; 
	JPanel panel;
	
	DiceThread(Dice dg){
		this.dg = dg; 
		panel = dg.center;
	}
	
	@Override
	public void run() {
		String title = "Random Dice";
		int count = 0;
		while(true) {
			panel.removeAll();
			JLabel lbl1 = new JLabel();
			int r = (int)(Math.random()*6 +1);
			ImageIcon icon1 = putIcon1(r);
			lbl1.setIcon(icon1);
			lbl1.setSize(icon1.getIconWidth(), icon1.getIconHeight());
			panel.add(lbl1);
			panel.updateUI();
			
			try {
				Thread.sleep(100);
			}catch(Exception e) {}
			count++;
			if(count == 15) {
				break;
			}
		}
	}

	ImageIcon putIcon1(int r) {
		ImageIcon icon = null;
		switch(r) {
		case 1: icon = new ImageIcon("image/dice/one.png");break;
		case 2: icon = new ImageIcon("image/dice/two.png");break;
		case 3: icon = new ImageIcon("image/dice/three.png");break;
		case 4: icon = new ImageIcon("image/dice/four.png");break;
		case 5: icon = new ImageIcon("image/dice/five.png");break;
		case 6: icon = new ImageIcon("image/dice/six.png");break;
		}
		return icon;
	}
}

public class Dice extends JFrame implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		dt = new DiceThread(this);
		dt.start();
	}
	
	JButton button; 
	JPanel center, south; 
	DiceThread dt;
	
	public Dice(String title) {
		super(title);
		setResizable(false);
		center = new JPanel(); 
		south = new JPanel(); 
		button = new JButton("Start"); 
		button.addActionListener(this);
		
		south.add(button);
		this.add("Center",center); 
		this.add("South", south);
		
		this.setSize(300, 300);
		this.setVisible(true);
		setLocationRelativeTo(null);
		
		// 주사위 프레임만 닫기
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

}
