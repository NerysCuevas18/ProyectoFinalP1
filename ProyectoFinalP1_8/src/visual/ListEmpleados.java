package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import logico.Empleado;
import logico.EmpleadoAdm;
import logico.EmpleadoCom;
import logico.Empresa;
import logico.Persona;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class ListEmpleados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	public static DefaultTableModel modelo;
	public static Object[] filas;
	private JComboBox comboBox;
	private String seleccion = "<Todos>";
	private Empleado aux = null;
	private JButton btnNewButton;
	private JButton btnEliminar;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public ListEmpleados() {
		setTitle("Listado de empleados");
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
					String[] headers = {"Cedula","Nombre","Telefono","Correo","Tipo de empleado","Ingreso compañia","Cant. Ventas","Expericia años", "Saldo"};
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
				JLabel lblNewLabel = new JLabel("Empleado/s:");
				buttonPane.add(lblNewLabel);
			}
			{
				comboBox = new JComboBox();
				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						seleccion = comboBox.getSelectedItem().toString();
						cargarListaDisponible(seleccion);
					}
					
				});
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Comercial", "Administrativo"}));
				buttonPane.add(comboBox);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(aux!=null) {
							int option = JOptionPane.showConfirmDialog(null, "¿Está seguro/a de que desea eliminar el empleado: "+aux.getCedula(), "Confirmación", JOptionPane.WARNING_MESSAGE);
						    if(option == JOptionPane.OK_OPTION) {
						        Empresa.getInstance().eliminarEmpleado(aux);
						     	seleccion = "<Todos>";
						    	cargarListaDisponible(seleccion);
						    	btnEliminar.setEnabled(false);
						    }
						}
					
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
								aux = Empresa.getInstance().findEmpleado((String)modelo.getValueAt(seleccion, 0));
							}
						}
					});
					btnNewButton.setEnabled(false);
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							DetalleEmpleado det = new DetalleEmpleado();
							det.setModal(true);
							det.setLocationRelativeTo(null);
							det.setVisible(true);
						}
					});
					buttonPane.add(btnNewButton);
				}
				{
					btnModificar = new JButton("Modificar");
					btnModificar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							RegEmpleado regEmpleado = null;
							try {
								regEmpleado = new RegEmpleado("Modificar Empleado", 1, aux);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							regEmpleado.setVisible(true);
							llenarTabla();
						}
					});
					btnModificar.setEnabled(false);
					buttonPane.add(btnModificar);
				}
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
	
		cargarListaDisponible(seleccion);
	}
	
	public static void llenarTabla() {
		modelo.setRowCount(0);
		filas = new Object[modelo.getColumnCount()];
		for(Empleado empleados : Empresa.getInstance().getEmpleados()) {
			filas[0]=empleados.getCedula();
			filas[1]=empleados.getNombres();
			filas[2]=empleados.getTelefonos();
			filas[3]=empleados.getCorreo();
			
			if(empleados instanceof EmpleadoCom)
			 {
				
				filas[4]="Comercial"; 
				filas[5]=empleados.getIngresoCompania();
				filas[6]=((EmpleadoCom) empleados).getCantVenta();
				filas[7]="N/A";
				filas[8]=empleados.getSaldo();
			    modelo.addRow(filas);
			     }
		 
			if(empleados instanceof EmpleadoAdm)
			 {
				 
				 filas[4]="Administrativo"; 
				 filas[5]=empleados.getIngresoCompania();
				 filas[6]="N/A";
				 filas[7]=((EmpleadoAdm) empleados).getExpAnios();
				 filas[8]=empleados.getSaldo();
				modelo.addRow(filas);
			     }
			
		}
	}
	
	private void cargarListaDisponible(String seleccion) {
		modelo.setRowCount(0);
		filas = new Object[modelo.getColumnCount()];
		if(seleccion.equalsIgnoreCase("<Todos>")){
		  llenarTabla();
		}else{
			for(Empleado empleados : Empresa.getInstance().getEmpleados()) {
			 if(seleccion == "Comercial"){
				 if(empleados instanceof EmpleadoCom)
				 {
					filas[0]=empleados.getCedula();
					filas[1]=empleados.getNombres();
					filas[2]=empleados.getTelefonos();
					filas[3]=empleados.getCorreo();
					filas[4]="Comercial"; 
					filas[5]=empleados.getIngresoCompania();
					filas[6]=((EmpleadoCom) empleados).getCantVenta();
					filas[7]="N/A";
					filas[8]=empleados.getSaldo();
				    modelo.addRow(filas);
				     }
			 }
			 if(seleccion == "Administrativo"){
				 if(empleados instanceof EmpleadoAdm)
				 {
					 filas[0]=empleados.getCedula();
					 filas[1]=empleados.getNombres();
					 filas[2]=empleados.getTelefonos();
					 filas[3]=empleados.getCorreo();
					 filas[4]="Administrativo"; 
					 filas[5]=empleados.getIngresoCompania();
					 filas[6]="N/A";
					 filas[7]=((EmpleadoAdm) empleados).getExpAnios();
					 filas[8]=empleados.getSaldo();
					modelo.addRow(filas);
				     }
			 }
			 
		 }	
		}
		
	}

}
