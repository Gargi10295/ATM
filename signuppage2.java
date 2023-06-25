package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class signuppage2 extends JFrame implements ActionListener{

    JLabel details,religion,Category,income,eq,eq1,occu,pancard,aadharcard,senior,exist;
    JTextField pancard1,aadharcard1;
    JRadioButton senior1y,senior1n,exist1y,exist1n;
    JButton next;
    JComboBox religion1,category1,income1,edu1,occu1;
    String formno;
     signuppage2(String formno){
      this.formno=formno;
       setSize(600,700);
       setLocation(480,100);
       setVisible(true);
    setLayout(null);
      getContentPane().setBackground(Color.WHITE);
      setTitle("SIGN UP PAGE : 2");

       details = new JLabel("Page 2:Additional Details");
       details.setBounds(200,25,200,30);
       details.setFont(new Font("Oswad",Font.BOLD,15));
       add(details);

       religion = new JLabel("Religion:");
       religion.setBounds(50,70,150,30);
       religion.setFont(new Font("Oswad",Font.BOLD,18));
       add(religion);

       String r[] = {"Hindu","Muslim","Jain","Christian","Other"};
       religion1 = new JComboBox(r);
       religion1.setBounds(200,70,350,30);
       religion1.setBackground(Color.WHITE);
       add(religion1);

       Category = new JLabel("Category:");
       Category.setBounds(50,120,150,30);
       Category.setFont(new Font("Oswad",Font.BOLD,18));
       add(Category);

       String c[]= {"General","OBC","SC","ST","Other"};
       category1 = new JComboBox(c);
       category1.setBounds(200,120,350,30);
       category1.setBackground(Color.WHITE);
       add(category1);

       income = new JLabel("Income:");
       income.setBounds(50,170,150,30);
       income.setFont(new Font("Oswad",Font.BOLD,18));
       add(income);

       String i[]= {"Null","< 1,50,000","< 2,50,000","< 5,00,000","upto 10,00,000","Other"};
       income1 = new JComboBox(i);
       income1.setBounds(200,170,350,30);
       income1.setBackground(Color.WHITE);
       add(income1);

       eq = new JLabel("Educational");
       eq.setBounds(50,220,150,30);
       eq.setFont(new Font("Oswad",Font.BOLD,18));
       add(eq);
       eq1 = new JLabel("Qualification:");
       eq1.setBounds(50,240,150,30);
       eq1.setFont(new Font("Oswad",Font.BOLD,18));
       add(eq1);

       String e[]= {"10th","12th","Graduation","Post Graduation","Phd.","Other"};
       edu1 = new JComboBox(e);
       edu1.setBounds(200,220,350,30);
       edu1.setBackground(Color.WHITE);
       add(edu1);

       occu = new JLabel("Occupation:");
       occu.setBounds(50,290,150,30);
       occu.setFont(new Font("Oswad",Font.BOLD,18));
       add(occu);

       String o[]= {"BusinessMan","Student","Salaried","Self-Employeed","Retired","Other"};
       occu1 = new JComboBox(o);
       occu1.setBounds(200,290,350,30);
       occu1.setBackground(Color.WHITE);
       add(occu1);

       pancard = new JLabel("PAN Number:");
       pancard.setBounds(50,340,150,30);
       pancard.setFont(new Font("Oswad",Font.BOLD,18));
       add(pancard);

       pancard1 = new JTextField();
       pancard1.setBounds(200,340,350,30);
       add(pancard1);

       aadharcard = new JLabel("Aadhar Number:");
       aadharcard.setBounds(50,390,150,30);
       aadharcard.setFont(new Font("Oswad",Font.BOLD,18));
       add(aadharcard);

       aadharcard1 = new JTextField();
       aadharcard1.setBounds(200,390,350,30);
       add(aadharcard1);

       senior = new JLabel("Senior Citizen:");
       senior.setBounds(50,440,150,30);
       senior.setFont(new Font("Oswad",Font.BOLD,18));
       add(senior);

       senior1y = new JRadioButton("Yes");
       senior1y.setBounds(240, 440, 60, 18);
       senior1y.setBackground(Color.WHITE);
       add(senior1y);
       senior1n = new JRadioButton("No");
       senior1n.setBounds(380, 440, 60, 18);
       senior1n.setBackground(Color.WHITE);
       add(senior1n);

       ButtonGroup g1 = new ButtonGroup();
       g1.add(senior1y);
       g1.add(senior1n);

       exist = new JLabel("Existing Account:");
       exist.setBounds(50,490,200,30);
       exist.setFont(new Font("Oswad",Font.BOLD,18));
       add(exist);

       exist1y = new JRadioButton("Yes");
       exist1y.setBounds(240, 490, 60, 18);
       exist1y.setBackground(Color.WHITE);
       add(exist1y);
       exist1n = new JRadioButton("No");
       exist1n.setBounds(380, 490, 60, 18);
       exist1n.setBackground(Color.WHITE);
       add(exist1n);

       ButtonGroup g2 = new ButtonGroup();
       g2.add(exist1y);
       g2.add(exist1n);

       next=new JButton("Next");
       next.setBounds(400, 550, 100, 30);
       next.setFont(new Font("Osward",Font.BOLD,20));
       next.addActionListener(this);
       add(next);
       
     }

     public void actionPerformed(ActionEvent ae){
         String rel =  (String) religion1.getSelectedItem();
         String cat  = (String) category1.getSelectedItem();
         String inc = (String) income1.getSelectedItem();
         String eq = (String) edu1.getSelectedItem();
         String occ =  (String) occu1.getSelectedItem();
         String pan = pancard1.getText();
         String aadhar = aadharcard1.getText();
         String sen = null;

         if(senior1y.isSelected()){
          sen = "Yes";
         }else if(senior1n.isSelected()){
          sen = "No";
         }
         String exi = null;

         if(exist1y.isSelected()){
          exi = "Yes";
         }else if(exist1n.isSelected()){
          exi = "No";
         }
        
         try{
         String query = "insert into signuppage2 values('"+formno+"','"+rel+"','"+cat+"','"+inc+"','"+eq+"','"+occ+"','"+pan+"','"+aadhar+"','"+sen+"','"+exi+"')";
         Conn c = new Conn();
         c.s.executeUpdate(query);

         setVisible(false);
         new signuppage3(formno).setVisible(true);
         }catch(Exception e){
          System.out.println(e);
         }
     }
    public static void main(String[] args) {
        new signuppage2("");
    }
}
