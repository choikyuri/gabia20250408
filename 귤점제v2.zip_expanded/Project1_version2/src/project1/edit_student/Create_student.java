package project1.edit_student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Create_student {
	
	public Create_student() {
	
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;
		int new_student_index=0;
		int execute_returnNum = 0;
		final int teamnumber = 5;

		ArrayList<String> team1_namelist = new ArrayList<>();
		ArrayList<String> team2_namelist = new ArrayList<>();
		ArrayList<String> team3_namelist = new ArrayList<>();
		ArrayList<String> team4_namelist = new ArrayList<>();
		ArrayList<String> team5_namelist = new ArrayList<>();
		
		try {
			con = EditButton.getConnection();

			for (int i = 1; i <= teamnumber; i++) {
				sql = "select studentname from team" + i + "Version2";
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();

				if (i == 1) {
					while (rs.next()) 
						team1_namelist.add(rs.getString(1));
				} else if (i == 2) {
					while (rs.next()) 
						team2_namelist.add(rs.getString(1));
				} else if (i == 3) {
					while (rs.next()) 
						team3_namelist.add(rs.getString(1));
				} else if (i == 4) {
					while (rs.next()) 
						team4_namelist.add(rs.getString(1));
				} else if (i == 5) {
					while (rs.next()) 
						team5_namelist.add(rs.getString(1));
				}
				pst.clearParameters();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				con.close();
				System.out.println("create_student 연결 종료");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} // finally
		
		String std_name = JOptionPane.showInputDialog("추가할 학생 이름을 입력하세요");
		
		if(std_name != null){
		    if(!std_name.isEmpty()){
		    	String team_number = JOptionPane.showInputDialog("어떤 팀에 추가할지 입력하세요(1, 2, 3, 4, 5)");
		    	if (team_number !=null || !team_number.isEmpty()) {
		    		if (team_number.equals("1") || team_number.equals("2") || team_number.equals("3") || team_number.equals("4") || team_number.equals("5")) {
			    		if (team_number.equals("1")) {
			    			new_student_index = team1_namelist.size(); // 7부터 들어감
			    			sql = "insert into team1Version2 values (?, ?, 0, 0)"; //(studentno, studentname, studentpoint, studenttotal)
			    		}
			    		else if (team_number.equals("2")) {
			    			new_student_index = team1_namelist.size() + team2_namelist.size(); // 12번부터 들어감
			    			sql = "insert into team2Version2 values (?, ?, 0, 0)";
			    		}
			    		else if (team_number.equals("3")) {
			    			new_student_index = team1_namelist.size() + team2_namelist.size() + team3_namelist.size(); // 18부터 들어감
			    			sql = "insert into team3Version2 values (?, ?, 0, 0)";
			    		}
			    		else if (team_number.equals("4")) {
			    			new_student_index = team1_namelist.size() + team2_namelist.size() + team3_namelist.size() + team4_namelist.size(); // 24부터 들어감
			    			sql = "insert into team4Version2 values (?, ?, 0, 0)";
			    		}
			    		else if (team_number.equals("5")) {
			    			new_student_index = team1_namelist.size() + team2_namelist.size() + team3_namelist.size() + team4_namelist.size() + team5_namelist.size(); // 24부터 들어감
			    			sql = "insert into team5Version2 values (?, ?, 0, 0)";
			    		}
			    		con = EditButton.getConnection();
			    		try {
			    			con.setAutoCommit(false);
			    			pst = con.prepareStatement(sql);
			    			pst.setString(1, String.valueOf(new_student_index));
			    			pst.setString(2, std_name);
			    			execute_returnNum = pst.executeUpdate();
			    			pst.clearParameters();
			    			
			    			if (execute_returnNum == 1) { // 쿼리문 실행이 정상적으로 되었을 경우
			    				for (int i=Integer.parseInt(team_number)+1; i<=teamnumber; i++) { // 1팀에 학생이 새로 들어간다고 해도 맨끝으로 들어가므로 studentno를 수정할 필요가 없음, 그러므로 i=2부터 시작
									sql = "update team" + i + "Version2 set studentno=studentno+1 where studentno>=?"; // 어느 학생이 삭제되었을 때 db의 각 테이블의 studentno를 재설정하기 위함
									pst = con.prepareStatement(sql);
									pst.setInt(1, new_student_index);
									pst.executeUpdate();
								}
			    				JOptionPane.showMessageDialog(null, "team"+ team_number +"에 학생 "+std_name+" 추가가 완료되었습니다\n갱신을 위해 종료합니다. 다시 실행하세요");
			    				con.commit();
			    				System.exit(0);
			    				
			    			} else {
			    				con.rollback();
			    				JOptionPane.showMessageDialog(null, "정상적으로 실행되지 않았습니다\n관리자에게 문의하세요");
			    			}
			    			
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							try { if (rs != null) rs.close(); } catch (Exception e2) {e2.printStackTrace();}
							try { if (pst != null) pst.close(); } catch (Exception e2) {e2.printStackTrace();}
							try { if (con != null) con.close(); } catch (Exception e2) {e2.printStackTrace();}
						}
		    		} else 
		    			JOptionPane.showMessageDialog(null, "올바른 값(1, 2, 3, 4, 5)이 입력되지 않았으므로 취소합니다");
		    	} else 
		    		JOptionPane.showMessageDialog(null, "팀이 올바르게 입력되지 않았으므로 취소합니다");
		    } else
		    	JOptionPane.showMessageDialog(null, "학생의 이름이 입력되지 않았으므로 취소합니다");
		} else
			JOptionPane.showMessageDialog(null, "취소했습니다");
		
		for (String s : team1_namelist)
			System.out.print(s + " ");
		System.out.println();
		for (String s : team2_namelist)
			System.out.print(s + " ");
		System.out.println();
		for (String s : team3_namelist)
			System.out.print(s + " ");
		System.out.println();
		for (String s : team4_namelist)
			System.out.print(s + " ");
		System.out.println();
		for (String s : team5_namelist)
			System.out.print(s + " ");
		System.out.println();
		
	}

	
}
