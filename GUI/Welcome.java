package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI.FirstScreenRportGeneration;
import GUI.loginpage;
import jdbctry.GetConnection;
import validation.MyValidation;

import java.awt.CardLayout;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Color;

public class Welcome {

	private JPanel contentPane;
	private JFrame frmWelcome;
	private JTextField t11;
	private JTextField t12;
	private JPasswordField t13;
	private JTextField t15;
	private JPasswordField passwordField;
	private Connection con;
	private JLabel l11;
	private JLabel l12;
	private JLabel l13;
	private JLabel l14;
	private JLabel l15;
	private JLabel l16;
	private JLabel label;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Welcome() {
		con = (Connection) (new GetConnection().connectionobj());
		frmWelcome = new JFrame();
		frmWelcome.setResizable(false);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcome.setBounds(100, 020, 1060, 817);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmWelcome.setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.PINK);
		contentPane.add(panel_1, "t1");
		panel_1.setLayout(null);

		btnNewButton = new JButton("");
	btnNewButton.setIcon(new ImageIcon(Welcome.class.getResource("/WelcomeScreen/Next Button(150x50).jpg")));
		btnNewButton.addActionListener(new ActionListener() {
			private Statement stmt;
			private ResultSet rs;

			public void actionPerformed(ActionEvent arg0) {

				try {
					stmt = con.createStatement();
					rs = stmt.executeQuery("select * from staff;");
					if (rs.isBeforeFirst()) {
						new loginpage();
						frmWelcome.dispose();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				CardLayout c = (CardLayout) (contentPane.getLayout());
				c.show(contentPane, "t2");
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(855, 697, 150, 50);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Welcome.class.getResource("/image2/GROOC.png")));
		lblNewLabel.setBounds(0, 0, 1032, 760);
		panel_1.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.control);
		contentPane.add(panel, "t2");

		t11 = new JTextField();
		t11.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				String str = t11.getText();

				if ((new MyValidation().checkText(str)) == false) {
					l11.setText("alphabit only");
				} else
					l11.setText("");
			}

		});
		t11.setColumns(10);
		t11.setBounds(273, 213, 521, 50);
		panel.add(t11);

		t12 = new JTextField();
		t12.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				String str = t12.getText();

				if ((new MyValidation().checkText(str)) == false) {
					l12.setText("alphabit only");
				} else
					l12.setText("");
			}
		});
		t12.setFont(new Font("Times New Roman", Font.BOLD, 15));
		t12.setColumns(10);
		t12.setBounds(273, 276, 521, 50);
		panel.add(t12);

		t13 = new JPasswordField();
		t13.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				String str = t13.getText();

				if ((new MyValidation().checkPassword(str)) == false) {
					JOptionPane.showMessageDialog(null, "one lowercase letter \n one digit i.e. 0-9 \n one special character \n one capital letter \n minimum 6 letters to maximum 16 letters");
					
				} else
					l11.setText("");
				if ((new MyValidation().checkPassword(str)) == false)
				l11.setText("invalid password");
			}
		});
		t13.setFont(new Font("Times New Roman", Font.BOLD, 15));
		t13.setEchoChar('*');
		t13.setBounds(273, 339, 522, 50);
		panel.add(t13);

		t15 = new JTextField();
		t15.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				String str=t15.getText();
				if((str.length())==10){
					if ((new MyValidation().checkPhoneno(str)) == false) {
						l15.setText("numaric length 10");
					} else
						l15.setText("");
				}else
					l15.setText("numaric length 10");
			}
		});
		
				passwordField = new JPasswordField();
				passwordField.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent arg0) {
						if(t13.getText().equals(passwordField.getText())){
							l14.setText("");
						}else
							l14.setText("password dosen't match");
					}
				});
				passwordField.setFont(new Font("Times New Roman", Font.BOLD, 15));
				passwordField.setEchoChar('*');
				passwordField.setBounds(272, 402, 522, 50);
				panel.add(passwordField);
		t15.setFont(new Font("Times New Roman", Font.BOLD, 15));
		t15.setColumns(10);
		t15.setBounds(273, 465, 521, 50);
		panel.add(t15);

		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblContactNumber.setBounds(52, 462, 194, 50);
		panel.add(lblContactNumber);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblUserName.setBounds(52, 276, 166, 50);
		panel.add(lblUserName);

		JLabel lblStaffName = new JLabel("Staff Name");
		lblStaffName.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblStaffName.setBounds(52, 213, 166, 50);
		panel.add(lblStaffName);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblPassword.setBounds(52, 336, 166, 50);
		panel.add(lblPassword);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Welcome.class.getResource("/WelcomeScreen/Submit Button(150x50).jpg")));
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Statement stmt;
				ResultSet rs;
				t11.setText(t11.getText().trim());
				t12.setText(t12.getText().trim());
				t13.setText(t13.getText().trim());
				t15.setText(t15.getText().trim());
				l16.setText("");
				if (t11.getText().equals("") || t12.getText().equals("") || t13.getText().equals("")
						|| t15.getText().equals("") || passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "No Field should be blank");
				} else if (t11.getText().equals(null) || t12.getText().equals(null) || t13.getText().equals(null)
						|| t15.getText().equals(null) || passwordField.getText().equals(null)) {
					JOptionPane.showMessageDialog(null, "entered values are null");
				} else if (!(t13.getText().equals(passwordField.getText()))) {
					JOptionPane.showMessageDialog(null, "password enter is not same");
				} else if (con == null) {
					JOptionPane.showMessageDialog(null, "connection not estiblish");
				} else if (l11.getText().equals("") && l12.getText().equals("") && l13.getText().equals("")
						&& l14.getText().equals("") && l15.getText().equals("") && l16.getText().equals("")) {
					try {

						String str = new String(t13.getPassword());
						String sql = "insert into staff values('" + t11.getText() + "','" + t12.getText() + "','" + str
								+ "','" + t15.getText() + "')";
						String sql2 = "insert into users values('" + t12.getText() + "','" + t12.getText() + "','" + str
								+ "')";
						stmt = ((Connection) con).createStatement();
						stmt.executeUpdate(sql2);
						stmt.executeUpdate(sql);
						t11.setText("");
						t12.setText("");
						t13.setText("");
						t15.setText("");
						passwordField.setText("");
						JOptionPane n = new JOptionPane();
						n.setSize(200, 400);
						n.showMessageDialog(null, "User created");
						new loginpage();
						frmWelcome.dispose();
						return;

					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					l16.setText("Fild are not properly entered");
				}

			}
		});
		button.setFont(new Font("Times New Roman", Font.BOLD, 20));
		button.setBounds(273, 596, 150, 50);
		panel.add(button);

		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(Welcome.class.getResource("/WelcomeScreen/Cancel Button.jpg")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmWelcome.dispose();
				return;
			}
		});
		button_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		button_1.setBounds(454, 596, 150, 50);
		panel.add(button_1);

		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(Welcome.class.getResource("/WelcomeScreen/Reset Button.jpg")));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t11.setText("");
				t12.setText("");
				t13.setText("");
				t15.setText("");
				passwordField.setText("");
			}
		});
		button_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		button_2.setBounds(644, 596, 150, 50);
		panel.add(button_2);

		JLabel lblConfirnPassword = new JLabel("Confirm Password");
		lblConfirnPassword.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblConfirnPassword.setBounds(52, 399, 194, 50);
		panel.add(lblConfirnPassword);

		l11 = new JLabel("");
		l11.setForeground(Color.RED);
		l11.setBounds(794, 230, 226, 33);
		panel.add(l11);

		l12 = new JLabel("");
		l12.setForeground(Color.RED);
		l12.setBounds(794, 293, 226, 33);
		panel.add(l12);

		l13 = new JLabel("");
		l13.setForeground(Color.RED);
		l13.setBounds(794, 356, 238, 33);
		panel.add(l13);

		l14 = new JLabel("");
		l14.setForeground(Color.RED);
		l14.setBounds(794, 419, 226, 33);
		panel.add(l14);

		l15 = new JLabel("");
		l15.setForeground(Color.RED);
		l15.setBounds(794, 482, 226, 33);
		panel.add(l15);
		l16 = new JLabel("");
		l16.setForeground(Color.RED);
		l16.setBounds(273, 528, 521, 33);
		panel.add(l16);

		label = new JLabel("");
		label.setIcon(new ImageIcon(Welcome.class.getResource("/newImage/createStaff/Create User(1060x817) blur.jpg")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		//label.setIcon(new ImageIcon(FirstScreenRportGeneration.class.getResource("/WelcomeScreen/welcome Staff Blur(1032x755).jpg")));
		label.setBounds(0, 0, 1032, 760);
		panel.add(label);
		frmWelcome.setVisible(true);
	}
}
