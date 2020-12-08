package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import logico.Cliente;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class DetalleCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtSexo;
	private JTextField txtNacimiento;
	private JTextField txtNacionalidad;
	private JTextField txtNombreR;
	private JTextField txtTeleR;
	private Cliente cliente;


	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public DetalleCliente() {
		setTitle("Detalles datos Clientes");
		setBounds(100, 100, 643, 588);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Informacion del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Cedula:");
			lblNewLabel.setBounds(15, 55, 84, 20);
			panel.add(lblNewLabel);
			
			txtCedula = new JTextField();
			txtCedula.setEditable(false);
			txtCedula.setBounds(155, 52, 376, 26);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			txtCedula.setText(cliente.getCedula());
			
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(15, 97, 69, 20);
			panel.add(lblNewLabel_1);
			
			txtNombre = new JTextField();
			txtNombre.setEditable(false);
			txtNombre.setColumns(10);
			txtNombre.setBounds(155, 94, 376, 26);
			panel.add(txtNombre);
			txtNombre.setText(cliente.getNombres());
			
			JLabel lblNewLabel_2 = new JLabel("Apellido:");
			lblNewLabel_2.setBounds(15, 139, 69, 20);
			panel.add(lblNewLabel_2);
			
			txtApellido = new JTextField();
			txtApellido.setEditable(false);
			txtApellido.setColumns(10);
			txtApellido.setBounds(155, 136, 376, 26);
			panel.add(txtApellido);
			txtApellido.setText(cliente.getApellidos());
			
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(15, 181, 69, 20);
			panel.add(lblTelefono);
			
			txtTelefono = new JTextField();
			txtTelefono.setEditable(false);
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(155, 178, 376, 26);
			panel.add(txtTelefono);
			String telefono = "";
			for(int i = 0; i<cliente.getTelefonos().size(); i++){
				telefono += cliente.getTelefonos().get(i)+" / ";
			}
			txtTelefono.setText(telefono);
			
			JLabel lblCorreo = new JLabel("Correo:");
			lblCorreo.setBounds(15, 223, 69, 20);
			panel.add(lblCorreo);
			
			txtCorreo = new JTextField();
			txtCorreo.setEditable(false);
			txtCorreo.setColumns(10);
			txtCorreo.setBounds(155, 220, 376, 26);
			panel.add(txtCorreo);
			txtCorreo.setText(cliente.getCorreo());
			
			JLabel lblSexo = new JLabel("Sexo:");
			lblSexo.setBounds(15, 262, 69, 20);
			panel.add(lblSexo);
			
			txtSexo = new JTextField();
			txtSexo.setEditable(false);
			txtSexo.setColumns(10);
			txtSexo.setBounds(155, 259, 376, 26);
			panel.add(txtSexo);
			txtSexo.setText(cliente.getSexo());
			
			JLabel lblNacionalidad = new JLabel("Nacimiento:");
			lblNacionalidad.setBounds(15, 301, 104, 20);
			panel.add(lblNacionalidad);
			
			txtNacimiento = new JTextField();
			txtNacimiento.setEditable(false);
			txtNacimiento.setColumns(10);
			txtNacimiento.setBounds(155, 298, 376, 26);
			panel.add(txtNacimiento);
			txtNacimiento.setText(cliente.getNacimiento().toString());
			
			
			JLabel lblNacionalidad_1 = new JLabel("Nacionalidad:");
			lblNacionalidad_1.setBounds(15, 340, 104, 20);
			panel.add(lblNacionalidad_1);
			
			txtNacionalidad = new JTextField();
			txtNacionalidad.setEditable(false);
			txtNacionalidad.setColumns(10);
			txtNacionalidad.setBounds(155, 337, 376, 26);
			panel.add(txtNacionalidad);
			txtNacionalidad.setText(cliente.getNacionalidad());
			
			JLabel lblNombrereferen = new JLabel("NombreRef:");
			lblNombrereferen.setBounds(15, 379, 125, 20);
			panel.add(lblNombrereferen);
			
			txtNombreR = new JTextField();
			txtNombreR.setEditable(false);
			txtNombreR.setColumns(10);
			txtNombreR.setBounds(155, 376, 376, 26);
			panel.add(txtNombreR);
			txtNombreR.setText(cliente.getNombreReferencia());
			
			JLabel lblTelefonoref = new JLabel("TelefonoRef:");
			lblTelefonoref.setBounds(15, 418, 125, 20);
			panel.add(lblTelefonoref);
			
			txtTeleR = new JTextField();
			txtTeleR.setEditable(false);
			txtNombreR.setEditable(false);
			txtTeleR.setColumns(10);
			txtTeleR.setBounds(155, 415, 376, 26);
			panel.add(txtTeleR);
			txtTeleR.setText(cliente.getTelefonoReferencia());
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
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
