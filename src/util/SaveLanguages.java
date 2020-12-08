package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SaveLanguages {

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader ("C:\\Users\\krysi\\eclipse-workspace\\desktop\\src\\resources\\languages.txt");
		
		BufferedReader br = new BufferedReader(fr);
		
		String languageName;
		String languageCode;
		
		String languageData;
		
		while ((languageData = br.readLine()) != null) {
			
			languageName = languageData.substring(0, languageData.length()-3);
			languageCode = languageData.substring(languageName.length() + 1);
			
			System.out.println(languageName + languageCode);
			
		}
	
		br.close();

	}

}
