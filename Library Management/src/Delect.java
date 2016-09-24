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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class Delect extends JFrame {

    private JPanel contentPane;
    JLabel bI, BT, P, Pr, Author, C, SUB;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton b1, b2, b3;

    JMenuBar mb;
    JMenu file, AddItem, help, home;
    JMenuItem author, subject, category, publication;

    JMenuItem Home, BNF;

    /**
     * Launch the application.
     */
    /*   
     public static void main(String[] args) {
		
     try {
     Delect frame = new Delect("DElect Book" ,"prachi");
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
    public Delect(String title, String username) {
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

        BNF = new JMenuItem("WHAT IS BOOK ID");
        BNF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                int ans = JOptionPane.showConfirmDialog(getParent(), "PLEACE SEARCH BOOK ID FROM THE SEARCH PANEL AND PUT IN THIS FILL BOX \n why do you Want Search book Id ", "SEARCH MESSAGE", JOptionPane.INFORMATION_MESSAGE);

                if (ans == JOptionPane.YES_OPTION) {

                    SearchByAdmin frame = new SearchByAdmin("Search Book", username);
                    frame.setVisible(true);

                } else {
                    Delect frame = new Delect("Delect Book", username);
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
        help.add(BNF);
        //add new menu bar
        home.add(Home);

        mb.add(file);
        mb.add(home);
        mb.add(help);
        contentPane.add(mb);

        //label of book
        bI = new JLabel("Book ID");
        SUB = new JLabel("SUBJECT");
        BT = new JLabel("Book Title");
        P = new JLabel("Publication");
        C = new JLabel("category");
        Author = new JLabel("Author");
        Pr = new JLabel("Prize");

        //book ID
        b3 = new JButton("search Book");

        b3.setBounds(650, 40, 250, 25);
        t1 = new JTextField(10);
        t1.setBounds(350, 40, 250, 25);
        bI.setBounds(160, 40, 150, 25);
        contentPane.add(bI);
        contentPane.add(t1);
        contentPane.add(b3);

        b3.addActionListener(new ActionListener() {
            String s2, s3, s4, s5, s6, s7;
            int Flag = 0;

            public void actionPerformed(ActionEvent arg0) {

                String id = t1.getText();

                if (id.equalsIgnoreCase(null)) {
                    JOptionPane.showMessageDialog(getParent(), "Enter book no", "Error", JOptionPane.ERROR_MESSAGE);

                } else {
                    String query = " SELECT * FROM `book` where BID= ? ";

                    try {
                        PreparedStatement ps = DBINFO.getConnection().prepareStatement(query);
                        ps.setString(1, id);

                        ResultSet res = ps.executeQuery();

                        while (res.next()) {

                            s2 = res.getString(3);
                            s3 = res.getString(4);
                            s4 = res.getString(5);
                            s5 = res.getString(6);
                            s6 = res.getString(7);
                            s7 = res.getString(8);
                            Flag = 1;
                            break;

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (Flag == 1) {

                        t2.setText(s2);
                        t3.setText(s3);
                        t4.setText(s4);
                        t5.setText(s5);
                        t6.setText(s6);
                        t7.setText(s7);

                    } else {

                        JOptionPane.showMessageDialog(getParent(), "book not  Found Pleace TRy AGAIN ", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        });

        //book Title
        t2 = new JTextField(10);
        t2.setBounds(350, 80, 250, 25);
        BT.setBounds(160, 80, 150, 25);
        contentPane.add(BT);
        contentPane.add(t2);
        t2.setEditable(false);

        //SUBJECT
        t3 = new JTextField(10);
        t3.setBounds(350, 120, 250, 25);

        SUB.setBounds(160, 120, 150, 25);
        contentPane.add(SUB);
        contentPane.add(t3);

        t3.setEditable(false);

        //Author
        t4 = new JTextField(10);
        t4.setBounds(350, 160, 250, 25);

        Author.setBounds(160, 160, 150, 25);
        contentPane.add(Author);

        contentPane.add(t4);
        t4.setEditable(false);

		  //Publication 
        t5 = new JTextField(10);
        t5.setBounds(350, 200, 250, 25);

        P.setBounds(160, 200, 150, 25);
        contentPane.add(P);

        contentPane.add(t5);
        t5.setEditable(false);

        //category
        t6 = new JTextField(10);
        t6.setBounds(350, 240, 250, 25);

        C.setBounds(160, 240, 150, 25);
        contentPane.add(C);

        contentPane.add(t6);
        t6.setEditable(false);

	//Prize
        t7 = new JTextField(10);
        t7.setBounds(350, 280, 250, 25);
        Pr.setBounds(160, 280, 150, 25);
        contentPane.add(Pr);
        contentPane.add(t7);
        t7.setEditable(false);

        b1 = new JButton("DELETE");
        b1.setBounds(100, 360, 200, 40);
        contentPane.add(b1);

        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                String id = t1.getText();

                //System.out.println("Author is ="+Aut);	
                String query = "DELETE  from  book  where BID= ?   ";
                Connection con = DBINFO.getConnection();
                int i = 0;
                int j = 0;

                try {

                    PreparedStatement ps = con.prepareStatement(query);

                    ps.setString(1, id);

                    i = ps.executeUpdate();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                j = DBINFO.DeletIssueBook(id);
                if (i == 1 && j == 1) {

                    JOptionPane.showMessageDialog(getParent(), "Delete success");
                    t1.setText(null);
                    t2.setText(null);
                    t3.setText(null);
                    t4.setText(null);
                    t5.setText(null);
                    t6.setText(null);
                    t7.setText(null);

                }
                if (i == 0) {
                    JOptionPane.showMessageDialog(getParent(), "Your book not Delete", "Error", JOptionPane.ERROR_MESSAGE);

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
                t5.setText(null);
                t6.setText(null);
                t7.setText(null);

            }
        });

        b1.setBounds(100, 360, 200, 40);
        b2.setBounds(350, 360, 200, 40);
        contentPane.add(b1);
        contentPane.add(b2);

    }
}
