
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
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ViewStudent implements ActionListener{
    JFrame f;
    JLabel lab1;
    JTextField txt1;
    JButton btn,btn1;
    int count=0;
    ViewStudent(){
        f = new JFrame("View Employee");
        
        f.setBounds(350,250,500,270);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setResizable(false);
        f.getContentPane().setBackground(Color.WHITE);
        Cursor cur = new Cursor(Cursor.HAND_CURSOR);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("student_management/view.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,270,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel la=new JLabel(i3); 
        la.setBounds(0,0,500,270);
        f.add(la);
        
        lab1 = new JLabel("Employee ID");
        lab1.setBounds(50,50,200,30);
        lab1.setFont(new Font("Serif",Font.BOLD,24));
        lab1.setForeground(Color.WHITE);
        la.add(lab1);
        
        txt1 = new JTextField();
        txt1.setBounds(220,50,220,30);
        txt1.setFont(new Font("TAHOMBO",Font.PLAIN,18));
        f.add(txt1);
        
        btn = new JButton("Back");
        btn.setBounds(150,130,120,32);
        btn.setBackground(Color.WHITE);
        btn.setForeground(Color.BLACK);
        btn.setFont(new Font("TAHOMA",Font.PLAIN,16));
        btn.setCursor(cur);
        btn.addActionListener(this);
        la.add(btn);
        
        btn1 = new JButton("Search");
        btn1.setBounds(320,130,120,32);
        btn1.setBackground(Color.WHITE);
        btn1.setForeground(Color.BLACK);
        btn1.setFont(new Font("TAHOMA",Font.PLAIN,16));
        btn1.setCursor(cur);
        btn1.addActionListener(this);
        la.add(btn1);
          
        
        
        f.setVisible(true);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == btn){
             f.setVisible(false);
             new StudentDetails().setVisible(true);
         }
         if(e.getSource() == btn1){
            try{
           
                Connection con = DataBase.dbconnect();
                String empid=txt1.getText();
                
                PreparedStatement pst = con.prepareStatement("select * from employeedetails where studentid=?");
                pst.setString(1, empid);
                 ResultSet rs=pst.executeQuery();
                
                 if(rs.next()){
                        f.setVisible(false);
                        new SeeStudentDetails(empid).setVisible(true);
                 }
                 else{
                      
                     JOptionPane.showMessageDialog(null, "Employee ID Not Found");
                      txt1.setText("");
                      count++;
                     if(count == 3){
                          txt1.setBackground(Color.LIGHT_GRAY);
                          btn1.setBackground(Color.LIGHT_GRAY);
                           btn.setBackground(Color.LIGHT_GRAY);
                     }
                 }
                 if(count == 3){
                       JOptionPane.showMessageDialog(null, "Please Retry in 10 seconds");
                        txt1.setEnabled(false);
                       
                        btn1.setEnabled(false);
                        btn.setEnabled(false);
                       
                     try{
                         
                            Thread.sleep(10000);
                            JOptionPane.showMessageDialog(null, "Now You will Try..!!");
                            txt1.setEnabled(true);
                            btn1.setEnabled(true);
                            btn.setEnabled(true);
                            txt1.setBackground(Color.WHITE);
                             btn1.setBackground(Color.WHITE);
                             btn.setBackground(Color.WHITE);
                        }
                        catch(Exception eq){}
                      count=0;
                   }
                 
            }
            catch(Exception em){
                em.printStackTrace();
            }
           
         }
    }
    
     public static void main(String[] args){
        new ViewStudent();
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

}
