package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Empresa;

public class PrincipalCom extends JFrame { 

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalCom frame = new PrincipalCom();
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
	public PrincipalCom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
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
		

		JMenu mnNewMenu1 = new JMenu("Compra de planes");
		menuBar.add(mnNewMenu1);
	
		JMenuItem mntmNewMenuItem_21 = new JMenuItem("Compra de planes");
		mntmNewMenuItem_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompraPlan compraPlan = new CompraPlan();
				compraPlan.setVisible(true);
			}
		});
		mnNewMenu1.add(mntmNewMenuItem_21);
	}

}
