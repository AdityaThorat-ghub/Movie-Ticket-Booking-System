import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.sql.*;

class Registration1 extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5;
    JButton b1;

    String name,email,password,address;
    Connection cn=null;
    PreparedStatement prstm;
    String sql;

    Registration1() {
        setTitle("Registration1");
        setSize(800,600);
        setLocationRelativeTo(null);
        setLayout(null);

        l1=new JLabel("Registration1");
        l2=new JLabel("Enter username");
        l3=new JLabel("Enter Email");
        l4=new JLabel("Enter password");
        l5=new JLabel("Enter address");

        t1=new JTextField("");
        t2=new JTextField("");
        t3=new JTextField("");
        t4=new JTextField("");
        t5=new JTextField("");

        b1=new JButton("Register");

        add(l1);    add(l2);    add(l3);
        add(l4);    add(l5);

        add(t1);    add(t2);
        add(t3);    add(t4);    add(t5);

        add(b1);

        b1.addActionListener(this);

        l1.setBounds(100,100,150,30);

        l2.setBounds(220,150,150,30);
        t1.setBounds(350,150,200,30);

        l3.setBounds(220,200,150,30);
        t2.setBounds(350,200,200,30);

        l4.setBounds(220,250,150,30);
        t3.setBounds(350,250,200,30);

        l5.setBounds(220,300,150,30);
        t4.setBounds(350,300,200,30);

        b1.setBounds(250,450,100,30);

        try {
            cn = DriverManager.getConnection("jdbc:mysql:///movie","root","");
        } catch(Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource()==b1) {
                name=t1.getText();
                email=t2.getText();
                password=t3.getText();
                address=t4.getText();

                sql="insert into users1 (name, email, password, address) values ('"+name+"','"+email+"','"+password+"','"+address+"')";
                prstm=cn.prepareStatement(sql);
                prstm.execute();
                prstm.close();

                JOptionPane.showMessageDialog(null, "Registration1 successful.");
            }
        } catch(Exception ee) {
            System.out.println(ee);
        }
    }

    public static void main(String []args) {
        new Registration1();
    }
}

