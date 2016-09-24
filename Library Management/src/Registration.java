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

public class Registration  extends JFrame    {
	private JPanel contentPane;
	JLabel l1,l2,l3;
	JTextField t1;
	JPasswordField p1;
	JButton b1,b2,b3;
	JComboBox C; 
	String	s2,username;
	
/*	
	public static void main(String[] args) {
		
		try {
			Registration frame = new Registration("Registration New user" );
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
}*/
	
	
	
	public Registration( String title)
	{
		
		super(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 714, 505);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLayout(null);
		
	l1 = new JLabel("enter user name");
	l2 = new JLabel("enter user Password");
	l3 = new JLabel("Select user Type ");
	
	String UserType[]={"Select","admin","faculty","student"};  
	
	C =new JComboBox(UserType);
	
	

t1=new JTextField(10);
p1=new JPasswordField(10);
b1 = new JButton("SUBMIT");
b2 = new JButton("RESET");
b3=new JButton("LOGIN");



l1.setBounds(160,60,200,25);
t1.setBounds(360,60,200,25);

l2.setBounds(160,100,200,25);
p1.setBounds(360,100,200,25);
l3.setBounds(160,140,200,25);
C.setBounds(360,140,200,25);

b1.setBounds(300,200,100,25);
b2.setBounds(450,200,100,25);
b3.setBounds(450,20,100,25);

add(l1);
add(t1);
add(l2);
add(p1);
add(l3);
add(C);
add(b1);
add(b2);
add(b3);





username = "";
t1.addFocusListener(new FocusAdapter(){
	
	int Flag = 0;
	//get Old Password From Database

	
	 String s2 = " ";
	public void focusLost( FocusEvent arg0 )
	
	{
		
		
	 username = t1.getText();
		
if( username.isEmpty())
{     JOptionPane.showMessageDialog( getParent()," enter user name " ,"Error",JOptionPane.ERROR_MESSAGE);   

}
else
{
		
		String query = " SELECT * FROM `login` where username= ?";
		
		try
		{
			PreparedStatement ps = DBINFO.getConnection().prepareStatement(query);
			ps.setString(1,username );
		
			
			 ResultSet  res = ps.executeQuery();
			
					while(res.next())
					{
						
					s2 = res.getString(2);
						
						Flag=1;
						
					
					}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(s2.equals(username))
		{
			
			 JOptionPane.showMessageDialog( getParent()," This user name already Exist " ,"Error",JOptionPane.ERROR_MESSAGE);  	
			 t1.setText(null);
		
			
		}
	
		
	}
	}
	
});




b1.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0)
	
	{
		int i = 0;
		int j = 0;
		
		String usertype =(String) C.getSelectedItem();
		 username = t1.getText();
		char ch[] = p1.getPassword();
		String  password = String.copyValueOf(ch);
		
		System.out.println("userName="+username+"\n password="+password+"\n userType="+usertype);
			System.out.println( " laxman mali =" +   username.isEmpty()); 
		System.out.println(username+":i am a laxman :"+password);
		System.out.println( "null="+ null);
		
		if(usertype.equalsIgnoreCase("select")||username.isEmpty()||password.isEmpty())
		{
			
			JOptionPane.showMessageDialog( getParent()," pleace Select any  Option or enter any vaue in textBox ","Error",JOptionPane.ERROR_MESSAGE );  
			
			
			
		}
		else
		{
			
		i=DBINFO.Registrationinsert(username, password, usertype);
		
		
	    
		
		if(usertype.equalsIgnoreCase("student"))
		{
		 j =   DBINFO.userinsert(username);	
		 
		    EditProfile frame = new EditProfile("Edit Your Profile",username);
					frame.setVisible(true);
	    	 dispose();
			
		}
		
		
		
		if(i==0)
		{
			
			JOptionPane.showMessageDialog( getParent(),"you are not login Pleace try again","Error",JOptionPane.ERROR_MESSAGE );  
		}
		if(i==1)
		{
			
			
			
		
			
			
			t1.setText(null);
			p1.setText(null);
			C.setSelectedIndex(0);
			if(usertype.equalsIgnoreCase("admin"))
			{
				
				AdminSection obj=new AdminSection("Admin Account",username);
			obj.setVisible(true);
			dispose();
				
				
			}
			
		}
		}
		
		
		
	}});


	
	b2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0)
		
		{
			t1.setText(null);
			p1.setText(null);
			C.setSelectedIndex(0);
		
		
		
		
	}});
		
	
	b3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0)
		
		{Login frame = new Login("Already member ? sign in" );
	frame.setVisible(true);
	dispose();	
		}});

	

}
}