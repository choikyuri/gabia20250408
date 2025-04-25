package project1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javaswingdev.GradientDropdownMenu;
import javaswingdev.MenuEvent;
import project1.dice.Dice;
import project1.edit_student.Addgul2;
import project1.horse.MainHorse;
import project1.random_name.Ran;
import project1.wheel.MainWheel;

public class sub extends JFrame{
	
	JLabel lb1;
	static String main_screen = "image/orange_center.png";
	
	public sub() {
		super("메인메뉴"); // Frame title
		setSize(850, 850);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setResizable(false);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBounds(0, 0, 850, 850);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);
		
		List<String> image = new ArrayList<>(); // 사진이름 담아놓을 리스트
		image.add("image/orange_center.png"); // 인덱스0: 귤
		image.add("image/home_bs.jpg"); // 인덱스1: 백설
		image.add("image/home_christmas.jpg"); // 인덱스2: 크리스마스 백설
		image.add("image/home_teacher.jpg"); // 인덱스3: 선생님
	
		
		ImagePanel Main1Panel = new ImagePanel(new ImageIcon(main_screen).getImage());
		Main1Panel.setBounds(0, 0, 850, 850);
		setSize(Main1Panel.getWidth(),Main1Panel.getHeight()); // 그림크기에 맞춰 프레임 가로 세로 조정
		getContentPane().add(Main1Panel);
		
		
		ImagePanel Main1Pane0 = new ImagePanel(new ImageIcon(image.get(0)).getImage());
		Main1Pane0.setBounds(0, 0, 850, 850);
		setSize(Main1Pane0.getWidth(),Main1Pane0.getHeight()); // 그림크기에 맞춰 프레임 가로 세로 조정
		getContentPane().add(Main1Pane0);
		Main1Pane0.setVisible(false);
		
		ImagePanel Main1Pane1 = new ImagePanel(new ImageIcon(image.get(1)).getImage());
		Main1Pane1.setBounds(0, 0, 850, 850);
		setSize(Main1Pane1.getWidth(),Main1Pane1.getHeight()); // 그림크기에 맞춰 프레임 가로 세로 조정
		getContentPane().add(Main1Pane1);
		Main1Pane1.setVisible(false);
		
		ImagePanel Main1Pane2 = new ImagePanel(new ImageIcon(image.get(2)).getImage());
		Main1Pane2.setBounds(0, 0, 850, 850);
		setSize(Main1Pane2.getWidth(),Main1Pane2.getHeight()); // 그림크기에 맞춰 프레임 가로 세로 조정
		getContentPane().add(Main1Pane2);
		Main1Pane2.setVisible(false);
		
		ImagePanel Main1Pane3 = new ImagePanel(new ImageIcon(image.get(3)).getImage());
		Main1Pane3.setBounds(0, 0, 850, 850);
		setSize(Main1Pane3.getWidth(),Main1Pane3.getHeight()); // 그림크기에 맞춰 프레임 가로 세로 조정
		getContentPane().add(Main1Pane3);
		Main1Pane3.setVisible(false);
		
		
		GradientDropdownMenu menu = new GradientDropdownMenu();
		menu.setMenuHeight(70);
		menu.setGradientColor(new Color(230,58,58), new Color(200,150,30));
		menu.setBackground(new Color(0,0,0));
		menu.setHeaderGradient(true);
		menu.addItem("Home");
		menu.addItem(" ");
		menu.addItem("관리대장","귤", "학생");
		menu.addItem("팀별 현황", "팀1", "팀2", "팀3", "팀4", "팀5");
		menu.addItem("포인트 게임","랜덤 박스","돌림판","경마","주사위");
		menu.addItem("테마","Black","Orange","Green","SW","X-MAS_SW","Teacher","mandarin");
		menu.addItem("관리자 설정","학생 편집","포인트 리셋");
		menu.setFont(new Font("함초롱바탕", Font.BOLD, 15));
		menu.applay(this);
		menu.addEvent((MenuEvent) new MenuEvent() {
		
		    @Override
		    public void selected(int index, int subIndex, boolean menuItem) {
		        if (menuItem) {
		            
		        	if(menu.getMenuNameAt(index, subIndex).trim().equals("Home")) {
		        		dispose();
		        		new sub();
		        	}
		        	if(menu.getMenuNameAt(index, subIndex).trim().equals("귤")) {
		        		dispose();
		        		new Addgul();
		        	}
		        	if(menu.getMenuNameAt(index, subIndex).trim().equals("학생")) {
		        		dispose();
		        		new demerit();
		        	}
		        	if (menu.getMenuNameAt(index, subIndex).trim().equals("팀1")) {
						dispose();
						new SelectTeam1();
					}
					if (menu.getMenuNameAt(index, subIndex).trim().equals("팀2")) {
						dispose();
						new SelectTeam2();
					}
					if (menu.getMenuNameAt(index, subIndex).trim().equals("팀3")) {
						dispose();
						new SelectTeam3();
					}
					if (menu.getMenuNameAt(index, subIndex).trim().equals("팀4")) {
						dispose();
						new SelectTeam4();
					}
					if (menu.getMenuNameAt(index, subIndex).trim().equals("팀5")) {
						dispose();
						new SelectTeam5();
					}
		        	if (menu.getMenuNameAt(index, subIndex).trim().equals("랜덤 박스")) {
		        		new Ran();
					}
					if (menu.getMenuNameAt(index, subIndex).trim().equals("돌림판")) {
						MainWheel wheel = new MainWheel();
						wheel.start();
					}
					if (menu.getMenuNameAt(index, subIndex).trim().equals("경마")) {
						new MainHorse();
					}
					if (menu.getMenuNameAt(index, subIndex).trim().equals("주사위")) {
						new Dice("Random Dice");
					}
		        	if(menu.getMenuNameAt(index, subIndex).trim().equals("Black")) {
		        		menu.setBackground(new Color(0,0,0));
		        	}
		        	if(menu.getMenuNameAt(index, subIndex).trim().equals("Orange")) {
		        		menu.setBackground(new Color(230,100,10));
		        	}
		        	if(menu.getMenuNameAt(index, subIndex).trim().equals("Green")) {
		        		menu.setBackground(new Color(25,51,0));
		        	}
		        	if(menu.getMenuNameAt(index, subIndex).trim().equals("SW")) {
		        		Main1Panel.setVisible(false);
		        		Main1Pane0.setVisible(false);
		        		Main1Pane1.setVisible(true);
		        		Main1Pane2.setVisible(false);
		        		Main1Pane3.setVisible(false);
		        		JOptionPane.showMessageDialog(null, "테마가  \"백설이\"로  바뀌었습니다");
		        		main_screen = image.get(1);
		        	}
		        	if(menu.getMenuNameAt(index, subIndex).trim().equals("X-MAS_SW")) {
		        		Main1Panel.setVisible(false);
		        		Main1Pane0.setVisible(false);
		        		Main1Pane1.setVisible(false);
		        		Main1Pane2.setVisible(true);
		        		Main1Pane3.setVisible(false);
		        		JOptionPane.showMessageDialog(null, "테마가  \"크리스마스\"로  바뀌었습니다");
		        		main_screen = image.get(2);
		        	}
		        	if(menu.getMenuNameAt(index, subIndex).trim().equals("Teacher")) {
		        		Main1Panel.setVisible(false);
		        		Main1Pane0.setVisible(false);
		        		Main1Pane1.setVisible(false);
		        		Main1Pane2.setVisible(false);
		        		Main1Pane3.setVisible(true);
		        		JOptionPane.showMessageDialog(null, "테마가  \"선생님\"으로  바뀌었습니다");
		        		main_screen = image.get(3);
		        	}
		        	if(menu.getMenuNameAt(index, subIndex).trim().equals("mandarin")) {
		        		Main1Panel.setVisible(false);
		        		Main1Pane0.setVisible(true);
		        		Main1Pane1.setVisible(false);
		        		Main1Pane2.setVisible(false);
		        		Main1Pane3.setVisible(false);
		        		JOptionPane.showMessageDialog(null, "테마가  \"귤\"로  바뀌었습니다");
		        		main_screen = image.get(0);
		        	}
		        	if(menu.getMenuNameAt(index, subIndex).trim().equals("학생 편집")) {
		        		dispose();
		        		new Addgul2();
		        	}
		        	if(menu.getMenuNameAt(index, subIndex).trim().equals("포인트 리셋")) {
		        		new resetPoint();
		        	}
		        }
		    }
		});
		
		//--------------------------------------------------------------------------------------
	
		setVisible(true);
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
	}
	
	private Color Color(int i, int j, int k) {
		return null;
	}

	class ImagePanel extends JPanel{
		private Image img;

		public ImagePanel(Image img) {
			this.img = img;
			setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
			setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
			setLayout(null);
		}
		
		public int getWidth() {
			return img.getWidth(null); //이미지 가로 넓이
		}
		public int getHeight() {
			return img.getHeight(null);
		}

		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}		

	
}

