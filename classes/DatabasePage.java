import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DatabasePage extends JFrame implements ActionListener {

    private String username;
    private String movieName;
    private int numTickets;
    private String showTime;
    private int amount;


    private JLabel nameLabel;
    private JLabel movieNameLabel;
    private JLabel numTicketsLabel;
    private JLabel showTimeLabel;
    private JLabel amountLabel;
    private JButton backButton;
    
    public DatabasePage(String username, String movieName, int numTickets, String showTime) {
        this.username = username;
        this.movieName = movieName;
        this.numTickets = numTickets;
        this.showTime = showTime;
        int amount=numTickets*160;
        // Set up the frame
        setTitle(" Booking Summary ");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set up the components
        nameLabel = new JLabel("Name: " + username);
        movieNameLabel = new JLabel("Movie Name: " + movieName);
        numTicketsLabel = new JLabel("Number of Tickets: " + numTickets);
        showTimeLabel = new JLabel("Show Time: " + showTime);
        amountLabel = new JLabel("                         You have to Pay: " + amount);
        backButton = new JButton("Back");

        // Add components to panel

        add(nameLabel);
        nameLabel.setBounds(100,50,300,60);

        add(movieNameLabel);
        movieNameLabel.setBounds(100,90,300,60);

        add(numTicketsLabel);
        numTicketsLabel.setBounds(100,130,300,60);

        add(showTimeLabel);
        showTimeLabel.setBounds(100,170,300,60);

        add(amountLabel);
        amountLabel.setBounds(100,210,300,60);



        // Add button listener
        backButton.addActionListener(this);


        // Insert data into MySQL database
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie", "root", "");
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO tickets (username, movieName, numTickets, showTime,amount) VALUES ('" + username + "', '" + movieName + "', " + numTickets + ", '" + showTime + "' ,'" + amount + "')";
            stmt.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Show the frame
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Hide this frame and open the previous one
        setVisible(false);
        new TicketPage(username, movieName);
    }
}

