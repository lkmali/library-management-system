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


public class ChangePasswordByStudent extends JFrame {

	private JPanel contentPane;
	JLabel l1,l2,l3,l4;
	JPasswordField p1,p2,p3;
	JButton b1,b2;
	  String s2,s3  ;
	  JMenu file,AddItem, help;  
	      JMenuItem Home,issueBOOK,home;
	      JMenuBar mb;  
	
	

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		
				try {
					ChangePasswordByStudent frame = new ChangePasswordByStudent("Change Password  ","laxman" );
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}

	/**
	 * Create the frame.
	 */
	
	//Constructer 
	public ChangePasswordByStudent( String title ,String username ) {
		super(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 714, 505);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLayout(null);
		
	
	
	
		Home = new JMenuItem("Home");  
		
		Home.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			
			{
				
					StudentSection frame= new StudentSection(" StudentSection ",username);
	    	 frame.setVisible(true);
	    	 dispose();
			}
			});
		
		issueBOOK = new JMenuItem("Issue Book");  
		
		issueBOOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			
			{
				issueBOOK frame = new issueBOOK(" Issue book",username );
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
         home.add(Home);  
  home.add(issueBOOK);

mb.add(file);mb.add(home);mb.add(help);
contentPane.add(mb);
	
	
	
	
	
	
	
		l2 = new JLabel("enter Old Password");
		l3 = new JLabel("enter New Password");
		l4 = new JLabel("enter ReEnter Password");
	
		p1=new JPasswordField(20);
		p2=new JPasswordField(20);
		p3=new JPasswordField(20);
	
		//set userName Field
	
		
		
		//set Old Password Field
		l2.setBounds(100, 80, 200, 25);
		p1.setBounds(350, 80, 200, 25);
		contentPane.add(l2);
		contentPane.add(p1);
		//set New Password Field
				l3.setBounds(100, 120, 200, 25);
				p2.setBounds(350, 120, 200, 25);
				contentPane.add(l3);
				contentPane.add(p2);
				//set New Password Field
				l4.setBounds(100, 160, 200, 25);
				p3.setBounds(350, 160, 200, 25);
				contentPane.add(l4);
				contentPane.add(p3);
		
		
		
			
			
			
		
	
		
		 
		 
	
			
				 
				 
				 
				 
	b1=new JButton("update");	 
	b1.setBounds(100, 200, 100, 25);
	contentPane.add(b1);
	 b1.addActionListener(new ActionListener(){
				

				public void actionPerformed(ActionEvent arg0)
				
				{
					int Flag1=0;
					
					int Flag=0;
					char ch2[] = p2.getPassword();
					String password1 = String.copyValueOf(ch2);
					 
					 
						char ch3[] = p3.getPassword();
						 String password2 = String.copyValueOf(ch3);
						
					char ch[] = p1.getPassword();
					String  password = String.copyValueOf(ch);
						 System.out.println("password1="+password1+"\npassword2="+password2);
						 
						 
						 //get Old Password From Database
						 String query1 = " SELECT * FROM `login` where username= ? and password= ?";
					
					try
					{
						PreparedStatement ps = DBINFO.getConnection().prepareStatement(query1);
						ps.setString(1,username );
						ps.setString(2,password  );
						
						 ResultSet  res = ps.executeQuery();
						
								while(res.next())
								{
									
									s2 = res.getString(2);
									s3 = res.getString(3);
									
									Flag=1;
									break;
								
								}
						
						
					}catch(Exception e){
						e.printStackTrace();
					}
					
					
					
					if(Flag==0)
					{
						 	
						 JOptionPane.showMessageDialog( getParent()," your Password Does not Math your Account " ,"Error",JOptionPane.ERROR_MESSAGE);  
					
					p1.setText(null);
					p2.setText(null);
					p3.setText(null);
					}
					
					
					else
					{
					
					
					
					
					if( password1.equals(password2))
					{ 
						
						String query = " UPDATE  `login` SET  password=?  where username= ? and password=? ";	
						try
						{
							PreparedStatement ps = DBINFO.getConnection().prepareStatement(query);
							ps.setString(1,password1  );
							ps.setString(2,s2 );
							ps.setString(3,s3  );
							Flag1=  ps.executeUpdate();
							
							
						}catch(Exception e){
							e.printStackTrace();
						}
						 
						if(Flag1==1)
						{
							
							 JOptionPane.showMessageDialog( getParent()," your Password  Has Been Update" ,"MESSAGE",JOptionPane.INFORMATION_MESSAGE);  	
							 		StudentSection frame= new StudentSection(" StudentSection ",username);
	    	 frame.setVisible(true);
	    	 dispose();
						}
						else
						{
							 JOptionPane.showMessageDialog( getParent()," your Password Does not Update Pleace Try Again " ,"Error",JOptionPane.ERROR_MESSAGE);  
							
						}
						
					}
					
					else
					{
						
					p2.setText(null);
					p3.setText(null);
						 JOptionPane.showMessageDialog( getParent()," your Password and ReENTER password Does noe Match " ,"Error",JOptionPane.ERROR_MESSAGE);  	
						
					}
					}
			 
			 
		 }});
	 b2=new JButton("RESET");	 
		b2.setBounds(250, 200, 100, 25);
		contentPane.add(b2);
		
		
		 b2.addActionListener(new ActionListener(){
				

				public void actionPerformed(ActionEvent arg0)
				
				{
					
				
					p1.setText(null);
					p2.setText(null);
					p3.setText(null);
					
					
				}});
		

	}

	
}
