package product.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home1 extends JFrame implements ActionListener {
    
    JButton add, purchase, remove, ship, feedback;
    
    Home1() {
        
        getContentPane().setBackground(Color.black);
        setLayout(null);
        
        JLabel heading = new JLabel("Product Management System");
        heading.setBounds(330,15,600,40);
        heading.setFont(new Font("serif", Font.PLAIN, 40));
        heading.setForeground(Color.white);
        add(heading);
        
        add = new JButton("Add Product");
        add.setBounds(150, 70, 150, 40);
        add.addActionListener(this);
        add(add);
        
        purchase = new JButton("Purchase Product");
        purchase.setBounds(310, 70, 150, 40);
        purchase.addActionListener(this);
        add(purchase);
        
        remove = new JButton("Remove Purchase");
        remove.setBounds(470, 70, 150, 40);
        remove.addActionListener(this);
        add(remove);
        
        ship = new JButton("Shipment");
        ship.setBounds(630, 70, 150, 40);
        ship.addActionListener(this);
        add(ship);
        
        feedback = new JButton("Feedback");
        feedback.setBounds(790, 70, 150, 40);
        feedback.addActionListener(this);
        add(feedback);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/biscuits.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,200,200,200);
        add(image);
        
        JLabel biscuit = new JLabel("Biscuit");
        biscuit.setBounds(150,415,100,30);
        biscuit.setFont(new Font("serif", Font.PLAIN, 30));
        biscuit.setForeground(Color.white);
        add(biscuit);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/chips.jpg"));
        Image i5 = i4.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(330,200,200,200);
        add(image1);
        
        JLabel chip = new JLabel("Chips");
        chip.setBounds(390,415,100,30);
        chip.setFont(new Font("serif", Font.PLAIN, 30));
        chip.setForeground(Color.white);
        add(chip);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i8 = i7.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image2 = new JLabel(i9);
        image2.setBounds(550,200,200,200);
        add(image2);
        
        JLabel book = new JLabel("Books");
        book.setBounds(610,415,100,30);
        book.setFont(new Font("serif", Font.PLAIN, 30));
        book.setForeground(Color.white);
        add(book);
        
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/ball.jpg"));
        Image i11 = i10.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel image3 = new JLabel(i12);
        image3.setBounds(770,200,200,200);
        add(image3);
        
        JLabel ball = new JLabel("Sport");
        ball.setBounds(830,415,100,30);
        ball.setFont(new Font("serif", Font.PLAIN, 30));
        ball.setForeground(Color.white);
        add(ball);
        
        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add) {
            setVisible(false);
            new AddProduct1();
        } else if(ae.getSource() == purchase) {
            setVisible(false);
            new Purchase();
        } else if(ae.getSource() == remove) {
            setVisible(false);
            new RemovePurchase();
        } else if(ae.getSource() == ship){
            setVisible(false);
            new Shipment();
        } else {
            setVisible(false);
            new Feedback();
        }
    }
    
    public static void main(String args[]) {
        new Home1();
    }
}
