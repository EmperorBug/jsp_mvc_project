package edu.global.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.global.ex.dao.HomeShoppingDAO;

public class HomeShopiingJoinFormCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HomeShoppingDAO dao = new HomeShoppingDAO();
		int lastNo = dao.lastCustno();
		if (lastNo == 1) lastNo = 100001;
		
		request.setAttribute("custno", lastNo);
	}
	

}
