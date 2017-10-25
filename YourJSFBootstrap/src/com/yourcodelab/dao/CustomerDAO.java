package com.yourcodelab.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yourcodelab.model.Category;
import com.yourcodelab.model.Customer;

public class CustomerDAO extends GenericDAO{
	PreparedStatement ps;
	
	private String INSERT_CUSTOMER = "INSERT INTO CUSTOMER VALUES(?, ?, ?, ?, ?, ?, ?);";
	private String LISTAR_TODOS = "select customer.*, Category.description from Customer inner join Category on Customer.idCategory = Category.id;";
	private String ALTERAR = "UPDATE CUSTOMER SET NAME = ?, EMAIL = ?, IDCATEGORY = ?, VIDEOGAME = ?, SERIES = ?, FUTEBOL = ?, FUMANTE = ? WHERE ID=?;";
	private String EXCLUIR = "DELETE CUSTOMER WHERE ID=?;";
	private String PROCURAR_NOME = "select customer.*, Category.description from Customer inner join Category on Customer.idCategory = Category.id where name like ?";
	
	public void salvar(Customer c) throws SQLException {
		openConnection();
		
		ps = connect.prepareStatement(INSERT_CUSTOMER);
		
		ps.setString(1, c.getName());
		ps.setString(2, c.getEmail());
		ps.setInt(3, c.getCategory().getId());
		ps.setInt(4, c.getVideogame());
		ps.setInt(5, c.getSeries());
		ps.setInt(6, c.getFutebol());
		ps.setInt(7, c.getFumante());
		
		ps.execute();
		
		closeConnection();
	}
	
	public void update(Customer c) throws SQLException{
		openConnection();
		
		ps = connect.prepareStatement(ALTERAR);
		ps.setString(1, c.getName());
		ps.setString(2, c.getEmail());
		ps.setInt(3, c.getCategory().getId());
		ps.setInt(4, c.getVideogame());
		ps.setInt(5, c.getSeries());
		ps.setInt(6, c.getFutebol());
		ps.setInt(7, c.getFumante());
		ps.setInt(8, c.getId());
		
		ps.execute();
		
		closeConnection();
	}
	
	public List<Customer> listAll() throws SQLException{
		List<Customer> lista = new ArrayList<Customer>();
		
		openConnection();
		
		ps = connect.prepareStatement(LISTAR_TODOS);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs != null) {
			while(rs.next()) {
				Category  category= new Category(rs.getInt("idCategory"), rs.getString("description"));
				Customer c = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("email"), category, rs.getInt("videogame"), rs.getInt("series"), rs.getInt("futebol"), rs.getInt("fumante"));
				lista.add(c);
			}
		}
		
		closeConnection();
		
		return lista;
	}
	
	public void delete(Customer c) throws SQLException {
		openConnection();
		
		ps = connect.prepareStatement(EXCLUIR);
		ps.setInt(1, c.getId());
		
		ps.execute();
		
		closeConnection();
	}
	
	public List<Customer> findCustomerByName(String name) throws SQLException{
		List<Customer> lista = new ArrayList<Customer>();
		
		openConnection();
		
		ps = connect.prepareStatement(PROCURAR_NOME);
		ps.setString(1, name + "%");
		
		ResultSet rs = ps.executeQuery();
		
		if(rs!=null) {
			while(rs.next()) {
				Category  category= new Category(rs.getInt("idCategory"), rs.getString("description"));
				Customer c = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("email"), category, rs.getInt("videogame"), rs.getInt("series"), rs.getInt("futebol"), 0);//rs.getInt("fumante")
				lista.add(c);
			}
		}
		
		closeConnection();
		return lista;
	}
}
