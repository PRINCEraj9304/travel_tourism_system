

package travel.management.systemm;
import java.awt.*;
import javax.swing.*;
// import javax.swing.border.LineBorder;
import java.awt.event.*; // for actionlistener class

public class Signup extends JFrame implements ActionListener {
    
    // globally defined
    
    JButton create,back;  
    JTextField tfusername,tfname, tfpassword,tfans;
    Choice security;
    
    Signup(){
        setBounds(350,200,900,360);  // setbound is combination of setsize and setlocation so we can also use setbound function
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,450,360);
        p1.setLayout(null);
        add(p1);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
        lblusername.setBounds(50,20,125,25);
        p1.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(190,20,180,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder()); 
        p1.add(tfusername);
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        name.setBounds(50,60,125,25);
        p1.add(name);
        
        tfname = new JTextField();
        tfname.setBounds(190,60,180,25);
        tfname.setBorder(BorderFactory.createEmptyBorder()); 
        p1.add(tfname);
        
        JLabel lblpass = new JLabel("Password");
        lblpass.setFont(new Font("Tahoma",Font.BOLD,14));
        lblpass.setBounds(50,100,125,25);
        p1.add(lblpass);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(190,100,180,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder()); 
        p1.add(tfpassword);
        
        JLabel lblsec = new JLabel("Security Question");
        lblsec.setFont(new Font("Tahoma",Font.BOLD,14));
        lblsec.setBounds(50,140,125,25);
        p1.add(lblsec);
        
        // we will use choice class for different question
        
        security = new Choice(); // object of security type
        security.add("Favourite character from The Boys");
        security.add("Best marvel superhero");
        security.add("Favourite captain of team india");
        security.add("your lucky number");
        security.setBounds(190,140,180,25);
        p1.add(security);
        
        JLabel lblans = new JLabel("Answer");
        lblans.setFont(new Font("Tahoma",Font.BOLD,14));
        lblans.setBounds(50,180,125,25);
        p1.add(lblans);
        
        tfans = new JTextField();
        tfans.setBounds(190,180,180,25);
        tfans.setBorder(BorderFactory.createEmptyBorder()); 
        p1.add(tfans);
        
        create = new JButton("Create");
        create.setBounds(80,250,100,30);
        create.setBackground(Color.WHITE);
        create.setFont(new Font("Tahoma", Font.BOLD,14));
        create.setForeground(new Color(131,193,233)); // for changing foreground color or changing text color
        create.addActionListener(this); // onclick event occur through this line of code
        p1.add(create);
        
        back = new JButton("Back");
        back.setBounds(250,250,100,30);
        back.setBackground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD,14));
        back.setForeground(new Color(131,193,233)); // for changing foreground color or changing text color
        back.addActionListener(this);
        p1.add(back);
        
        
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("Icons/signup2.png"));
        Image I2 = I1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel image = new JLabel(I3);
        image.setBounds(550,40,250,250);
        add(image);
        setVisible(true);
        }
    
    
        public void actionPerformed(ActionEvent ae){
            
            // action listener has abstract function which we have to override 
            // jab aap actionlistener function ko call karte hai to wo internally actionperformed ko call karta hai aur batata hai
            // ki create bottom ke click pe karna kya hai
            // ab humare pass do bottom hai aur same he function ke to pata kaisse chalega kisse use karna hai to wo actionevent batata hai
            
            if(ae.getSource() == create){
                // isme hum textfield ke anadr jo bhi data hai usse hum extract karenge aur hum usse databse me save karenge.
                // getText() function ke help se textfield() ke data extract karte hai
                
                String username = tfusername.getText();
                String name = tfname.getText();
                String password = tfpassword.getText();
                String question = security.getSelectedItem();
                String ans = tfans.getText();
                
                String query = "insert into account values('"+username+"','"+name+"' , '"+password+"' , '"+question+"' , '"+ans+"')" ;
                // above line is mysql query which will insert into table
                
                try{
                    Conn c = new Conn(); // conn class ka ek object banaya, jab bhi data fetch karna rahta to to sql ke saath connection 
                    // banana padta hai aur fir object banao
                    // step-4 of jdbc excetuing the mysql queries
                    c.s.executeUpdate(query);  // dml command of mysql
                    
                    JOptionPane.showMessageDialog(null,"Account Created Successfully");  // pop up message when you completed signup
                    // JOptionPane() is used to create a diaglog box 
                    setVisible(false);
                    new Login();  // login page ab khol do
                }
                
                catch(Exception e){
                    e.printStackTrace();
                }
            }
                
            else if(ae.getSource() == back){
                setVisible(false); // current file ko band kar dena hai aur new page pe jana hai
                new Login();  // login page pe chale jao
            }
            
            
        }
        
    public static void main(String[] args){
        new Signup();
    }
    
}
