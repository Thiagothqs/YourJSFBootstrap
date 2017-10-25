package com.yourcodelab.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.yourcodelab.model.Category;
import com.yourcodelab.model.Customer;
import com.yourcodelab.service.CustomerService;

@ManagedBean(name = "customerManagedBean")
@SessionScoped
public class CustomerManagedBean implements Serializable{
	private static final long serialVersionUID = -9004785433894347006L;
	
	private Customer customer;
	private List<Customer> listCustomer;
	private CustomerService service;
	private Category category;
	
	private boolean videogame;
	private boolean series;
	private boolean futebol;
	
	public CustomerManagedBean() throws SQLException{
		service = new CustomerService();
		category = new Category(0, "");
		customer = new Customer(0, "", "", category, 0, 0, 0, 0);
		listCustomer = service.listAll();
	}

	public void searchByNameAction() throws SQLException{
		System.out.println("Searching...");
		this.listCustomer = service.findCustomerByName(customer.getName());
		
	}
	
	public String insertCustomerAction() throws SQLException{
		System.out.println("Saving...");
		service.insertCustomer(customer, isVideogame(), isSeries(), isFutebol());
		
		this.listCustomer = service.listAll();
		
		return "index";
	}
	
	public String updateCustomerAction() throws SQLException{
		System.out.println("Updating...");
		service.updateCustomer(customer, isVideogame(), isSeries(), isFutebol());
		this.listCustomer = service.listAll();
		
		return "index";
	}
	
	public void deleteCustomerAction() throws SQLException {
		System.out.println("Deleting...");
		service.deleteCustomer(customer);
		listCustomer = service.listAll();
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getListCustomer() {
		return listCustomer;
	}

	public void setListCustomer(List<Customer> listCustomer) {
		this.listCustomer = listCustomer;
	}

	public boolean isVideogame() {
		return videogame;
	}

	public void setVideogame(boolean videogame) {
		this.videogame = videogame;
	}

	public boolean isSeries() {
		return series;
	}

	public void setSeries(boolean series) {
		this.series = series;
	}

	public boolean isFutebol() {		
		return futebol;
	}

	public void setFutebol(boolean futebol) {
		this.futebol = futebol;
	}
	
}
