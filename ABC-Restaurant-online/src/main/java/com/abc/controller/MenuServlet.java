package com.abc.controller;

import com.abc.model.MenuItem;
import com.abc.service.MenuService;
import com.abc.util.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;



/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuService menuService;
    
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
        super.init();
        try {
            Connection conn = DatabaseConnection.getConnection();
            menuService = new MenuService(conn);
        } catch (SQLException e) {
            throw new ServletException("Error initializing MenuService", e);
        }
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
            Map<String, List<MenuItem>> menuItems = menuService.getMenuItemsByCategory();
            request.setAttribute("menuItems", menuItems);
            request.getRequestDispatcher("/menu.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error retrieving menu items", e);
        }
    }
        
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
