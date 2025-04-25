package project1.horse;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MainHorse {

	public MainHorse() {
		
		final int WIDTH=1600;
		final int HEIGHT=800;
		
		JFrame frame=new JFrame();
		frame.setTitle("경마게임");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		
		int x=(int)(screenSize.getWidth()/2-WIDTH/2);
		int y=(int)(screenSize.getHeight()/2-HEIGHT/2);
		frame.setBounds(x, y, WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		
		RaceTrack race=new RaceTrack();
		frame.setContentPane(race);
		frame.revalidate();
		
	}


}
