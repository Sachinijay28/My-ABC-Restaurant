package com.abc.controller;

import java.awt.Menu;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.dao.MenuDAO;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Fetch the menu items from the DAO
        List<Menu> mainCourseItems = MenuDAO.getMainCourseItems();
        List<Menu> appetizerItems = MenuDAO.getAppetizerItems();
        List<Menu> MainCourseprices = MenuDAO.getMainCourseItems();
        List<Menu> appetizerprices = MenuDAO.getAppetizerItems();
        
        // Set the menu items as request attributes
        request.setAttribute("mainCourseItems", mainCourseItems);
        request.setAttribute("appetizerItems", appetizerItems);
        
        // Forward the request to the JSP page
        request.getRequestDispatcher("menu.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
