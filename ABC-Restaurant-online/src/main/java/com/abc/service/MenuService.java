package com.abc.service;

import com.abc.dao.MenuDAO;
import com.abc.model.MenuItem;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class MenuService {
	
	private MenuDAO menuDAO;

    public MenuService(Connection conn) {
        this.menuDAO = new MenuDAO(conn);
    }

    // Business logic method to get menu items by category
    public Map<String, List<MenuItem>> getMenuItemsByCategory() throws SQLException {
        return menuDAO.getMenuItemsByCategory();
    }
}
