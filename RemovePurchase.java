package product.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemovePurchase extends JFrame implements ActionListener {
    
    Choice cname;
    JButton delete, back;
    
    RemovePurchase() {
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel labelid = new JLabel("Product Name:");
        labelid.setBounds(50, 50, 100, 30);
        add(labelid);
        
        cname = new Choice();
        cname.setBounds(200, 50, 100, 30);
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
        
        JLabel labelcomp = new JLabel("Company Name:");
        labelcomp.setBounds(50, 100, 100, 30);
        add(labelcomp);
        
        JLabel comp = new JLabel();
        comp.setBounds(200, 100, 100, 30);
        add(comp);
        
        JLabel labelqty = new JLabel("Quantity:");
        labelqty.setBounds(50, 150, 100, 30);
        add(labelqty);
        
        JLabel qty = new JLabel();
        qty.setBounds(200, 150, 100, 30);
        add(qty);
        
        try {
            Conn c = new Conn();
            String query = "select * from purchase where name='"+cname.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                comp.setText(rs.getString("company"));
                qty.setText(rs.getString("quantity"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        cname.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from purchase where name='"+cname.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        comp.setText(rs.getString("company"));
                        qty.setText(rs.getString("quantity"));
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220, 300, 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                String query = "delete from purchase where name='"+cname.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Product deleted successfully");
                setVisible(false);
                new Home1();
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home1();
        }
    }
    
    public static void main(String args[]) {
        new RemovePurchase();
    }
}
