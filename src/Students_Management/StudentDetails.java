
package Students_Management;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StudentDetails implements ActionListener{
    JFrame f;
    JButton btn,btn1,btn2,btn3,btn4;
    StudentDetails(){
         f = new JFrame("Employee Details");
        
        f.setBounds(200,100,700,500);
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         f.setLayout(null);
         f.setResizable(false);
        f.getContentPane().setBackground(Color.WHITE);
        Cursor cur = new Cursor(Cursor.HAND_CURSOR);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("student_management/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lab1=new JLabel(i3); 
        lab1.setBounds(0,0,700,500);
        f.add(lab1);
        
          
          btn = new JButton("Add");
          btn.setBounds(360,60,120,35);
          btn.setForeground(Color.BLACK);
          btn.setFont(new Font("TAHOMA",Font.PLAIN,18));
          btn.setCursor(cur);
          btn.addActionListener(this);
          lab1.add(btn);
          
         
          btn1 = new JButton("View");
          btn1.setBounds(520,60,120,35);
          btn1.setForeground(Color.BLACK);
          btn1.setFont(new Font("TAHOMA",Font.PLAIN,18));
          btn1.setCursor(cur);
          btn1.addActionListener(this);
          lab1.add(btn1);
          
          btn2 = new JButton("Remove");
          btn2.setBounds(360,130,120,35);
          btn2.setForeground(Color.BLACK);
          btn2.setFont(new Font("TAHOMA",Font.PLAIN,18));
          btn2.setCursor(cur);
          btn2.addActionListener(this); 
          lab1.add(btn2);
          
         
          btn3 = new JButton("Update");
          btn3.setBounds(520,130,120,35);
          btn3.setForeground(Color.BLACK);
          btn3.setFont(new Font("TAHOMA",Font.PLAIN,18));
          btn3.setCursor(cur);
          btn3.addActionListener(this);
          lab1.add(btn3);
        
          btn4 = new JButton("Back");
          btn4.setBounds(450,190,120,35);
          btn4.setBackground(Color.BLACK);
          btn4.setForeground(Color.WHITE);
          btn4.setFont(new Font("TAHOMA",Font.PLAIN,16));
          btn4.setCursor(cur);
          btn4.addActionListener(this);
          lab1.add(btn4);
        f.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn){
            f.setVisible(false);
           new AddStudent().setVisible(true);
        }
        
        
        if(e.getSource() == btn1){
            f.setVisible(false);
           new ViewStudent().setVisible(true);
        }
        
        
        if(e.getSource() == btn2){
              f.setVisible(false);
           new RemoveStudent().setVisible(true);
        }
        
        
        if(e.getSource() == btn3){
             f.setVisible(false);
           new UpdateStudentDetails().setVisible(true);
        }
        
        if(e.getSource() == btn4){
             f.setVisible(false);
             new LoginPage().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new StudentDetails();
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
