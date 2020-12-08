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

import logico.Empresa;

public class GraficoCantUsuariosPlan extends JFrame {

	private JPanel panel;
	public GraficoCantUsuariosPlan() {
		setTitle("CANTIDAD DE USUARIOS POR PLAN");
		setSize(800,475);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		init();
	}
	private void init() {
		panel = new JPanel();
		getContentPane().add(panel);
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		int[] aux = new int[Empresa.getInstance().getPlanes().size()];
		aux = Empresa.getInstance().cantClientePlan();
		for (int i = 0; i < Empresa.getInstance().getPlanes().size(); i++) {
			dataset.setValue(aux[i],Empresa.getInstance().getPlanes().get(i).getNombreP(),"" );
		}
		JFreeChart chart = ChartFactory.createBarChart3D("CANTIDAD DE USUARIOS POR PLAN", "Nombre de plan", 
				"Cantidad de usuarios por plan", dataset,PlotOrientation.VERTICAL,true,true,false);
		chart.setBorderPaint(Color.white);
		chart.getTitle().setPaint(Color.black);
		CategoryPlot p = chart.getCategoryPlot();
		p.setRangeGridlinePaint(Color.red);
		ChartPanel chartPanel = new ChartPanel(chart);
		panel.add(chartPanel);
	}
	/*public static void main(String[] args) {
		new GraficoCantUsuariosPlan().setVisible(true);
	}*/


}
