package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class AddExercise extends JFrame {

	private JPanel contentPane;
	private JLabel lblIdiomaDest;
	private JLabel lblCategoria;
	private Image image;
	private Icon icon;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddExercise frame = new AddExercise();
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
	public AddExercise() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblIdiomaOrigen = new JLabel("Idioma origen:");
		
		lblIdiomaDest = new JLabel("Idioma destí:");
		
		lblCategoria = new JLabel("Categoria:");
		
		JButton btnTest = new JButton("");
	
		Image test = Toolkit.getDefaultToolkit().getImage(AddExercise.class.getResource("/image/test.png"));
		icon = new ImageIcon(test.getScaledInstance(100, 100, 100));
		btnTest.setIcon(icon);
		
		
		
		JButton btnOpenTrad = new JButton("");
		Image open_trad = Toolkit.getDefaultToolkit().getImage(AddExercise.class.getResource("/image/open_traduction.png"));
		icon = new ImageIcon(open_trad.getScaledInstance(100, 100, 100));
		btnOpenTrad.setIcon(icon);
		
		
		
		JButton btnTradReorWord = new JButton("");
		Image trad_reor_word = Toolkit.getDefaultToolkit().getImage(AddExercise.class.getResource("/image/translate_reorder_words.png"));
		icon = new ImageIcon(trad_reor_word.getScaledInstance(100, 100, 100));
		btnTradReorWord.setIcon(icon);
		
		
		
		JButton btnLisReorder = new JButton("");
		Image lisreorder = Toolkit.getDefaultToolkit().getImage(AddExercise.class.getResource("/image/reorder_listening.png"));
		icon = new ImageIcon(lisreorder.getScaledInstance(100, 100, 100));
		btnLisReorder.setIcon(icon);
		
		
		
		JButton btnLisOpen = new JButton("");
		Image lisopen = Toolkit.getDefaultToolkit().getImage(AddExercise.class.getResource("/image/open_listening.png"));
		icon = new ImageIcon(lisopen.getScaledInstance(100, 100, 100));
		btnLisOpen.setIcon(icon);
		
		
		
		JButton btnPutAWord = new JButton("");
		Image putAword = Toolkit.getDefaultToolkit().getImage(AddExercise.class.getResource("/image/put_a_word.png"));
		icon = new ImageIcon(putAword.getScaledInstance(100, 100, 100));
		btnPutAWord.setIcon(icon);
		
		
		
		JButton btnPairMaking = new JButton("");
		Image pairmake = Toolkit.getDefaultToolkit().getImage(AddExercise.class.getResource("/image/pair_making.png"));
		icon = new ImageIcon(pairmake.getScaledInstance(100, 100, 100));
		btnPairMaking.setIcon(icon);
		
		JLabel lblNivell = new JLabel("Nivell:");
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblIdiomaOrigen, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblIdiomaDest, Alignment.LEADING)
							.addComponent(lblCategoria, Alignment.LEADING))
						.addComponent(lblNivell))
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
							.addComponent(lblIdiomaOrigen)
							.addGap(31)
							.addComponent(lblIdiomaDest)
							.addGap(31)
							.addComponent(lblCategoria))
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
							.addComponent(lblNivell)
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
