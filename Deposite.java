package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
public class Deposite extends JFrame implements ActionListener{

    JLabel deposit;
    JButton depo,back;
    JTextField amount;
    String pinno;
    Deposite(String pinno){
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

        deposit =new JLabel("Please enter the deposite amount");
        deposit.setBounds(260,340,300,30);
        deposit.setFont(new Font("System",Font.BOLD,13));
        deposit.setForeground(Color.WHITE);
        Im1.add(deposit);

        
        depo =new JButton("Deposit");
        depo.setBounds(400,450,100,25);
        depo.addActionListener(this);
        Im1.add(depo);

        back =new JButton("Back");
        back.setBounds(400,480,100,25);
        back.addActionListener(this);
        Im1.add(back);

        amount = new JTextField();
        amount.setBounds(260, 380, 200, 30);
        Im1.add(amount);

        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
          setVisible(false);
          new Transection(pinno).setVisible(true);            
        }else if(ae.getSource()== depo){
               String number = amount.getText();
               Date date = new Date();
               try{
                 if(number.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposite");
                 }else{
                    String query = "insert into bank values('"+pinno+"','"+date+"','Deposit','"+number+"')";
                    Conn c = new Conn();
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs. "+number+" has been deposited");
                    setVisible(false);
                    new Transection(pinno).setVisible(true);
                 }
               }catch(Exception e){
                System.out.println(e);
               }
        }
    }
    public static void main(String[] args) {
        new Deposite("");
    }
}
