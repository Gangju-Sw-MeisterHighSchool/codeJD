package check;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.io.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conn = null;                         
		PreparedStatement pstmt = null;
		DriverManager out;
		try{
		String url = "jdbc:mysql://localhost:3306/code";
		String id = "root";                            
		String pw = "123456";                          
		Class.forName("com.mysql.jdbc.Driver");        
		conn=DriverManager.getConnection(url,id,pw);   
		
		la(pstmt, conn);
		
		
		}catch(Exception e){
		e.printStackTrace();
		DriverManager.println("addx");
		}finally{     
		if(pstmt != null) try{pstmt.close();}catch(SQLException sqle){}            // PreparedStatement ��ü ����
		if(conn != null) try{conn.close();}catch(SQLException sqle){}            // Connection ����
	}
	}
	static void la(PreparedStatement pstmt, Connection conn, String srt1, String srt2) throws SQLException, IOException {
		String sql1= "select * from pushCode where ? = ?";
		pstmt = conn.prepareStatement(sql1);
		pstmt.setString(1, srt1);
		pstmt.setString(2, srt2);
		ResultSet rs = pstmt.executeQuery();     			
		while(rs.next()) 
		{
			String asd = rs.getString("souce");
			outPutAu(asd);
			exeq();
			System.out.println(asd);
		}
		}
	static void la(PreparedStatement pstmt, Connection conn) throws SQLException, IOException {
		String sql1= "select * from pushCode";
		pstmt = conn.prepareStatement(sql1);
		ResultSet rs = pstmt.executeQuery();     			
		while(rs.next()) 
		{
			String asd = rs.getString("souce");
			outPutAu(asd);
			exeq();
			System.out.println(asd);
		}
		}
	static void outPutAu(String str) throws IOException
	{
		
		PrintWriter pw = new PrintWriter(new FileWriter("C:/Users/user/Desktop/�ý���/play.c"));
		pw.println(str);
		pw.close();
	}
	static void exeq() throws IOException
	{
		PrintWriter pw = new PrintWriter(new FileWriter("C:/Users/user/Desktop/�ý���/lunch.bat"));
		String a="cd C:\\Users\\user\\Desktop\\�ý���";
		pw.println(a+"\r");
		pw.println("gcc "+"play.c"+"\r\n");
		pw.close();
		start("C:/Users/user/Desktop/�ý���/lunch.bat"); 
	}
	static void start(String command) throws IOException
	{
		//String command = "C:/Users/user/Desktop/out555.bat";
		Runtime ru = Runtime.getRuntime();
		Process p=ru.exec(command);
	}	
}