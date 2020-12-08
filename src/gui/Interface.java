package gui;
import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import model.*;

class Interface extends JFrame {
	
	public static Image iconImage;
	
	public static List<Language> languagesList;
	public static List<Course> coursesList;
	
	private JMenuBar menuBar;
	private JMenu menu;	

	private JPanel contentPane;
	private JMenuItem menuCoursesManager;
	private JMenuItem menuOthers;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					Interface frame = new Interface();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
					
					getLanguages();
					getCourses();
					
				} catch (Exception e) {
					
					e.printStackTrace();
					
				}
				
			}
			
		});
		
	}

	public Interface() {
		
		iconImage = Toolkit.getDefaultToolkit().getImage(Interface.class.getResource("/image/duolingo_icon.png"));
		
		setIconImage(iconImage);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menu = new JMenu("Menu principal");
		menuBar.add(menu);
		
		menuCoursesManager = new JMenuItem("Administrar cursos");
		menu.add(menuCoursesManager);
		
		menuCoursesManager.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				CoursesManager coursesManager = new CoursesManager();
				Interface frame = new Interface();

				frame.setVisible(false);
				coursesManager.setVisible(true);
				
			}			
			
		});
		
		menuOthers = new JMenuItem("Otros");
		
		menu.add(menuOthers);
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setContentPane(contentPane);
		
	}
	
	public static void getLanguages() throws IOException {
		
		languagesList = new ArrayList<Language>();
		
		languagesList.add(new Language("Seleccione un idioma", "XX"));
		
		FileReader fr = new FileReader ("src/resources/languages.txt");
			
		BufferedReader br = new BufferedReader(fr);
		
		String languageName;
		String languageCode;
		
		String languageData;
		
		while ((languageData = br.readLine()) != null) {
			
			languageName = languageData.substring(0, languageData.length()-3);
			languageCode = languageData.substring(languageName.length() + 1);
			
			languagesList.add(new Language(languageName, languageCode));
			
		}
	
		br.close();
		
	}
	
	public static void getCourses() {
		
		coursesList = new ArrayList<Course>();
		
		Course c1 = new Course(languagesList.get(1), languagesList.get(2));
		Course c2 = new Course(languagesList.get(2), languagesList.get(3));
		Course c3 = new Course(languagesList.get(3), languagesList.get(4));
		Course c4 = new Course(languagesList.get(1), languagesList.get(4));
		
		coursesList.add(c1);
		coursesList.add(c2);
		coursesList.add(c3);
		coursesList.add(c4);
		
	}

}
