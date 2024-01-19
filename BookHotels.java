
package travel.management.systemm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class BookHotels extends JFrame implements ActionListener{
    
    Choice chotel, cac ,cfood;
    JTextField tfdays,tfperson;
    String Username;
    JLabel labelusername , labelid, labelnumber , labelphone , labeltotal;
    JButton checkprice , bookhotel, back; 
    
    BookHotels(String Username){
        
        this.Username = Username;
        setBounds(350,200,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel text = new JLabel("Book Hotels");
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
        
        JLabel lblpackage = new JLabel("Select Hotels");
        lblpackage.setBounds(40,110,200,20);
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpackage);
        
        chotel = new Choice();
        chotel.setBounds(250,110,200,20);
        add(chotel);
        
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblperson = new JLabel("Total Person");
        lblperson.setBounds(40,150,200,20);
        lblperson.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblperson);
        
        tfperson = new JTextField("1");
        tfperson.setBounds(250,150,200,20);
        add(tfperson);
        
        JLabel lbldays = new JLabel("No of Days");
        lbldays.setBounds(40,190,200,20);
        lbldays.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldays);
        
        tfdays = new JTextField("1");
        tfdays.setBounds(250,190,200,20);
        add(tfdays);
        
        JLabel lblac = new JLabel("AC/NON-AC");
        lblac.setBounds(40,230,200,20);
        lblac.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblac);
        
        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250,230,200,20);
        add(cac);
        
        
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(40,270,200,20);
        lblfood.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfood);
        
        cfood = new Choice();
        cfood.add("YES");
        cfood.add("NO");
        cfood.setBounds(250,270,200,20);
        add(cfood);
        
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(40,310,200,20);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(250,310,200,20);
        add(labelid);
        
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40,350,200,20);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(250,350,200,20);
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40,390,200,20);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(250,390,200,20);
        add(labelphone);
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40,430,200,20);
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbltotal);
        
        labeltotal = new JLabel();
        labeltotal.setBounds(250,430,200,20);
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
        checkprice.setBounds(60, 500, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);
        
     
        bookhotel = new JButton("Book Hotel");
        bookhotel.setBackground(Color.BLACK);
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setBounds(200, 500, 120, 25);
        bookhotel.addActionListener(this);
        add(bookhotel);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 500, 120, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,50,500,400);
        add(image);
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            
            try{
                
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from hotel where name = '"+chotel.getSelectedItem()+"'");
            // above line will give all data of one touple and we can access all by looping 
            
            while(rs.next()){
                 
                int cost = Integer.parseInt(rs.getString("costperperson"));   // Integer.parseInt will convert string format into integer
                int ac = Integer.parseInt(rs.getString("acroom")); 
                int food = Integer.parseInt(rs.getString("foodincluded"));
                
                int person = Integer.parseInt(tfperson.getText());  // we will fetch data from tfperson textfield and will convert into integer
                int days = Integer.parseInt(tfdays.getText());
                
                String acselected = cac.getSelectedItem();  // is line se humlog jan jayenge addmi ne ac ya non ac select kiya hai uske accr cost calculate karenge
                String foodselected = cfood.getSelectedItem();
                
                if(person*days > 0){
                    
                    int total = 0;
                    total += acselected.equals("AC") ? ac : 0;
                    total += foodselected.equals("YES") ? food : 0;
                    
                    total += cost;  // cost per person
                    total = total * person * days;  // total cost of all person
                    labeltotal.setText("Rs" + total);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please enter a valid number");
                }
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == bookhotel){
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"' ,'"+chotel.getSelectedItem()+"','"+tfperson.getText()+"','"+tfdays.getText()+"', '"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"','"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labeltotal.getText()+"')");
                
                JOptionPane.showMessageDialog(null, "Hotal Booked Successfully");
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
        new BookHotels("rak_12");
    }
}
