package bank.management.system;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class signuppage3 extends JFrame implements ActionListener{
      JLabel details,acctype,cardno,cardno1,pinno,pinno1,service,cardno2,pinno2;
      JRadioButton saving,current,fixed,recurring;
      JCheckBox c1,c2,c3,c4,c5,c6,c7;
      JButton submit,cancel;
      String formno;
    signuppage3(String formno){
      this.formno=formno;
        setSize(600,700);
        setVisible(true);
        setLocation(500,100);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setTitle("SIGN UP PAGE : 3");

        details = new JLabel("Page 3:Account Details");
        details.setBounds(200,25,200,30);
        details.setFont(new Font("Oswad",Font.BOLD,15));
        add(details);

        acctype = new JLabel("Account Type");
        acctype.setBounds(50,60,200,30);
        acctype.setFont(new Font("Oswad",Font.BOLD,18));
        add(acctype);

        saving = new JRadioButton("Saving Account");
        saving.setBounds(50, 90, 150, 30);
        saving.setFont(new Font("Raleway",Font.BOLD,15));
        saving.setBackground(Color.WHITE);
        add(saving);

        current = new JRadioButton("Current Account");
        current.setBounds(50, 140, 150, 30);
        current.setFont(new Font("Raleway",Font.BOLD,15));
        current.setBackground(Color.WHITE);
        add(current);

        fixed = new JRadioButton("Fixed Deposite Account");
        fixed.setBounds(270, 90, 230, 30);
        fixed.setFont(new Font("Raleway",Font.BOLD,15));
        fixed.setBackground(Color.WHITE);
        add(fixed);

        recurring = new JRadioButton("Recurring Deposite Account");
        recurring.setBounds(270, 140, 250, 30);
        recurring.setFont(new Font("Raleway",Font.BOLD,15));
        recurring.setBackground(Color.WHITE);
        add(recurring);

        ButtonGroup g1 = new ButtonGroup();
        g1.add(saving); g1.add(fixed); g1.add(current); g1.add(recurring);

        cardno = new JLabel("Card Number");
        cardno.setBounds(50,190,150,30);
        cardno.setFont(new Font("Oswad",Font.BOLD,18));
        add(cardno);
        cardno1 = new JLabel("Your 16 Digit Card Number");
        cardno1.setBounds(50,220,200,30);
        cardno1.setFont(new Font("Oswad",Font.BOLD,10));
        add(cardno1);
        cardno2 = new JLabel("XXXX-XXXX-XXXX-4571");
        cardno2.setBounds(230,190,300,30);
        cardno2.setFont(new Font("Oswad",Font.BOLD,18));
        add(cardno2);

        pinno = new JLabel("PIN:");
        pinno.setBounds(50,270,150,30);
        pinno.setFont(new Font("Oswad",Font.BOLD,18));
        add(pinno);
        pinno1 = new JLabel("Your 4 Digit Password");
        pinno1.setBounds(50,300,200,30);
        pinno1.setFont(new Font("Oswad",Font.BOLD,10));
        add(pinno1);
        pinno2 = new JLabel("XXXX");
        pinno2.setBounds(230,270,300,30);
        pinno2.setFont(new Font("Oswad",Font.BOLD,18));
        add(pinno2);

        service = new JLabel("Service Requried");
        service.setBounds(50,350,200,30);
        service.setFont(new Font("Oswad",Font.BOLD,18));
        add(service);

        c1=new JCheckBox("ATM CARD");
        c1.setBounds(50,390,150,30);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,15));
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBounds(240,390,150,30);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,15));          
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBounds(50,440,150,30);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,15));
        add(c3);

        c4=new JCheckBox("EMAIL and SMS alerts");
        c4.setBounds(240,440,150,30);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,15));
        add(c4);

        c5=new JCheckBox("Cheque Box");
        c5.setBounds(50,490,150,30);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,15));
        add(c5);

        c6=new JCheckBox("E-Statement");
        c6.setBounds(240,490,150,30);
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,15));
        add(c6);

        c7=new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBounds(50,540,500,30);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,10));
        add(c7);


        submit = new JButton("Submit");
        submit.setBounds(100,600,110,30);
        submit.setFont(new Font("Oswad",Font.BOLD,18));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(300,600,110,30);
        cancel.setFont(new Font("Oswad",Font.BOLD,18));
        cancel.addActionListener(this);
        add(cancel);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
         String acc = null;
         if(saving.isSelected()){
            acc="Saving Account";
         }else if(fixed.isSelected()){
            acc="Fixed Deposit Account";
         }else if(current.isSelected()){
            acc="Current Account";
         }else if(recurring.isSelected()){
            acc="Recurring Deposit Account";
         }
         
         Random random = new Random();
         String card = "" + Math.abs((random.nextLong() % 90000000L) + 5643278900000000L);
         String pin = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if(c1.isSelected()){
               facility= facility+"ATM CARD";
            }else if(c2.isSelected()){
                facility=facility+"Internet Banking";
            }else if(c3.isSelected()){
                facility=facility+"Mobile Banking";
            }else if(c4.isSelected()){
                facility=facility+"EMAIL and SMS alerts";
            }else if(c5.isSelected()){
                facility=facility+"Cheque Box";
            }else if(c6.isSelected()){
                facility=facility+"E-Statement";
            }

            try{
                if(acctype.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }else{
                    Conn c= new Conn();
                    String query = "insert into signuppage3 values('"+formno+"','"+acc+"','"+card+"','"+pin+"','"+facility+"')";
                    c.s.executeUpdate(query);
                    String quary1 = "insert into login values('"+formno+"','"+card+"','"+pin+"')";
                    c.s.executeUpdate(quary1);
                    JOptionPane.showMessageDialog(null,"CardNo : "+card+"\n PinNo : "+pin);
                    setVisible(false);
                    new Deposite(pin).setVisible(true);
    
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()== cancel){
            setVisible(false);
            new loginPage().setVisible(true);

        }
                
       
    }
    public static void main(String[] args) {
        new signuppage3("");
    }
}
