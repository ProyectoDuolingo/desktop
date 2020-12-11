package model;

public class Level {
		
		private long id;
		private String levelName;
		
		private static int totalLevels = 1;
		
		public Level(String levelName) {
			
			this.id = totalLevels;
			this.levelName = levelName;
			
		}


}
	
