package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.jar.JarEntry;

public class ministatement extends JFrame implements ActionListener {
    JButton exit;
    String pin;

    ministatement(String pin)
    {
        getContentPane().setBackground(new Color(100, 169, 182, 255));
        setLayout(null);
        this.pin = pin;

        JLabel mybank = new JLabel("MY BANK");
        mybank.setFont(new Font("Times New Roman", Font.BOLD, 21));
        mybank.setBounds(720,20,120,35);
        add(mybank);

        JLabel label1 = new JLabel();
        label1.setBounds(200,140,800,600);
        label1.setFont(new Font("Times New Roman", Font.BOLD,18));
        add(label1);

        JScrollPane scrollPane = new JScrollPane(label1);
        scrollPane.setBounds(20, 140, 600, 400); // Set bounds for the scroll area
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);


        JLabel label3 = new JLabel();
        label3.setBounds(100,80,300,20);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(620,700,500,25);
        label4.setFont(new Font("Times New Roman", Font.BOLD,20));
        add(label4);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            data r  = new data();
            ResultSet as = r.statement.executeQuery("Select * from login where pin = '"+pin+"'");
            while (as.next())
            {
                label3.setText("Card Number : "+ as.getString("card_no").substring(0,4)+"XXXXXXXX"+as.getString("card_no").substring(12));
            }

        }catch (Exception s)
        {
            s.printStackTrace();

        }

        try {
            int balance = 0;
            data r =new data();

            ResultSet resultSet = r.statement.executeQuery("Select * from bank where pin = '"+pin+"' ");
            while (resultSet.next())
            {
                label1.setText(label1.getText() + "<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+ "<br><br><html>");
                if(resultSet.getString("type").equals("Deposit"))
                {
                    balance +=Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -=Integer.parseInt(resultSet.getString("amount"));

                }
            }
            label4.setText("Your Total Balance is Rs "+balance);
        }catch (Exception f)
        {
            f.printStackTrace();

        }
        exit = new JButton("Exit");
        exit.setBounds(700,750,150,30);
        exit.setFont(new Font("Times New Roman", Font.BOLD,22));
        exit.addActionListener(this);
        add(exit);


setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Interface(pin);

    }

    public static void main(String[] args) {
        new ministatement("");
    }
}
