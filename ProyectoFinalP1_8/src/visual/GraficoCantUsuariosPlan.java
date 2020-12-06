package visual;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoCantUsuariosPlan extends JFrame {

	private JPanel panel;
	public GraficoCantUsuariosPlan() {
		setTitle("CANTIDAD DE USUARIOS POR PLAN");
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		init();
	}
	private void init() {
		panel = new JPanel();
		getContentPane().add(panel);
		//DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		//JFreeChart chart = ChartFactory.createBarChart3D;
	}
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraficoCantUsuariosPlan frame = new GraficoCantUsuariosPlan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}


}
