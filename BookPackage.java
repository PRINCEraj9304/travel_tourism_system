
package travel.management.systemm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener{
    
    Choice cpackage;
    JTextField tfperson;
    String Username;
    JLabel labelusername , labelid, labelnumber , labelphone , labeltotal;
    JButton checkprice , bookpackage, back; 
    
    BookPackage(String Username){
        
        this.Username = Username;
        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel text = new JLabel("Book Package");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,70,200,20);
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblusername);
        
      labelusername = new JLabel();
        labelusername.setBounds(250,70,200,20);
        labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setBounds(40,110,200,20);
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpackage);
        
        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250,110,200,20);
        add(cpackage);
        
        JLabel lblperson = new JLabel("Total Person");
        lblperson.setBounds(40,150,200,20);
        lblperson.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblperson);
        
        tfperson = new JTextField("1");
        tfperson.setBounds(250,150,200,20);
        add(tfperson);
        
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(40,190,200,20);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(250,190,200,20);
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40,230,200,20);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(250,230,200,20);
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40,270,200,20);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(250,270,200,20);
        add(labelphone);
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40,310,200,20);
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbltotal);
        
        labeltotal = new JLabel();
        labeltotal.setBounds(250,310,200,20);
        add(labeltotal);
        
        try{
            Conn c = new Conn();
            String query = "select * from customer where username = '"+Username+"'";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                
                // setting the value
                
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
   
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        checkprice = new JButton("Check price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60, 380, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);
        
     
        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200, 380, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 380, 120, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,50,500,300);
        add(image);
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            
            String pack = cpackage.getSelectedItem();
            int cost=0; // we are calculting cost for diffeent package 
            
            if(pack.equals("Gold Package")){
                cost += 32000;
            }
            else if(pack.equals("Silver Package")){
                cost += 24000;
            }
            else{
                cost += 12000;
            }
            
            int persons = Integer.parseInt(tfperson.getText());
            cost *= persons;
            labeltotal.setText("Rs" + cost);
        }
        else if(ae.getSource() == bookpackage){
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"' ,'"+cpackage.getSelectedItem()+"','"+tfperson.getText()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labeltotal.getText()+"')");
                
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }
    
    public static void main(String []args){
        new BookPackage("rak_12");
    }
}
