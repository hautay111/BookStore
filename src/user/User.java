package user;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * User Registration using Swing
 * @author javaguides.net
 *
 */
public class User extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField email;
    private JTextField username;
    private JTextField mob;
    private JPasswordField passwordField;
    private JButton btnNewButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	User frame = new User();
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

    public User() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("New User Register");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(362, 52, 325, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("T\u00EAn");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(120, 156, 50, 29);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("H\u1ECD");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(120, 219, 41, 29);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Email\r\n ");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddress.setBounds(120, 280, 64, 36);
        contentPane.add(lblEmailAddress);

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstname.setBounds(214, 151, 228, 29);
        contentPane.add(firstname);
        firstname.setColumns(10);

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lastname.setBounds(214, 214, 228, 29);
        contentPane.add(lastname);
        lastname.setColumns(10);

        email = new JTextField();

        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        email.setBounds(214, 279, 228, 29);
        contentPane.add(email);
        email.setColumns(10);

        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username.setBounds(651, 151, 228, 29);
        contentPane.add(username);
        username.setColumns(10);

        JLabel lblUsername = new JLabel("T\u00EAn T\u00E0i Kho\u1EA3n");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(509, 156, 132, 29);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("M\u1EADt Kh\u1EA9u");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(509, 221, 99, 24);
        contentPane.add(lblPassword);

        JLabel lblMobileNumber = new JLabel("S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMobileNumber.setBounds(509, 284, 139, 26);
        contentPane.add(lblMobileNumber);

        mob = new JTextField();
        mob.setFont(new Font("Tahoma", Font.PLAIN, 32));
        mob.setBounds(651, 278, 228, 29);
        contentPane.add(mob);
        mob.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(651, 214, 228, 29);
        contentPane.add(passwordField);

        btnNewButton = new JButton("\u0110\u0103ng K\u00FD");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstname.getText();
                String lastName = lastname.getText();
                String emailId = email.getText();
                String userName = username.getText();
                String mobileNumber = mob.getText();
                int len = mobileNumber.length();
                String password = passwordField.getText();

                String msg = "" + firstName;
                msg += " \n";
                if (len != 10) {
                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                }

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bookstore", "root", "");

                    String query = "INSERT INTO account values('" + firstName + "','" + lastName + "','" + userName + "','" +
                        password + "','" + emailId + "','" + mobileNumber + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, " + msg + "Your account is sucessfully created");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(342, 360, 259, 74);
        contentPane.add(btnNewButton);
    }
}