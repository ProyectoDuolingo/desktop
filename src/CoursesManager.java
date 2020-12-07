import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class CoursesManager extends JFrame {

	private JPanel contentPane;
	
	private JLabel lblManageCourses;
	private JLabel lblLanguageBase;
	private JLabel lblLanguageCourse;
	private JButton btnApplyFilter;
	private JComboBox cmbLanguageBase;
	private JComboBox cmbLanguageCourse;
	private JLabel lblLevels;
	private JLabel lblCategories;
	private JLabel lblCourses;
	private JList listCourses;
	private JList listCategories;
	private JList listLevels;
	private JButton btnNewCourse;
	private JButton btnNewCategory;
	private JButton btnNewLevel;
	private JButton btnNewExercise;
	private JButton btnShowExercises;
	private GroupLayout glContentPane;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					CoursesManager frame = new CoursesManager();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
			}
			
		});
		
	}

	/**
	 * Create the frame.
	 */
	public CoursesManager() {
		
		setIconImage(Main.iconImage);
		
		setBounds(100, 100, 1277, 790);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblManageCourses = new JLabel("Cursos existentes (filtrar por origen y/o destino)");
		
		lblLanguageBase = new JLabel("Idioma de origen");
		
		lblLanguageCourse = new JLabel("Idioma de destino");
		
		btnApplyFilter = new JButton("Aplicar filtro");
		
		cmbLanguageBase = new JComboBox();
		
		cmbLanguageCourse = new JComboBox();
		
		btnNewCourse = new JButton("Crear curso");
		
		lblLevels = new JLabel("Niveles de la categoría seleccionada");
		
		lblCategories = new JLabel("Categorías del curso seleccionado");
		
		lblCourses = new JLabel("Cursos");
		
		listCourses = new JList();
		
		listCategories = new JList();
		
		listLevels = new JList();
		
		btnNewCategory = new JButton("Añadir categoría");
		
		btnNewLevel = new JButton("Añadir nivel");
		
		btnNewExercise = new JButton("AÑADIR PREGUNTA");
		
		btnShowExercises = new JButton("VISUALIZAR PREGUNTAS");
		
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
										.addComponent(listCategories, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
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
												.addComponent(listCourses, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
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
						.addComponent(listCourses, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
						.addComponent(listCategories, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
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
}
