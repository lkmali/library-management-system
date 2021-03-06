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


public class Update extends JFrame {

	private JPanel contentPane;
	JLabel bI,BT,P,Pr,Q,Author,C,SUB;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton b1,b2,b3;
	   JComboBox ca,cp,cc,cs,ct;  
	    JMenuBar mb;  
       JMenu file,AddItem, help;  
       JMenuItem 	author,subject,category,publication;
       JMenuItem Home,BNF, home;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
				try {
					Update frame = new Update("Update Book","prachi" );
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}

	/**
	 * Create the frame.
	 */
	
	//Constructer 
	public Update( String title ,String username ) {
		super(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 505);
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
			
			
				 BNF = new JMenuItem("WHAT IS BOOK ID");  
		   BNF.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0)
				
				{
					
		
	 				int ans = JOptionPane.showConfirmDialog(getParent(),"PLEACE SEARCH BOOK ID FROM THE SEARCH PANEL AND PUT IN THIS FILL BOX \n why do you Want Search book Id ","SEARCH MESSAGE",JOptionPane.INFORMATION_MESSAGE);	
				
				
				if(ans==JOptionPane.YES_OPTION)
	{
		
	SearchByAdmin frame = new SearchByAdmin("Search Book",username );
 				frame.setVisible(true);
 			
		
	}
	else
	{
	Update frame = new Update("Update Book",username );
 				frame.setVisible(true);
 				dispose();	
		
	}
				
				
				}
				});
			
	
		
  
	     mb=new JMenuBar();  
         mb.setBounds(0,0,1000,20);  
        file=new JMenu("File");  
       home=new JMenu("Home");  
         help=new JMenu("Help"); 
		 //add new menu bar
		 help.add(BNF); 
         home.add(Home);  


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
		
		
		//Combo box
		 ca=new JComboBox(DBINFO.getAuthor());
		 ca.insertItemAt("select", 0);
	     ca.setSelectedIndex(0);
	     //select item from Author combo box and enter into Author text box   
	     ca.addItemListener(new   ItemListener()
	     {
	    	 
	    	

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				String aut=	 (String) ca.getSelectedItem();
				
					 if( aut.equalsIgnoreCase("Select"))
           {  

	   }
	   else
	   {
		     t4.setText(aut);    }
				
				
			}
	     });
	     
	     
	     
	     
	     //select category from database 
		 cc=new JComboBox(DBINFO.getcategory());
		 cc.insertItemAt("select", 0);
	     cc.setSelectedIndex(0);
	     //select item from category combo box and enter into category text box   
	     cc.addItemListener(new   ItemListener()
	     {
	    	 
	    	

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				String cat=	 (String) cc.getSelectedItem();
				
				
					
					 if( cat.equalsIgnoreCase("Select"))
           {  

	   }
	   else
	   {t6.setText(cat);
		         }
			
				
			}
	     });
	     
	     
	     
	     
	     
	   //select subject from database 
	     
		 cs=new JComboBox(DBINFO.getsubject());
		 cs.insertItemAt("select", 0);
	     cs.setSelectedIndex(0);
	     
	     //select item from subject combo box and enter into subject text box   
	     cs.addItemListener(new   ItemListener()
	     {
	    	 
	    	

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				String sub=	 (String) cs.getSelectedItem();
				
					 if( sub.equalsIgnoreCase("Select"))
           {  

	   }
	   else
	   {t3.setText(sub);
		         }
				
				
			}
	     });
	     
	     
	     
	     
	     
		 cp=new JComboBox(DBINFO.getpublication());
		 cp.insertItemAt("select", 0);
	     cp.setSelectedIndex(0);
	     //select item from publication combo box and enter into publication text box   
	     cp.addItemListener(new   ItemListener()
	     {
	    	 
	    	

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				String pub=	 (String) cp.getSelectedItem();
				
					 if( pub.equalsIgnoreCase("Select"))
           {  

	   }
	   else
	   {t5.setText(pub);
		         }
				
				
				
				
			}
	     }); 
		 
		 
		 
		 
		 ct=new JComboBox(DBINFO.getTitle());
		 ct.insertItemAt("select", 0);
	     ct.setSelectedIndex(0);
	     //select item from Title combo box and enter into Title text box   
	     ct.addItemListener(new   ItemListener()
	     {
	    	 
	    	

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				String title=	 (String) ct.getSelectedItem();
				 if( title.equalsIgnoreCase("Select"))
           {  

	   }
	   else
	   {
		   t2.setText(title);}
				
			}
	     });
		 
		 
		 
		//book ID
	     
	     
	     b3=new JButton("search Book");
	    t1 = new JTextField(10);
	       bI.setBounds(160,40,150,25);
		   t1.setBounds(350,40,250,25);
		b3.setBounds(650,40,250,25);
		t1.setEditable(true);
		
		contentPane.add(bI);
		contentPane.add(b3);
		contentPane.add( t1);
		
		
		
		  b3.addActionListener(new ActionListener(){
				String s2,s3,s4,s5,s6,s7,s8;
			int Flag = 0;

				public void actionPerformed(ActionEvent arg0)
				
				{
			
			
			
				String id = t1.getText();
				String query = " SELECT * FROM `book` where BID= ? ";
				
				try
				{
					PreparedStatement ps = DBINFO.getConnection().prepareStatement(query);
					ps.setString(1, id);
					
					 ResultSet  res = ps.executeQuery();
					
							while(res.next())
							{
								
								s2 = res.getString(3);
								s3 = res.getString(4);
								s4 = res.getString(5);
								s5 = res.getString(6);
								s6 = res.getString(7);
								s7 = res.getString(8);
								Flag=1;
								break;
							
							}
					
					
				}catch(Exception e){
					e.printStackTrace();
				}
				
				if(Flag==1)
				{
					
					t2.setText(s2);
					t3.setText(s3);
					t4.setText(s4);
					t5.setText(s5);
					t6.setText(s6);
					t7.setText(s7);
				t7.setEditable(true);
				
				t2.setEditable(true);
				
				}
				else
				{
					
			JOptionPane.showMessageDialog( getParent(),"book not  Found Pleace TRy AGAIN " ,"Error",JOptionPane.ERROR_MESSAGE);  
				}
				
			}
			
		});
		
		
		
		  //book Title
		t2 = new JTextField(10);
	
	BT.setBounds(160,80,150,25);
	t2.setBounds(350,80,250,25);
	ct.setBounds(650,80,250,25);
			contentPane.add(BT);
		     contentPane.add(t2);
			 contentPane.add(ct);
		     t2.setEditable(false);
		
		
		 //SUBJECT
		 	t3 = new JTextField(10);
			SUB.setBounds(160,120,150,25);
			t3.setBounds(350,120,250,25);
		cs.setBounds(650,120,250,25);
		
		contentPane.add(SUB);
		contentPane.add(t3);
		contentPane.add(cs);
		 t3.setEditable(false);
		
		
		
		  //Author
		t4 = new JTextField(10);
		Author.setBounds(160,160,150,25);
		t4.setBounds(350,160,250,25);
		ca.setBounds(650,160,250,25);
	
		contentPane.add(Author);
		contentPane.add( ca);
		contentPane.add(t4);
		 t4.setEditable(false);
		
		 
		
		
		  //Publication 
		
		t5 = new JTextField(10);
		P.setBounds(160,200,150,25);
		t5.setBounds(350,200,250,25);
		cp.setBounds(650,200,250,25);
		
	contentPane.add(P);
	contentPane.add( cp);
	contentPane.add(t5);
	 t5.setEditable(false);
	
	
	   //category
	t6 = new JTextField(10);
	C.setBounds(160,240,150,25);
	t6.setBounds(350,240,250,25);
		cc.setBounds(650,240,250,25);
		
	contentPane.add(C);
	contentPane.add(cc);
	contentPane.add(t6);
	t6.setEditable(false);
	
	
	//Prize
	
	
	   t7 = new JTextField(10);
		t7.setBounds(350,280,250,25);
	Pr.setBounds(160,280,150,25);
		contentPane.add(Pr);
		contentPane.add(t7);
		t7.setEditable(false);
		
		
		
		b1=new JButton("UPDATE");
		
		
		 b1.addActionListener(new ActionListener(){
			

				public void actionPerformed(ActionEvent arg0)
				
				{
					
				String id=	t1.getText();
				String TIT =	t2.getText();
				String sub=	 t3.getText();;
				String Aut =	 t4.getText();
			    String publication =	t5.getText();
				
				String cat  =	t6.getText();
				String prize =	t7.getText();
				
				
				
			
				
				//System.out.println("Author is ="+Aut);	
				String query = "update book set BookT=?,SUB=?,Author=?,Publication=?,category=?,Prize=? where BID= ?   ";
				  Connection con = DBINFO.getConnection();
					int	 i=0;
					int	 n=0;
				  
				  try{
					  
					  PreparedStatement ps = con.prepareStatement(query); 
					 
					  ps.setString(1,TIT);
					  ps.setString(2,sub);
					  ps.setString(3,Aut);
					  ps.setString(4,publication);
					  ps.setString(5,cat);
					  ps.setString(6,prize);
					  ps.setString(7,id);
					  
					 i=  ps.executeUpdate();
					  
					  
				  }catch(Exception e){
						e.printStackTrace();
					}
				  	n =  DBINFO.CheckTitle( TIT);	
					System.out.println("i=="+i);
					System.out.println("n=="+n);
				  if(i==1&&n==0)
				  {
					  int m =	  DBINFO.inserTitle(TIT);
				System.out.println(m);
				System.out.println("Title  add");
					  JOptionPane.showMessageDialog( getParent(),"book update" );  
						t1.setText(null);
						t2.setText(null);
						t3.setText(null);
						t4.setText(null);
						t5.setText(null);
						t6.setText(null);
						t7.setText(null);
					ct.setSelectedIndex(0);
						ca.setSelectedIndex(0);
						cc.setSelectedIndex(0);
						cp.setSelectedIndex(0);
						cs.setSelectedIndex(0);
						
						t2.setEditable(false);
						t7.setEditable(false);
						
										dispose();
			 new Update("Update Book",username ).setVisible(true);
					
						
				  }
				  else if(i==1&&n==1)
				  {
				
				System.out.println("Title not add");
					  JOptionPane.showMessageDialog( getParent(),"book update" );  
						t1.setText(null);
						t2.setText(null);
						t3.setText(null);
						t4.setText(null);
						t5.setText(null);
						t6.setText(null);
						t7.setText(null);
					ct.setSelectedIndex(0);
						ca.setSelectedIndex(0);
						cc.setSelectedIndex(0);
						cp.setSelectedIndex(0);
						cs.setSelectedIndex(0);
						t2.setEditable(false);
						t1.setEditable(true);
						t7.setEditable(false);
										dispose();
			 new Update("Update Book",username ).setVisible(true);
						
					
						
				  }
				 if(i==0)
				  {
					  JOptionPane.showMessageDialog( getParent(),"book not update" ,"Error",JOptionPane.ERROR_MESSAGE);   
					
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
				ct.setSelectedIndex(0);	
				ca.setSelectedIndex(0);
				cc.setSelectedIndex(0);
				cp.setSelectedIndex(0);
				cs.setSelectedIndex(0);
				t2.setEditable(false);
				t7.setEditable(false);
				
				
											dispose();
			 new Update("Update Book",username ).setVisible(true);
				
			}});
		
		
	
		
		
		b1.setBounds(100,360,100,20);
			b2.setBounds(250,360,100,20);
				contentPane.add(b1);
				contentPane.add(b2);
				
		
	
	}
}
