package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Balance_enquiry extends JFrame implements ActionListener {
    JLabel label1,label2;
    JButton back1;
    String pin;


    Balance_enquiry(String pin)
    {
        this.pin = pin;
        JLabel mybank = new JLabel("MY BANK");
        mybank.setFont(new Font("Times New Roman", Font.BOLD, 21));
        mybank.setBounds(720,20,120,35);
        add(mybank);

         label1 = new JLabel("YOUR CURRENT BALANCE IS :-");
        label1.setFont(new Font("Times New Roman", Font.BOLD, 19));
        label1.setBounds(30,200,500,35);
        add(label1);

         label2 = new JLabel();
        label2.setFont(new Font("Times New Roman", Font.BOLD, 19));
        label2.setBounds(500,200,600,35);
        add(label2);

        back1 = new JButton("Back");
        back1.setBounds(970,200,150,25);
        back1.setFont(new Font("Times New Roman", Font.BOLD,19));
        back1.addActionListener(this);
        add(back1);

        int balance =0;
        try{
            data c = new data();
            ResultSet resultSet = c.statement.executeQuery("Select * from bank where pin = '"+pin+"'");
            while (resultSet.next()){
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            label2.setText("Rs. " + balance);
        }catch (Exception e){
            e.printStackTrace();
        }

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Interface(pin);

    }

    public static void main(String[] args) {
        new Balance_enquiry("");
    }
}
