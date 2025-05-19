package bank.management.system;

import javax.swing.*;
import java.awt.*;

public class thankyou extends JFrame {

    thankyou()
    {

        getContentPane().setBackground(new Color(100, 169, 182, 255));

        JLabel mybank = new JLabel("MY BANK");
        mybank.setFont(new Font("Times New Roman", Font.BOLD, 26));
        mybank.setBounds(280,20,200,35);
        add(mybank);

        setLayout(null);
        setLocation(420,50);
        setSize(700,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JLabel a = new JLabel("THANK YOU FOR USING MY BANK.");
        a.setFont(new Font("Times New Roman", Font.BOLD, 22));
        a.setBounds(150,250,500,35);
        add(a);

        Timer s = new Timer(4000, e->this.dispose());
        s.setRepeats(false);
        s.start();


    }

    public static void main(String[] args) {
        new thankyou();
    }

}
