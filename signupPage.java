package bank.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.*;
public class signupPage extends JFrame implements ActionListener {

    JTextField nameee,fnameee,emaill,address1,pin,city1,state1;
    JDateChooser date; JRadioButton male,female,married,single,divorcee;
    JButton next;
    Long random;
    signupPage(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(600,700);
        setVisible(true);
        setLocation(500, 100);
       setTitle("SIGN UP PAGE : 1");

        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L)+1000L);
        
        JLabel applicaton = new JLabel("Application Form No: " +random);
        applicaton.setBounds(100,20,600,40);
        applicaton.setFont(new Font("Arial",Font.BOLD,30));
        add(applicaton);

        JLabel pageno = new JLabel("Page No 1: Personal Details");
        pageno.setBounds(180,80,400,30);
        pageno.setFont(new Font("Arial",Font.BOLD,15));
        add(pageno);

        JLabel namee = new JLabel("Name: ");
        namee.setBounds(60,130,100,20);
        namee.setFont(new Font("Arial",Font.BOLD,15));
        add(namee);

        JLabel fnamee = new JLabel("Fathers' Name: ");
        fnamee.setBounds(60,175,150,25);
        fnamee.setFont(new Font("Arial",Font.BOLD,15));
        add(fnamee);

        JLabel DOB = new JLabel("Date Of Birth: ");
        DOB.setBounds(60,220,150,25);
        DOB.setFont(new Font("Arial",Font.BOLD,15));
        add(DOB);

        JLabel gender = new JLabel("Gender: ");
        gender.setBounds(60,265,150,25);
        gender.setFont(new Font("Arial",Font.BOLD,15));
        add(gender);

        JLabel email = new JLabel("Email Address: ");
        email.setBounds(60,310,150,25);
        email.setFont(new Font("Arial",Font.BOLD,15));
        add(email);

        JLabel marital = new JLabel("Marital Status: ");
        marital.setBounds(60,355,150,25);
        marital.setFont(new Font("Arial",Font.BOLD,15));
        add(marital);

        JLabel Address = new JLabel("Address: ");
        Address.setBounds(60,400,150,25);
        Address.setFont(new Font("Arial",Font.BOLD,15));
        add(Address);

        JLabel city = new JLabel("City: ");
        city.setBounds(60,445,150,25);
        city.setFont(new Font("Arial",Font.BOLD,15));
        add(city);

        JLabel state = new JLabel("State: ");
        state.setBounds(60,490,150,25);
        state.setFont(new Font("Arial",Font.BOLD,15));
        add(state);

        JLabel pincode = new JLabel("Pincode: ");
        pincode.setBounds(60,535,150,25);
        pincode.setFont(new Font("Arial",Font.BOLD,15));
        add(pincode);


        nameee = new JTextField();
        nameee.setBounds(180,130,350,30);
        add(nameee);

        fnameee = new JTextField();
        fnameee.setBounds(180,175,350,30);
        add(fnameee);

        emaill = new JTextField();
        emaill.setBounds(180,310,350,30);
        add(emaill);

        address1 = new JTextField();
        address1.setBounds(180,400,350,30);
        add(address1);

        pin = new JTextField();
        pin.setBounds(180,535,350,30);
        add(pin);

        city1 = new JTextField();
        city1.setBounds(180,445,350,30);
        add(city1);
        
        state1=new JTextField();
        state1.setBounds(180,490,350,30);
        add(state1);

        date = new JDateChooser();
        date.setBounds(180, 220, 350, 30);
        add(date);

        male =new JRadioButton("Male");
        male.setBounds(200,265,100,30);
        male.setBackground(Color.WHITE);
        add(male);

        female =new JRadioButton("Female");
        female.setBounds(350,265,100,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male); bg.add(female);


        married = new JRadioButton("Married");
        married.setBounds(180,355,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        single = new JRadioButton("Single");
        single.setBounds(320,355,100,30);
        single.setBackground(Color.WHITE);
        add(single);
        divorcee= new JRadioButton("Divorcee");
        divorcee.setBounds(450,355,100,30);
        divorcee.setBackground(Color.WHITE);
        add(divorcee);
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(married);
        bg1.add(single);
        bg1.add(divorcee);

        next= new JButton("Next");
        next.setBounds(440,580,100,40);
        next.setFont(new Font("Osward",Font.BOLD,20));
        next.addActionListener(this);
        add(next);



    }
    public void actionPerformed(ActionEvent ae){
        String formno = "" +(random);
        String name1 = nameee.getText();
        String fname = fnameee.getText();
        String email = emaill.getText();
        String pinc = pin.getText();
        String state = state1.getText();
        String city = city1.getText();
        String address = address1.getText();
        String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
           gender="male";
        }else if(female.isSelected()){
            gender="female";
        }
        String marital = null;
        if(married.isSelected()){
            marital = "married";
        }else if(single.isSelected()){
            marital="single";
        }else if(divorcee.isSelected()){
            marital="divorcee";
        }
         
        try{
            Conn c = new Conn();
            String query="insert into signuppage values('"+formno+"','"+name1+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pinc+"')";
            c.s.executeUpdate(query);
            setVisible(false);
           new signuppage2(formno).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new signupPage();
    }
    
}
