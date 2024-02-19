package CarRentalManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import TestWork.login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	private static final long serialVersionUID = 1L;
	 JPanel contentPane;
	private JTextField idtxf;
	private JTextField fntxf;
	private JTextField lntxf;
	private JTextField usertxf;
	private JTextField passtxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 662);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREATE ACCOUNT");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(50, 11, 583, 55);
		contentPane.add(lblNewLabel);
		
		JLabel idlb = new JLabel("ID");
		idlb.setForeground(new Color(255, 255, 255));
		idlb.setFont(new Font("Tahoma", Font.ITALIC, 45));
		idlb.setBounds(12, 123, 253, 48);
		contentPane.add(idlb);
		
		idtxf = new JTextField();
		idtxf.setBounds(10, 168, 360, 42);
		contentPane.add(idtxf);
		idtxf.setColumns(10);
		
		JLabel fnlb = new JLabel("FirstName");
		fnlb.setForeground(new Color(255, 255, 255));
		fnlb.setFont(new Font("Tahoma", Font.ITALIC, 45));
		fnlb.setBounds(9, 206, 253, 48);
		contentPane.add(fnlb);
		
		fntxf = new JTextField();
		fntxf.setColumns(10);
		fntxf.setBounds(10, 253, 360, 42);
		contentPane.add(fntxf);
		
		JLabel lblPleaseDoNot = new JLabel("PLEASE DO NOT FORGET USERNAME AND PASSWORD");
		lblPleaseDoNot.setBackground(Color.GRAY);
		lblPleaseDoNot.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseDoNot.setForeground(Color.RED);
		lblPleaseDoNot.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPleaseDoNot.setBounds(-47, 77, 833, 55);
		contentPane.add(lblPleaseDoNot);
		
		JLabel lnlb = new JLabel("LastName");
		lnlb.setForeground(new Color(255, 255, 255));
		lnlb.setFont(new Font("Tahoma", Font.ITALIC, 45));
		lnlb.setBounds(15, 297, 266, 48);
		contentPane.add(lnlb);
		
		lntxf = new JTextField();
		lntxf.setColumns(10);
		lntxf.setBounds(14, 347, 360, 42);
		contentPane.add(lntxf);
		
		usertxf = new JTextField();
		usertxf.setColumns(10);
		usertxf.setBounds(10, 438, 360, 42);
		contentPane.add(usertxf);
		
		JLabel userlb = new JLabel("UserName");
		userlb.setForeground(new Color(255, 255, 255));
		userlb.setFont(new Font("Tahoma", Font.ITALIC, 45));
		userlb.setBounds(17, 391, 266, 48);
		contentPane.add(userlb);
		
		JLabel passlb = new JLabel("PassWord");
		passlb.setForeground(new Color(255, 255, 255));
		passlb.setFont(new Font("Tahoma", Font.ITALIC, 45));
		passlb.setBounds(17, 478, 266, 48);
		contentPane.add(passlb);
		
		passtxf = new JTextField();
		passtxf.setColumns(10);
		passtxf.setBounds(10, 524, 360, 42);
		contentPane.add(passtxf);
		
		JButton signupbtn = new JButton("SIGN UP");
		signupbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_management_system","root","");
				String sql="INSERT INTO signup VALUES(?,?,?,?,?)";	
				PreparedStatement st=con.prepareStatement(sql);
				st.setInt(1, Integer.parseInt(idtxf.getText()));
				st.setString(2, fntxf.getText());
				st.setString(3, lntxf.getText());
				st.setString(4, usertxf.getText());
				st.setString(5,passtxf.getText());
				JOptionPane.showMessageDialog(signupbtn, "data saved");
				st.executeUpdate();
				con.close();
				st.close();
				
					
					
					
					
					
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
				
				Login log= new Login();
				log.setVisible(true);
				dispose();
					
							}
		});
		signupbtn.setForeground(new Color(0, 128, 255));
		signupbtn.setFont(new Font("Tahoma", Font.BOLD, 27));
		signupbtn.setBounds(403, 168, 187, 55);
		contentPane.add(signupbtn);
		
		JButton Cancelbtn = new JButton("CANCEL");
		Cancelbtn.setForeground(new Color(0, 128, 255));
		Cancelbtn.setFont(new Font("Tahoma", Font.BOLD, 27));
		Cancelbtn.setBounds(403, 235, 187, 55);
		contentPane.add(Cancelbtn);
	}
}
