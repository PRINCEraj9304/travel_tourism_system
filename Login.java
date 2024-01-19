
package travel.management.systemm;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;  // it contain line border class. border is the subclass of swing package
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    String username;
    JButton Login, Signup,ForgotPass;
    JTextField tfusername,tfpassword;
    
    Login( String username){
        
        this.username = username;
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);  // for telling swing that we will build our own layout
        
        getContentPane().setBackground(Color.WHITE); // getcontentpane is used to take complete panel p1 as well as p2 and then we set background color
        
        JPanel p1 = new JPanel();
        // when you will not use any layout then bydeafult swing will apply border layout in whihch frame will be in centre
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,450,400); // for making layout
        p1.setLayout(null); // agar p1.setlayout null rahega tabhi p1.setbound function kaam karega
        add(p1);
        
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("Icons/login.png"));
        Image I2 = I1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel image = new JLabel(I3);
        image.setBounds(100,120,200,200);
        p1.add(image);
        
        // jlabel is mainly used for writing text on the frame 
        
        JPanel p2 = new JPanel(); // new panel for writing text such as login or username
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);
        
        JLabel lblusername = new JLabel("username"); // creating the variable lblusername
        lblusername.setBounds(80,20, 100,20); // left se 60 and top se 20 width 100 and height 50
        lblusername.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));  // setting the font of text
        p2.add(lblusername);
        
        tfusername = new JTextField();  // textfield is used in creating box and writing single textline;
        tfusername.setBounds(80,60,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());  // deleting the border from above container
        p2.add(tfusername);
        
        JLabel lblpassword = new JLabel("Password"); // creating the variable lblpassword
        lblpassword.setBounds(80,110, 100,20); // left se 60 and top se 20 width 100 and height 50
        lblpassword.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));  // setting the font of text
        p2.add(lblpassword);
        
        tfpassword = new JTextField();  // textfield is used in creating box and writing single textline;
        tfpassword.setBounds(80,150,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());  // deleting the border from above container
        p2.add(tfpassword);
        
        // now we have to create 3 button
        Login = new JButton("Login");
        Login.setBounds(80,200,130,30);
        Login.setBackground(new Color(131,193,233));
        Login.setForeground(Color.WHITE); // for changing foreground color or changing text color
        Login.setBorder(new LineBorder(new Color(131,193,233)));  // another method of deleting border
        Login.addActionListener(this);
        p2.add(Login);
        
        Signup = new JButton("Signup");
        Signup.setBounds(230,200,130,30);
        Signup.setBackground(new Color(131,193,233));
        Signup.setForeground(Color.WHITE); // for changing foreground color or changing text color
        Signup.setBorder(new LineBorder(new Color(131,193,233)));  // another method of deleting border
        Signup.addActionListener(this);
        p2.add(Signup);
        
        ForgotPass = new JButton("Forget Password");
        ForgotPass.setBounds(150,250,130,30);
        ForgotPass.setBackground(new Color(131,193,233));
        ForgotPass.setForeground(Color.WHITE); // for changing foreground color or changing text color
        ForgotPass.setBorder(new LineBorder(new Color(131,193,233)));  // another method of deleting border
        ForgotPass.addActionListener(this);
        p2.add(ForgotPass);
        
        // creatign label which will give user a warning or askign for help
        JLabel text = new JLabel("Trouble In Login...");
        text.setBounds(300,250,130,20);
        text.setForeground(Color.RED);
        p2.add(text);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae ){
        if(ae.getSource() == Signup){
            setVisible(false);
            new Signup();
        }
        else if(ae.getSource() == Login){
             
            try{
            String username = tfusername.getText();
            String Password = tfpassword.getText();
            
            String query = "select *from account where username = '"+username+"' AND password = '"+Password+"'";
            Conn c = new Conn(); // jaha bhi lage mysql se kam hai sabse pahle conn class ka object bana lo
            ResultSet rs = c.s.executeQuery(query); // puri ki puri row return karega
            
            if(rs.next()){
                setVisible(false);
                new Loading(username); // we pass username so that we change welcome note according to user
            }
            else{
                JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
            }
            }
            catch(Exception e){
                    e.printStackTrace();
                 }
            }
        else{
            setVisible(false);
            new ForgetPassword();
        }
    }
    
 public static void main(String args[]){
     new Login(username);
 }
}
