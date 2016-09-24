import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

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



public class DBINFO1 {

JButton b1;
	static  Vector <String>  header;
	static Vector <Vector <String>>  Record;
	static  Vector <String>  header1;
	static Vector <Vector <String>>  Record1;
	static Connection con = null;
	static
	{
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Connection getConnection()
	{
		
		//step 2 :Connection 
		 ResultSet rs;
		String url =  "jdbc:mysql://localhost:3306/libmgmt";
		String username="root";
		String password= "";
		try{
			con = DriverManager.getConnection(url,username,password);
		}catch(SQLException ex){
			System.out.println("Connection failed");
		}
		return con;
	}
        
        //insert Author subject Title Publication
	public static int insertValue(String tableName ,String value)

	{
		int i=0;
		String query = " insert  into   "+ tableName +   " (name)  value(?)" ;
		System.out.println(query);
		try
		{
			PreparedStatement ps = getConnection().prepareStatement(query);
		
			ps.setString(1, value.toLowerCase());
			 i=  ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}
	//get Author
public static Vector<String> getAuthor()
{
	Vector <String> V = new Vector();
	
	String query= "select name from author order by name";
	try{
		PreparedStatement ps = getConnection().prepareStatement(query);
		ResultSet res = ps.executeQuery();
		while(res.next())
		{
			String str = res.getString(1);
			V.add(str.toUpperCase());//add iTem int vector
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	return V;
}

public static Vector<String> getsubject()
{
	Vector <String> V = new Vector();
	
	String query= "select name from subject order by name";
	try{
		PreparedStatement ps = getConnection().prepareStatement(query);
		ResultSet res = ps.executeQuery();
		while(res.next())
		{
			String str = res.getString(1);
			V.add(str);//add iTem int vector
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	return V;
}

public static Vector<String> getcategory()
{
	Vector <String> V = new Vector();
	
	String query= "select name from category order by name";
	try{
		PreparedStatement ps = getConnection().prepareStatement(query);
		ResultSet res = ps.executeQuery();
		while(res.next())
		{
			String str = res.getString(1);
			V.add(str);//add iTem int vector
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	return V;
}
public static Vector<String> getpublication()
{
	
	Vector <String>  V = new Vector();
	String query= "select name from publication order by name";
	try{
		PreparedStatement ps = getConnection().prepareStatement(query);
		ResultSet res = ps.executeQuery();
		while(res.next())
		{
			String str = res.getString(1);
			V.add(str);//add iTem int vector
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	return V;
}

public static Vector<String> getTitle()
{
	Vector <String> V = new Vector();
	
	String query= "select BookT from BookT order by BookT";
	try{
		PreparedStatement ps = getConnection().prepareStatement(query);
		ResultSet res = ps.executeQuery();
		while(res.next())
		{
			String str = res.getString(1);
			V.add(str.toUpperCase());//add iTem int vector
			
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	return V;
}










//get  book  information  by Admin from the book tabel 
public static void getValue( String ColonName,String value ) 
{
	header = new Vector<>();
	Record = new Vector<>();
	System.out.println(ColonName+"  :::: "+value);
	
	Connection con = getConnection();
	PreparedStatement ps =null;
	String query ="";
if(ColonName.equalsIgnoreCase("All"))
{
	
	 query="select * from book b ";	

try
{
	 ps = con.prepareStatement(query);
	
	

}catch(Exception e){
	e.printStackTrace();
}

//if end
	
}


//if end
	

else
{
	
	query="select  * from book b  where  b."+ColonName+"= ?";
 


try
{
	 ps = con.prepareStatement(query);
	 ps.setString(1, value);
	

}catch(Exception e){
	e.printStackTrace();
}

}


//else end
try {
	ResultSet res = ps.executeQuery();
	//meta data
	
	ResultSetMetaData rsmd = res.getMetaData();
	int count = rsmd.getColumnCount();
	for(int i=1;i<=count;i++)
	{
		
		header.add(rsmd.getColumnName(i));
		
	}

	System.out.println(header);
	
	while(res.next())
	{
		
		Vector <String> single = new Vector<>();
		for(int i=1;i<=count;i++)
		{
			
			single.add(res.getString(i));
			
				
		}
		Record.add(single);
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	
}








public static void getValueStudent( String ColonName,String value ) 
{
	header = new Vector<>();
	Record = new Vector<>();
	System.out.println(ColonName+"  :::: "+value);
	
	Connection con = getConnection();
	PreparedStatement ps =null;
	String query ="";
if(ColonName.equalsIgnoreCase("All"))
{
	
	 query="select * from book b  where issueState='Book is in lib'   ";	

try
{
	 ps = con.prepareStatement(query);
	
	

}catch(Exception e){
	e.printStackTrace();
}

//if end
	
}


//if end
	

else
{
	
	query="select  * from book b  where  b."+ColonName+"= ? and issueState='Book is in lib' ";
 


try
{
	 ps = con.prepareStatement(query);
	 ps.setString(1, value);
	

}catch(Exception e){
	e.printStackTrace();
}

}


//else end
try {
	ResultSet res = ps.executeQuery();
	//meta data
	
	ResultSetMetaData rsmd = res.getMetaData();
	int count = rsmd.getColumnCount();
	for(int i=1;i<=count;i++)
	{
		
		header.add(rsmd.getColumnName(i));
		
	}

	System.out.println(header);
	
	while(res.next())
	{
		
		Vector <String> single = new Vector<>();
		for(int i=1;i<=count;i++)
		{
			
			single.add(res.getString(i));
			
				
		}
		Record.add(single);
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	
}

















//enter value into the login tabel when user meke new Account
public static int Registrationinsert (String username,String password,String usertype)
{

	int i=0;
	Connection con = getConnection();
	PreparedStatement ps =null;
	String query ="  INSERT INTO login (username,password,usertype) VALUES(?,?,?)";
	
	
	 
	try
	{
		 ps = con.prepareStatement(query);
		 ps.setString(1, username);
		 ps.setString(2, password);
		 ps.setString(3, usertype);
		 i=  ps.executeUpdate();

	}catch(Exception e){
		e.printStackTrace();
	}
	return i;
}
//inser into username into the student tabel when user make new account
public static int userinsert(String username)
{

         	int i=0;
	     Connection con = getConnection();

      	    PreparedStatement ps =null;
	            String query = "  INSERT INTO `student` (username) VALUES(?)";
	
	
	
	try
	{	 
		 ps = con.prepareStatement(query);
		 ps.setString(1, username);
		 i = ps.executeUpdate();
		 

	}catch(Exception e){
		e.printStackTrace();
	}
	return i;
	
}







//search student from the student tabel
public static void getStudent( String ColonName,String value ) 
{
	header1 = new Vector<>();
	Record1 = new Vector<>();
	System.out.println(ColonName+"  :::: "+value);
	
	Connection con = getConnection();
	PreparedStatement ps =null;
	String query ="";
if(ColonName.equalsIgnoreCase("All"))
{
	
	 query="  select s.CollegeId,s.Name,s.Branch,s.Sem,b.BID,b.BookT,b.Author from student s,issueb I,book b where  s.username=I.username and I.BID=b.BID";		

try
{
	 ps = con.prepareStatement(query);
	
	

}catch(Exception e){
	e.printStackTrace();
}

//if end
	
}



else if(ColonName=="Name"||ColonName=="CollegeId"||ColonName=="Branch"||ColonName=="Sem")
{
	
	query="select s.CollegeId,s.Name,s.Branch,s.Sem,b.BID,b.BookT,b.Author from student s,issueb I,book b where s.username=I.username and I.BID=b.BID and   s."+ColonName+"= ?";
	 	

try
{
	 ps = con.prepareStatement(query);
	 ps.setString(1, value);
	

}catch(Exception e){
	e.printStackTrace();
}	
	
}
else
{
 query="select s.CollegeId,s.Name,s.Branch,s.Sem,b.BID,b.BookT,b.Author   from student s,issueb I,book b where   s.username=I.username and I.BID=b.BID and   b."+ColonName+"= ?";	


try
{
	 ps = con.prepareStatement(query);
	 ps.setString(1, value);
	    

}catch(Exception e){
	e.printStackTrace();
}

}


//else end
try {
	ResultSet res = ps.executeQuery();
	//meta data
	
	ResultSetMetaData rsmd = res.getMetaData();
	int count = rsmd.getColumnCount();
	
	for(int i=1;i<=count;i++)
	{
		
		header1.add(rsmd.getColumnName(i));
		
	}

	System.out.println(header1);
	
	while(res.next())
	{
		
		Vector <String> single = new Vector<>();
		for(int i=1;i<=count;i++)
		{
			
			single.add(res.getString(i));
			
				
		}
		Record1.add(single);
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}



	
}
////delete student Account From the login table
public static int deletStudent( String username ) 
{
	
	Connection con = getConnection();
String query = "DELETE  from  login  where username= ?   ";
				 
					int	 j=0;
				  
				  try{
					  
					  PreparedStatement ps = con.prepareStatement(query); 
					 
					 
					  ps.setString(1,username);
					  
					 j=  ps.executeUpdate();
					  
					  
				  }catch(Exception e){
						e.printStackTrace();
					}	
					return j;
	
}


//delete student Account From the Student table
public static int deletStudent1( String collegeId ) 
{
	
String query = "DELETE  from  student  where CollegeId= ?   ";
				  Connection con = getConnection();
					int	 i=0;
				  
				  try{
					  
					  PreparedStatement ps = con.prepareStatement(query); 
					 
					 
					  ps.setString(1,collegeId);
					  
					 i=  ps.executeUpdate();
					  
					  
				  }catch(Exception e){
						e.printStackTrace();
					}
					
					return i;
	
}
//Search Branch From Branch table
public static Vector<String> getBranch()
{
	Vector <String> V = new Vector();
	
	String query= "select Branch from  Branch order by Branch";
	try{
		PreparedStatement ps = getConnection().prepareStatement(query);
		ResultSet res = ps.executeQuery();
		while(res.next())
		{
			String str = res.getString(1);
			V.add(str);//add iTem int vector
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	return V;
}

//when user is submit book then insert book into the nonissuebook` table
public static int SubmitBook( String id )
{
	int i = 0;
	
	String query= "INSERT INTO `nonissuebook` (BID)  VALUES(?) ";
	 try{
					  
					  PreparedStatement ps = getConnection().prepareStatement(query);
					 
					 
					  ps.setString(1,id);
					  
					 i =  ps.executeUpdate();
					  
					  
				  }catch(Exception e){
						e.printStackTrace();
					}	
					return i;
}


//delete book from the nonissuebook table when issue book by the user
public static int DeletIssueBook( String id )
{
	

	String query= "DELETE from `nonissuebook` where BID=? ";
	Connection con = getConnection();
					int	 i=0;
				  
				  try{
					  
					  PreparedStatement ps = con.prepareStatement(query); 
					 
					 
					  ps.setString(1,id);
					  
					 i=  ps.executeUpdate();
					  
					  
				  }catch(Exception e){
						e.printStackTrace();
					}
					
					return i;
}

//search issueb book id and user name in the issueb table
public static int SearchIssueBook1( String id,  String username )
{
	String str="",str1="";
	int i=0;
String query= "select * from  issueb where BID = ? and username = ?";
	try{
		PreparedStatement ps = getConnection().prepareStatement(query);
		  ps.setString(1,id);
		   ps.setString(2,username);
		ResultSet res = ps.executeQuery();
		while(res.next())
		{
		 str = res.getString(2);
		 str1 = res.getString(3);
		 i =1;
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	System.out.println("BID="+str );
	System.out.println("username="+str1 );
	return i;
}


///check book Title in  the DataBase that title is exists or not  in title table
public static int CheckTitle( String title )
{
	
	int i=0;
String query= "select BookT from  title where BookT=?";
	try{
		PreparedStatement ps = getConnection().prepareStatement(query);
		  ps.setString(1,title);
		 
		ResultSet res = ps.executeQuery();
		while(res.next())
		{
		i =1;
		}
	}catch(Exception e){
		e.printStackTrace();
	}
return i;
}


///insert Title into title table
	public static int inserTitle(String title)

	{
		int i=0;
		String query = " insert  into  BookT    (BookT)  values(?)" ;
		System.out.println(query);
		try
		{
			PreparedStatement ps = getConnection().prepareStatement(query);
		ps.setString(1, title.toLowerCase());
			 i=  ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}
        
        
        //insert image in database 
        public static int InsertPhoto(String image, String user )
{ 
 Connection con = getConnection();
 int	 i=0;					
    String str;
    String query = "update student set image=? where username= ?   ";

	try{
	PreparedStatement ps = con.prepareStatement(query); 
		 ps.setString(1,image);
		ps.setString(2,user);
		i=  ps.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
	}

return i;




}


}