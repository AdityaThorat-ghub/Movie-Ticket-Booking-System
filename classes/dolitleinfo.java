import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;

public class dolitleinfo extends JFrame implements ActionListener{
        
        JMenuBar mbr;
	JMenu m1;
	JMenuItem mi1,mi2;
	JButton m2,m3,m4,btn;
        String username,movieName;

    
    public dolitleinfo(String username,String movieName) {
        ImageIcon icon1;
        Font f;
        JLabel l1;
        this.username=username;
        this.movieName=movieName; 
        
        
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setBounds(800,50,1000,650);
        textArea.setText("Mistry , Triller\n"+"Movie Name:   Dolittle \n"+""+"\nStoryline:   A physician who can talk to animals embarks on an adventure to find a legendary island with a young apprentice and a crew of strange pets.\n"+
        "\nDirector:   Stephen Gaghan\n"+"\nWriters:   Stephen Gaghan(screenplay by)Dan Gregor(screenplay by)Doug Mand(screenplay by)\n"+"\nStars:   Robert Downey Jr.Antonio BanderasMichael Sheen\n"+"\nIMDb RATING:   9.2/10\n");
        f=new Font("Arial",Font.BOLD,25);
        textArea.setFont(f);
        add(textArea);
           	
    	icon1 = new ImageIcon("dolitle1.jpg");
    	
    	l1 = new JLabel(icon1);
	
                
        l1.setBounds(50,50,600,890);
        
        add(l1);

	m2=new JButton("HOME");
	m3=new JButton("Registration");
	m4=new JButton("Contact Us");
	btn=new JButton("Pricced to Booking");

		mbr=new JMenuBar();
		
		m1=new JMenu("Login");
		mi1=new JMenuItem("User Login");
		mi2=new JMenuItem("Admin Login");

		add(mbr);
		mbr.setBounds(0,0,1920,50);
 		add(btn);
                btn.setBounds(1100,800,500,50);

		mbr.add(m1);
		
		m1.add(mi1);
		m1.add(mi2);
		
		mbr.add(m2);
		
		mbr.add(m3);
		
		mbr.add(m4);

                m1.addActionListener(this);
                mi1.addActionListener(this);
                mi2.addActionListener(this);
 
                m2.addActionListener(this);
		m3.addActionListener(this);
		m4.addActionListener(this);
		btn.addActionListener(this);

        
        setSize(1920,1080);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
public void actionPerformed(ActionEvent e)
{
       if(e.getSource()==mi1)
	{
		new Userlogin();
		System.out.println("Clicked..");
	}

    /*   if(e.getSource()==mi2)
	{
		new Adminlogin();
		System.out.println("Clicked..");
	}*/


	if(e.getSource()==m2)
	{
		new Home(username);
		System.out.println("Clicked..");
	}


 
	if(e.getSource()==m3)
	{
		new Registration();
		System.out.println("Clicked..");
	}

	/* if(e.getSource()==m4)
	{
		new Contact_us();
		System.out.println("Clicked..");
	}*/

	if(e.getSource()==btn)
	{
                new TicketPage(username,movieName);
                System.out.println("Clicked..");
	}



}

    
    public static void main(String[] args) {
    //    new dolitleinfo();
    }
}
