package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
public class pinchange extends JFrame implements ActionListener{

    JLabel pinch,npin,repin;
    JButton change,back;
    JTextField npin1,repin1;
    String pinno;
    pinchange(String pinno){
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

        pinch =new JLabel("Change your Pin");
        pinch.setBounds(320,340,300,30);
        pinch.setFont(new Font("System",Font.BOLD,13));
        pinch.setForeground(Color.WHITE);
        Im1.add(pinch);

        npin =new JLabel("New Pin: ");
        npin.setBounds(235,380,120,20);
        npin.setFont(new Font("System",Font.BOLD,13));
        npin.setForeground(Color.WHITE);
        Im1.add(npin);

        repin =new JLabel("Re-enter your Pin: ");
        repin.setBounds(235,410,120,20);
        repin.setFont(new Font("System",Font.BOLD,13));
        repin.setForeground(Color.WHITE);
        Im1.add(repin);

        npin1 = new JTextField();
        npin1.setBounds(360,380,140,20);
        Im1.add(npin1);

        repin1 = new JTextField();
        repin1.setBounds(360,410,140,20);
        Im1.add(repin1);

        change =new JButton("Change");
        change.setBounds(400,450,100,25);
        change.addActionListener(this);
        Im1.add(change);

        back =new JButton("Back");
        back.setBounds(400,480,100,25);
        back.addActionListener(this);
        Im1.add(back);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
        try{
           String pin = npin1.getText();
           String repin = repin1.getText();
           if(!pin.equals(repin)){
            JOptionPane.showMessageDialog(null,"New pin does not match re pin");
            return;
           }
           if(pin.equals("")){
            JOptionPane.showMessageDialog(null,"Please enter New pin");
            return;
           }
           if(repin.equals("")){
            JOptionPane.showMessageDialog(null,"Please Re-enter New pin");
            return;
           }
           Conn c= new Conn();
           String q1 = "update login set pinno ='"+repin+"' where pinno = '"+pinno+"'";
           String q2 = "update bank set pinno ='"+repin+"' where pinno = '"+pinno+"'";
           String q3 = "update signuppage3 set pinno ='"+repin+"' where pinno = '"+pinno+"'";
           c.s.executeUpdate(q1);
           c.s.executeUpdate(q2);
           c.s.executeUpdate(q3);
           JOptionPane.showMessageDialog(null,"Pin updated Sucessfully");
           setVisible(false);
          new Transection(repin).setVisible(true);

        }catch(Exception e){
            System.out.println(e);
        }
        
        }
    else if(ae.getSource()==back){
          setVisible(false);
          new Transection(pinno).setVisible(true);
    }
}
    public static void main(String[] args) {
        new pinchange("");
    }
}
