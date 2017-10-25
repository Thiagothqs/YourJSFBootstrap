package com.yourcodelab.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yourcodelab.dao.CustomerDAO;
import com.yourcodelab.model.Customer;

public class CustomerService {
	CustomerDAO dao = new CustomerDAO();
	
	public List<Customer> listAll() throws SQLException{
		List<Customer> list = new ArrayList<Customer>();
			
		list = dao.listAll();
		
		return list;
	}
	
	public void insertCustomer(Customer c, boolean videogame, boolean series, boolean futebol) throws SQLException{
		if(videogame == true) {
			c.setVideogame(1);
		}
		else {
			c.setVideogame(0);
		}
		if(series == true) {
			c.setSeries(1);
		}
		else {
			c.setSeries(0);
		}
		if(futebol == true) {
			c.setFutebol(1);
		}
		else {
			c.setFutebol(0);
		}
		
		dao.salvar(c);
	}
	
	public List<Customer> findCustomerByName(String name) throws SQLException{
		List<Customer> list = new ArrayList<Customer>();
		
		if(!name.isEmpty()) {
			list = dao.findCustomerByName(name);
		}
		else {
			list = dao.listAll();
		}	
		
		return list;
	}
	
	public void updateCustomer(Customer c, boolean videogame, boolean series, boolean futebol) throws SQLException {
		if(videogame == true) {
			c.setVideogame(1);
		}
		else {
			c.setVideogame(0);
		}
		if(series == true) {
			c.setSeries(1);
		}
		else {
			c.setSeries(0);
		}
		if(futebol == true) {
			c.setFutebol(1);
		}
		else {
			c.setFutebol(0);
		}
		
		dao.update(c);
	}
	
	public void deleteCustomer(Customer c) throws SQLException {
		dao.delete(c);
	}
}
