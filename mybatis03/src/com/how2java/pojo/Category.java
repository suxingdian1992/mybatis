package com.how2java.pojo;

import java.util.List;

public class Category {
	private int id;
	private String name;
	List<Product> products;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 此处在直接使用syso的时候默认会调用该方法来输出
	 */
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
