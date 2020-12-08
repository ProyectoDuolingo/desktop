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
import java.awt.event.ActionEvent;

import model.*;

public class CoursesManager extends JFrame {

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
	private JList listLevels;
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
		
		lblManageCourses = new JLabel("Cursos existentes (filtrar por origen y/o destino)");
		
		lblLanguageBase = new JLabel("Idioma de origen");
		
		lblLanguageCourse = new JLabel("Idioma de destino");
		
		btnApplyFilter = new JButton("Aplicar filtro");
		
		btnApplyFilter.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				listModelCourses = new DefaultListModel<Course>();
				
				if (cmbLanguageBase.getSelectedIndex() == 0 && cmbLanguageCourse.getSelectedIndex() == 0) {
					
					JOptionPane.showMessageDialog(null, "Asegurese de seleccionar como minimo un idioma origen o un idioma destino.");
					
				} else if (cmbLanguageBase.getSelectedIndex() == cmbLanguageCourse.getSelectedIndex()) {
					
					JOptionPane.showMessageDialog(null, "Asegurese de no seleccionar el mismo idioma como origen y destino.");
					
				} else if (cmbLanguageBase.getSelectedIndex() == 0) {
									
					for (int i = 0; i < Interface.coursesList.size(); i++) {
						
						if (Interface.coursesList.get(i).getLanguageCourse().getId() == cmbLanguageCourse.getSelectedIndex()) {
														
							listModelCourses.addElement(Interface.coursesList.get(i));
							
						}
						
					}
					
				} else if (cmbLanguageCourse.getSelectedIndex() == 0) {
					
					for (int i = 0; i < Interface.coursesList.size(); i++) {
						
						if (Interface.coursesList.get(i).getLanguageBase().getId() == cmbLanguageBase.getSelectedIndex()) {	
												
							listModelCourses.addElement(Interface.coursesList.get(i));
							
						}
						
					}
					
				} else {
					
					for (int i = 0; i < Interface.coursesList.size(); i++) {
						
						if (Interface.coursesList.get(i).getLanguageBase().getId() == cmbLanguageBase.getSelectedIndex() && Interface.coursesList.get(i).getLanguageCourse().getId() == cmbLanguageCourse.getSelectedIndex()) {
												
							listModelCourses.addElement(Interface.coursesList.get(i));
							
						}
						
					}
					
				}
				
				updateCoursesList(listModelCourses);
				listModelCategories = new DefaultListModel<Category>();
				listCategories.setModel(listModelCategories);
				btnNewCategory.setEnabled(false);
				
			}
			
		});
		
		cmbLanguageBase = new JComboBox();		
		cmbLanguageCourse = new JComboBox();
		
		setCmbOptions();
		
		btnNewCourse = new JButton("Crear curso");
		
		btnNewCourse.setEnabled(false);
		
		btnNewCourse.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Course c = new Course(Interface.languagesList.get(cmbLanguageBase.getSelectedIndex()), Interface.languagesList.get(cmbLanguageCourse.getSelectedIndex()));
				
				Interface.coursesList.add(c);
				
				listModelCourses.addElement(c);
				
				listCourses.setModel(listModelCourses);
				
				btnNewCourse.setEnabled(false);
				
			}
			
		});
		
		lblLevels = new JLabel("Niveles de la categoría seleccionada");
		
		lblCategories = new JLabel("Categorías del curso seleccionado");
		
		lblCourses = new JLabel("Cursos");
		
		listCourses = new JList();
		
		listCourses.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent me) {
				
				JList source = (JList) me.getSource();
				
				int index =  source.getSelectedIndex();
				
				if (index >= 0) {
					
					btnNewCategory.setEnabled(true);
					
					updateCategoriesList();
					
				}
				
			}
			
		});
		
		listCategories = new JList();
		
		listLevels = new JList();
		
		btnNewCategory = new JButton("Añadir categoría");
		
		btnNewCategory.setEnabled(false);
		
		btnNewCategory.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				Category c = new Category("Categoría " + (Interface.coursesList.get((int) listCourses.getSelectedValue().getId() - 1).getCategoriesList().size() + 1));
				
				Interface.coursesList.get((int) listCourses.getSelectedValue().getId() - 1).addCategory(c);
				
				listModelCategories.addElement(c);
				
				listCategories.setModel(listModelCategories);
				
			}
		});
		
		btnNewLevel = new JButton("Añadir nivel");
		
		btnNewLevel.setEnabled(false);
		
		btnNewExercise = new JButton("AÑADIR PREGUNTA");
		
		btnNewExercise.setEnabled(false);
		
		btnShowExercises = new JButton("VISUALIZAR PREGUNTAS");
		
		btnShowExercises.setEnabled(false);
		
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
				
		for (int i = 0; i < Interface.languagesList.size(); i++) {
			
			cmbLanguageBase.addItem(Interface.languagesList.get(i));
			cmbLanguageCourse.addItem(Interface.languagesList.get(i));
			
		}		
		
	}
	
	public void updateCoursesList(DefaultListModel<Course> listModelCourses) {
		
		if (listModelCourses.getSize() == 0 && cmbLanguageBase.getSelectedIndex() != 0 && cmbLanguageCourse.getSelectedIndex() != 0) {
			
			btnNewCourse.setEnabled(true);
			
		} else {
			
			btnNewCourse.setEnabled(false);
			
		}
	
		listCourses.setModel(listModelCourses);
		
	}
	
	public void updateCategoriesList() {
		
		listModelCategories = new DefaultListModel<Category>();
		
		Course c = Interface.coursesList.get((int) listCourses.getSelectedValue().getId() - 1);
		
		for (int i = 0; i < c.getCategoriesList().size(); i++) {
			
			listModelCategories.addElement(c.getCategoriesList().get(i));
			
		}
		
		listCategories.setModel(listModelCategories);
		
	}
	
}
