package com.yourcodelab.service;

import java.sql.SQLException;
import java.util.List;

import com.yourcodelab.dao.CategoryDAO;
import com.yourcodelab.model.Category;

public class CategoryService {
	CategoryDAO dao = new CategoryDAO();
	
	public List<Category> listAll(){
		try {
			return dao.listAll();
		} catch (SQLException e) {
			return null;
		}
	}
}
