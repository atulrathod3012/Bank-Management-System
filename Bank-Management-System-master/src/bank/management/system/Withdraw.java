package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    JTextField amount1 ;
    JPasswordField pinfield;
    JButton Withdraw1,back ;
    String pin;

    Withdraw(String pin)
    {
        getContentPane().setBackground(new Color(100, 169, 182, 255));
        setLayout(null);
        this.pin = pin;

        JLabel mybank = new JLabel("MY BANK");
        mybank.setFont(new Font("Times New Roman", Font.BOLD, 21));
        mybank.setBounds(720,20,120,35);
        add(mybank);

        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAWL :-");
        label1.setFont(new Font("Times New Roman", Font.BOLD, 19));
        label1.setBounds(30,200,500,35);
        add(label1);

        JLabel label2 = new JLabel("MAXIMUM AMOUNT TO BE WITHDRAWL MUST BE > Rs 5000");
        label2.setFont(new Font("Times New Roman", Font.BOLD, 19));
        label2.setBounds(500,100,600,35);
        add(label2);

        JLabel pin1 = new JLabel("PLEASE ENTER THE PIN :-");
        pin1.setFont(new Font("Times New Roman", Font.BOLD, 19));
        pin1.setBounds(30,250,500,35);
        add(pin1);

        amount1 = new JTextField();
        amount1.setBounds(500,200,200,25);
        amount1.setFont(new Font("Times New Roman", Font.PLAIN,18));
        add(amount1);

        pinfield = new JPasswordField();
        pinfield.setBounds(500,250,200,25);
        pinfield.setFont(new Font("Times New Roman", Font.PLAIN,18));
        add(pinfield);

        Withdraw1 = new JButton("Withdrawl");
        Withdraw1.setBounds(280,400,150,25);
        Withdraw1.setFont(new Font("Times New Roman", Font.BOLD,19));
        Withdraw1.addActionListener(this);
        add(Withdraw1);

        back = new JButton("Back");
        back.setBounds(550,400,150,25);
        back.setFont(new Font("Times New Roman", Font.BOLD,19));
        back.addActionListener(this);
        add(back);


        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Withdraw1) {
            try {
                String amount = amount1.getText();
                String pin2 = pinfield.getText();
                Date date = new Date();
                if (amount1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
                } else if (pin2.equals("")) {
                    JOptionPane.showMessageDialog(null,"Please enter your PIN");
                    
                } else {
                    data c1 = new data();
                    ResultSet resultSet = c1.statement.executeQuery("select * from bank where pin = '" + pin + "'");

                    if(!pin2.equals(pin)) {
                        JOptionPane.showMessageDialog(null,"Incorrect PIN . Please enter correct PIN");
                        return;
           }

                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }

                    c1.statement.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Withdraw', '" + amount + "' )");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                    setVisible(false);
                    new Interface(pin);

                }


            } catch (Exception E) {

            }
        } else if (e.getSource()==back) {
            setVisible(false);
            new Interface(pin);
            
        }
    }

    public static void main(String[] args) {
        new Withdraw("");
    }
}
