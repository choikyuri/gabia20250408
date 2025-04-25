package project1.edit_student;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import javaswingdev.GradientDropdownMenu;
import javaswingdev.MenuEvent;
import project1.Addgul;
import project1.SelectTeam1;
import project1.SelectTeam2;
import project1.SelectTeam3;
import project1.SelectTeam4;
import project1.SelectTeam5;
import project1.demerit;
import project1.resetPoint;
import project1.sub;
import project1.dice.Dice;
import project1.edit_student.EditButton.Main5_2;
import project1.horse.MainHorse;
import project1.random_name.Ran;
import project1.wheel.MainWheel;

public class Addgul2 extends JFrame implements ActionListener {

	JButton[] jbtn;
	static ArrayList<String> arraylist_total = new ArrayList<>();
	static final int teamnumber=5;
	
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
	
	public Addgul2() {
		Connection con = null;
		PreparedStatement select= null;
		ResultSet rs = null;
		
		// 학생 이름 담는 배열
		ArrayList<String> arraylist = new ArrayList<>();

		// 버튼 붙일 패널
		ImagePanel jp = new ImagePanel(new ImageIcon("image/human_edit.png").getImage());
		jp.setSize(850, 850);
		jp.setVisible(true);
		
		JButton create_btn = new JButton("학생 추가");
		create_btn.setBounds(25, 100, 100, 30);
		create_btn.setVisible(true);
		create_btn.setFont(new Font("함초롱바탕", Font.BOLD, 15));
		jp.add(create_btn);
		
		create_btn.setUI(new StyledButtonUI());
		create_btn.setForeground(Color.white); // 폰트 컬러
		create_btn.setBackground(Color.black);
		
		create_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Create_student();
			}
		});
		
		// 드랍다운 메뉴바
		GradientDropdownMenu menu = new GradientDropdownMenu();
		menu.setMenuHeight(70);
		menu.setGradientColor(new Color(230, 58, 58), new Color(200, 150, 30));
		menu.setBackground(new Color(0, 0, 0));
		menu.setHeaderGradient(true);
		menu.addItem("Home");
		menu.addItem(" ");
		menu.addItem("관리대장", "귤", "학생");
		menu.addItem("팀별 현황", "팀1", "팀2", "팀3", "팀4", "팀5");
		menu.addItem("포인트 게임", "랜덤 박스", "주사위", "경마");
		menu.addItem("테마", "Black", "Orange", "Green");
		menu.addItem("관리자 설정", "학생 편집", "포인트 리셋");
		menu.setFont(new Font("함초롱바탕", Font.BOLD, 15));
		menu.applay(this);
		menu.addEvent((MenuEvent) new MenuEvent() {
			@Override
			public void selected(int index, int subIndex, boolean menuItem) {
				if (menuItem) {

					if (menu.getMenuNameAt(index, subIndex).trim().equals("Home")) {
						dispose();
						new sub();
					}
					if (menu.getMenuNameAt(index, subIndex).trim().equals("귤")) {
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
					if (menu.getMenuNameAt(index, subIndex).trim().equals("Black")) {
						menu.setBackground(new Color(0, 0, 0));
					}
					if (menu.getMenuNameAt(index, subIndex).trim().equals("Orange")) {
						menu.setBackground(new Color(230, 100, 10));
					}
					if (menu.getMenuNameAt(index, subIndex).trim().equals("Green")) {
						menu.setBackground(new Color(25, 51, 0));
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
		
		try {
			con = getConnection();
			int x=80, y=300; // 버튼 좌표
			
			// 프레임 셋팅
			setBounds(0, 0, 850, 850); // (x, y): 화면에서 프레임 창 위치 (w, h): 프레임 창 크기
			setVisible(true);
			setLocationRelativeTo(null);
			setResizable(false);
			
			for (int j=0; j<teamnumber; j++) { // 팀 개수 만큼 반복
				String sql = "select studentname from team"+(j+1) + "Version2 order by studentno asc";
				select = con.prepareStatement(sql);
				rs = select.executeQuery();
				
				while (rs.next()) {
					arraylist.add(rs.getString("studentname"));
					arraylist_total.add(rs.getString("studentname"));
				}
				
				jbtn = new JButton[arraylist.size()]; // 각 팀원 수 마다 버튼배열 객체 생성해서 원소로 팀원버튼 각각 생성
				
				// 귤 줄 이름 버튼 나열 및 액션리스너
				for (int i=0; i<arraylist.size(); i++, x+=115) { // 팀원 수 만큼 반복
					Font font = new Font("함초롱바탕", Font.BOLD, 15); 
					jbtn[i] = new JButton(arraylist.get(i));
					jbtn[i].setBounds(x, y, 90, 30);
					jbtn[i].setFont(font); // 폰트 설정
					jbtn[i].setForeground(Color.black); // 폰트 컬러
					jbtn[i].setUI(new StyledButtonUI()); // 버튼디자인UI 설정
					jp.add(jbtn[i]);
					jbtn[i].addActionListener(this); // 이벤트 메소드 호출
				} // 팀원 수 만큼 반복문
				y += 100; // y좌표는 한 팀씩 반복이 끝나면 밑으로 내려와서 다시 출력해야 하므로 증가
				x = 80; // x좌표는 처음시작 위치로 변경
				arraylist.clear(); // 한 팀씩 반복이 끝나면 이름을 새로 받기위해 초기화
				
			} // 팀 개수만큼 반복문

			add(jp); // 패널 프레임에 부착
			
			addWindowListener(new WindowAdapter() {
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
			
		} // finally
		
	} // Addgul()
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		EditButton.check_team("개발자"); // team(1~5)_namelist 갱신
		
		if ( EditButton.team1_namelist.contains(e.getActionCommand()) ) {
			EditButton.student_index = arraylist_total.indexOf(e.getActionCommand());
			EditButton.student_name = e.getActionCommand();
			new Main5_2();
		} else if ( EditButton.team2_namelist.contains(e.getActionCommand()) ) {
			EditButton.student_index = arraylist_total.indexOf(e.getActionCommand());
			EditButton.student_name = e.getActionCommand();
			new Main5_2();
		} else if ( EditButton.team3_namelist.contains(e.getActionCommand()) ) {
			EditButton.student_index = arraylist_total.indexOf(e.getActionCommand());
			EditButton.student_name = e.getActionCommand();
			new Main5_2();
		} else if ( EditButton.team4_namelist.contains(e.getActionCommand()) ) {
			EditButton.student_index = arraylist_total.indexOf(e.getActionCommand());
			EditButton.student_name = e.getActionCommand();
			new Main5_2();
		} else if ( EditButton.team5_namelist.contains(e.getActionCommand()) ) {
			EditButton.student_index = arraylist_total.indexOf(e.getActionCommand());
			EditButton.student_name = e.getActionCommand();
			new Main5_2();
		}
		
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
	} // ImagePanel class
	
	// 버튼 디자인
	class StyledButtonUI extends BasicButtonUI {

	    @Override
	    public void installUI (JComponent c) {
	        super.installUI(c);
	        AbstractButton button = (AbstractButton) c;
	        button.setOpaque(false);
	        button.setBorder(new EmptyBorder(5, 15, 5, 15));
	    }
	    
	    @Override
	    public void paint (Graphics g, JComponent c) {
	        AbstractButton b = (AbstractButton) c;
	        paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
	        super.paint(g, c);
	    }

	    private void paintBackground (Graphics g, JComponent c, int yOffset) {
	        Dimension size = c.getSize();
	        Graphics2D g2 = (Graphics2D) g;
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g.setColor(c.getBackground().darker());
	        g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
	        g.setColor(c.getBackground());
	        g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);
	    }
	    
	}
	
	
} // test3
