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

public class SearchByStudent extends JFrame {

    private JPanel contentPane;
    JLabel s, B;
    JComboBox SearchC, C;

    JButton b1, b2, b3;
    JMenu file, AddItem, help;
    JMenuItem Home, issueBOOK, home;
    JMenuBar mb;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        try {
            SearchByStudent frame = new SearchByStudent("Search Book", "laxman");
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /* Create the frame.*/
    //Constructer 
    public SearchByStudent(String title, String username) {
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

                StudentSection frame = new StudentSection(" StudentSection ", username);
                frame.setVisible(true);
                dispose();
            }
        });

        issueBOOK = new JMenuItem("Issue Book");

        issueBOOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                issueBOOK frame = new issueBOOK(" Issue book", username);
                frame.setVisible(true);
                dispose();

            }
        });

        mb = new JMenuBar();
        mb.setBounds(0, 0, 1000, 20);
        file = new JMenu("File");
        home = new JMenu("Home");
        help = new JMenu("Help");
        //add new menu bar
        home.add(Home);
        home.add(issueBOOK);

        mb.add(file);
        mb.add(home);
        mb.add(help);
        contentPane.add(mb);

        String SEARCH[] = {"Select", "BID", "BookT", "Author", "SUB", "Publication", "category", "all"};

        SearchC = new JComboBox(SEARCH);
        s = new JLabel("SEARCH BY");

        SearchC.setBounds(350, 40, 250, 25);
        s.setBounds(160, 40, 150, 25);
        contentPane.add(SearchC);

        contentPane.add(s);
        b1 = new JButton("Search");
        b1.setBounds(160, 100, 250, 25);
        contentPane.add(b1);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String SearchByStudent = (String) SearchC.getSelectedItem();

                if (SearchByStudent == "Select") {

                    JOptionPane.showMessageDialog(getParent(), " pleace Select any Option", "Error", JOptionPane.ERROR_MESSAGE);

                } else {

                    if (SearchByStudent == "all") {

                        DBINFO.getValueStudent(SearchByStudent, "");
                        JFrame frm = new JFrame();
                        frm.setSize(900, 600);
                        frm.setLocationRelativeTo(getParent());
                        //now create a JTable
                        JTable tabel = new JTable(DBINFO.Record, DBINFO.header);
                        JScrollPane pane = new JScrollPane(tabel);
                        frm.add(pane);
                        frm.setVisible(true);

                    } else if (SearchByStudent == "BID") {

                        String value = JOptionPane.showInputDialog("ente book NO");
                        if (value.isEmpty()) {
                            JOptionPane.showMessageDialog(getParent(), "pleage enter book no ", "Error", JOptionPane.ERROR_MESSAGE);

                        } else {
                            DBINFO.getValueStudent(SearchByStudent, value);
                            JFrame frm = new JFrame();
                            frm.setSize(900, 600);
                            frm.setLocationRelativeTo(getParent());
                            //now create a JTable
                            JTable tabel = new JTable(DBINFO.Record, DBINFO.header);
                            JScrollPane pane = new JScrollPane(tabel);
                            frm.add(pane);
                            frm.setVisible(true);

                        }

                    } else {

                        if (SearchByStudent == "BookT") {

                            C = new JComboBox(DBINFO.getTitle());

                        }
                        if (SearchByStudent == "SUB") {

                            C = new JComboBox(DBINFO.getsubject());;

                        }

                        if (SearchByStudent == "Author") {

                            C = new JComboBox(DBINFO.getAuthor());

                        }
                        if (SearchByStudent == "Publication") {

                            C = new JComboBox(DBINFO.getpublication());

                        }
                        if (SearchByStudent == "category") {

                            C = new JComboBox(DBINFO.getcategory());

                        }

                        B = new JLabel("Select" + SearchByStudent + "Name");
                        C.insertItemAt("select", 0);
                        B.setBounds(10, 20, 250, 25);
                        C.setBounds(300, 20, 250, 25);
                        C.setSelectedIndex(0);
                        JFrame fr = new JFrame();
                        fr.setBounds(10, 10, 600, 200);
                        fr.setLocationRelativeTo(getParent());
                        fr.setVisible(true);
                        fr.add(B);
                        fr.add(C);

                        C.addItemListener(new ItemListener() {
                            public void itemStateChanged(ItemEvent e) {

                                String value = (String) C.getSelectedItem();

                                DBINFO.getValueStudent(SearchByStudent, value);

                                JFrame frm = new JFrame();
                                frm.setSize(900, 600);
                                frm.setLocationRelativeTo(getParent());
                                //now create a JTable
                                JTable tabel = new JTable(DBINFO.Record, DBINFO.header);
                                JScrollPane pane = new JScrollPane(tabel);
                                frm.add(pane);
                                frm.setVisible(true);
                                fr.setVisible(false);

                            }
                        });

                    }

                }
            }
        });

    }

}
