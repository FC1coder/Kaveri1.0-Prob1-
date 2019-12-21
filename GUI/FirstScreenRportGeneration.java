package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FirstScreenRportGeneration{
    private JFrame frame;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnPlacePdf;
	private JButton btnReportResult;
	private JButton btnStudentData;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					FirstScreenRportGeneration frame1 = new FirstScreenRportGeneration();
					//frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FirstScreenRportGeneration() {
		frame=new JFrame("Selection Screen");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 489, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("SubjectData");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MarkBase mb=new MarkBase();
				CardLayout c = (CardLayout) (mb.getContentPane().getLayout());
				c.show(mb.getContentPane(), "t2");
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setForeground(Color.GRAY);
		btnNewButton.setBounds(53, 109, 161, 62);
		contentPane.add(btnNewButton);
		
		btnPlacePdf = new JButton("Place PDF");
		btnPlacePdf.setForeground(Color.GRAY);
		btnPlacePdf.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnPlacePdf.setBounds(225, 186, 161, 62);
		contentPane.add(btnPlacePdf);
		
		btnReportResult = new JButton("Report Result");
		btnReportResult.setEnabled(false);
		btnReportResult.setForeground(Color.GRAY);
		btnReportResult.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnReportResult.setBounds(53, 259, 161, 62);
		contentPane.add(btnReportResult);
		
		btnStudentData = new JButton("Student Data");
		btnStudentData.setEnabled(false);
		btnStudentData.setForeground(Color.GRAY);
		btnStudentData.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnStudentData.setBounds(225, 332, 161, 62);
		contentPane.add(btnStudentData);
		
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(FirstScreenRportGeneration.class.getResource("/newImage/StudentData/Student data blur(1060x817).jpg")));
		lblNewLabel.setBounds(0, 0, 471, 500);
		contentPane.add(lblNewLabel);
	}
}
