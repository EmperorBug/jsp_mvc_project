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
import edu.global.ex.dto.HomeShoppingSalesDTO;

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
	
	//가입시 번호 자동생성을 위한 메소
	public int lastCustno() {
		int num = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet	rs	=	null;
		try {
			String query= "select max(custno) custno from member_tbl_02";
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				num = rs.getInt("custno")+1;
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
		return num;
	}
	
	public void join(HomeShoppingDTO dto) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			String query= "insert into member_tbl_02 values(?,?,?,?,?,?,?)";
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, dto.getCustno());
			preparedStatement.setString(2, dto.getCustname());
			preparedStatement.setString(3, dto.getPhone());
			preparedStatement.setString(4, dto.getAddress());
			preparedStatement.setDate(5, dto.getJoindate());
			preparedStatement.setString(6, dto.getGrade());
			preparedStatement.setString(7, dto.getCity());
			
			int result = preparedStatement.executeUpdate();
			
			System.out.println("업데이트 쿼리수 : " +result+"개입니다.");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}	
	}
	
	public HomeShoppingDTO modifyForm(int custno) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet	rs	=	null;
		
		HomeShoppingDTO dto = new HomeShoppingDTO();
		try {
			String query= "select * from member_tbl_02 where custno = ?";
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, custno);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				dto.setCustno(rs.getInt("custno"));
				dto.setCustname(rs.getString("custname"));
				dto.setPhone(rs.getString("phone"));
				dto.setAddress(rs.getString("address"));
				dto.setJoindate(rs.getDate("joindate"));
				dto.setGrade(rs.getString("grade"));
				dto.setCity(rs.getString("city"));
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
		return dto;
	}
	public void modify(HomeShoppingDTO dto, int beforeNo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			String query= "update member_tbl_02 set custno=?, custname=?, phone=?, address=?, joindate=?, grade=?, city=? where custno=?";
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);

			//회원번호 수정 못하도록 해야할듯? 
			preparedStatement.setInt(1, dto.getCustno());
			preparedStatement.setString(2, dto.getCustname());
			preparedStatement.setString(3, dto.getPhone());
			preparedStatement.setString(4, dto.getAddress());
			preparedStatement.setDate(5, dto.getJoindate());
			preparedStatement.setString(6, dto.getGrade());
			preparedStatement.setString(7, dto.getCity());
			preparedStatement.setInt(8, beforeNo);
			
			int result = preparedStatement.executeUpdate();
			
			System.out.println("업데이트 쿼리수 : " +result+"개입니다.");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}	
	}
	
	public List<HomeShoppingSalesDTO> sales() {
		List<HomeShoppingSalesDTO> rlist = new ArrayList<HomeShoppingSalesDTO>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet	rs	=	null;
		try {
			String query= "SELECT m.custno, m.custname , m.grade, s.sales from MEMBER_TBL_02  m INNER JOIN (SELECT custno, sum(price) sales FROM MONEY_TBL_02 GROUP BY custno) s on m.CUSTNO  = s.custno ORDER BY  sales desc";
					
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int custno = rs.getInt("custno");
				String custname = rs.getString("custname");
				String grade = rs.getString("grade");
				Long sales = rs.getLong("sales");
				rlist.add(new HomeShoppingSalesDTO(custno, custname, grade, sales));
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
