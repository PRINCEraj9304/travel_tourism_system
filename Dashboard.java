
package travel.management.systemm;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    
    JButton addpersonaldetails, viewpersonaldetails, updatepersonaldetails ,checkpackages ,Bookpackages, viewpackages, viewhotels, destination;
    JButton bookhotels , viewbookedhotels , payments, calculator ,notepad , about;
    
    String username;
    Dashboard(String username){
      this.username = username;
       // setBounds(0,0,1600,1000);
       setExtendedState(JFrame.MAXIMIZED_BOTH);  // used to open frame with maximum lenght and width
       setLayout(null);
       
       JPanel p1 = new JPanel();  // top panel
       p1.setLayout(null);
       p1.setBounds(0,0,1600,65);
       p1.setBackground(new Color(0,0,102));
       add(p1);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/dashboard.png"));
       Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel icon = new JLabel(i3);
       icon.setBounds(5,0,70,70);
       p1.add(icon);
       
       JLabel heading = new JLabel("Dashboard");
       heading.setBounds(80,10,300,40);
       heading.setForeground(Color.WHITE);
       heading.setFont(new Font("Tahoma",Font.BOLD,30));
       p1.add(heading);
       
       JPanel p2 = new JPanel();  // left side panel
       p2.setLayout(null);
       p2.setBounds(0,65,300,900);
       p2.setBackground(new Color(0,0,102));
       add(p2);
       
       addpersonaldetails= new JButton("Add Personal Details");
       addpersonaldetails.setBounds(0,0,300,50);
       addpersonaldetails.setBackground(new Color(0,0,102));
       addpersonaldetails.setForeground(Color.WHITE);
       addpersonaldetails.setFont(new Font("Tahoma",Font.BOLD,20));
       addpersonaldetails.setMargin(new Insets(0,0,0,55));
       //addpersonaldetails.setBorder(BorderFactory.createEmptyBorder());
       addpersonaldetails.addActionListener(this);
       p2.add(addpersonaldetails);
       
       updatepersonaldetails = new JButton("Update Personal Details");
       updatepersonaldetails.setBounds(0,50,300,50);
       updatepersonaldetails.setBackground(new Color(0,0,102));
       updatepersonaldetails.setForeground(Color.WHITE);
       updatepersonaldetails.setFont(new Font("Tahoma",Font.BOLD,20));
       updatepersonaldetails.setMargin(new Insets(0,0,0,25));
       //addpersonaldetails.setBorder(BorderFactory.createEmptyBorder());
       updatepersonaldetails.addActionListener(this);
       p2.add(updatepersonaldetails);
       
       viewpersonaldetails = new JButton("View Details");
       viewpersonaldetails.setBounds(0,100,300,50);
       viewpersonaldetails.setBackground(new Color(0,0,102));
       viewpersonaldetails.setForeground(Color.WHITE);
       viewpersonaldetails.setFont(new Font("Tahoma",Font.BOLD,20));
       viewpersonaldetails.setMargin(new Insets(0,0,0,140)); // gives us aligining to bottom takes 4 parameter(t,b,l,r)
       //addpersonaldetails.setBorder(BorderFactory.createEmptyBorder());
        viewpersonaldetails.addActionListener(this);
       p2.add(viewpersonaldetails);
       
       JButton Deletepersonaldetails = new JButton("Delete Personal Details");
       Deletepersonaldetails.setBounds(0,150,300,50);
       Deletepersonaldetails.setBackground(new Color(0,0,102));
       Deletepersonaldetails.setForeground(Color.WHITE);
       Deletepersonaldetails.setFont(new Font("Tahoma",Font.BOLD,20));
       Deletepersonaldetails.setMargin(new Insets(0,0,0,30)); // gives us aligining to bottom takes 4 parameter(t,b,l,r)
       //addpersonaldetails.setBorder(BorderFactory.createEmptyBorder());
       p2.add(Deletepersonaldetails);
       
       checkpackages = new JButton("Check Package");
       checkpackages.setBounds(0,200,300,50);
       checkpackages.setBackground(new Color(0,0,102));
       checkpackages.setForeground(Color.WHITE);
       checkpackages.setFont(new Font("Tahoma",Font.BOLD,20));
       checkpackages.setMargin(new Insets(0,0,0,110)); // gives us aligining to bottom takes 4 parameter(t,b,l,r)
       //addpersonaldetails.setBorder(BorderFactory.createEmptyBorder());
       checkpackages.addActionListener(this);
       p2.add(checkpackages);
      
       Bookpackages = new JButton("Book Package");
       Bookpackages.setBounds(0,250,300,50);
       Bookpackages.setBackground(new Color(0,0,102));
       Bookpackages.setForeground(Color.WHITE);
       Bookpackages.setFont(new Font("Tahoma",Font.BOLD,20));
       Bookpackages.setMargin(new Insets(0,0,0,120)); // gives us aligining to bottom takes 4 parameter(t,b,l,r)
       //addpersonaldetails.setBorder(BorderFactory.createEmptyBorder());
        Bookpackages.addActionListener(this);
       p2.add(Bookpackages);
//      
       viewpackages = new JButton("View Package");
       viewpackages.setBounds(0,300,300,50);
       viewpackages.setBackground(new Color(0,0,102));
       viewpackages.setForeground(Color.WHITE);
       viewpackages.setFont(new Font("Tahoma",Font.BOLD,20));
       viewpackages.setMargin(new Insets(0,0,0,120)); // gives us aligining to bottom takes 4 parameter(t,b,l,r)
       //addpersonaldetails.setBorder(BorderFactory.createEmptyBorder());
       viewpackages.addActionListener(this);
       p2.add(viewpackages);
       
      
       viewhotels = new JButton("View Hotels");
       viewhotels.setBounds(0,350,300,50);
       viewhotels.setBackground(new Color(0,0,102));
       viewhotels.setForeground(Color.WHITE);
       viewhotels.setFont(new Font("Tahoma",Font.BOLD,20));
       viewhotels.setMargin(new Insets(0,0,0,140)); // gives us aligining to bottom takes 4 parameter(t,b,l,r)
       //addpersonaldetails.setBorder(BorderFactory.createEmptyBorder());
       viewhotels.addActionListener(this);
       p2.add(viewhotels);
      
       bookhotels = new JButton("Book Hotels");
       bookhotels.setBounds(0,400,300,50);
       bookhotels.setBackground(new Color(0,0,102));
       bookhotels.setForeground(Color.WHITE);
       bookhotels.setFont(new Font("Tahoma",Font.BOLD,20));
       bookhotels.setMargin(new Insets(0,0,0,140)); // gives us aligining to bottom takes 4 parameter(t,b,l,r)
       //addpersonaldetails.setBorder(BorderFactory.createEmptyBorder());
        bookhotels.addActionListener(this);
       p2.add(bookhotels);
      
       viewbookedhotels = new JButton("View Booked Hotel");
       viewbookedhotels.setBounds(0,450,300,50);
       viewbookedhotels.setBackground(new Color(0,0,102));
       viewbookedhotels.setForeground(Color.WHITE);
       viewbookedhotels.setFont(new Font("Tahoma",Font.BOLD,20));
       viewbookedhotels.setMargin(new Insets(0,0,0,70)); // gives us aligining to bottom takes 4 parameter(t,b,l,r)
       //addpersonaldetails.setBorder(BorderFactory.createEmptyBorder());
       viewbookedhotels.addActionListener(this);
       p2.add(viewbookedhotels);
       
       destination= new JButton("Destinations");
       destination.setBounds(0,500,300,50);
       destination.setBackground(new Color(0,0,102));
       destination.setForeground(Color.WHITE);
       destination.setFont(new Font("Tahoma",Font.BOLD,20));
       destination.setMargin(new Insets(0,0,0,130)); // gives us aligining to bottom takes 4 parameter(t,b,l,r)
       //addpersonaldetails.setBorder(BorderFactory.createEmptyBorder());
       destination.addActionListener(this);
       
       p2.add(destination);
       
       payments = new JButton("Payments");
       payments.setBounds(0,550,300,50);
       payments.setBackground(new Color(0,0,102));
       payments.setForeground(Color.WHITE);
       payments.setFont(new Font("Tahoma",Font.BOLD,20));
       payments.setMargin(new Insets(0,0,0,160)); // gives us aligining to bottom takes 4 parameter(t,b,l,r)
       //addpersonaldetails.setBorder(BorderFactory.createEmptyBorder());
       payments.addActionListener(this);
       p2.add(payments);
       
       calculator = new JButton("Calculator");
       calculator.setBounds(0,600,300,50);
       calculator.setBackground(new Color(0,0,102));
       calculator.setForeground(Color.WHITE);
       calculator.setFont(new Font("Tahoma",Font.BOLD,20));
       calculator.setMargin(new Insets(0,0,0,160)); // gives us aligining to bottom takes 4 parameter(t,b,l,r)
       //addpersonaldetails.setBorder(BorderFactory.createEmptyBorder());
       calculator.addActionListener(this);
       p2.add(calculator);
       
       notepad = new JButton("Notepad");
       notepad.setBounds(0,650,300,50);
       notepad.setBackground(new Color(0,0,102));
       notepad.setForeground(Color.WHITE);
       notepad.setFont(new Font("Tahoma",Font.BOLD,20));
       notepad.setMargin(new Insets(0,0,0,170)); // gives us aligining to bottom takes 4 parameter(t,b,l,r)
       //addpersonaldetails.setBorder(BorderFactory.createEmptyBorder());
       notepad.addActionListener(this);
       p2.add(notepad);
       
       about = new JButton("About");
       about.setBounds(0,700,300,40);
       about.setBackground(new Color(0,0,102));
       about.setForeground(Color.WHITE);
       about.setFont(new Font("Tahoma",Font.BOLD,20));
       about.setMargin(new Insets(0,0,0,180)); // gives us aligining to bottom takes 4 parameter(t,b,l,r)
       //addpersonaldetails.setBorder(BorderFactory.createEmptyBorder());
       about.addActionListener(this);
       p2.add(about);
       
       ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Icons/home.jpg"));
       Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
       ImageIcon i6 = new ImageIcon(i5);
       JLabel image = new JLabel(i6);
       image.setBounds(0,0,1650,1000);
       add(image);
       
       JLabel text = new JLabel("Travel And Tourism Management System");
       text.setBounds(400,70,1200,70);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("Raleway",Font.PLAIN,55));
       image.add(text);
       
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
           if(ae.getSource() == addpersonaldetails){
               new Addcustomer(username);
           }
           else if(ae.getSource() ==  viewpersonaldetails){
               new Viewcustomer(username);
           }
           else if(ae.getSource() == updatepersonaldetails){
               new Updatecustomer(username);
           }
           else if(ae.getSource() == checkpackages){
               new CheckPackage();
           }
           else if(ae.getSource() == Bookpackages ){
               new BookPackage(username);
           }
           else if(ae.getSource() ==  viewpackages){
               new ViewPackage(username);
           }
           else if(ae.getSource() == viewhotels){
               new CheckHotels();
           }
           else if(ae.getSource() == destination){
               new Destinations();
           }
           else if(ae.getSource() == bookhotels){
               new BookHotels(username);
           }
           else if(ae.getSource() == viewbookedhotels){
               new ViewBookedHotel(username);
           }
           else if(ae.getSource() == payments){
               new Payments();
           }
           else if(ae.getSource() == calculator){
               
               // runtime ek class hoti hai to jo sirf executable file pick karti hai and calculator ka exectable calc.exe hota hai
               try{
               Runtime.getRuntime().exec("calc.exe");
               }
               catch(Exception e){
                   e.printStackTrace();
               }
           }
           else if(ae.getSource() == notepad){
               try{
                 Runtime.getRuntime().exec("notepad.exe");
                 }
               catch(Exception e){
                   e.printStackTrace();
               }
           }
           else if(ae.getSource() == about){
               new About();
           }
    }
    public static void main(String[] args){
        new Dashboard("");
    }
}
