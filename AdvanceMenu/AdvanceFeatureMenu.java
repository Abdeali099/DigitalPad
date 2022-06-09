package AdvanceMenu;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class AdvanceFeatureMenu extends JMenu
{
	public	JMenuItem AutoSave;
	
			public AdvanceFeatureMenu(String Title)
			{
		                      super(Title);
		                      
		                      AutoSave=new JMenuItem("Auto Save");
		                      
		                      AutoSave.setBackground(Color.white);
		                      
		                      add(AutoSave);
		                      
			}
	
	
}
