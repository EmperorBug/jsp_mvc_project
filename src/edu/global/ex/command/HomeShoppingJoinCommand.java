package edu.global.ex.command;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.global.ex.dao.HomeShoppingDAO;
import edu.global.ex.dto.HomeShoppingDTO;

public class HomeShoppingJoinCommand implements Command{
//	CUSTNO   NOT NULL NUMBER       
//	CUSTNAME          VARCHAR2(20) 
//	PHONE             VARCHAR2(13) 
//	ADDRESS           VARCHAR2(60) 
//	JOINDATE          DATE         
//	GRADE             CHAR(1)      
//	CITY              CHAR(2)  
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HomeShoppingDAO dao = new HomeShoppingDAO();
		
		int custno = Integer.parseInt(request.getParameter("custno"));
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		
		Date joindate = null;
		SimpleDateFormat before = new SimpleDateFormat("yyyymmdd");
		SimpleDateFormat after = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date reqDate = null;
		try {
			reqDate = before.parse(request.getParameter("joindate"));
			joindate = Date.valueOf(after.format(reqDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		dao.join(new HomeShoppingDTO(custno, custname, phone, address, joindate, grade, city));
	}

}
