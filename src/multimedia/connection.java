package multimedia;

import java.sql.*;  
import java.io.*;  
import multimedia.Indexer;
import multimedia.Searcher;

public class connection {
	
	public static boolean isDone = true;
	public static Indexer index ;
	public static Searcher search;
	
	public static void main(String[] args) {
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			//Statement st = con.createStatement();
			
			
			
			//index = new Indexer();
			//search = new Searcher();
			//String[] myStrings = {"/home/abhi/mmdb/dummy/0.jpg"};
			//index.indexing(myStrings);
			//search.search(myStrings);
			
			/*Statement st = con.createStatement();
			
			String sql="select * from IMAGE_TABLE.IMAGE_TABLE";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			System.out.println("AT database:"+rs);*/
			
			
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
	
	
	
	public static void insertImage(Connection con,Statement st,int imgCount) {
		
		try
		{
		
		//PreparedStatement ps=con.prepareStatement("insert into IMAGE_TABLE.IMAGE_TABLE values(BFILENAME('/home/abhi/mmdb/images',"+imgCount+".jpg"+"),JPEG)");  
		
		//FileInputStream fin=new FileInputStream("/media/abhi/Documents/Ms_passau/Third_Semester/Multimedia/project/project_resources/image.vary.jpg/" + imgCount + ".jpg");  
		
		//ps.setBinaryStream(1,fin,fin.available());
		
			int cc = 0;
			while(cc < 9906){
				cc++;
				if(cc == 9906){
					st.close();
					con.close();
				}
			insertImage(con,st,cc);
			}
		
		String sql1 = "insert into IMAGE_TABLE.IMAGE_TABLE values"; 
		String sql2 = "(bfilename('/home/abhi/mmdb/images','"+imgCount+".jpg'),'JPEG')";
		System.out.println(sql1+sql2);
		st.execute(sql1+sql2);
		
		//int ii = ps.executeUpdate(); 
		
		System.out.println(st);
		
		}
		catch(Exception e)
		{
			System.out.println("hello");
			System.out.println(e);
		}
		
		
		
	
	}

}
