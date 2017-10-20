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
	
	public CustomerManagedBean() throws SQLException{
		service = new CustomerService();
		category = new Category(0, "");
		customer = new Customer(0, "", "", category, 0, 0, 0, 0);
		listCustomer = service.listAll();
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String searchByNameAction() throws SQLException{
		System.out.println("Searching...");
		this.listCustomer = service.findCustomerByName(customer.getName());
		
		return "index";
	}
	
	public String insertCustomerAction() throws SQLException{
		System.out.println("Saving...");
		service.insertCustomer(customer);
		
		this.listCustomer = service.listAll();
		
		return "index";
	}
	
	public String updateCustomerAction() throws SQLException{
		System.out.println("Updating...");
		service.updateCustomer(customer);
		this.listCustomer = service.listAll();
		
		return "index";
	}
	
	public void deleteCustomerAction() throws SQLException {
		System.out.println("Deleting...");
		service.deleteCustomer(customer);
		listCustomer = service.listAll();
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
	
}
