import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NamePage extends JFrame implements ActionListener {

    private JLabel nameLabel;
    private JTextField nameTextField;
    private JButton nextButton;

    public NamePage() {
        // Set up the frame
        setTitle("Name Page");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        nameLabel = new JLabel("Enter your name:");
        nameTextField = new JTextField(20);
        nextButton = new JButton("Next");

        // Add components to panel
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(nameLabel);
        panel.add(nameTextField);

        // Add button listener
        nextButton.addActionListener(this);

        // Add panel to frame
        add(panel, BorderLayout.CENTER);
        add(nextButton, BorderLayout.SOUTH);

        // Show the frame
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Get the name from the text field
        String name = nameTextField.getText();

        // Hide this frame and open the next one
        setVisible(false);
        new MoviePage(name);
    }

    public static void main(String[] args) {
        new NamePage();
    }
}

