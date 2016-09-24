import java.awt.*;
import java.awt.EventQueue;

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

public class AdminSection extends JFrame {
 

	JPanel f;
	/*
	public static void main(String[] args) {  
	    try
	    {
	    	 AdminSection frame= new  AdminSection("admin Section","modi");
	    	 frame.setVisible(true);
	    			
	    }catch(Exception e){e.printStackTrace();}
	}
	
	*/
	 AdminSection( String title ,String username){  
	  
	     super(title);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	setBounds(100, 100, 714, 505);
	      f=new JPanel();
	      f.setBorder(new EmptyBorder(5,5,5,5));
	      setContentPane(f);
	      f.setLayout(new GridLayout(3,3,0,0));  
	      setLocationRelativeTo(this);
	    JButton b1=new JButton("Add New Book");  
	    
	    b1.addActionListener(new ActionListener(){
			

			public void actionPerformed(ActionEvent arg0)
			{
				
				
				AddnewBook frame = new AddnewBook("AddNeBook",username );
				frame.setVisible(true);
				dispose();	
				
				
			}});
	    
	    
	    JButton b2=new JButton("UPdate  Book");  
	    b2.addActionListener(new ActionListener(){
			

	 			public void actionPerformed(ActionEvent arg0)
	 			{
	 				
	 				
	 				Update frame = new Update("Update Book",username );
	 				frame.setVisible(true);
	 				dispose();	
	 				
	 				
	 			}});
	   
	    JButton b4=new JButton("Issue book");  
		  b4.addActionListener(new ActionListener(){
			

	 			public void actionPerformed(ActionEvent arg0)
	 			{
	 				
	 				
	 				ShowIssueBook	 frame = new ShowIssueBook	("ShowIssueBook	",username );
	 				frame.setVisible(true);
	 				dispose();	
	 				
	 				
	 			}});
	
	
	    JButton b5=new JButton("Search Book");  
	    b5.addActionListener(new ActionListener(){
			

	 			public void actionPerformed(ActionEvent arg0)
	 			{
	 				
	 				
	 				SearchByAdmin frame = new SearchByAdmin("Search Book",username );
	 				frame.setVisible(true);
	 				dispose();	
	 				
	 				
	 			}});
	    
	    
	        JButton b6=new JButton("DElect user Account");
			
			
			b6.addActionListener(new ActionListener(){
				

				public void actionPerformed(ActionEvent arg0)
				{
					
					
					DelectStudent frame = new DelectStudent("DelectStudent Account",username );
					frame.setVisible(true);
					dispose();	
					
					
				}});

			
	        JButton b7=new JButton("Delect book");
	        b7.addActionListener(new ActionListener(){
				

				public void actionPerformed(ActionEvent arg0)
				{
					
					
					Delect frame = new Delect("DElect Book",username );
					frame.setVisible(true);
					dispose();	
					
					
				}});
	    JButton b8=new JButton("Change Passworld");
	    
	    b8.addActionListener(new ActionListener(){
			

			public void actionPerformed(ActionEvent arg0)
			{
				
				
				ChangePasswordByAdmin frame = new ChangePasswordByAdmin("Search Book",username );
				frame.setVisible(true);
				dispose();	
				
				
			}});
	    
	    
	        JButton b9=new JButton("Search Student");  
			b9.addActionListener(new ActionListener(){
			

			public void actionPerformed(ActionEvent arg0)
			{
				
				
				SearchStudent frame = new SearchStudent("Search Student",username );
					frame.setVisible(true);
				dispose();	
				
				
			}});
			  JButton b3=new JButton("logout");  
			b3.addActionListener(new ActionListener(){
			

			public void actionPerformed(ActionEvent arg0)
			{
				
				
			Login r = new Login("Already member ? sign in");
		r.setVisible(true);
				dispose();
			
				
				
			}});
	          
	    f.add(b1);f.add(b2);f.add(b4);f.add(b5);  
	    f.add(b6);f.add(b7);f.add(b8);f.add(b9);  
		f.add(b3);
	 
	  
	    //setting grid layout of 3 rows and 3 columns  
	  
	    f.setSize(300,300);  
	    f.setVisible(true);  
	}
	  
		}