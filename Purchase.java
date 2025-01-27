package product.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Purchase extends JFrame implements ActionListener {
    
    JTextField tfname, tfcom, tfq;
    JButton add, back;
    JTable table;
    
    Purchase() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Purchase Product Details");
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
        
        JLabel pcom = new JLabel("Company:");
        pcom.setBounds(50, 200, 150, 30);
        pcom.setFont(new Font("serif", Font.PLAIN, 20));
        add(pcom);
        
        tfcom = new JTextField();
        tfcom.setBounds(200, 200, 150, 30);
        add(tfcom);
        
        JLabel pq = new JLabel("Quantity:");
        pq.setBounds(50, 250, 150, 30);
        pq.setFont(new Font("serif", Font.PLAIN, 20));
        add(pq);
        
        tfq = new JTextField();
        tfq.setBounds(200, 250, 150, 30);
        add(tfq);
        
        add = new JButton("Purchase Product");
        add.setBounds(250, 350, 150, 40);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 350, 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from purchase");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            while(rs.next()) {
                
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 500, 900, 600);
        add(jsp);
        
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
                String query = "insert into purchase values('"+name+"', '"+com+"', '"+qnty+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Product purchase successfully");
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
        new Purchase();
    }
}
