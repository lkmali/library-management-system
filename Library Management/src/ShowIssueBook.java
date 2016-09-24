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

public class ShowIssueBook extends JFrame {

    private JPanel contentPane;
    JLabel s, B, Br;
    JComboBox SearchC, C, branch;

    JButton b1, b2, b3;
    JMenu file, AddItem, help;
    JMenuItem Home, issueBOOK, Update, Delete, AddnewItem, home;
    JMenuBar mb;

    /**
     * Launch the application.
     */
    /*
     public static void main(String[] args) {
		
     try {
     ShowIssueBook frame = new ShowIssueBook("Search Student","prachi" );
     frame.setVisible(true);
     } catch (Exception e) {
     e.printStackTrace();
     }
     }

     */
    //Constructer 
    public ShowIssueBook(String title, String username) {
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

        mb = new JMenuBar();
        mb.setBounds(0, 0, 1000, 20);
        file = new JMenu("File");
        home = new JMenu("Home");
        help = new JMenu("Help");
        //add new menu bar
        home.add(Home);;

        mb.add(file);
        mb.add(home);
        mb.add(help);
        contentPane.add(mb);

        String SEARCH[] = {"Select", "BID", "BookT", "Author", "SUB", "Publication", "category", "CollegeId", "Name", "Branch", "Sem", "all"};

        SearchC = new JComboBox(SEARCH);
        s = new JLabel("SEARCH BY");

        SearchC.setBounds(320, 40, 100, 40);
        s.setBounds(160, 40, 100, 30);
        contentPane.add(SearchC);

        contentPane.add(s);
        b1 = new JButton("Search");
        b1.setBounds(160, 100, 100, 40);
        contentPane.add(b1);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String SearchStudent = (String) SearchC.getSelectedItem();
                if (SearchStudent == "Select") {

                    JOptionPane.showMessageDialog(getParent(), " pleace Select any Option", "Error", JOptionPane.ERROR_MESSAGE);

                } else {

                    if (SearchStudent == "all") {

                        DBINFO.getStudent(SearchStudent, " ");
                        JFrame frm = new JFrame();
                        frm.setSize(1500, 600);
                        frm.setLocationRelativeTo(getParent());
                        //now create a JTable
                        JTable tabel = new JTable(DBINFO.Record1, DBINFO.header1);
                        JScrollPane pane = new JScrollPane(tabel);
                        frm.add(pane);
                        frm.setVisible(true);

                    } else if (SearchStudent == "BID") {

                        String value = JOptionPane.showInputDialog("enter book NO");
                        if (value == " ") {
                            JOptionPane.showMessageDialog(getParent(), "pleace enter book no ", "Error", JOptionPane.ERROR_MESSAGE);

                        } else {
                            DBINFO.getStudent(SearchStudent, value);
                            JFrame frm = new JFrame();
                            frm.setSize(1500, 600);
                            frm.setLocationRelativeTo(getParent());
                            //now create a JTable
                            JTable tabel = new JTable(DBINFO.Record1, DBINFO.header1);
                            JScrollPane pane = new JScrollPane(tabel);
                            frm.add(pane);
                            frm.setVisible(true);

                        }

                    } else if (SearchStudent == "Name" || SearchStudent == "CollegeId" || SearchStudent == "Sem") {

                        String value = JOptionPane.showInputDialog("enter " + SearchStudent);
                        if (value == " ") {
                            JOptionPane.showMessageDialog(getParent(), "pleace enter book no ", "Error", JOptionPane.ERROR_MESSAGE);

                        } else {
                            DBINFO.getStudent(SearchStudent, value);
                            JFrame frm = new JFrame();
                            frm.setSize(900, 600);
                            frm.setLocationRelativeTo(getParent());
                            //now create a JTable
                            JTable tabel = new JTable(DBINFO.Record1, DBINFO.header1);
                            JScrollPane pane = new JScrollPane(tabel);
                            frm.add(pane);
                            frm.setVisible(true);

                        }

                    } else if (SearchStudent == "Branch") {

                        String branch1[] = {"Computer Engineering", "Mechanical Engineering ", "Electronics & Communication Engineering", "Electronics Instrumentation & Control ", "Electrical Engineering ", "Civil Engineering   ", "Information Technology    "};
                        branch = new JComboBox(branch1);
                        Br = new JLabel("Select  Branch Name");
                        branch.insertItemAt("select", 0);
                        Br.setBounds(10, 20, 250, 25);
                        branch.setBounds(300, 20, 250, 25);
                        branch.setSelectedIndex(0);
                        JFrame fr = new JFrame();
                        fr.setBounds(10, 10, 600, 20);
                        fr.setLocationRelativeTo(getParent());
                        fr.setVisible(true);
                        fr.add(Br);
                        fr.add(branch);

                        branch.addItemListener(new ItemListener() {
                            public void itemStateChanged(ItemEvent e) {

                                String value = (String) branch.getSelectedItem();

                                DBINFO.getStudent(SearchStudent, value);

                                JFrame frm = new JFrame();
                                frm.setSize(900, 600);
                                frm.setLocationRelativeTo(getParent());
                                //now create a JTable
                                JTable tabel = new JTable(DBINFO.Record1, DBINFO.header1);
                                JScrollPane pane = new JScrollPane(tabel);
                                frm.add(pane);
                                frm.setVisible(true);
                                fr.setVisible(false);

                            }
                        });

                    } else {

                        if (SearchStudent == "SUB") {

                            C = new JComboBox(DBINFO.getsubject());;

                        }
                        if (SearchStudent == "BookT") {

                            C = new JComboBox(DBINFO.getTitle());;

                        }

                        if (SearchStudent == "Author") {

                            C = new JComboBox(DBINFO.getAuthor());

                        }
                        if (SearchStudent == "Publication") {

                            C = new JComboBox(DBINFO.getpublication());

                        }
                        if (SearchStudent == "category") {

                            C = new JComboBox(DBINFO.getcategory());

                        }

                        B = new JLabel("Select" + SearchStudent + "Name");
                        C.insertItemAt("select", 0);

                        B.setBounds(10, 20, 250, 25);
                        C.setBounds(300, 20, 250, 25);
                        C.setSelectedIndex(0);
                        JFrame fr = new JFrame();
                        fr.setBounds(10, 10, 600, 20);
                        fr.setLocationRelativeTo(getParent());
                        fr.setVisible(true);
                        fr.add(B);
                        fr.add(C);

                        C.addItemListener(new ItemListener() {
                            public void itemStateChanged(ItemEvent e) {

                                String value = (String) C.getSelectedItem();

                                DBINFO.getStudent(SearchStudent, value);

                                JFrame frm = new JFrame();
                                frm.setSize(1500, 600);
                                frm.setLocationRelativeTo(getParent());
                                //now create a JTable
                                JTable tabel = new JTable(DBINFO.Record1, DBINFO.header1);
                                JScrollPane pane = new JScrollPane(tabel);
                                frm.add(pane);
                                frm.setVisible(true);
                                fr.setVisible(false);

                            }
                        });

                    }

                }
                SearchC.setSelectedIndex(0);
            }
        });

    }
}
