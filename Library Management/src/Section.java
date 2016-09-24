import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Section extends JFrame {

    JPanel f, l;

    public static void main(String[] args) {
        try {
            Section frame = new Section("admin Section");
            frame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Section(String title) {

        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 714, 505);
        f = new JPanel();
        l = new JPanel();
        f.setBounds(50, 100, 600, 400);

        f.setBorder(new EmptyBorder(5, 5, 5, 5));
        // setContentPane(f);
        f.setLayout(new GridLayout(3, 2, 0, 0));
        //setLocationRelativeTo(this);
        add(f, BorderLayout.CENTER);
        add(l, BorderLayout.WEST);

        ImageIcon usIcon = new ImageIcon("image/usIcon.gif");
        ImageIcon caIcon = new ImageIcon("image/caIcon.gif");
        ImageIcon ukIcon = new ImageIcon("image/ukIcon.gif");

        // l.setLayout(new FlowLayout(FlowLayout.LEADING));  
        JButton b1 = new JButton(usIcon);
        JButton b2 = new JButton(caIcon);
        JButton b3 = new JButton(ukIcon);
        JButton b6 = new JButton(usIcon);

        JButton b4 = new JButton("Issue book");
        JButton b5 = new JButton("Search Book");
        JButton b8 = new JButton("Change Passworld");
        JButton b9 = new JButton("Search Student");

        l.add(b1);
        f.add(b4);
        f.add(b5);
        f.add(b8);
        f.add(b9);
        l.add(b2);
        l.add(b3);
        l.add(b6);

        b1.setBounds(50, 5, 20, 20);
        b2.setBounds(5, 27, 20, 20);
        b3.setBounds(5, 49, 20, 20);
        b6.setBounds(5, 71, 20, 20);
	    //setting grid layout of 3 rows and 3 columns  

        f.setSize(300, 300);
        f.setVisible(true);
    }

}
