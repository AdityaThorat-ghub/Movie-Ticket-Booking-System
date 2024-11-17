import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MoviePage extends JFrame implements ActionListener {

    private String name;
    private JLabel movieLabel;
    private JTextField movieTextField;
    private JButton nextButton;

    public MoviePage(String name) {
        this.name = name;

        // Set up the frame
        setTitle("Movie Page");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        movieLabel = new JLabel("Enter the movie name:");
        movieTextField = new JTextField(20);
        nextButton = new JButton("Next");

        // Add components to panel
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(movieLabel);
        panel.add(movieTextField);

        // Add button listener
        nextButton.addActionListener(this);

        // Add panel to frame
        add(panel, BorderLayout.CENTER);
        add(nextButton, BorderLayout.SOUTH);

        // Show the frame
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Get the movie name from the text field
        String movieName = movieTextField.getText();

        // Hide this frame and open the next one
        setVisible(false);
        new TicketPage(name, movieName);
    }
}

