package FileMenu;

import java.awt.Color;
import MainFrame.*;
import java.awt.Container;

import javax.swing.JMenu;

import javax.swing.JMenuItem;

public class FileMenu extends JMenu
{
	
	// Step 1 Making refrence what we need //	
	
	 public	JMenuItem ne,NewWind,op,sa,sas,prn,ex;     //   --> It is a Menu Item Of "File" -> New,Open,Close,Save,Save as,Exit.

	 					public FileMenu(String s)
	 					{
	 						 super(s); // :- s="File"
	 						
	 					    // Step 2 (File Menu Items)//	
		                     
		                     ne = new JMenuItem("New");
		                     NewWind=new JMenuItem("New Window");
		                     op = new JMenuItem("Open");		                    
		                     sa = new JMenuItem("Save");
		                     sas = new JMenuItem("Save As");
		                     prn = new JMenuItem("Print");
		                     ex = new JMenuItem("Exit");
		                     
		           	                     
		                  // Step 3  --> Adding menu Items  // 
		             		
		             		add(ne); add(NewWind); add(op);  addSeparator(); add(sa); add(sas); add(prn);   addSeparator(); add(ex);
		             		
		             		ne.setBackground(Color.white);
		             		NewWind.setBackground(Color.white);
		             		op.setBackground(Color.white);
		             		sa.setBackground(Color.white);
		             		sas.setBackground(Color.white);
		             		prn.setBackground(Color.white);
		             		ex.setBackground(Color.white);

	 						
	 					} // constructor close
	 	
	 
}// class close

  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
											//File Menu Close //
