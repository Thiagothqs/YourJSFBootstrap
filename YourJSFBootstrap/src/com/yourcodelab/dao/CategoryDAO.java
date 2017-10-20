package com.yourcodelab.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yourcodelab.model.Category;

public class CategoryDAO extends GenericDAO{
	private PreparedStatement ps;
	private String LISTAR="SELECT * FROM CATEGORY;";
	
	public List<Category> listAll () throws SQLException {
		openConnection();
		
		ps = connect.prepareStatement(LISTAR);
		
		ResultSet rs = ps.executeQuery();
		List<Category> list = new ArrayList<Category>();
		
		while(rs.next()) {
			list.add(new Category(rs.getInt("id"), rs.getString("description")));
		}
		
		closeConnection();
		
		return list;
	}
}
