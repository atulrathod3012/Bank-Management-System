package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Welcome_page extends JFrame implements ActionListener
{
    JLabel label1;
    JLabel label2;
    JLabel label3;

    JTextField username;
    JPasswordField password;

    JButton log_button;
    JButton clear_button;
    JButton sign_button;

    JLabel Lsign_button ;


    String pin;
    Welcome_page(String pin){
        super("My Bank");
        this.pin  = pin;

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("Icon/Bankbg.jpeg"));
        Image img2 = img1.getImage().getScaledInstance(700,700, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(0,0,700,650);
        add(image);

        ImageIcon imag1 = new ImageIcon(ClassLoader.getSystemResource("Icon/rupee.png"));
        Image imag2 = imag1.getImage().getScaledInstance(80,80, Image.SCALE_DEFAULT);
        ImageIcon imag3 = new ImageIcon(imag2);
        JLabel image1 = new JLabel(imag3);
        image1.setBounds(1000,30,100,100);
        add(image1);

        label1  = new JLabel("WELCOME TO BANK");
        label1.setBounds(950,5,400,300);
        label1.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(label1);

        label2  = new JLabel("Account no. :");
        label2.setBounds(730,260,120,50);
        label2.setFont(new Font("Times New Roman",Font.BOLD,19));
        add(label2);

        label3  = new JLabel("Password     :");
        label3.setBounds(730,310,120,50);
        label3.setFont(new Font("Times New Roman",Font.BOLD,19));
        add(label3);

        username = new JTextField(17);
        username.setBounds(860,265,300,30);
        username.setFont(new Font("Times New Roman",Font.PLAIN,16));
        add(username);

        password = new JPasswordField(17);
        password.setBounds(860,320,300,30);
        password.setFont(new Font("Times New Roman",Font.PLAIN,16));
        add(password);

        log_button = new JButton("Login");
        log_button.setBounds(860,370,130,40);
        log_button.setFont(new Font("Times New Roman",Font.PLAIN,19));
        log_button.addActionListener(this);
        add(log_button);

        clear_button = new JButton("Clear All");
        clear_button.setBounds(1020,370,140,40);
        clear_button.setFont(new Font("Times New Roman",Font.PLAIN,19));
        clear_button.addActionListener(this);
        add(clear_button);

        Lsign_button = new JLabel("* If new user sign up.");
        Lsign_button.setBounds(924,430,150,40);
        Lsign_button.setFont(new Font("Times New Roman",Font.PLAIN,16));
        add(Lsign_button);

        sign_button = new JButton("Sign Up");
        sign_button.setBounds(950,470,100,40);
        sign_button.setFont(new Font("Times New Roman",Font.PLAIN,19));
        sign_button.addActionListener(this);
        add(sign_button);




        setLayout(null);
        setSize(1400,700);
        setLocation(50,50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {
        try {
            if(e.getSource()==log_button)
            {
                data c = new data();
                String card_no = username.getText();
                String pin = password.getText();
                String q = "select * from login where card_no = '"+card_no+"' and  pin = '"+pin+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if (resultSet.next() ) {
                    setVisible(false);
                    new Interface(pin);
                }
                else {
                    JOptionPane.showMessageDialog(null,"incorrect Username of Password");

                }

            }
            else if (e.getSource()==clear_button)
            {
               username.setText("");
               password.setText("");
            }
            else if (e.getSource()==sign_button)
            {
                new Sign_up();
                setVisible(false);


            }

        }
        catch (Exception E)
        {
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Welcome_page("");
    }
}
