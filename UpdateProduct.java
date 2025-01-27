package product.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateProduct extends JFrame implements ActionListener {
    
    JTextField tfprice, tfcom, tfq;
    JLabel lblid, lblname;
    JButton add, back;
    String id;
    
    UpdateProduct(String id) {
        this.id = id;
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Product Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("san_serif", Font.BOLD, 25));
        add(heading);
        
        JLabel pname = new JLabel("Product Name:");
        pname.setBounds(50, 150, 150, 30);
        pname.setFont(new Font("serif", Font.PLAIN, 20));
        add(pname);
        
        lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);
        
        JLabel pid = new JLabel("Product ID:");
        pid.setBounds(50, 200, 150, 30);
        pid.setFont(new Font("serif", Font.PLAIN, 20));
        add(pid);
        
        lblid = new JLabel();
        lblid.setBounds(200, 200, 150, 30);
        add(lblid);
        
        JLabel price = new JLabel("Price:");
        price.setBounds(50, 250, 150, 30);
        price.setFont(new Font("serif", Font.PLAIN, 20));
        add(price);
        
        tfprice = new JTextField();
        tfprice.setBounds(200, 250, 150, 30);
        add(tfprice);
        
        JLabel pcom = new JLabel("Company:");
        pcom.setBounds(50, 300, 150, 30);
        pcom.setFont(new Font("serif", Font.PLAIN, 20));
        add(pcom);
        
        tfcom = new JTextField();
        tfcom.setBounds(200, 300, 150, 30);
        add(tfcom);
        
        JLabel pq = new JLabel("Quantity:");
        pq.setBounds(50, 350, 150, 30);
        pq.setFont(new Font("serif", Font.PLAIN, 20));
        add(pq);
        
        tfq = new JTextField();
        tfq.setBounds(200, 350, 150, 30);
        add(tfq);
        
        try {
            Conn c = new Conn();
            String query = "select * from product where id='"+id+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                lblid.setText(rs.getString("id"));
                tfprice.setText(rs.getString("price"));
                tfcom.setText(rs.getString("company"));
                tfq.setText(rs.getString("quantity"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        add = new JButton("Update Product");
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
            String price = tfprice.getText();
            String com = tfcom.getText();
            String qnty = tfq.getText();
            
            try {
                Conn conn = new Conn();
                String query = "update product set price = '"+price+"', company = '"+com+"', quantity = '"+qnty+"' where id = '"+lblid+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Product updated successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]) {
        new UpdateProduct("");
    }
}
