package uniandes.dpoo.taller4.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

@SuppressWarnings("serial")
public class InterfazLigthsOut extends JFrame implements ActionListener, MouseListener
{
	private PanelTablero panelTablero;
	private PanelOpcionesArriba panelOpcionesArriba;
	private PanelOpcionesDerecha panelOpcionesDerecha;
	private PanelInformacion panelInformacion;
	
	private int[][] cantidades;
	private int ultimaFila;
	private int ultimaColumna;
	
	private Tablero tablero;
	private File archivo;
	private Top10 top10;

	public InterfazLigthsOut()
	{
		setTitle("Juego Lights Out");
		archivo = new File("./data/top10.csv");
		top10 = new Top10();
		top10.cargarRecords(archivo);
		
		tablero = new Tablero(5);
		tablero.desordenar(5);
		
		cantidades = new int[tablero.darTablero().length][tablero.darTablero().length];
		ultimaFila = 100;
		ultimaColumna = 100;
		
		panelTablero = new PanelTablero(tablero);
		panelTablero.addMouseListener(this);
		
		
		panelOpcionesArriba = new PanelOpcionesArriba();
		panelOpcionesDerecha = new PanelOpcionesDerecha();
		
		panelOpcionesDerecha.darBNuevo().addActionListener(this);
		panelOpcionesDerecha.darBReiniciar().addActionListener(this);
		panelOpcionesDerecha.darBTop10().addActionListener(this);
		panelOpcionesDerecha.darBCambiarJugador().addActionListener(this);
		
		panelInformacion = new PanelInformacion();
		
		this.setSize(600, 500);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
		
		this.add(panelTablero, BorderLayout.CENTER);
		this.add(panelOpcionesArriba, BorderLayout.NORTH);
		this.add(panelOpcionesDerecha, BorderLayout.EAST);
		this.add(panelInformacion, BorderLayout.SOUTH);
		
		String entradaUsuario = JOptionPane.showInputDialog("Introduzca el nombre del jugador:");
		panelInformacion.cambiarJugador(entradaUsuario);
		
		addWindowListener(new WindowAdapter()
		{
		public void windowClosing(WindowEvent e)
		{
			try {
				top10.salvarRecords(archivo);
			} 
			catch (FileNotFoundException e1) 
			{
				e1.printStackTrace();
			}
			catch (UnsupportedEncodingException e1) 
			{
				e1.printStackTrace();
			}
		}
		});
	}
	
	
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==panelOpcionesDerecha.darBNuevo()) 
		{
			tablero = new Tablero(panelOpcionesArriba.darTamanio());
			tablero.desordenar(panelOpcionesArriba.darDificultad());
			panelInformacion.reiniciarJugadas();
			
			cantidades = new int[tablero.darTablero().length][tablero.darTablero().length];
			ultimaFila = 100;
			ultimaColumna = 100;
			
			panelTablero.setVisible(false);
			panelTablero = new PanelTablero(tablero);
			panelTablero.addMouseListener(this);
			
			this.add(panelTablero, BorderLayout.CENTER);
			panelTablero.setVisible(true);
			panelTablero.repaint();
		}
		else if (e.getSource()==panelOpcionesDerecha.darBReiniciar()) 
		{
			tablero.reiniciar();
			cantidades = new int[tablero.darTablero().length][tablero.darTablero().length];
			panelInformacion.reiniciarJugadas();
			
			panelTablero.setVisible(false);
			panelTablero = new PanelTablero(tablero);
			panelTablero.addMouseListener(this);
			
			this.add(panelTablero, BorderLayout.CENTER);
			panelTablero.setVisible(true);
			panelTablero.repaint();
		}
		else if (e.getSource()==panelOpcionesDerecha.darBTop10()) 
		{
			JDialog dlg = new JDialog();
			dlg.setSize(300, 500);
			dlg.setLayout(new BorderLayout());
			
			DefaultListModel model = new DefaultListModel();
			
			int contador = 0;
			for(RegistroTop10 r:top10.darRegistros())
			{
				contador++;
				if(contador==10)
				{
					if(!r.darNombre().equals(""))
						model.addElement(contador + "   " + r.darNombre() + "         " + r.darPuntos());
					else
						model.addElement(contador + "     " + r.darNombre() + "              " + r.darPuntos());
				}
				else
				{
					if(!r.darNombre().equals(""))
						model.addElement(contador + "     " + r.darNombre() + "         " + r.darPuntos());
					else
						model.addElement(contador + "         " + r.darNombre() + "            " + r.darPuntos());
				}
			}
			
			JList list = new JList();
			RenderLista render = new RenderLista();
			list.setCellRenderer(render);
			list.setModel(model);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
			JScrollPane sp = new JScrollPane();
			sp.setViewportView(list);
			
			JPanel panel = new JPanel();
			String txt = "<html><h1 style=\"font-family: Verdana, Geneva, Tahoma, sans-serif; font-size: large;\"># &nbsp; &nbsp; &nbsp; &nbsp; NOMBRE &nbsp; &nbsp; RECORD</h1></html>";
			JLabel lbl = new JLabel(txt);
			panel.setBackground(new Color(43, 158, 234));
			lbl.setForeground(Color.WHITE);
			panel.add(lbl);
			
			dlg.add(panel, BorderLayout.NORTH);
			dlg.add(sp, BorderLayout.CENTER);
			dlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		    dlg.setVisible(true);
		    dlg.setLocationRelativeTo(null);
		}
		else if (e.getSource()==panelOpcionesDerecha.darBCambiarJugador()) 
		{
			String entradaUsuario = JOptionPane.showInputDialog("Introduzca el nombre del nuevo jugador:");
			panelInformacion.cambiarJugador(entradaUsuario);
		}
	}

	   public void mousePressed(MouseEvent e)
	    {
	    	int click_x = e.getX();
	    	int click_y = e.getY();
	    	int[] casilla = panelTablero.convertirCoordenadasACasilla(click_x, click_y);
	    	cantidades[casilla[0]][casilla[1]]++;
	    	panelInformacion.agregarJugada();
	    	tablero.jugar(casilla[0], casilla[1]);
	    	this.ultimaFila = casilla[0];
	    	this.ultimaColumna = casilla[1];
	    	panelTablero.agregarJugada(ultimaColumna, ultimaFila);
	    	repaint();
	    	if(tablero.tableroIluminado())
	    	{
	    		if(top10.esTop10(panelInformacion.darContador()))
	    		{
	    			top10.agregarRegistro(panelInformacion.darJugador(), panelInformacion.darContador());
		    		
	    		}
	    		JOptionPane.showMessageDialog(null,"Felicitaciones! Ha terminado el nivel con un puntaje: "+panelInformacion.darContador());
	    		actionPerformed(new ActionEvent(panelOpcionesDerecha.darBNuevo(), 500, "NUEVOc"));
	    	}
	    }


	public static void main(String[] args) 
	{
		@SuppressWarnings("unused")
		InterfazLigthsOut aplicacion = new InterfazLigthsOut();
	}




	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
