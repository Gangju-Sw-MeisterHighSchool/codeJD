package check;

import java.sql.*;

import com.mysql.*;

	import java.sql.Connection;

	import java.sql.DriverManager;

	import java.sql.ResultSet;

	import java.sql.SQLException;



class database {		
	public void da() {
		Connection conn = null;                         
		PreparedStatement pstmt = null;
		DriverManager out;
		try{
		String url = "jdbc:mysql://localhost:3306/code";
		String id = "root";                            
		String pw = "123456";                          
		Class.forName("com.mysql.jdbc.Driver");        
		conn=DriverManager.getConnection(url,id,pw);   
		
		String sql1= "select * from pushCode";
		pstmt = conn.prepareStatement(sql1);            
		ResultSet rs = pstmt.executeQuery();     			
		while(rs.next()) 
		{
			String asd = rs.getString("souce");
			System.out.println(asd);
		}
		
		
		/*
			String sql = "insert into pushCode values(?,?,?,?)";      
			pstmt = conn.prepareStatement(sql);                       
			pstmt.setInt(1,456);
			pstmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));   
			pstmt.setString(3,"test");
			pstmt.setInt(4,132);
			pstmt.executeUpdate();   
		
// 쿼리를 실행한다.
			
			
			for(int i = 0;i<5;i++)
			{
				
				String sql2= "delete from pushCode where souce='test'";                        // sql 쿼리
				pstmt = conn.prepareStatement(sql2);       
				pstmt.execute(sql2);                                        // 쿼리를 실행한다.
			}
			
			
			String sql1= "select * from pushCode";                        // sql 쿼리
			//pstmt.setInt(1,456);
			pstmt = conn.prepareStatement(sql1);            

			
			ResultSet rs = pstmt.executeQuery();     
			boolean is = rs.next();
			System.out.println(is);

			while(rs.next()) 
			{
				String asd = rs.getString("souce");
				System.out.println(asd);
			}
			DriverManager.println("add 0");
*/
		}catch(Exception e){

		e.printStackTrace();

		DriverManager.println("addx");

		}finally{                                                            // 쿼리가 성공 또는 실패에 상관없이 사용한 자원을 해제 한다. (순서중요)

		if(pstmt != null) try{pstmt.close();}catch(SQLException sqle){}            // PreparedStatement 객체 해제

		if(conn != null) try{conn.close();}catch(SQLException sqle){}            // Connection 해제
	}
}
}