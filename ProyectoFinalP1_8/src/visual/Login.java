package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import logico.EmpleadoAdm;
import logico.EmpleadoCom;
import logico.Empresa;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;

public class Login extends JDialog {

	private JPanel contentPane;
	private JFormattedTextField textField;
	private JPasswordField textField_1;
	private String passw = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream empresa;
				FileOutputStream empresa2;
				ObjectInputStream empresaRead;
				ObjectOutputStream empresaWrite;
				try {
					empresa = new FileInputStream ("Altice.dat");
					empresaRead = new ObjectInputStream(empresa);
					Empresa temp = (Empresa)empresaRead.readObject();
					Empresa.setAltice(temp);
					empresa.close();
					empresaRead.close();
				} catch (FileNotFoundException e) {
					try {
						empresa2 = new  FileOutputStream("Altice.dat");
						empresaWrite = new ObjectOutputStream(empresa2);
						ArrayList<String> tel = new ArrayList<String>();
						tel.add("");
						Date nac = new Date();
						Date ing = new Date();
						EmpleadoAdm aux = new EmpleadoAdm("000-0000000-0", "Adm", "Adm", tel, "Adm", 'F', nac, "Adm", "Adm", "Adm","Adm",ing, 0, "Adm");
						Empresa.getInstance().insertarEmpleado(aux);
						empresaWrite.writeObject(Empresa.getInstance());
						empresa2.close();
						empresaWrite.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					Empresa.getInstance().generarFacturas();
					if(Empresa.getInstance().isConexion()) {
						if(Empresa.getInstance().getLoginUser() instanceof EmpleadoAdm) {
						PrincipalAdm frame = new PrincipalAdm();
						frame.setVisible(true);
					} else if (Empresa.getInstance().getLoginUser() instanceof EmpleadoCom){
						PrincipalCom frame = new PrincipalCom("");
						frame.setVisible(true);
					}
					} else {
						Login frame = new Login();
						frame.setVisible(true);	
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public Login() throws ParseException {
		setTitle("\u00A1Bienvenido/a a Altice!");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 370, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("C\u00E9dula:");
		lblUsuario.setBounds(75, 261, 72, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(75, 324, 105, 14);
		panel.add(lblContrasea);
		
		MaskFormatter formatter = new MaskFormatter("###-#######-#");
        textField = new JFormattedTextField(formatter);
		textField.setBounds(75, 278, 191, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(75, 342, 191, 20);
		panel.add(textField_1);
		
		JButton btnLogin = new JButton("Ingresar");
		btnLogin.setBackground(Color.LIGHT_GRAY);
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passw = "";
				for(int i = 0; i<textField_1.getPassword().length; i++) {
					passw += textField_1.getPassword()[i];
				}
				if(Empresa.getInstance().confirmLoginAdm(textField.getText(),passw)){
					PrincipalAdm frame = new PrincipalAdm();
					dispose();
					frame.setVisible(true);
					Empresa.getInstance().setConexion(true);
				} else if(Empresa.getInstance().confirmLoginCom(textField.getText(),passw)){
					PrincipalCom frame = new PrincipalCom(textField.getText());
					dispose();
					frame.setVisible(true);
					Empresa.getInstance().setConexion(true);
				} else {
					JOptionPane.showMessageDialog(null, "El usuario que ha insertado no coincide con ninguno en nuestros registros.", "Información", JOptionPane.INFORMATION_MESSAGE);
					clean();
				};
				
			}

			private void clean() {
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnLogin.setBounds(126, 389, 89, 23);
		panel.add(btnLogin);
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon("Altice_logo.png"));
		logo.setBounds(39, 34, 262, 133);
		panel.add(logo);
		
		JLabel lblNewLabel = new JLabel("\u00A1Bienvenido/a, distinguido/a socio/a!");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 208, 324, 30);
		panel.add(lblNewLabel);
		
		
	}
}