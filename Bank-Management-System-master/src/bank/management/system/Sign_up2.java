package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sign_up2 extends JFrame implements ActionListener {
    JTextField Adhaarfield,Panfield;
    JComboBox Religioncombo, Categorycombo,Incomecombo, Educationcombo ,Occupationcombo ;
    JRadioButton yes,no;

    JButton next;

    String form_no;
    Sign_up2(String form_no){
        super("BANK MANAGEMENT SYSTEM");


        getContentPane().setBackground(new Color(255,255,200));
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


        JLabel L1 = new JLabel("Page 2");
        L1.setBounds(0,1,100,40);
        L1.setFont(new Font("Times New Roman",Font.BOLD,19));
        add(L1);

        JLabel L2 = new JLabel("Additional Information:-");
        L2.setBounds(30,100,210,40);
        L2.setFont(new Font("Times New Roman",Font.BOLD,19));
        add(L2);


        JLabel form  = new JLabel("Form no:-");
        form.setBounds(550,100,100,40);
        form.setFont(new Font("Times New Roman",Font.BOLD,19));
        add(form);

        JLabel form1  = new JLabel(form_no);
        form1.setBounds(645,100,100,40);
        form1.setFont(new Font("Times New Roman",Font.BOLD,19));
        add(form1);


        JLabel L3 = new JLabel("Adhaar no:-");
        L3.setBounds(30,140,100,25);
        L3.setFont(new Font("Times New Roman",Font.BOLD,17));
        add(L3);

        Adhaarfield = new JTextField();
        Adhaarfield.setBounds(220,140,200,25);
        Adhaarfield.setFont(new Font("Times New Roman",Font.BOLD,16));
        add(Adhaarfield);

        JLabel L5 = new JLabel("Pan no:-");
        L5.setBounds(30,170,100,25);
        L5.setFont(new Font("Times New Roman",Font.BOLD,17));
        add(L5);

        Panfield = new JTextField();
        Panfield.setBounds(220,170,200,25);
        Panfield.setFont(new Font("Times New Roman",Font.BOLD,16));
        add(Panfield);

        JLabel L6 = new JLabel("Religion:-");
        L6.setBounds(30,200,100,25);
        L6.setFont(new Font("Times New Roman",Font.BOLD,17));
        add(L6);

        String religion[]= {"Hindu","Muslim","Sikh","Christian","Other"};
        Religioncombo = new JComboBox(religion);
        Religioncombo.setBounds(220,200,200,25);
        add(Religioncombo);

        JLabel L7 = new JLabel("Category:-");
        L7.setBounds(30,230,100,25);
        L7.setFont(new Font("Times New Roman",Font.BOLD,17));
        add(L7);

        String category[]= {"ST","SC","NT","VJNT","OBC","SBC","EBC","OPEN"};
        Categorycombo = new JComboBox(category);
        Categorycombo.setBounds(220,230,200,25);
        add(Categorycombo);

        JLabel L8 = new JLabel("Income:-");
        L8.setBounds(30,260,100,25);
        L8.setFont(new Font("Times New Roman",Font.BOLD,17));
        add(L8);

        String Income[]= {"<50000","<100000","<200000","<500000","<1000000",">1000000"};
        Incomecombo = new JComboBox(Income);
        Incomecombo.setBounds(220,260,200,25);
        add(Incomecombo);

        JLabel L9 = new JLabel("Education:-");
        L9.setBounds(30,290,100,25);
        L9.setFont(new Font("Times New Roman",Font.BOLD,17));
        add(L9);

        String Education[]= {"10th","12th","Under Graduate","Post Graduate","PhD","Other"};
        Educationcombo = new JComboBox(Education);
        Educationcombo.setBounds(220,290,200,25);
        add(Educationcombo);

        JLabel L10 = new JLabel("Occupation:-");
        L10.setBounds(30,320,100,25);
        L10.setFont(new Font("Times New Roman",Font.BOLD,17));
        add(L10);

        String occupation[]= {"salarized","Employed","Un-Employed","Business","Student","Civil Services","Retired","Other"};
        Occupationcombo = new JComboBox(occupation);
        Occupationcombo.setBounds(220,320,200,25);
        add(Occupationcombo);

        JLabel L11 = new JLabel("Existing Account:-");
        L11.setBounds(30,350,150,25);
        L11.setFont(new Font("Times New Roman",Font.BOLD,17));
        add(L11);

        yes = new JRadioButton("Yes");
        yes.setBounds(220,350,60,25);
        yes.setFont(new Font("Times New Roman",Font.BOLD,16));
        add(yes);

        no = new JRadioButton("No");
        no.setBounds(310,350,60,25);
        no.setFont(new Font("Times New Roman",Font.BOLD,16));
        add(no);

        next = new JButton("Next");
        next.setBounds(500,700,80,25);
        next.setFont(new Font("Times New Roman",Font.BOLD,20));
        next.addActionListener(this);
        add(next);


        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent e)
    {
        String adhaar = (String) Adhaarfield.getText();
        String pan = (String) Panfield.getText();

        String religion = (String) Religioncombo.getSelectedItem();
        String category = (String) Categorycombo.getSelectedItem();
        String income = (String) Incomecombo.getSelectedItem();
        String education = (String) Educationcombo.getSelectedItem();
        String occupation = (String) Occupationcombo.getSelectedItem();



        String eAccount = " ";
        if ((yes.isSelected())){
            eAccount = "Yes";
        } else if (no.isSelected()) {
            eAccount ="No";
        }

        try{
            if (Panfield.getText().equals("") || Adhaarfield.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            } else {
                data a1 =new data();
                String a =  "insert into Signup_two values('"+form_no+"', '"+religion+"', '"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+adhaar+"','"+eAccount+"')";
                a1.statement.executeUpdate(a);
                new Account_details(form_no);
                setVisible(false);
                
            }

        }
        catch (Exception w)
        {
            w.printStackTrace();

        }


    }
    public static void main(String[] args) {
        new Sign_up2(" ");

    }
}
