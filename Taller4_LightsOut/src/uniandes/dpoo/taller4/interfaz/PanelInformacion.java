package uniandes.dpoo.taller4.interfaz;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class PanelInformacion extends JPanel
{
	private JLabel lblJugadas;
	private JLabel lblNJugadas;
	private JLabel lblJugador;
	private JLabel lblNombreJugador;
	
	private int contador;
	
	public PanelInformacion()
	{
		setLayout(new GridLayout(1,4));
		
		lblJugadas = new JLabel("Jugadas:");
		contador = 0;
		lblNJugadas = new JLabel(Integer.toString(contador));
		lblJugador = new JLabel("Jugador:");
		lblNombreJugador = new JLabel("");
		
		Border borde = BorderFactory.createLineBorder(Color.GRAY, 1);
		
		lblNJugadas.setBorder(borde);
		lblNombreJugador.setBorder(borde);
		
		add(lblJugadas);
		add(lblNJugadas);
		add(lblJugador);
		add(lblNombreJugador);
	}
	
	public void agregarJugada()
	{
		contador++;
		lblNJugadas.setText(Integer.toString(contador));
	}
	
	public void reiniciarJugadas()
	{
		contador=0;
		lblNJugadas.setText(Integer.toString(contador));
	}
	
	public String darJugador()
	{
		return lblNombreJugador.getText();
	}
	
	public int darContador()
	{
		return Integer.parseInt(lblNJugadas.getText());
	}
	
	public void cambiarJugador(String nombre)
	{
		lblNombreJugador.setText(nombre);
	}
}
