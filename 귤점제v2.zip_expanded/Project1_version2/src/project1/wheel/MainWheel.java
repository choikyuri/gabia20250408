package project1.wheel;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainWheel extends Thread {
	
	final int teamnumber = 5;
	static ArrayList<String> arraylist_total = new ArrayList<>();

	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "12345");
			System.out.println("Addgul DB연결 성공");
			return con;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public void run() {
		
		try {
			int width = 1000, height = 1000;
			
			JFrame frame = new JFrame();
			frame.setResizable(false);
			
			// 돌림판 프레임만 닫기
			frame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					frame.dispose();
				}
			});
			
			Connection con = null;
			PreparedStatement select= null;
			ResultSet rs = null;
			
			con = getConnection();
			
			for (int j=0; j<teamnumber; j++) { // 팀 개수 만큼 반복
				String sql = "select studentname from team"+(j+1) + "Version2 order by studentno asc";
				select = con.prepareStatement(sql);
				rs = select.executeQuery();
				
				while (rs.next()) 
					arraylist_total.add(rs.getString("studentname"));
			}
			
			SelectionWheel wheel = new SelectionWheel(arraylist_total);
			wheel.hasBorders(true);
			wheel.setBounds(10, 10, 700, 700);
			
			
			JLabel lbl1 = new JLabel("Selection: ");
			JLabel lbl2 = new JLabel("Angle: ");
			JLabel lbl3 = new JLabel("Speed: ");
			JLabel lblsel = new JLabel("(selection)");
			JLabel lblang = new JLabel("(angle)");
			JLabel lblsp = new JLabel("(speed)");
			lbl1.setBounds(720, 10, 100, 20);
			lblsel.setBounds(830, 10, 150, 20);
			lbl2.setBounds(720, 30, 100, 20);
			lblang.setBounds(830, 30, 150, 20);
			lbl3.setBounds(720, 50, 100, 20);
			lblsp.setBounds(830, 50, 150, 20);
			frame.add(wheel);
			frame.add(lbl1);
			frame.add(lblsel);
			frame.add(lbl2);
			frame.add(lblang);
			frame.add(lbl3);
			frame.add(lblsp);
			frame.setSize(width, height);
			frame.setLayout(null);
			frame.setVisible(true);
			
			lblsel.setText(wheel.getSelectedString());
			lblang.setText(Double.toString(wheel.getRotationAngle()));
			lblsp.setText(Double.toString(wheel.getSpinSpeed()));
			
			while(true) {
				// wait for action
				while(true)
				{
					lblsel.setText(wheel.getSelectedString());
					lblang.setText(Double.toString(wheel.getRotationAngle()));
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(wheel.isSpinning())
						break;
				}
				// while spinning
				while(wheel.isSpinning())
				{
					lblsel.setText(wheel.getSelectedString());
					lblang.setText(Double.toString(wheel.getRotationAngle()));
					lblsp.setText(Double.toString(wheel.getSpinSpeed()));
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				lblsp.setText(Double.toString(wheel.getSpinSpeed()));
				// show selection
				JOptionPane.showMessageDialog(frame, "Selection: " + wheel.getSelectedString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
