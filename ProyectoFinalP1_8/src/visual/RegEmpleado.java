package visual;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.DatePicker;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import logico.Empleado;
import logico.EmpleadoAdm;
import logico.EmpleadoCom;
import logico.Empresa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.UIManager;
import java.awt.Color;

public class RegEmpleado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JFormattedTextField txtCed;
	private JFormattedTextField txtTel1;
	private JFormattedTextField txtTel2;
	private JTextField txtEmail;
	private JTextField txtNaci;
	private JTextField txtNombRef;
	private JTextField txtApellRef;
	private JTextField txtTel;
	private JTextField txtSueldo;
	private JComboBox cbxSexo;
	private JSpinner spnFecNac;
	private JComboBox cbxPuesto; 

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			RegEmpleado dialog = new RegEmpleado("", 0, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 * @param object 
	 * @param i 
	 * @param string 
	 * @throws ParseException 
	 */
	public RegEmpleado(String string, int i, Empleado empl) throws ParseException{
		setResizable(false);
		setModal(true);
		setTitle(string);
		setBounds(100, 100, 792, 491);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(5, 5, 765, 204);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Nombre completo:");
			lblNewLabel.setBounds(10, 11, 137, 14);
			panel.add(lblNewLabel);
			
			txtNombre = new JTextField();
			txtNombre.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					txtNombre.setText("");
					txtApellido.setText("");
				}
			});
			txtNombre.setText("Nombre(s)");
			txtNombre.setBounds(135, 8, 300, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			txtApellido = new JTextField();
			txtApellido.setText("Apellido(s)");
			txtApellido.setColumns(10);
			txtApellido.setBounds(455, 8, 300, 20);
			panel.add(txtApellido);
			
			JLabel lblCdula = new JLabel("C\u00E9dula:");
			lblCdula.setBounds(10, 48, 137, 14);
			panel.add(lblCdula);
			
			MaskFormatter formatter = new MaskFormatter("###-#######-#");
			txtCed = new JFormattedTextField(formatter);
			txtCed.setColumns(10);
			txtCed.setBounds(135, 45, 300, 20);
			panel.add(txtCed);
			
			JLabel lblEdad = new JLabel("Fecha de nacimiento:");
			lblEdad.setBounds(455, 48, 137, 14);
			panel.add(lblEdad);
			
			spnFecNac = new JSpinner();
			spnFecNac.setModel(new SpinnerDateModel(new Date(-287438400000L), new Date(-287438400000L), null, Calendar.DAY_OF_YEAR));
			spnFecNac.setBounds(604, 45, 151, 20);
			panel.add(spnFecNac);
			
			JLabel lblTelfonos = new JLabel("Tel\u00E9fono(s):");
			lblTelfonos.setBounds(10, 130, 137, 14);
			panel.add(lblTelfonos);
					
			MaskFormatter formatter1 = new MaskFormatter("(###) ###-####");
			txtTel1 = new JFormattedTextField(formatter1);
			txtTel1.setColumns(10);
			txtTel1.setBounds(135, 127, 300, 20);
			panel.add(txtTel1);
			
			txtTel2 = new JFormattedTextField(formatter1);
			txtTel2.setColumns(10);
			txtTel2.setBounds(455, 127, 300, 20);
			panel.add(txtTel2);
			
			JLabel lblSexo = new JLabel("Nacionalidad:");
			lblSexo.setBounds(10, 87, 137, 14);
			panel.add(lblSexo);
			
			cbxSexo = new JComboBox();
			cbxSexo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "F", "M"}));
			cbxSexo.setBounds(604, 84, 151, 20);
			panel.add(cbxSexo);
			
			JLabel lblCorreo = new JLabel("Correo:");
			lblCorreo.setBounds(10, 171, 137, 14);
			panel.add(lblCorreo);
			
			txtEmail = new JTextField();
			txtEmail.setColumns(10);
			txtEmail.setBounds(135, 168, 300, 20);
			panel.add(txtEmail);
			
			JLabel lblNacionalidad = new JLabel("Sexo:");
			lblNacionalidad.setBounds(455, 87, 137, 14);
			panel.add(lblNacionalidad);
			
			txtNaci = new JTextField();
			txtNaci.setColumns(10);
			txtNaci.setBounds(135, 84, 300, 20);
			panel.add(txtNaci);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Referencia", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(5, 220, 765, 101);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Nombre completo:");
		label.setBounds(10, 28, 137, 14);
		panel.add(label);
		
		txtNombRef = new JTextField();
		txtNombRef.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNombRef.setText("");
				txtApellRef.setText("");
			}
		});
		{
		txtNombRef.setText("Nombre(s)");
		txtNombRef.setColumns(10);
		txtNombRef.setBounds(135, 25, 300, 20);
		panel.add(txtNombRef);
		
		txtApellRef = new JTextField();
		txtApellRef.setText("Apellido(s)");
		txtApellRef.setColumns(10);
		txtApellRef.setBounds(455, 25, 300, 20);
		panel.add(txtApellRef);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(10, 65, 137, 14);
		panel.add(lblTelfono);
		
		MaskFormatter formatter2 = new MaskFormatter("(###) ###-####");
		txtTel = new JFormattedTextField(formatter2);
		txtTel.setColumns(10);
		txtTel.setBounds(135, 62, 300, 20);
		panel.add(txtTel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Puesto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(5, 332, 765, 67);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPuesto = new JLabel("Puesto:");
		lblPuesto.setBounds(10, 28, 137, 14);
		panel_1.add(lblPuesto);
		
		cbxPuesto = new JComboBox();
		cbxPuesto.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administrativo", "Comercial"}));
		cbxPuesto.setBounds(135, 25, 151, 20);
		panel_1.add(cbxPuesto);
		
		JLabel lblSueldoBase = new JLabel("Sueldo base:");
		lblSueldoBase.setBounds(455, 31, 137, 14);
		panel_1.add(lblSueldoBase);
		
		txtSueldo = new JTextField();
		txtSueldo.setColumns(10);
		txtSueldo.setBounds(585, 28, 170, 20);
		panel_1.add(txtSueldo);
		}
		
		if (i==1)
		{
			txtCed.setText(empl.getCedula());
			txtNombre.setText(empl.getNombres());
			txtCed.setEnabled(false);
			txtApellido.setText(empl.getApellidos());
			spnFecNac.setValue(empl.getNacimiento());
			txtNaci.setText(empl.getNacionalidad());
			cbxSexo.setSelectedItem(empl.getSexo());
			txtTel1.setText(empl.getTelefonos().get(0));
			txtTel2.setText(empl.getTelefonos().get(1));
			txtEmail.setText(empl.getCorreo());
			txtNombRef.setText(empl.getNombreReferencia());//ARREGLAR ESO
			txtTel.setText(empl.getTelefonoReferencia());
			txtSueldo.setText(Float.toString(empl.getSaldo()));
						
			if(empl instanceof EmpleadoAdm) {
				cbxPuesto.setSelectedItem("Administrativo");
			}
			
			if(empl instanceof EmpleadoCom) {
				cbxPuesto.setSelectedItem("Comercial");
			}
		}
			
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if((txtCed.getText()==" ")||(txtNombre.getText()==" ")||(txtTel1.getText()==" ")||(txtTel2.getText()==" ")||
								(txtEmail.getText()==" ")||(cbxSexo.getSelectedItem().toString()=="<Seleccione>")||(txtNaci.getText()==" ")||
								(txtNombRef.getText()==" ")||(txtApellRef.getText()==" ")||(txtTel.getText()==" ")) {
							JOptionPane.showMessageDialog(null, "Llene todos los campos", "Información", JOptionPane.ERROR_MESSAGE);
						}else {
							if (i==0) {
								String cliente1=" ";
								String cliente2=" ";
								boolean aux1 = false;
								{
									do {
										cliente1 = JOptionPane.showInputDialog("Digite la contraseña a utilizar:");
										if(cliente1!=" ") {
											cliente2 = JOptionPane.showInputDialog("Confirme la contraseña:");
											do {
												if (cliente2!=" ") {
													aux1=true;
												}else {
													JOptionPane.showMessageDialog(null, "Digite una contraseña:", "Información", JOptionPane.ERROR_MESSAGE);
													cliente2 = JOptionPane.showInputDialog("Confirme la contraseña:");
												}
											} while (!(cliente2.equals(cliente1)));
										}else {
											JOptionPane.showMessageDialog(null, "Digite una contraseña:", "Información", JOptionPane.ERROR_MESSAGE);
											cliente1 = JOptionPane.showInputDialog("Digite la contraseña a utilizar:");
										}
									} while (aux1==false);
								}
								if (aux1==true) {
									if(cbxPuesto.getSelectedItem().toString()=="Administrativo") {
										String cedula = txtCed.getText();
										String nombre = txtNombre.getText();
										String apellido = txtApellido.getText();
										ArrayList<String> tel = new ArrayList<String>();
										tel.add(txtTel1.getText());
										tel.add(txtTel2.getText());
										String correo = txtEmail.getText();
										String s=cbxSexo.getSelectedItem().toString();  
										char sexo=s.charAt(0);
										Date fecha = (Date) spnFecNac.getValue();
										String nac = txtNaci.getText();
										String nombreR = (txtNombRef.getText()+" "+txtApellRef.getText());
										String telR = txtTel.getText();
										Date fechaIng = new Date();
										float sueldo = Float.parseFloat(txtSueldo.getText());
										String password = cliente1;
										EmpleadoAdm aux = new EmpleadoAdm(cedula,nombre,apellido,tel,correo,sexo,fecha,nac,nombreR,telR,fechaIng,sueldo,password);
										Empresa.getInstance().insertarEmpleado(aux);
										
									}else if(cbxPuesto.getSelectedItem().toString()=="Comercial") {
										String cedula = txtCed.getText();
										String nombre = txtNombre.getText();
										String apellido = txtApellido.getText();
										ArrayList<String> tel = new ArrayList<String>();
										tel.add(txtTel1.getText());
										tel.add(txtTel2.getText());
										String correo = txtEmail.getText();
										String s=cbxSexo.getSelectedItem().toString();  
										char sexo=s.charAt(0);
										Date fecha = (Date) spnFecNac.getValue();
										String nac = txtNaci.getText();
										String nombreR = (txtNombRef.getText()+" "+txtApellRef.getText());
										String telR = txtTel.getText();
										Date fechaIng = new Date();
										float sueldo = Float.parseFloat(txtSueldo.getText());
										String password = cliente1;
										EmpleadoCom aux = new EmpleadoCom(cedula,nombre,apellido,tel,correo,sexo,fecha,nac,nombreR,telR,fechaIng,sueldo,password);
										Empresa.getInstance().insertarEmpleado(aux);
									}
									JOptionPane.showMessageDialog(null, "Registro satisfactorio", "Información", JOptionPane.INFORMATION_MESSAGE);
									clean();
								}
							}else if(i==1) {
								if((txtCed.getText()==" ")||(txtNombre.getText()==" ")||(txtTel1.getText()==" ")||(txtTel2.getText()==" ")||
										(txtEmail.getText()==" ")||(cbxSexo.getSelectedItem().toString()=="<Seleccione>")||(txtNaci.getText()==" ")||
										(txtNombRef.getText()==" ")||(txtApellRef.getText()==" ")||(txtTel.getText()==" ")||(cbxPuesto.getSelectedItem().toString()=="<Seleccione>")) {
									JOptionPane.showMessageDialog(null, "Llene todos los campos", "Información", JOptionPane.ERROR_MESSAGE);
								}else {
									int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea actualizar", "Confirmación", JOptionPane.WARNING_MESSAGE);
									if(option==JOptionPane.OK_OPTION) { 
										if(empl instanceof EmpleadoAdm) {
											empl.setCedula(txtCed.getText());
											empl.setNombres(txtNombre.getText());
											empl.setApellidos(txtApellido.getText());
											ArrayList<String> tel = new ArrayList<String>();
											tel.add(txtTel1.getText());
											tel.add(txtTel2.getText());
											empl.setTelefonos(tel);
											empl.setCorreo(txtEmail.getText());
											empl.setNombres(txtNombre.getText());
											String s=cbxSexo.getSelectedItem().toString();  
											char sexo=s.charAt(0);
											empl.setSexo(sexo);
											empl.setNacionalidad(txtNaci.getText());
											empl.setNombreReferencia(txtNombRef.getText()+" "+txtApellRef.getText());
											empl.setTelefonoReferencia(txtTel.getText());
											empl.setSaldo(Float.parseFloat(txtSueldo.getText()));
											cbxPuesto.setSelectedItem("Administrativo");
											cbxPuesto.setEnabled(false);
											spnFecNac.setValue(empl.getNacimiento());
																				
										}else if(empl instanceof EmpleadoCom) {
											empl.setCedula(txtCed.getText());
											empl.setNombres(txtNombre.getText());
											empl.setApellidos(txtApellido.getText());
											ArrayList<String> tel = new ArrayList<String>();
											tel.add(txtTel1.getText());
											tel.add(txtTel2.getText());
											empl.setTelefonos(tel);
											empl.setCorreo(txtEmail.getText());
											empl.setNombres(txtNombre.getText());
											String s=cbxSexo.getSelectedItem().toString();  
											char sexo=s.charAt(0);
											empl.setSexo(sexo);
											empl.setNacionalidad(txtNaci.getText());
											empl.setNombreReferencia(txtNombRef.getText()+" "+txtApellRef.getText());
											empl.setTelefonoReferencia(txtTel.getText());
											empl.setSaldo(Float.parseFloat(txtSueldo.getText()));
											cbxPuesto.setSelectedItem("Comercial");
											cbxPuesto.setEnabled(false);
											spnFecNac.setValue(empl.getNacimiento());
										}								
										clean();
										dispose();
									}
									if(option!=JOptionPane.OK_OPTION) {
										clean();
										dispose();
									}
								}
							}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private void clean() {
		   txtCed.setText("");
		   txtNombre.setText("Nombre(s)");
		   txtApellido.setText("Apellido(s)");
		   txtTel1.setText("");
		   txtTel2.setText("");
		   txtEmail.setText("");
		   txtNaci.setText("");
		   txtNombRef.setText("Nombre(s)");
		   txtApellRef.setText("Apellido(s)");
		   txtTel.setText("");
		   txtSueldo.setText("");
		   cbxSexo.setSelectedIndex(0);   
	}
}
