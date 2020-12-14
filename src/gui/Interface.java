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

import lib.duolingoproject.hibernate.model.*;
import lib.duolingoproject.hibernate.dao.*;
import lib.duolingoproject.hibernate.dao.i.*;

class Interface extends JFrame {
	
	public static Image iconImage;
	
	private JMenuBar menuBar;
	private JMenu menu;	

	private JPanel contentPane;
	private JMenuItem menuCoursesManager;
	private JMenuItem menuOthers;
	
	static Interface frame;
	static CoursesManager cm;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					frame = new Interface();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);

//					createLanguages();
					
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
				
				cm = new CoursesManager();

				cm.setVisible(true);
				
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
