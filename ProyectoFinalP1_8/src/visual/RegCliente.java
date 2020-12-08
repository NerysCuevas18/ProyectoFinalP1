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
import logico.Cliente;
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
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCed;
	private JFormattedTextField txtTel1;
	private JFormattedTextField txtTel2;
	private JTextField txtEmail;
	private JTextField txtNac;
	private JTextField txtNomR;
	private JTextField txtApellR;
	private JTextField txtTelR;
	private JComboBox cbxSexo;
	private JSpinner spnFecNac;
	private int condicion = 0;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		try {
			RegCliente dialog = new RegCliente("", 0, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 * @param object 
	 * @param i 
	 * @param string 
	 * @throws ParseException 
	 */
	public RegCliente(String string, int i, Cliente cliente, String ced) throws ParseException {
		setResizable(false);
		setModal(true);
		setTitle(string);
		setBounds(100, 100, 792, 395);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		{
			if(i==0) {
				setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		        addWindowListener(new java.awt.event.WindowAdapter() {
		            @Override
		            public void windowClosing(java.awt.event.WindowEvent evt){
		                if (JOptionPane.showConfirmDialog(rootPane, "Si cierra la ventana, no podrá registrarse. ¿Continuar de todos modos?", 
		                        "Información", JOptionPane.ERROR_MESSAGE) == JOptionPane.ERROR_MESSAGE){
		                	setCondicion(1);
		                    dispose();
		                }
		            }
		        });
				}
			
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
			txtCed = new JTextField(ced);
			txtCed.setEditable(false);
			txtCed.setEnabled(false);
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
			
			txtNac = new JTextField();
			txtNac.setColumns(10);
			txtNac.setBounds(135, 84, 300, 20);
			panel.add(txtNac);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Referencia", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(5, 220, 765, 101);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Nombre completo:");
		label.setBounds(10, 28, 137, 14);
		panel.add(label);
		
		txtNomR = new JTextField();
		txtNomR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNomR.setText("");
				txtApellR.setText("");
			}
		});
		txtNomR.setText("Nombre(s)");
		txtNomR.setColumns(10);
		txtNomR.setBounds(135, 25, 300, 20);
		panel.add(txtNomR);
		
		txtApellR = new JTextField();
		txtApellR.setText("Apellido(s)");
		txtApellR.setColumns(10);
		txtApellR.setBounds(455, 25, 300, 20);
		panel.add(txtApellR);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(10, 65, 137, 14);
		panel.add(lblTelfono);
		
		MaskFormatter formatter2 = new MaskFormatter("(###) ###-####");
		txtTelR = new JFormattedTextField(formatter2);
		txtTelR.setColumns(10);
		txtTelR.setBounds(135, 62, 300, 20);
		panel.add(txtTelR);
		
		if (i==1)
		{
			txtCed.setText(cliente.getCedula());
			txtNombre.setText(cliente.getNombres());
			txtCed.setEnabled(false);
			txtApellido.setText(cliente.getApellidos());
			spnFecNac.setValue(cliente.getNacimiento());
			txtNac.setText(cliente.getNacionalidad());
			cbxSexo.setSelectedItem(String.valueOf(cliente.getSexo()));
			txtTel1.setText(cliente.getTelefonos().get(0));
			txtTel2.setText(cliente.getTelefonos().get(1));
			txtEmail.setText(cliente.getCorreo());
			txtNomR.setText(cliente.getNombreReferencia());//ARREGLAR ESO
			txtTelR.setText(cliente.getTelefonoReferencia());
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(i==0) {
							if((txtCed.getText()==" ")||(txtNombre.getText().equalsIgnoreCase(""))||(txtApellido.getText().equalsIgnoreCase(""))||(txtNombre.getText().equalsIgnoreCase(""))||(txtApellido.getText().equalsIgnoreCase(""))
									||(txtTel1.getText().equalsIgnoreCase("(   )    -    "))||(txtTel2.getText().equalsIgnoreCase("(   )    -    "))||(txtEmail.getText().equalsIgnoreCase(""))||((String) cbxSexo.getSelectedItem()=="<Seleccione>")
									||(txtNac.getText().equalsIgnoreCase(""))||(txtNomR.getText().equalsIgnoreCase(""))||(txtApellR.getText().equalsIgnoreCase(""))||(txtNomR.getText().equalsIgnoreCase(""))||(txtApellR.getText().equalsIgnoreCase(""))||
									(txtTelR.getText().equalsIgnoreCase("(   )    -    "))) {
								
								JOptionPane.showMessageDialog(null, "Llene todos los campos", "Información", JOptionPane.ERROR_MESSAGE);
							
							}if((txtCed.getText()!=" ")&&(txtNombre.getText()!="Nombre(s)")&&(txtApellido.getText()!="Apellido(s)")&&(txtNombre.getText()!=" ")&&(txtApellido.getText()!=" ")
									&&(txtTel1.getText()!=" ")&&(txtTel2.getText()!=" ")&&(txtEmail.getText()!=" ")&&((String) cbxSexo.getSelectedItem()!="<Seleccione>")
									&&(txtNac.getText()!=" ")&&(txtNomR.getText()!="Nombre(s)")&&(txtApellR.getText()!="Apellido(s)")&&(txtNomR.getText()!=" ")&&(txtApellR.getText()!=" ")&&
									(txtTelR.getText()!=" ")){
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
								String nac = txtNac.getText();
								String nombreR = (txtNomR.getText()+ " "+ txtApellR.getText());
								String telR = txtTelR.getText();
								Date reg = new Date();
								if((Empresa.getInstance().findEmpleado(txtCed.getText()))!=null) {
									
									JOptionPane.showMessageDialog(null, "Ya la cédula se encuentra registrada.\n Dígite una válida.", "Información", JOptionPane.ERROR_MESSAGE);
								
								}else{
									Cliente aux = new Cliente(cedula,nombre,apellido,tel,correo,sexo,fecha,nac,nombreR,telR,true,reg);
									Empresa.getInstance().insertarCliente(aux);
									JOptionPane.showMessageDialog(null, "Registro satisfactorio", "Información", JOptionPane.INFORMATION_MESSAGE);
									dispose();
								}
							}
						}
						else if(i==1) {
							int option = JOptionPane.showConfirmDialog(null, "Está seguro que desea actualizar", "Confirmación", JOptionPane.WARNING_MESSAGE);
							if(option==JOptionPane.OK_OPTION) { 
								if((txtCed.getText()==" ")||(txtNombre.getText().equalsIgnoreCase(""))||(txtApellido.getText().equalsIgnoreCase(""))||(txtNombre.getText().equalsIgnoreCase(""))||(txtApellido.getText().equalsIgnoreCase(""))
										||(txtTel1.getText().equalsIgnoreCase("(   )    -    "))||(txtTel2.getText().equalsIgnoreCase("(   )    -    "))||(txtEmail.getText().equalsIgnoreCase(""))||((String) cbxSexo.getSelectedItem()=="<Seleccione>")
										||(txtNac.getText().equalsIgnoreCase(""))||(txtNomR.getText().equalsIgnoreCase(""))||(txtApellR.getText().equalsIgnoreCase(""))||(txtNomR.getText().equalsIgnoreCase(""))||(txtApellR.getText().equalsIgnoreCase(""))||
										(txtTelR.getText().equalsIgnoreCase("(   )    -    "))) {
									
									JOptionPane.showMessageDialog(null, "Llene todos los campos", "Información", JOptionPane.ERROR_MESSAGE);
								
								}if((txtCed.getText()!=" ")&&(txtNombre.getText()!="Nombre(s)")&&(txtApellido.getText()!="Apellido(s)")&&(txtNombre.getText()!=" ")&&(txtApellido.getText()!=" ")
										&&(txtTel1.getText()!=" ")&&(txtTel2.getText()!=" ")&&(txtEmail.getText()!=" ")&&((String) cbxSexo.getSelectedItem()!="<Seleccione>")
										&&(txtNac.getText()!=" ")&&(txtNomR.getText()!="Nombre(s)")&&(txtApellR.getText()!="Apellido(s)")&&(txtNomR.getText()!=" ")&&(txtApellR.getText()!=" ")&&
										(txtTelR.getText()!=" ")) {
									cliente.setCedula(txtCed.getText());
									cliente.setNombres(txtNombre.getText());
									cliente.setApellidos(txtApellido.getText());
									ArrayList<String> tel = new ArrayList<String>();
									tel.add(txtTel1.getText());
									tel.add(txtTel2.getText());
									cliente.setTelefonos(tel);
									cliente.setCorreo(txtEmail.getText());
									cliente.setNombres(txtNombre.getText());
									String s=cbxSexo.getSelectedItem().toString();  
									char sexo=s.charAt(0);
									cliente.setSexo(sexo);
									cliente.setNacionalidad(txtNac.getText());
									cliente.setNombreReferencia(txtNomR.getText()+" "+txtApellR.getText());
									cliente.setTelefonoReferencia(txtTelR.getText());
									spnFecNac.setValue(cliente.getNacimiento());								
									clean();
									dispose();
								}
							}
							if(option!=JOptionPane.OK_OPTION) {
								clean();
								dispose();
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
						if (JOptionPane.showConfirmDialog(rootPane, "Si cierra la ventana, no podrá registrarse. ¿Continuar de todos modos?", 
		                        "Información", JOptionPane.ERROR_MESSAGE) == JOptionPane.ERROR_MESSAGE){
		                	setCondicion(1);
		                    dispose();
		                }
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
		   txtNac.setText("");
		   txtNomR.setText("Nombre(s)");
		   txtApellR.setText("Apellido(s)");
		   txtTelR.setText("");
		   cbxSexo.setSelectedIndex(0);  
	}
	public int getCondicion() {
		return condicion;
	}
	public void setCondicion(int condicion) {
		this.condicion = condicion;
	} 
}
