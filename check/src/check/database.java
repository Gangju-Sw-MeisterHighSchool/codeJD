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
		
// ������ �����Ѵ�.
			
			
			for(int i = 0;i<5;i++)
			{
				
				String sql2= "delete from pushCode where souce='test'";                        // sql ����
				pstmt = conn.prepareStatement(sql2);       
				pstmt.execute(sql2);                                        // ������ �����Ѵ�.
			}
			
			
			String sql1= "select * from pushCode";                        // sql ����
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

		}finally{                                                            // ������ ���� �Ǵ� ���п� ������� ����� �ڿ��� ���� �Ѵ�. (�����߿�)

		if(pstmt != null) try{pstmt.close();}catch(SQLException sqle){}            // PreparedStatement ��ü ����

		if(conn != null) try{conn.close();}catch(SQLException sqle){}            // Connection ����
	}
}
}