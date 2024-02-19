package CarRentalManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class Customer {

	 JFrame frame;
	private JTextField custtxf;
	private JTextField fntxf;
	private JTextField lntxf;
	private JTextField ematxf;
	private JTextField photxf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer window = new Customer();
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
	public Customer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setTitle("CUSTOMER FORM");
		frame.setBounds(100, 100, 902, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CUSTOMERS FORM IN CAR RENTAL SYSTEM");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(101, 0, 721, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel custlb = new JLabel("customer_id");
		custlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		custlb.setBounds(10, 82, 163, 27);
		frame.getContentPane().add(custlb);
		
		JLabel fnlb = new JLabel("firstname");
		fnlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		fnlb.setBounds(10, 115, 163, 27);
		frame.getContentPane().add(fnlb);
		
		JLabel lnlb = new JLabel("lastname");
		lnlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		lnlb.setBounds(10, 153, 163, 27);
		frame.getContentPane().add(lnlb);
		
		JLabel emalb = new JLabel("email");
		emalb.setFont(new Font("Tahoma", Font.BOLD, 18));
		emalb.setBounds(10, 199, 163, 27);
		frame.getContentPane().add(emalb);
		
		JLabel pholb = new JLabel("phone");
		pholb.setFont(new Font("Tahoma", Font.BOLD, 18));
		pholb.setBounds(10, 242, 163, 27);
		frame.getContentPane().add(pholb);
		
		JButton Insertbtn = new JButton("INSERT");
		Insertbtn.setBackground(new Color(128, 255, 255));
		Insertbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_management_system","root","");
					String query="INSERT INTO customer VALUES (?,?,?,?,?)";
					PreparedStatement stm=con.prepareStatement(query);
					stm.setInt(1,Integer.parseInt(custtxf.getText()));
					stm.setString(2, fntxf.getText());
					stm.setString(3, lntxf.getText());
					stm.setString(4, ematxf.getText());
					stm.setString(5, photxf.getText());
					stm.executeUpdate();
					JOptionPane.showMessageDialog(Insertbtn, "successfull!!");
					stm.close();
					con.close();
				} catch (Exception e2) {
					
				}
			}


		});
		Insertbtn.setForeground(new Color(0, 0, 255));
		Insertbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Insertbtn.setBounds(621, 82, 113, 35);
		frame.getContentPane().add(Insertbtn);
		
		JButton Deletebtn = new JButton("EXIT");
		Deletebtn.setBackground(new Color(128, 255, 255));
		Deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				custtxf.setText(null);
				fntxf.setText(null);
				lntxf.setText(null);
				ematxf.setText(null);
				photxf.setText(null);
			}
		});
		Deletebtn.setForeground(new Color(255, 0, 0));
		Deletebtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Deletebtn.setBounds(621, 217, 113, 35);
		frame.getContentPane().add(Deletebtn);
		
		custtxf = new JTextField();
		custtxf.setBounds(270, 80, 309, 35);
		frame.getContentPane().add(custtxf);
		custtxf.setColumns(10);
		
		fntxf = new JTextField();
		fntxf.setColumns(10);
		fntxf.setBounds(270, 118, 309, 35);
		frame.getContentPane().add(fntxf);
		
		lntxf = new JTextField();
		lntxf.setColumns(10);
		lntxf.setBounds(270, 155, 309, 35);
		frame.getContentPane().add(lntxf);
		
		ematxf = new JTextField();
		ematxf.setColumns(10);
		ematxf.setBounds(270, 195, 309, 35);
		frame.getContentPane().add(ematxf);
		
		photxf = new JTextField();
		photxf.setColumns(10);
		photxf.setBounds(270, 236, 309, 35);
		frame.getContentPane().add(photxf);
		
		JButton btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_management_system","root","");	
				java.sql.Statement st=con.createStatement();
				String query="SELECT * FROM customer";
				ResultSet rs= st.executeQuery(query);
				ResultSetMetaData rsmd=rs.getMetaData();
				
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int cols=rsmd.getColumnCount();
				String[] colName=new String[cols];
				for(int i=0;i<cols;i++)
					colName[i]=rsmd.getColumnName(i+1);
				model.setColumnIdentifiers(colName);
				String customer_id,first_name,last_name,email,phone;
				while(rs.next()) {
					customer_id=rs.getString(1);
					first_name=rs.getString(2);
					last_name=rs.getString(3);
					email=rs.getString(4);
					phone=rs.getString(5);
					
					String[] row= {customer_id,first_name,last_name,email,phone};
					model.addRow(row);
				}
				
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
			}
		});
		btnView.setBackground(new Color(128, 255, 255));
		btnView.setForeground(new Color(0, 128, 192));
		btnView.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnView.setBounds(621, 125, 113, 35);
		frame.getContentPane().add(btnView);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_management_system","root","");	 
			String sql="UPDATE customer SET firstName=?, lastName=?, email=?, phone=? WHERE Customer_id=?";
			PreparedStatement stm=con.prepareStatement(sql);
			
			stm.setString(1, fntxf.getText());
			stm.setString(2, lntxf.getText());
			stm.setString(3, ematxf.getText());
			stm.setString(4, photxf.getText());
			
			stm.setInt(5, Integer.parseInt(custtxf.getText()));
			stm.executeUpdate();
				JOptionPane.showMessageDialog(btnUpdate, "updated data!!");
				con.close();
				stm.close();
				
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				
				
				
				
			}
		});
		btnUpdate.setBackground(new Color(128, 255, 255));
		btnUpdate.setForeground(new Color(0, 0, 255));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBounds(621, 171, 113, 35);
		frame.getContentPane().add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 280, 526, 195);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 0, 255));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME HERE DEAR FRIEND");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(161, 36, 598, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\Saved Pictures\\IMG-20240129-WA0020.jpg"));
		lblNewLabel_2.setBounds(537, 280, 318, 195);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Home hm=new Home();
				hm.setVisible(true);
				frame.dispose();
			}
		});
		btnBack.setForeground(Color.BLUE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBackground(new Color(128, 255, 255));
		btnBack.setBounds(742, 236, 113, 41);
		frame.getContentPane().add(btnBack);
	}
}
