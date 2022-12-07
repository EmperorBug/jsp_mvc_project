package edu.global.ex.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.global.ex.dao.HomeShoppingDAO;
import edu.global.ex.dto.HomeShoppingDTO;

public class HomeShoppingModifyCommand implements Command{
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
		Date joindate = Date.valueOf(request.getParameter("joindate"));
		
		int beforeCustNo = Integer.parseInt(request.getParameter("beforeCustNo"));
		dao.modify(new HomeShoppingDTO(custno, custname, phone, address, joindate, grade, city),beforeCustNo);
	}

}