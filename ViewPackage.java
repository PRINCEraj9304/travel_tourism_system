
package travel.management.systemm;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class ViewPackage extends JFrame implements ActionListener{
    
    JButton back;
    
    ViewPackage(String username){
        
        setBounds(450,200,900,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW PACKAGE DETILS");
        text.setFont(new Font("Tahome",Font.BOLD, 20));
        text.setBounds(60,0,300,30);
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Package");
        lblpackage.setBounds(30,95,150,25);
        add(lblpackage);
        
        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220,95,150,25);
        add(labelpackage);
        
        JLabel lblperson = new JLabel("Total Person");
        lblperson.setBounds(30,140,150,25);
        add(lblperson);
        
        JLabel labelperson = new JLabel();
        labelperson.setBounds(220,140,150,25);
        add(labelperson);
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,190,150,25);
        add(lblid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220,190,150,25);
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,240,150,25);
        add(lblnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220,240,150,25);
        add(labelnumber);
      
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30,290,150,25);
        add(lblphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(220,290,150,25);
        add(labelphone);
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(30,340,150,25);
        add(lbltotal);
        
        JLabel labeltotal = new JLabel();
        labeltotal.setBounds(220,340,150,25);
        add(labeltotal);
        
        back = new JButton("Back");
        back.setBounds(100, 380, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Icons/bookedDetails.jpg"));
        Image i5 = i4.getImage().getScaledInstance(450, 400, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(350,50,500,300);
        add(image2);
        
        try{
            Conn c = new Conn();
            String query = "select * from bookpackage where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                
                // setting the value
                
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("package"));
                labeltotal.setText(rs.getString("total"));
                labelperson.setText(rs.getString("person"));
                labelphone.setText(rs.getString("phone"));
                
            }
        }
        catch(Exception e){
            
        }

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    public static void main(String []args){
        new ViewPackage("rak_12"); // creation of object
    }
}
