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

public class Loyalty {

	 JFrame frame;
	private JTextField protxf;
	private JTextField pntxf;
	private JTextField rttxf;
	private JTextField rdtxf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loyalty window = new Loyalty();
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
	public Loyalty() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("WELCOME TO LOYALTY FORM IN CAR RENTAL SYSTEM");
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 879, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOYALTY FORM IN CAR RENTAL SYSTEM");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 652, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel prolb = new JLabel("programID");
		prolb.setFont(new Font("Tahoma", Font.BOLD, 18));
		prolb.setBounds(10, 81, 187, 37);
		frame.getContentPane().add(prolb);
		
		JLabel pnlb = new JLabel("programName");
		pnlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		pnlb.setBounds(10, 148, 187, 37);
		frame.getContentPane().add(pnlb);
		
		JLabel rtlb = new JLabel("rewardThreshold");
		rtlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		rtlb.setBounds(10, 216, 187, 37);
		frame.getContentPane().add(rtlb);
		
		JLabel rdlb = new JLabel("rewordDescription");
		rdlb.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdlb.setBounds(5, 282, 187, 37);
		frame.getContentPane().add(rdlb);
		
		JButton Insertbtn = new JButton("INSERT");
		Insertbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hm=new Home();
				hm.setVisible(true);
				frame.dispose();
				
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_management_system","root","");	
				String sql="INSERT INTO loyalty VALUES(?,?,?,?)";	
				PreparedStatement stm=con.prepareStatement(sql);
				stm.setInt(1, Integer.parseInt(protxf.getText()));
				stm.setString(2, pntxf.getText());
				stm.setString(3, rttxf.getText());
				stm.setString(4, rdtxf.getText());
				stm.executeUpdate();
				JOptionPane.showMessageDialog(Insertbtn, "saved data!!");
				con.close();
				stm.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
			}
		});
		Insertbtn.setBackground(new Color(128, 255, 255));
		Insertbtn.setForeground(new Color(0, 0, 255));
		Insertbtn.setFont(new Font("Tahoma", Font.BOLD, 19));
		Insertbtn.setBounds(550, 85, 116, 42);
		frame.getContentPane().add(Insertbtn);
		
		JButton Viewbtn = new JButton("VIEW");
		Viewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_management_system","root","");	
				java.sql.Statement st=con.createStatement();
				String query="SELECT * FROM loyalty";
				ResultSet rs= st.executeQuery(query);
				ResultSetMetaData rsmd=rs.getMetaData();
				
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int cols=rsmd.getColumnCount();
				String[] colName=new String[cols];
				for(int i=0;i<cols;i++)
					colName[i]=rsmd.getColumnName(i+1);
				model.setColumnIdentifiers(colName);	
				
				String 		PROGRAMMER_ID,PROGRAMME_NAME,REWORD_THRESHOLD,REWORD_DESCRIPTION;
				while(rs.next()) {
					PROGRAMMER_ID=rs.getString(1);
					PROGRAMME_NAME=rs.getString(2);
					REWORD_THRESHOLD=rs.getString(3);
					REWORD_DESCRIPTION=rs.getString(4);
					
					String[] row= {PROGRAMMER_ID,PROGRAMME_NAME,REWORD_THRESHOLD,REWORD_DESCRIPTION};
					model.addRow(row);
				}
				
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
			}
		});
		Viewbtn.setBackground(new Color(128, 255, 255));
		Viewbtn.setForeground(Color.BLUE);
		Viewbtn.setFont(new Font("Tahoma", Font.BOLD, 19));
		Viewbtn.setBounds(550, 147, 116, 42);
		frame.getContentPane().add(Viewbtn);
		
		JButton Updatebtn = new JButton("UPDATE");
		Updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_management_system","root","");
				String sql="UPDATE loyalty SET program_name=?,reword_threshold=?,reward_description=? WHERE program_id=?";
				PreparedStatement stm=con.prepareStatement(sql);	
				stm.setString(1, pntxf.getText());
				stm.setString(2, rttxf.getText());
				stm.setString(3, rdtxf.getText());
				stm.setInt(4, Integer.parseInt(protxf.getText()));
				stm.executeUpdate();
				
	JOptionPane.showMessageDialog(Updatebtn, "change data now!!");			
				
	stm.close();
	con.close();
				
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}	
				
				
				
				
			}
		});
		Updatebtn.setBackground(new Color(128, 255, 255));
		Updatebtn.setForeground(Color.BLUE);
		Updatebtn.setFont(new Font("Tahoma", Font.BOLD, 19));
		Updatebtn.setBounds(550, 215, 116, 42);
		frame.getContentPane().add(Updatebtn);
		
		JButton Deletebtn = new JButton("DELETE");
		Deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_management_system","root","");
					String sql = "DELETE FROM loyalty WHERE program_id=?";
					  int protxf=Integer.parseInt(JOptionPane.showInputDialog("Enter program_ID to delete:"));
					  PreparedStatement stm=con.prepareStatement(sql);
					  stm.setInt(1,protxf);
					  Component Delete;
					JOptionPane.showMessageDialog(Deletebtn, "recorded out!!");
					  
					  stm.executeUpdate();
					  stm.close();
					  con.close();
					
					
					
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		Deletebtn.setBackground(new Color(128, 255, 255));
		Deletebtn.setForeground(new Color(255, 0, 0));
		Deletebtn.setFont(new Font("Tahoma", Font.BOLD, 19));
		Deletebtn.setBounds(550, 274, 116, 42);
		frame.getContentPane().add(Deletebtn);
		
		protxf = new JTextField();
		protxf.setBounds(223, 86, 311, 37);
		frame.getContentPane().add(protxf);
		protxf.setColumns(10);
		
		pntxf = new JTextField();
		pntxf.setColumns(10);
		pntxf.setBounds(223, 148, 311, 37);
		frame.getContentPane().add(pntxf);
		
		rttxf = new JTextField();
		rttxf.setColumns(10);
		rttxf.setBounds(223, 216, 311, 37);
		frame.getContentPane().add(rttxf);
		
		rdtxf = new JTextField();
		rdtxf.setColumns(10);
		rdtxf.setBounds(223, 282, 311, 37);
		frame.getContentPane().add(rdtxf);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 352, 581, 246);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(192, 192, 192));
		table.setForeground(new Color(0, 0, 255));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("L");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\PC\\Pictures\\download.jpg"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 42));
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(596, 352, 259, 236);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
