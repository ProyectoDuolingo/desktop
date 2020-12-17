package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JDialog;

public class addTestExercise extends JFrame {

	private JPanel contentPane;
	private JTextField textSentToTrans;
	private JTextField textSentCorrect;
	private JTextField textSentWrong1;
	private JTextField textSentWrong2;
	private JLabel lblSentWrong1;


	public addTestExercise() {
		
		setIconImage(Interface.iconImage);
		
		setBounds(200, 200, 900, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSentToTrans = new JLabel("Frase a traducir:");
		
		textSentToTrans = new JTextField();
		textSentToTrans.setColumns(10);
		
		JLabel lblSentCorrect = new JLabel("Frase traducida:");
		
		textSentCorrect = new JTextField();
		textSentCorrect.setColumns(10);
		
		lblSentWrong1 = new JLabel("Frase incorrecta 1:");
		
		textSentWrong1 = new JTextField();
		textSentWrong1.setColumns(10);
		
		JLabel lblSentWrong2 = new JLabel("Frase incorrecta 2:");
		
		textSentWrong2 = new JTextField();
		textSentWrong2.setColumns(10);
		
		JButton btnSaveAtDB = new JButton("GUARDAR EJERCICIO");
		
		btnSaveAtDB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				if (textSentToTrans.getText().equals("") || textSentCorrect.getText().equals("") || textSentWrong1.getText().equals("") || textSentWrong2.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Asegúrese de rellenar todos los campos.");
					
				} else {
					
					
					
					setVisible(false);
					
				}

				
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblSentWrong2)
								.addComponent(textSentWrong1)
								.addComponent(textSentToTrans, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
								.addComponent(lblSentToTrans)
								.addComponent(lblSentCorrect)
								.addComponent(lblSentWrong1)
								.addComponent(textSentCorrect)
								.addComponent(textSentWrong2)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(93)
							.addComponent(btnSaveAtDB, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(397, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(lblSentToTrans)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textSentToTrans, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblSentCorrect)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textSentCorrect, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblSentWrong1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textSentWrong1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblSentWrong2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textSentWrong2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(btnSaveAtDB)
					.addContainerGap(51, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
