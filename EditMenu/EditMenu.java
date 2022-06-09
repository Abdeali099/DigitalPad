package EditMenu;

import java.awt.Color;
import MainFrame.*;

import java.awt.Container;

import javax.swing.JMenu;

import javax.swing.JMenuItem;

public class EditMenu extends JMenu
{
	
	// Step 1 Making refrence what we need //	
	
	 public	JMenuItem Copy,Paste,Cut,SelectAll,Replace,Find;     //   --> It is a Menu Item Of "File" -> New,Open,Close,Save,Save as,Exit.

	 					public EditMenu(String s)
	 					{
	 						 super(s); // :- s="File"
	 						
	 					    // Step 2 (File Menu Items)//	
		                     
		                     Copy = new JMenuItem("Copy");
		                     Paste=new JMenuItem("Paste");
		                    Cut= new JMenuItem("Cut");		                    
		                     SelectAll= new JMenuItem("Select All");
		                     Replace = new JMenuItem("Replace All");
		                     Find = new JMenuItem("Find");
		                     
		                     
		           	                     
		                  // Step 3  --> Adding menu Items  // 
		             		
		             		add(Copy); add(Paste); add(Cut);  add(SelectAll);  addSeparator();  add(Replace); add(Find);  
		             		
		             		Copy.setBackground(Color.white);
		             		Paste.setBackground(Color.white);
		             		Cut.setBackground(Color.white);
		             		SelectAll.setBackground(Color.white);
		             		Replace.setBackground(Color.white);
		             		Find.setBackground(Color.white);
		             			 						
	 					} // constructor close
	 	
	 	


}// class close

  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
											//File Menu Close //
