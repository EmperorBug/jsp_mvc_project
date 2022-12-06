package edu.global.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.global.ex.command.Command;
import edu.global.ex.command.HomeShoppingListCommand;

public class HomeShoppingController extends HttpServlet{

	
	public HomeShoppingController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(req,resp);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
		System.out.println("actionDo() ..");
		
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		Command command = null;
		
		//위의 세 줄은 http://localhost:8282/jsp_mvc_board/list.do 에서 list.do를 꺼내기 위한 코드들.
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		System.out.println("경로 확인:" + uri + ":" + conPath + ":" + com );
	
		if(com.equals("/list.do")) {
			System.out.println("디버깅문구");
			command = new HomeShoppingListCommand();
			command.execute(request, response);
			viewPage ="/homeshopping/list.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}
