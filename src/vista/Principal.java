package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.*;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	// Atributos
	private JPanel contentPane;
	private ControladorSocio controladorSocio;
	private ControladorLibro controladorLibro;
	private ControladorPrestamo controladorPrestamo;
	
	// Getters y setters
	public ControladorSocio getControladorSocio() {
		return controladorSocio;
	}
	
	public void setControladorSocio(ControladorSocio controladorSocio) {
		this.controladorSocio = controladorSocio;
	}
	
	public ControladorLibro getControladorLibro() {
		return controladorLibro;
	}

	public void setControladorLibro(ControladorLibro controladorLibro) {
		this.controladorLibro = controladorLibro;
	}

	public ControladorPrestamo getControladorPrestamo() {
		return controladorPrestamo;
	}

	public void setControladorPrestamo(ControladorPrestamo controladorPrestamo) {
		this.controladorPrestamo = controladorPrestamo;
	}

	// Constructor
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelIcon = new JLabel("");
		labelIcon.setVerticalAlignment(SwingConstants.BOTTOM);
		labelIcon.setIcon(new ImageIcon("C:\\Users\\ikaslea\\Desktop\\libros.jpg"));
		
		JButton botonGestionLibros = new JButton("GESTION LIBROS");
		botonGestionLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			controladorLibro.abrirVentanaGestionLibros();
			}
		});
		
		JButton botonGestionSocios = new JButton("GESTION SOCIOS");
		botonGestionSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorSocio.abrirVentanaGestionSocios();
			}
		});
		
		JButton botonPrestamos = new JButton("GESTION PRESTAMOS");
		botonPrestamos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPrestamo.abrirVentanaGestionPrestamo();
			}
		});
		
		JLabel labelBiblioteca = new JLabel("BIBLIOTECA");
		labelBiblioteca.setToolTipText("");
		labelBiblioteca.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(labelBiblioteca))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(botonPrestamos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(botonGestionSocios, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(botonGestionLibros, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
					.addGap(26)
					.addComponent(labelIcon, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addComponent(labelBiblioteca, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(56)
					.addComponent(botonGestionLibros)
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addComponent(botonGestionSocios)
					.addGap(26)
					.addComponent(botonPrestamos)
					.addGap(19))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(labelIcon, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
