package CarRentalManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.log.Log;
import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import TestWork.login;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 579);
		contentPane = new JPanel();
		setTitle("WELCOME   OUR HAOME  PAGE    DEAR    MEMBERS");
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME OUR HOME PAGE");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel.setBounds(24, 0, 659, 53);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("CUSTOMERS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer st=new Customer();
				st.frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton.setBounds(43, 87, 217, 53);
		contentPane.add(btnNewButton);
		
		JButton btnCars = new JButton("CARS");
		btnCars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car c=new Car();
				c.frame.setVisible(true);
				dispose();
			}
		});
		btnCars.setForeground(Color.BLUE);
		btnCars.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnCars.setBounds(43, 149, 217, 53);
		contentPane.add(btnCars);
		
		JButton btnLoyalty_1 = new JButton("LOYALTY");
		btnLoyalty_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loyalty lo=new Loyalty();
				lo.frame.setVisible(true);
				dispose();
			}
		});
		btnLoyalty_1.setForeground(Color.BLUE);
		btnLoyalty_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnLoyalty_1.setBounds(43, 213, 217, 53);
		contentPane.add(btnLoyalty_1);
		
		JButton btnServerlog = new JButton("SERVERLOG");
		btnServerlog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServerLog log= new ServerLog();
				log.frame.setVisible(true);
				dispose();
			}
		});
		btnServerlog.setForeground(Color.BLUE);
		btnServerlog.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnServerlog.setBounds(43, 282, 217, 53);
		contentPane.add(btnServerlog);
		
		JButton btnLoyalty = new JButton("ADMIN");
		btnLoyalty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin ad= new Admin();
				ad.frame.setVisible(true);
				dispose();
			}
		});
		btnLoyalty.setForeground(Color.BLUE);
		btnLoyalty.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnLoyalty.setBounds(43, 345, 217, 53);
		contentPane.add(btnLoyalty);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(new Color(255, 0, 0));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp up= new SignUp();
				up.setVisible(true);
			dispose();
			}
		});
		btnBack.setForeground(Color.BLUE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnBack.setBounds(717, 455, 131, 76);
		contentPane.add(btnBack);
		
		JButton btnLogout = new JButton("log out");
		btnLogout.setBackground(new Color(255, 128, 128));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Login log=new Login();
			log.setVisible(true);
			dispose();
		
			}
		});
		btnLogout.setForeground(Color.BLUE);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnLogout.setBounds(693, 0, 138, 72);
		contentPane.add(btnLogout);
	}
}
