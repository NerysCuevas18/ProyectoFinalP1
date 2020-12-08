package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Cliente;
import logico.Empleado;
import logico.EmpleadoAdm;
import logico.Empresa;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DetalleEmpleado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtSexo;
	private JTextField txtNacimiento;
	private JTextField txtNacionalidad;
	private JTextField txtIngresoComp;
	private JTextField txtSaldo;
	private JTextField txtTipo;
	private JTextField txtNombreRef;
	private JTextField txtTelefonoR;
	private Empleado empleado;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		try {
			DetalleEmpleado dialog = new DetalleEmpleado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DetalleEmpleado(Empleado empleado) {
		this.empleado = empleado;
		setTitle("Detalles Empleados");
		setBounds(100, 100, 1293, 533);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setResizable(false);
		setLocationRelativeTo(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Informacion Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Cedula:");
			lblNewLabel.setBounds(15, 51, 69, 20);
			panel.add(lblNewLabel);
			
			txtCedula = new JTextField();
			txtCedula.setEditable(false);
			txtCedula.setBounds(143, 48, 504, 26);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			txtCedula.setText(empleado.getCedula());
			
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(15, 98, 69, 20);
			panel.add(lblNewLabel_1);
			
			txtNombre = new JTextField();
			txtNombre.setEditable(false);
			txtNombre.setColumns(10);
			txtNombre.setBounds(143, 95, 421, 26);
			panel.add(txtNombre);
			txtNombre.setText(empleado.getNombres());
			
			JLabel lblNewLabel_2 = new JLabel("Apellido:");
			lblNewLabel_2.setBounds(608, 98, 69, 20);
			panel.add(lblNewLabel_2);
			
			txtApellido = new JTextField();
			txtApellido.setEditable(false);
			txtApellido.setColumns(10);
			txtApellido.setBounds(737, 95, 421, 26);
			panel.add(txtApellido);
			txtApellido.setText(empleado.getApellidos());

			
			JLabel lblNewLabel_3 = new JLabel("Telefono:");
			lblNewLabel_3.setBounds(15, 145, 69, 20);
			panel.add(lblNewLabel_3);
			
			txtTelefono = new JTextField();
			txtTelefono.setEditable(false);
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(143, 142, 421, 26);
			panel.add(txtTelefono);
			String telefono = "";
			for(int i = 0; i<empleado.getTelefonos().size(); i++){
				telefono += empleado.getTelefonos().get(i)+" / ";
			}
			txtTelefono.setText(telefono);
			
			JLabel lblCorreo = new JLabel("Correo:");
			lblCorreo.setBounds(608, 145, 69, 20);
			panel.add(lblCorreo);
			
			txtCorreo = new JTextField();
			txtCorreo.setEditable(false);
			txtCorreo.setColumns(10);
			txtCorreo.setBounds(737, 142, 421, 26);
			panel.add(txtCorreo);
			txtCorreo.setText(empleado.getCorreo());
			
			JLabel lblSexo = new JLabel("Sexo:");
			lblSexo.setBounds(15, 194, 69, 20);
			panel.add(lblSexo);
			
			txtSexo = new JTextField();
			txtSexo.setEditable(false);
			txtSexo.setColumns(10);
			txtSexo.setBounds(143, 191, 421, 26);
			panel.add(txtSexo);
			txtSexo.setText(empleado.getSexo()+"");
			
			JLabel lblNacimiento = new JLabel("Nacimiento:");
			lblNacimiento.setBounds(608, 194, 123, 20);
			panel.add(lblNacimiento);
			
			txtNacimiento = new JTextField();
			txtNacimiento.setEditable(false);
			txtNacimiento.setColumns(10);
			txtNacimiento.setBounds(737, 191, 421, 26);
			panel.add(txtNacimiento);
			txtNacimiento.setText(empleado.getNacimiento().toString());
			
			JLabel lblNacionalidad = new JLabel("Nacionalidad:");
			lblNacionalidad.setBounds(15, 246, 113, 20);
			panel.add(lblNacionalidad);
			
			txtNacionalidad = new JTextField();
			txtNacionalidad.setEditable(false);
			txtNacionalidad.setColumns(10);
			txtNacionalidad.setBounds(143, 243, 421, 26);
			panel.add(txtNacionalidad);
			txtNacionalidad.setText(empleado.getNacionalidad());
			
			JLabel lblIngresoCompaia = new JLabel("Ingreso Comp:");
			lblIngresoCompaia.setBounds(608, 246, 123, 20);
			panel.add(lblIngresoCompaia);
			
			txtIngresoComp = new JTextField();
			txtIngresoComp.setEditable(false);
			txtIngresoComp.setColumns(10);
			txtIngresoComp.setBounds(737, 243, 421, 26);
			panel.add(txtIngresoComp);
			txtIngresoComp.setText(empleado.getIngresoCompania().toString());
			
			
			JLabel lblSaldo = new JLabel("Saldo:");
			lblSaldo.setBounds(608, 357, 69, 20);
			panel.add(lblSaldo);
			
			txtSaldo = new JTextField();
			txtSaldo.setEditable(false);
			txtSaldo.setColumns(10);
			txtSaldo.setBounds(737, 354, 421, 26);
			panel.add(txtSaldo);
			txtSaldo.setText(empleado.getSaldo()+"");
			
			JLabel lblPass = new JLabel("Tipos Emp:");
			lblPass.setBounds(15, 357, 99, 20);
			panel.add(lblPass);
			
			txtTipo = new JTextField();
			txtTipo.setEditable(false);
			txtTipo.setColumns(10);
			txtTipo.setBounds(143, 354, 421, 26);
			panel.add(txtTipo);

			for (Empleado emp : Empresa.getInstance().getEmpleados()) {
			if( emp instanceof EmpleadoAdm) {
				txtTipo.setText("Administrador");
			}else {
				txtTipo.setText("Comercial");
			}
			}
			
			
			JLabel lblNombreRef = new JLabel("Nombre Ref:");
			lblNombreRef.setBounds(15, 302, 113, 20);
			panel.add(lblNombreRef);
			
			txtNombreRef = new JTextField();
			txtNombreRef.setEditable(false);
			txtNombreRef.setColumns(10);
			txtNombreRef.setBounds(143, 299, 421, 26);
			panel.add(txtNombreRef);
			txtNombreRef.setText(empleado.getNombreReferencia());
			
			JLabel lblTelefonoRef = new JLabel("Telefono Ref:");
			lblTelefonoRef.setBounds(608, 302, 113, 20);
			panel.add(lblTelefonoRef);
			
			txtTelefonoR = new JTextField();
			txtTelefonoR.setEditable(false);
			txtTelefonoR.setColumns(10);
			txtTelefonoR.setBounds(737, 299, 421, 26);
			panel.add(txtTelefonoR);
			txtTelefonoR.setText(empleado.getTelefonoReferencia());
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCancelar = new JButton("Cancel");
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
