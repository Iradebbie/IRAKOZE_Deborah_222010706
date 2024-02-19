package CarRentalManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	 JPanel contentPane;
	 private JTextField logintxf;
	 private JTextField passtxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 523);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		setTitle("LOG     IN     FORM IN CAR  RENTAL  MANAGEMENT   SYSTEM");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN FORM IS HERE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(122, 11, 561, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 55));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(219, 116, 296, 63);
		contentPane.add(lblNewLabel_1);
		
		logintxf = new JTextField();
		logintxf.setBounds(58, 190, 595, 49);
		contentPane.add(logintxf);
		logintxf.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("PassWord");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 55));
		lblNewLabel_1_1.setBounds(219, 238, 330, 63);
		contentPane.add(lblNewLabel_1_1);
		
		passtxf = new JTextField();
		passtxf.setColumns(10);
		passtxf.setBounds(58, 312, 595, 44);
		contentPane.add(passtxf);
		
		JButton loginbtn = new JButton("LOG IN");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Home hm	=new Home();
			hm.setVisible(true);
			dispose();
				
				
			}
		});
		loginbtn.setForeground(new Color(0, 128, 255));
		loginbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		loginbtn.setBounds(201, 429, 142, 49);
		contentPane.add(loginbtn);
	}
}
