
package travel.management.systemm;

import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {
    
    CheckPackage(){
        setBounds(450,200,900,600);
      
        String[] package1 = {"GOLD PACKAGE", "6 Days and 7 Nights","Airport Assiastance", "Full Day City Tour", "Free Buffet","Full Day 3 Island Cruise","Soft and Hard Drink","English Speaking Guide","Book Now", "Monsoon Special","Rs 32000/- Only","package1.jpg"};
        String[] package2 = {"Silver Package", "5 Days and 6 Nights","Night Safari", "Half Day City Tour", "Toll Free","Entrance Free Tickets", "Full Day 2 Island Cruise Tour","Hard Drink","Book Now","Winter Special","Rs 24000/- Only","package2.jpg"};
        String[] package3 = {"Bronze Package","4 Days and 5 Nights","Free Clubbing","Horse Riding","Other Services", "Full Day 1 Island Cruise Tour","BBO Dinner" ,"Soft Drink","Book Now","Summer Special","Rs 12000/- Only","package3.jpg"};
        
        JTabbedPane tab = new JTabbedPane();  // use to create tab column
        
        JPanel p1 = createPackage(package1);
        tab.addTab("Package 1", null ,p1); // we pass 3 parameter into tab pannel
        
        JPanel p2 = createPackage(package2);
        tab.addTab("Package 2", null ,p2); // we pass 3 parameter into tab pannel
        
        JPanel p3 = createPackage(package3);
        tab.addTab("Package 3", null ,p3); // we pass 3 parameter into tab pannel
        
        add(tab);
        
        setVisible(true);
    }
    
    public JPanel createPackage(String[]pack){
        
        JTabbedPane tab = new JTabbedPane();  // use to create tab column
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        
        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(50,5,300,30);
        l1.setForeground(Color.YELLOW);
        l1.setFont(new Font("Tahome",Font.BOLD,30));
        p1.add(l1);
        
        JLabel l2 = new JLabel(pack[1]);
        l2.setBounds(50,60,300,30);
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Tahome",Font.BOLD,20));
        p1.add(l2);
        
        JLabel l3 = new JLabel(pack[2]);
        l3.setBounds(50,115,300,30);
        l3.setForeground(Color.GREEN);
        l3.setFont(new Font("Tahome",Font.BOLD,20));
        p1.add(l3);
        
        JLabel l4 = new JLabel(pack[3]);
        l4.setBounds(50,170,300,30);
        l4.setForeground(new Color(131,193,233));
        l4.setFont(new Font("Tahome",Font.BOLD,20));
        p1.add(l4);
        
        JLabel l5 = new JLabel(pack[4]);
        l5.setBounds(50,225,300,30);
        l5.setForeground(Color.PINK);
        l5.setFont(new Font("Tahome",Font.BOLD,20));
        p1.add(l5);
        
        JLabel l6 = new JLabel(pack[5]);
        l6.setBounds(50,280,300,30);
        l6.setForeground(Color.GREEN);
        l6.setFont(new Font("Tahome",Font.BOLD,20));
        p1.add(l6);
        
        JLabel l7 = new JLabel(pack[6]);
        l7.setBounds(50,335,300,30);
        l7.setForeground(Color.ORANGE);
        l7.setFont(new Font("Tahome",Font.BOLD,20));
        p1.add(l7);
        
        JLabel l8 = new JLabel(pack[7]);
        l8.setBounds(50,390,300,30);
        l8.setForeground(Color.BLACK);
        l8.setFont(new Font("Tahome",Font.BOLD,20));
        p1.add(l8);
        
        JLabel l9 = new JLabel(pack[8]);
        l9.setBounds(50,450,300,30);
        l9.setForeground(Color.RED);
        l9.setFont(new Font("Tahome",Font.BOLD,20));
        p1.add(l9);
        
        JLabel l10 = new JLabel(pack[9]);
        l10.setBounds(50,490,300,30);
        l10.setForeground(Color.MAGENTA);
        l10.setFont(new Font("Tahome",Font.BOLD,20));
        p1.add(l10);
        
        JLabel l11 = new JLabel(pack[10]);
        l11.setBounds(400,490,300,30);
        l11.setForeground(Color.BLUE);
        l11.setFont(new Font("Tahome",Font.BOLD,20));
        p1.add(l11);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/"+pack[11]));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,100,400,300);
        p1.add(image);
        
        return p1;
        
    }
    
    public static void main(String []args){
        new CheckPackage();
    }
}
