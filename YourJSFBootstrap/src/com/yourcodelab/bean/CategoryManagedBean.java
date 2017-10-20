package com.yourcodelab.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.yourcodelab.model.Category;
import com.yourcodelab.service.CategoryService;

@ManagedBean(name = "categoryManagedBean")
@SessionScoped
public class CategoryManagedBean implements Serializable {
	private static final long serialVersionUID = -4211750794309016710L;
	
	private Category category;
	private List<Category> listCategory;
	private CategoryService service;
	
	public CategoryManagedBean() {
		category = new Category(0, "");
		service = new CategoryService();
		listCategory = service.listAll();
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}
}
