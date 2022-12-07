package edu.global.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.global.ex.command.Command;
import edu.global.ex.command.HomeShopiingJoinFormCommand;
import edu.global.ex.command.HomeShoppingModifyFormCommand;
import edu.global.ex.command.HomeShoppingSalesListCommand;
import edu.global.ex.command.HomeShoppingJoinCommand;
import edu.global.ex.command.HomeShoppingListCommand;
import edu.global.ex.command.HomeShoppingModifyCommand;

@WebServlet("*.do")
public class HomeShoppingController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
			System.out.println("리스트");
			command = new HomeShoppingListCommand();
			command.execute(request, response);
			viewPage ="/homeshopping/list.jsp";
		}
		else if (com.equals("/joinForm.do")) {
			System.out.println("가입화면");
			command = new HomeShopiingJoinFormCommand();
			command.execute(request, response);
			viewPage ="/homeshopping/joinForm.jsp";
		}
		else if (com.equals("/join.do")) {
			System.out.println("가입");
			command = new HomeShoppingJoinCommand();
			command.execute(request, response);
			response.sendRedirect("/list.do");
			return;
		}
		else if (com.equals("/modifyForm.do")) {
			System.out.println("수정화면");
			command = new HomeShoppingModifyFormCommand();
			command.execute(request, response);
			viewPage = "/homeshopping/modifyForm.jsp";
		}
		else if (com.equals("/modify.do")) {
			System.out.println("수정");
			command = new HomeShoppingModifyCommand();
			command.execute(request, response);
			response.sendRedirect("/list.do");
			return;
		}
		else if (com.equals("/salesList.do")) {
			System.out.println("수정화면");
			command = new HomeShoppingSalesListCommand();
			command.execute(request, response);
			viewPage = "/homeshopping/salesList.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}
