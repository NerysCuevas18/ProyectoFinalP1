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

public class ListPlan extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	public static DefaultTableModel modelo;
	public static Object[] filas;
	public ArrayList<Plan> aux = Empresa.getInstance().getPlanes();
	public Plan aux1;
	private ArrayList<String> auxDisponible;
	private JButton btnRegistrar;
	private Date today;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			ListPlan dialog = new ListPlan();
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
	public ListPlan() {
		setTitle("Lista de planes");
		setModal(true);
		setBounds(100, 100, 785, 336);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 759, 233);
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
						        btnRegistrar.setEnabled(true);

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
				
				btnRegistrar = new JButton("Eliminar");
				btnRegistrar.setEnabled(false);
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(aux!=null) {
							int option = JOptionPane.showConfirmDialog(null, "¿Está seguro/a de que desea eliminar el plan: "+aux1.getCodPlan(), "Confirmación", JOptionPane.WARNING_MESSAGE);
						    if(option == JOptionPane.OK_OPTION) {
						        Empresa.getInstance().eliminarPlan(aux1);
						        btnRegistrar.setEnabled(false);
						    	llenarTabla();
						    }
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
}