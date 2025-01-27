package product.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveProduct extends JFrame implements ActionListener {
    
    Choice cid;
    JButton delete, back;
    
    RemoveProduct() {
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel labelid = new JLabel("Product ID:");
        labelid.setBounds(50, 50, 100, 30);
        add(labelid);
        
        cid = new Choice();
        cid.setBounds(200, 50, 100, 30);
        add(cid);
        
        try {
            Conn c = new Conn();
            String query = "select * from product";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                cid.add(rs.getString("id"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Product Name:");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);
        
        JLabel pname = new JLabel();
        pname.setBounds(200, 100, 100, 30);
        add(pname);
        
        JLabel labelcmp = new JLabel("Company Name:");
        labelcmp.setBounds(50, 150, 100, 30);
        add(labelcmp);
        
        JLabel cmp = new JLabel();
        cmp.setBounds(200, 150, 100, 30);
        add(cmp);
        
        try {
            Conn c = new Conn();
            String query = "select * from product where id='"+cid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                pname.setText(rs.getString("name"));
                cmp.setText(rs.getString("company"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        cid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from product where id='"+cid.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        pname.setText(rs.getString("name"));
                        cmp.setText(rs.getString("company"));
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
                String query = "delete from product where id='"+cid.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Product deleted successfully");
                setVisible(false);
                new Home();
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]) {
        new RemoveProduct();
    }
}