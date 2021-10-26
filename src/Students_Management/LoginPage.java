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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class LoginPage implements ActionListener{
    
    JButton btn,btn1;
    JTextField txt1;
    JPasswordField txt2;
    JFrame f;
    LoginPage(){
        f = new JFrame("Login Page");
        f.setBounds(430,200,650,350);
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         f.setLayout(null);
         f.setResizable(false);
        f.getContentPane().setBackground(Color.WHITE);
          Cursor cur = new Cursor(Cursor.HAND_CURSOR);
          
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("student_management/login.jpg"));
         Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel la = new JLabel(i3);
        
         la.setBounds(400,20,190,180);
         f.add(la);
         
         JLabel lab1=new JLabel("UserName");
         lab1.setBounds(50,60,300,30);
         lab1.setFont(new Font("TAHOMBO",Font.BOLD,20));
         f.add(lab1);
         
         JLabel lab2=new JLabel("Password");
         lab2.setBounds(50,120,300,30);
         lab2.setFont(new Font("TAHOMBO",Font.BOLD,20));
         f.add(lab2);
         
         txt1 = new JTextField();
         txt1.setBounds(170,63,220,30);
         txt1.setFont(new Font("TAHOMBO",Font.PLAIN,18));
         f.add(txt1);
         
         txt2 = new JPasswordField();
         txt2.setBounds(170,123,220,30);
         txt2.setFont(new Font("TAHOMBO",Font.PLAIN,18));
         f.add(txt2);
         
          f.getContentPane().setBackground(Color.WHITE);
          
          btn = new JButton("Login");
          btn.setBounds(260,190,120,35);
          btn.setBackground(Color.BLACK);
          btn.setForeground(Color.WHITE);
          btn.setFont(new Font("TAHOMA",Font.PLAIN,16));
          btn.setCursor(cur);
          btn.addActionListener(this);
          f.add(btn);
         
          btn1 = new JButton("Cancel");
          btn1.setBounds(80,190,120,35);
          btn1.setBackground(Color.BLACK);
          btn1.setForeground(Color.WHITE);
          btn1.setFont(new Font("TAHOMA",Font.PLAIN,16));
          btn1.setCursor(cur);
          btn1.addActionListener(this);
          f.add(btn1);
          
         f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == btn1){
             System.exit(0);
         }
         if(e.getSource() == btn){
          
             try{
                  Connection con = DataBase.dbconnect();
           
                  String user = txt1.getText();
                  String pass = txt2.getText();
          
                 PreparedStatement pst=( PreparedStatement)con.prepareStatement("select * from employee where username=? and password=?");   
                 pst.setString(1, user);
                 pst.setString(2, pass);
                
                 ResultSet rs = pst.executeQuery();
                
                 if(rs.next()){
                     f.setVisible(false);
                     new StudentDetails().setVisible(true);
                 }
                 else{
                     JOptionPane.showMessageDialog(null,"Invalid username Or Password");
                 }
                 txt1.setText("");
                 txt2.setText("");
             } catch (SQLException ex) {
                  ex.printStackTrace();
             }
           
         }
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


  public static void main(String[] args){
       new LoginPage();
    }
}