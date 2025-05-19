package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

public class Sign_up extends JFrame implements ActionListener
{
    Random random_no = new Random();
    long five =(random_no.nextLong() % 90000L) +10000L;
    String ran =  " "+Math.abs(five);

    JTextField namefield, fatherfield , motherfield, emailfield, addressfield,statefield, cityfield , pincodefield;
    JDateChooser dob;
    JRadioButton male,female,married,unmarried;
    JButton next,Previous;

    Sign_up()
    {
        super("BANK MANAGEMENT SYSTEM");

        getContentPane().setBackground(new Color(255,255,200));
        setLayout(null);
        setSize(1200,810);
        setLocation(170,5);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Icon/rupee.png"));
        Image image2 = image1.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel im = new JLabel(image3);
        im.setBounds(568,20,60,60);
        add(im);

        JLabel label1 = new JLabel("User Application no :" +ran);
        label1.setBounds(438,90,310,50);
        label1.setFont(new Font("Times New Roman",Font.BOLD,25));
        add(label1);

//        JLabel rand = new JLabel(ran);
//        rand.setBounds(675,90,400,50);
//        rand.setFont(new Font("Times New Roman",Font.BOLD,24));
//        add(rand);

        JLabel page = new JLabel("Page 1");
        page.setBounds(0,1,100,40);
        page.setFont(new Font("Times New Roman",Font.BOLD,19));
        add(page);

        JLabel l2 = new JLabel("Personal Data:-");
        l2.setBounds(30,120,150,40);
        l2.setFont(new Font("Times New Roman",Font.BOLD,19));
        add(l2);

        JLabel name = new JLabel("Name :");
        name.setBounds(30,170,80,40);
        name.setFont(new Font("Times New Roman",Font.BOLD,17));
        add(name);

        namefield = new JTextField();
        namefield.setBounds(210,190,262,25);
        namefield.setFont(new Font("Times New Roman",Font.PLAIN,16));
        add(namefield);

        JLabel pd = new JLabel("Parents Detail :-");
        pd.setBounds(30,210,150,40);
        pd.setFont(new Font("Times New Roman",Font.BOLD,19));
        add(pd);

        JLabel father = new JLabel("Father Name :");
        father.setBounds(30,240,130,40);
        father.setFont(new Font("Times New Roman",Font.BOLD,17));
        add(father);

        JLabel mother = new JLabel("Mother Name :");
        mother.setBounds(30,275,130,40);
        mother.setFont(new Font("Times New Roman",Font.BOLD,17));
        add(mother);

        fatherfield = new JTextField();
        fatherfield.setBounds(210,250,262,25);
        fatherfield.setFont(new Font("Times New Roman",Font.PLAIN,16));
        add(fatherfield);

        motherfield = new JTextField();
        motherfield.setBounds(210,290,262,25);
        motherfield.setFont(new Font("Times New Roman",Font.PLAIN,16));
        add(motherfield);

        JLabel DOB = new JLabel("D.O.B :");
        DOB.setBounds(30,320,80,40);
        DOB.setFont(new Font("Times New Roman",Font.BOLD,17));
        add(DOB);

        dob = new JDateChooser();
        dob.setBounds(210,330,270,25);
        add(dob);

        JLabel gender = new JLabel("Gender :");
        gender.setBounds(30,360,80,40);
        gender.setFont(new Font("Times New Roman",Font.BOLD,17));
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(210,360,60,25);
        male.setFont(new Font("Times New Roman",Font.BOLD,16));
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(300,360,80,25);
        female.setFont(new Font("Times New Roman",Font.BOLD,16));
        add(female);

        ButtonGroup Button_grp = new ButtonGroup();
        Button_grp.add(male);
        Button_grp.add(female);

        JLabel email = new JLabel("E-mail :");
        email.setBounds(30,395,80,40);
        email.setFont(new Font("Times New Roman",Font.BOLD,17));
        add(email);

        emailfield = new JTextField();
        emailfield.setBounds(210,400,262,25);
        emailfield.setFont(new Font("Times New Roman",Font.BOLD,16));
        add(emailfield);

        JLabel marriage = new JLabel("Martial Status :");
        marriage.setBounds(30,435,120,40);
        marriage.setFont(new Font("Times New Roman",Font.BOLD,17));
        add(marriage);

        married = new JRadioButton("Married");
        married.setBounds(210,435,80,25);
        married.setFont(new Font("Times New Roman",Font.BOLD,16));
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(300,435,100,25);
        unmarried.setFont(new Font("Times New Roman",Font.BOLD,16));
        add(unmarried);

        ButtonGroup bg = new ButtonGroup();
        bg.add(married);
        bg.add(unmarried);

        JLabel add = new JLabel("Address :");
        add.setBounds(30,470,70,40);
        add.setFont(new Font("Times New Roman",Font.BOLD,17));
        add(add);

        addressfield = new JTextField();
        addressfield.setBounds(210,470,450,25);
        addressfield.setFont(new Font("Times New Roman",Font.PLAIN,16));
        add(addressfield);

        JLabel state = new JLabel("State :");
        state.setBounds(30,510,70,40);
        state.setFont(new Font("Times New Roman",Font.BOLD,17));
        add(state);


        statefield = new JTextField();
        statefield.setBounds(210,515,262,25);
        statefield.setFont(new Font("Times New Roman",Font.PLAIN,16));
        add(statefield);

        JLabel city = new JLabel("City :");
        city.setBounds(30,545,70,40);
        city.setFont(new Font("Times New Roman",Font.BOLD,17));
        add(city);

        cityfield = new JTextField();
        cityfield.setBounds(210,550,262,25);
        cityfield.setFont(new Font("Times New Roman",Font.PLAIN,16));
        add(cityfield);

        JLabel pincode = new JLabel("Pincode :");
        pincode.setBounds(30, 575, 75, 40);
        pincode.setFont(new Font("Times New Roman", Font.BOLD, 17));
        add(pincode);

        pincodefield = new JTextField();
        pincodefield.setBounds(210, 580, 262, 25);
        pincodefield.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(pincodefield);

        next = new JButton("Next Page");
        next.setBounds(650,700,120,25);
        next.setFont(new Font("Times New Roman",Font.PLAIN,17));
        next.addActionListener(this);
        add(next);

        Previous = new JButton("Previous Page");
        Previous.setBounds(300,700,130,25);
        Previous.setFont(new Font("Times New Roman",Font.PLAIN,17));
        add(Previous);



        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        String form_no = ran;
        String name = namefield.getText();
        String fname = fatherfield.getText();
        String mname  = motherfield.getText();
        String dobs = ((JTextField) dob.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected())
        {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email = emailfield.getText();
        String married_status = null;
        if(married.isSelected())
        {
            married_status = "Married";

        } else if (unmarried.isSelected()) {
            married_status = "Unmarried";

        }
        String address = addressfield.getText();
        String city  = cityfield.getText();
        String pincode = pincodefield.getText();
        String state = statefield.getText();
       try{
        if(namefield.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Fill all the fields");

        }else{
            data data1 = new data();
            String da = "insert into signup values('"+form_no+"','"+name+"','"+fname+"','"+mname+"','"+dobs+"','"+gender+"','"+email+"','"+married_status+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                data1.statement.executeUpdate(da);
                new Sign_up2(form_no);
                setVisible(false);
            }
        }
        catch (Exception ex)
    {
        ex.printStackTrace();
    }
    }

    public static void main(String[] args) {
        new Sign_up();

    }

}
