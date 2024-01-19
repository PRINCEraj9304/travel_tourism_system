package travel.management.systemm;

import javax.swing.*;
import java.awt.*; // for importing image class

// JFrame ke andar kuch function hote hai jo ki extended java swing me hote hai to humen pahle usse import kiya for jframe call kiya
// multiple inheritence in java is not allowed means you cannot extend more than one class, allowed with interfaces not with classes

 // public abstract class Splash extends JFrame implements Runnable {
    // runnable ke under run method ko override karna padta hai ya fir spalsh class ko abstract bana do lekin fir ek concept aata hai ki
    // agar aap kisi class ko abstract bana dete ho to fir aap us class ki object nhi bana sakte ho isliye hum override karenge
      
public class Splash extends JFrame implements Runnable {
        Thread thread;  // thread object
        
    Splash() {

        // setSize(1200,600);
        // we will make frame with the help of setsize and it take two arguement frame length and its width
        // setLocation(200,100);
        // bydefault frame will open from leftmost top side but we want it to open from centre so we give location to it
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("Icons/splash.jpg"));

        // image icon naam ka class banaya taki image ko access kar sake fir drive or directory se image ko lene ke liye classloader class ka use 
        // kiye aur fir inbulit functionn ka use kiye
        // ab hume i1 image ko frame ke upar place karna hai to iske liye jlabel ka use karte hai
        Image I2 = I1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        // above line is for scaling image to get required shape. we import Image class java.awt but we cant directly add Image class object
        // onto frame, we have to use imageIcon again 

        ImageIcon I3 = new ImageIcon(I2);
        JLabel image = new JLabel(I3);

        // JLabel image = new JLabel(I1);
        add(image);

        setVisible(true); // bydefault frame is invisible so for visibility we write this line of code
        thread  = new Thread(this);
        thread.start();   // start method call run function internally, aur run function ko multithreaded way me behave karwane ke liye 
                          // he start ka use karte hai agar aap sirf run func ka use karte hai to wo normally run ho jayega
    }
    
    public void run(){
        try{
            thread.sleep(7000);  // after 7 sec frame will close and login page will open
            // New Login;
            setVisible(false); // frame will close after 7 sec
        }
        catch(Exception e){
            
        }
    }

    public static void main(String[] arsg) {
        // class ko run karne ke liye main ke andar object banana padega to humne new splash naam se banaya
        // class ke object banate he constructor call hota haii to  hume constructor banana pdata hai

        Splash frame = new Splash();
        int x = 1;
        for (int i = 1; i < 500; x += 7, i += 6) {
            frame.setLocation(750-(x+i)/2,400-(i/2));
            frame.setSize(x + i, i);

            try {
                Thread.sleep(20); // thread help us to control transisiton time
            } catch (Exception e) {
            }
        }
    }
}
