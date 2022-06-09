package HelpMenu;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class HelpMenu extends JMenu
{
	public JMenuItem About,Help;
	
	public HelpMenu(String Title)
	{
		                 super(Title);
	
	
		                 Help=new JMenuItem("View Help");
		                 About=new JMenuItem("About DigitalPad");
		                 
		                 add(Help); addSeparator(); add(About);
		                 
		                 Help.setBackground(Color.white);
		                 About.setBackground(Color.white);
		                 
		}

	
}
