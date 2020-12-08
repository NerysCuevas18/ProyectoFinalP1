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
import logico.Empleado;
import logico.Empresa;
import logico.Persona;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	public static DefaultTableModel modelo;
	public static Object[] filas;
	public Cliente aux = null;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnNewButton;

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
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							btnEliminar.setEnabled(true);
							btnNewButton.setEnabled(true);
							btnModificar.setEnabled(true);
							
						}
					});
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
						int seleccion = table.getSelectedRow();
						Cliente aux1 = null;
						if(seleccion!=-1) {
							//btnEliminar.setEnabled(true);
							//btnNewButton.setEnabled(true);
							aux1 = Empresa.getInstance().findCliente((String)modelo.getValueAt(seleccion, 0));
						}
						try {
							regClient = new RegCliente("Modificar cliente", 1, aux1);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						regClient.setVisible(true);
						llenarTabla();
					}
				});
				{
					btnNewButton = new JButton("Ver Informacion");
					btnNewButton.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int seleccion = table.getSelectedRow();
							if(seleccion!=-1) {
								btnEliminar.setEnabled(true);
								btnNewButton.setEnabled(true);
								aux = Empresa.getInstance().findCliente((String)modelo.getValueAt(seleccion, 0));
							}
						}
					});
					btnNewButton.setEnabled(false);
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							DetalleCliente det = new DetalleCliente();
							det.setModal(true);
							det.setLocationRelativeTo(null);
							det.setVisible(true);
							
						}
					});
					buttonPane.add(btnNewButton);
				}
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
							int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar al Cliente: "+aux.getCedula(), "Confirmación", JOptionPane.WARNING_MESSAGE);
						    if(option == JOptionPane.OK_OPTION){
						    	Empresa.getInstance().eliminarCliente(aux);
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
