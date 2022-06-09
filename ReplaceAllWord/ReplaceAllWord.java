package ReplaceAllWord;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ReplaceAllWord extends JDialog implements ActionListener,KeyListener
{

	
	 public  JTextArea MainTextArea;
	 
	 JLabel WordFind,WordReplace,Errors;
	 
	 JButton Replace;
	 
	 JTextField WordFindField,WordReplaceField;
	 
	 String FindWord,ReplaceWord;

	 ImageIcon icon;
	 
	public ReplaceAllWord(Container cont, String title,JTextArea MainTextArea) 
     {
  	           super();	   
  	   
  	           setTitle(title);
  	           
  	           setLayout(null);
  	           
  	           setBackground(Color.white);
  	           
  	           this.MainTextArea=MainTextArea;
  
  	           
  	 // ------------------------ Locate Label For Word Replace ---------------------- //
  	           
  	         WordFind=new JLabel("Enter Word To Be Replace :- ");
  	         
  	         WordFind.setBounds(10,12,200,25);
  	                
  	         WordFind.setFont(new Font("Arial",Font.PLAIN,15));
  
                         add(WordFind);
  	         
  	                
  	          WordFindField=new JTextField();
  	         
  	          WordFindField.setBounds(215,12,200,25);
              
  	          WordFindField.setFont(new Font("Arial",Font.PLAIN,15));
  	          
  	        WordFindField.addKeyListener(this);
                
                         add(WordFindField);
                         
  // ------------------------ Locate Label For Word Replace with---------------------- //
                      	           
                         WordReplace=new JLabel("Enter Word To Be Replace With :- ");
                      	         
                         WordReplace.setBounds(10,50,230,25);
                      	                
                         WordReplace.setFont(new Font("Arial",Font.PLAIN,15));
                                          	                
                      	                add(WordReplace);
                      	                
              	              WordReplaceField=new JTextField();
              	         
              	              WordReplaceField.setBounds(250,50,200,25);
                          
              	             WordReplaceField.setFont(new Font("Arial",Font.PLAIN,15));
              	             
              	           WordReplaceField.addKeyListener(this);
              	           
                                         add(WordReplaceField);
                                         
                                     
  // ------------------------ Locate Button For Execution ---------------------- //    
                                         
                         Replace=new JButton("Replace-All");                
                                    
                         Replace.setBounds(180,85,200,25);
       	                
                         Replace.setFont(new Font("Arial",Font.PLAIN,15));
                         
                         Replace.addActionListener(this);
                                          	                
                      	       add(Replace);
                      	       
  // ---------------------------- Showing Error ------------------------------- // 
                      	       
                      	     Errors=new JLabel("Word Not Found !!!");
                      	     
                      	     Errors.setVisible(false);
                      	       
                      	   Errors.setBounds(150,120,200,25);
          	                
                      	 Errors.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
                                    
                      	 Errors.setForeground(Color.red);
                      	 
                        	       add(Errors);
                        	       
                        	       
//-------------------------------------------- Set Icon for Frame -----------------------------//
		                            
		                            icon=new ImageIcon("src\\symbol.png");
		                    		
                                    this.setIconImage(icon.getImage());
		                    		
		                    		
     // ------------------------------------- Closing Event -----------------------------------//
                        	       
                        	       this.addWindowListener(new WindowAdapter()
         	              		  
				            		  {
 
                                          public void windowClosing(WindowEvent e)
                                          {
				            	            
                                        	  Errors.setVisible(false);
                                        	  
                                        					            		 
                                          }      		  
	  
				            		  }    
	                                       );
                        	       
                        	       

     }
	
			    public void actionPerformed(ActionEvent ae) 
			    {

         	       FindWord=WordFindField.getText();
         	       
         	       ReplaceWord=WordReplaceField.getText();
         	       
         	     //  System.out.print("FIndWord:- -" + FindWord + "---");
         	      // System.out.print("ReplaceWord:- -" + ReplaceWord + "---");
         	       
         	       try {
         	    	   
         	       
         	       	     
      			   if(FindWord==null || FindWord.equals(" ") || FindWord==" ")
      			   {
      				 	 Errors.setVisible(true);
      			   }
      			   
      			   if(ReplaceWord==null || ReplaceWord.equals(" ") || ReplaceWord==" ")
      			   {
      				   ReplaceWord="";
      			   }
      			   	
      			   if(FindWord!=null && ReplaceWord!=null && FindWord.equals(" ")==false && FindWord!=" ")
      			   	{	
      			      Replace();
      			   	}  
      			   
         	  }// try close
         	       
         	       catch(Exception e)
         	       {
         	    	   System.out.print("\n\t Error :- " + e.getMessage());
         	       }
			    	
	       }			
	
	public void keyTyped(KeyEvent ke) 
	{
		
		char ch;
		
		ch=ke.getKeyChar();
		

	       FindWord=WordFindField.getText();
	       
	       ReplaceWord=WordReplaceField.getText();
	       	
	       
	       try {
	       
		   if(ch=='\n')
		   {
			   if(FindWord==null || FindWord.equals(" ") || FindWord==" ")
  			   {
  				 	 Errors.setVisible(true);
  			   }
  			   
  			   if(ReplaceWord==null || ReplaceWord.equals(" ") || ReplaceWord==" ")
  			   {
  				   ReplaceWord="";
  			   }
  			   	
  			   if(FindWord!=null && ReplaceWord!=null && FindWord.equals(" ")==false && FindWord!=" ")
  			   	{	
  			      Replace();
  			   	}  
		   }
		   
	 }// try close
     
     catch(Exception e)
     {
  	   System.out.print("\n\t Error :- " + e.getMessage());
     }
		         
		
	}
	
	           
	            void Replace()
	            {
	                        	       
	            	       String Data=MainTextArea.getText();
	            	       	            	       
	            	       if(Data.contains(FindWord)==true)
	            	       {
	            	    	            Errors.setVisible(false);
	            	    	          
	            	    	           Data=Data.replace(FindWord,ReplaceWord);
	            	    	           
	            	    	           MainTextArea.setText(Data);
	            	       }
	            	       
	            	       else
	            	       {
	            	    	   	 Errors.setVisible(true);
	            	       }
	            }
	            
	
	public void keyPressed(KeyEvent e) {} public void keyReleased(KeyEvent e) {}	

	   
	
}
