import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends JFrame {

    public void setLookAndFeel() {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    private JPanel contentPane;
    JLabel l1, l2;
    JTextField t1;
    JPasswordField p1;
    JButton b1, b2, b3;

    public Login(String title) {

        super(title);

        setLookAndFeel();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 714, 505);
        setLocationRelativeTo(this);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLayout(null);
        l1 = new JLabel("enter user name");
        l2 = new JLabel("enter user Password");

        t1 = new JTextField(10);
        p1 = new JPasswordField(10);
        b1 = new JButton("Login");
        b2 = new JButton("Reset");
        b3 = new JButton("new User");
        add(l1);
        add(t1);
        add(l2);
        add(p1);
        add(b1);
        add(b2);
        add(b3);
        l1.setBounds(160, 40, 200, 25);
        t1.setBounds(360, 40, 200, 25);

        l2.setBounds(160, 80, 200, 25);
        p1.setBounds(360, 80, 200, 25);

        b1.setBounds(100, 200, 100, 25);
        b2.setBounds(250, 200, 100, 25);
        b3.setBounds(400, 200, 100, 25);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int flag = 0;
                String usertype = "";
                String username = t1.getText();
                char ch[] = p1.getPassword();
                String password = String.copyValueOf(ch);
                System.out.println(" laxman mali =" + username.isEmpty());
                System.out.println(username + ":i am a laxman :" + password);
                System.out.println("null=" + null);

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(getParent(),
                            "  enter any vaue in textBox ", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Connection con = DBINFO.getConnection();
                    java.sql.PreparedStatement ps = null;

                    ResultSet res;

                    String query = "SELECT * FROM `login` where username = ? and password = ?";

                    try {
                        ps = con.prepareStatement(query);

                        ps.setString(1, username);
                        ps.setString(2, password);
                        res = ps.executeQuery();
                        while (res.next()) {
                            flag = 1;
                            usertype = res.getString(4);
                            break;
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (flag == 1 && usertype.equalsIgnoreCase("admin")) {
                        AdminSection obj = new AdminSection("Admin Account",
                                username);
                        obj.setVisible(true);
                        dispose();

                    }
                    if (flag == 1 && usertype.equalsIgnoreCase("faculty")) {

                        JOptionPane.showMessageDialog(getParent(),
                                "login done", "success",
                                JOptionPane.INFORMATION_MESSAGE);
                        System.out
                                .println("login successfully done as Faculty");

                    }
                    if (flag == 1 && usertype.equalsIgnoreCase("student")) {

                        StudentSection frame = new StudentSection(
                                "Student Section", username);
                        frame.setVisible(true);
                        dispose();

                    }
                    if (flag == 0) {
                        JOptionPane.showMessageDialog(getParent(),
                                "login Falled", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        p1.setText(null);

                    }

                }
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                t1.setText(null);
                p1.setText(null);

            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Registration frame = new Registration("Registration New user");
                frame.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String args[]) {
        Login r = new Login("Already member ? sign in");
        r.setVisible(true);
    }

}
