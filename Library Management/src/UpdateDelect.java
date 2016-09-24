import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;


public class UpdateDelect extends JFrame {

	private JPanel contentPane;
	JLabel bI,BT,P,Pr,Q,Author,C,SUB;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JButton b1,b2,b3;
	   JComboBox ca,cp,cc,cs;  
	    JMenuBar mb;  
       JMenu file,AddItem, help;  
       JMenuItem 	author,subject,category,publication;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
				try {
					UpdateDelect frame = new UpdateDelect("Update Book" );
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}

	/**
	 * Create the frame.
	 */
	
	//Constructer 
	public UpdateDelect( String title  ) {
		super(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 714, 505);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLayout(null);
		
		//add menu bar
		  
		 //Author Action Event
		author = new JMenuItem("author");  
		
		author.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			
			{
				
			String option = arg0.getActionCommand();
			String value = JOptionPane.showInputDialog("Enter  " +"   "+option+ "   name:");
			System.out.println(option+"::::"+value);
			
			int i =  DBINFO.insertValue( option, value);
			
			System.out.println(i);
			dispose();
			new UpdateDelect("AddNeBook" ).setVisible(true);
			}
			
			
			});
		 
// Subject Action Event		 
		subject = new JMenuItem("subject");  
        
		subject .addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			
			{
				
			String option = arg0.getActionCommand();
			String value = JOptionPane.showInputDialog("Enter  " +"   "+option+ "   name:");
			System.out.println(option+"::::"+value);
			
			int i =  DBINFO.insertValue( option, value);
			
			System.out.println(i);
			dispose();
			new UpdateDelect("AddNeBook" ).setVisible(true);
			}
			
			
			});
		
		
		//	category  Action Event
        
		category = new JMenuItem("category");  
		
		category.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			
			{
				
			String option = arg0.getActionCommand();//It Will be Fetch the value From label
			String value = JOptionPane.showInputDialog("Enter  " +"   "+option+ "   name:");
			System.out.println(option+"::::"+value);
			
			int i =  DBINFO.insertValue( option, value);
			
			System.out.println(i);
			dispose();
			new UpdateDelect("AddNeBook" ).setVisible(true);
			}
			
			
			});
		
		
		
		
		//Publication Action Event
       publication=new JMenuItem("publication");  
       publication.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			
			{
				
			String option = arg0.getActionCommand();
			String value = JOptionPane.showInputDialog("Enter  " +"   "+option+ "   name:");
			System.out.println(option+"::::"+value);
			
			int i =  DBINFO.insertValue( option, value);
			
			System.out.println(i);
			dispose();
			new UpdateDelect("AddNeBook" ).setVisible(true);
			}
			
			
			});
       
       //create menu bar
       
	     mb=new JMenuBar();  
             mb.setBounds(0,0,514,20);  
	        file=new JMenu("File");  
           AddItem=new JMenu("Add New");  
             help=new JMenu("Help"); 
			 //add new menu bar
			 AddItem.add(author);AddItem.add(subject);AddItem.add(category);AddItem.add( publication);  
  
  
mb.add(file);mb.add(AddItem);mb.add(help);
//contentPane.add(mb);
  

			 
	   
	   
		//label of book
		bI= new JLabel("Book ID");
		SUB = new JLabel("SUBJECT");
		BT = new JLabel("Book Title");
		P = new JLabel("Publication");
		C = new JLabel("category");
		Author = new JLabel("Author");
		Pr = new JLabel("Prize");
		Q = new JLabel("Quantity");
		
		//Combo box
		 ca=new JComboBox(DBINFO.getAuthor());
		 ca.insertItemAt("select", 0);
	     ca.setSelectedIndex(0);
	     //select item from Author combo box and enter into Author text box   
	     ca.addItemListener(new   ItemListener()
	     {
	    	 
	    	

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				String sub=	 (String) ca.getSelectedItem();
				t4.setText(sub);
				
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
				
				String sub=	 (String) cc.getSelectedItem();
				t6.setText(sub);
				
			}
	     });
	     
	     
	     
	     
	     
	   //select category from database 
	     
		 cs=new JComboBox(DBINFO.getsubject());
		 cs.insertItemAt("select", 0);
	     cs.setSelectedIndex(0);
	     
	     //select item from subject combo box and enter into Subject text box   
	     cs.addItemListener(new   ItemListener()
	     {
	    	 
	    	

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				String sub=	 (String) cs.getSelectedItem();
				t3.setText(sub);
				
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
				
				String sub=	 (String) cp.getSelectedItem();
				t5.setText(sub);
				
			}
	     }); 
		 
		 
		//book ID
	    t1 = new JTextField(10);
	 
	    
		t1.setBounds(320,40,100,20);
		bI.setBounds(160,40,100,20);
		contentPane.add(bI);
		contentPane.add( t1);
		
		
		
		t1.addFocusListener(new FocusAdapter(){
			
			String s2,s3,s4,s5,s6,s7,s8;
			int Flag = 0;
			public void focusLost( FocusEvent arg0 )
			
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
				
				if(Flag==1)
				{
					
					t2.setText(s2);
					t3.setText(s3);
					t4.setText(s4);
					t5.setText(s5);
					t6.setText(s6);
					t7.setText(s7);
					t8.setText(s8);
				}
				else
				{
					
					 JOptionPane.showMessageDialog( getParent(),"book not  Found Pleace TRy AGAIN " ,"Error",JOptionPane.ERROR_MESSAGE);  
				}
				
			}
			
		});
		
		
		
		  //book Title
		t2 = new JTextField(10);
	t2.setBounds(320,80,100,20);
	BT.setBounds(160,80,100,20);
			contentPane.add(BT);
		     contentPane.add(t2);
		
		
		 //SUBJECT
		 	t3 = new JTextField(10);
			t3.setBounds(320,120,100,20);
		cs.setBounds(440,120,100,20);
		SUB.setBounds(160,120,100,20);
		contentPane.add(SUB);
		contentPane.add(t3);
		contentPane.add(cs);
		
		
		
		
		  //Author
		t4 = new JTextField(10);
		t4.setBounds(320,160,100,20);
		ca.setBounds(440,160,100,20);
	Author.setBounds(160,160,100,20);
		contentPane.add(Author);
		contentPane.add( ca);
		contentPane.add(t4);
		
		
		 
		
		
		  //Publication 
		
		t5 = new JTextField(10);
		t5.setBounds(320,200,100,20);
		cp.setBounds(440,200,100,20);
		P.setBounds(160,200,100,20);
	contentPane.add(P);
	contentPane.add( cp);
	contentPane.add(t5);
	
	
	
	   //category
	t6 = new JTextField(10);
	t6.setBounds(320,240,100,20);
		cc.setBounds(440,240,100,20);
		C.setBounds(160,240,100,20);
	contentPane.add(C);
	contentPane.add(cc);
	contentPane.add(t6);
	
	
	//Prize
	
	
	   t7 = new JTextField(10);
		t7.setBounds(320,280,100,20);
	Pr.setBounds(160,280,180,20);
		contentPane.add(Pr);
		contentPane.add(t7);
		
		
		//Quantity of Book
		   t8 = new JTextField(10);
		t8.setBounds(320,320,100,20);
		Q.setBounds(160,320,100,20);
			contentPane.add(Q);
		contentPane.add(t8);
		
		
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
				String Qunt =	t8.getText();
				
				
			
				
				//System.out.println("Author is ="+Aut);	
				String query = "update book set BookT=?,SUB=?,Author=?,Publication=?,category=?,Prize=?,Quantity=? where BID= ?   ";
				  Connection con = DBINFO.getConnection();
					int	 i=0;
				  
				  try{
					  
					  PreparedStatement ps = con.prepareStatement(query); 
					 
					  ps.setString(1,TIT);
					  ps.setString(2,sub);
					  ps.setString(3,Aut);
					  ps.setString(4,publication);
					  ps.setString(5,cat);
					  ps.setString(6,prize);
					  ps.setString(7,Qunt);
					  ps.setString(8,id);
					  
					 i=  ps.executeUpdate();
					  
					  
				  }catch(Exception e){
						e.printStackTrace();
					}
				  
				  if(i!=0)
				  {
					  
					  JOptionPane.showMessageDialog( getParent(),"book update" );  
						t1.setText(null);
						t2.setText(null);
						t3.setText(null);
						t4.setText(null);
						t5.setText(null);
						t6.setText(null);
						t7.setText(null);
						t8.setText(null);
						ca.setSelectedIndex(0);
						cc.setSelectedIndex(0);
						cp.setSelectedIndex(0);
						cs.setSelectedIndex(0);
					
						
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
				t8.setText(null);	
				ca.setSelectedIndex(0);
				cc.setSelectedIndex(0);
				cp.setSelectedIndex(0);
				cs.setSelectedIndex(0);
				
				
				
			}});
		
		
		
		b3=new JButton("DELETE");

		 b3.addActionListener(new ActionListener(){
			

				public void actionPerformed(ActionEvent arg0)
				
				{
					
				String id=	t1.getText();
				
				
			
				
				//System.out.println("Author is ="+Aut);	
				String query = "DELETE  from  book  where BID= ?   ";
				  Connection con = DBINFO.getConnection();
					int	 i=0;
				  
				  try{
					  
					  PreparedStatement ps = con.prepareStatement(query); 
					 
					 
					  ps.setString(1,id);
					  
					 i=  ps.executeUpdate();
					  
					  
				  }catch(Exception e){
						e.printStackTrace();
					}
				  
				  if(i!=0)
				  {
					  
					  JOptionPane.showMessageDialog( getParent(),"Delete success" );  
						t1.setText(null);
						t2.setText(null);
						t3.setText(null);
						t4.setText(null);
						t5.setText(null);
						t6.setText(null);
						t7.setText(null);
						t8.setText(null);
					
						
				  }
				  if(i==0)
				  {
					  JOptionPane.showMessageDialog( getParent(),"Your book not Delete" ,"Error",JOptionPane.ERROR_MESSAGE);   
					
				  }
				}
				 
				 
				  
				});
		
		
		b1.setBounds(100,360,100,20);
			b2.setBounds(250,360,100,20);
				b3.setBounds(440,360,200,20);
				contentPane.add(b1);
				contentPane.add(b2);
				contentPane.add(b3);
				
		
	
	}
}
