package edu.global.ex.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.global.ex.dto.HomeShoppingDTO;

public class HomeShoppingDAO {
//	커넥션풀을 사용하기 위한 소스코드 (DataSource를 import할 시 java.sql로 해야한다.
	private DataSource dataSource = null;
	
	//기존에driver를 설정하고 Class.forName(driver)를 넣는 방식과는 달리 context.xml에 
    //리소스를 설정해주었다. context.xml에 있는 소스를 읽기 위해 context객체 생성한다
	public HomeShoppingDAO() {
		try {
			//jdbc/oracle : context.xml에 들어간 Resource에서 name에 해당하는 부분 
            //위의 식은 context.xml에서 name을 lookup 찾으라는 뜻이다. 
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<HomeShoppingDTO> list() {
		List<HomeShoppingDTO> rlist = new ArrayList<HomeShoppingDTO>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet	rs	=	null;
		try {
			String query= "select * from member_tbl_02";
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int custno = rs.getInt("custno");
				String custname = rs.getString("custname");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				Date joindate = rs.getDate("joindate");
				String grade = rs.getString("grade");
				String city = rs.getString("city");
				rlist.add(new HomeShoppingDTO(custno, custname, phone, address, joindate, grade, city));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}	
		return rlist;
	}
}
