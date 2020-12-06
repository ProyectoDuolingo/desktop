import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class Desktop_main extends JFrame {

	private JPanel contentPane;
	private JMenuItem menu_adminCursos;
	private JMenuItem menu_altres;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Desktop_main frame = new Desktop_main();
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
	public Desktop_main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu principal");
		menuBar.add(mnMenu);
		
		menu_adminCursos = new JMenuItem("Administrar cursos");
		mnMenu.add(menu_adminCursos);
		
		menu_adminCursos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AdministrarCursos adminCursos = new AdministrarCursos();
				Desktop_main deskMain = new Desktop_main();

				deskMain.setVisible(false);
				adminCursos.setVisible(true);
				adminCursos.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
			}			
			
		});
		
		menu_altres = new JMenuItem("Altres");
		mnMenu.add(menu_altres);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	public Image getIconImage() {
		
		Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("src/Images/duolingo_icon.png"));
		return retValue;
		
	}

}
