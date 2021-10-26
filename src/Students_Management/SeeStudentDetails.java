
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SeeStudentDetails implements ActionListener{
    JFrame f;
    JLabel lab,lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,lab9, la1,la2,la3,la4,la5,la6,la7,la8,la9;
    JButton btn;
    String a,b,c,d,e,ff,g,h,i;
    
    SeeStudentDetails(String txt1){
        
        try{
             Connection con = DataBase.dbconnect();
                String stuid=txt1;
                
                PreparedStatement pst = con.prepareStatement("select * from employeedetails where studentid=?");
                pst.setString(1, stuid);
                ResultSet rs=pst.executeQuery();
                
                if(rs.next()){
                    a=rs.getString("name");
                    b=rs.getString("fathername");
                    c=rs.getString("class");
                    d=rs.getString("hindi");
                    e=rs.getString("english");
                    ff=rs.getString("socialscience");
                    g=rs.getString("science");
                    h=rs.getString("sanskrit");
                    i=rs.getString("maths");
                }
        }
        catch(Exception en){
            en.printStackTrace();
        }
         f = new JFrame("Remove Employee");
   
        f.setBounds(300,70,595,750);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setResizable(false);
        f.getContentPane().setBackground(Color.WHITE);
        Cursor cur = new Cursor(Cursor.HAND_CURSOR);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("student_management/print.jpg"));
        Image i2 = i1.getImage().getScaledInstance(590,750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel la=new JLabel(i3); 
        la.setBounds(0,0,595,750);
        f.add(la);
        
        lab = new JLabel("Employee Details");
        lab.setBounds(170,10,300,35);
        lab.setFont(new Font("Serif",Font.BOLD,28));
        lab.setForeground(Color.BLACK);
        la.add(lab);
        
        lab1 = new JLabel("Name");
        lab1.setBounds(50,60,200,30);
        lab1.setFont(new Font("Serif",Font.BOLD,24));
        lab1.setForeground(Color.BLACK);
        la.add(lab1);
        
        lab2 = new JLabel("Father's Name");
        lab2.setBounds(50,110,200,30);
        lab2.setFont(new Font("Serif",Font.BOLD,24));
        lab2.setForeground(Color.BLACK);
        la.add(lab2);
        
        lab3 = new JLabel("Class");
        lab3.setBounds(50,160,200,30);
        lab3.setFont(new Font("Serif",Font.BOLD,24));
        lab3.setForeground(Color.BLACK);
        la.add(lab3);
        
        lab4 = new JLabel("HINDI");
        lab4.setBounds(50,250,200,30);
        lab4.setFont(new Font("Serif",Font.BOLD,24));
        lab4.setForeground(Color.BLACK);
        la.add(lab4);
        
        lab5 = new JLabel("ENGLISH");
        lab5.setBounds(50,300,200,30);
        lab5.setFont(new Font("Serif",Font.BOLD,24));
        lab5.setForeground(Color.BLACK);
        la.add(lab5);
        
        lab6 = new JLabel("SOCIAL SCIENCE");
        lab6.setBounds(50,350,200,30);
        lab6.setFont(new Font("Serif",Font.BOLD,24));
        lab6.setForeground(Color.BLACK);
        la.add(lab6);
        
        lab7 = new JLabel("SCIENCE");
        lab7.setBounds(50,400,200,30);
        lab7.setFont(new Font("Serif",Font.BOLD,24));
        lab7.setForeground(Color.BLACK);
        la.add(lab7);
    
        
        lab8 = new JLabel("SANSKRIT");
        lab8.setBounds(50,450,200,30);
        lab8.setFont(new Font("Serif",Font.BOLD,24));
        lab8.setForeground(Color.BLACK);
        la.add(lab8);
        
        lab9 = new JLabel("MATHEMATICS");
        lab9.setBounds(50,500,200,30);
        lab9.setFont(new Font("Serif",Font.BOLD,24));
        lab9.setForeground(Color.BLACK);
        la.add(lab9);
        
        
        
        la1 = new JLabel(a);
        la1.setBounds(260,60,700,30);
        la1.setFont(new Font("Serif",Font.BOLD,24));
        la1.setForeground(Color.RED);
        la.add(la1);
        
        la2 = new JLabel(b);
        la2.setBounds(260,110,700,30);
        la2.setFont(new Font("Serif",Font.BOLD,24));
        la2.setForeground(Color.RED);
        la.add(la2);
        
        la3 = new JLabel(c);
        la3.setBounds(260,160,700,30);
        la3.setFont(new Font("Serif",Font.BOLD,24));
        la3.setForeground(Color.RED);
        la.add(la3);
        
        la4 = new JLabel(d);
        la4.setBounds(260,250,700,30);
        la4.setFont(new Font("Serif",Font.BOLD,24));
        la4.setForeground(Color.RED);
        la.add(la4);
        
        la5 = new JLabel(e);
        la5.setBounds(260,300,700,30);
        la5.setFont(new Font("Serif",Font.BOLD,24));
        la5.setForeground(Color.RED);
        la.add(la5);
        
        la6 = new JLabel(ff);
        la6.setBounds(260,350,700,30);
        la6.setFont(new Font("Serif",Font.BOLD,24));
        la6.setForeground(Color.RED);
        la.add(la6);
        
        la7 = new JLabel(g);
        la7.setBounds(260,400,700,30);
        la7.setFont(new Font("Serif",Font.BOLD,24));
        la7.setForeground(Color.RED);
        la.add(la7);
    
        
        la8 = new JLabel(h);
        la8.setBounds(260,450,700,30);
        la8.setFont(new Font("Serif",Font.BOLD,24));
        la8.setForeground(Color.RED);
        la.add(la8);
        
        la9 = new JLabel(i);
        la9.setBounds(260,500,700,30);
        la9.setFont(new Font("Serif",Font.BOLD,24));
        la9.setForeground(Color.RED);
        la.add(la9);
        
        
        btn = new JButton("Back");
        btn.setBounds(220,610,120,32);
        btn.setBackground(Color.WHITE);
        btn.setForeground(Color.BLACK);
        btn.setFont(new Font("TAHOMA",Font.PLAIN,16));
        btn.setCursor(cur);
        btn.addActionListener(this);
        la.add(btn);
        
        f.setVisible(true);
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == btn){
             f.setVisible(false);
           new ViewStudent().setVisible(true);
         }
    }
    
    public static void main(String[] args){
        new SeeStudentDetails("");
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
