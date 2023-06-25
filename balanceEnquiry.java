
package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.sql.*;

import javax.swing.*;
public class balanceEnquiry extends JFrame implements ActionListener{

    JLabel chbal;
    JButton depo,back;
    JTextField amount;
    String pinno;
    balanceEnquiry(String pinno){
        this.pinno=pinno;
        setSize(900,900);
        setLocation(300, 0);
        setVisible(true);
        setLayout(null);

        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image I2=I1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel Im1 = new JLabel(I3);
        Im1.setBounds(0,0,900,900);
        add(Im1);
         int balance = 0;
        back =new JButton("Back");
        back.setBounds(400,480,100,25);
        back.addActionListener(this);
        Im1.add(back);

        Conn c = new Conn();
        try{
            String query = "select * from bank where pinno ='"+pinno+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }

        }catch(Exception e){
            System.out.println(e);
        }
         
        chbal =new JLabel("Your account balance is Rs. "+balance);
        chbal.setBounds(260,340,300,30);
        chbal.setFont(new Font("System",Font.BOLD,13));
        chbal.setForeground(Color.WHITE);
        Im1.add(chbal);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
          setVisible(false);
          new Transection(pinno).setVisible(true);            
        }
    }
    public static void main(String[] args) {
        new balanceEnquiry("");
    }
}
