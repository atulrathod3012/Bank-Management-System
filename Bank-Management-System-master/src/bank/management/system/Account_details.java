package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Account_details extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4,r5,r6;

    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel ;

    String form_no;
    Account_details(String form_no)
    {
        super("BANK MANAGEMENT SYSTEM");

        getContentPane().setBackground(new Color(63, 143, 136));
        setLayout(null);
        setSize(1200,810);
        setLocation(170,5);
        this.form_no = form_no;

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Icon/rupee.png"));
        Image image2 = image1.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel im = new JLabel(image3);
        im.setBounds(568,20,60,60);
        add(im);

        JLabel l1 = new JLabel("Page 1");
        l1.setBounds(0,1,100,40);
        l1.setFont(new Font("Times New Roman",Font.BOLD,19));
        add(l1);

        JLabel l2 = new JLabel("Account Details:-");
        l2.setBounds(30,80,150,30);
        l2.setFont(new Font("Times New Roman",Font.BOLD,19));
        add(l2);

        JLabel account_type = new JLabel("Account type:-");
        account_type.setBounds(30,110,130,25);
        account_type.setFont(new Font("Times New Roman",Font.BOLD,17));
        add(account_type);

        r1 = new JRadioButton("Saving Account");
        r1.setBounds(140,110,130,25);
        r1.setFont(new Font("Times New Roman",Font.PLAIN,16));
        r1.setBackground(new Color(224, 255, 23));
        add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setBounds(280,110,130,25);
        r2.setFont(new Font("Times New Roman",Font.PLAIN,16));
        r2.setBackground(new Color(224, 255, 23));
        add(r2);

        r3 = new JRadioButton("Salary Account");
        r3.setBounds(420,110,130,25);
        r3.setFont(new Font("Times New Roman",Font.PLAIN,16));
        r3.setBackground(new Color(224, 255, 23));
        add(r3);

        r4 = new JRadioButton("Fixed Deposit");
        r4.setBounds(560,110,130,25);
        r4.setFont(new Font("Times New Roman",Font.PLAIN,16));
        r4.setBackground(new Color(224, 255, 23));
        add(r4);

        r5 = new JRadioButton("Recurring Deposit");
        r5.setBounds(700,110,150,25);
        r5.setFont(new Font("Times New Roman",Font.PLAIN,16));
        r5.setBackground(new Color(224, 255, 23));
        add(r5);

        r6 = new JRadioButton("NRI Account");
        r6.setBounds(860,110,130,25);
        r6.setFont(new Font("Times New Roman",Font.PLAIN,16));
        r6.setBackground(new Color(224, 255, 23));
        add(r6);

        ButtonGroup ac =new ButtonGroup();
        ac.add(r1);
        ac.add(r2);
        ac.add(r3);
        ac.add(r4);
        ac.add(r5);
        ac.add(r6);

        JLabel services  = new JLabel("Required Services:-");
        services.setBounds(30,140,150,30);
        services.setFont(new Font("Times New Roman",Font.BOLD,17));
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setBounds(180,140,150,30);
        c1.setFont(new Font("Times New Roman", Font.BOLD,16));
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(360,140,150,30);
        c2.setFont(new Font("Times New Roman", Font.BOLD,16));
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(180,180,150,30);
        c3.setFont(new Font("Times New Roman", Font.BOLD,16));
        add(c3);

        c4 = new JCheckBox("Check Book");
        c4.setBounds(360,180,150,30);
        c4.setFont(new Font("Times New Roman", Font.BOLD,16));
        add(c4);

        c5 = new JCheckBox("E-Statement");
        c5.setBounds(180,220,150,30);
        c5.setFont(new Font("Times New Roman", Font.BOLD,16));
        add(c5);

        c6 = new JCheckBox("Credit Card");
        c6.setBounds(360,220,150,30);
        c6.setFont(new Font("Times New Roman", Font.BOLD,16));
        add(c6);

        JCheckBox c7 = new JCheckBox("I here by decleares that the above entered details correct to the best of my knlowledge.",true);
 //       c7.setBackground(new Color(215,252,252));
        c7.setFont(new Font("Times New Roman",Font.BOLD,19));
        c7.setBounds(30,620,800,20);
        add(c7);

        JLabel l4 = new JLabel("Card Number:-");
        l4.setFont(new Font("Times New Roman",Font.BOLD,17));
        l4.setBounds(30,300,200,30);
        add(l4);

        JLabel l5 = new JLabel("(Your 16-digit Card Number)");
        l5.setFont(new Font("Times New Roman",Font.BOLD,12));
        l5.setBounds(30,330,200,20);
        add(l5);

        JLabel l6 = new JLabel("XXXX-XXXX-XXXX-4841");
        l6.setFont(new Font("Times New Roman",Font.BOLD,17));
        l6.setBounds(330,300,250,30);
        add(l6);

        JLabel l7 = new JLabel("(It would appear on atm card/cheque Book and Statements)");
        l7.setFont(new Font("Times New Roman",Font.BOLD,12));
        l7.setBounds(330,330,500,20);
        add(l7);

        JLabel l8 = new JLabel("PIN:-");
        l8.setFont(new Font("Times New Roman",Font.BOLD,17));
        l8.setBounds(30,370,200,30);
        add(l8);

        JLabel l9 = new JLabel("XXXX");
        l9.setFont(new Font("Times New Roman",Font.BOLD,17));
        l9.setBounds(330,370,200,30);
        add(l9);

        JLabel l10 = new JLabel("(4-digit Password)");
        l10.setFont(new Font("Times New Roman",Font.BOLD,17 ));
        l10.setBounds(30,400,200,20);
        add(l10);

        JLabel forms = new JLabel("Form no:-");
        forms.setBounds(900,50,100,40);
        forms.setFont(new Font("Times New Roman",Font.BOLD,19));
        add(forms);

        JLabel forforms = new JLabel(form_no);
        forforms.setBounds(995,50,100,40);
        forforms.setFont(new Font("Times New Roman",Font.BOLD,19));
        add(forforms);

        submit = new JButton("Submit");
        submit.setBounds(300,700,150,30);
        submit.setFont(new Font("Times New Roman",Font.BOLD,18));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(600,700,150,30);
        cancel.setFont(new Font("Times New Roman",Font.BOLD,18));
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
    public void actionPerformed(ActionEvent a){
         String acc = null;
         if(r1.isSelected()){
             acc = "Saving Account";
         }
         else if (r2.isSelected())
         {
             acc = "Current Account";
         }
         else if (r3.isSelected())
         {
             acc = "Salary Account";
         }
         else if (r4.isSelected()) {
             acc = "Fixed Deposit";
         }
         else if (r5.isSelected()) {
             acc = "Recurring Deposit";
         }
         else if (r6.isSelected()) {
             acc = "NRI Account";
         }

        Random randomno = new Random();
        long first7 = (randomno.nextLong() % 90000000L) + 1409963000000000L;
        String cardno = "" + Math.abs(first7);

        long first3 = (randomno.nextLong() % 9000L)+ 1000L;
        String pin = "" + Math.abs(first3);

        String services = "";
        if(c1.isSelected()){
            services = services+"ATM CARD ";
        } else if (c2.isSelected()) {
            services = services+"Internet Banking";
        } else if (c3.isSelected()) {
            services = services+"Mobile Banking";
        } else if (c4.isSelected()) {
            services = services+"Check book";
        } else if (c5.isSelected()) {
            services=services+"E-Statement";
        } else if (c6.isSelected()) {
            services=services+"Credit card";
        }

        try{
            if(a.getSource()==submit)
            {
                if(acc.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Fill all the remaining fields");
                }
                else {
                    data d2 = new data();
                    String a2 = "insert into accountdetail values('"+form_no+"', '"+acc+"','"+services+"','"+cardno+"','"+pin+"')";
                    String a3 = "insert into login values('"+form_no+"','"+cardno+"','"+pin+"')";
                    d2.statement.executeUpdate(a2);
                    d2.statement.executeUpdate(a3);
                    JOptionPane.showMessageDialog(null,"Account Number  : "+cardno+"\n Pin/Password : "+pin );
                    new Money_Deposit(pin);
                    setVisible(false);

                }
            } else if (a.getSource()==cancel) {
                System.exit(0);
                new Money_Deposit(pin);
                
            }

        }catch(Exception q){
            q.printStackTrace();


        }


    }


    public static void main(String[] args) {
        new Account_details("");
    }
}
