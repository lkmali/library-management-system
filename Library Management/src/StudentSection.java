import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class StudentSection extends JFrame {
 

	JPanel f;
/*	
	public static void main(String[] args) {  
	    try
	    {
	    	StudentSection frame= new  StudentSection("admin Section","laxman");
	    	 frame.setVisible(true);
	    			
	    }catch(Exception e){e.printStackTrace();}
	}
	*/ 
	
	 StudentSection( String title ,String username){  
	  
	     super(title);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	setBounds(100, 100, 714, 505);
	      f=new JPanel();
	      f.setBorder(new EmptyBorder(5,5,5,5));
	      setContentPane(f);
	      f.setLayout(new GridLayout(3,3,0,0));  
	      setLocationRelativeTo(this);
	    JButton b1=new JButton("Profile");  
	    
	    b1.addActionListener(new ActionListener(){
			

			public void actionPerformed(ActionEvent arg0)
			{
				
				
			     Profile frame= new  Profile("  Student  Profile",username);
	    	 frame.setVisible(true);
	    	 dispose();
				
				
			}});
	    
	    

	    
	    JButton b2=new JButton("Issue book"); 


   b2.addActionListener(new ActionListener(){
			

			public void actionPerformed(ActionEvent arg0)
			{
				
				
			issueBOOK frame = new issueBOOK("ISSue Book",username );
					frame.setVisible(true);
	    	 dispose();	
				
				
			}});

		
	    JButton b3=new JButton("Search Book");  
	    b3.addActionListener(new ActionListener(){
			

	 			public void actionPerformed(ActionEvent arg0)
	 			{
	 				
	 				
	 				SearchByStudent frame = new SearchByStudent("Search Book",username );
	 				frame.setVisible(true);
	 				dispose();	
	 				
	 				
	 			}});
	    
	    
	        
	       
	    JButton b4=new JButton("Change Password");
	    
	    b4.addActionListener(new ActionListener(){
			

			public void actionPerformed(ActionEvent arg0)
			{
				
				
				ChangePasswordByStudent frame = new ChangePasswordByStudent("Change Password",username );
				frame.setVisible(true);
				dispose();	
				
				
			}});
	    
	    
	       	  JButton b5=new JButton("logout");  
			b5.addActionListener(new ActionListener(){
			

			public void actionPerformed(ActionEvent arg0)
			{
				
				
				
			Login r = new Login("Already member ? sign in");
		r.setVisible(true);
				dispose();
                          				
				
				
			}});
	          
	    f.add(b1);f.add(b2);f.add(b3);  
	   f.add(b4); f.add(b5); 
	 
	  
	    //setting grid layout of 3 rows and 3 columns  
	  
	    f.setSize(300,300);  
	    f.setVisible(true);  
	}
	  
		}