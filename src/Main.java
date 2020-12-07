import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class Main extends JFrame {
	
	public static Image iconImage;
	
	private JMenuBar menuBar;
	private JMenu menu;	

	private JPanel contentPane;
	private JMenuItem menuCoursesManager;
	private JMenuItem menuOthers;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					Main frame = new Main();
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
	public Main() {
		
		iconImage = Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/image/duolingo_icon.png"));
		
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
				Main frame = new Main();

				frame.setVisible(false);
				coursesManager.setVisible(true);
				coursesManager.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
			}			
			
		});
		
		menuOthers = new JMenuItem("Otros");
		
		menu.add(menuOthers);
				
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setContentPane(contentPane);
		
	}

}
