package CarRentalManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Admin {

	 JFrame frame;
	private JTextField adtxf;
	private JTextField fntxf;
	private JTextField lntxf;
	private JTextField ematxf;
	private JTextField photxf;
	private JTable table;
	private JTextField potxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 128, 128));
		frame.setTitle("ADMIN FORM FROM CAR RENTAL MANAGEMENT SYSTEM");
				frame.setBounds(100, 100, 909, 581);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN FORM FROM CAR RENTAL SYSTEM");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 664, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel adlb = new JLabel("Admin_id");
		adlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		adlb.setBounds(0, 90, 138, 36);
		frame.getContentPane().add(adlb);
		
		JLabel fnlb = new JLabel("FirstName");
		fnlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		fnlb.setBounds(0, 138, 138, 36);
		frame.getContentPane().add(fnlb);
		
		JLabel lnlb = new JLabel("LastName");
		lnlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		lnlb.setBounds(0, 184, 138, 36);
		frame.getContentPane().add(lnlb);
		
		JLabel emalb = new JLabel("Email");
		emalb.setFont(new Font("Tahoma", Font.BOLD, 18));
		emalb.setBounds(0, 230, 138, 36);
		frame.getContentPane().add(emalb);
		
		JLabel pholb = new JLabel("PhoneNumber");
		pholb.setFont(new Font("Tahoma", Font.BOLD, 18));
		pholb.setBounds(0, 272, 138, 36);
		frame.getContentPane().add(pholb);
		
		JLabel polb = new JLabel("Position");
		polb.setFont(new Font("Tahoma", Font.BOLD, 18));
		polb.setBounds(0, 318, 138, 36);
		frame.getContentPane().add(polb);
		
		JButton Insertbtn = new JButton("INSERT");
		Insertbtn.setBackground(new Color(255, 255, 128));
		Insertbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hm=new Home();
				hm.setVisible(true);
				frame.dispose();
				try {
					
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_management_system","root","");
				String sql="INSERT INTO admin VALUES(?,?,?,?,?,?)";	
				PreparedStatement stm=con.prepareStatement(sql);
				stm.setInt(1, Integer.parseInt(adtxf.getText()));
				stm.setString(2, fntxf.getText());
				stm.setString(3, lntxf.getText());
				stm.setString(4, ematxf.getText());
				stm.setString(5, photxf.getText());
				stm.setString(6,potxf.getText());
				stm.executeUpdate();
				JOptionPane.showMessageDialog(Insertbtn, "saved data!!");
				
				con.close();
				stm.close();
				
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		Insertbtn.setForeground(new Color(0, 0, 255));
		Insertbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Insertbtn.setBounds(444, 149, 117, 42);
		frame.getContentPane().add(Insertbtn);
		
		JButton Viewbtn = new JButton("VIEW");
		Viewbtn.setBackground(new Color(255, 255, 128));
		Viewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {   
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_management_system","root","");	
				java.sql.Statement st=con.createStatement();
				String query="SELECT * FROM admin";
				ResultSet rs= st.executeQuery(query);
				ResultSetMetaData rsmd=rs.getMetaData();
				
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int cols=rsmd.getColumnCount();
				String[] colName=new String[cols];
				for(int i=0;i<cols;i++)
					colName[i]=rsmd.getColumnName(i+1);
				model.setColumnIdentifiers(colName);
				String admin_id,first_name,last_name,email,phone,position;
				while(rs.next()) {
					admin_id=rs.getString(1);
					first_name=rs.getString(2);
					last_name=rs.getString(3);
					email=rs.getString(4);
					phone=rs.getString(5);
					position=rs.getString(6);
					String[] row= {admin_id,first_name,last_name,email,phone,position};
					model.addRow(row);
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				
				
				
			}
		});
		Viewbtn.setForeground(new Color(0, 0, 255));
		Viewbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Viewbtn.setBounds(444, 195, 117, 42);
		frame.getContentPane().add(Viewbtn);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(new Color(255, 255, 128));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_management_system","root","");	 
			String sql="UPDATE admin SET first_name=?, last_name=?, email=?, phone_number=?, position=? WHERE admin_id=?";
			PreparedStatement stm=con.prepareStatement(sql);
			
			stm.setString(1, fntxf.getText());
			stm.setString(2, lntxf.getText());
			stm.setString(3, ematxf.getText());
			stm.setString(4, photxf.getText());
			stm.setString(5,potxf.getText());
			stm.setInt(6, Integer.parseInt(adtxf.getText()));
			stm.executeUpdate();
				JOptionPane.showMessageDialog(btnUpdate, "updated data!!");
				con.close();
				stm.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				
			}
		});
		btnUpdate.setForeground(new Color(0, 0, 255));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBounds(444, 241, 117, 42);
		frame.getContentPane().add(btnUpdate);
		
		JButton Deletebtn = new JButton("DELETE");
		Deletebtn.setBackground(new Color(255, 255, 128));
		Deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_management_system","root","");
				 String sql = "DELETE FROM admin WHERE admin_id=?";
				  int adtxf=Integer.parseInt(JOptionPane.showInputDialog("Enter admin_ID to delete:"));	
				PreparedStatement stm=con.prepareStatement(sql);
				stm.setInt(1, adtxf);
				Component Delete;
				JOptionPane.showMessageDialog(Deletebtn, "record out!!");
				 stm.executeUpdate();
				  stm.close();
				  con.close();
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				
				
			}
		});
		Deletebtn.setForeground(new Color(0, 0, 255));
		Deletebtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Deletebtn.setBounds(444, 287, 117, 42);
		frame.getContentPane().add(Deletebtn);
		
		adtxf = new JTextField();
		adtxf.setBounds(164, 93, 245, 36);
		frame.getContentPane().add(adtxf);
		adtxf.setColumns(10);
		
		fntxf = new JTextField();
		fntxf.setColumns(10);
		fntxf.setBounds(164, 140, 245, 36);
		frame.getContentPane().add(fntxf);
		
		lntxf = new JTextField();
		lntxf.setColumns(10);
		lntxf.setBounds(164, 185, 245, 36);
		frame.getContentPane().add(lntxf);
		
		ematxf = new JTextField();
		ematxf.setColumns(10);
		ematxf.setBounds(164, 232, 245, 36);
		frame.getContentPane().add(ematxf);
		
		photxf = new JTextField();
		photxf.setColumns(10);
		photxf.setBounds(164, 279, 245, 36);
		frame.getContentPane().add(photxf);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 365, 578, 130);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME  HERE ");
		lblNewLabel_1.setBackground(new Color(64, 128, 128));
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 53, 525, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		potxf = new JTextField();
		potxf.setColumns(10);
		potxf.setBounds(164, 325, 245, 36);
		frame.getContentPane().add(potxf);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\Saved Pictures\\IMG-20240129-WA0015.jpg"));
		lblNewLabel_2.setBounds(581, 66, 297, 186);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("C:\\Users\\PC\\Downloads\\WhatsApp Image 2024-02-01 at 01.06.42.jpeg"));
		label.setBounds(581, 214, 277, 310);
		frame.getContentPane().add(label);
	}
}
