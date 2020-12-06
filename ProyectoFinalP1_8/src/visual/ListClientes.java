package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Empresa;
import logico.Persona;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ListClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	public static DefaultTableModel modelo;
	public static Object[] filas;
	public Persona aux = null;
	private JButton btnEliminar;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListClientes dialog = new ListClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListClientes() {
		setTitle("Listado de clientes");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 1222, 633);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					modelo = new DefaultTableModel();
					String[] headers = {"Cedula","Nombre","Telefono","Correo","Estado","PlanC","Fact.Mensual","Registro"};
					modelo.setColumnIdentifiers(headers);
					
					table = new JTable();
					table.setModel(modelo);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegCliente regClient = null;
						regClient = new RegCliente("Modificar cliente", 1, aux);
						regClient.setVisible(true);
						llenarTabla();
					}
				});
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(aux!=null){
							int option = JOptionPane.showConfirmDialog(null, "Est� seguro que desea eliminar al Cliente: "+aux.getCedula(), "Confirmaci�n", JOptionPane.WARNING_MESSAGE);
						    if(option == JOptionPane.OK_OPTION){
						    	Empresa.getInstance().eliminarClientes(aux);
						    	llenarTabla();
						    	btnEliminar.setEnabled(false);
						    	
						    }
						}
					}
				});
				btnEliminar.setEnabled(false);
				buttonPane.add(btnEliminar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		
		llenarTabla();
	}

	public static void llenarTabla() {
		modelo.setRowCount(0);
		filas = new Object[modelo.getColumnCount()];
		for (Cliente person : Empresa.getInstance().getClientes()) {
			filas[0] = person.getCedula();
			filas[1] =person.getNombres();
			filas[2] = person.getTelefonos();
			filas[3] = person.getCorreo();
			filas[4] = person.isEstado();
			filas[5] = person.getPlanC();
			filas[6] = person.getFacturasMensual();
			filas[7] = person.getRegistro();
			modelo.addRow(filas);
		}
		
	}
	
}