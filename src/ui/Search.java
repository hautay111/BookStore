package ui;

import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class Search extends JFrame {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField searchable = new JTextField(30);
    private JButton searchB = new JButton("Search");
    private JTable result = new JTable();
    private JPanel panel = new JPanel();
    private JScrollPane scrollPane = new JScrollPane(result);
    private final JButton btnClose = new JButton("Close");
 
    public static void main(String[] args) {
        new Search("SearchBox Example");
    }
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
    private Search(String title) throws HeadlessException {
        super(title);
        setSize(600, 600);
        setResizable(true);
        addComponents();
        setTable();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        

    }

    public Search() {
    	result.addComponentListener(new ComponentAdapter() {
    		@Override
    		public void componentShown(ComponentEvent e) {
    		}
    	});
    	result.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 0)));
		// TODO Auto-generated constructor stub
        setSize(600, 600);
        setResizable(true);
        addComponents();
        setTable();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}

	private void addComponents() {
        panel.setLayout(null);
        searchable.setBounds(104, 6, 246, 19);
        panel.add(searchable);
        searchB.setBounds(355, 5, 65, 21);
        panel.add(searchB);
        btnClose.setBounds(425, 5, 57, 21);
        btnClose.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(1);
        	}
        });
        
        panel.add(btnClose);
        scrollPane.setBounds(67, 31, 452, 402);
        scrollPane.addComponentListener(new ComponentAdapter() {
        	@Override
        	public void componentShown(ComponentEvent e) {
        		
        	}
        });
        panel.add(scrollPane);
        getContentPane().add(panel);
    }
 
    private void setTable() {
        searchB.addActionListener(e -> result.setModel(DbUtils.resultSetToTableModel(
                new DataBase().search(searchable.getText(), panel))));
        		String sql="select * from book" ;
        		
    }
}