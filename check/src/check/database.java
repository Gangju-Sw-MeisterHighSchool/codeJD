package check;

import java.sql.*;

import com.mysql.*;

	import java.sql.Connection;

	import java.sql.DriverManager;

	import java.sql.ResultSet;

	import java.sql.SQLException;




class database {
		public static void main(String[] args) {
			Connection conn = null;                                        // null�� �ʱ�ȭ �Ѵ�.

			PreparedStatement pstmt = null;



			DriverManager out;
			try{

			String url = "jdbc:mysql://localhost:3306/code";        // ����Ϸ��� �����ͺ��̽����� ������ URL ���

			String id = "root";                                                    // ����� ����

			String pw = "123456";                                                // ����� ������ �н�����
			
			Class.forName("com.mysql.jdbc.Driver");                       // �����ͺ��̽��� �����ϱ� ���� DriverManager�� ����Ѵ�.

			conn=DriverManager.getConnection(url,id,pw);              // DriverManager ��ü�κ��� Connection ��ü�� ���´�.
			
			String sql = "insert into pushCode values(?,?,?,?)";        // sql ����

			pstmt = conn.prepareStatement(sql);                          // prepareStatement���� �ش� sql�� �̸� �������Ѵ�.

			pstmt.setInt(1,456);
			pstmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));    // ���� ��¥�� �ð�
			pstmt.setString(3,"passasdfasdfdasfdsfasdfwd");

			pstmt.setInt(4,132);

			pstmt.executeUpdate();                                        // ������ �����Ѵ�.
			
			
			//
			String sql1= "select * from pushCode where name = 456";                        // sql ����

			pstmt = conn.prepareStatement(sql1);                          // prepareStatement���� �ش� sql�� �̸� �������Ѵ�.

//			pstmt.setInt(1,456);



			ResultSet rs = pstmt.executeQuery();     
			System.out.println(rs);


			
			
			DriverManager.println("member ���̺� ���ο� ���ڵ带 �߰��߽��ϴ�.");        // ������ �޽��� ���

			

			}catch(Exception e){

			e.printStackTrace();

			DriverManager.println("member ���̺� ���ο� ���ڵ� �߰��� �����߽��ϴ�.");

			}finally{                                                            // ������ ���� �Ǵ� ���п� ������� ����� �ڿ��� ���� �Ѵ�. (�����߿�)

			if(pstmt != null) try{pstmt.close();}catch(SQLException sqle){}            // PreparedStatement ��ü ����

			if(conn != null) try{conn.close();}catch(SQLException sqle){}            // Connection ����

			}



			
				
				
				
				
				
		}

			 
					
			
		
	}

