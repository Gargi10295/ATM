package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class loginPage extends JFrame implements ActionListener{
      
     JTextField t1;
     JPasswordField t2;
     JButton login,cancel,signup;


    loginPage(){
        setSize(800, 480);
        setVisible(true);
        setTitle("ATM");
        setLocation(350,200);
        setLayout(null);
        ImageIcon I1 =new ImageIcon(ClassLoader.getSystemResource("icons/images.png"));
        Image I2= I1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon I3=new ImageIcon(I2);
        JLabel label = new JLabel(I3);
        label.setBounds(10, 10, 100, 100);
        add(label);

        getContentPane().setBackground(Color.WHITE);
        JLabel label1 =new JLabel("WELCOME TO ATM!!!");
        label1.setBounds(220, 40,400, 40);
        label1.setFont(new Font("Osward",Font.BOLD,30));
        label.setForeground(Color.BLACK);
        add(label1);

        JLabel label2 =new JLabel("CARD NO..");
        label2.setBounds(150,150,150,30);
        label2.setFont(new Font("Raleway",Font.BOLD,19));
        add(label2);

        JLabel l3 = new JLabel("PIN NO..");
        l3.setBounds(150,250,150,30);
        l3.setFont(new Font("Raleway",Font.BOLD,19));
        add(l3);
        
         t1 = new JTextField();
        t1.setBounds(260,150,300,30);
        t1.setBackground(Color.BLACK);
        t1.setForeground(Color.WHITE);
        t1.setFont(new Font("Arial",Font.ITALIC,20));
        add(t1);
        

         t2=new JPasswordField();
        t2.setBounds(260,250,300,30);
        t2.setBackground(Color.BLACK);
        t2.setForeground(Color.WHITE);
        t2.setFont(new Font("Arial",Font.ITALIC,20));
        add(t2);

        login = new JButton("SIGN IN");
        login.setBounds(260,300,130,40);
        login.setBackground(Color.WHITE);
        login.setForeground(Color.black);
        login.addActionListener(this);
        add(login);

        cancel =new JButton("CANCEL");
        cancel.setBounds(430,300,130,40);
        cancel.setForeground(Color.black);
        cancel.setBackground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        signup =new JButton("SIGN UP");
        signup.setBounds(340,360,130,40);
        signup.setForeground(Color.black);
        signup.setBackground(Color.white);
        signup.addActionListener(this);
        add(signup);
        
       

    }
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == cancel){
                t1.setText("");
                t2.setText("");
            }else if(ae.getSource() == login){

                Conn c = new Conn();
                String cardno = t1.getText();
                String pinno = t2.getText();
                String query="select * from login where cardno = '"+cardno+"' and pinno ='"+pinno+"'";   
                try{
                    ResultSet y = c.s.executeQuery(query);
                    if(y.next()){
                        setVisible(false);
                        new Transection(pinno).setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null,"Incorrect Card No Or Pin No");
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }else if (ae.getSource()== signup){
                   setVisible(false);
                   new signupPage().setVisible(true);
            }
    }
    public static void main(String[] args) {
        new loginPage();
    }
}