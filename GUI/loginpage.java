package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.UIManager;

import jdbctry.GetConnection;

import java.awt.Toolkit;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class loginpage {

	private JFrame frmLogin;
	private JTextField username;
	private JPasswordField passwordField;
	private JButton btn2;
	private JPanel panel;
	private JLabel label_1;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginpage window = new loginpage();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setTitle("Login ");
		frmLogin.setForeground(Color.GRAY);
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Mahi\\Downloads\\login.png"));
		frmLogin.getContentPane().setBackground(UIManager.getColor("textHighlight"));
		frmLogin.getContentPane().setForeground(new Color(135, 206, 250));
		frmLogin.setBounds(200, 200, 660, 413);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(new CardLayout(0, 0));
		JPanel home = new JPanel(null);
		home.setBackground(SystemColor.textHighlight);
		username = new JTextField();
		username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		username.setBounds(373, 104, 211, 32);
		// frmLogin.getContentPane().add(username);
		home.add(username);
		username.setColumns(10);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setBounds(273, 108, 94, 24);
		// frmLogin.getContentPane().add(lblUserName);
		home.add(lblUserName);
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(273, 145, 85, 24);
		// frmLogin.getContentPane().add(lblPassword);
		home.add(lblPassword);
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(373, 149, 211, 22);
		// frmLogin.getContentPane().add(passwordField);
		home.add(passwordField);
		btnLogin = new JButton("");
		btnLogin.setDefaultCapable(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setOpaque(false);

		btnLogin.setIcon(new ImageIcon(loginpage.class.getResource("/image/login button.jpg")));
		btnLogin.setBounds(373, 206, 118, 37);
		// frmLogin.getContentPane().add(btnLogin);
		home.add(btnLogin);
		frmLogin.getContentPane().add(home, "t1");
		 label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(loginpage.class.getResource("/image/login 1.jpg")));
		label_1.setBounds(0, 0, 654, 378);
		home.add(label_1);
		 panel = new JPanel(null);
		frmLogin.getContentPane().add(panel, "t2");
		panel.setLayout(null);
		btn2 = new JButton("");
		btn2.setHorizontalTextPosition(SwingConstants.CENTER);
		btn2.setIcon(new ImageIcon(loginpage.class.getResource("/image/search button(191x72).jpg")));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						frmLogin.dispose();
						FirstScreenRportGeneration frame = new FirstScreenRportGeneration();
						//frame.setVisible(true);
					}		
		});
		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Statement stmt;
				ResultSet rs;
				
				Connection con = (Connection) (new GetConnection().connectionobj());
				try {
					stmt = con.createStatement();

					rs = stmt.executeQuery("select * from Users;");
					int f=1;
					while (rs.next()) {
						String str = rs.getString(2);
						String str2 = rs.getString(3);
						if (str.equals(username.getText())) {
							String str3 = new String(passwordField.getPassword());
							if (str2.equals(str3)) {
								username.setText("");
								passwordField.setText("");
								CardLayout c = (CardLayout) (frmLogin.getContentPane().getLayout());
								c.show(frmLogin.getContentPane(), "t2");
								f=0;
								break;
								
							} else {
								JOptionPane.showMessageDialog(null, "Invalid Password ");
							}
						} 
					}
						if (f==1) {
							JOptionPane.showMessageDialog(null, "Invalid Username ");
						}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		JButton btn1 = new JButton("");
		btn1.setIcon(new ImageIcon(loginpage.class.getResource("/image2/CriditBase(191x72).jpg")));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLogin.dispose();
			//	filechooser frame = new filechooser();
				//frame.setVisible(true);
			}
		});
		btn1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btn1.setBounds(298, 168, 191, 72);
		panel.add(btn1);
		btn2.setForeground(SystemColor.inactiveCaptionText);
		btn2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btn2.setBounds(53, 168, 191, 72);
		panel.add(btn2);
		
		JButton btnNewButton = new JButton("logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c = (CardLayout) (frmLogin.getContentPane().getLayout());
				c.show(frmLogin.getContentPane(), "t1");
			}
		});
		btnNewButton.setBounds(545, 13, 97, 25);
		panel.add(btnNewButton);
		JLabel label = new JLabel("");
		label.setLabelFor(panel);
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setBounds(0, 0, 654, 378);
		label.setIcon(new ImageIcon(loginpage.class.getResource("/image/login 2.jpg")));
		panel.add(label);
		frmLogin.setVisible(true);
	}

	public JFrame getFrmLogin() {
		return frmLogin;
	}

	
}
