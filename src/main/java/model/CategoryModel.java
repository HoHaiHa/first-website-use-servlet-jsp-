package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "category")
@Table(name = "category")
public class CategoryModel {
	@Id
	@GeneratedValue
	@Column(name = "[cateId]")
	private int cateId;
	@Column(name = "[cateName]")
	private String cateName;
	
	
	public CategoryModel(int cateId, String cateName) {
		super();
		this.cateId = cateId;
		this.cateName = cateName;
	}
	
	
	public CategoryModel() {
		super();
	}


	public int getCateId() {
		return cateId;
	}
	public void setCateId(int cateId) {
		this.cateId = cateId;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String string) {
		this.cateName = string;
	}
}
