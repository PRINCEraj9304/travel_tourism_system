
package travel.management.systemm;
import javax.swing.*;
import java.awt.*;


public class Loading extends JFrame implements Runnable {
    Thread t;
    JProgressBar bar;
    String Username;
    
    // humlog progressbar 0 se 100 tak lekar jane ke liye multithreading concept use kar rahe hain jo ki splash me use kar chuke hai
    public void run(){
        try{
            
            for(int i=1;i<=101;i++){
                
                int max = bar.getMaximum();  // give us maxm value
                int value = bar.getValue(); // give us current value
                
                if(value<max){
                    bar.setValue(bar.getValue()+1);
                }
                else{
                    setVisible(false);
                    new Dashboard(Username);
                }
                Thread.sleep(30);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    Loading(String Username){
         
         this.Username = Username;
         t = new Thread(this); // thread class ka object banaya taki run method ko call kiya jaye
         setBounds(500,200,650,400);
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
         JLabel text = new JLabel("Travel and Tourism Application");
         text.setBounds(50,20,600,40);
         text.setForeground(Color.BLUE);
         text.setFont(new Font("Raleway",Font.BOLD,35));
         add(text);
         
         bar = new JProgressBar();  // used to create progressbar
         bar.setBounds(150,100,300,35);
         bar.setStringPainted(true); // setstringpaintd is used to show percentage or progress
         add(bar);
         
         JLabel loading = new JLabel("Loading Please Wait...");
         loading.setBounds(175,140,300,25);
         loading.setForeground(Color.RED);
         loading.setFont(new Font("Raleway",Font.BOLD,18));
         add(loading);
         
         JLabel username = new JLabel("Welcome" + "" + Username);
         username.setBounds(30,320,350,25);
         username.setForeground(Color.RED);
         username.setFont(new Font("Raleway",Font.BOLD,18));
         add(username);
         t.start();
         
         setVisible(true);
         
    }
    
    public static void main(String[] args){
        new Loading("");  // creation of constructor
    }
}
