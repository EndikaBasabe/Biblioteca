package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorPrestamo;
import modelo.Prestamo;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ConsultaPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldIdSocio;
	private ControladorPrestamo controladorPrestamo;
	private JTable table;

	/**
	 * Create the dialog.
	 */
	public ConsultaPrestamo(JDialog parent,boolean modal) {
		
		super(parent,modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPanel.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Por socio", null, panel, null);
		
		JLabel lblIdSocio = new JLabel("Id socio :");
		
		textFieldIdSocio = new JTextField();
		textFieldIdSocio.setColumns(10);
		
		JButton buttonBuscar = new JButton("Buscar");
		buttonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonBuscarActionPerformed();
			}
		});
		
		table = new JTable();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(58)
							.addComponent(lblIdSocio, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textFieldIdSocio, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(buttonBuscar, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(128)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(69)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIdSocio, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldIdSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonBuscar, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
	}

	protected void buttonBuscarActionPerformed() {
		this.controladorPrestamo.mostrarPrestamosDeSocio(Integer.parseInt(textFieldIdSocio.getText()));
		
	}

	public ControladorPrestamo getControladorPrestamo() {
		return controladorPrestamo;
	}

	public void setControladorPrestamo(ControladorPrestamo controladorPrestamo) {
		this.controladorPrestamo = controladorPrestamo;
	}

	public void taulaBete(ArrayList<Prestamo> prestamos) {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		
		Object[] cabecera = { "titulo","fecha","devuelto"};
		
		defaultTableModel.setColumnIdentifiers(cabecera);
		
		for (Prestamo prestamo : prestamos){
			Object[] linea = {prestamo.getId_libro(),prestamo.getFecha(),prestamo.isDevuelto()};
			
			defaultTableModel.addRow(linea);
			
		}
		table.setModel(defaultTableModel);
	}
	
}
