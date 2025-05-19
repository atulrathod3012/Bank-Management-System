package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Money_Deposit extends JFrame implements ActionListener {
    JTextField amount1 ;
    JButton deposit,back ;
    String pin;

     Money_Deposit(String pin)
    {
        this.pin = pin;

        getContentPane().setBackground(new Color(100, 169, 182, 255));
        setLayout(null);

        JLabel mybank = new JLabel("MY BANK");
        mybank.setFont(new Font("Times New Roman", Font.BOLD, 21));
        mybank.setBounds(720,20,120,35);
        add(mybank);



        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT :-");
        label1.setFont(new Font("Times New Roman", Font.BOLD, 19));
        label1.setBounds(30,100,420,35);
        add(label1);


        amount1 = new JTextField();
        amount1.setBounds(480,100,200,25);
        amount1.setFont(new Font("Times New Roman", Font.PLAIN,18));
        add(amount1);

        deposit = new JButton("Deposit");
        deposit.setBounds(800,100,150,25);
        deposit.setFont(new Font("Times New Roman", Font.BOLD,19));
        deposit.addActionListener(this);
        add(deposit);

        back = new JButton("Back");
        back.setBounds(970,100,150,25);
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
         try{
             String amount = amount1.getText();
             Date date = new Date();
             if (e.getSource()==deposit) {
                 if (amount1.getText().equals("")) {
                     JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Deposit");
                 }
                 else
                 {
                     data da = new data();
                     da.statement.executeUpdate("insert into bank values('"+pin+"', '"+date+"','Deposit', '"+amount+"')");
                     JOptionPane.showMessageDialog(null,"Rs. "+amount+" Deposited Successfully");
                     setVisible(false);
                     new Interface(pin);
                 }
             }
             else if (e.getSource()==back)
             {
                 setVisible(false);
                 new Interface(pin);
             }


         }catch (Exception s)
         {
             s.printStackTrace();
         }


    }

    public static void main(String[] args) {
        new Money_Deposit("");
    }
}
