package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Empresa;
import logico.Plan;

import javax.swing.JLabel;
import java.awt.Font;

public class PrincipalAdm extends JFrame { 

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalAdm frame = new PrincipalAdm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalAdm() {
		setTitle("Altice Administrador");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream empresa2;
				ObjectOutputStream empresaWrite;
				try {
					empresa2 = new  FileOutputStream("Altice.dat");
					empresaWrite = new ObjectOutputStream(empresa2);
					empresaWrite.writeObject(Empresa.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u00A1Bienvenido, Sr/a "+Empresa.getInstance().getLoginUser().getApellidos()+"!");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 26));
		lblNewLabel_1.setBounds(25, 268, 621, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblbuenaSuerteEn = new JLabel("\u00A1Buena suerte en su jornada!");
		lblbuenaSuerteEn.setFont(new Font("Verdana", Font.PLAIN, 17));
		lblbuenaSuerteEn.setBounds(25, 306, 621, 63);
		contentPane.add(lblbuenaSuerteEn);
		
		JLabel lblNewLabel2 = new JLabel("");
		lblNewLabel2.setIcon(new ImageIcon("Fondo2.png"));
		lblNewLabel2.setBounds(397, 11, 407, 358);
		contentPane.add(lblNewLabel2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Fondo.jpg"));
		lblNewLabel.setBounds(0, -21, 804, 391);
		contentPane.add(lblNewLabel);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCuenta = new JMenu("Cuenta");
		menuBar.add(mnCuenta);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Perfil");
		mnCuenta.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Cerrar sesi\u00F3n");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnValue= JOptionPane.showConfirmDialog(null, "¿Está seguro/a que desea cerrar la sesión?", "Confirmación", JOptionPane.CANCEL_OPTION);
		    	 if(returnValue == 0) {
		    		Empresa.getInstance().setConexion(false);
		    		
		    		FileOutputStream empresa2;
					ObjectOutputStream empresaWrite;
					try {
						empresa2 = new  FileOutputStream("Altice.dat");
						empresaWrite = new ObjectOutputStream(empresa2);
						empresaWrite.writeObject(Empresa.getInstance());
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		
		    		dispose();
		    	 }
			}
		});
		mnCuenta.add(mntmNewMenuItem_3);
		
			JMenu mnNewMenu1 = new JMenu("Registros");
			menuBar.add(mnNewMenu1);
			
				JMenuItem mntmNewMenuItem_21 = new JMenuItem("Registro de empleados");
				mntmNewMenuItem_21.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegEmpleado regEmpleado = null;
						try {
							regEmpleado = new RegEmpleado("Registrar empleado", 0, null);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						regEmpleado.setVisible(true);
					}
				});
				mnNewMenu1.add(mntmNewMenuItem_21);
				
				JMenuItem mntmNewMenuItem = new JMenuItem("Crear plan");
				mnNewMenu1.add(mntmNewMenuItem);
				mntmNewMenuItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CrearPlan crearPlan = new CrearPlan();
						crearPlan.setVisible(true);
					}
				});
		
		JMenu mnNewMenu = new JMenu("Listados");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Clientes");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Empresa.getInstance().getClientes().size() == 0) {
					JOptionPane.showMessageDialog(null, "Actualmente no hay clientes registrados.", "Información", JOptionPane.INFORMATION_MESSAGE);
				} else {
					ListClientes listClientes = new ListClientes();
					listClientes.setVisible(true);
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmFacturas = new JMenuItem("Facturas");
		mntmFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Empresa.getInstance().getFacturas().size() == 0) {
					JOptionPane.showMessageDialog(null, "Actualmente no hay facturas realizadas.", "Información", JOptionPane.INFORMATION_MESSAGE);
				} else {
					ListFactura listFacturas = new ListFactura();
					listFacturas.setVisible(true);
				}
			}
		});
		mnNewMenu.add(mntmFacturas);
		
		JMenuItem mntmEmpleados = new JMenuItem("Empleados");
		mntmEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Empresa.getInstance().getEmpleados().size() == 0) {
					JOptionPane.showMessageDialog(null, "Actualmente no hay empleados registrados.", "Información", JOptionPane.INFORMATION_MESSAGE);
				} else {
					ListEmpleados listEmpleados = new ListEmpleados();
					listEmpleados.setVisible(true);
				}
			}
		});
		mnNewMenu.add(mntmEmpleados);
		
		JMenu mnNewMenu_1 = new JMenu("Reportes");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Cantidad de usuarios por plan");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GraficoCantUsuariosPlan graficoCantUsuariosPlan = new GraficoCantUsuariosPlan();
				graficoCantUsuariosPlan.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Ganancias mensuales");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
	
	}
}
