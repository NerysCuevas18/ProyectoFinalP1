package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Empleado;
import logico.EmpleadoAdm;
import logico.EmpleadoCom;
import logico.Empresa;
import logico.Factura;
import logico.Plan;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.UIManager;
import java.awt.Color;

public class CompraPlan extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	public static DefaultTableModel modelo;
	public static Object[] filas;
	private JList list;
	public ArrayList<Plan> aux = Empresa.getInstance().getPlanes();
	public Plan aux1;
	private ArrayList<String> auxDisponible;
	private JButton btnNewButton;
	private JTextField txtNomb;
	private JTextField txtCed;
	private JTextField txtCodPlan;
	private JButton btnRegistrar;
	private Date today;
	private JEditorPane txtDescripcion;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			CompraPlan dialog = new CompraPlan(String cedEmpleado, String nombreCliente, String cedulaCliente);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	/**
	 * Create the dialog.
	 * @param miAlmacen 
	 */
	public CompraPlan(String cedEmpleado, String nombreCliente, String cedulaCliente) {
		setTitle("Venta de planes");
		setModal(true);
		setBounds(100, 100, 785, 511);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 456, 233);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Planes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					modelo = new DefaultTableModel();
					String[] headers = {"ID Plan", "Nombre Plan","Precio Base", "Impuesto","Precio Final"};
					modelo.setColumnIdentifiers(headers);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int seleccion = table.getSelectedRow();
							if(seleccion!=-1) {
								aux1 = aux.get(table.getSelectedRow());
								btnNewButton.setEnabled(true);
							}
						}
					});
					table.setModel(modelo);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			btnNewButton = new JButton("Buscar");
			btnNewButton.setEnabled(false);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarListaDisponible();
				}
			});
			btnNewButton.setBounds(331, 255, 89, 23);
			contentPanel.add(btnNewButton);
		}
		{
			JTextArea txtrSeleccioneUnaFila = new JTextArea();
			txtrSeleccioneUnaFila.setText("Seleccione una fila y d\u00E9 click a buscar \r\npara ver m\u00E1s detalles del plan.");
			txtrSeleccioneUnaFila.setEditable(false);
			txtrSeleccioneUnaFila.setBounds(49, 255, 229, 40);
			contentPanel.add(txtrSeleccioneUnaFila);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Detalle de plan", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(476, 11, 287, 233);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		list = new JList();
		panel.add(list, BorderLayout.CENTER);
		txtDescripcion = new JEditorPane();
		txtDescripcion.setBounds(92, 94, 382, 145);
		panel.add(txtDescripcion);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del cliente y del plan a comprar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 323, 753, 92);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Cliente:");
		lblNewLabel.setBounds(10, 27, 95, 14);
		panel_1.add(lblNewLabel);
		
		txtNomb = new JTextField();
		txtNomb.setText(nombreCliente);
		txtNomb.setEnabled(false);
		txtNomb.setEditable(false);
		txtNomb.setBounds(104, 24, 236, 20);
		panel_1.add(txtNomb);
		txtNomb.setColumns(10);
		
		JLabel lblCdula = new JLabel("C\u00E9dula Cliente:");
		lblCdula.setBounds(420, 27, 111, 14);
		panel_1.add(lblCdula);
		
		txtCed = new JTextField(cedulaCliente);
		txtCed.setText(cedulaCliente);
		txtCed.setEnabled(false);
		txtCed.setEditable(false);
		txtCed.setColumns(10);
		txtCed.setBounds(507, 24, 236, 20);
		panel_1.add(txtCed);
		
		JLabel lblCodPlan = new JLabel("C\u00F3digo Plan:");
		lblCodPlan.setBounds(10, 58, 95, 14);
		panel_1.add(lblCodPlan);
		
		txtCodPlan = new JTextField();
		txtCodPlan.setColumns(10);
		txtCodPlan.setBounds(104, 55, 236, 20);
		panel_1.add(txtCodPlan);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if((txtCed.getText()==" ")||(txtCodPlan.getText()==" ")||(txtNomb.getText()==" ")) {
							JOptionPane.showMessageDialog(null, "Llene todos los campos", "Informaci�n", JOptionPane.ERROR_MESSAGE);
						}else {
							String cedula = txtCed.getText();
							String plan = txtCodPlan.getText();
							Empleado empleado = Empresa.getInstance().findEmpleado(cedEmpleado);
							if (empleado instanceof EmpleadoCom) {
								((EmpleadoCom) empleado).cantVenta++;
							}
							Plan planC = Empresa.getInstance().findPlan(plan);
							if(planC!=null) {
								Cliente cliente = Empresa.getInstance().findCliente(cedula);
								if(cliente!=null) {
									cliente.setPlanC(planC);
								}
							}
							JOptionPane.showMessageDialog(null, "Registro satisfactorio", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}		
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		llenarTabla();
	}
	
	
	public static void llenarTabla() {
		modelo.setRowCount(0);
		filas = new Object[modelo.getColumnCount()];
		for (Plan planes : Empresa.getInstance().getPlanes()) {
			filas[0] = planes.getCodPlan();	
			filas[1] = planes.getNombreP();
			filas[2] = planes.getPrecioBase();
			filas[3] = planes.generarImpPlan();
			filas[4] = planes.getPrecioFinal();
			modelo.addRow(filas);
		}
	}
	private void cargarListaDisponible() {
		txtDescripcion.setText("Descripci�n: "+aux1.getDescripcionP());
	}
}