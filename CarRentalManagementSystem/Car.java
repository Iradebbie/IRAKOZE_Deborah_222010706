package CarRentalManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
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
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class Car {

	JFrame frame;
	private JTextField cartxf;
	private JTextField matxf;
	private JTextField motxf;
	private JTextField yetxf;
	private JTextField drtxf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Car window = new Car();
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
	public Car() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setTitle("CAR FORM WITHIN CAR RENTAL MANAGEMENT SYSTEM");
		frame.setBounds(100, 100, 909, 598);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CAR FORM IN CAR RENTAL SYSTEM");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(24, 1, 573, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel carlb = new JLabel("Car_id");
		carlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		carlb.setBounds(10, 78, 169, 22);
		frame.getContentPane().add(carlb);
		
		JLabel malb = new JLabel("Make");
		malb.setFont(new Font("Tahoma", Font.BOLD, 18));
		malb.setBounds(10, 134, 169, 22);
		frame.getContentPane().add(malb);
		
		JLabel molb = new JLabel("Model");
		molb.setFont(new Font("Tahoma", Font.BOLD, 18));
		molb.setBounds(10, 184, 169, 22);
		frame.getContentPane().add(molb);
		
		JLabel yelb = new JLabel("Year");
		yelb.setFont(new Font("Tahoma", Font.BOLD, 18));
		yelb.setBounds(10, 235, 169, 33);
		frame.getContentPane().add(yelb);
		
		JLabel drlb = new JLabel("DailyRate");
		drlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		drlb.setBounds(10, 288, 169, 33);
		frame.getContentPane().add(drlb);
		
		JButton Insertbtn = new JButton("INSERT");
		Insertbtn.setBackground(new Color(255, 255, 128));
		Insertbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_management_system","root","");
				String query="INSERT INTO car VALUES(?,?,?,?,?)";
				PreparedStatement stm=con.prepareStatement(query);
				stm.setInt(1, Integer.parseInt(cartxf.getText()));
				stm.setString(2, matxf.getText());
				stm.setString(3, motxf.getText());
				stm.setString(4, yetxf.getText());
				stm.setString(5, drtxf.getText());
				stm.executeUpdate();
				JOptionPane.showMessageDialog(Insertbtn,"successfuly!!!!!!!!!!!!!");
				stm.close();
				stm.close();
				
				} catch (Exception e2) {
					
				}
			}
		});
		Insertbtn.setForeground(new Color(0, 0, 255));
		Insertbtn.setFont(new Font("Tahoma", Font.BOLD, 19));
		Insertbtn.setBounds(370, 124, 125, 40);
		frame.getContentPane().add(Insertbtn);
		
		JButton Deletebtn = new JButton("RESET");
		Deletebtn.setBackground(new Color(255, 255, 128));
		Deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartxf.setText(null);
				matxf.setText(null);
				motxf.setText(null);
				yetxf.setText(null);
				drtxf.setAction(null);
			}
		});
		Deletebtn.setForeground(new Color(255, 0, 0));
		Deletebtn.setFont(new Font("Tahoma", Font.BOLD, 19));
		Deletebtn.setBounds(370, 274, 125, 40);
		frame.getContentPane().add(Deletebtn);
		
		cartxf = new JTextField();
		cartxf.setBounds(10, 103, 350, 27);
		frame.getContentPane().add(cartxf);
		cartxf.setColumns(10);
		
		matxf = new JTextField();
		matxf.setColumns(10);
		matxf.setBounds(10, 154, 350, 27);
		frame.getContentPane().add(matxf);
		
		motxf = new JTextField();
		motxf.setColumns(10);
		motxf.setBounds(10, 207, 350, 27);
		frame.getContentPane().add(motxf);
		
		yetxf = new JTextField();
		yetxf.setColumns(10);
		yetxf.setBounds(10, 266, 350, 27);
		frame.getContentPane().add(yetxf);
		
		drtxf = new JTextField();
		drtxf.setColumns(10);
		drtxf.setBounds(10, 320, 350, 27);
		frame.getContentPane().add(drtxf);
		
		JButton btnView = new JButton("VIEW");
		btnView.setBackground(new Color(255, 255, 128));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_management_system","root","");
				java.sql.Statement st=con.createStatement();
				String query="SELECT * FROM car";
				ResultSet rs= st.executeQuery(query);
				ResultSetMetaData rsmd=rs.getMetaData();
				
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int cols=rsmd.getColumnCount();
				String[] colName=new String[cols];
				for(int i=0;i<cols;i++)
					colName[i]=rsmd.getColumnName(i+1);
				model.setColumnIdentifiers(colName);
				String Car_id,Make,Model,Year,dailyRate;	
			while(rs.next()) 
			{
			Car_id=rs.getString(1);
			Make=rs.getString(2);
			Model=rs.getString(3);
			Year=rs.getString(4);
			dailyRate=rs.getString(5);
			String[]row= {Car_id,Make,Model,Year,dailyRate};
			model.addRow(row);
				
				
				
				
				
			}	
				
				
				
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				
			}
		});
		btnView.setForeground(new Color(0, 0, 255));
		btnView.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnView.setBounds(370, 175, 125, 40);
		frame.getContentPane().add(btnView);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_management_system","root","");
				
				String sql="UPDATE car SET Make=?, Model=?, Year=?, Daily_Rate=? WHERE car_id=?";
				PreparedStatement stm=con.prepareStatement(sql);	
				stm.setString(1, matxf.getText());
				stm.setString(2, motxf.getText());
				stm.setString(3, yetxf.getText());
				stm.setString(4, drtxf.getText());
				stm.setInt(5, Integer.parseInt(cartxf.getText()));
				stm.executeUpdate();
				JOptionPane.showMessageDialog(Insertbtn,"changed data!!");
				stm.close();
				stm.close();	
				
				
				
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
			}
		});
		btnUpdate.setBackground(new Color(255, 255, 128));
		btnUpdate.setForeground(new Color(0, 0, 255));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnUpdate.setBounds(370, 228, 125, 40);
		frame.getContentPane().add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 358, 477, 192);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 128, 255));
		table.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hm=new Home();
				hm.setVisible(true);
				frame.dispose();
			}
		});
		btnBack.setForeground(Color.BLUE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnBack.setBackground(new Color(255, 255, 128));
		btnBack.setBounds(723, 514, 125, 47);
		frame.getContentPane().add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBounds(530, 46, 299, 457);
		frame.getContentPane().add(panel);
		panel.setBorder(new LineBorder(new Color(0, 0, 255), 13));
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\PC\\Documents\\kigali.jpg"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 9, 279, 379);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CITY ONE");
		lblNewLabel_2.setForeground(new Color(0, 128, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(86, 399, 142, 47);
		panel.add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 9, 301, 459);
		panel.add(scrollPane_1);
	}
}
