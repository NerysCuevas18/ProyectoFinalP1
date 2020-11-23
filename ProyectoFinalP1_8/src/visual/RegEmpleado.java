package visual;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.DatePicker;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class RegEmpleado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegEmpleado dialog = new RegEmpleado("", 0, null);
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
	 */
	public RegEmpleado(String string, int i, Object object) {
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
			
			txtNombres = new JTextField();
			txtNombres.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					txtNombres.setText("");
					txtApellidos.setText("");
				}
			});
			txtNombres.setText("Nombre(s)");
			txtNombres.setBounds(135, 8, 300, 20);
			panel.add(txtNombres);
			txtNombres.setColumns(10);
			
			txtApellidos = new JTextField();
			txtApellidos.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					txtNombres.setText("");
					txtApellidos.setText("");
				}
			});
			txtApellidos.setText("Apellido(s)");
			txtApellidos.setColumns(10);
			txtApellidos.setBounds(455, 8, 300, 20);
			panel.add(txtApellidos);
			
			JLabel lblCdula = new JLabel("C\u00E9dula:");
			lblCdula.setBounds(10, 48, 137, 14);
			panel.add(lblCdula);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(135, 45, 300, 20);
			panel.add(textField_2);
			
			JLabel lblEdad = new JLabel("Fecha de nacimiento:");
			lblEdad.setBounds(455, 48, 137, 14);
			panel.add(lblEdad);
			
			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerDateModel(new Date(-287438400000L), new Date(-287438400000L), null, Calendar.DAY_OF_YEAR));
			spinner.setBounds(604, 45, 151, 20);
			panel.add(spinner);
			
			JLabel lblTelfonos = new JLabel("Tel\u00E9fono(s):");
			lblTelfonos.setBounds(10, 130, 137, 14);
			panel.add(lblTelfonos);
			
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(135, 127, 300, 20);
			panel.add(textField_3);
			
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(455, 127, 300, 20);
			panel.add(textField_4);
			
			JLabel lblSexo = new JLabel("Nacionalidad:");
			lblSexo.setBounds(10, 87, 137, 14);
			panel.add(lblSexo);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "F", "M"}));
			comboBox.setBounds(604, 84, 151, 20);
			panel.add(comboBox);
			
			JLabel lblCorreo = new JLabel("Correo:");
			lblCorreo.setBounds(10, 171, 137, 14);
			panel.add(lblCorreo);
			
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(135, 168, 300, 20);
			panel.add(textField_5);
			
			JLabel lblNacionalidad = new JLabel("Sexo:");
			lblNacionalidad.setBounds(455, 87, 137, 14);
			panel.add(lblNacionalidad);
			
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(135, 84, 300, 20);
			panel.add(textField_6);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Referencia", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(5, 220, 765, 101);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Nombre completo:");
		label.setBounds(10, 28, 137, 14);
		panel.add(label);
		
		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		textField.setText("Nombre(s)");
		textField.setColumns(10);
		textField.setBounds(135, 25, 300, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		textField_1.setText("Apellido(s)");
		textField_1.setColumns(10);
		textField_1.setBounds(455, 25, 300, 20);
		panel.add(textField_1);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(10, 65, 137, 14);
		panel.add(lblTelfono);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(135, 62, 300, 20);
		panel.add(textField_7);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Puesto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(5, 332, 765, 67);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPuesto = new JLabel("Puesto:");
		lblPuesto.setBounds(10, 28, 137, 14);
		panel_1.add(lblPuesto);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Administrativo", "Comercial"}));
		comboBox.setBounds(135, 25, 151, 20);
		panel_1.add(comboBox);
		
		JLabel lblSueldoBase = new JLabel("Sueldo base:");
		lblSueldoBase.setBounds(455, 31, 137, 14);
		panel_1.add(lblSueldoBase);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(585, 28, 170, 20);
		panel_1.add(textField_8);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
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
}
