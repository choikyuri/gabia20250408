package project1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Login extends JFrame {

	private JFrame frame;
	private JTextField textid;
	private JPasswordField textpw;
	public static Connection con;

	@Override
	public JMenuBar getJMenuBar() {
		return getJMenuBar();
	}

	/*
	 * Launch the application.
	 */
	public Login() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame("로그인창");
		frame.setVisible(true);
		frame.setResizable(false); // 창크기 임의 조정 불가
		frame.getContentPane().setLayout(null);
		ImagePanel loginPanel = new ImagePanel(new ImageIcon("image/login.png").getImage());
		loginPanel.setBounds(0, 0, 850, 850);
		loginPanel.setBackground(Color.ORANGE);
		loginPanel.setToolTipText("Enter ID");
		frame.setSize(loginPanel.getWidth(), loginPanel.getHeight()); // 그림크기에 맞춰 프레임 가로 세로 조정

		// 메인패널 > 팀 현황 귤점,평점 버튼등
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.orange);
		mainPanel.setBounds(0, 0, 1100, 615);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setVisible(false);

		JLabel mainScreenLabel = new JLabel("Welcome \uADDC\uB9AC\uC9F1\uC758 \uADE4\uC810\uC81C!");
		mainScreenLabel.setFont(new Font("함초롱바탕", Font.BOLD, 20));
		mainScreenLabel.setBounds(420, 36, 388, 51);
		mainPanel.add(mainScreenLabel);
		frame.getContentPane().add(loginPanel);
		
		JLabel lblLogin = new JLabel("login");
		lblLogin.setFont(new Font("함초롱바탕", Font.BOLD, 20));
		lblLogin.setBounds(192, 260, 67, 47);
		loginPanel.add(lblLogin);

		JLabel lblNewLabel = new JLabel("ID  :");
		lblNewLabel.setFont(new Font("함초롱바탕", Font.PLAIN, 18));
		lblNewLabel.setBounds(60, 320, 57, 27);
		loginPanel.add(lblNewLabel);

		textid = new JTextField();
		textid.setFont(new Font("함초롱바탕", Font.PLAIN, 18));
		textid.setToolTipText("Enter ID");
		textid.setBounds(115, 320, 186, 27);
		loginPanel.add(textid);
		textid.setColumns(10);

		JLabel lblPassword = new JLabel("PW :");
		lblPassword.setFont(new Font("함초롱바탕", Font.PLAIN, 18));
		lblPassword.setBounds(60, 355, 57, 27);
		loginPanel.add(lblPassword);

		textpw = new JPasswordField();
		textpw.setFont(new Font("함초롱바탕", Font.PLAIN, 18));
		textpw.setToolTipText("Enter Passwod");
		textpw.setBounds(115, 355, 186, 27);
		loginPanel.add(textpw);

		JButton btnNewButton = new JButton("Login");

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (textid.getText().equals("smile") && Arrays.equals(textpw.getPassword(), "12345".toCharArray())) {
					JOptionPane.showMessageDialog(null, "환영합니다");
					dispose(); // 안먹힘
					new sub();
				} else {
					JOptionPane.showMessageDialog(null, "아이디와 패스워드를 확인해주세요");
				}

			}
		});

		Action ok = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (textid.getText().equals("smile") && Arrays.equals(textpw.getPassword(), "12345".toCharArray())) {
					JOptionPane.showMessageDialog(null, "환영합니다");
					dispose(); // 안먹힘
					new sub();
				} else {
					JOptionPane.showMessageDialog(null, "아이디와 패스워드를 확인해주세요");
				}

			}
		};
		
		textid.setFocusTraversalKeysEnabled(false);
		textid.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB)
					textpw.requestFocus();
			}
		});
		
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
		textpw.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
		textpw.getActionMap().put("ENTER", ok);
		textid.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
		textid.getActionMap().put("ENTER", ok);
		
		btnNewButton.setBackground(new Color(255,153,051));
		btnNewButton.setFont(new Font("함초롱바탕", Font.PLAIN, 12));
		btnNewButton.setBounds(310, 320, 65, 65);
		loginPanel.add(btnNewButton);

		frame.setLocationRelativeTo(null); // 창화면 중앙에 뜨기

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

	public String clockString() {
		Calendar time = Calendar.getInstance();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String format_time1 = format1.format(time.getTime());
		return format_time1;
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
		g.setFont(new Font("함초롱바탕", Font.BOLD, 18));
		g.drawString(clockString(), 230, 510);
		this.repaint();
	}

	public void repaint() {
		super.repaint();
	}
}
