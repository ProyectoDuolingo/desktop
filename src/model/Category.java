package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Category {
	
	private static int totalCategories = 1;
	
	private long id;
	
	private String categoryName;
	
	private int initialLevel;
	
	private int finalLevel;
	
	private List<Level> levelsList;
	
	public Category(String categoryName) {
		
		this.id = totalCategories;
		this.categoryName = categoryName;
		this.initialLevel = 1;
		this.finalLevel = 5;
		this.levelsList = new ArrayList<Level>();
		
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
	
	public List<Level> getLevelsList() {
		return levelsList;
	}
	
	public void setCategoriesList(List<Level> levelsList) {
		this.levelsList = levelsList;
	}
	
	public String toString() {
		
		return categoryName;
		
	}
	
	public void addLevel(Level l) {
		
		this.levelsList.add(l);
		
	}

}