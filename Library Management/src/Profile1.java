

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


public class Profile1 extends JFrame {

	private JPanel contentPane;
JTextField t1,t2,t3,t4;
	JButton b1,b2,b3;
	String CollegeID,Name,Branch,Year;

	
	   JMenu file,AddItem, help;  
	      JMenuItem Home,issueBOOK,Update,Delete,AddnewItem,home;
	      JMenuBar mb;  
	
	

	/**
	 * Launch the application.
	 */
/*
	public static void main(String[] args) {
		
				try {
					Profile frame = new Profile("Search Book" );
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
*/

	/* Create the frame.*/
	 
	
	//Constructer 
	public Profile1( String title  ,String username ) {
		super(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 714, 505);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLayout(null);
		
		
		
		///Select Student profile from Student
		
			
			
			
			
				
		
	Home = new JMenuItem("Home");  
		
		Home.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			
			{
				
					StudentSection frame= new  StudentSection("Student Section",username);
	    	 frame.setVisible(true);
	    	 dispose();
			}
			});
		
		issueBOOK = new JMenuItem("   Issue Book");  
		
		issueBOOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			
			{
				issueBOOK frame = new issueBOOK(" Issue book",username );
 				frame.setVisible(true);
 				dispose();	
			
			}
			});
		
		AddnewItem = new JMenuItem("Add New Book");  
		
		AddnewItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			
			{
				
				AddnewBook frame = new AddnewBook("AddNeBook",username );
				frame.setVisible(true);
				dispose();	
			}
			});
		
		Update = new JMenuItem("Update Book");  
			
		Update.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0)
				
				{
					
	 				Update frame = new Update("Update Book",username );
	 				frame.setVisible(true);
	 				dispose();	
	 					
				
				}
				});
	Delete = new JMenuItem("Delete Book");  
		
		Delete.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0)
				
				{
					
					Delect frame = new Delect("Delect Book",username );
	 				frame.setVisible(true);
	 				dispose();	
	 					
				
				}
				});
  
	     mb=new JMenuBar();  
         mb.setBounds(0,0,514,20);  
        file=new JMenu("File");  
       home=new JMenu("Home");  
         help=new JMenu("Help"); 
		 //add new menu bar
         home.add(Home); home.add(Delete); home.add(Update); home.add( AddnewItem);  
  home.add(issueBOOK);

mb.add(file);mb.add(home);mb.add(help);
contentPane.add(mb);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	int	Flag=0;
	
		
		
		
		
		
		
		
		
 ImageIcon icon = new ImageIcon("person.jpg");
JLabel	P = new JLabel( icon);	
	P.setBounds(10, 10, 100, 100);
	contentPane.add(P);
	
JLabel	n = new JLabel("Name");	
JLabel	C = new JLabel("College ID" );	
 JLabel   B = new JLabel("Branch");	
JLabel	Y = new JLabel("Year" );
t1=  new JTextField(10);
t2=  new  JTextField(10);
t3= new JTextField(10);
t4=new  JTextField(10);

n.setBounds(200, 20, 100, 25);
	contentPane.add(n);	
	t1.setBounds(400, 20, 200, 25);
	contentPane.add(t1);
 t1.setEditable(false);	
 
 
 C.setBounds(200, 50, 100, 25);
	contentPane.add(C);	
	t2.setBounds(400, 50, 200, 25);
	contentPane.add(t2);
 t2.setEditable(false);	
		
		
		B.setBounds(200, 80, 100, 25);
	    contentPane.add(B);	
	    t3.setBounds(400, 80, 200, 25);
	    contentPane.add(t3);
        t3.setEditable(false);	
		
		
			Y.setBounds(200, 110, 100, 25);
	    contentPane.add(Y);	
	    t4.setBounds(400, 110, 200, 25);
	    contentPane.add(t4);
        t4.setEditable(false);	
		
		b1=   new JButton("Edit Profile");
		  b1.setBounds(100, 150, 200, 25);
	    contentPane.add(b1);
			b1.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0)
	
			{
				
				
				EditProfile frame= new  EditProfile("Edit Profile",username);
	    	 frame.setVisible(true);
	    	 dispose();
				
			}});
			
			
			
			 	b2=   new JButton("Home");
		  b2.setBounds(100, 200, 200, 25);
	    contentPane.add(b2);
			b2.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0)
	
			{
				
				
			StudentSection frame= new  StudentSection("Student Section",username);
	    	 frame.setVisible(true);
	    	 dispose();
				
			}});
		
				
		Connection con = DBINFO.getConnection();
		java.sql.PreparedStatement ps = null;
	        
		ResultSet res;
		
		String query = "SELECT * FROM `student` where username = ?";
		 


		 try
		 {
		 	 ps = con.prepareStatement(query);
			
					ps.setString(1, username);
					  res = ps.executeQuery();
					while(res.next())
					{
						Flag=1;
						CollegeID = res.getString(1);
						Name = res.getString(2);
						Branch = res.getString(4);
						Year = res.getString(5);
						break;
					}
					
		 	

		 }catch(Exception e){
		 	e.printStackTrace();
		 }
if(Flag==1)
{
	
	t1.setText(CollegeID);
	
	t2.setText(Name);
	
	t3.setText(Branch);
	t4.setText(Year);
	
}
		
		}
}
