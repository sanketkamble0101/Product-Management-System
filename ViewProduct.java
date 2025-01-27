package product.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewProduct extends JFrame implements ActionListener {
    
    JTable table;
    Choice cproductname;
    JButton search1, print, update, back;
    
    ViewProduct() {
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel search = new JLabel("Search By Product Name");
        search.setBounds(20, 20, 150, 20);
        add(search);
        
        cproductname = new Choice();
        cproductname.setBounds(170, 20, 150, 20);
        add(cproductname);
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from product");
            
            while(rs.next()) {
                cproductname.add(rs.getString("name"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from product");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            while(rs.next()) {
                cproductname.add(rs.getString("name"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        search1 = new JButton("Search");
        search1.setBounds(20, 70, 80, 20);
        search1.addActionListener(this);
        add(search1);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == search1) {
            String query = "select * from product where name='"+cproductname.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource() == print) {
            try {
                table.print();
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource() == update) {
            setVisible(false);
            new UpdateProduct(cproductname.getSelectedItem());
        } else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]) {
        new ViewProduct();
    }
}
