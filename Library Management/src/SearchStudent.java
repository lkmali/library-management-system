import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class SearchStudent extends JFrame {

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
    public static void main(String[] args) {

        try {
            SearchStudent frame = new SearchStudent("Search Student", "prachi");
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Constructer 
    public SearchStudent(String title, String username) {
        super(title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 714, 505);
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
        mb.setBounds(0, 0, 514, 20);
        file = new JMenu("File");
        home = new JMenu("Home");
        help = new JMenu("Help");
        //add new menu bar
        home.add(Home);;

        mb.add(file);
        mb.add(home);
        mb.add(help);
        contentPane.add(mb);

        String SEARCH[] = {"Select", "BID", "Author", "SUB", "Publication", "category", "CollegeId", "Name", "Branch", "Sem", "all"};

        SearchC = new JComboBox(SEARCH);
        s = new JLabel("SEARCH BY");

        SearchC.setBounds(320, 40, 100, 20);
        s.setBounds(160, 40, 100, 20);
        contentPane.add(SearchC);

        contentPane.add(s);
        b1 = new JButton("Search");
        b1.setBounds(160, 100, 100, 20);
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
                        frm.setSize(900, 600);
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
                            frm.setSize(900, 600);
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
                        Br.setBounds(10, 20, 100, 20);
                        branch.setBounds(110, 20, 100, 20);
                        branch.setSelectedIndex(0);
                        JFrame fr = new JFrame();
                        fr.setBounds(100, 100, 500, 200);
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
                        B.setBounds(10, 20, 100, 20);
                        C.setBounds(110, 20, 100, 20);
                        C.setSelectedIndex(0);
                        JFrame fr = new JFrame();
                        fr.setBounds(100, 100, 500, 200);
                        fr.setLocationRelativeTo(getParent());
                        fr.setVisible(true);
                        fr.add(B);
                        fr.add(C);

                        C.addItemListener(new ItemListener() {
                            public void itemStateChanged(ItemEvent e) {

                                String value = (String) C.getSelectedItem();

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

                    }

                }
                SearchC.setSelectedIndex(0);
            }
        });

    }
}
