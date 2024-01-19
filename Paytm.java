
package travel.management.systemm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paytm extends JFrame implements ActionListener{
    
    JButton back;
    
    Paytm(){
        setBounds(500,200,800,600);
        
        JEditorPane pane = new JEditorPane();
        pane.setEditable(false); // hum edit nhi karna chahte hai text area ko
        
        try{
           
            pane.setPage("https://www.paytmbank.com/") ; // set page is used to load the page on other website
           } catch(Exception e){
            
            pane.setContentType("text/html");
            pane.setText("<html> Could not load , Error 404 </html>");
        }
        
        JScrollPane sp = new JScrollPane(pane); // jscroll pane is used to add scroll bar in text area
        getContentPane().add(sp);
        
        back = new JButton("Back");
        back.setBounds(610,20,80,40);
        back.addActionListener(this);
        pane.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Payments();
    }
    public static void main(String [] args){
        new Paytm();
    }
}
