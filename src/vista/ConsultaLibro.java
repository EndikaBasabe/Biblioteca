package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorLibro;
import modelo.Libro;
import modelo.Socio;

import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;

public class ConsultaLibro extends JDialog {

	// --- ATRIBUTOS

	private JComboBox comboBoxTitulo;
	private JTextField textFieldAutor;
	private JTextField textFieldNumPag;
	private ControladorLibro controladorLibro;
	private JComboBox comboBoxAutor;
	private JList listLibros;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton radioButtonMenorCien;
	private JRadioButton radioButtonDe100a500;
	private JRadioButton radioButtonMayor500;
	private JScrollPane scrollPane;

	// --- GETS Y SETS

	public ControladorLibro getControladorLibro() {
		return controladorLibro;
	}

	public void setControladorLibro(ControladorLibro controladorLibro) {
		this.controladorLibro = controladorLibro;
	}

	public ConsultaLibro(GestionLibro parent, boolean modal) {
		super(parent, modal);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			getContentPane().add(tabbedPane, BorderLayout.CENTER);
			{
				JPanel panelTitulo = new JPanel();
				tabbedPane.addTab(" titulo", null, panelTitulo, null);
				{
					comboBoxTitulo = new JComboBox();
					comboBoxTitulo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							comboBoxTituloActionPerformed();
						}
					});
				}

				textFieldAutor = new JTextField();
				textFieldAutor.setEditable(false);
				textFieldAutor.setEnabled(false);
				textFieldAutor.setColumns(10);

				textFieldNumPag = new JTextField();
				textFieldNumPag.setEditable(false);
				textFieldNumPag.setEnabled(false);
				textFieldNumPag.setColumns(10);

				JLabel lblAutor = new JLabel("Autor :");

				JLabel lblNumPag = new JLabel(" paginas:");
				GroupLayout gl_panelTitulo = new GroupLayout(panelTitulo);
				gl_panelTitulo.setHorizontalGroup(
					gl_panelTitulo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTitulo.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_panelTitulo.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelTitulo.createSequentialGroup()
									.addGap(1)
									.addComponent(lblNumPag)
									.addGap(18)
									.addComponent(textFieldNumPag, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelTitulo.createSequentialGroup()
									.addGap(10)
									.addComponent(lblAutor)
									.addGap(18)
									.addComponent(textFieldAutor, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
								.addComponent(comboBoxTitulo, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(116, Short.MAX_VALUE))
				);
				gl_panelTitulo.setVerticalGroup(
					gl_panelTitulo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTitulo.createSequentialGroup()
							.addGap(34)
							.addComponent(comboBoxTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addGroup(gl_panelTitulo.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAutor))
							.addGap(18)
							.addGroup(gl_panelTitulo.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldNumPag, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumPag))
							.addContainerGap(84, Short.MAX_VALUE))
				);
				panelTitulo.setLayout(gl_panelTitulo);
			}
			{
				JPanel panelAutor = new JPanel();
				tabbedPane.addTab(" autor", null, panelAutor, null);

				comboBoxAutor = new JComboBox();
				comboBoxAutor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						comboBoxAutorActionPerformed();
					}
				});

				listLibros = new JList();

				JLabel lblAutor = new JLabel("Autor:");
				GroupLayout gl_panelAutor = new GroupLayout(panelAutor);
				gl_panelAutor.setHorizontalGroup(
					gl_panelAutor.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panelAutor.createSequentialGroup()
							.addGap(61)
							.addComponent(lblAutor)
							.addGap(36)
							.addComponent(comboBoxAutor, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(135, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panelAutor.createSequentialGroup()
							.addGap(138)
							.addComponent(listLibros, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(148))
				);
				gl_panelAutor.setVerticalGroup(
					gl_panelAutor.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelAutor.createSequentialGroup()
							.addGap(26)
							.addGroup(gl_panelAutor.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAutor)
								.addComponent(comboBoxAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(41)
							.addComponent(listLibros, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addGap(24))
				);
				panelAutor.setLayout(gl_panelAutor);
			}
			{
				JPanel panelNumPag = new JPanel();
				tabbedPane.addTab(" numero de paginas", null, panelNumPag, null);
				
				radioButtonMenorCien = new JRadioButton("< 100");
				buttonGroup.add(radioButtonMenorCien);
				radioButtonMenorCien.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						rellenarTablaActionPerformed(0,100);
					}
				});
				
				radioButtonDe100a500 = new JRadioButton("100 - 500");
				radioButtonDe100a500.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rellenarTablaActionPerformed(100, 500);
					}
				});
				buttonGroup.add(radioButtonDe100a500);
				
				radioButtonMayor500 = new JRadioButton("> 500");
				radioButtonMayor500.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rellenarTablaActionPerformed(500, 10000);
					}
				});
				buttonGroup.add(radioButtonMayor500);
				
				scrollPane = new JScrollPane();
				
				table = new JTable();
				scrollPane.setViewportView(table);
				GroupLayout gl_panelNumPag = new GroupLayout(panelNumPag);
				gl_panelNumPag.setHorizontalGroup(
					gl_panelNumPag.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelNumPag.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_panelNumPag.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelNumPag.createSequentialGroup()
									.addComponent(radioButtonMenorCien)
									.addGap(47)
									.addComponent(radioButtonDe100a500)
									.addGap(43)
									.addComponent(radioButtonMayor500))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)))
				);
				gl_panelNumPag.setVerticalGroup(
					gl_panelNumPag.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelNumPag.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_panelNumPag.createParallelGroup(Alignment.LEADING)
								.addComponent(radioButtonMenorCien)
								.addComponent(radioButtonDe100a500)
								.addComponent(radioButtonMayor500))
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
				);
				panelNumPag.setLayout(gl_panelNumPag);
			}
		}
	}
		
	

	protected void rellenarTablaActionPerformed(int min, int max) {

		if(radioButtonMenorCien.isSelected() || this.radioButtonDe100a500.isSelected() || this.radioButtonMayor500.isSelected()){
			controladorLibro.rellenarPorPaginas(min,max);
		
		}
	}

	public void rellenarComboLibros(ArrayList<Libro> libros) {

		DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel<String>();
		for (Libro libro : libros) {
			defaultComboBoxModel.addElement(libro.getId() + ": " + libro.getTitulo());
		}
		defaultComboBoxModel.setSelectedItem("Elige el titulo del libro...");
		this.comboBoxTitulo.setModel(defaultComboBoxModel);

		// for (Libro libro : libros) {
		// this.comboBoxTitulo.addItem(libro.getId() + ": " +
		// libro.getTitulo());
		// }
		// this.comboBoxTitulo.setSelectedIndex(-1);
	}

	protected void comboBoxTituloActionPerformed() {

		String item = this.comboBoxTitulo.getSelectedItem().toString();
		String[] partes = item.split(":");
		int idLibro = Integer.parseInt(partes[0]);

		controladorLibro.rellenarPorTitulo(idLibro);
	}

	public void llenarPestanaTitulo(Libro libro) {
		this.textFieldAutor.setText(libro.getAutor());
		this.textFieldNumPag.setText(String.valueOf(libro.getNum_pag()));

	}

	public void rellenarComboAutores(ArrayList<String> autores) {
		DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel<String>();
		for (String autor : autores) {
			defaultComboBoxModel.addElement(autor);
		}
		defaultComboBoxModel.setSelectedItem("Elige uno");
		this.comboBoxAutor.setModel(defaultComboBoxModel);

	}

	protected void comboBoxAutorActionPerformed() {
		String autor = this.comboBoxAutor.getSelectedItem().toString();
		controladorLibro.rellenarPorAutor(autor);

	}

	public void llenarListaLibrosAutor(ArrayList<Libro> librosAutor) {
		DefaultListModel defaultListModel = new DefaultListModel();
		for (Libro libro : librosAutor) {
			defaultListModel.addElement(libro.getTitulo() + " - " + libro.getNum_pag());

			this.listLibros.setModel(defaultListModel);
		}
	}

	public void llenarTabla(ArrayList<Libro> libros) {
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		
		Object[] cabecera = {"Titulo", "Autor"};
		
		defaultTableModel.setColumnIdentifiers(cabecera);
		
		for (Libro libro : libros) {
			Object[] linea = { libro.getTitulo(),libro.getAutor()};
			
			defaultTableModel.addRow(linea);
			
		}
		table.setModel(defaultTableModel);
	}
}
