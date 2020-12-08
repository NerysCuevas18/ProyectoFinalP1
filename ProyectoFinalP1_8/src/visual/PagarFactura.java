package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Cliente;
import logico.Empresa;
import logico.Factura;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PagarFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_1;
	private JTable table;
	public static DefaultTableModel modelo;
	public static Object[] filas;
	private int mode;
	private Factura aux = null;
	private JButton verFactura;
	private JButton okButton;
	private float pago;
	private float monto = 0;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		try {
			PagarFactura dialog = new PagarFactura(Cliente cliente);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PagarFactura(Cliente cliente) {
		setBounds(100, 100, 653, 306);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPanel.add(panel, BorderLayout.CENTER);
		
		JLabel label_1 = new JLabel("C\u00E9dula del cliente:");
		label_1.setBounds(12, 57, 177, 14);
		panel.add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Facturas sin pagar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(246, 25, 365, 135);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		JLabel label_11 = new JLabel("Total:  RD$0");
		label_11.setBounds(458, 188, 133, 14);
		panel.add(label_11);
		
		modelo = new DefaultTableModel();
		String [] headers = {"Código de factura", "Nombre", "Monto"};
		modelo.setColumnIdentifiers(headers);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccion = table.getSelectedRow();
				if(seleccion!=-1) {
					verFactura.setEnabled(true);
					okButton.setEnabled(true);
					aux = Empresa.getInstance().findFactura((String)modelo.getValueAt(seleccion, 0));
					monto = aux.getMonto();
					label_11.setText("Total:  RD$"+monto);
				}
			}
		});
		table.setModel(modelo);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JLabel label_2 = new JLabel("Nombre:");
		label_2.setBounds(12, 99, 62, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel(cliente.getNombres());
		label_3.setBounds(12, 117, 188, 14);
		panel.add(label_3);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 171, 601, 2);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(210, 27, 8, 135);
		panel.add(separator_2);
		
		JLabel label_10 = new JLabel("Monto pagado:  RD$");
		label_10.setBounds(10, 188, 133, 14);
		panel.add(label_10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(126, 184, 80, 23);
		panel.add(textField_1);
		
		
		JLabel label = new JLabel(cliente.getCedula());
		label.setBounds(12, 74, 188, 14);
		panel.add(label);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			verFactura = new JButton("Ver factura");
			verFactura.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirarchivo(aux.getFact());
				}

				private void abrirarchivo(String archivo) {
					try {

			            File objetofile = new File (archivo);
			            Desktop.getDesktop().open(objetofile);

			     }catch (IOException ex) {

			            System.out.println(ex);

			     }
					
				}
			});
			verFactura.setActionCommand("OK");
			buttonPane.add(verFactura);
			{
				okButton = new JButton("Pagar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean isValid = true;
					    try {
					        Double.parseDouble(textField_1.getText());
					    } catch(NumberFormatException nfe) {
					        isValid = false;
					    }
					    if (isValid) {
					    	pago = new Float(textField_1.getText());
					    	if(pago>=monto) {
					    		JOptionPane.showMessageDialog(null, "Se ha pagado la factura correctamente. Su cambio es de RD$"+(pago-monto), "Información", JOptionPane.INFORMATION_MESSAGE);
					    		aux.setPagada(true);
					    		Date date = new Date();
					    		Empresa.getInstance().totalPagoMes(aux, date);
					    		dispose();
					    		}  else JOptionPane.showMessageDialog(null, "El monto insertado es menor al requerido.", "Información", JOptionPane.INFORMATION_MESSAGE);
					    } else JOptionPane.showMessageDialog(null, "Por favor, introduzca el monto a pagar", "Información", JOptionPane.INFORMATION_MESSAGE);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		verFactura.setEnabled(false);
		okButton.setEnabled(false);
		llenarTabla(cliente);
	}
	
	public static void llenarTabla(Cliente cliente) {
		modelo.setRowCount(0);
		filas = new Object[modelo.getColumnCount()];
		for(Factura factura : cliente.getFacturasMensual()) {
			if(!(factura.isPagada())) {
			filas[0]=factura.getCodFactura();
			filas[1]=factura.getCliente().getNombres();
			filas[2]="RD$"+factura.getMonto();
			modelo.addRow(filas);	
			}
			
		}
	}
}
