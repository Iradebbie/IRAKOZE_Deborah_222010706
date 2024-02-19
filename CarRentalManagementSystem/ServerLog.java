package CarRentalManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.nio.file.StandardWatchEventKinds;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ServerLog {

	 JFrame frame;
	private JTextField logtxf;
	private JTextField titxf;
	private JTextField lmtxf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerLog window = new ServerLog();
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
	public ServerLog() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 859, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ServerLog");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(101, 0, 622, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel loglb = new JLabel("Log_id");
		loglb.setFont(new Font("Tahoma", Font.BOLD, 17));
		loglb.setBounds(10, 95, 148, 36);
		frame.getContentPane().add(loglb);
		
		JLabel tilb = new JLabel("timeStamp");
		tilb.setFont(new Font("Tahoma", Font.BOLD, 17));
		tilb.setBounds(10, 168, 148, 36);
		frame.getContentPane().add(tilb);
		
		JLabel lmlb = new JLabel("logMessage");
		lmlb.setFont(new Font("Tahoma", Font.BOLD, 17));
		lmlb.setBounds(10, 254, 148, 36);
		frame.getContentPane().add(lmlb);
		
		logtxf = new JTextField();
		logtxf.setBounds(228, 96, 215, 36);
		frame.getContentPane().add(logtxf);
		logtxf.setColumns(10);
		
		titxf = new JTextField();
		titxf.setColumns(10);
		titxf.setBounds(228, 168, 215, 36);
		frame.getContentPane().add(titxf);
		
		lmtxf = new JTextField();
		lmtxf.setColumns(10);
		lmtxf.setBounds(228, 241, 215, 79);
		frame.getContentPane().add(lmtxf);
		
		JButton Submitbtn = new JButton("SUBMIT");
		Submitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hm=new Home();
				hm.setVisible(true);
				frame.dispose();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_management_system","root","");
					String sql="INSERT INTO serverlog VALUES(?,?,?)";
					PreparedStatement stm=con.prepareStatement(sql);
					stm.setInt(1, Integer.parseInt(logtxf.getText()));
					stm.setString(2, titxf.getText());
					stm.setString(3, lmtxf.getText());
					stm.executeUpdate();
					JOptionPane.showMessageDialog(Submitbtn, "nice!!!!!!");
					con.close();
					stm.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		Submitbtn.setForeground(new Color(0, 0, 255));
		Submitbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Submitbtn.setBounds(89, 349, 113, 49);
		frame.getContentPane().add(Submitbtn);
		
		JButton Exitbtn = new JButton("EXIT");
		Exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				logtxf.setText(null);
				titxf.setText(null);
				lmtxf.setText(null);
			}
		});
		Exitbtn.setForeground(new Color(255, 0, 0));
		Exitbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		Exitbtn.setBounds(287, 405, 113, 49);
		frame.getContentPane().add(Exitbtn);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_management_system","root","");
				String sql="UPDATE serverlog SET timestamp=?,logmessage=? WHERE log_id=?";
				PreparedStatement stm=con.prepareStatement(sql);
				
				stm.setString(1, titxf.getText());
				stm.setString(2, lmtxf.getText());
				stm.setInt(3, Integer.parseInt(logtxf.getText()));
				stm.executeUpdate();
				JOptionPane.showMessageDialog(btnUpdate, "yes!!!!!");
				con.close();
				stm.close();
				
				
				
				
				
				
				
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnUpdate.setForeground(new Color(0, 128, 192));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBounds(287, 349, 113, 49);
		frame.getContentPane().add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(446, 60, 389, 394);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		
		JButton btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_management_system","root","");	
					java.sql.Statement st=con.createStatement();
					String query="SELECT * FROM serverlog";
					ResultSet rs= st.executeQuery(query);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel)table.getModel();
					int cols=rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0;i<cols;i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String log_id,timestamp,logmessage;
					while(rs.next()) {
						log_id=rs.getString(1);
						timestamp=rs.getString(2);
						logmessage=rs.getString(3);
						String[] row= {log_id,timestamp,logmessage};
						model.addRow(row);
						
					}
					
					st.close();
					con.close();
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnView.setForeground(new Color(0, 0, 255));
		btnView.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnView.setBounds(89, 405, 113, 49);
		frame.getContentPane().add(btnView);
	}
}
