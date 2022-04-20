package uniandes.dpoo.taller4.interfaz;

import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class PanelOpcionesArriba extends JPanel
{
	
	private JLabel lblTamanio;
	private JComboBox<String> cmbTamanio;
	private JLabel lblDificultad;
	private JRadioButton rbtnFacil;
	private JRadioButton rbtnMedio;
	private JRadioButton rbtnDificil;
	private ButtonGroup bg;
	
	public PanelOpcionesArriba()
	{
		setBackground(new Color(43, 158, 234));
		
		lblTamanio = new JLabel("Tamaño: ");
		lblTamanio.setForeground(Color.WHITE);
		
		lblDificultad = new JLabel("Dificultad: ");
		lblDificultad.setForeground(Color.WHITE);
		
		cmbTamanio = new JComboBox<>();
		cmbTamanio.addItem("5X5");
		cmbTamanio.addItem("6X6");
		cmbTamanio.addItem("7X7");
		cmbTamanio.setEditable(false);
		
		bg = new ButtonGroup();
		
		rbtnFacil = new JRadioButton("Facil");
		rbtnFacil.setBackground(new Color(43, 158, 234));
		rbtnFacil.setForeground(Color.WHITE);
		rbtnFacil.setSelected(true);
		bg.add(rbtnFacil);
		
		rbtnMedio = new JRadioButton("Medio");
		rbtnMedio.setBackground(new Color(43, 158, 234));
		rbtnMedio.setForeground(Color.WHITE);
		bg.add(rbtnMedio);
		
		rbtnDificil = new JRadioButton("Dificil");
		rbtnDificil.setBackground(new Color(43, 158, 234));
		rbtnDificil.setForeground(Color.WHITE);
		bg.add(rbtnDificil);
		
		this.add(lblTamanio);
		this.add(cmbTamanio);
		this.add(lblDificultad);
		this.add(rbtnFacil);
		this.add(rbtnMedio);
		this.add(rbtnDificil);
	}	
	
	public int darTamanio()
	{
		int resp = 0;
		if(cmbTamanio.getSelectedIndex()==0)
		{
			resp = 5;	
		}
		else if(cmbTamanio.getSelectedIndex()==1)
		{
			resp=6;
		}
		else if(cmbTamanio.getSelectedIndex()==2)
		{
			resp=7;
		}
		return resp;
	}
	
	public int darDificultad()
	{
		int resp = 0;
		if(rbtnFacil.isSelected())
		{
			resp=5;
		}
		else if(rbtnMedio.isSelected())
		{
			resp=10;
		}
		else if(rbtnDificil.isSelected())
		{
			resp=20;
		}
		return resp;
	}
}
