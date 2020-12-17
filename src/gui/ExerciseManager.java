package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lib.duolingoproject.hibernate.dao.ExerciseTypeDaoImpl;
import lib.duolingoproject.hibernate.dao.i.IExerciseTypeDao;
import lib.duolingoproject.hibernate.model.Category;
import lib.duolingoproject.hibernate.model.Course;
import lib.duolingoproject.hibernate.model.ExerciseType;
import lib.duolingoproject.hibernate.model.Level;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;

public class ExerciseManager extends JFrame {
	
	public static Course course;
	public static Category category;
	public static Level level;
	public static List<ExerciseType> exercisesTypes;

	private JPanel contentPane;
	private JLabel lblIdiDest;
	private JLabel lblCategory;
	private Image image;
	private Icon icon;
	
	public ExerciseManager(Course course, Category category, Level level) {
		
		setIconImage(Interface.iconImage);
				
		this.course = course;
		this.category = category;
		this.level = level;
		
		IExerciseTypeDao exerciseTypeManager = new ExerciseTypeDaoImpl();
		
		exercisesTypes = exerciseTypeManager.getAllExercisesType();
		
		setBounds(200, 200, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblIdiOri = new JLabel("Idioma origen: " + course.getLanguageBase().getLanguageName());
		lblIdiOri.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		lblIdiDest = new JLabel("Idioma destino: " + course.getLanguageCourse().getLanguageName());
		lblIdiDest.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		lblCategory = new JLabel("Categoria: " + category.getCategoryName());
		lblCategory.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		JLabel lblLevel = new JLabel("Nivell: " + level.getLevelName());
		lblLevel.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		JButton btnTest = new JButton("");
		Image test = Toolkit.getDefaultToolkit().getImage(ExerciseManager.class.getResource("/image/test.png"));
		icon = new ImageIcon(test.getScaledInstance(100, 100, 100));
		btnTest.setIcon(icon);
		
		btnTest.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				
				addTestExercise addtestexercise = new addTestExercise();
				addtestexercise.setVisible(true);
				
			}
		});
		
		JButton btnOpenTrad = new JButton("");
		Image open_trad = Toolkit.getDefaultToolkit().getImage(ExerciseManager.class.getResource("/image/open_traduction.png"));
		icon = new ImageIcon(open_trad.getScaledInstance(100, 100, 100));
		btnOpenTrad.setIcon(icon);
		
		JButton btnTradReorWord = new JButton("");
		Image trad_reor_word = Toolkit.getDefaultToolkit().getImage(ExerciseManager.class.getResource("/image/translate_reorder_words.png"));
		icon = new ImageIcon(trad_reor_word.getScaledInstance(100, 100, 100));
		btnTradReorWord.setIcon(icon);
		
		JButton btnLisReorder = new JButton("");
		Image lisreorder = Toolkit.getDefaultToolkit().getImage(ExerciseManager.class.getResource("/image/reorder_listening.png"));
		icon = new ImageIcon(lisreorder.getScaledInstance(100, 100, 100));
		btnLisReorder.setIcon(icon);		
		
		JButton btnLisOpen = new JButton("");
		Image lisopen = Toolkit.getDefaultToolkit().getImage(ExerciseManager.class.getResource("/image/open_listening.png"));
		icon = new ImageIcon(lisopen.getScaledInstance(100, 100, 100));
		btnLisOpen.setIcon(icon);
		
		JButton btnPutAWord = new JButton("");
		Image putAword = Toolkit.getDefaultToolkit().getImage(ExerciseManager.class.getResource("/image/put_a_word.png"));
		icon = new ImageIcon(putAword.getScaledInstance(100, 100, 100));
		btnPutAWord.setIcon(icon);
		
		JButton btnPairMaking = new JButton("");
		Image pairmake = Toolkit.getDefaultToolkit().getImage(ExerciseManager.class.getResource("/image/pair_making.png"));
		icon = new ImageIcon(pairmake.getScaledInstance(100, 100, 100));
		btnPairMaking.setIcon(icon);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblIdiOri, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblIdiDest, Alignment.LEADING)
							.addComponent(lblCategory, Alignment.LEADING))
						.addComponent(lblLevel))
					.addPreferredGap(ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnPutAWord, 0, 0, Short.MAX_VALUE)
							.addComponent(btnLisReorder, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
							.addComponent(btnOpenTrad, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
						.addGap(59))
					.addGap(5)
					.addComponent(btnTest, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnPairMaking, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(btnTradReorWord, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnLisOpen, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
					.addGap(89))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(64)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblIdiOri)
							.addGap(31)
							.addComponent(lblIdiDest)
							.addGap(31)
							.addComponent(lblCategory))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnTest, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnOpenTrad, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTradReorWord, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addComponent(btnLisOpen, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(lblLevel)
							.addComponent(btnLisReorder, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPairMaking, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPutAWord, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
