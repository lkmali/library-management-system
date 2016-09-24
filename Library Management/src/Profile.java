import java.awt.EventQueue;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

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
import javax.swing.filechooser.FileNameExtensionFilter;

public class Profile extends JFrame {

    private JPanel contentPane;
    JTextField t1, t2, t3, t4;
    JLabel P;
    JButton b1, b2, b3, b4;
    String CollegeID, Name, Branch, Year, image;

    JMenu file, AddItem, help;
    JMenuItem Home, issueBOOK, home;
    JMenuBar mb;

    /**
     * Launch the application.
     */
    /*
     public static void main(String[] args) {
		
     try {
     Profile frame = new Profile("Student Profile","laxman" );
     frame.setVisible(true);
     } catch (Exception e) {
     e.printStackTrace();
     }
     }


     /* Create the frame.*/
    //Constructer 
    public Profile(String title, String username) {
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

                StudentSection frame = new StudentSection("Student Section", username);
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

	//menu bar end		
//add student information	
        //ImageIcon icon = new ImageIcon("person.jpg");
        b4 = new JButton("Edit Photo");

        b4.setBounds(10, 20, 200, 200);
//b4.setBounds(10, 300, 100, 25);
        contentPane.add(b4);  //add user profile
//contentPane.add(P); 
        b4.setToolTipText("   Edit Profile  Photo ");
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "JPG, GIF, and PNG Images", "jpg", "gif", "png");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(contentPane);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    System.out.println("You chose to open this file: "
                            + file.getName());
                    BufferedImage image1;
                    try {
                        image1 = ImageIO.read(file);

                        b4.setIcon(new ImageIcon(((new ImageIcon(image1)).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
                        ImageIO.write(image1, "jpg", new File("I:\\Project\\Library Management\\Profile\\" + file.getName()));

                        int i = DBINFO.InsertPhoto(file.getName(), username);

                    } catch (IOException ex) {
                        Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        JLabel n = new JLabel("Name");
        JLabel C = new JLabel("College ID");
        JLabel B = new JLabel("Branch");
        JLabel Y = new JLabel("Year");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t4 = new JTextField(10);

        n.setBounds(400, 40, 200, 25);
        contentPane.add(n);
        t1.setBounds(500, 40, 300, 25);
        contentPane.add(t1);
        t1.setEditable(false);

        C.setBounds(400, 70, 200, 25);
        contentPane.add(C);
        t2.setBounds(500, 70, 300, 25);
        contentPane.add(t2);
        t2.setEditable(false);

        B.setBounds(400, 100, 200, 25);
        contentPane.add(B);
        t3.setBounds(500, 100, 300, 25);
        contentPane.add(t3);
        t3.setEditable(false);

        Y.setBounds(400, 130, 200, 25);
        contentPane.add(Y);
        t4.setBounds(500, 130, 300, 25);
        contentPane.add(t4);
        t4.setEditable(false);
        //end student information
        b1 = new JButton("Edit Profile");
        b1.setBounds(300, 200, 350, 25);
        contentPane.add(b1);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                EditProfile frame = new EditProfile("Edit Profile", username);
                frame.setVisible(true);
                dispose();

            }
        });

        Connection con = DBINFO.getConnection();
        java.sql.PreparedStatement ps = null;
        int Flag = 0;
        ResultSet res;

        String query = "SELECT * FROM `student` where username = ?";

        try {
            ps = con.prepareStatement(query);

            ps.setString(1, username);
            res = ps.executeQuery();
            while (res.next()) {
                Flag = 1;
                CollegeID = res.getString(1);
                Name = res.getString(2);
                image = res.getString(3);
                Branch = res.getString(5);
                Year = res.getString(6);
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Flag == 1) {

            t1.setText(CollegeID);
            t2.setText(Name);
            String s = "I:\\Project\\Library Management\\Profile\\" + image;
            t3.setText(Branch);
            t4.setText(Year);

            b4.setIcon(new ImageIcon(((new ImageIcon(s)).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));

        }

    }
}
