package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Fast_cash extends JFrame implements ActionListener {

    JPasswordField pinfield1;
    JButton deposit,withdrawl,fast_cash,statement,change_pin,enquiry,exit1;
    String pin;

    Fast_cash(String pin){

        getContentPane().setBackground(new Color(100, 169, 182, 255));
        setLayout(null);
        this.pin = pin;

        JLabel mybank = new JLabel("MY BANK");
        mybank.setFont(new Font("Times New Roman", Font.BOLD, 21));
        mybank.setBounds(720,20,120,35);
        add(mybank);

        JLabel label = new JLabel("Select withdrawl amount");
        label.setBounds(570,50,700,35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Times New Roman",Font.BOLD,28));
        add(label);

        JLabel pin1 = new JLabel("PLEASE ENTER THE PIN :-");
        pin1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pin1.setBounds(460,500,500,35);
        add(pin1);

        pinfield1 = new JPasswordField();
        pinfield1.setBounds(750,500,200,25);
        pinfield1.setFont(new Font("Times New Roman", Font.PLAIN,20));
        add(pinfield1);



        deposit = new JButton("Rs. 500");
        deposit.setBounds(450,220,200,35);
        deposit.setFont(new Font("Times New Roman", Font.BOLD,25));
        deposit.addActionListener(this);
        add(deposit);

        withdrawl = new JButton("Rs. 1000");
        withdrawl.setBounds(850,220,200,35);
        withdrawl.setFont(new Font("Times New Roman", Font.BOLD,25));
        withdrawl.addActionListener(this);
        add(withdrawl);


        fast_cash = new JButton("Rs. 1500");
        fast_cash.setBounds(450,300,200,35);
        fast_cash.setFont(new Font("Times New Roman", Font.BOLD,25));
        fast_cash.addActionListener(this);
        add(fast_cash);

        statement = new JButton("Rs. 2000");
        statement.setBounds(850,300,200,35);
        statement.setFont(new Font("Times New Roman", Font.BOLD,25));
        statement.addActionListener(this);
        add(statement);

        change_pin = new JButton("Rs. 5000");
        change_pin.setBounds(450,380,200,35);
        change_pin.setFont(new Font("Times New Roman", Font.BOLD,25));
        change_pin.addActionListener(this);
        add(change_pin);

        enquiry = new JButton("Rs. 10000");
        enquiry.setBounds(850,380,200,35);
        enquiry.setFont(new Font("Times New Roman", Font.BOLD,25));
        enquiry.addActionListener(this);
        add(enquiry);

        exit1 = new JButton("Exit");
        exit1.setBounds(650,600,200,35);
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
        if (e.getSource() == exit1) {
            setVisible(false);
            new Interface(pin);

        } else {
                String enteredPin = String.valueOf(pinfield1.getPassword());


                if (enteredPin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the PIN to proceed.");
                    return;
                }


                if (!enteredPin.equals(pin)) {
                    JOptionPane.showMessageDialog(null, "Incorrect PIN. Please try again.");
                    return;
                }


                String amount = ((JButton) e.getSource()).getText().substring(4);
                data z = new data();
                Date D = new Date();
                try {
                    ResultSet resultSet = z.statement.executeQuery("Select * from bank where pin = '" + pin + "' ");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));

                        }
                    }
                    String num = "17";

                    if (e.getSource() != exit1 && balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    z.statement.executeUpdate("insert into bank values('" + pin + "','" + z + "','Withdrawl','" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + "Debited Successfully");

                } catch (Exception r) {
                    r.printStackTrace();
                }

                setVisible(false);
                new Interface(pin);
            }

        }


    public static void main(String[] args) {
        new Fast_cash("");
    }
}
