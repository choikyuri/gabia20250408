package project1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javaswingdev.GradientDropdownMenu;
import javaswingdev.MenuEvent;

import project1.sub;
import project1.dice.Dice;
import project1.edit_student.Addgul2;
import project1.horse.MainHorse;
import project1.random_name.Ran;
import project1.wheel.MainWheel;

public class SelectTeam5 extends JFrame { // 팀 페이지에서 학생들 이름과 포인트 나열 (총점, 환전기능 아직 구현X)
	
	// 오라클 연동 함수
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "12345");
			return con;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public SelectTeam5() {
		Connection con = null;
		PreparedStatement select= null; // Statement는 Query 작업을 실행하기 위한 객체.
		PreparedStatement select2= null;
		ResultSet rs = null;
		
		ArrayList<String> arraylist = new ArrayList<>(); // db에서 가져온 학생이름 담을 리스트 생성 
		ArrayList<String> arraylist2 = new ArrayList<>(); // db에서 가져온 포인트점수 담을 리스트 생성
		
		int total = 0; // 총 포인트의 합을 담을 변수
		int exchangeWon = 0; // 환전해서 나온 금액
		
		
		try {
			con = getConnection(); // 연결
			String sql = "select studentname, studentpoint from team5Version2 order by studentno asc"; // sql문 - team1에서 학생들 이름을 조회해
			select = con.prepareStatement(sql); // sql을 db에 보내기 위해 객체 생성
			rs = select.executeQuery(); // sql문 실행
			while (rs.next()) { // 실행되어 반환된 결과 테이블(모양)에서 "studentname"이라는 이름의 컬럼 값을 하나씩 가져옴
				arraylist.add(rs.getString("studentname"));
				arraylist2.add(rs.getString("studentpoint"));
			}
			
			setSize(850, 850);
			setLocationRelativeTo(null);
			setLayout(null);
			setVisible(true);
			setResizable(false);
			Font font = new Font("맑은고딕", Font.BOLD, 20);
			
			ImagePanel jp = new ImagePanel(new ImageIcon("image/board.png").getImage());
			jp.setSize(850, 850);
			jp.setVisible(true);
			
			GradientDropdownMenu menu = new GradientDropdownMenu();
			menu.setMenuHeight(70);
			menu.setGradientColor(new Color(230,58,58), new Color(200,150,30));
			menu.setBackground(new Color(0,0,0));
			menu.setHeaderGradient(true);
			menu.addItem("Home");
			menu.addItem(" ");
			menu.addItem("관리대장","귤", "학생");
			menu.addItem("팀별 현황", "팀1", "팀2", "팀3", "팀4", "팀5");
			menu.addItem("포인트 게임","랜덤 박스","돌림판","경마", "주사위");
			menu.addItem("테마","Black","Orange","Green");
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
			        	if (menu.getMenuNameAt(index, subIndex).trim().equals("학생")) {
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
			
			JLabel[] jlabel = new JLabel[arraylist.size()]; // 이름을 담아서 뿌릴 JLabel 객체 arraylist의 크기만큼 생성
			JLabel[] jlabel2 = new JLabel[arraylist2.size()];
			
			Font font1 = new Font("맑은고딕", Font.BOLD, 25);
			JLabel jlabel_teamName = new JLabel("팀5");
			jlabel_teamName.setBounds(370, 20, 500, 270);
			jlabel_teamName.setFont(font1);
			jlabel_teamName.setVisible(true);
			jp.add(jlabel_teamName);
			
			for (int i=0, y=220; i<arraylist.size(); i++, y+=60) {
				jlabel[i] = new JLabel(arraylist.get(i));
				jlabel[i].setBounds(270, y, 150, 50);
				
				jlabel2[i] = new JLabel(arraylist2.get(i) + " 개");
				jlabel2[i].setBounds(520, y, 200, 50);
				
				jlabel[i].setFont(font);
				jlabel2[i].setFont(font);
				
				jp.add(jlabel[i]);
				jp.add(jlabel2[i]);
				
				add(jp);
				
				total += Integer.parseInt(arraylist2.get(i));
			}			
			
			// 총 포인트
			DecimalFormat decFormat = new DecimalFormat("###,###");
			
			String total_point = decFormat.format(total);
			JLabel total_point_jlabel = new JLabel("총 포인트 : " + total_point);
			total_point_jlabel.setBounds(350, 610, 500, 100);
			total_point_jlabel.setFont(font);
			jp.add(total_point_jlabel);
			
			String exchange_point = decFormat.format(total*300);
			JLabel exchange_point_jlabel = new JLabel("귤머니 환전: " + exchange_point);
			exchange_point_jlabel.setBounds(330, 660, 500, 100);
			exchange_point_jlabel.setFont(font);
			jp.add(exchange_point_jlabel);
			
			
			addWindowListener(new WindowAdapter() { // x로 화면닫기 구현
				@Override
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				select.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("con close에 문제 발생");
			}
		}
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
