import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Userlogin extends JFrame  {
    private JLabel labelUsername, labelPassword;
    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private JButton buttonLogin;
    private Connection connection;
    
    public Userlogin()
     {


        labelUsername = new JLabel("Username:");
        labelPassword = new JLabel("Password:");
        textFieldUsername = new JTextField(20);
        passwordField = new JPasswordField(20);
        buttonLogin = new JButton("Login");
        setLayout(null);


        add(labelUsername);
        add(textFieldUsername);
        add(labelPassword);
        add(passwordField);
        add(new JLabel(""));
        add(buttonLogin);
        
       labelUsername.setBounds(220,150,100,30);
	textFieldUsername.setBounds(350,150,200,30);

	labelPassword.setBounds(220,200,100,30);
	passwordField.setBounds(350,200,200,30);
        buttonLogin.setBounds(270,300,225,30);
        

buttonLogin.addActionListener(new ActionListener() 
{
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textFieldUsername.getText();
                String password = new String(passwordField.getPassword());
                if (checkLogin(username, password)) {
                    JOptionPane.showMessageDialog(Userlogin.this, "Login successful");
                                new Home(username);

               
                } else {
                    JOptionPane.showMessageDialog(Userlogin.this, "Invalid username or password");
                }
            }
});
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "");
                       

       
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setTitle("form");
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private boolean checkLogin(String username, String password) 
    {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
         
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
   
    
    public static void main(String[] args) {
        new Userlogin();
    }
}

