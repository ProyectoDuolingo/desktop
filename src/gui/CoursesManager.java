package gui;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import lib.duolingoproject.hibernate.model.*;
import lib.duolingoproject.hibernate.util.JSONObjectConverter;
import lib.duolingoproject.hibernate.dao.*;
import lib.duolingoproject.hibernate.dao.i.*;

public class CoursesManager extends JFrame {
	
	private List<Course> coursesList; 
	private List<Language> languagesList;
	private List<Category> categoriesList;
	private List<Level> levelsList;
	private List<Exercise> exercisesList;

	private JPanel contentPane;
	
	private JLabel lblManageCourses;
	private JLabel lblLanguageBase;
	private JLabel lblLanguageCourse;
	private JButton btnApplyFilter;
	private JComboBox<Language> cmbLanguageBase;
	private JComboBox<Language> cmbLanguageCourse;
	private JLabel lblLevels;
	private JLabel lblCategories;
	private JLabel lblCourses;
	private DefaultListModel<Course> listModelCourses;
	private JList<Course> listCourses;
	private DefaultListModel<Category> listModelCategories;
	private JList<Category> listCategories;
	private DefaultListModel<Level> listModelLevels;
	private JList<Level> listLevels;
	private JButton btnNewCourse;
	private JButton btnNewCategory;
	private JButton btnNewLevel;
	private JButton btnNewExercise;
	private JButton btnShowExercises;
	private GroupLayout glContentPane;

	public CoursesManager() {
		
		setIconImage(Interface.iconImage);
		
		setBounds(100, 100, 1277, 790);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		try {
			
//			createLanguages();
			getLanguages();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		lblManageCourses = new JLabel("Cursos existentes (filtrar por origen y/o destino)");
		
		lblLanguageBase = new JLabel("Idioma de origen");
		
		lblLanguageCourse = new JLabel("Idioma de destino");
		
		btnApplyFilter = new JButton("Aplicar filtro");
		
		btnApplyFilter.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				ICourseDao courseManager = new CourseDaoImpl();
				
				listModelCourses = new DefaultListModel<Course>();
				
				listCourses.setModel(listModelCourses);
				
				listModelCategories = new DefaultListModel<Category>();
				
				listCategories.setModel(listModelCategories);
				
				listModelLevels = new DefaultListModel<Level>();
				
				listLevels.setModel(listModelLevels);
				
				btnNewCategory.setEnabled(false);
				
				if (cmbLanguageBase.getSelectedIndex() == 0 && cmbLanguageCourse.getSelectedIndex() == 0) {					
					
					JOptionPane.showMessageDialog(null, "Asegúrese de seleccionar como mínimo un idioma origen o un idioma destino.");
					
					return;
					
				} else if (cmbLanguageBase.getSelectedIndex() == cmbLanguageCourse.getSelectedIndex()) {
					
					JOptionPane.showMessageDialog(null, "Asegúrese de no seleccionar el mismo idioma como origen y destino.");
					
					return;
					
				} else {
					
					updateCoursesList();
					
				}
				
			}
			
		});
		
		cmbLanguageBase = new JComboBox();		
		cmbLanguageCourse = new JComboBox();
		
		setCmbOptions();
		
		btnNewCourse = new JButton("Crear curso");
		
		btnNewCourse.setEnabled(false);
		
		btnNewCourse.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {				
				
				ICourseDao courseManager = new CourseDaoImpl();
				
				Course c = new Course(languagesList.get(cmbLanguageBase.getSelectedIndex()), languagesList.get(cmbLanguageCourse.getSelectedIndex()));

				courseManager.saveCourse(c);				
				
				coursesList.add(c);
				
				listModelCourses.addElement(c);
				
				listCourses.setModel(listModelCourses);
				
				btnNewCourse.setEnabled(false);
				
			}
			
		});
		
		lblLevels = new JLabel("Niveles de la categorï¿½a seleccionada");
		
		lblCategories = new JLabel("Categorï¿½as del curso seleccionado");
		
		lblCourses = new JLabel("Cursos");
		
		listCourses = new JList();
		
		listCourses.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent me) {
				
				JList source = (JList) me.getSource();
				
				int index =  source.getSelectedIndex();
				
				if (index >= 0) {
					
					btnNewCategory.setEnabled(true);
					
					updateCategoriesList();
					
					listModelLevels = new DefaultListModel<Level>();
					
					listLevels.setModel(listModelLevels);					
					
				}
				
			}
			
		});
		
		listCategories = new JList();
		
		listCategories.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent me) {
				
				JList source = (JList) me.getSource();
				
				int index =  source.getSelectedIndex();
				
				if (index >= 0) {
					
					btnNewLevel.setEnabled(true);
					
					updateLevelsList();
					
				}
				
			}
			
		});		
		
		listLevels = new JList();
		
		btnNewCategory = new JButton("Aï¿½adir categorï¿½a");
		
		btnNewCategory.setEnabled(false);
		
		btnNewCategory.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				listModelLevels = new DefaultListModel<Level>();
				
				listLevels.setModel(listModelLevels);
				
				ICategoryDao categoryManager = new CategoryDaoImpl();

				String categoryName = JOptionPane.showInputDialog("Introduce el nombre de la categorï¿½a: ");
				
				Category c = new Category(categoryName , listCourses.getSelectedValue());
				
				categoriesList.add(c);
				
				categoryManager.saveCategory(c);
							
				listCourses.getSelectedValue().addCategory(c);
				
				listModelCategories.addElement(c);
				
				listCategories.setModel(listModelCategories);
				
			}
			
		});
		
		btnNewLevel = new JButton("Aï¿½adir nivel");
		
		btnNewLevel.setEnabled(false);
		
		btnNewLevel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ILevelDao levelManager = new LevelDaoImpl();
				
				String levelName = JOptionPane.showInputDialog("Introduce el nombre del nivel: ");
				
				Level l = new Level(levelName, listCategories.getSelectedValue());
				
				levelsList.add(l);
				
				listCategories.getSelectedValue().addLevel(l);
				
				levelManager.saveLevel(l);
				
				
				
				listModelLevels.addElement(l);
				
				listLevels.setModel(listModelLevels);
				
			}
			
		});
		
		btnNewExercise = new JButton("AÃ‘ADIR PREGUNTA");
		
		btnNewExercise.setEnabled(true);
		
		btnNewExercise.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				IExerciseDao exerciseManager = new ExerciseDaoImpl();
				
				if (listLevels.getSelectedValue() != null) {
					
					JSONObjectConverter JSONManager;
					
				} else {
					
					JOptionPane.showMessageDialog(null, "AsegÃºrese de seleccionar un nivel al que aÃ±adir el ejercicio.");
					
				}
				
//				Exercise e = new Exercise(levelName, listCategories.getSelectedValue(), JSONManager.createExerciseTestJSON("original", "translated", "mistake1", "mistake2"));
				
//				exercisesList.add(e);
//				
//				exerciseManager.saveExercise(e);
				
			}
			
		});
		
		btnShowExercises = new JButton("VISUALIZAR PREGUNTAS");
		
		btnShowExercises.setEnabled(true);
		
		glContentPane = new GroupLayout(contentPane);
		
		glContentPane.setHorizontalGroup(
			glContentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(glContentPane.createSequentialGroup()
					.addGroup(glContentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(glContentPane.createSequentialGroup()
							.addGroup(glContentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(glContentPane.createSequentialGroup()
									.addGap(88)
									.addComponent(cmbLanguageBase, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
								.addGroup(glContentPane.createSequentialGroup()
									.addGap(72)
									.addComponent(lblLanguageBase))
								.addGroup(glContentPane.createSequentialGroup()
									.addGap(60)
									.addGroup(glContentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(listCourses, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
										.addComponent(lblCourses))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(glContentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(glContentPane.createSequentialGroup()
									.addGroup(glContentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(glContentPane.createSequentialGroup()
											.addGap(147)
											.addComponent(cmbLanguageCourse, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
										.addGroup(glContentPane.createSequentialGroup()
											.addGap(117)
											.addGroup(glContentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblCategories, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
												.addComponent(listCategories, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
												.addComponent(btnNewCategory, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
									.addPreferredGap(ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
									.addGroup(glContentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(listLevels, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
										.addComponent(lblLevels)
										.addComponent(btnNewCourse, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnApplyFilter, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewLevel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(glContentPane.createSequentialGroup()
									.addGap(131)
									.addComponent(lblLanguageCourse))))
						.addGroup(glContentPane.createSequentialGroup()
							.addGap(36)
							.addGroup(glContentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(glContentPane.createSequentialGroup()
									.addComponent(lblManageCourses)
									.addPreferredGap(ComponentPlacement.RELATED, 784, Short.MAX_VALUE))
								.addGroup(glContentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
									.addGroup(glContentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnNewExercise, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnShowExercises, GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE))))))
					.addGap(104))
		);
		
		glContentPane.setVerticalGroup(
			glContentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(glContentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(glContentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(glContentPane.createSequentialGroup()
							.addComponent(lblManageCourses)
							.addGap(42))
						.addGroup(glContentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblLanguageCourse)
							.addComponent(lblLanguageBase)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glContentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbLanguageCourse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbLanguageBase, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnApplyFilter, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addComponent(btnNewCourse, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(75)
					.addGroup(glContentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategories)
						.addComponent(lblCourses)
						.addComponent(lblLevels))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(glContentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(listCategories, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
						.addComponent(listCourses, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
						.addComponent(listLevels, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(glContentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewCategory)
						.addComponent(btnNewLevel))
					.addGap(18)
					.addComponent(btnNewExercise)
					.addGap(18)
					.addComponent(btnShowExercises)
					.addContainerGap(77, Short.MAX_VALUE))
		);
		
		contentPane.setLayout(glContentPane);
		
	}
	
	public void setCmbOptions() {
				
		for (int i = 0; i < languagesList.size(); i++) {
			
			cmbLanguageBase.addItem(languagesList.get(i));
			cmbLanguageCourse.addItem(languagesList.get(i));
			
		}		
		
	}
	
	public void getLanguages() throws IOException {
		
		ILanguageDao languageManager = new LanguageDaoImpl();
		
		languagesList = languageManager.getAllLanguages();
		
		languagesList.add(0, new Language("Seleccione un idioma", "XX"));
		
	}
	
	public void updateCoursesList() {
		
		ICourseDao courseManager = new CourseDaoImpl();
		
		coursesList = courseManager.getAllCoursesByLanguagesId(cmbLanguageBase.getSelectedIndex(), cmbLanguageCourse.getSelectedIndex());
		
		listModelCourses = new DefaultListModel<Course>();
				
		if (coursesList.size() == 0 && cmbLanguageBase.getSelectedIndex() != 0 && cmbLanguageCourse.getSelectedIndex() != 0) {
			
			btnNewCourse.setEnabled(true);
			
		} else {
			
			btnNewCourse.setEnabled(false);
			
			for (Course c : coursesList) {
				
				listModelCourses.addElement(c);
				
			}			
			
		}
	
		listCourses.setModel(listModelCourses);
		
	}
	
	public void updateCategoriesList() {
		
		ICategoryDao categoryManager = new CategoryDaoImpl();
		
		categoriesList = categoryManager.getAllCategoriesByCourseId(listCourses.getSelectedValue().getId());
		
		listModelCategories = new DefaultListModel<Category>();
		
		for (Category c : categoriesList) {
			
			listModelCategories.addElement(c);
			
		}
		
		listCategories.setModel(listModelCategories);
		
	}
	
	public void updateLevelsList() {
		
		ILevelDao levelManager = new LevelDaoImpl();
		
		levelsList = levelManager.getAllLevelsByCategoryId(listCategories.getSelectedValue().getId());
		
		listModelLevels = new DefaultListModel<Level>();
		
		for (Level l : levelsList) {
			
			listModelLevels.addElement(l);
			
		}
		
		listLevels.setModel(listModelLevels);
		
	}
	
	public void createLanguages() throws IOException {
		
		ILanguageDao languageManager = new LanguageDaoImpl();
				
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
			
			languageManager.saveLanguage(new Language(languageName, languageCode));
			
			languagesList.add(new Language(languageName, languageCode));
			
		}
	
		br.close();
		
	}
	
}
