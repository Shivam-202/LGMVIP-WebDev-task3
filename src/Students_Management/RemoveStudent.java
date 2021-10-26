package Students_Management;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RemoveStudent implements ActionListener {

    JFrame f;
    JLabel la, lab, lab1, lab2, lab3, l1, l2, l3;
    JTextField txt1;
    JButton bt, btn, btn1, btn2, btn3;
    String a, b, c;

    RemoveStudent() {
        f = new JFrame("Remove Employee");

        f.setBounds(350, 250, 600, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setResizable(false);
        f.getContentPane().setBackground(Color.WHITE);
        Cursor cur = new Cursor(Cursor.HAND_CURSOR);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("student_management/remove.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        la = new JLabel(i3);
        la.setBounds(0, 0, 600, 500);
        f.add(la);

        lab = new JLabel("Employee ID");
        lab.setBounds(90, 50, 200, 30);
        lab.setFont(new Font("Serif", Font.BOLD, 24));
        lab.setForeground(Color.WHITE);
        la.add(lab);

        txt1 = new JTextField();
        txt1.setBounds(250, 50, 220, 30);
        txt1.setFont(new Font("TAHOMBO", Font.PLAIN, 18));
        f.add(txt1);

        lab1 = new JLabel("Name     :");
        lab1.setBounds(10, 200, 200, 30);
        lab1.setFont(new Font("Serif", Font.BOLD, 24));
        lab1.setForeground(Color.WHITE);
        la.add(lab1);
        lab1.setVisible(false);

        lab2 = new JLabel("Father's :");
        lab2.setBounds(10, 250, 200, 30);
        lab2.setFont(new Font("Serif", Font.BOLD, 24));
        lab2.setForeground(Color.WHITE);
        la.add(lab2);
        lab2.setVisible(false);

        lab3 = new JLabel("Class    :");
        lab3.setBounds(10, 300, 200, 30);
        lab3.setFont(new Font("Serif", Font.BOLD, 24));
        lab3.setForeground(Color.WHITE);
        la.add(lab3);
        lab3.setVisible(false);

        
        btn = new JButton("Back");
        btn.setBounds(70, 130, 120, 32);
        btn.setBackground(Color.WHITE);
        btn.setForeground(Color.BLACK);
        btn.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        btn.setCursor(cur);
        btn.addActionListener(this);
        la.add(btn);

        btn1 = new JButton("Search");
        btn1.setBounds(380, 130, 120, 32);
        btn1.setBackground(Color.WHITE);
        btn1.setForeground(Color.BLACK);
        btn1.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        btn1.setCursor(cur);
        btn1.addActionListener(this);
        la.add(btn1);

        bt = new JButton("Refresh");
        bt.setBounds(220, 130, 120, 32);
        bt.setBackground(Color.WHITE);
        bt.setForeground(Color.BLACK);
        bt.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        bt.setCursor(cur);
        bt.addActionListener(this);
        la.add(bt);

        btn2 = new JButton("Remove");
        btn2.setBounds(330, 350, 120, 32);
        btn2.setBackground(Color.WHITE);
        btn2.setForeground(Color.BLACK);
        btn2.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        btn2.setCursor(cur);
        btn2.addActionListener(this);
        la.add(btn2);
        btn2.setVisible(false);

        btn3 = new JButton("Cancel");
        btn3.setBounds(150, 350, 120, 32);
        btn3.setBackground(Color.WHITE);
        btn3.setForeground(Color.BLACK);
        btn3.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        btn3.setCursor(cur);
        btn3.addActionListener(this);
        la.add(btn3);
        btn3.setVisible(false);

        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            f.setVisible(false);
            new StudentDetails().setVisible(true);
        }

        if (e.getSource() == btn1) {

            lab1.setVisible(true);
            lab2.setVisible(true);
            lab3.setVisible(true);
            btn2.setVisible(true);
            btn3.setVisible(true);

            Connection con = DataBase.dbconnect();
            String empid = txt1.getText();

            PreparedStatement pst;
            try {
                pst = con.prepareStatement("select * from employeedetails where studentid=?");
                pst.setString(1, empid);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {

                    a = rs.getString("name");
                    b = rs.getString("fathername");
                    c = rs.getString("class");

                    l1 = new JLabel(a);
                    l1.setBounds(120, 200, 600, 30);
                    l1.setFont(new Font("Serif", Font.BOLD, 24));
                    l1.setForeground(Color.WHITE);
                    la.add(l1);

                    l2 = new JLabel(b);
                    l2.setBounds(120, 250, 600, 30);
                    l2.setFont(new Font("Serif", Font.BOLD, 24));
                    l2.setForeground(Color.WHITE);
                    la.add(l2);

                    l3 = new JLabel(c);
                    l3.setBounds(120, 300, 600, 30);
                    l3.setFont(new Font("Serif", Font.BOLD, 24));
                    l3.setForeground(Color.WHITE);
                    la.add(l3);

                } else {
                    JOptionPane.showMessageDialog(null, "ID Not Found");
                    txt1.setText("");
                    lab1.setVisible(false);
                    lab2.setVisible(false);
                    lab3.setVisible(false);
                    l1.setVisible(false);
                    l2.setVisible(false);
                    l3.setVisible(false);
                    btn2.setVisible(false);
                    btn3.setVisible(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RemoveStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == bt) {
            txt1.setText("");
            lab1.setVisible(false);
            lab2.setVisible(false);
            lab3.setVisible(false);
            
            btn2.setVisible(false);
            btn3.setVisible(false);

            l1.setVisible(false);
            l2.setVisible(false);
            l3.setVisible(false);
            
        }

        if (e.getSource() == btn3) {
            lab1.setVisible(false);
            lab2.setVisible(false);
            lab3.setVisible(false);
            
            btn2.setVisible(false);
            btn3.setVisible(false);

            l1.setVisible(false);
            l2.setVisible(false);
            l3.setVisible(false);
            

        }

        if (e.getSource() == btn2) {
            Connection con = DataBase.dbconnect();
            String empid = txt1.getText();
            PreparedStatement pst;
            try {
                int opt = JOptionPane.showConfirmDialog(null, "Do You Want To Delete..!!", "Delete Employee", JOptionPane.YES_NO_OPTION);

                if (opt == 0) {
                    pst = con.prepareStatement("delete from employeedetails where studentid=?");
                    pst.setString(1, empid);
                    pst.executeUpdate();

                    lab1.setVisible(false);
                    lab2.setVisible(false);
                    lab3.setVisible(false);
                    
                    btn2.setVisible(false);
                    btn3.setVisible(false);

                    l1.setVisible(false);
                    l2.setVisible(false);
                    l3.setVisible(false);
                    

                    txt1.setText("");
                    JOptionPane.showMessageDialog(null, "Delete Successfully..!!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(RemoveStudent.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public static void main(String[] args) {
        new RemoveStudent();
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
