package check;

import java.sql.*;

import com.mysql.*;

	import java.sql.Connection;

	import java.sql.DriverManager;

	import java.sql.ResultSet;

	import java.sql.SQLException;




class database {
		public static void main(String[] args) {
			Connection conn = null;                         

			PreparedStatement pstmt = null;



			DriverManager out;
			try{

			String url = "jdbc:mysql://localhost:3306/code";

			String id = "root";                            

			String pw = "123456";                          
			
			Class.forName("com.mysql.jdbc.Driver");        

			conn=DriverManager.getConnection(url,id,pw);   
			
			String sql = "insert into pushCode values(?,?,?,?)";      

			pstmt = conn.prepareStatement(sql);                       

			pstmt.setInt(1,456);
			pstmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));   
			pstmt.setString(3,"las");

			pstmt.setInt(4,132);

			pstmt.executeUpdate();                                        // ������ �����Ѵ�.
			String sql1= "select * from pushCode where name = 456";                        // sql ����

			pstmt = conn.prepareStatement(sql1);            



			ResultSet rs = pstmt.executeQuery();     
			System.out.println(rs);


			
			
			DriverManager.println("add 0");

			

			}catch(Exception e){

			e.printStackTrace();

			DriverManager.println("addx");

			}finally{                                                            // ������ ���� �Ǵ� ���п� ������� ����� �ڿ��� ���� �Ѵ�. (�����߿�)

			if(pstmt != null) try{pstmt.close();}catch(SQLException sqle){}            // PreparedStatement ��ü ����

			if(conn != null) try{conn.close();}catch(SQLException sqle){}            // Connection ����

			}

		}

		
	}

