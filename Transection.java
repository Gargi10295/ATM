package bank.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Transection extends JFrame implements ActionListener{
    JLabel Trans;
    JButton depo,fastc,pincn,cawithdraw,ministate,balance,exit;
    String pinno;
    Transection(String pinno){
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

        Trans =new JLabel("Please selct your Transaction");
        Trans.setBounds(260,340,300,30);
        Trans.setFont(new Font("System",Font.BOLD,15));
        Trans.setForeground(Color.WHITE);
        Im1.add(Trans);

        depo =new JButton("Deposit");
        depo.setBounds(240,390,100,25);
        depo.addActionListener(this);
        Im1.add(depo);

        fastc =new JButton("Fast Cash");
        fastc.setBounds(240,420,100,25);
        fastc.addActionListener(this);
        Im1.add(fastc);

        pincn =new JButton("Pin Change");
        pincn.setBounds(240,450,100,25);
        pincn.addActionListener(this);
        Im1.add(pincn);

        cawithdraw =new JButton("Cash Withdrawl");
        cawithdraw.setBounds(375,390,125,25);
        cawithdraw.addActionListener(this);
        Im1.add(cawithdraw);

        ministate =new JButton("Mini Statement");
        ministate.setBounds(375,420,125,25);
        ministate.addActionListener(this);
        Im1.add(ministate);

        balance =new JButton("Balance Enquiry");
        balance.setBounds(375,450,125,25);
        balance.setFont(new Font("System",Font.BOLD,11));
        balance.addActionListener(this);
        Im1.add(balance);

        exit =new JButton("Exit");
        exit.setBounds(310,480,100,25);
        exit.addActionListener(this);
        Im1.add(exit);



    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource()==depo){
            setVisible(false);
          new Deposite(pinno).setVisible(true); 
        }else if(ae.getSource()==cawithdraw){
            setVisible(false);
            new Withdrawl(pinno).setVisible(true);
        }else if(ae.getSource()==fastc){
            setVisible(false);
            new fastCash(pinno).setVisible(true);
        }else if(ae.getSource()==pincn){
            setVisible(false);
            new pinchange(pinno).setVisible(true);
        }else if(ae.getSource()==balance){
            setVisible(false);
            new balanceEnquiry(pinno).setVisible(true);
        }else if(ae.getSource()==ministate){
            new miniStatement(pinno).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transection("");
    }
}
