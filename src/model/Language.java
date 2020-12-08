package model;

public class Language {
	
	private static int totalLanguages = 0;
	
	private int id;
	
	private String languageName;
	
	private String code;

	public Language(String languageName, String code) {
		
		this.id = totalLanguages;
		this.languageName = languageName;
		this.code = code;
		
		totalLanguages++;
		
	}

	public int getId() {
		return id;
	}

	public String getLanguageName() {
		return languageName;
	}

	public String getCode() {
		return code;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String toString() {
		
		return languageName;
		
	}
		
}
