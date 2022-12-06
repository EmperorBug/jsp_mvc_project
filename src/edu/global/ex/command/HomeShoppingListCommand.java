package edu.global.ex.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.global.ex.dao.HomeShoppingDAO;
import edu.global.ex.dto.HomeShoppingDTO;

public class HomeShoppingListCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HomeShoppingDAO dao = new HomeShoppingDAO();
		List<HomeShoppingDTO> rList = dao.list();
		
		request.setAttribute("list", rList);
	}
	

}
