package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MarkBase  {
	private JFrame frame;
	private JPanel contentPane;
	private JPanel panel_3;
	private JPanel panel_2;
	private JPanel panel_1;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarkBase frame1 = new MarkBase();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MarkBase() {
		frame=new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1032, 788);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		 panel = new JPanel();
		contentPane.add(panel, "t1");
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MarkBase.class.getResource("/newImage/SubjectData/subject(1060x817) blur.jpg")));
		lblNewLabel.setBounds(0, 0, 1004, 731);
		panel.add(lblNewLabel);
		
		 panel_1 = new JPanel();
		contentPane.add(panel_1, "t2");
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MarkBase.class.getResource("/newImage/createStaff/Create User(1060x817) blur.jpg")));
		lblNewLabel_1.setBounds(0, 0, 1004, 731);
		panel_1.add(lblNewLabel_1);
		
		 panel_2 = new JPanel();
		contentPane.add(panel_2, "t3");
		panel_2.setLayout(null);
		
		 panel_3 = new JPanel();
		contentPane.add(panel_3, "t4");
		panel_3.setLayout(null);
	}

	public Container getContentPane() {
		// TODO Auto-generated method stub
		return contentPane;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
