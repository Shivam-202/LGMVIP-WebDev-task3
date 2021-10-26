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
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class AddStudent implements ActionListener {

    private static void add(JProgressBar pb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    JFrame f;
    JLabel lab, lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9, lab10, lab11, lab12, lab13;
    JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10, txt11, txt12, txt13;

    JButton btn, btn1;
    JLabel la;

    AddStudent() {

        f = new JFrame("Add Employee");

        f.setBounds(200, 60, 900, 700);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setResizable(false);
        f.getContentPane().setBackground(Color.WHITE);
        Cursor cur = new Cursor(Cursor.HAND_CURSOR);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("student_management/add.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        la = new JLabel(i3);
        la.setBounds(0, 0, 900, 700);
        f.add(la);

        lab = new JLabel("New Employee Details");
        lab.setBounds(280, 50, 400, 40);
        lab.setFont(new Font("Serif", Font.PLAIN, 35));
        lab.setForeground(Color.BLACK);
        la.add(lab);

        lab1 = new JLabel("Name");
        lab1.setBounds(50, 150, 200, 30);
        lab1.setFont(new Font("Serif", Font.BOLD, 24));
        lab1.setForeground(Color.BLACK);
        la.add(lab1);

        lab2 = new JLabel("Father's Name");
        lab2.setBounds(50, 210, 200, 30);
        lab2.setFont(new Font("Serif", Font.BOLD, 24));
        lab2.setForeground(Color.BLACK);
        la.add(lab2);

        lab3 = new JLabel("Age");
        lab3.setBounds(50, 270, 200, 30);
        lab3.setFont(new Font("Serif", Font.BOLD, 24));
        lab3.setForeground(Color.BLACK);
        la.add(lab3);

        lab4 = new JLabel("Class");
        lab4.setBounds(50, 330, 200, 30);
        lab4.setFont(new Font("Serif", Font.BOLD, 24));
        lab4.setForeground(Color.BLACK);
        la.add(lab4);

        lab5 = new JLabel("Student ID");
        lab5.setBounds(50, 390, 200, 30);
        lab5.setFont(new Font("Serif", Font.BOLD, 24));
        lab5.setForeground(Color.BLACK);
        la.add(lab5);

        lab6 = new JLabel("Address");
        lab6.setBounds(50, 450, 200, 30);
        lab6.setFont(new Font("Serif", Font.BOLD, 24));
        lab6.setForeground(Color.BLACK);
        la.add(lab6);

        lab7 = new JLabel("Mobile No.");
        lab7.setBounds(50, 510, 200, 30);
        lab7.setFont(new Font("Serif", Font.BOLD, 24));
        lab7.setForeground(Color.BLACK);
        la.add(lab7);

        lab8 = new JLabel("HINDI");
        lab8.setBounds(430, 210, 200, 30);
        lab8.setFont(new Font("Serif", Font.BOLD, 24));
        lab8.setForeground(Color.BLACK);
        la.add(lab8);

        lab9 = new JLabel("ENGLISH");
        lab9.setBounds(430, 270, 200, 30);
        lab9.setFont(new Font("Serif", Font.BOLD, 24));
        lab9.setForeground(Color.BLACK);
        la.add(lab9);

        lab10 = new JLabel("SOCIAL SCIENCE");
        lab10.setBounds(430, 330, 200, 30);
        lab10.setFont(new Font("Serif", Font.BOLD, 24));
        lab10.setForeground(Color.BLACK);
        la.add(lab10);

        lab11 = new JLabel("SCIENCE");
        lab11.setBounds(430, 390, 200, 30);
        lab11.setFont(new Font("Serif", Font.BOLD, 24));
        lab11.setForeground(Color.BLACK);
        la.add(lab11);

        lab12 = new JLabel("SANSKRIT");
        lab12.setBounds(430, 450, 200, 30);
        lab12.setFont(new Font("Serif", Font.BOLD, 24));
        lab12.setForeground(Color.BLACK);
        la.add(lab12);

        lab13 = new JLabel("MATHEMATICS");
        lab13.setBounds(430, 510, 200, 30);
        lab13.setFont(new Font("Serif", Font.BOLD, 24));
        lab13.setForeground(Color.BLACK);
        la.add(lab13);

        txt1 = new JTextField();
        txt1.setBounds(230, 150, 180, 30);
        txt1.setFont(new Font("TAHOMBO", Font.PLAIN, 18));
        f.add(txt1);

        txt2 = new JTextField();
        txt2.setBounds(230, 210, 180, 30);
        txt2.setFont(new Font("TAHOMBO", Font.PLAIN, 18));
        f.add(txt2);

        txt3 = new JTextField();
        txt3.setBounds(230, 270, 180, 30);
        txt3.setFont(new Font("TAHOMBO", Font.PLAIN, 18));
        f.add(txt3);

        txt4 = new JTextField();
        txt4.setBounds(230, 330, 180, 30);
        txt4.setFont(new Font("TAHOMBO", Font.PLAIN, 18));
        f.add(txt4);

        txt5 = new JTextField();
        txt5.setBounds(230, 390, 180, 30);
        txt5.setFont(new Font("TAHOMBO", Font.PLAIN, 18));
        f.add(txt5);

        txt6 = new JTextField();
        txt6.setBounds(230, 450, 180, 30);
        txt6.setFont(new Font("TAHOMBO", Font.PLAIN, 18));
        f.add(txt6);

        txt7 = new JTextField();
        txt7.setBounds(230, 510, 180, 30);
        txt7.setFont(new Font("TAHOMBO", Font.PLAIN, 18));
        f.add(txt7);

        txt8 = new JTextField();
        txt8.setBounds(620, 210, 180, 30);
        txt8.setFont(new Font("TAHOMBO", Font.PLAIN, 18));
        f.add(txt8);

        txt9 = new JTextField();
        txt9.setBounds(620, 270, 180, 30);
        txt9.setFont(new Font("TAHOMBO", Font.PLAIN, 18));
        f.add(txt9);

        txt10 = new JTextField();
        txt10.setBounds(620, 330, 180, 30);
        txt10.setFont(new Font("TAHOMBO", Font.PLAIN, 18));
        f.add(txt10);

        txt11 = new JTextField();
        txt11.setBounds(620, 390, 180, 30);
        txt11.setFont(new Font("TAHOMBO", Font.PLAIN, 18));
        f.add(txt11);

        txt12 = new JTextField();
        txt12.setBounds(620, 450, 180, 30);
        txt12.setFont(new Font("TAHOMBO", Font.PLAIN, 18));
        f.add(txt12);

        txt13 = new JTextField();
        txt13.setBounds(620, 510, 180, 30);
        txt13.setFont(new Font("TAHOMBO", Font.PLAIN, 18));
        f.add(txt13);

        btn = new JButton("Back");
        btn.setBounds(200, 570, 130, 35);
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        btn.setCursor(cur);
        btn.addActionListener(this);
        la.add(btn);

        btn1 = new JButton("Submit");
        btn1.setBounds(490, 570, 130, 35);
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        btn1.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        btn1.setCursor(cur);
        btn1.addActionListener(this);
        la.add(btn1);

        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            f.setVisible(false);
            new StudentDetails().setVisible(true);
        }

        if (e.getSource() == btn1) {

            Connection con = DataBase.dbconnect();

            String Name = txt1.getText();
            String Fathername = txt2.getText();
            String Age = txt3.getText();
            String Class = txt4.getText();
            String Studentid = txt5.getText();
            String Address = txt6.getText();
            String Mobileno = txt7.getText();
            String Hindi = txt8.getText();
            String English = txt9.getText();
            String SocialSci = txt10.getText();
            String Science = txt11.getText();
            String Sanskrit = txt12.getText();
            String Maths = txt13.getText();

            try {
                if (Name.trim().isEmpty() || Fathername.trim().isEmpty() || Age.trim().isEmpty() || Class.trim().isEmpty() || Studentid.trim().isEmpty() || Address.trim().isEmpty() || Mobileno.trim().isEmpty() || Hindi.trim().isEmpty() || English.trim().isEmpty() || SocialSci.trim().isEmpty() || Science.trim().isEmpty() || Sanskrit.trim().isEmpty() || Maths.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All Field is Required..!!");
                } else {

                    if (Studentid.length() < 4) {
                        JOptionPane.showMessageDialog(null, "Allow Only 4 Digit Employee ID");
                    } else {

                        if (Mobileno.length() < 10) {
                            JOptionPane.showMessageDialog(null, "Allow Only 10 Digit Mobile Number");
                        } else {

                            if(Integer.parseInt(Hindi) >= 100 || Integer.parseInt(English) >= 100 ||  Integer.parseInt(SocialSci) >= 100 || Integer.parseInt(Science) >= 100 || Integer.parseInt(Sanskrit) >= 100 || Integer.parseInt(Maths) >= 100)
                            { JOptionPane.showMessageDialog(null, "Marks is not Greater than 100");}
                            if(Integer.parseInt(Hindi) <= 0 || Integer.parseInt(English) <= 0 ||  Integer.parseInt(SocialSci) <= 0 || Integer.parseInt(Science) <= 0 || Integer.parseInt(Sanskrit) <= 0 || Integer.parseInt(Maths) <= 0)
                            { JOptionPane.showMessageDialog(null, "Marks is not Less than 0");}
                            else{
                                PreparedStatement pstm = con.prepareStatement("insert into employeedetails(name,fathername,age,class,studentid,address,mobileno,hindi,english,socialscience,science,sanskrit,maths) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                                pstm.setString(1, Name);
                                pstm.setString(2, Fathername);
                                pstm.setString(3, Age);
                                pstm.setString(4, Class);
                                pstm.setString(5, Studentid);
                                pstm.setString(6, Address);
                                pstm.setString(7, Mobileno);
                                pstm.setString(8, Hindi);
                                pstm.setString(9, English);
                                pstm.setString(10, SocialSci);
                                pstm.setString(11, Science);
                                pstm.setString(12, Sanskrit);
                                pstm.setString(13, Maths);
                                
                                pstm.executeUpdate();
                                
                                JOptionPane.showMessageDialog(null, "Employee Details Added Successfully..!!");
                                
                                txt1.setText("");
                                txt2.setText("");
                                txt3.setText("");
                                txt4.setText("");
                                txt5.setText("");
                                txt6.setText("");
                                txt7.setText("");
                                txt8.setText("");
                                txt9.setText("");
                                txt10.setText("");
                                txt11.setText("");
                                txt12.setText("");
                                txt13.setText("");
                            }
                           
                        }
                    }
                }
            } catch (Exception err) {
            }

        }

    }


public static void main(String[] args){
        new AddStudent();
    }


    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
