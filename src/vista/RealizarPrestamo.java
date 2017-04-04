package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorPrestamo;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;

public class RealizarPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ControladorPrestamo controladorPrestamo;

	/**
	 * Create the dialog.
	 */
	public RealizarPrestamo(JDialog parent,boolean modal) {
		super(parent,modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblRealizarPrestamo = new JLabel("REALIZAR PRESTAMO");
			lblRealizarPrestamo.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblRealizarPrestamo.setBounds(121, 22, 184, 14);
			contentPanel.add(lblRealizarPrestamo);
		}
		{
			JLabel lblSocios = new JLabel("Socios :");
			lblSocios.setBounds(50, 78, 46, 14);
			contentPanel.add(lblSocios);
		}
		{
			JLabel lblLibros = new JLabel("Libros :");
			lblLibros.setBounds(50, 149, 46, 14);
			contentPanel.add(lblLibros);
		}
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(121, 75, 102, 20);
		contentPanel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(121, 146, 102, 20);
		contentPanel.add(comboBox_1);
		
		JButton buttonOk = new JButton("OK");
		buttonOk.setBounds(290, 215, 89, 23);
		contentPanel.add(buttonOk);
	}

	public ControladorPrestamo getControladorPrestamo() {
		return controladorPrestamo;
	}

	public void setControladorPrestamo(ControladorPrestamo controladorPrestamo) {
		this.controladorPrestamo = controladorPrestamo;
	}
}
