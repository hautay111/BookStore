package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserManager extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManager frame = new UserManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField textSearch;
	private JTable table;
	private JTextField textField;

	public void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/bookstore", "root", "");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
	public void table_load() {
		try {
			pst = con.prepareStatement("select * from account");
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public UserManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 416, 194);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
//				String  user_name = textField.getText();
//				pst = con.prepareStatement("select * from account where user_name  = ?");
//				pst.setString(1, textField );
//				ResultSet rs = pst.executeQuery();
//				table_load();
			}
		});
		textField.setBounds(106, 14, 203, 19);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
