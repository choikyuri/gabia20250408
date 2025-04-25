package project1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class random extends JFrame {

	JTextField name, age;// 클래스 변수로 선언.
	JLabel lbtitle;
	Font font = new Font("휴먼모음T", Font.PLAIN, 17);
	static int student_index;
	static String student_name;
	
	
	public static Connection getConnection() {  
		try {
			String user = "system";
			String pw = "12345";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, pw);
			System.out.println("연결성공");
			return con;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	static class Main5_1 extends JFrame {
		static int[] total = new int[30]; // 학생 수
		static int total3; //1조 총점
		static int total4; //2조 총점
		static int total5; //3조 총점
		static int total6; //4조 총점
		static int total7; //5조 총점

		// 버튼이 눌러지면 만들어지는 새 창을 정의한 클래스
		public Main5_1() {
			
			JFrame p1 = new JFrame();
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 서브 프레임 종료버튼 생성
			p1.setTitle("귤");
			p1.setBounds(100, 100, 427, 250); // 위치 설정
			p1.setLayout(new FlowLayout());
			p1.setLocationRelativeTo(null); // 화면 중앙에 띄우기
			JButton btn1 = new JButton(new ImageIcon("image/plus_gul.png")); // 아이콘 추가하며 버튼 객체 생성
			JButton btn2 = new JButton(new ImageIcon("image/minus_gul.png")); // 아이콘 추가하며 버튼 객체 생성
			btn1.setPreferredSize(new Dimension(200, 203)); // 레이아웃에서 크기지정 할 때 사용
			btn2.setPreferredSize(new Dimension(200, 203));
			p1.add(btn1); // 프레임에 붙이기
			p1.add(btn2);
			p1.setVisible(true); // 보이기
			p1.setResizable(false);
			
			btn1.addActionListener(new ActionListener() { // btn1버튼 눌렸을 때 ActionListener 실행
				
				@Override
				public void actionPerformed(ActionEvent e) { // 현재의 버튼(JButton btn1)이 눌리면 호출되는 actionPerformed 오버라이딩
					int point = Integer.parseInt(JOptionPane.showInputDialog(null, "몇개 줄까요?"));
		
					Connection con = null;
					PreparedStatement update = null;
					PreparedStatement select= null;
					ResultSet rs = null;
					
					PreparedStatement pst = null;
					final int teamnumber = 5;
					String sql;
					
					ArrayList<String> team1_namelist = new ArrayList<>();
					ArrayList<String> team2_namelist = new ArrayList<>();
					ArrayList<String> team3_namelist = new ArrayList<>();
					ArrayList<String> team4_namelist = new ArrayList<>();
					ArrayList<String> team5_namelist = new ArrayList<>();
					
					try {
						con = getConnection();
						
						for (int i=1; i<=teamnumber; i++) {
							sql = "select studentname from team"+i+"Version2";
							pst = con.prepareStatement(sql);
							rs = pst.executeQuery();
							
							if (i==1) {
								while(rs.next()) 
									team1_namelist.add(rs.getString(1));
							} else if (i==2) {
								while(rs.next()) 
									team2_namelist.add(rs.getString(1));
							} else if (i==3) {
								while(rs.next()) 
									team3_namelist.add(rs.getString(1));
							} else if (i==4) {
								while(rs.next()) 
									team4_namelist.add(rs.getString(1));
							}  else if (i==5) {
								while(rs.next()) 
									team5_namelist.add(rs.getString(1));
							}
							pst.clearParameters();
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					} finally {
						try {
							pst.close();
							con.close();
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
					
					if (team1_namelist.contains(random.student_name)) {
							try {
								con = getConnection();
								
								System.out.println("b: " + student_index + ", " + student_name);
								
								String sql1 = "select StudentPoint from team1Version2 where StudentNo=?";
								select = con.prepareStatement(sql1);
								select.setString(1,String.valueOf(student_index));
								rs = select.executeQuery();
								
								while(rs.next()) {
									String str1 = rs.getString(1);
									total[student_index]=Integer.parseInt(str1);
								}
								
								sql = "update team1Version2 set StudentPoint=? where StudentNo=?";
								update = con.prepareStatement(sql);
								
								update.setString(1, String.valueOf(total[student_index]+=point));
								update.setInt(2,random.student_index);
								update.executeUpdate();
								
								System.out.println("데이터 업데이트 완료");
								
							}catch (Exception e1) {
								System.out.println(e1.getMessage() + "업데이트 실패");
							}finally {
								try {if(rs != null)rs.close();} catch (Exception e2) {}
								try {if(update != null)con.close();} catch (Exception e2) {}
								try {if(con != null)update.close();} catch (Exception e2) {}
							}
							
							try {
								con = getConnection();
								sql = "update totalVersion2 set team1 = ?";
								update = con.prepareStatement(sql);
								
								String sql1 = "select team1 from totalVersion2";
								select = con.prepareStatement(sql1);
								rs = select.executeQuery();
								while(rs.next()) {
									String str1 = rs.getString(1);
									total3 = Integer.parseInt(str1);
								}
								update.setString(1, String.valueOf(total3+point));
								update.executeUpdate();
								System.out.println("데이터 업데이트 완료");
							} catch (Exception e1) {
								System.out.println(e1.getMessage() + "업데이트 실패");
							}finally {
								try {if(rs != null)rs.close();} catch (Exception e2) {}
								try {if(con != null)update.close();} catch (Exception e2) {}
								try {if(update != null)con.close();} catch (Exception e2) {}
							}
						}
		
					else if (team2_namelist.contains(random.student_name)) {
						
							try {
								con = getConnection();
								
								sql = "update team2Version2 set StudentPoint=? where StudentNo=?";
								update = con.prepareStatement(sql);
								
								String sql1 = "select StudentPoint from team2Version2 where StudentNo=?";
								select = con.prepareStatement(sql1);
								select.setString(1,String.valueOf(student_index));
								rs = select.executeQuery();
								
								while(rs.next()) {
									String str1 = rs.getString(1);
									total[student_index]=Integer.parseInt(str1);
								}
								update.setString(1, String.valueOf(total[student_index]+=point));
								update.setInt(2,random.student_index);
								update.executeUpdate();
								System.out.println("데이터 업데이트 완료");
								
							}catch (Exception e1) {
								System.out.println(e1.getMessage() + "업데이트 실패");
							}finally {
								try {if(rs != null)rs.close();} catch (Exception e2) {}
								try {if(con != null)update.close();} catch (Exception e2) {}
								try {if(update != null)con.close();} catch (Exception e2) {}
							}
							
							try {
								con = getConnection();
								sql = "update totalVersion2 set team2 = ?";
								update = con.prepareStatement(sql);
								String sql1 = "select team2 from totalVersion2";
								select = con.prepareStatement(sql1);
								rs = select.executeQuery();
								while(rs.next()) {
									String str1 = rs.getString(1);
									total4 = Integer.parseInt(str1);
								}
								update.setString(1, String.valueOf(total4+point));
								update.executeUpdate();
								System.out.println("데이터 업데이트 완료");
							} catch (Exception e1) {
								System.out.println(e1.getMessage() + "업데이트 실패");
							}finally {
								try {if(rs != null)rs.close();} catch (Exception e2) {}
								try {if(update != null)con.close();} catch (Exception e2) {}
								try {if(con != null)update.close();} catch (Exception e2) {}
							}
						}
						
					else if (team3_namelist.contains(random.student_name)) {
						
							try {
								con = getConnection();
								
								sql = "update team3Version2 set StudentPoint=? where StudentNo=?";
								update = con.prepareStatement(sql);
								
								String sql1 = "select StudentPoint from team3Version2 where StudentNo=?";
								select = con.prepareStatement(sql1);
								select.setString(1,String.valueOf(student_index));
								rs = select.executeQuery();
								
								while(rs.next()) {
									String str1 = rs.getString(1);
									total[student_index]=Integer.parseInt(str1);
								} 
								update.setString(1, String.valueOf(total[student_index]+=point));
								update.setInt(2,random.student_index);
								update.executeUpdate();
								System.out.println("데이터 업데이트 완료");
								
							}catch (Exception e1) {
								System.out.println(e1.getMessage() + "업데이트 실패");
							}finally {
								try {if(rs != null)rs.close();} catch (Exception e2) {}
								try {if(con != null)update.close();} catch (Exception e2) {}
								try {if(update != null)con.close();} catch (Exception e2) {}
							}
							
							try {
								con = getConnection();
								sql = "update totalVersion2 set team3= ?";
								update = con.prepareStatement(sql);
								String sql1 = "select team3 from totalVersion2";
								select = con.prepareStatement(sql1);
								rs = select.executeQuery();
								while(rs.next()) {
									String str1 = rs.getString(1);
									total5 = Integer.parseInt(str1);
								}
								update.setString(1, String.valueOf(total5+point));
								update.executeUpdate();
								System.out.println("데이터 업데이트 완료");
							} catch (Exception e1) {
								System.out.println(e1.getMessage() + "업데이트 실패");
							}finally {
								try {if(rs != null)rs.close();} catch (Exception e2) {}
								try {if(con != null)update.close();} catch (Exception e2) {}
								try {if(update != null)con.close();} catch (Exception e2) {}
							}
						
		
						} else if (team4_namelist.contains(random.student_name)) {
		
							try {
								con = getConnection();
								
								sql = "update team4Version2 set StudentPoint=? where StudentNo=?";
								update = con.prepareStatement(sql);
								
								String sql1 = "select StudentPoint from team4Version2 where StudentNo=?";
								select = con.prepareStatement(sql1);
								select.setString(1,String.valueOf(student_index));
								rs = select.executeQuery();
								
								while(rs.next()) {
									String str1 = rs.getString(1);
									total[student_index]=Integer.parseInt(str1);
								}
								update.setString(1, String.valueOf(total[student_index]+=point));
								update.setInt(2,random.student_index);
								update.executeUpdate();
								System.out.println("데이터 업데이트 완료");
								
							}catch (Exception e1) {
								System.out.println(e1.getMessage() + "업데이트 실패");
							}finally {
								try {if(rs != null)rs.close();} catch (Exception e2) {}
								try {if(con != null)update.close();} catch (Exception e2) {}
								try {if(update != null)con.close();} catch (Exception e2) {}
							}
							
							try {
								con = getConnection();
								sql = "update totalVersion2 set team4= ?";
								update = con.prepareStatement(sql);
								String sql1 = "select team4 from totalVersion2";
								select = con.prepareStatement(sql1);
								rs = select.executeQuery();
								while(rs.next()) {
									String str1 = rs.getString(1);
									total6 = Integer.parseInt(str1);
								}
								update.setString(1, String.valueOf(total6+point));
								update.executeUpdate();
								System.out.println("데이터 업데이트 완료");
							} catch (Exception e1) {
								System.out.println(e1.getMessage() + "업데이트 실패");
							}finally {
								try {if(rs != null)rs.close();} catch (Exception e2) {}
								try {if(update != null)con.close();} catch (Exception e2) {}
								try {if(con != null)update.close();} catch (Exception e2) {}
							}
							
							
						} else if (team5_namelist.contains(random.student_name)) {
		
							try {
								con = getConnection();
								
								sql = "update team5Version2 set StudentPoint=? where StudentNo=?";
								update = con.prepareStatement(sql);
								
								String sql1 = "select StudentPoint from team5Version2 where StudentNo=?";
								select = con.prepareStatement(sql1);
								select.setString(1,String.valueOf(student_index));
								rs = select.executeQuery();
								
								while(rs.next()) {
									String str1 = rs.getString(1);
									total[student_index]=Integer.parseInt(str1);
								}
								update.setString(1, String.valueOf(total[student_index]+=point));
								update.setInt(2,random.student_index);
								update.executeUpdate();
								System.out.println("데이터 업데이트 완료");
								
							}catch (Exception e1) {
								System.out.println(e1.getMessage() + "업데이트 실패");
							}finally {
								try {if(rs != null)rs.close();} catch (Exception e2) {}
								try {if(con != null)update.close();} catch (Exception e2) {}
								try {if(update != null)con.close();} catch (Exception e2) {}
							}
							
							try {
								con = getConnection();
								sql = "update totalVersion2 set team5= ?";
								update = con.prepareStatement(sql);
								String sql1 = "select team5 from totalVersion2";
								select = con.prepareStatement(sql1);
								rs = select.executeQuery();
								while(rs.next()) {
									String str1 = rs.getString(1);
									total7 = Integer.parseInt(str1);
								}
								update.setString(1, String.valueOf(total7+point));
								update.executeUpdate();
								System.out.println("데이터 업데이트 완료");
							} catch (Exception e1) {
								System.out.println(e1.getMessage() + "업데이트 실패");
							}finally {
								try {if(rs != null)rs.close();} catch (Exception e2) {}
								try {if(update != null)con.close();} catch (Exception e2) {}
								try {if(con != null)update.close();} catch (Exception e2) {}
							}
						}
					
				}
			});
			
			
			
			
			btn2.addActionListener(new ActionListener() { // // 만들어진 버튼 "새 창 띄우기"에 버튼이 눌러지면 발생하는 행동을 정의
				@Override
				public void actionPerformed(ActionEvent e) { // 위와 똑같은 형태의 함수이지만 위에는 더했다면 이번에는 귤 뺏기
					int mpoint = Integer.parseInt(JOptionPane.showInputDialog(null, "몇개 뺏을까요?"));
					
					Connection con = null;
					PreparedStatement update = null;
					PreparedStatement select= null;
					ResultSet rs = null;
					
					PreparedStatement pst = null;
					final int teamnumber = 5;
					String sql;
					
					ArrayList<String> team1_namelist = new ArrayList<>();
					ArrayList<String> team2_namelist = new ArrayList<>();
					ArrayList<String> team3_namelist = new ArrayList<>();
					ArrayList<String> team4_namelist = new ArrayList<>();
					ArrayList<String> team5_namelist = new ArrayList<>();
					
					try {
						con = getConnection();
						
						for (int i=1; i<=teamnumber; i++) {
							sql = "select studentname from team"+i+"Version2";
							pst = con.prepareStatement(sql);
							rs = pst.executeQuery();
							
							if (i==1) {
								while(rs.next()) 
									team1_namelist.add(rs.getString(1));
							} else if (i==2) {
								while(rs.next()) 
									team2_namelist.add(rs.getString(1));
							} else if (i==3) {
								while(rs.next()) 
									team3_namelist.add(rs.getString(1));
							} else if (i==4) {
								while(rs.next()) 
									team4_namelist.add(rs.getString(1));
							}  else if (i==5) {
								while(rs.next()) 
									team5_namelist.add(rs.getString(1));
							}
							pst.clearParameters();
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					} finally {
						try {
							pst.close();
							con.close();
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
					
					if (team1_namelist.contains(random.student_name)) {

						try {
							con = getConnection();
							
							sql = "update team1Version2 set StudentPoint=? where StudentNo=?";
							update = con.prepareStatement(sql);
							
							String sql1 = "select StudentPoint from team1Version2 where StudentNo=?";
							select = con.prepareStatement(sql1);
							select.setString(1,String.valueOf(student_index));
							rs = select.executeQuery();
							
							while(rs.next()) {
								String str1 = rs.getString(1);
								total[student_index]=Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total[student_index]-=mpoint)); // 학생의 귤 포인트 -로 귤 뺏기
							update.setInt(2,random.student_index);
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
							
						}catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						}finally {
							try {if(rs != null)rs.close();} catch (Exception e2) {}
							try {if(update != null)con.close();} catch (Exception e2) {}
							try {if(con != null)update.close();} catch (Exception e2) {}
						}
						
						try {
							con = getConnection();
							sql = "update totalVersion2 set team1= ?";
							update = con.prepareStatement(sql);
							String sql1 = "select team1 from totalVersion2";
							select = con.prepareStatement(sql1);
							rs = select.executeQuery();
							while(rs.next()) {
								String str1 = rs.getString(1);
								total3 = Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total3-mpoint)); // 팀의 포인트 총 합에서 뺀 귤 -하기
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
						} catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						}finally {
							try {if(rs != null)rs.close();} catch (Exception e2) {}
							try {if(update != null)con.close();} catch (Exception e2) {}
							try {if(con != null)update.close();} catch (Exception e2) {}
						}
					}

					else if (team2_namelist.contains(random.student_name)) {
						
						try {
							con = getConnection();
							
							sql = "update team2Version2 set StudentPoint=? where StudentNo=?";
							update = con.prepareStatement(sql);
							
							String sql1 = "select StudentPoint from team2Version2 where StudentNo=?";
							select = con.prepareStatement(sql1);
							select.setString(1,String.valueOf(student_index));
							rs = select.executeQuery();
							
							while(rs.next()) {
								String str1 = rs.getString(1);
								total[student_index]=Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total[student_index]-=mpoint));
							update.setInt(2,random.student_index);
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
							
						}catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						}finally {
							try {if(rs != null)rs.close();} catch (Exception e2) {}
							try {if(update != null)con.close();} catch (Exception e2) {}
							try {if(con != null)update.close();} catch (Exception e2) {}
						}
						
						try {
							con = getConnection();
							sql = "update totalVersion2 set team2= ?";
							update = con.prepareStatement(sql);
							String sql1 = "select team2 from totalVersion2";
							select = con.prepareStatement(sql1);
							rs = select.executeQuery();
							while(rs.next()) {
								String str1 = rs.getString(1);
								total4 = Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total4-mpoint));
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
						} catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						}finally {
							try {if(rs != null)rs.close();} catch (Exception e2) {}
							try {if(update != null)con.close();} catch (Exception e2) {}
							try {if(con != null)update.close();} catch (Exception e2) {}
						}
					}

					else if (team3_namelist.contains(random.student_name)) {

						try {
							con = getConnection();
							
							
							sql = "update team3Version2 set StudentPoint=? where StudentNo=?";
							update = con.prepareStatement(sql);
							
							String sql1 = "select StudentPoint from team3Version2 where StudentNo=?";
							select = con.prepareStatement(sql1);
							select.setString(1,String.valueOf(student_index));
							rs = select.executeQuery();
							
							while(rs.next()) {
								String str1 = rs.getString(1);
								total[student_index]=Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total[student_index]-=mpoint));
							update.setInt(2,random.student_index);
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
							
						}catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						}finally {
							try {if(rs != null)rs.close();} catch (Exception e2) {}
							try {if(update != null)con.close();} catch (Exception e2) {}
							try {if(con != null)update.close();} catch (Exception e2) {}
						}
						try {
							con = getConnection();
							sql = "update totalVersion2 set team3= ?";
							update = con.prepareStatement(sql);
							String sql1 = "select team3 from totalVersion2";
							select = con.prepareStatement(sql1);
							rs = select.executeQuery();
							while(rs.next()) {
								String str1 = rs.getString(1);
								total5 = Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total5-mpoint));
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
						} catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						}finally {
							try {if(rs != null)rs.close();} catch (Exception e2) {}
							try {if(update != null)con.close();} catch (Exception e2) {}
							try {if(con != null)update.close();} catch (Exception e2) {}
						}
					} 
					
					else if (team4_namelist.contains(random.student_name)) {

						try {
							con = getConnection();
							
							
							sql = "update team4Version2 set StudentPoint=? where StudentNo=?";
							update = con.prepareStatement(sql);
							
							String sql1 = "select StudentPoint from team4Version2 where StudentNo=?";
							select = con.prepareStatement(sql1);
							select.setString(1,String.valueOf(student_index));
							rs = select.executeQuery();
							
							while(rs.next()) {
								String str1 = rs.getString(1);
								total[student_index]=Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total[student_index]-=mpoint));
							update.setInt(2,random.student_index);
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
							
						}catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						}finally {
							try {if(rs != null)rs.close();} catch (Exception e2) {}
							try {if(update != null)con.close();} catch (Exception e2) {}
							try {if(con != null)update.close();} catch (Exception e2) {}
						}
						
						try {
							con = getConnection();
							sql = "update totalVersion2 set team4= ?";
							update = con.prepareStatement(sql);
							String sql1 = "select team4 from totalVersion2";
							select = con.prepareStatement(sql1);
							rs = select.executeQuery();
							while(rs.next()) {
								String str1 = rs.getString(1);
								total6 = Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total6-mpoint));
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
						} catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						}finally {
							try {if(rs != null)rs.close();} catch (Exception e2) {}
							try {if(update != null)con.close();} catch (Exception e2) {}
							try {if(con != null)update.close();} catch (Exception e2) {}
						}
					}
					
					else if (team5_namelist.contains(random.student_name)) {

						try {
							con = getConnection();
							
							sql = "update team5Version2 set StudentPoint=? where StudentNo=?";
							update = con.prepareStatement(sql);
							
							String sql1 = "select StudentPoint from team5Version2 where StudentNo=?";
							select = con.prepareStatement(sql1);
							select.setString(1,String.valueOf(student_index));
							rs = select.executeQuery();
							
							while(rs.next()) {
								String str1 = rs.getString(1);
								total[student_index]=Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total[student_index]-=mpoint));
							update.setInt(2,random.student_index);
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
							
						}catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						}finally {
							try {if(rs != null)rs.close();} catch (Exception e2) {}
							try {if(update != null)con.close();} catch (Exception e2) {}
							try {if(con != null)update.close();} catch (Exception e2) {}
						}
						
						try {
							con = getConnection();
							sql = "update totalVersion2 set team5= ?";
							update = con.prepareStatement(sql);
							String sql1 = "select team5 from totalVersion2";
							select = con.prepareStatement(sql1);
							rs = select.executeQuery();
							while(rs.next()) {
								String str1 = rs.getString(1);
								total7 = Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total7-mpoint));
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
						} catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						}finally {
							try {if(rs != null)rs.close();} catch (Exception e2) {}
							try {if(update != null)con.close();} catch (Exception e2) {}
							try {if(con != null)update.close();} catch (Exception e2) {}
						}
					}
					
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
	}

}

