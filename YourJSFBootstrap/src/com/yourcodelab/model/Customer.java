package com.yourcodelab.model;

public class Customer {
	private Integer id;
	private String name;
	private String email;
	private Category category;
	
	private Integer videogame;
	private Integer series;
	private Integer futebol;
	private Integer fumante;
	
	public Customer(Integer id, String name, String email, Category category, Integer videogame, Integer series, Integer futebol, Integer fumante){
		this.id = id;
		this.name = name;
		this.email = email;
		this.category = category;
		this.videogame = videogame;
		this.series = series;
		this.futebol = futebol;
		this.fumante = fumante;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Integer getVideogame() {
		return videogame;
	}

	public void setVideogame(Integer videogame) {
		this.videogame = videogame;
	}

	public Integer getSeries() {
		return series;
	}

	public void setSeries(Integer series) {
		this.series = series;
	}

	public Integer getFutebol() {
		return futebol;
	}

	public void setFutebol(Integer futebol) {
		this.futebol = futebol;
	}

	public Integer getFumante() {
		return fumante;
	}

	public void setFumante(Integer fumante) {
		this.fumante = fumante;
	}

}
