package product.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {
    
    JButton admin, user;
    
    Splash() {
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("PRODUCT MANAGEMENT SYSTEM");
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50,100,1050,500);
        add(image);
        
        admin = new JButton("Admin");
        admin.setBounds(440, 200, 200, 50);
        admin.setFont(new Font("Arial", Font.PLAIN, 20));
        admin.setBackground(Color.white);
        admin.setForeground(Color.black);
        admin.addActionListener(this);
        image.add(admin);
        
        user = new JButton("User");
        user.setBounds(440, 300, 200, 50);
        user.setFont(new Font("Arial", Font.PLAIN, 20));
        user.setBackground(Color.white);
        user.setForeground(Color.black);
        user.addActionListener(this);
        image.add(user);
        
        setSize(1170,650);
        setLocation(200,50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == admin) {
            setVisible(false);
            new Login1();
        } else {
            setVisible(false);
            new Login2();
        }
    }
    
    public static void main(String args[]) {
        new Splash();
    }
}
