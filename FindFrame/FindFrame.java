package FindFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

import MainFrame.*;



public class FindFrame extends JDialog implements KeyListener,ActionListener //,ItemListener
{

	JLabel Text,Errors;
	
	JTextField WordField;
	
	JButton BFind;
	
	// JCheckBox CaseMatch;
	
	JTextArea MainTextArea;
	
	Container cont;
	
	ImageIcon icon;

	boolean Case=false;
	
	String Find;

	
	Highlighter hilite;
	
	
	 
       public FindFrame(Container cont, String title,JTextArea MainTextArea) 
       {
    	           super();	   
    	        // ------------------------------------- Extra :- Find MenuItem -------------------------------------  //
	               
	               
	            /*   FindWord=new FindFrame(cont,"Find Word",MainTextArea,DN);
	                     FindWord.setVisible(false); */
    	   
    	           setTitle(title);
    	           
    	           setLayout(null);
    	           
    	           setBackground(Color.white);
    	           
    	           this.MainTextArea=MainTextArea;
    	           
    	           this.cont=cont;
    	           
    	 
//  ------------------------ Locate Label ------------------------  //
    	           
    	           Text=new JLabel("Enter Word :- ");
    	           
    	           Text.setFont(new Font("Arial",Font.PLAIN,15));
    	           
    	            Text.setBounds(5,15,100,20);
    	            
    	            add(Text);
 
//  ------------------------ Locate TextFiels ------------------------  //

    	            WordField=new JTextField();
    	            
    	            WordField.setFont(new Font("Arial",Font.PLAIN,15));
     	           
    	            WordField.setBounds(110,12,200,25);
    	            
    	            add(WordField);
    	            
    	            WordField.addKeyListener(this);
 
//  ------------------------ Locate CheckBox ------------------------  //
 
    /*	           CaseMatch=new JCheckBox("Match-Case");
    	           
    	           CaseMatch.setFont(new Font("Arial",Font.BOLD,15));
     	           
    	           CaseMatch.setBounds(120,40,200,25);
   	            
   	            	add(CaseMatch);
   	            
   	            	CaseMatch.addItemListener(this);   */
    	           
//  ------------------------ Locate Button ------------------------  //
   	           
   	            	BFind=new JButton("Find");
   	            	
   	            	BFind.setFont(new Font("Arial",Font.ITALIC,15));
      	           
   	            	BFind.setBounds(105,80,205,25);
    	            
    	            	add(BFind);
    	            
    	            	BFind.addActionListener(this);
    	            	
 //  ------------------------ Showing Error  ------------------------  //
	            	
    	            	   
                 	     Errors=new JLabel("Word Not Found !!!");
                 	     
                 	     Errors.setVisible(false);
                 	       
                 	   Errors.setBounds(120,40,200,25);
     	                
                 	 Errors.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
                               
                 	 Errors.setForeground(Color.red);
                 	 
                   	       add(Errors);
                   	       
  //-------------------------------------------- Set Icon for Frame -----------------------------//
   
										   icon=new ImageIcon("src\\symbol.png");
										
										   this.setIconImage(icon.getImage());
										                   	       

 //  ------------------------ Remove HighLighter ------------------------  //
    	            	
    	                this.addWindowListener(new WindowAdapter()
    	              		  
    	  								            		  {
    	              	  
    	              	                                           public void windowClosing(WindowEvent e)
    	              	                                           {
    	  								            	            
    	              	                                        	   Exit();
    	  								            		 
    	              	                                           }      		  
    	              		  
    	  								            		  }    
    	              		  );
    	              
    	           
       } // constructor close
       
    // -------------------------------------Here Is Nested Class For Find Word ------------------------------------------------------ //
 	  
 	  class MyHighLightPainter extends DefaultHighlighter.DefaultHighlightPainter
 	  {
 		            public MyHighLightPainter(Color color)
 		            {
 		            	super(color);
 		            }
 	  } // Nested Class Close
   	  
 	  
     Highlighter.HighlightPainter myHighLightPainter =new MyHighLightPainter(Color.yellow); // It Is Only FOr Setting Which Color Do Yuy want?

 public void removeHighlights(JTextComponent textcomp)
 {
	      hilite=textcomp.getHighlighter();
	 
	 Highlighter.Highlight[] hilites=hilite.getHighlights();
	 
	 for(int i=0; i< hilites.length;i++)
	 {
		 if(hilites[i].getPainter() instanceof MyHighLightPainter)
		 {
			 hilite.removeHighlight(hilites[i]); 
		 }
	 }
 }
     
     
 public void highlight(JTextComponent textcomp,String Pattern)
 {
	 removeHighlights(textcomp);
	 
               try
               {
             	  hilite=textcomp.getHighlighter();
             	  
             	  Document doc=textcomp.getDocument();
             	  
             	  String Text=doc.getText(0, doc.getLength());
             	  
             	  int pos=0;
             	  
             	  while((pos=Text.toUpperCase().indexOf(Pattern.toUpperCase(),pos))>=0)
             	  {
             		  hilite.addHighlight(pos, pos+Pattern.length(), myHighLightPainter);
             	  
             	       pos +=Pattern.length();
             	  }
             	  
               } // try close
               
               catch(Exception e)
               {
             	  System.out.print("\n\t Error :- " + e.getMessage());
               }

 } // method close
 	  
 // --------------------------------------------------------------------------------------------------------------------- //


       public void actionPerformed(ActionEvent ae)
       {
    	   try 
   		{
   		
    		   
    	   Find=WordField.getText();
   	    
   	    String Data=MainTextArea.getText();
   	       
   	 if(Data.contains(Find)==true && Find.length()>=1 && Data.length()>=1)
 	     {
   	    	          highlight(MainTextArea,Find);
   	    	            Errors.setVisible(false);
   	    	          
    	   }
   	       
   	       else
   	       {
   	    	   	 Errors.setVisible(true);
   	   
   	       }
    	   
       }// try close
       
       
       catch(Exception e)
       {
    	   System.out.print("\n\t ==> Error :- " + e.getMessage());
       }
       
       }// method close
       
       // ---------------------------------------------------------------------------  //
		
	public void keyPressed(KeyEvent ke)
	{
		char ch;
		
		try 
		{
		
		           ch=ke.getKeyChar();
		           
		           if(ch=='\n')
		           {
		        	    Find=WordField.getText();
		        	    
		        	    String Data=MainTextArea.getText();
	            	       
		        	    if(Data.contains(Find)==true && Find.length()>=1 && Data.length()>=1)
		        	    {
	            	    	          highlight(MainTextArea,Find);
	            	    	            
	            	    	                 Errors.setVisible(false);
	            	    	          
	             	       }
	            	       
	            	       else
	            	       {
	            	    	   	 Errors.setVisible(true);
	            	       }
		           
		     }
		           
		}// try close
        
        
        catch(Exception e)
        {
     	   System.out.print("\n\t ==> Error :- " + e.getMessage());
        }
		
	}
	
	
	void Exit()
	{
		       if(hilite!=null)
		       {
		       hilite.removeAllHighlights();
		       Errors.setVisible(false);
		       }
		       
		       else
		       {
		    	   this.dispose();
		    	   Errors.setVisible(false);
		       }
	}
	
	/*public void itemStateChanged(ItemEvent ie) 
	{
		      
		               if(CaseMatch.isSelected())
		               {
		            	   Case=true; // Match Case
		               }
		               
		               else
		               {
		            	   Case=false;
		               }
		
		
	} */
	
	
	public void keyReleased(KeyEvent e) {}     public void keyTyped(KeyEvent e) {}


	
	
		        
}
