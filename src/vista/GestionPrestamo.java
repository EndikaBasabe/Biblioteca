package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorPrestamo;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private ControladorPrestamo controladorPrestamo;
	/**
	 * Create the dialog.
	 */
	public GestionPrestamo(JFrame parent,boolean modal) {
		
		super(parent,modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 260, 434, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblGestionPrestamos = new JLabel("GESTION PRESTAMOS :");
		lblGestionPrestamos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGestionPrestamos.setBounds(131, 29, 191, 14);
		getContentPane().add(lblGestionPrestamos);
		
		JButton buttonRealizarPrestamo = new JButton("Realizar Prestamo");
		buttonRealizarPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPrestamo.abrirVentanaRealizarPrestamo();
			}
		});
		buttonRealizarPrestamo.setBounds(151, 79, 146, 23);
		getContentPane().add(buttonRealizarPrestamo);
	}
	public ControladorPrestamo getControladorPrestamo() {
		return controladorPrestamo;
	}
	public void setControladorPrestamo(ControladorPrestamo controladorPrestamo) {
		this.controladorPrestamo = controladorPrestamo;
	}
}
