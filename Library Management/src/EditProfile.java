

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


public class EditProfile extends JFrame {

	private JPanel contentPane;
JTextField t1,t2,t3,t4;
	JButton b1,b2,b3;
	String CollegeID,Name,Branch,Year,image,s;

	
	    JMenu file,AddItem, help;  
	      JMenuItem Home,issueBOOK,home;
	      JMenuBar mb;  
	
	

	/**
	 * Launch the application.
	 */
/*
	public static void main(String[] args) {
		
				try {
					EditProfile frame = new EditProfile("Edit Your Profile","laxman" );
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
*/
	/* Create the frame.*/
	 
	
	//Constructer 
	public EditProfile( String title,String username ) {
		super(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 505);
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
         mb.setBounds(0,0,1000,20);  
        file=new JMenu("File");  
       home=new JMenu("Home");  
         help=new JMenu("Help"); 
		 //add new menu bar
         home.add(Home);  
  home.add(issueBOOK);

mb.add(file);mb.add(home);mb.add(help);
contentPane.add(mb);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
	
	
		
		
	
//select Branch		

JComboBox	Br = new JComboBox(DBINFO.getBranch());
Br.insertItemAt("Select",0);
Br.setSelectedIndex(0);
Br.addItemListener(new ItemListener(){
public void itemStateChanged(ItemEvent e) {
									
String br = (String) Br.getSelectedItem();
  System.out.println(br);
 

  if( br.equalsIgnoreCase("Select"))
  {  

	   }
	   else
	   {
		   t3.setText(br);}

			
}});
		///end select Branch
JLabel	P = new JLabel();	
P.setToolTipText("Profile");
P.setBounds(10, 50, 200, 200);
contentPane.add(P);  //add user profile
	
JLabel	n = new JLabel("Name");	
JLabel	C = new JLabel("College ID" );	
 JLabel   B = new JLabel("Branch");	
JLabel	Y = new JLabel("Semester" );
t1=  new JTextField(10);
t2=  new  JTextField(10);
t3= new JTextField(10);
t4=new  JTextField(10);

n.setBounds(250, 40, 150, 25);
	contentPane.add(n);	
	t1.setBounds(350, 40, 250, 25);
	contentPane.add(t1);
 
 
 
 C.setBounds(250, 70, 150, 25);
	contentPane.add(C);	
	t2.setBounds(350, 70, 250, 25);
	contentPane.add(t2);
 
		
	
		B.setBounds(250, 100, 150, 25);
	    contentPane.add(B);	
		 Br.setBounds(650, 100, 250, 25);
	    t3.setBounds(350, 100, 250, 25);
	    contentPane.add(Br);
		   contentPane.add(t3);
		     t3.setEditable(false);
		   
       
		
		
			Y.setBounds(250, 130, 150, 25);
	    contentPane.add(Y);	
	    t4.setBounds(350, 130, 250, 25);
	    contentPane.add(t4);
        
		
		
		
		
		
		
		
		
					
		Connection con = DBINFO.getConnection();
		java.sql.PreparedStatement ps = null;
	     int Flag=0;   
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
                                                image =res.getString(3);
						Branch = res.getString(5);
						Year = res.getString(6);
						break;
					}
					
		 	

		 }catch(Exception e){
		 	e.printStackTrace();
		 }
if(Flag==1)
{
t1.setText(CollegeID);
t2.setText(Name);
Br.setSelectedIndex(0);
t3.setText(Branch);
t4.setText(Year);
String s= "I:\\Project\\Library Management\\Profile\\" +image;
          
          P.setIcon(new ImageIcon(((new ImageIcon(s)).getImage()).getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));;
	
}
		
		
		
		
		
		
		
		
	
		
		b1=   new JButton("Edit Profile");
		  b1.setBounds(250, 200, 250, 25);
	    contentPane.add(b1);
		b1.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0)
	
	{
		
		String Id = t2.getText();
		String name = t1.getText();
		String Branch = t3.getText();
		String sem = t4.getText();
		
		if(Id.isEmpty()||name.isEmpty()||sem.isEmpty()||Branch.isEmpty())
		{
			
		JOptionPane.showMessageDialog( getParent()," enter any vaue in textBox ","Error",JOptionPane.ERROR_MESSAGE ); 	
		}
		else
		{
			
			
					
				//System.out.println("Author is ="+Aut);	
				String query = "update student set CollegeId=?,Name=?,	Branch=?,Sem=? where username= ?   ";
				  Connection con = DBINFO.getConnection();
					int	 i=0;
				  
				  try{
					  
					  PreparedStatement ps = con.prepareStatement(query); 
					 
					  ps.setString(1,Id);
					  ps.setString(2,name);
					  ps.setString(3,Branch);
					  ps.setString(4,sem);
					  	  ps.setString(5,username);
					i=  ps.executeUpdate();
					  
					  
				  }catch(Exception e){
						e.printStackTrace();
					}
					if(i==0)
					{
						
						
		JOptionPane.showMessageDialog( getParent()," Your Information is note update ","Error",JOptionPane.ERROR_MESSAGE ); 		
						
						
					}
					
					if(i==1)
					{
					

           Profile frame= new  Profile("Profile",username);
	    	 frame.setVisible(true);
	    	 dispose();
					
					}
		}
		
		
		}});
		
			b2=   new JButton("Reset");
		  b2.setBounds(700, 200, 250, 25);
	    contentPane.add(b2);
		
			b2.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0)
	
	{
		
		
		t1.setText(null);
t2.setText(null);
Br.setSelectedIndex(0);
t3.setText(null);
t4.setText(null);
			}});
		
		}
}
