package uniandes.dpoo.taller4.interfaz;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

@SuppressWarnings("serial")
public class PanelTablero extends JPanel
{
	private Tablero tablero;
	private JLabel[][] contadores;
	
	public PanelTablero(Tablero tablero)
	{
		this.tablero = tablero;
		this.contadores = new JLabel[tablero.darTablero().length][tablero.darTablero().length];
		this.setLayout(new GridLayout(tablero.darTablero().length,tablero.darTablero().length));
        reiniciarjugadas();
		repaint();
	}
	
	private void reiniciarjugadas() 
	{
		int num = tablero.darTablero().length;
        
		for(int i=0;i<num;i++)
		{
			for(int j=0;j<num;j++)
			{
				contadores[j][i] = new JLabel("0");
				this.add(contadores[j][i]);
			}
		}
	}

	private void pintar(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        
        int num = tablero.darTablero().length;
        
        int x = (getWidth())/num;
        int y = (getHeight())/num;
        
        for(int i=0;i<num;i++)
        {
        	for(int j=0;j<num;j++)
            {
            	if(tablero.darTablero()[j][i])
            	{
            		g2d.setPaint(new GradientPaint(i*(x), j*(y), Color.WHITE, (i+1)*(x), (j+1)*(y), new Color(249, 255, 111)));
            		g2d.fillRoundRect(i*(x), j*(y), x, y, 10, 10);
            		contadores[i][j].setForeground(Color.BLACK);
            	}
            	else
            	{
            		g2d.setPaint(new GradientPaint(i*(x), j*(y), Color.BLACK, (i+1)*(x), (j+1)*(y), new Color(56, 56, 55)));
            		g2d.fillRoundRect(i*(x), j*(y), x, y, 10, 10);
            		contadores[i][j].setForeground(Color.WHITE);
            	}
            }
        }
        
        
    }
	
	public void agregarJugada(int x, int y)
	{
		contadores[x][y].setText(Integer.toString(Integer.parseInt(contadores[x][y].getText())+1));
	}

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        pintar(g);
    }
    
    public int[] convertirCoordenadasACasilla(int x, int y)
    {
    	int num = tablero.darTablero().length;
        int anchoCasilla = (getWidth())/num;
        int altoCasilla = (getHeight())/num;
    	int fila = (int) (y / (altoCasilla));
    	int columna = (int) (x / (anchoCasilla));
    	return new int[] { fila, columna };
    }
}
