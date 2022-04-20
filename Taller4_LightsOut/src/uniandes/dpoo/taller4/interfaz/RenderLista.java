package uniandes.dpoo.taller4.interfaz;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

@SuppressWarnings("serial")
public class RenderLista extends DefaultListCellRenderer {
	/** Creates a new instance of LocaleRenderer */
	public RenderLista() 
	{
		
	}

	@SuppressWarnings("rawtypes")
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) 
	{
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		 
		
		
		if (isSelected) 
		{
            setFont(new Font("Lucida Sans", Font.BOLD, 30));
            setBackground(new Color(43, 158, 234));
			setForeground(Color.WHITE);
            setOpaque(true);
        } 
		else 
        {
			setFont(new Font("Verdana", Font.BOLD, 28));
			setForeground(Color.black);
			setOpaque(false);
        }
		
		return this;
	}
}