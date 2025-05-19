package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changepin extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField p1,p2;

    String pin;
    changepin(String pin)
    {
        this.pin = pin;
        getContentPane().setBackground(new Color(100, 169, 182, 255));
        setLayout(null);

        JLabel mybank = new JLabel("MY BANK");
        mybank.setFont(new Font("Times New Roman", Font.BOLD, 21));
        mybank.setBounds(720,20,120,35);
        add(mybank);

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setFont(new Font("Times New Roman", Font.BOLD, 19));
        label1.setBounds(30,100,420,35);
        add(label1);

        JLabel label2 = new JLabel("NEW PIN :-");
        label2.setFont(new Font("Times New Roman", Font.BOLD, 18));
        label2.setBounds(30,200,420,35);
        add(label2);

        JLabel label3 = new JLabel("RE-ENTER NEW PIN :-");
        label3.setFont(new Font("Times New Roman", Font.BOLD, 18));
        label3.setBounds(30,300,420,35);
        add(label3);

        p1 = new JPasswordField();
        p1.setBounds(350,200,200,25);
        p1.setFont(new Font("Times New Roman", Font.PLAIN,18));
        add(p1);

        p2 = new JPasswordField();
        p2.setBounds(350,300,200,25);
        p2.setFont(new Font("Times New Roman", Font.PLAIN,18));
        add(p2);

        b1 = new JButton("Change");
        b1.setBounds(500,600,150,30);
        b1.setFont(new Font("Times New Roman", Font.BOLD,22));
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(800,600,150,30);
        b2.setFont(new Font("Times New Roman", Font.BOLD,22));
        b2.addActionListener(this);
        add(b2);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try
        {
                String s1 = p1.getText();
            String s2 = p2.getText();
            if (!s1.equals(s2)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            if (e.getSource()==b1) {
                if (p1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }
                if (p2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter New PIN");
                    return;
                }
                data a = new data();
                String a1 = "Update bank set pin = '"+s1+"' where pin = '"+pin+"'";
                String a2 = "Update login set pin = '"+s1+"' where pin = '"+pin+"'";
                String a3 = "Update accountdetail set pin = '"+s1+"' where pin = '"+pin+"'";

                a.statement.executeUpdate(a1);
                a.statement.executeUpdate(a2);
                a.statement.executeUpdate(a3);

                JOptionPane.showMessageDialog(null,"Your PIN changed successfully");
                setVisible(false);
                new Welcome_page(pin);



            } else if (e.getSource()==b2) {
                new Interface(pin);
                setVisible(false);
            }

        }catch (Exception d)
        {
            d.printStackTrace();

        }

    }

    public static void main(String[] args) {
        new changepin("");
    }
}
