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

public class AddnewBook extends JFrame {

    private JPanel contentPane;
    JLabel bI, BT, P, Pr, Q, Author, C, SUB;
    JTextField t1, t2, t3, t4;
    JButton b1, b2, b3;
    JComboBox ca, cp, cc, cs, ct;
    JMenuBar mb;
    JMenu file, AddItem, help, home;
    JMenuItem author, subject, category, publication;
    JMenuItem Home, Search, Update, Delete, AddnewItem;

    /**
     * Launch the application.
     *//*
     public static void main(String[] args) {
		
     try {
     AddnewBook frame = new AddnewBook("AddNeBook","prachi" );
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
    public AddnewBook(String title, String username) {
        super(title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1000, 505);
        setLocationRelativeTo(this);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLayout(null);

		//add menu bar
        Home = new JMenuItem("Home");

        Home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                AdminSection obj = new AdminSection("Admin Account", username);
                obj.setVisible(true);
                dispose();
            }
        });

        //Author Action Event
        author = new JMenuItem("author");

        author.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                String option = arg0.getActionCommand();
                String value = JOptionPane.showInputDialog("Enter  " + "   " + option + "   name:");
                if (value.isEmpty()) {

                } else {
                    System.out.println(option + "::::" + value);

                    int i = DBINFO.insertValue(option, value);

                    System.out.println(i);
                    dispose();
                    new AddnewBook("AddNeBook", username).setVisible(true);
                }
            }

        });

// Subject Action Event		 
        subject = new JMenuItem("subject");

        subject.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                String option = arg0.getActionCommand();
                String value = JOptionPane.showInputDialog("Enter  " + "   " + option + "   name:");

                if (value.isEmpty()) {

                } else {
                    System.out.println(option + "::::" + value);

                    int i = DBINFO.insertValue(option, value);

                    System.out.println(i);
                    dispose();
                    new AddnewBook("AddNeBook", username).setVisible(true);
                }
            }

        });

		//	category  Action Event
        category = new JMenuItem("category");

        category.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                String option = arg0.getActionCommand();//It Will be Fetch the value From label
                String value = JOptionPane.showInputDialog("Enter  " + "   " + option + "   name:");
                if (value.isEmpty()) {

                } else {
                    System.out.println(option + "::::" + value);

                    int i = DBINFO.insertValue(option, value);

                    System.out.println(i);
                    dispose();
                    new AddnewBook("AddNeBook", username).setVisible(true);
                }
            }

        });

        //Publication Action Event
        publication = new JMenuItem("publication");
        publication.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                String option = arg0.getActionCommand();
                String value = JOptionPane.showInputDialog("Enter  " + "   " + option + "   name:");
                if (value.isEmpty()) {

                } else {
                    System.out.println(option + "::::" + value);

                    int i = DBINFO.insertValue(option, value);

                    System.out.println(i);
                    dispose();
                    new AddnewBook("AddNeBook", username).setVisible(true);
                }

            }
        });

       //create menu bar
        mb = new JMenuBar();
        mb.setBounds(0, 0, 514, 20);
        file = new JMenu("File");
        home = new JMenu("Home");
        AddItem = new JMenu("Add New");
        help = new JMenu("Help");
        //add new menu bar
        AddItem.add(author);
        AddItem.add(subject);
        AddItem.add(category);
        AddItem.add(publication);
        home.add(Home);

        mb.add(file);
        mb.add(home);
        mb.add(AddItem);
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

//generate random Book id		
        String bid = "";
        for (int i = 0; i < 7; i++) {
            bid += (int) (Math.random() * 9) + 1;

        }
        System.out.println("Book id is=" + bid);
        //Combo box
        ca = new JComboBox(DBINFO.getAuthor());
        ca.insertItemAt("select", 0);
        ca.setSelectedIndex(0);

        cc = new JComboBox(DBINFO.getcategory());
        cc.insertItemAt("select", 0);
        cc.setSelectedIndex(0);

        cs = new JComboBox(DBINFO.getsubject());
        cs.insertItemAt("select", 0);
        cs.setSelectedIndex(0);

        cp = new JComboBox(DBINFO.getpublication());
        cp.insertItemAt("select", 0);
        cp.setSelectedIndex(0);

		// get book Title From The Dbms
        ct = new JComboBox(DBINFO.getTitle());
        ct.insertItemAt("select", 0);
        ct.setSelectedIndex(0);
        ct.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                String title = (String) ct.getSelectedItem();
                System.out.println(title);

                if (title.equalsIgnoreCase("Select")) {

                } else {
                    t4.setText(title);
                }

            }
        });

        //book ID
        t1 = new JTextField(10);
        t1.setBounds(320, 40, 250, 25);
        bI.setBounds(160, 40, 150, 25);
        contentPane.add(bI);
        t1.setText(bid);
        t1.setEditable(false);
        contentPane.add(t1);

        //book Title
        t4 = new JTextField(10);
        t4.setBounds(320, 80, 250, 25);
        BT.setBounds(160, 80, 150, 25);
        contentPane.add(BT);
        contentPane.add(t4);

        ct.setBounds(620, 80, 250, 25);
        contentPane.add(ct);

        //SUBJECT
        cs.setBounds(320, 120, 250, 25);
        SUB.setBounds(160, 120, 150, 25);
        contentPane.add(SUB);
        contentPane.add(cs);

        //Author
        ca.setBounds(320, 160, 250, 25);
        Author.setBounds(160, 160, 150, 25);
        contentPane.add(Author);
        contentPane.add(ca);

        //Publication 
        cp.setBounds(320, 200, 250, 25);
        P.setBounds(160, 200, 150, 25);
        contentPane.add(P);
        contentPane.add(cp);

        //category
        cc.setBounds(320, 240, 250, 25);
        C.setBounds(160, 240, 150, 25);
        contentPane.add(C);
        contentPane.add(cc);

	//Prize
        t2 = new JTextField(10);
        t2.setBounds(320, 280, 250, 25);
        Pr.setBounds(160, 280, 150, 25);
        contentPane.add(Pr);
        contentPane.add(t2);

        b1 = new JButton("save");

        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                String id = t1.getText();
                String sub = (String) cs.getSelectedItem();
                String Aut = (String) ca.getSelectedItem();

                String publication = (String) cp.getSelectedItem();

                String cat = (String) cc.getSelectedItem();
                String prize = t2.getText();

                String TIT = t4.getText();

                if (Aut.equalsIgnoreCase("select") || sub.equalsIgnoreCase("select") || cat.equalsIgnoreCase("select") || publication.equalsIgnoreCase("select") || prize.equalsIgnoreCase(null)) {

                    JOptionPane.showMessageDialog(getParent(), " pleace Select any Option or Enter value in Text box", "Error", JOptionPane.ERROR_MESSAGE);

                } else {
                    //System.out.println("Author is ="+Aut);	
                    String query = "insert into Book(`BID`, `BookT`, `SUB`, `Author`, `Publication`, `category`, `Prize`  ) values(?,?,?,?,?,?,?)";
                    Connection con = DBINFO.getConnection();
                    int i = 0;
                    int l = 0;
                    int n = 0;

                    try {

                        PreparedStatement ps = con.prepareStatement(query);
                        ps.setString(1, id);
                        ps.setString(2, TIT);
                        ps.setString(3, sub);
                        ps.setString(4, Aut);
                        ps.setString(5, publication);
                        ps.setString(6, cat);
                        ps.setString(7, prize);

                        i = ps.executeUpdate();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    n = DBINFO.CheckTitle(TIT);
                    l = DBINFO.SubmitBook(id);
                    if (i != 0 && l != 0 && n == 0) {

                        int m = DBINFO.inserTitle(TIT);
                        System.out.println(m);
                        System.out.println("Title  add");
                        JOptionPane.showMessageDialog(getParent(), "book added");

                        t1.setText(null);
                        t2.setText(null);
                        t4.setText(null);
                        ca.setSelectedIndex(0);
                        cc.setSelectedIndex(0);
                        cp.setSelectedIndex(0);
                        cs.setSelectedIndex(0);
                        dispose();
                        new AddnewBook("AddNeBook", username).setVisible(true);
                    } else if (i != 0 && l != 0 && n == 1) {

                        System.out.println("Title not add");
                        JOptionPane.showMessageDialog(getParent(), "book added");
                        t1.setText(null);
                        t2.setText(null);
                        t4.setText(null);
                        ca.setSelectedIndex(0);
                        cc.setSelectedIndex(0);
                        cp.setSelectedIndex(0);
                        cs.setSelectedIndex(0);
                        dispose();
                        new AddnewBook("AddNeBook", username).setVisible(true);

                    }
                    if (i == 0) {
                        JOptionPane.showMessageDialog(getParent(), "book not  added", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                }

            }
        });

        b2 = new JButton("Reset");
        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                t2.setText(null);
                t4.setText(null);
                ca.setSelectedIndex(0);
                cc.setSelectedIndex(0);
                cp.setSelectedIndex(0);
                cs.setSelectedIndex(0);

            }
        });

        b3 = new JButton("save");

        b1.setBounds(100, 360, 100, 20);
        b2.setBounds(250, 360, 100, 20);
        b3.setBounds(350, 260, 200, 20);
        contentPane.add(b1);
        contentPane.add(b2);

    }
}
