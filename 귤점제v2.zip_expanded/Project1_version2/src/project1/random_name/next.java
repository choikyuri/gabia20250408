package project1.random_name;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class next extends JFrame{
	
	private static JLabel label;
	final int teamnumber = 4;
	static ArrayList<String> names = new ArrayList<>();
	
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
	
	// 생성자
	public next() {
		
		setTitle("Random");
		JFrame frame = new JFrame();
		ImagePanel IP=new ImagePanel(new ImageIcon("image/randombox1.jpg").getImage());
		frame.setBackground(Color.WHITE); 
		frame.setSize(450,450);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		label=new JLabel();
		label.setFont(new Font("함초롱바탕", Font.BOLD, 40));
		label.setBounds(165, 173,150,100);
		frame.add(label, BorderLayout.CENTER);
	
		IP.add(label);
		frame.add(IP);
		
		// ************************** 학생이름 리스트를 가변적일 수 있도록 db에서 끌어옴 **************************
		Connection con = null;
		PreparedStatement select= null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			for (int j=0; j<teamnumber; j++) { // 팀 개수 만큼 반복
				String sql = "select studentname from team"+(j+1) + "Version2 order by studentno asc";
				select = con.prepareStatement(sql);
				rs = select.executeQuery();
				
				while (rs.next()) 
					names.add(rs.getString("studentname"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				select.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		
		// ******************************************************************************
		
		int random = (int)(Math.random()*names.size());
		
		label.setText(names.get(random));
		
	}
	class ImagePanel extends JPanel {
		private Image img;

		public ImagePanel(Image img) {
			this.img = img;
			setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setLayout(null);
		}
		
		public int getWidth() {
			return img.getWidth(null); // 이미지 가로 넓이
		}
		public int getHeight() {
			return img.getHeight(null);
		}

		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}
	
}
