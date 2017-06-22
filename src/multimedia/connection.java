package multimedia;

import java.sql.*;  
import java.io.*;  


public class connection {
	
	public static boolean isDone = true;
	 
	
	public static void main(String[] args) {
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			
			
		
			retreiveImage(con);
		
			
			
			
			//Statement st = con.createStatement();
			
			//String sql="select * from IMAGE_TABLE.IMAGETABLE";
			//ResultSet rs = st.executeQuery(sql);
			//while(rs.next())
			//System.out.println("AT database:"+rs.getInt(1));
			
			
		}
		catch(Exception e)
		{
			System.out.println("hello");
			System.out.println(e);
		}
	}
	
	
	
	public static void retreiveImage(Connection con){
		
		int i = 0; 
		FileOutputStream fout = null;
		try{
			
			PreparedStatement ps=con.prepareStatement("select * from IMAGE_TABLE.IMAGETABLE");  
			ResultSet rs=ps.executeQuery();  
			while(rs.next()){//now on 1st row  
			i++;             
			Blob b=rs.getBlob(1);//2 means 2nd column data  
			byte barr[]=b.getBytes(1,(int)b.length());//1 means first image  
			              
			fout=new FileOutputStream("/home/abhi/Desktop/multimedia/"+i+".jpg");  
			fout.write(barr); 
			              
			}
			
			fout.close(); 
			con.close();
			
			}

catch(Exception e)
		{
			System.out.println("hello");
			System.out.println(e);
		}
	}
	
	
	
	public static void insertImage(Connection con,int imgCount) {
		
		try
		{
		
		PreparedStatement ps=con.prepareStatement("insert into IMAGE_TABLE.IMAGETABLE values(?)");  
		
		FileInputStream fin=new FileInputStream("/media/abhi/Documents/Ms_passau/Third_Semester/Multimedia/project/project_resources/image.vary.jpg/" + imgCount + ".jpg");  
		
		ps.setBinaryStream(1,fin,fin.available());
		
		int ii = ps.executeUpdate(); 
		
		System.out.println("AT database:"+ii);
		
		}
		catch(Exception e)
		{
			System.out.println("hello");
			System.out.println(e);
		}
		
		
		
	
	}

}
