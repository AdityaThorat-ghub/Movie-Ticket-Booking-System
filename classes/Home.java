import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;

class Home extends JFrame implements ActionListener
{
    private String username;

	JMenuBar mbr;
	JLabel l1,l2,l3,l4,l5,l6;
	Font f;
	ImageIcon icon1,icon2,icon3,icon4,icon5,icon6;
	JButton m1,m2,m3,m4,b1,b2,b3,b4,b5,b6;

	Home(String username)
	{
	
		super("Movie Ticket Booking System");
	
	            JLabel label1 = new JLabel("Welcome to");
                   label1.setBounds(850, 100, 500, 30);
        	   JLabel label2 = new JLabel("Carnival Cinema");
                   label2.setBounds(700, 200, 650, 60);
            Font f1,f2;
        f1=new Font("Arial",Font.BOLD,30);
        f2=new Font("Arial",Font.BOLD,60);

        label2.setForeground(Color.RED);


        label1.setFont(f1);
        label2.setFont(f2);

                 add(label1);
                 add(label2);
	
		this.username = username;
		setSize(1920,1080);
		setLocation(350,250);
		setLayout(null);

		ImageIcon icon1 = new ImageIcon("aladin.jpg");
       		ImageIcon icon2 = new ImageIcon("Shutter_iseland.jpg");
       	        ImageIcon icon3 = new ImageIcon("dolitle.jpg");
       		ImageIcon icon4 = new ImageIcon("jumanji.jpg");
		ImageIcon icon5 = new ImageIcon("lucy.jpg");
       		ImageIcon icon6 = new ImageIcon("the_boss_baby.jpg");
       		


		l1 = new JLabel(icon1);
                l2 = new JLabel(icon2);
                l3 = new JLabel(icon3);
                l4 = new JLabel(icon4);
		l5 = new JLabel(icon5);
                l6 = new JLabel(icon6);
                                

	                        
                
                b1=new JButton("View Details");
                b2=new JButton("View Details");
                b3=new JButton("View Details");
                b4=new JButton("View Details");
                b5=new JButton("View Details");
                b6=new JButton("View Details");
		m1=new JButton("Login");	
		m2=new JButton("HOME");
		m3=new JButton("Registration");
		m4=new JButton("Contact Us");

                f=new Font("Arial",Font.BOLD,30);
	
		mbr=new JMenuBar();		

		add(mbr);
		mbr.setBounds(0,0,1920,50);

		mbr.add(m1);
			
		mbr.add(m2);
		
		mbr.add(m3);
		
		mbr.add(m4);
		
		 add(l1);	add(l2);
                add(l3);	add(l4);
                
                 add(l5);	add(l6);
         
         
                 add(b1);	add(b2);
                add(b3);	add(b4);

                 add(b5);	add(b6);


                m1.addActionListener(this);
                m2.addActionListener(this);
		m3.addActionListener(this);
		m4.addActionListener(this);

                b1.addActionListener(this);
                b2.addActionListener(this);
                b3.addActionListener(this);
                b4.addActionListener(this);
                b5.addActionListener(this);
                b6.addActionListener(this);



                getContentPane().add(l1);
      		getContentPane().add(l2);
                getContentPane().add(l3);
      		getContentPane().add(l4); 
                getContentPane().add(l5);
      		getContentPane().add(l6);

                l1.setBounds(100,560, 250,371);
                b1.setBounds(100,945, 250, 50);
                l2.setBounds(620,560, 250,371);
                b2.setBounds(620,945, 250, 50);
                l3.setBounds(1040,560, 250,371);
                b3.setBounds(1040,945, 250, 50);
                l4.setBounds(1550,560, 250,371);
                b4.setBounds(1550,945, 250, 50);

                l5.setBounds(250,90, 250,371);
                b5.setBounds(250,475, 250, 50);
                l6.setBounds(1400,90, 250,371);
                b6.setBounds(1400,475, 250, 50);
                



        setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

public void actionPerformed(ActionEvent e)
{
       if(e.getSource()==m1)
	{
		new Userlogin();
		System.out.println("Clicked..");
	}

	if(e.getSource()==m2)
	{
		new Home(null);
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

       if(e.getSource()==b1)
	{
	        String movieName ="Aladin";
		new aladininfo(username, movieName);

		System.out.println("Clicked..");
	}


     if(e.getSource()==b2)
	{
	        String movieName ="Shutter iseland";
		new Shutter_iselandinfo(username, movieName);

		System.out.println("Clicked..");
	}
      if(e.getSource()==b3)
	{

	        String movieName ="Dolitle";
		new dolitleinfo(username, movieName);

		System.out.println("Clicked..");
	}
       if(e.getSource()==b4)
	{
	        String movieName ="jumanji";
		new jumanjiinfo(username, movieName);

		System.out.println("Clicked..");
	}
       if(e.getSource()==b5)
	{
	        String movieName ="Lucy";
		new lucyinfo(username, movieName);
		System.out.println("Clicked..");
	}
       if(e.getSource()==b6)
	{

	        String movieName ="the_boss_baby";
		new the_boss_babyinfo(username, movieName);
		System.out.println("Clicked..");
	}

}

public static void main(String []args)
	{  
               new Home(null);
	}



}
