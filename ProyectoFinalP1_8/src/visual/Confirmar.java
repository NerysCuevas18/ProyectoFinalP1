package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logico.Cliente;
import logico.Empresa;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Confirmar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField textCedulaSal;
	private boolean tipo;
	private String ced;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		try {
			Saldo dialog = new Saldo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 * @throws ParseException 
	 */
	public Confirmar(boolean tipo, String ced) throws ParseException {
		this.ced = ced;
		this.tipo = tipo;
		setTitle("Saldo");
		setBounds(100, 100, 405, 182);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setResizable(false);
		setLocationRelativeTo(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setBounds(10, 11, 46, 14);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Por favor, introduzca su c\u00E9dula para seguir con la operaci\u00F3n.");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(10, 7, 359, 31);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel label = new JLabel("C\u00E9dula:");
				label.setBounds(102, 49, 175, 14);
				panel.add(label);
			}
			{
				MaskFormatter formatter = new MaskFormatter("###-#######-#");
				textCedulaSal = new JFormattedTextField(formatter);
				textCedulaSal.setColumns(10);
				textCedulaSal.setBounds(102, 66, 175, 23);
				panel.add(textCedulaSal);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Continuar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Cliente cliente = Empresa.getInstance().findCliente(textCedulaSal.getText());
						if(cliente!=null) {
							if(!cliente.isEstado())
							{
								int returnValue= JOptionPane.showConfirmDialog(null, "Su cuenta está bloqueada. ¿Desea activarla con un costo de RD$500.00?", "Confirmación", JOptionPane.CANCEL_OPTION);
						    	 if(returnValue == 0) {
						    		 cliente.setEstado(true);
						    		 JOptionPane.showMessageDialog(null, "Su cuenta ha sido restaurada. Pague las deudas pendientes antes de que sea bloqueada nuevamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
						    	 }
						    	 else dispose();
							}
							else {
							if(tipo) {
								if(cliente.getFacturasMensual().size()==0)
									JOptionPane.showMessageDialog(null, "Usted no tiene facturas pendientes de pago.", "Información", JOptionPane.INFORMATION_MESSAGE);
								else {
									PagarFactura pagarFactura = new PagarFactura(cliente);
									pagarFactura.setVisible(true);
								}
							} else {
								CompraPlan compraPlan = new CompraPlan(ced, cliente.getNombres(), cliente.getCedula());
								compraPlan.setVisible(true);
							}
							dispose();
							}
						} else {
							int returnValue= JOptionPane.showConfirmDialog(null, "El usuario insertado no se encuentra en nuestros registros. ¿Desea añadirlo?", "Confirmación", JOptionPane.CANCEL_OPTION);
					    	 if(returnValue == 0) {
					    		 RegCliente regCliente = null;
								try {
									regCliente = new RegCliente("Registrar cliente", 0, null, textCedulaSal.getText());
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
					    		 regCliente.setVisible(true);
					    		 if (regCliente.getCondicion()==1) {
										dispose();
									} else {
					    	 
					    	 if(tipo) {
					    		 JOptionPane.showMessageDialog(null, "¡Bienvenido a Altice! Sus facturas serán generadas el 15 de cada mes", "Información", JOptionPane.INFORMATION_MESSAGE);
					    		 dispose();
					    	 } else {
					    		 JOptionPane.showMessageDialog(null, "¡Bienvenido a Altice! Ya puedes activar tu Plan.", "Información", JOptionPane.INFORMATION_MESSAGE);
					    		 
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
	}

}
