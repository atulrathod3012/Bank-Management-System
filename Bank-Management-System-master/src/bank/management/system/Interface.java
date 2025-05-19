package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame implements ActionListener
{
    JButton deposit,withdrawl,fast_cash,statement,change_pin,enquiry,exit1;
    String pin;
    Interface(String pin)
    {
        getContentPane().setBackground(new Color(100, 169, 182, 255));
        setLayout(null);
        this.pin = pin;

        JLabel mybank = new JLabel("MY BANK");
        mybank.setFont(new Font("Times New Roman", Font.BOLD, 21));
        mybank.setBounds(720,20,120,35);
        add(mybank);

        JLabel label = new JLabel("Please Select Your Transaction");
        label.setBounds(570,50,700,35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Times New Roman",Font.BOLD,28));
        add(label);

        deposit = new JButton("Deposit");
        deposit.setBounds(450,220,200,35);
        deposit.setFont(new Font("Times New Roman", Font.BOLD,25));
        deposit.addActionListener(this);
        add(deposit);

        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(850,220,200,35);
        withdrawl.setFont(new Font("Times New Roman", Font.BOLD,25));
        withdrawl.addActionListener(this);
        add(withdrawl);


        fast_cash = new JButton("Fast Cash");
        fast_cash.setBounds(450,300,200,35);
        fast_cash.setFont(new Font("Times New Roman", Font.BOLD,25));
        fast_cash.addActionListener(this);
        add(fast_cash);

        statement = new JButton("Mini Statement");
        statement.setBounds(850,300,200,35);
        statement.setFont(new Font("Times New Roman", Font.BOLD,25));
        statement.addActionListener(this);
        add(statement);

        change_pin = new JButton("Pin change");
        change_pin.setBounds(450,380,200,35);
        change_pin.setFont(new Font("Times New Roman", Font.BOLD,25));
        change_pin.addActionListener(this);
        add(change_pin);

        enquiry = new JButton("Enquiry");
        enquiry.setBounds(850,380,200,35);
        enquiry.setFont(new Font("Times New Roman", Font.BOLD,25));
        enquiry.addActionListener(this);
        add(enquiry);

        exit1 = new JButton("Exit");
        exit1.setBounds(650,460,200,35);
        exit1.setFont(new Font("Times New Roman", Font.BOLD,20));
        exit1.addActionListener(this);
        add(exit1);








        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==deposit) {
            new Money_Deposit(pin);
            setVisible(false);
        } else if (e.getSource()==exit1) {
            new thankyou();
            setVisible(false);

        }else if (e.getSource()==withdrawl) {
            new Withdraw(pin);
            setVisible(false);

        }
        else if (e.getSource()==enquiry) {
            new Balance_enquiry(pin);
            setVisible(false);

        }
        else if (e.getSource()==fast_cash) {
            new Fast_cash(pin);
            setVisible(false);
        }
        else if (e.getSource()==change_pin) {
            new changepin(pin);
            setVisible(false);
        }
        else if (e.getSource()==statement) {
            new ministatement(pin);
            setVisible(false);
        }


        }

    public static void main(String[] args) {
        new Interface("");
    }
}
