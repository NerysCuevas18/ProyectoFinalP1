package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Empresa;
import logico.Plan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

public class CrearPlan extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtPrecioBase;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JTextField txtDescripcion;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		try {
			RegPub dialog = new RegPub();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearPlan() {
		setTitle("Creaci\u00F3n de planes");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 518, 378);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel_Informacion = new JPanel();
		panel_Informacion.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n general", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Informacion.setBounds(10, 11, 484, 300);
		contentPanel.add(panel_Informacion);
		panel_Informacion.setLayout(null);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(10, 28, 46, 14);
		panel_Informacion.add(lblId);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setEditable(false);
		txtId.setBounds(92, 24, 65, 23);
		panel_Informacion.add(txtId);
		txtId.setColumns(10);
		txtId.setText("PL"+(1000+ Empresa.getInstance().getCodPlan()));
		
		JLabel lblPrecioBase = new JLabel("Precio base:  ");
		lblPrecioBase.setBounds(10, 261, 100, 14);
		panel_Informacion.add(lblPrecioBase);
		
		txtPrecioBase = new JTextField();
		txtPrecioBase.setBounds(120, 257, 93, 23);
		panel_Informacion.add(txtPrecioBase);
		txtPrecioBase.setColumns(10);
		
		JLabel lblRd = new JLabel("RD$");
		lblRd.setBounds(92, 261, 51, 14);
		panel_Informacion.add(lblRd);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 58, 58, 23);
		panel_Informacion.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(92, 58, 382, 23);
		panel_Informacion.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(10, 92, 71, 19);
		panel_Informacion.add(lblDescripcin);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(92, 94, 382, 145);
		panel_Informacion.add(txtDescripcion);
		
		JComboBox cbxServicios = new JComboBox();
		cbxServicios.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Cable", "Tel\u00E9fono", "Internet", "Cable y tel\u00E9fono", "Cable e Internet", "Tel\u00E9fono e Internet", "Cable, tel\u00E9fono e Internet"}));
		cbxServicios.setBounds(235, 25, 239, 20);
		panel_Informacion.add(cbxServicios);
		
		JLabel lblServicios = new JLabel("Servicios:");
		lblServicios.setBounds(177, 28, 58, 14);
		panel_Informacion.add(lblServicios);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
								
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				
				JButton btnRegistrar = new JButton("Crear plan");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean isValid = true;
					    try {
					        Double.parseDouble(txtPrecioBase.getText());
					    } catch(NumberFormatException nfe) {
					        isValid = false;
					    }
					    if (isValid) {
					    	float PFinal = (float) (Float.parseFloat(txtPrecioBase.getText()) + Float.parseFloat(txtPrecioBase.getText())*0.3);
					    	 int returnValue= JOptionPane.showConfirmDialog(null, "El valor final de su producto, con impuestos incluídos, es de RD$"+PFinal+". ¿Desea proceder?", "Confirmación", JOptionPane.CANCEL_OPTION);
					    	 if(returnValue == 0) {
					    		 Plan plan = new Plan(txtId.getText(), txtNombre.getText(), txtDescripcion.getText(), Float.parseFloat(txtPrecioBase.getText()), cbxServicios.getSelectedItem().toString());
					    		 Empresa.getInstance().insertarPlan(plan);
					    		 JOptionPane.showMessageDialog(null, "El plan ha sido añadido con éxito.");
					    		 
					    		 clean();
					    	 }
						} else JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico en el precio base.", "Información", JOptionPane.INFORMATION_MESSAGE);
					}
				});
				btnRegistrar.setActionCommand("Cancel");
				buttonPane.add(btnRegistrar);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void clean() {
		txtNombre.setText("");
		txtDescripcion.setText("");
		txtPrecioBase.setText("");
		txtId.setText("PL"+(1000+ Empresa.getInstance().getCodPlan()));
	}
}