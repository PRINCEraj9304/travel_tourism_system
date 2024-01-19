
package travel.management.systemm;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;


public class Updatecustomer extends JFrame implements ActionListener {
    
    JButton update,back;
    JLabel lblusername, lblid,lblnumber,lblname,labelname;
    JComboBox comboid;
    JTextField tfnumber,tfcountry,tfaddress,tfemail,tfphone,tfid,tfgender;
    // JRadioButton rmale,rfemale;  // used to create circular button which we can tick or untick
    
    Updatecustomer(String username){
        
        
        setBounds(500,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50,0,300,25);
        text.setFont(new Font("Tahome",Font.PLAIN,20));
        add(text);
        
        lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        lblid = new JLabel("Id");
        lblid.setBounds(30,90,150,25);
        add(lblid);
        
       
        
        tfid = new JTextField();
        tfid.setBounds(220,90,150,25);
        add(tfid);
      
        
        lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);
        
        lblname = new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        add(lblname);
        
        labelname = new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);
        
        tfgender = new JTextField();
        tfgender.setBounds(220,210,150,25);
        add(tfgender);
     
        
        // buttongroup class is used to select either one box male or female. if one is ticked and we select other one then first will be unticked
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(30,250,150,25);
        add(lblcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220,290,150,25);
        add(tfaddress);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30,330,150,25);
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220,330,150,25);
        add(tfphone);
        
        JLabel lblemail = new JLabel("E-Mail");
        lblemail.setBounds(30,370,150,25);
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(220,370,150,25);
        add(tfemail);
        
        update = new JButton("Update");
        update.setBounds(70,430,100,25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(250,430,100,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =  new JLabel(i3);
        image.setBounds(400,100,450,300);
        add(image);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+ Username +"'");  // ddl command
            while(rs.next()){
                lblusername.setText(rs.getString("Username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
          
                
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        setVisible(true);   
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == update){
            // sara data hum jo bhi input karenge use fetch karke database me store kar denge
            
            String username = lblusername.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            
            try{
                Conn c = new Conn();
                String query = "update customer set username ='"+username+"' ,id = '"+id+"',number = '"+number+"' , name = '"+name+"',gender = '"+gender+"',country = '"+country+"',address = '"+address+"',phone = '"+phone+"',email = '"+email+"'";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Details updated Successfully");
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
    
    public static  void main (String[] args){
        new Updatecustomer("rak_12");
    }
}
