package project1.edit_student;

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

public class EditButton extends JFrame {

	JTextField name, age;// 클래스 변수로 선언.
	JLabel lbtitle;
	Font font = new Font("휴먼모음T", Font.PLAIN, 17);

	static int student_index;
	static String student_name;

	static ArrayList<String> team1_namelist = new ArrayList<>();
	static ArrayList<String> team2_namelist = new ArrayList<>();
	static ArrayList<String> team3_namelist = new ArrayList<>();
	static ArrayList<String> team4_namelist = new ArrayList<>();
	static ArrayList<String> team5_namelist = new ArrayList<>();

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

	public static int check_team(String name) {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql;
		final int teamnumber = 5;

		try {
			con = getConnection();

			for (int i = 1; i <= teamnumber; i++) {
				sql = "select studentname from team" + i + "Version2";
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();

				if (i == 1) {
					while (rs.next()) {
						team1_namelist.add(rs.getString(1));
					}
				} else if (i == 2) {
					while (rs.next()) {
						team2_namelist.add(rs.getString(1));
					}
				} else if (i == 3) {
					while (rs.next()) {
						team3_namelist.add(rs.getString(1));
					}
				} else if (i == 4) {
					while (rs.next()) {
						team4_namelist.add(rs.getString(1));
					}
				} else if (i == 5) {
					while (rs.next()) {
						team5_namelist.add(rs.getString(1));
					}
				}
				pst.clearParameters();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();
				System.out.println("check_team 연결 종료");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		// 이름이 어느 팀 리스트에 포함되어있는지 확인
		if (team1_namelist.contains(name))
			return 1;
		else if (team2_namelist.contains(name))
			return 2;
		else if (team3_namelist.contains(name))
			return 3;
		else if (team4_namelist.contains(name))
			return 4;
		else if (team5_namelist.contains(name))
			return 5;
		else
			return 6;

	} // check_team()

	static class Main5_2 extends JFrame {
		static int[] total = new int[30];
		static int total3;// 1조 총점
		static int total4;// 2조 총점
		static int total5;// 3조 총점
		static int total6;// 4조 총점
		static int total7;// 5조 총점

		// 버튼이 눌러지면 만들어지는 새 창을 정의한 클래스
		public Main5_2() {

			final int teamnumber = 5;

			JFrame p1 = new JFrame();
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 서브 프레임 종료버튼 생성
			p1.setTitle("학생 편집창");
			p1.setBounds(100, 100, 250, 210);
			p1.setLocationRelativeTo(null);
			JButton btn1 = new JButton(new ImageIcon("image/delete.png"));// 삭제
			JButton btn2 = new JButton(new ImageIcon("image/point_modify.png"));// 포인트수정
			JButton btn3 = new JButton(new ImageIcon("image/team_modify.png"));// 이름수정
			btn1.setPreferredSize(new Dimension(200, 50));
			btn2.setPreferredSize(new Dimension(200, 50));
			btn3.setPreferredSize(new Dimension(200, 50));
			btn1.setSize(200, 50);
			btn2.setSize(200, 50);
			btn3.setSize(200, 50);

			p1.add(btn1);
			p1.add(btn2);
			p1.add(btn3);
			p1.setVisible(true);
			p1.setResizable(false);
			p1.setLayout(new FlowLayout()); // 버튼들 위에서 아래로 자동정렬 배치

			// 학생 삭제
			btn1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int delete = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					if (delete == 1) {
						JOptionPane.showMessageDialog(null, "삭제를 취소했습니다");
						p1.dispose();
					} else if (delete == 0) {
						Connection con = null;
						PreparedStatement update = null;

						check_team("개발자");

						if (team1_namelist.contains(EditButton.student_name)) {
							try {
								con = getConnection(); // con = null, build path에 jar 추가하지 않으면 con에 null들어옴! Statement
														// url인가
														// 거기서 가져오려면 jar이 있어야함
								String sql = "delete team1Version2 where StudentNo=?";
								update = con.prepareStatement(sql);

								update.setInt(1, EditButton.student_index);
								update.executeUpdate();

								update.clearParameters(); // PreparedStatement 객체 재사용하기 위해
								for (int i = 1; i <= teamnumber; i++) {
									sql = "update team" + i + "Version2 set studentno=studentno-1 where studentno>=?"; // 어느
																														// 학생이
																														// 삭제되었을때
																														// db의
																														// 각
																														// 테이블의
																														// studentno를
																														// 재설정하기
																														// 위함
									update = con.prepareStatement(sql);
									update.setInt(1, EditButton.student_index);
									update.executeUpdate();
									update.clearParameters();
								}

								System.out.println("데이터 삭제 완료");
								p1.dispose();

							} catch (Exception e1) {
								System.out.println(e1.getMessage() + "team1Version2 삭제 실패");
							} finally {
								System.out.println("team1Version2 finally 수행");
								try {
									update.close();
									con.close();
								} catch (Exception e2) {
									e2.printStackTrace();
								}
								JOptionPane.showMessageDialog(null, "갱신을 위해 종료됩니다. 다시 실행하세요");
								System.exit(0);
							}

						}

						else if (team2_namelist.contains(EditButton.student_name)) {
							try {
								con = getConnection(); // con = null, build path에 jar 추가하지 않으면 con에 null들어옴! Statement
														// url인가
														// 거기서 가져오려면 jar이 있어야함
								String sql = "delete team2Version2 where StudentNo=?";
								update = con.prepareStatement(sql);

								update.setInt(1, EditButton.student_index);
								update.executeUpdate();

								update.clearParameters(); // PreparedStatement 객체 재사용하기 위해
								for (int i = 1; i <= teamnumber; i++) {
									sql = "update team" + i + "Version2 set studentno=studentno-1 where studentno>=?"; // 어느
																														// 학생이
																														// 삭제되었을때
																														// db의
																														// 각
																														// 테이블의
																														// studentno를
																														// 재설정하기
																														// 위함
									update = con.prepareStatement(sql);
									update.setInt(1, EditButton.student_index);
									update.executeUpdate();
									update.clearParameters();
								}

								System.out.println("데이터 삭제 완료");
								p1.dispose();

							} catch (Exception e1) {
								System.out.println(e1.getMessage() + "team2Version2 삭제 실패");
							} finally {
								System.out.println("team2Version2 finally 수행");
								try {
									update.close();
									con.close();
								} catch (Exception e2) {
									e2.printStackTrace();
								}
								JOptionPane.showMessageDialog(null, "갱신을 위해 종료됩니다. 다시 실행하세요");
								System.exit(0);
							}
						}

						else if (team3_namelist.contains(EditButton.student_name)) {
							try {
								con = getConnection(); // con = null, build path에 jar 추가하지 않으면 con에 null들어옴! Statement
														// url인가
														// 거기서 가져오려면 jar이 있어야함
								String sql = "delete team3Version2 where StudentNo=?";
								update = con.prepareStatement(sql);

								update.setInt(1, EditButton.student_index);
								update.executeUpdate();

								update.clearParameters(); // PreparedStatement 객체 재사용하기 위해
								for (int i = 1; i <= teamnumber; i++) {
									sql = "update team" + i + "Version2 set studentno=studentno-1 where studentno>=?"; // 어느
																														// 학생이
																														// 삭제되었을때
																														// db의
																														// 각
																														// 테이블의
																														// studentno를
																														// 재설정하기
																														// 위함
									update = con.prepareStatement(sql);
									update.setInt(1, EditButton.student_index);
									update.executeUpdate();
									update.clearParameters();
								}

								System.out.println("데이터 삭제 완료");
								p1.dispose();

							} catch (Exception e1) {
								System.out.println(e1.getMessage() + "team3Version2 삭제 실패");
							} finally {
								System.out.println("team3Version2 finally 수행");
								try {
									update.close();
									con.close();
								} catch (Exception e2) {
									e2.printStackTrace();
								}
								JOptionPane.showMessageDialog(null, "갱신을 위해 종료됩니다. 다시 실행하세요");
								System.exit(0);
							}

						} else if (team4_namelist.contains(EditButton.student_name)) {
							try {
								con = getConnection(); // con = null, build path에 jar 추가하지 않으면 con에 null들어옴! Statement
														// url인가
														// 거기서 가져오려면 jar이 있어야함
								String sql = "delete team4Version2 where StudentNo=?";
								update = con.prepareStatement(sql);

								update.setInt(1, EditButton.student_index);
								update.executeUpdate();

								update.clearParameters(); // PreparedStatement 객체 재사용하기 위해
								for (int i = 1; i <= teamnumber; i++) {
									sql = "update team" + i + "Version2 set studentno=studentno-1 where studentno>=?"; // 어느
																														// 학생이
									// 삭제되었을
									// 때 db의
									// 각
									// 테이블의
									// studentno를
									// 재설정하기
									// 위함
									update = con.prepareStatement(sql);
									update.setInt(1, EditButton.student_index);
									update.executeUpdate();
									update.clearParameters();
								}

								System.out.println("데이터 삭제 완료");
								p1.dispose();

							} catch (Exception e1) {
								System.out.println(e1.getMessage() + "team4Version2 삭제 실패");
							} finally {
								System.out.println("team4Version2 finally 수행");
								try {
									update.close();
									con.close();
								} catch (Exception e2) {
									e2.printStackTrace();
								}
								JOptionPane.showMessageDialog(null, "갱신을 위해 종료됩니다. 다시 실행하세요");
								System.exit(0);
							}

						} else if (team5_namelist.contains(EditButton.student_name)) {
							try {
								con = getConnection(); // con = null, build path에 jar 추가하지 않으면 con에 null들어옴! Statement
														// url인가
														// 거기서 가져오려면 jar이 있어야함
								String sql = "delete team5Version2 where StudentNo=?";
								update = con.prepareStatement(sql);

								update.setInt(1, EditButton.student_index);
								update.executeUpdate();

								update.clearParameters(); // PreparedStatement 객체 재사용하기 위해
								for (int i = 1; i <= teamnumber; i++) {
									sql = "update team" + i + "Version2 set studentno=studentno-1 where studentno>=?"; // 어느
																														// 학생이
									// 삭제되었을
									// 때 db의
									// 각
									// 테이블의
									// studentno를
									// 재설정하기
									// 위함
									update = con.prepareStatement(sql);
									update.setInt(1, EditButton.student_index);
									update.executeUpdate();
									update.clearParameters();
								}

								System.out.println("데이터 삭제 완료");
								p1.dispose();

							} catch (Exception e1) {
								System.out.println(e1.getMessage() + "team5Version2 삭제 실패");
							} finally {
								System.out.println("team5Version2 finally 수행");
								try {
									update.close();
									con.close();
								} catch (Exception e2) {
									e2.printStackTrace();
								}
								JOptionPane.showMessageDialog(null, "갱신을 위해 종료됩니다. 다시 실행하세요");
								System.exit(0);
							}

						}

					}
				}
			});

			// 포인트 수정
			btn2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int point = Integer.parseInt(JOptionPane.showInputDialog(null, "몇개로 수정 할까요?"));

					Connection con = null;
					PreparedStatement update = null;
					PreparedStatement select = null;
					ResultSet rs = null;

					int team = check_team(EditButton.student_name);

					if (team == 1) {
						try {
							con = getConnection();
							String sql = "update team1Version2 set StudentPoint=? where Studentname=?";
							update = con.prepareStatement(sql);

							update.setString(1, String.valueOf(point));
							update.setString(2, EditButton.student_name);
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");

						} catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						} finally {
							try {
								if (rs != null)
									rs.close();
							} catch (Exception e2) {
							}
							try {
								if (update != null)
									con.close();
							} catch (Exception e2) {
							}
							try {
								if (con != null)
									update.close();
							} catch (Exception e2) {
							}
						}

						try {
							con = getConnection();
							String sql = "update totalVersion2 set team1= ?";
							update = con.prepareStatement(sql);

							String sql1 = "select team1 from totalVersion2";
							select = con.prepareStatement(sql1);
							rs = select.executeQuery();
							while (rs.next()) {
								String str1 = rs.getString(1);
								total3 = Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total3 + point));
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
						} catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						} finally {
							try {
								if (rs != null)
									rs.close();
							} catch (Exception e2) {
							}
							try {
								if (update != null)
									con.close();
							} catch (Exception e2) {
							}
							try {
								if (con != null)
									update.close();
							} catch (Exception e2) {
							}
						}
					}

					if (team == 2) {

						try {
							con = getConnection();
							String sql = "update team2Version2 set StudentPoint=? where StudentName=?";
							update = con.prepareStatement(sql);

							update.setString(1, String.valueOf(point));
							update.setString(2, EditButton.student_name);
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");

						} catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						} finally {
							try {
								if (rs != null)
									rs.close();
							} catch (Exception e2) {
							}
							try {
								if (update != null)
									con.close();
							} catch (Exception e2) {
							}
							try {
								if (con != null)
									update.close();
							} catch (Exception e2) {
							}
						}

						try {
							con = getConnection();
							String sql = "update totalVersion2 set team2= ?";
							update = con.prepareStatement(sql);
							String sql1 = "select team2 from totalVersion2";
							select = con.prepareStatement(sql1);
							rs = select.executeQuery();
							while (rs.next()) {
								String str1 = rs.getString(1);
								total4 = Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total4 + point));
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
						} catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						} finally {
							try {
								if (rs != null)
									rs.close();
							} catch (Exception e2) {
							}
							try {
								if (update != null)
									con.close();
							} catch (Exception e2) {
							}
							try {
								if (con != null)
									update.close();
							} catch (Exception e2) {
							}
						}
					}

					if (team == 3) {

						try {
							con = getConnection();
							String sql = "update team3Version2 set StudentPoint=? where StudentName=?";
							update = con.prepareStatement(sql);

							update.setString(1, String.valueOf(point));
							update.setString(2, EditButton.student_name);

							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");

						} catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						} finally {
							try {
								if (rs != null)
									rs.close();
							} catch (Exception e2) {
							}
							try {
								if (update != null)
									con.close();
							} catch (Exception e2) {
							}
							try {
								if (con != null)
									update.close();
							} catch (Exception e2) {
							}
						}

						try {
							con = getConnection();
							String sql = "update totalVersion2 set team3= ?";
							update = con.prepareStatement(sql);
							String sql1 = "select team3 from totalVersion2";
							select = con.prepareStatement(sql1);
							rs = select.executeQuery();
							while (rs.next()) {
								String str1 = rs.getString(1);
								total5 = Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total5 + point));
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
						} catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						} finally {
							try {
								if (rs != null)
									rs.close();
							} catch (Exception e2) {
							}
							try {
								if (update != null)
									con.close();
							} catch (Exception e2) {
							}
							try {
								if (con != null)
									update.close();
							} catch (Exception e2) {
							}
						}
					}

					if (team == 4) {

						try {
							con = getConnection();
							String sql = "update team4Version2 set StudentPoint=? where StudentName=?";
							update = con.prepareStatement(sql);

							update.setString(1, String.valueOf(point));
							update.setString(2, EditButton.student_name);
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");

						} catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						} finally {
							try {
								if (rs != null)
									rs.close();
							} catch (Exception e2) {
							}
							try {
								if (update != null)
									con.close();
							} catch (Exception e2) {
							}
							try {
								if (con != null)
									update.close();
							} catch (Exception e2) {
							}
						}

						try {
							con = getConnection();
							String sql = "update totalVersion2 set team4= ?";
							update = con.prepareStatement(sql);
							String sql1 = "select team4 from totalVersion2";
							select = con.prepareStatement(sql1);
							rs = select.executeQuery();
							while (rs.next()) {
								String str1 = rs.getString(1);
								total6 = Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total6 + point));
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
						} catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						} finally {
							try {
								if (rs != null)
									rs.close();
							} catch (Exception e2) {
							}
							try {
								if (update != null)
									con.close();
							} catch (Exception e2) {
							}
							try {
								if (con != null)
									update.close();
							} catch (Exception e2) {
							}
						}
					}

					if (team == 5) {

						try {
							con = getConnection();
							String sql = "update team5Version2 set StudentPoint=? where StudentName=?";
							update = con.prepareStatement(sql);

							update.setString(1, String.valueOf(point));
							update.setString(2, EditButton.student_name);
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");

						} catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						} finally {
							try {
								if (rs != null)
									rs.close();
							} catch (Exception e2) {
							}
							try {
								if (update != null)
									con.close();
							} catch (Exception e2) {
							}
							try {
								if (con != null)
									update.close();
							} catch (Exception e2) {
							}
						}

						try {
							con = getConnection();
							String sql = "update totalVersion2 set team5= ?";
							update = con.prepareStatement(sql);
							String sql1 = "select team5 from totalVersion2";
							select = con.prepareStatement(sql1);
							rs = select.executeQuery();
							while (rs.next()) {
								String str1 = rs.getString(1);
								total7 = Integer.parseInt(str1);
							}
							update.setString(1, String.valueOf(total7 + point));
							update.executeUpdate();
							System.out.println("데이터 업데이트 완료");
						} catch (Exception e1) {
							System.out.println(e1.getMessage() + "업데이트 실패");
						} finally {
							try {
								if (rs != null)
									rs.close();
							} catch (Exception e2) {
							}
							try {
								if (update != null)
									con.close();
							} catch (Exception e2) {
							}
							try {
								if (con != null)
									update.close();
							} catch (Exception e2) {
							}
						}
					}

				}
			});

			// 팀 변경
			btn3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					Connection con = null;
					PreparedStatement pst = null;
					ResultSet rs = null;

					String sql_std1;

					String sql_change1;
					String sql_change1_1; // update...set 표현식은 하위질의여야 하기 때문에 하위질의를 따로 작성하기 위함

					String sql_change2;
					String sql_change2_1 = null;

					ArrayList<String> student1_info = new ArrayList<>();

					String std_name1 = EditButton.student_name;
					try {
						con = getConnection();
						int team = check_team(std_name1);
						if (team == 1) {
							// 학생1의 정보를 조회할 쿼리문
							sql_std1 = "select studentname, studentpoint, studenttotal from team1Version2 where studentname like ?";
							// 학생1을 update하기 위한 쿼리문(1)
							sql_change1 = "update team1Version2 set(studentname, studentpoint, studenttotal) = ";
							pst = con.prepareStatement(sql_std1);
						} else if (team == 2) {
							sql_std1 = "select studentname, studentpoint, studenttotal from team2Version2 where studentname like ?";
							sql_change1 = "update team2Version2 set(studentname, studentpoint, studenttotal) = ";
							pst = con.prepareStatement(sql_std1);
						} else if (team == 3) {
							sql_std1 = "select studentname, studentpoint, studenttotal from team3Version2 where studentname like ?";
							sql_change1 = "update team3Version2 set(studentname, studentpoint, studenttotal) = ";
							pst = con.prepareStatement(sql_std1);
						} else if (team == 4) {
							sql_std1 = "select studentname, studentpoint, studenttotal from team4Version2 where studentname like ?";
							sql_change1 = "update team4Version2 set(studentname, studentpoint, studenttotal) = ";
							pst = con.prepareStatement(sql_std1);
						} else if (team == 5) {
							sql_std1 = "select studentname, studentpoint, studenttotal from team5Version2 where studentname like ?";
							sql_change1 = "update team5Version2 set(studentname, studentpoint, studenttotal) = ";
							pst = con.prepareStatement(sql_std1);
						} else {
							JOptionPane.showMessageDialog(null, "없는 학생입니다");
							return;
						}
//								// 첫번째 학생의 정보 가져오기
						pst.setString(1, String.valueOf(std_name1));
						rs = pst.executeQuery();
						pst.clearParameters();
						// 첫번째 학생의 정보 배열에 담기
						while (rs.next()) {
							student1_info.add(rs.getString(1));
							student1_info.add(rs.getString(2));
							student1_info.add(rs.getString(3));
						}

						String std_name2 = JOptionPane.showInputDialog(null, "팀을 바꿀 학생의 이름을 입력하세요.");
						if (std_name2 != null) {
							if (!std_name2.isEmpty()) {
								if (!std_name2.equals(std_name1)) {
									try {
										int team2 = check_team(std_name2);
										if (team2 == 1) {
											// 학생1을 update하기 위한 쿼리문(2)
											sql_change1_1 = "(select studentname, studentpoint, studenttotal from team1Version2 where studentname like ?) where studentname like ?";
											// 학생2를 update하기 위한 쿼리문(1)
											sql_change2 = "update team1Version2 set ";
										} else if (team2 == 2) {
											sql_change1_1 = "(select studentname, studentpoint, studenttotal from team2Version2 where studentname like ?) where studentname like ?";
											sql_change2 = "update team2Version2 set ";
										} else if (team2 == 3) {
											sql_change1_1 = "(select studentname, studentpoint, studenttotal from team3Version2 where studentname like ?) where studentname like ?";
											sql_change2 = "update team3Version2 set ";
										} else if (team2 == 4) {
											sql_change1_1 = "(select studentname, studentpoint, studenttotal from team4Version2 where studentname like ?) where studentname like ?";
											sql_change2 = "update team4Version2 set ";
										} else if (team2 == 5) {
											sql_change1_1 = "(select studentname, studentpoint, studenttotal from team5Version2 where studentname like ?) where studentname like ?";
											sql_change2 = "update team5Version2 set ";
										} else {
											JOptionPane.showMessageDialog(null, "없는 학생입니다");
											return;
										}

										sql_change2_1 = "studentname = ?, studentpoint = ?, studenttotal = ? where studentname like ?";

										// 학생1을 학생2의 정보로 update
										pst = con.prepareStatement(sql_change1 + sql_change1_1);
										pst.setString(1, String.valueOf(std_name2));
										pst.setString(2, String.valueOf(std_name1));
										rs = pst.executeQuery();
										pst.clearParameters();

										// 학생2를 학생1(temp)의 정보로 update
										pst = con.prepareStatement(sql_change2 + sql_change2_1);
										pst.setString(1, student1_info.get(0));
										pst.setString(2, student1_info.get(1));
										pst.setString(3, student1_info.get(2));
										pst.setString(4, String.valueOf(std_name2));

										rs = pst.executeQuery();

										System.out.println("업데이트 완료");
										JOptionPane.showMessageDialog(null, "갱신을 위해 종료합니다. 다시 실행하세요");
										System.exit(0);

									} catch (Exception e2) {
										e2.printStackTrace();
									}
								} else
									JOptionPane.showMessageDialog(null, "수정하려는 학생의 이름과 같으므로 취소합니다");
							} else
								JOptionPane.showMessageDialog(null, "학생의 이름이 입력되지 않았으므로 취소합니다");
						} else
							JOptionPane.showMessageDialog(null, "취소했습니다");
						// std_name2

					} catch (Exception e2) {
						e2.printStackTrace();
					} finally {
						System.out.println("update team 연결종료");
						try {
							if (rs != null)
								rs.close();
						} catch (Exception e2) {
						}
						try {
							if (pst != null)
								pst.close();
						} catch (Exception e2) {
						}
						try {
							if (con != null)
								con.close();
						} catch (Exception e2) {
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