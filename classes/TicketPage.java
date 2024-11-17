import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicketPage extends JFrame implements ActionListener {

    private String username;
    private String movieName;

    private JLabel ticketLabel;
    private JSpinner ticketSpinner;
    private JLabel showTimeLabel;
    private JComboBox showTimeComboBox;
    private JButton submitButton;

    public TicketPage(String username, String movieName) {
        this.username = username;
        this.movieName = movieName;

        // Set up the frame
        setTitle("Ticket Page");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set up the components
        ticketLabel = new JLabel("Select number of tickets:");
        ticketSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        showTimeLabel = new JLabel("Select show time:");
        String[] showTimes = {"12:00 PM", "3:00 PM", "6:00 PM", "9:00 PM"};
        showTimeComboBox = new JComboBox(showTimes);
        submitButton = new JButton("Submit");

        // Add components to panel
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(ticketLabel);
        panel.add(ticketSpinner);
        panel.add(showTimeLabel);
        panel.add(showTimeComboBox);

        // Add button listener
        submitButton.addActionListener(this);

        // Add panel to frame
        add(panel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);

        // Show the frame
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Get the number of tickets and show time
        int numTickets = (Integer) ticketSpinner.getValue();
        String showTime = (String) showTimeComboBox.getSelectedItem();

        // Hide this frame and open the next one
        setVisible(false);
        new DatabasePage(username, movieName, numTickets, showTime);
    }
}

