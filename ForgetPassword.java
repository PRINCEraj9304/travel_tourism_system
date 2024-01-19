
package travel.management.systemm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;  // for importing ResultSet


public class ForgetPassword extends JFrame implements ActionListener {
    
    JTextField tfusername, tfname, tfquest ,tfans,tfpassword;
    JButton search,retrieve,back;
    
    ForgetPassword(){
        
     setBounds(350,200,850,380);
     getContentPane().setBackground(Color.WHITE);
     setLayout(null);  // apna layout banana chahte hai bydefault use nhi karna hai
     
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/forgotpassword.jpg"));
     Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel image = new JLabel(i3);
     image.setBounds(580,70,200,200);
     add(image);
     
     
     JPanel p1 = new JPanel();
     p1.setLayout(null);  // taki bydefault boundary wala layout nhi utha le
     p1.setBounds(30,30,500,280);
     add(p1);
     
     JLabel lblusername = new JLabel("Username");
     lblusername.setBounds(40,20,100,25);
     lblusername.setFont(new Font("Tahoma",Font.BOLD, 14 ));
     p1.add(lblusername);
     
     tfusername = new JTextField();
     tfusername.setBounds(170,20,150,25);
     tfusername.setBorder(BorderFactory.createEmptyBorder());
     p1.add(tfusername);
     
     search = new JButton("Search");
     search.setBackground(Color.GRAY);
     search.setForeground(Color.WHITE);
     search.setBounds(350,20,120,25);
     search.addActionListener(this);
     p1.add(search);
     
     JLabel name = new JLabel("Name");
     name.setBounds(40,60,100,25);
     name.setFont(new Font("Tahoma",Font.BOLD, 14 ));
     p1.add(name);
     
     tfname = new JTextField();
     tfname.setBounds(170,60,150,25);
     tfname.setBorder(BorderFactory.createEmptyBorder());
     p1.add(tfname);
     
     JLabel question = new JLabel("Security Quest");
     question.setBounds(40,100,150,25);
     question.setFont(new Font("Tahoma",Font.BOLD, 14 ));
     p1.add(question);
     
     tfquest = new JTextField();
     tfquest.setBounds(170,100,150,25);
     tfquest.setBorder(BorderFactory.createEmptyBorder());
     p1.add(tfquest);
     
     JLabel answer = new JLabel("Answer");
     answer.setBounds(40,140,150,25);
     answer.setFont(new Font("Tahoma",Font.BOLD, 14 ));
     p1.add(answer);
     
     tfans = new JTextField();
     tfans.setBounds(170,140,150,25);
     tfans.setBorder(BorderFactory.createEmptyBorder());
     p1.add(tfans);
     
     retrieve = new JButton("Retrieve");
     retrieve.setBackground(Color.GRAY);
     retrieve.setForeground(Color.WHITE);
     retrieve.setBounds(350,140,120,25);
     retrieve.addActionListener(this);
     p1.add(retrieve);
     
     // when  the username will forgot his password then he will go to another page and type his username system will give his username, name and
     // security question and also will write answer then his password will retrieve in another textfield
     
     JLabel password = new JLabel("Password");
     password.setBounds(40,180,150,25);
     password.setFont(new Font("Tahoma",Font.BOLD, 14 ));
     p1.add(password);
     
     tfpassword = new JTextField();
     tfpassword.setBounds(170,180,150,25);
     tfpassword.setBorder(BorderFactory.createEmptyBorder());
     p1.add(tfpassword);
     
     back = new JButton("Back");
     back.setBackground(Color.GRAY);
     back.setForeground(Color.WHITE);
     back.setBounds(190,240,100,25);
     back.addActionListener(this);
     p1.add(back);
     
     setVisible(true);
     
    }
    
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == search){
             
             try{
                 String query = "select * from account where username = '"+tfusername.getText()+"'"; // fetchig the query from databasse
                 Conn c = new Conn() ; // jab whi query chalana padta hai to connection banana padta hai
                 
                 ResultSet rs = c.s.executeQuery(query); // sara tupple ka value rs set ke andar store ho gaya hai
                 // ab hum  loop chalakar us tupple ke data ko access kar sakte hai
                 while(rs.next()){
                     tfname.setText(rs.getString("name")); // getstring ke help se rs class ke andar se name ko fetch karenge aur
                     // usko tfname textfield ke andar set kar denge
                     tfquest.setText(rs.getString("security"));
                 }
             }
             catch(Exception e){
                 e.printStackTrace();
             }
         }
         else if(ae.getSource() == retrieve){
             
             try{
                 String query = "select * from account where ans = '"+tfans.getText()+"' AND username = '"+tfusername.getText()+"'"; // fetchig the query from databasse
                 Conn c = new Conn() ; // jab whi query chalana padta hai to connection banana padta hai
                 
                 ResultSet rs = c.s.executeQuery(query); // sara tupple ka value rs set ke andar store ho gaya hai
                 // ab hum  loop chalakar us tupple ke data ko access kar sakte hai
                 while(rs.next()){
                     tfpassword.setText(rs.getString("password")); // getstring ke help se rs class ke database tupple ke andar
                     // se password ko fetch karenge aur usko tfname textfield ke andar set kar denge
                 }
             }
             catch(Exception e){
                 e.printStackTrace();
             }
             
         }
         else{
             setVisible(true);
             new Login();
         }
     }
     
    public static void main(String [] args){
        new ForgetPassword();  // object creation
    }
}
