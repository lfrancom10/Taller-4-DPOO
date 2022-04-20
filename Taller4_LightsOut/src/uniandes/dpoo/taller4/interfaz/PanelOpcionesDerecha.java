package uniandes.dpoo.taller4.interfaz;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelOpcionesDerecha extends JPanel
{
	private JButton btnNuevo;
	private JButton btnReiniciar;
	private JButton btnTop10;
	private JButton btnCambiarJugador;
	
	public PanelOpcionesDerecha()
	{		
		setLayout(new GridLayout(21,1));
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setBackground(new Color(43, 158, 234));
		btnNuevo.setForeground(Color.WHITE);
		
		btnReiniciar = new JButton("REINICIAR");
		btnReiniciar.setBackground(new Color(43, 158, 234));
		btnReiniciar.setForeground(Color.WHITE);
		
		btnTop10 = new JButton("TOP-10");
		btnTop10.setBackground(new Color(43, 158, 234));
		btnTop10.setForeground(Color.WHITE);
		
		btnCambiarJugador = new JButton("CAMBIAR JUGADOR");
		btnCambiarJugador.setBackground(new Color(43, 158, 234));
		btnCambiarJugador.setForeground(Color.WHITE);
		
		
		
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
		
		add(btnNuevo);
		add(new JLabel(""));
		add(btnReiniciar);
		add(new JLabel(""));
		add(btnTop10);
		add(new JLabel(""));
		add(btnCambiarJugador);
		
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
	}
	
	public JButton darBNuevo()
	{
		return btnNuevo;
	}
	
	public JButton darBReiniciar()
	{
		return btnReiniciar;
	}
	
	public JButton darBTop10()
	{
		return btnTop10;
	}
	
	public JButton darBCambiarJugador()
	{
		return btnCambiarJugador;
	}
}
