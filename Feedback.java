package product.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Feedback extends JFrame implements ActionListener {
    
    JTextField tfname, tfcom, tfq;
    JButton add, back;
    
    Feedback() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Feedback");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("san_serif", Font.BOLD, 25));
        add(heading);
        
        JLabel pname = new JLabel("Product Name:");
        pname.setBounds(50, 150, 150, 30);
        pname.setFont(new Font("serif", Font.PLAIN, 20));
        add(pname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        JLabel pna = new JLabel("On basis of 1 to 5");
        pna.setBounds(210, 200, 150, 30);
        pna.setFont(new Font("serif", Font.PLAIN, 16));
        add(pna);
        
        JLabel pcom = new JLabel("Rate the Product:");
        pcom.setBounds(50, 220, 150, 30);
        pcom.setFont(new Font("serif", Font.PLAIN, 20));
        add(pcom);
        
        tfcom = new JTextField();
        tfcom.setBounds(200, 230, 150, 30);
        add(tfcom);
        
        JLabel pq = new JLabel("Description:");
        pq.setBounds(50, 300, 150, 30);
        pq.setFont(new Font("serif", Font.PLAIN, 20));
        add(pq);
        
        tfq = new JTextField();
        tfq.setBounds(200, 300, 150, 30);
        add(tfq);
        
        add = new JButton("Submit Feedback");
        add.setBounds(250, 400, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 400, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add) {
            String name = tfname.getText();
            String com = tfcom.getText();
            String qnty = tfq.getText();
            
            try {
                Conn conn = new Conn();
                String query = "insert into feedback values('"+name+"', '"+com+"', '"+qnty+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Feedback submit successfully");
                setVisible(false);
                new Home1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home1();
        }
    }
    
    public static void main(String args[]) {
        new Feedback();
    }
}
