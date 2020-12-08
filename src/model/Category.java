package model;

import java.util.List;
import java.util.Set;

public class Category {
	
	private static int totalCategories = 1;
	
	private long id;
	
	private String categoryName;
	
	private int initialLevel;
	
	private int finalLevel;
	
	public Category(String categoryName) {
		
		this.id = totalCategories;
		this.categoryName = categoryName;
		this.initialLevel = 1;
		this.finalLevel = 5;
		
		totalCategories++;
	}

	public long getId() {
		return id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public int getInitialLevel() {
		return initialLevel;
	}

	public int getFinalLevel() {
		return finalLevel;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setInitialLevel(int initialLevel) {
		this.initialLevel = initialLevel;
	}

	public void setFinalLevel(int finalLevel) {
		this.finalLevel = finalLevel;
	}	
	
	public String toString() {
		
		return categoryName;
		
	}

}
