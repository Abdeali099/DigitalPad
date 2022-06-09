package ViewMenu;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ViewMenu extends JMenu
{
	// Step 1 Making refrence what we need //	
	
		 public	JMenuItem Fonts,Theme;     //   --> It is a Menu Item Of "File" -> New,NumberPanelen,Close,Save,Save as,Exit.

		 					public ViewMenu(String s)
		 					{
		 						 super(s); // :- s="File"
		 						
		 					    // Step 2 (File Menu Items)//	
			                     
			                     Fonts = new JMenuItem("Fonts");
			                     Theme = new JMenuItem("Theme");		                    			                    
			                   
			                     
			           	                     
			                  // Step 3  --> Adding menu Items  // 
			             		
			             		add(Fonts);  addSeparator(); add(Theme);
			             		
			             		Fonts.setBackground(Color.white);
			      			    Theme.setBackground(Color.white);
			    	       		 						
		 					} // constructor close
		 	
		 

}
