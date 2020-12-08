package model;

import java.util.ArrayList;
import java.util.List;

public class Course {
	
	private static int totalCourses = 1;

	private long id;
	
	private Language languageBase;
	
	private Language languageCourse;
	
	private List<Category> categoriesList;
	
	public Course(Language languageBase, Language languageCourse) {
		
		this.id = totalCourses;
		this.languageBase = languageBase;
		this.languageCourse = languageCourse;
		this.categoriesList = new ArrayList<Category>();
		
		totalCourses++;
		
	}

	public long getId() {
		return id;
	}

	public Language getLanguageBase() {
		return languageBase;
	}

	public Language getLanguageCourse() {
		return languageCourse;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setLanguageBase(Language languageBase) {
		this.languageBase = languageBase;
	}

	public void setLanguageCourse(Language languageCourse) {
		this.languageCourse = languageCourse;
	}	
	
	public String toString() {
		
		return languageBase + " - " + languageCourse;
		
	}

	public List<Category> getCategoriesList() {
		return categoriesList;
	}
	
	public void addCategory(Category c) {
		
		this.categoriesList.add(c);
		
	}

	public void setCategoriesList(List<Category> categoriesList) {
		this.categoriesList = categoriesList;
	}
	
	
	
}
