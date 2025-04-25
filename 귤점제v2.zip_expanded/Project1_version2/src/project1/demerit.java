package project1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import javaswingdev.GradientDropdownMenu;
import javaswingdev.MenuEvent;
import project1.dice.Dice;
import project1.edit_student.Addgul2;
import project1.horse.MainHorse;
import project1.random_name.Ran;
import project1.wheel.MainWheel;

public class demerit extends JFrame implements ActionListener {

	JButton[] jbtn;
	TextArea area;
	JFrame fr;
	JTextField text;
	BufferedReader in;
	PrintWriter out;
	Calendar time = Calendar.getInstance();
	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

	static ArrayList<String> arraylist_total_team = new ArrayList<>();

	String format_time1 = format1.format(time.getTime());

	public static String story = null;

	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "12345");
			return con;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public demerit() {
		Connection con = null;
		PreparedStatement select = null;
		ResultSet rs = null;
		final int teamnumber = 5;

		// 학생 이름 담는 배열
		ArrayList<String> arraylist = new ArrayList<>();

		// 버튼 붙일 패널
		ImagePanel jp = new ImagePanel(new ImageIcon("image/brain.png").getImage());
		jp.setSize(850, 850);
		jp.setVisible(true);

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
		menu.addItem("포인트 게임", "랜덤 박스", "돌림판", "경마", "주사위");
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
					if (menu.getMenuNameAt(index, subIndex).trim().equals("학생 편집")) {
						dispose();
						new Addgul2();
					}
					if (menu.getMenuNameAt(index, subIndex).trim().equals("포인트 리셋")) {
						new resetPoint();
					}
				}
			}
		});

		try {
			con = getConnection();
			int x = 80, y = 250; // 버튼 좌표

			// 프레임 셋팅
			setBounds(0, 0, 850, 850); // (x, y): 화면에서 프레임 창 위치 (w, h): 프레임 창 크기
			setVisible(true);
			setLocationRelativeTo(null);
			setResizable(false);

			for (int j = 0; j < teamnumber; j++) { // 팀 개수 만큼 반복
				String sql = "select studentname from team" + (j + 1) + "Version2 order by studentno asc";
				select = con.prepareStatement(sql);
				rs = select.executeQuery();

				while (rs.next()) {
					arraylist.add(rs.getString("studentname"));
					arraylist_total_team.add(rs.getString("studentname"));
				}

				jbtn = new JButton[arraylist.size()]; // 각 팀원 수 마다 버튼배열 객체 생성해서 원소로 팀원버튼 각각 생성

				// 귤 줄 이름 버튼 나열 및 액션리스너
				for (int i = 0; i < arraylist.size(); i++, x += 115) { // 팀원 수 만큼 반복
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

		if (arraylist_total_team.contains(e.getActionCommand())) {

			area = new TextArea("\t날짜\t\t내용\n", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
			area.setEditable(false);
			area.setSize(700, 300);
			area.setFont(new Font("맑은고딕", Font.BOLD, 18));

			fr = new JFrame();
			fr.setTitle(e.getActionCommand() + " 학생");
			fr.setSize(700, 300);
			fr.setLocationRelativeTo(null);
			fr.add(area);
			fr.setVisible(true);

			fr.add(text = new JTextField(), BorderLayout.SOUTH);
			String name = e.getActionCommand();

			Connection con = null;
			PreparedStatement select = null;
			ResultSet rs = null;

			con = getConnection(); // 연결
			String sql = "select * from penaltyVersion2 where name='" + name + "'"; // sql문 - team1에서 학생들 이름을 조회해
			try {
				select = con.prepareStatement(sql);
				rs = select.executeQuery();
				while (rs.next()) {
					if (!rs.getString("story").equals("null")) {
						System.out.println(rs.getString("story"));
						area.append(rs.getString("story"));
					} else { // null일 때
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {// sql문 실행
				try {
					con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

			// text: JTextField
			// area: TextArea
			// JTextField에 값이 들어가고 엔터키를 누르면 TestArea영역에 내용이 추가됨
			text.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if (e.getKeyChar() == KeyEvent.VK_ENTER) { // 내가 땡긴 키가 Enter라면
						area.append(format_time1 + "\t" + text.getText() + "\n");
						story = format_time1 + "\t" + text.getText() + "\n";
						text.setText(""); // 텍스트필드 초기화
						text.requestFocus();

						Connection con = null;
						PreparedStatement select = null;
						ResultSet rs = null;

						con = getConnection(); // 연결
						String sql = "insert into penaltyVersion2 values('" + name + "','" + story + "')";
						try {
							select = con.prepareStatement(sql);
							rs = select.executeQuery();
						} catch (SQLException e1) {
							e1.printStackTrace();
						} finally {// sql문 실행
							try {
								con.close();
							} catch (Exception e2) {
								e2.printStackTrace();
							}
						}

					}
				}
			});

			fr.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					fr.setVisible(false);
					fr.dispose();
				}
			});
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
		public void installUI(JComponent c) {
			super.installUI(c);
			AbstractButton button = (AbstractButton) c;
			button.setOpaque(false);
			button.setBorder(new EmptyBorder(5, 15, 5, 15));
		}

		@Override
		public void paint(Graphics g, JComponent c) {
			AbstractButton b = (AbstractButton) c;
			paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
			super.paint(g, c);
		}

		private void paintBackground(Graphics g, JComponent c, int yOffset) {
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
