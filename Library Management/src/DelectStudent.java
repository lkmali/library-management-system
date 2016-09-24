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
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class DelectStudent extends JFrame {

    private JPanel contentPane;
    JLabel SI, branch, sem, name;
    JTextField t1, t2, t3, t4;
    JButton b1, b2, b3;

    String s2, s4, s5, s3 = "";
    JMenuBar mb;
    JMenu file, AddItem, help, home;
    JMenuItem author, nameject, category, publication;

    JMenuItem Home, BNF;

    /**
     * Launch the application.
     */
    /*  
     public static void main(String[] args) {
		
     try {
     DelectStudent frame = new DelectStudent("DelectStudent Account","prachi" );
     frame.setVisible(true);
     } catch (Exception e) {
     e.printStackTrace();
     }
     }
     */
    /**
     * Create the frame.
     */
    //Constructer 
    public DelectStudent(String title, String username) {
        super(title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1000, 505);
        setLocationRelativeTo(this);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLayout(null);

        Home = new JMenuItem("Home");

        Home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                AdminSection obj = new AdminSection("Admin Account", username);
                obj.setVisible(true);
                dispose();
            }
        });

        BNF = new JMenuItem("WHAT IS Student ID");
        BNF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                int ans = JOptionPane.showConfirmDialog(getParent(), "PLEACE SEARCH Student ID FROM THE SEARCH PANEL AND PUT IN THIS FILL BOX \n why do you Want Studengt Id ", "SEARCH MESSAGE", JOptionPane.INFORMATION_MESSAGE);

                if (ans == JOptionPane.YES_OPTION) {

                    SearchStudent frame = new SearchStudent("Search Student", username);
                    frame.setVisible(true);

                } else {
                    DelectStudent frame = new DelectStudent("Delete user Account", username);
                    frame.setVisible(true);
                    dispose();

                }

            }
        });

        mb = new JMenuBar();
        mb.setBounds(0, 0, 1000, 20);
        file = new JMenu("File");
        home = new JMenu("Home");
        help = new JMenu("Help");
        //add new menu bar
        home.add(Home);

        mb.add(file);
        mb.add(home);
        mb.add(help);
        help.add(BNF);
        contentPane.add(mb);

        //label of book
        SI = new JLabel("Student ID");
        name = new JLabel("Name");
        branch = new JLabel("Branch");
        sem = new JLabel("Semester");

        //book ID
        b3 = new JButton("search student");

        b3.setBounds(650, 40, 250, 25);
        t1 = new JTextField(10);

        t1.setBounds(320, 40, 200, 25);
        SI.setBounds(160, 40, 100, 25);
        contentPane.add(SI);
        contentPane.add(t1);
        contentPane.add(b3);

        b3.addActionListener(new ActionListener() {

            int Flag = 0;

            public void actionPerformed(ActionEvent arg0) {

                String id = t1.getText();

                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(getParent(), "Enter Student College Id  ", "Error", JOptionPane.ERROR_MESSAGE);

                } else {
                    String query = " SELECT * FROM `student` where CollegeId= ? ";

                    try {
                        PreparedStatement ps = DBINFO.getConnection().prepareStatement(query);
                        ps.setString(1, id);

                        ResultSet res = ps.executeQuery();

                        while (res.next()) {

                            s2 = res.getString(2);
                            s4 = res.getString(4);
                            s3 = res.getString(3);
                            s5 = res.getString(5);

                            Flag = 1;
                            break;

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (Flag == 1) {

                        t2.setText(s2);
                        t3.setText(s4);
                        t4.setText(s5);

                    } else {

                        JOptionPane.showMessageDialog(getParent(), "   Student Not Found   Pleace TRy AGAIN ", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        });

        //Student Branch
        t2 = new JTextField(10);
        t2.setBounds(350, 80, 250, 25);
        name.setBounds(160, 80, 150, 25);
        contentPane.add(name);
        contentPane.add(t2);
        t2.setEditable(false);

        //  Student Name
        t3 = new JTextField(10);
        t3.setBounds(350, 120, 250, 25);
        branch.setBounds(160, 120, 150, 25);
        contentPane.add(branch);
        contentPane.add(t3);

        t3.setEditable(false);

        // Student Semester
        t4 = new JTextField(10);
        t4.setBounds(350, 160, 250, 25);

        sem.setBounds(160, 160, 150, 25);
        contentPane.add(sem);

        contentPane.add(t4);
        t4.setEditable(false);

        b1 = new JButton("DELETE Student Account ");
        b1.setBounds(100, 360, 250, 25);
        contentPane.add(b1);

        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                String id = t1.getText();
                int i = 0;
                int j = 0;
                i = DBINFO.deletStudent1(id);
                System.out.println("Author is =" + s3);

                j = DBINFO.deletStudent(s3);

                if (j == 1 && i == 1) {

                    JOptionPane.showMessageDialog(getParent(), "Delete" + s2 + "Account");
                    t1.setText(null);
                    t2.setText(null);
                    t3.setText(null);
                    t4.setText(null);

                }
                if (i == 0) {
                    JOptionPane.showMessageDialog(getParent(), s2 + " Account is does not  Delete", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }

        });

        b2 = new JButton("Reset");
        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                t1.setText(null);
                t2.setText(null);
                t3.setText(null);
                t4.setText(null);
                dispose();
                new DelectStudent("DelectStudent Account", username).setVisible(true);

            }
        });

        b2.setBounds(350, 360, 250, 25);
        contentPane.add(b1);
        contentPane.add(b2);

    }
}
