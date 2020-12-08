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

public class GraficoGananciasMensuales extends JFrame {

	private JPanel panel;
	public GraficoGananciasMensuales() {
		setTitle("GANANCIAS MENSUALES");
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
		int[] aux = new int[12];
		for (int i = 0; i < Empresa.getInstance().getPlanes().size(); i++) {
			if(i==0) {
				dataset.setValue(aux[i], "Enero","");
			}else if(i==1) {
				dataset.setValue(aux[i],  "Febrero","");
			}else if(i==2) {
				dataset.setValue(aux[i],  "Marzo","");
			}else if(i==3) {
				dataset.setValue(aux[i],  "Abril","");
			}else if(i==4) {
				dataset.setValue(aux[i],  "Mayo","");
			}else if(i==5) {
				dataset.setValue(aux[i], "Junio","");
			}else if(i==6) {
				dataset.setValue(aux[i], "Julio","");
			}else if(i==7) {
				dataset.setValue(aux[i],  "Agosto","");
			}else if(i==8) {
				dataset.setValue(aux[i],  "Septiembre","");
			}else if(i==9) {
				dataset.setValue(aux[i],  "Octubre","");
			}else if(i==10) {
				dataset.setValue(aux[i],  "Noviembre","");
			}else if(i==11) {
				dataset.setValue(aux[i], "Diciembre","");
			}
		}
		JFreeChart chart = ChartFactory.createBarChart3D("GANANCIAS MENSUALES", "Mes", 
				"Cantidad de ganancias mensuales", dataset,PlotOrientation.VERTICAL,true,true,false);
		chart.setBorderPaint(Color.white);
		chart.getTitle().setPaint(Color.black);
		CategoryPlot p = chart.getCategoryPlot();
		p.setRangeGridlinePaint(Color.red);
		ChartPanel chartPanel = new ChartPanel(chart);
		panel.add(chartPanel);
	}
	public static void main(String[] args) {
		new GraficoGananciasMensuales().setVisible(true);
	}


}
