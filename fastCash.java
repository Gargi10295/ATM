package bank.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
public class fastCash extends JFrame implements ActionListener{
    JLabel Trans;
    JButton a100,a500,a1000,a2000,a5000,a10000,back;
    String pinno;
    fastCash(String pinno){
        this.pinno = pinno;
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

        Trans =new JLabel("Select your Withdrawl Amount");
        Trans.setBounds(260,340,300,30);
        Trans.setFont(new Font("System",Font.BOLD,15));
        Trans.setForeground(Color.WHITE);
        Im1.add(Trans);

        a100 =new JButton("Rs 100");
        a100.setBounds(240,390,100,25);
        a100.addActionListener(this);
        Im1.add(a100);

        a500 =new JButton("Rs 500");
        a500.setBounds(240,420,100,25);
        a500.addActionListener(this);
        Im1.add(a500);

        a1000 =new JButton("Rs 1000");
        a1000.setBounds(240,450,100,25);
        a1000.addActionListener(this);
        Im1.add(a1000);

        a2000 =new JButton("Rs 2000");
        a2000.setBounds(375,390,125,25);
        a2000.addActionListener(this);
        Im1.add(a2000);

        a5000 =new JButton("Rs 5000");
        a5000.setBounds(375,420,125,25);
        a5000.addActionListener(this);
        Im1.add(a5000);

        a10000 =new JButton("Rs 10000");
        a10000.setBounds(375,450,125,25);
        a10000.setFont(new Font("System",Font.BOLD,11));
        a10000.addActionListener(this);
        Im1.add(a10000);

        back =new JButton("Back");
        back.setBounds(310,480,100,25);
        back.addActionListener(this);
        Im1.add(back);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transection(pinno).setVisible(true);
        }else{
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                String query = "select * from bank where pinno ='"+pinno+"'";
                ResultSet rs = c.s.executeQuery(query);
              int balance =0;
              while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                      balance+=Integer.parseInt(rs.getString("amount"));
                }else{
                      balance-=Integer.parseInt(rs.getString("amount"));
                }  
            }  
            if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null,"Insufficient Balance");
                return;
            }

            Date date = new Date();
            String query1 = "insert into bank values('"+pinno+"','"+date+"','Withdraw','"+amount+"')";
            c.s.executeUpdate(query1);
            JOptionPane.showMessageDialog(null,"Rs. " + amount +"has been Withdrawled");
            setVisible(false);
            new Transection(pinno).setVisible(true);
        }
         catch(Exception e){
             System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new fastCash("");
    }
}
