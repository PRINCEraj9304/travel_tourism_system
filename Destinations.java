
package travel.management.systemm;
import javax.swing.*;
import java.awt.*;


public class Destinations extends JFrame implements Runnable {
    
    Thread t1; // we have to make thread class object in runnable
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JLabel[] label = new JLabel[]{l1,l2,l3,l4,l5,l6,l7,l8,l9,l10};
    // there is no need of initialisatio of jlabel 
    
    JLabel caption;
    public void run(){
        
        String[] text = new String[]{"JW Marriot Hotel","Madarin Oriental Hotel" ,"Four Season Hotel", "Raddisson Hotel" ,"The Taj Hotel" ,"Dimadond Inn Hotel", "Classio Hotel","The Bay Club Hotel","Gargee Gautam Hotel","RiverView Hotel"};
        
        try{
          
            for(int i=0;i<7;i++){
                label[i].setVisible(true);  // we will start label[i] slide to show on frame
                // caption.setText(text[i]);
                Thread.sleep(2500);  // label[i] slide will  be shown for 2.5 second 
                label[i].setVisible(false); // then at last label[i] slide will closed and other slide will open
             }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    Destinations(){
        setBounds(500,200,800,600);
        
        caption = new JLabel();  // caption is for writing hotel name
        caption.setBounds(50,500,1000,70);
        caption.setFont(new Font("Tahoma",Font.PLAIN,40));
        caption.setForeground(Color.WHITE);
        add(caption);
         
        // we can show all hotel diagram one by one or we cal also run a for loop  
        // we will initialize imageicon with null so that there will be no error after then we will finally declare inside the for loop
        
        ImageIcon i1 = null ,i2 = null,i3 = null ,i4 = null,i5 = null, i6 = null ,i7 = null, i8 = null, i9 = null, i10 = null;
        // we cannot concenate imageicon like string se we haves to make array of imageicon to use dynamically
        ImageIcon[] image = new ImageIcon[]{i1,i2,i3,i4,i5,i6,i7,i8,i9,i10};
        
        Image j1 = null ,j2 = null,j3 = null ,j4 = null,j5 = null, j6 = null ,j7 = null, j8 = null, j9 = null, j10 = null;
        // we cannot concenate image like string se we haves to make array of image to use dynamically
        Image[] jimage = new Image[]{j1,j2,j3,j4,j5,j6,j7,j8,j9,j10};
        
        ImageIcon k1 = null ,k2 = null,k3 = null ,k4 = null,k5 = null, k6 = null ,k7 = null, k8 = null, k9 = null, k10 = null;
        // we cannot concenate image like string se we haves to make array of image to use dynamically
        ImageIcon[] kimage = new ImageIcon[]{k1,k2,k3,k4,k5,k6,k7,k8,k9,k10};
        
        for(int i=0;i<7;i++){
            
        image[i] = new ImageIcon(ClassLoader.getSystemResource("Icons/dest"+(i+1)+".jpg"));
        jimage[i] = image[i].getImage().getScaledInstance(800, 600,Image.SCALE_DEFAULT);
        kimage[i] = new ImageIcon(jimage[i]);
        label[i] = new JLabel(kimage[i]);  // we also have to run loop for jlabel as we have to show 10 iocns so there should be 10 differnet 
                                            // 10 Jlabel so we will again declare array for this
        label[i].setBounds(0,0,800,600);
        add(label[i]);
        
        // now we have to slideshow all the icons like one will appear at a time and then it will disappear then second will be shown and so on
        // so we have to use concept of multithreading using runnable interface
        }
        
        t1 = new Thread(this);
        t1.start();  // start will call run method intenally so we have to override this
        
        setVisible(true);
    }
    
    public static void main(String []args){
        new Destinations();
    }
}
