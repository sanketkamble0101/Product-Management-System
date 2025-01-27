package product.management.system;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class Shipment extends JFrame implements ActionListener {
    
    JTextField tfname, tfcom, tfq, tfaddress;
    JDateChooser dcdb;
    JButton add, back;
    Choice cname;
    
    Shipment() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Product Shipment Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("san_serif", Font.BOLD, 25));
        add(heading);
        
        JLabel pname = new JLabel("Person Name:");
        pname.setBounds(50, 150, 150, 30);
        pname.setFont(new Font("serif", Font.PLAIN, 20));
        add(pname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        JLabel pcom = new JLabel("Product Name:");
        pcom.setBounds(50, 200, 150, 30);
        pcom.setFont(new Font("serif", Font.PLAIN, 20));
        add(pcom);
        
        cname = new Choice();
        cname.setBounds(200, 200, 150, 30);
        add(cname);
        
        try {
            Conn c = new Conn();
            String query = "select * from purchase";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                cname.add(rs.getString("name"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        JLabel pq = new JLabel("Mobile No:");
        pq.setBounds(50, 250, 150, 30);
        pq.setFont(new Font("serif", Font.PLAIN, 20));
        add(pq);
        
        tfq = new JTextField();
        tfq.setBounds(200, 250, 150, 30);
        add(tfq);
        
        JLabel date = new JLabel("Date:");
        date.setBounds(50, 300, 150, 30);
        date.setFont(new Font("serif", Font.PLAIN, 20));
        add(date);
        
        dcdb = new JDateChooser();
        dcdb.setBounds(200, 300, 150, 30);
        add(dcdb);
        
        JLabel address = new JLabel("Address:");
        address.setBounds(50, 350, 150, 30);
        address.setFont(new Font("serif", Font.PLAIN, 20));
        add(address);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 350, 150, 30);
        add(tfaddress);
        
        add = new JButton("Place Shipment");
        add.setBounds(250, 450, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 450, 150, 40);
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
            String com = cname.getSelectedItem();
            String qnty = tfq.getText();
            String db = ((JTextField) dcdb.getDateEditor().getUiComponent()).getText();
            String addr = tfaddress.getText();
            
            try {
                Conn conn = new Conn();
                String query = "insert into shipment values('"+name+"', '"+com+"', '"+qnty+"', '"+db+"', '"+addr+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Product shipment successfully");
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
        new Shipment();
    }
}
