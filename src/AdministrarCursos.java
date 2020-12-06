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

public class AdministrarCursos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministrarCursos frame = new AdministrarCursos();
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
	public AdministrarCursos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1277, 790);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCursosExistentesfiltrar = new JLabel("Cursos existentes (filtrar por origen y/o destino)");
		
		JLabel lblIdiomaDeOrigen = new JLabel("Idioma de origen");
		
		JLabel lblIdiomaDeDestino = new JLabel("Idioma de destino");
		
		JButton btnAplicarFiltro = new JButton("Aplicar filtro");
		
		JComboBox comboIdiomaOrigen = new JComboBox();
		
		JComboBox comboIdiomaDestino = new JComboBox();
		
		JButton btnCrearCurso = new JButton("Crear curso");
		
		JLabel lblNivelesCategoria = new JLabel("Niveles de la categoría seleccionada");
		
		JLabel lblCategoriasDelCurso = new JLabel("Categorías del curso seleccionado");
		
		JLabel lblCursos = new JLabel("Cursos");
		
		JList list_1 = new JList();
		
		JList list_1_1 = new JList();
		
		JList list_1_1_1 = new JList();
		
		JButton btnNewButton = new JButton("Añadir categoría");
		
		JButton btnAadirNivel = new JButton("Añadir nivel");
		
		JButton btnAnadirPregunta = new JButton("AÑADIR PREGUNTA");
		
		JButton btnVisualizarPreguntas = new JButton("VISUALIZAR PREGUNTAS");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(88)
									.addComponent(comboIdiomaOrigen, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(72)
									.addComponent(lblIdiomaDeOrigen))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(60)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(list_1_1, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
										.addComponent(lblCursos))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(147)
											.addComponent(comboIdiomaDestino, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(117)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblCategoriasDelCurso, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
												.addComponent(list_1, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
												.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
									.addPreferredGap(ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(list_1_1_1, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
										.addComponent(lblNivelesCategoria)
										.addComponent(btnCrearCurso, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnAplicarFiltro, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnAadirNivel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(131)
									.addComponent(lblIdiomaDeDestino))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCursosExistentesfiltrar)
									.addPreferredGap(ComponentPlacement.RELATED, 784, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnAnadirPregunta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnVisualizarPreguntas, GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE))))))
					.addGap(104))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCursosExistentesfiltrar)
							.addGap(42))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblIdiomaDeDestino)
							.addComponent(lblIdiomaDeOrigen)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboIdiomaDestino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboIdiomaOrigen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAplicarFiltro, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addComponent(btnCrearCurso, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(75)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategoriasDelCurso)
						.addComponent(lblCursos)
						.addComponent(lblNivelesCategoria))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
						.addComponent(list_1_1, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
						.addComponent(list_1_1_1, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnAadirNivel))
					.addGap(18)
					.addComponent(btnAnadirPregunta)
					.addGap(18)
					.addComponent(btnVisualizarPreguntas)
					.addContainerGap(77, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
