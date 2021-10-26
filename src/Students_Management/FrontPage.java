
package Students_Management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FrontPage implements ActionListener{
   JFrame f;
   JButton btn;
  
    FrontPage(){
        f = new JFrame("Front Page");
        f.setBounds(150,100,1200,670);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.WHITE);
        f.setResizable(false);
        f.setLayout(null);
       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("student_management/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1160,550,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lab1=new JLabel(i3); 
        lab1.setBounds(13,110,1160,550);
        
        f.add(lab1);
        
        JLabel lab2 = new JLabel("STUDENT MANAGEMENT SYSTEM");
        lab2.setFont(new Font("TAHOMA",Font.PLAIN,70));
        lab2.setForeground(Color.RED);
        lab2.setBounds(40,25,1300,70);
        f.add(lab2);
      
        
        
        btn = new JButton("Click Here To Continue");
        btn.setBounds(750,520, 250,55);
        btn.setFont(new Font("TAHOMA",Font.PLAIN,18));
        btn.setForeground(Color.WHITE);
        btn.setBackground(Color.BLACK);
        btn.addActionListener(this);
        f.add(btn);
        
        
        f.setVisible(true);
          
        while(true){
            lab2.setVisible(false);
            try{
                   Thread.sleep(500);
                }
            catch(Exception ex){ }
            
            lab2.setVisible(true);
            try{
                   Thread.sleep(500);
                } 
            catch(Exception ex){ }
        }
       
   }
   
    @Override
    public void actionPerformed(ActionEvent e) {
         f.setVisible(false);
        new LoginPage().setVisible(true);
        
    }
    
    public static void main(String[] args) {
         new FrontPage();

    }

}
