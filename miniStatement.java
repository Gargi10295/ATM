package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;

import javax.swing.*;
public class miniStatement extends JFrame{
    String pinno;
    JLabel text,bank,card,mini;
    miniStatement(String pinno){
      this.pinno=pinno;
        setSize(400,600);
        setLocation(20, 20);
        setVisible(true);
        setLayout(null);
        setTitle("MINI STATEMENT");
        getContentPane().setBackground(Color.WHITE);

        text = new JLabel();
        text.setBounds(50,520,200,30);
        add(text);

        bank = new JLabel("Indian Bank");
        bank.setBounds(140,30,200,30);
        bank.setFont(new Font("Osward",Font.BOLD,18));
        add(bank);
 
        card = new JLabel();
        card.setBounds(20,100,300,30);
        card.setFont(new Font("Osward",Font.BOLD,15));
        add(card);
        mini = new JLabel();
        mini.setBounds(50,140,400,370);
        add(mini);
         Conn c = new Conn();
         try{
           String query = "select * from login where pinno ='"+pinno+"'";
           ResultSet rs =  c.s.executeQuery(query);
           while(rs.next()){
              card.setText("Card Number: " + rs.getString("cardno").substring(0,4)+"XXXXXXXX"+rs.getString("cardno").substring(12));
           }
            
         }catch(Exception e){
            System.out.println(e);
         }
         try{
            String query1 = "select * from bank where pinno ='"+pinno+"'";
            ResultSet rs =  c.s.executeQuery(query1);
            while(rs.next()){
               mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
            }
             
          }catch(Exception e){
             System.out.println(e);
          }
          int balance =0;
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

            text.setText("Your Current Balance : "+ balance);

        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new miniStatement("");
    }
}