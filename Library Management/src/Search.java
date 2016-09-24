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
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;


public class Search extends JFrame {

	private JPanel contentPane;
	JLabel bI,BT,P,Pr,Q,Author,C,SUB;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JButton b1,b2,b3,b4;
	  JMenuBar mb;  
      JMenu file,AddItem, help;  
      JMenuItem Home,Search,Update,Delete,AddnewItem,home, BNF;
	  String s1;

	/**
	 * Launch the application.
	 */
/*
	public static void main(String[] args) {
		
				try {
					Search frame = new Search("Search Book","laxman" );
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
	public Search( String title ,String username ) {
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
				
				AdminSection obj=new AdminSection("Admin Account",username);
				obj.setVisible(true);
				dispose();
			}
			});
		
		Search = new JMenuItem("Search Book");  
		
		Search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			
			{
				Search frame = new Search("Search Book",username );
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
					
	 				Update frame = new Update("Update Book" ,username);
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
		 
		 BNF = new JMenuItem("WHAT IS BOOK ID");  
		   BNF.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0)
				
				{
					
		
	 				int ans = JOptionPane.showConfirmDialog(getParent(),"PLEACE SEARCH BOOK ID FROM THE SEARCH PANEL AND PUT IN THIS FILL BOX \n why do you Want Search book Id ","SEARCH MESSAGE",JOptionPane.INFORMATION_MESSAGE);	
				
				
				if(ans==JOptionPane.YES_OPTION)
	{
		
	SearchByStudent frame = new SearchByStudent("Search Book",username );
 				frame.setVisible(true);
 			
		
	}
	else
	{
	Search frame = new Search("Search Book",username );
 				frame.setVisible(true);
 				dispose();	
		
	}
				
				
				}
				});
		 
		 //add new menu bar
         home.add(Home); home.add(Delete); home.add(Update); home.add( AddnewItem);  
   help.add(BNF);
mb.add(file);mb.add(home);mb.add(help);
contentPane.add(mb);

			 
	   
	   
		//label of book
		bI= new JLabel("Book ID");
		SUB = new JLabel("SUBJECT");
		BT = new JLabel("Book Title");
		P = new JLabel("Publication");
		C = new JLabel("category");
		Author = new JLabel("Author");
		Pr = new JLabel("Prize");
		Q = new JLabel("Quantity");
		

		 
		 
		//book ID
	    t1 = new JTextField(10);
	 
	    
		t1.setBounds(320,40,100,20);
		bI.setBounds(160,40,100,20);
		contentPane.add(bI);
		contentPane.add( t1);
		
		
		

		
		
		  //book Title
		t2 = new JTextField(10);
	t2.setBounds(320,80,100,20);
	BT.setBounds(160,80,100,20);
			contentPane.add(BT);
		     contentPane.add(t2);
		     t2.setEditable(false);
		
		
		 //SUBJECT
		 	t3 = new JTextField(10);
			t3.setBounds(320,120,100,20);
		
		SUB.setBounds(160,120,100,20);
		contentPane.add(SUB);
		contentPane.add(t3);
		
		t3.setEditable(false);
		
		
		
		  //Author
		t4 = new JTextField(10);
		t4.setBounds(320,160,100,20);
		
	Author.setBounds(160,160,100,20);
		contentPane.add(Author);
	
		contentPane.add(t4);
		t4.setEditable(false);
		
		 
		
		
		  //Publication 
		
		t5 = new JTextField(10);
		t5.setBounds(320,200,100,20);
	
		P.setBounds(160,200,100,20);
	contentPane.add(P);
	
	contentPane.add(t5);
	t5.setEditable(false);
	
	
	   //category
	t6 = new JTextField(10);
	t6.setBounds(320,240,100,20);
		
		C.setBounds(160,240,100,20);
	contentPane.add(C);

	contentPane.add(t6);
	t6.setEditable(false);
	
	//Prize
	
	
	   t7 = new JTextField(10);
		t7.setBounds(320,280,100,20);
	Pr.setBounds(160,280,180,20);
		contentPane.add(Pr);
		contentPane.add(t7);
		t7.setEditable(false);
		
		//Quantity of Book
		   t8 = new JTextField(10);
		t8.setBounds(320,320,100,20);
		Q.setBounds(160,320,100,20);
			contentPane.add(Q);
		contentPane.add(t8);
		t8.setEditable(false);
		
		
		
		b3 = new JButton("issue book");
		   b3.setBounds(100,360,100,20);
		        contentPane.add(b3);
		        b3.setVisible(false);
				 b3.addActionListener(new ActionListener(){
			
		
				int i = 0;
				public void actionPerformed(ActionEvent arg0)
				
				{
				
			
				
				String query = " INSERT INTO `IssueB` (username,BID) VALUES(?,?) ";
					
					try
					{
						PreparedStatement ps = DBINFO.getConnection().prepareStatement(query);
						 ps.setString(1, username);
		                 ps.setString(2, s1);
		                  i =  ps.executeUpdate();
					
						
							
						
						
					}catch(Exception e){
						e.printStackTrace();
					}
					
					if(i==1)
					{
						
				JOptionPane.showMessageDialog(getParent(),"PLEACE SUBMIT BOOK AT GIVEN TIME "," MESSAGE",JOptionPane.INFORMATION_MESSAGE);	
				t1.setText(null);
					t2.setText(null);
					t3.setText(null);
					t4.setText(null);
					t5.setText(null);
					t6.setText(null);
					t7.setText(null);
					t8.setText(null);	
			b3.setVisible(false);
			b4.setVisible(false);
			
					}
					else
					{
						
						 JOptionPane.showMessageDialog( getParent(),"book not  Found Pleace TRy AGAIN " ,"Error",JOptionPane.ERROR_MESSAGE);  
					}	
		
				}
				 
				 
				  
				});
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		
						b4 = new JButton("Submit book");
		
		b4.setBounds(100,360,100,20);
		contentPane.add(b4);
		b4.setVisible(false);
		
		b4.addActionListener(new ActionListener(){
			int i =0;
			public void actionPerformed(ActionEvent arg0)
			{
				
				
				
					String query = " DELETE  FROM issueb where BID= ? and username = ? ";
					
					try
					{
						PreparedStatement ps = DBINFO.getConnection().prepareStatement(query);
						
						 ps.setString(1, s1);
		                 ps.setString(2,username);
		                  i =  ps.executeUpdate();
						
					}catch(Exception e){
						e.printStackTrace();
					}
					if(i==1)
					{
						
				JOptionPane.showMessageDialog(getParent(),"YOU are SucceFull submit book "," MESSAGE",JOptionPane.INFORMATION_MESSAGE);	
				t1.setText(null);
					t2.setText(null);
					t3.setText(null);
					t4.setText(null);
					t5.setText(null);
					t6.setText(null);
					t7.setText(null);
					t8.setText(null);	
			b3.setVisible(false);
			b4.setVisible(false);	
						
					}
				
				
			}
			
			
			
		});
	
		
		b1=new JButton("Search Book");
		
		 b1.addActionListener(new ActionListener(){
			
			 String s2,s3,s4,s5,s6,s7,s8,l1,l2;
				int Flag = 0;
				int Flag1 = 0;
				public void actionPerformed(ActionEvent arg0)
				
				{
					
							String id = t1.getText();
					String query1 = " SELECT * FROM issueb where BID= ? and username = ? ";
					
					try
					{
						PreparedStatement ps = DBINFO.getConnection().prepareStatement(query1);
						ps.setString(1, id);
						ps.setString(2, username);
						
						 ResultSet  res = ps.executeQuery();
						
								while(res.next())
								{
							        l1 = res.getString(1);
									l2 = res.getString(2);
									Flag1=1;
									break;
								
								}
						
						
					}catch(Exception e){
						e.printStackTrace();
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					String query = " SELECT * FROM `book` where BID= ? ";
					
					try
					{
						PreparedStatement ps = DBINFO.getConnection().prepareStatement(query);
						ps.setString(1, id);
						
						 ResultSet  res = ps.executeQuery();
						
								while(res.next())
								{
									s1 = res.getString(1);
									s2 = res.getString(2);
									s3 = res.getString(3);
									s4 = res.getString(4);
									s5 = res.getString(5);
									s6 = res.getString(6);
									s7 = res.getString(7);
									s8 = res.getString(8);
									Flag=1;
									break;
								
								}
						
						
					}catch(Exception e){
						e.printStackTrace();
					}
					
					if(Flag==1&&Flag1==0)
					{
						
						t2.setText(s2);
						t3.setText(s3);
						t4.setText(s4);
						t5.setText(s5);
						t6.setText(s6);
						t7.setText(s7);
						t8.setText(s8);
						b4.setVisible(false);
					b3.setVisible(true);
					System.out.println("BOOK id = "+s1);
					
					}
					 else if(Flag1==1&&Flag==1)
					
					{
						t2.setText(s2);
						t3.setText(s3);
						t4.setText(s4);
						t5.setText(s5);
						t6.setText(s6);
						t7.setText(s7);
						t8.setText(s8);
						b4.setVisible(true);
					b3.setVisible(false);
					System.out.println("BOOK id = "+s1);	
						
						
					}					
					else
					{
						
						 JOptionPane.showMessageDialog( getParent(),"book not  Found Pleace TRy AGAIN " ,"Error",JOptionPane.ERROR_MESSAGE);  
					}	
		
				}
				 
				 
				  
				});

				
			
			b2=new JButton("Reset");
			b2.addActionListener(new ActionListener(){
				

				public void actionPerformed(ActionEvent arg0)
				
				{
					
			
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
					t4.setText(null);
					t5.setText(null);
					t6.setText(null);
					t7.setText(null);
					t8.setText(null);	
			b3.setVisible(false);
			b4.setVisible(false);
			
					
					
				}});

				b1.setBounds(440,40,200,20);
			
			b2.setBounds(250,360,100,20);
				contentPane.add(b1);
				contentPane.add(b2);
				
				
				
	}
}
