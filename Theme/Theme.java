package Theme;

import java.awt.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Theme extends JDialog implements ActionListener,ItemListener
{
	
	ImageIcon icon;
	
	JTextArea NumOfLine,MainTextArea;
	
	
	// -------------- Main 2 panel ----------//
	
	JPanel ParentPanel,ForMainTextArea,ForLineNumber;
	
    // ------------------- Main 2 Button --------//
	
	JButton Ok,Cancel;
	
	//------------------ For Main Text Area --------//
	
	JLabel MainFgLabel,MainBgLabel,MainCaretLabel;
	JTextField MainFgField,MainBgField,MainCaretField;
	List MainFgList,MainBgList,MainCaretList,Check;
	String MainFgStr="black",MainBgStr="white",MainCaretStr="black";
	
	//------------------ For Line Number Area  --------//
	
		JLabel NumberFgLabel,NumberBgLabel;
		JTextField NumberFgField,NumberBgField;
		List NumberFgList,NumberBgList;
		String NumberFgStr="red",NumberBgStr="white";
	
	public Theme(String title,JTextArea MainTextArea,JTextArea NumOfLine)
	{
		
		                              setTitle(title);
		                              
		                              setLayout(null);
		
		                              this.MainTextArea=MainTextArea;
		                              
		                              this.NumOfLine=NumOfLine;
		                              
		                              ParentPanel=new JPanel();
		                              
		                              ParentPanel.setLayout(null);
		                              
		                              ParentPanel.setBounds(0,0,530,500);
		                              
		                              ParentPanel.setBackground(Color.white);
		                              
		                              
				                              add(ParentPanel);
		                              
		                              	                                  
	// ***************************  Working on  MainTextAreas Theme *************************** //	  
		                              
		// ------------- Step 1 :- Adding Panel Of MainTextArea In Theme -----------------//       
		                              
		                                   ForMainTextArea=new JPanel();
		                              
		                                   ForMainTextArea.setLayout(null);
		                                 
		                         ForMainTextArea.setBorder(new TitledBorder("TextArea-View"));	
		                         
		                        // Find Border width // 
		                         
		                         ForMainTextArea.setBackground(Color.white);
		                         
		                          ForMainTextArea.setBounds(0,0,530,200);

		                          ParentPanel.add(ForMainTextArea);

	 // ------------- Step 2 :- Adding 3 Lists Of MainTextArea -----------------//    
	 	                                      
	 	                                      
	 	             // ---- Step 2.1 :- ForeGround  ---- //
	 	                                      
	 	                                     MainFgLabel=new JLabel("Fore-Ground : ");
	 	                                     
	 	                                      MainFgLabel.setBounds(20,20,150,20);
	 	                                    
	 	                                     ForMainTextArea.add(MainFgLabel);  
	 	                                     
	 	                                     // ----- //
	 	                                    MainFgField=new JTextField("black");
		                                     
		                                      MainFgField.setBounds(20,41,150,20);
		                                      
		                                      MainFgField.setEditable(false);
		                                      
		                                      MainFgField.setBackground(Color.white);
		                                    
		                                     ForMainTextArea.add(MainFgField);  
		                                     
		                                     // ----- //
	 	                                     
	 	                           MainFgList=new List();
	 	                           
	 	                       //    .setForeground(Color.decode(title));
	 	                           
	 	                          MainFgList.setBounds(20,62,150,120);
	 	                          
       MainFgList.add("black"); MainFgList.add("white");   MainFgList.add("blue"); MainFgList.add("cyan"); MainFgList.add("red"); MainFgList.add("orange"); MainFgList.add("Gray"); 
       MainFgList.add("yellow"); MainFgList.add("lightGray");  MainFgList.add("darkGray");  MainFgList.add("magenta");  MainFgList.add("green");  MainFgList.add("pink"); 
	 	
	MainFgList.select(0);   
	 	                          
	 	                            ForMainTextArea.add(MainFgList);
	 	                         
	 	                             MainFgList.addItemListener(this);
	 	                             
	 	                       
	 	  // ---- Step 2.2 :- BackGround  ---- // 
	                                  
	                                  MainBgLabel=new JLabel("Back-Ground :- ");
	                                  
	                                  MainBgLabel.setBounds(210,20,150,20);
	                                 
	                                  ForMainTextArea.add(MainBgLabel);  
	                                  
	                                  // ----- //
	                                 MainBgField=new JTextField("white");
	                                 
	                                  MainBgField.setBounds(210,41,150,20);
	                                  
	                                  MainBgField.setEditable(false);
	                                  
	                                  MainBgField.setBackground(Color.white);
	                                
	                                 ForMainTextArea.add(MainBgField);  
	                                 
	                                 // ----- //
	                                  
	                       MainBgList=new List();
	                        
	                      MainBgList.setBounds(210,62,150,120);
	                       
MainBgList.add("white"); MainBgList.add("black");  MainBgList.add("blue"); MainBgList.add("cyan"); MainBgList.add("red"); MainBgList.add("orange"); MainBgList.add("Gray");

MainBgList.add("yellow"); MainBgList.add("lightGray");  MainBgList.add("darkGray");  MainBgList.add("magenta");  MainBgList.add("green");  MainBgList.add("pink");  
	                      	         	 
	                      
	MainBgList.select(0);

	                       
	                         ForMainTextArea.add(MainBgList);
	                      
	                         MainBgList.addItemListener(this);
	                    
	// ---- Step 2.3 :- caret Color ---- //
	                          
	                          MainCaretLabel=new JLabel("Caret-color : ");
	                          
	                           MainCaretLabel.setBounds(400,20,100,20);
	                         
	                          ForMainTextArea.add(MainCaretLabel);  
	                          
	                          // ----- //
	                         MainCaretField=new JTextField("black");
	                         
	                          MainCaretField.setBounds(400,41,100,20);
	                          
	                          MainCaretField.setEditable(false);
	                          
	                          MainCaretField.setBackground(Color.white);
	                        
	                         ForMainTextArea.add(MainCaretField);  
	                         
	                         // ----- //
	                          
	                MainCaretList=new List();
	                
	               MainCaretList.setBounds(400,62,100,120);
	               
	               
	               

	                 ForMainTextArea.add(MainCaretList);
	
  MainCaretList.add("black");  MainCaretList.add("white");     MainCaretList.add("blue");     MainCaretList.add("cyan");   MainCaretList.add("red"); MainCaretList.add("orange");  MainCaretList.add("Gray");
	 
  MainCaretList.add("lightGray");  MainCaretList.add("darkGray");  MainCaretList.add("magenta");  MainCaretList.add("green");  MainCaretList.add("pink"); MainCaretList.add("yellow"); 
 	
	             	  MainCaretList.select(0);

	              
	                  MainCaretList.addItemListener(this);
	                  
	                  // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ //
	                  
// ***************************  Working on  NumberPanel  Theme *************************** //	  
                      
	          		// ------------- Step 1 :- Adding Panel Of Number  In Theme -----------------//       
	          		                              
	          		                                   ForLineNumber=new JPanel();
	          		                              
	          		                                   ForLineNumber.setLayout(null);
	          		                                 
	          		                         ForLineNumber.setBorder(new TitledBorder("LineNumber-View"));	
	          		                         
	          		                        // Find Border width // 
	          		                         
	          		                         ForLineNumber.setBackground(Color.white);
	          		                         
	          		                          ForLineNumber.setBounds(0,210,530,200);

	          		                        ParentPanel.add(ForLineNumber);

	          	 // ------------- Step 2 :- Adding 2 Lists Of MainTextArea -----------------//    
	          	 	                                      
	          	 	                                      
	          	 	             // ---- Step 2.1 :- ForeGround  ---- //
	          	 	                                      
	          	 	                                     NumberFgLabel=new JLabel("Fore-Ground : ");
	          	 	                                     
	          	 	                                      NumberFgLabel.setBounds(90,20,150,20);
	          	 	                                    
	          	 	                                     ForLineNumber.add(NumberFgLabel);  
	          	 	                                     
	          	 	                                     // ----- //
	          	 	                                    NumberFgField=new JTextField("red");
	          		                                     
	          		                                      NumberFgField.setBounds(90,41,150,20);
	          		                                      
	          		                                      NumberFgField.setEditable(false);
	          		                                      
	          		                                      NumberFgField.setBackground(Color.white);
	          		                                    
	          		                                     ForLineNumber.add(NumberFgField);  
	          		                                     
	          		                                     // ----- //
	          	 	                                     
	          	 	                           NumberFgList=new List();
	          	 	                           
	          	 	                                	 	                           
	          	 	                          NumberFgList.setBounds(90,62,150,120);
	          	 	                          
	                 NumberFgList.add("black"); NumberFgList.add("white");   NumberFgList.add("blue"); NumberFgList.add("cyan"); NumberFgList.add("red"); NumberFgList.add("orange"); NumberFgList.add("Gray"); 
	                 NumberFgList.add("yellow"); NumberFgList.add("lightGray");  NumberFgList.add("darkGray");  NumberFgList.add("magenta");  NumberFgList.add("green");  NumberFgList.add("pink"); 
	          	 	
	              	NumberFgList.select(4);   
	          	 	                          
	          	                                  ForLineNumber.add(NumberFgList);
	          	 	                         
	          	 	                             NumberFgList.addItemListener(this);
	          	 	                             
	          	 	                       
	          	 	  // ---- Step 2.2 :- BackGround  ---- // 
	          	                                  
	          	                                  NumberBgLabel=new JLabel("Back-Ground :- ");
	          	                                  
	          	                                  NumberBgLabel.setBounds(310,20,150,20);
	          	                                 
	          	                                ForLineNumber.add(NumberBgLabel);  
	          	                                  
	          	                                  // ----- //
	          	                                 NumberBgField=new JTextField("white");
	          	                                 
	          	                                  NumberBgField.setBounds(310,41,150,20);
	          	                                  
	          	                                  NumberBgField.setEditable(false);
	          	                                  
	          	                                  NumberBgField.setBackground(Color.white);
	          	                                
	          	                                 ForLineNumber.add(NumberBgField);  
	          	                                 
	          	                                 // ----- //
	          	                                  
	          	                       NumberBgList=new List();
	          	                        
	          	                      NumberBgList.setBounds(310,62,150,120);
	          	                       
	          NumberBgList.add("white"); NumberBgList.add("black");  NumberBgList.add("blue"); NumberBgList.add("cyan"); NumberBgList.add("red"); NumberBgList.add("orange"); NumberBgList.add("Gray");

	          NumberBgList.add("yellow"); NumberBgList.add("lightGray");  NumberBgList.add("darkGray");  NumberBgList.add("magenta");  NumberBgList.add("green");  NumberBgList.add("pink");  
	          	                      	         	 
	          	                      
	          	NumberBgList.select(0);

	          	                       
	          	                               ForLineNumber.add(NumberBgList);
	          	                      
	          	                         NumberBgList.addItemListener(this);
	          	                         
	          	                         
// ---------------------------------------- Set Buttons On parent Pannel ---------------------------------------//
	          	                         
	          	                       Ok=new JButton("Ok");
	          	                     
	          	                     Cancel=new JButton("Cancel");
	          	                     
	          	                     Ok.setBounds(200,420,80,20);   Cancel.setBounds(300,420,80,20);
	          	                     
	          	                   ParentPanel.add(Ok);         ParentPanel.add(Cancel);
	          	                      
	          	                      Ok.addActionListener(this);      Cancel.addActionListener(this);
	          	                          
	          	                         // orLineNumber.setBounds(0,210,530,200);
	          	                         
	          	                         
	          	                         
		// ***************************Set Icon for Frame *************************** //
	    
		icon=new ImageIcon("src\\symbol.png");
			
		this.setIconImage(icon.getImage()); // we Need "Image" Not "icon" so we use Methods in parameter	

	} // Constructor close		
	
	
	
	
	public void actionPerformed(ActionEvent ae) 
	{
		
		                 String S=ae.getActionCommand();
		                 
		                 if(S.equals("Ok"))
		                 {
		                	 this.dispose();
		                 }
		                 
		                 else
		                 {
		                	  NumberFgStr="red"; NumberBgStr="white";
		                	 
		                	 MainFgStr="black"; MainBgStr="white"; MainCaretStr="black";
		                	 
		                	 MainFgField.setText(MainFgStr); MainBgField.setText(MainBgStr); MainCaretField.setText(MainCaretStr);
		                	                 	 
		                	 NumberFgField.setText(MainFgStr); NumberBgField.setText(MainBgStr);
		                	 
		                	 
		                	 NumOfLine.setBackground(Color.white); 
		                	 
		                	 NumOfLine.setForeground(Color.red);
		                	 
		                	 MainTextArea.setForeground(Color.black);
		                	 
		                	 MainTextArea.setBackground(Color.white);
		                	 
		                	 MainTextArea.setCaretColor(Color.black);
		                	 
		                	 
		                	 
		                	 try 
            	             {
								Thread.sleep(100);
							  } 
            	             catch (InterruptedException e) 
            	             {
							        System.out.print("\n\t ==> Error :- " + e.getMessage());
							 }
            	             
            	            this.dispose();				
		                	 
		                 }
		
	}

	
	public void itemStateChanged(ItemEvent ie)
	{
		try
		{
     Check=(List)ie.getSource(); // It Return "Object" Class So We Have to Change It.
		}
		catch(Exception ae)
		{
			System.out.print("\n\t ==> Error :- " + ae.getMessage());
		} 
        if(Check==MainFgList)
        {
        	MainFgStr=Check.getSelectedItem();
     	   
        	MainFgField.setText(MainFgStr);
        	
        	if(MainFgStr.equalsIgnoreCase("white"))
            {
         	   
        		MainTextArea.setForeground(Color.white); 
            } // 1
            
            else if(MainFgStr.equalsIgnoreCase("black"))
            {
            	MainTextArea.setForeground(Color.black);
            }// 2
        	
            else if(MainFgStr.equalsIgnoreCase("blue"))
            {
            	MainTextArea.setForeground(Color.blue);
            }// 3
        	
            else if(MainFgStr.equalsIgnoreCase("cyan"))
            {
            	MainTextArea.setForeground(Color.cyan);
            }// 4
        	
            else if(MainFgStr.equalsIgnoreCase("red"))
            {
            	MainTextArea.setForeground(Color.red);
            }// 5
        	
            else if(MainFgStr.equalsIgnoreCase("orange"))
            {
            	MainTextArea.setForeground(Color.orange);
           }// 6
        	
            else if(MainFgStr.equalsIgnoreCase("lightGray"))
            {
            	MainTextArea.setForeground(Color.lightGray);
           }// 7
        	
            else if(MainFgStr.equalsIgnoreCase("darkGray"))
            {
            	MainTextArea.setForeground(Color.DARK_GRAY);
           }// 8
        	
        	
            else if(MainFgStr.equalsIgnoreCase("magenta"))
            {
            	MainTextArea.setForeground(Color.magenta);
            }// 9
        	
            else if(MainFgStr.equalsIgnoreCase("green"))
            {
            	MainTextArea.setForeground(Color.green);         	
            }// 10
        	
            else if(MainFgStr.equalsIgnoreCase("pink"))
            {
            	MainTextArea.setForeground(Color.pink);
           }// 11
        	
            else if(MainFgStr.equalsIgnoreCase("gray"))
            {
            	MainTextArea.setForeground(Color.gray);
            }// 12
        	
            else 
            {
            	MainTextArea.setForeground(Color.yellow);
            }// 13
        	
     	   
     	   
        } // Object If close
        
                             
   
// ============ //
        
        if(Check==MainBgList)
        {
     	   
        	MainBgStr=Check.getSelectedItem();
     	   
     	      MainBgField.setText(MainBgStr);
     	   
     	     if(MainBgStr.equalsIgnoreCase("white"))
             {
          	   
         		MainTextArea.setBackground(Color.white); 
             } // 1
             
             else if(MainBgStr.equalsIgnoreCase("black"))
             {
             	MainTextArea.setBackground(Color.black);
             }// 2
         	
             else if(MainBgStr.equalsIgnoreCase("blue"))
             {
             	MainTextArea.setBackground(Color.blue);
             }// 3
         	
             else if(MainBgStr.equalsIgnoreCase("cyan"))
             {
             	MainTextArea.setBackground(Color.cyan);
             }// 4
         	
             else if(MainBgStr.equalsIgnoreCase("red"))
             {
             	MainTextArea.setBackground(Color.red);
             }// 5
         	
             else if(MainBgStr.equalsIgnoreCase("orange"))
             {
             	MainTextArea.setBackground(Color.orange);
            }// 6
         	
             else if(MainBgStr.equalsIgnoreCase("lightGray"))
             {
             	MainTextArea.setBackground(Color.lightGray);
            }// 7
         	
             else if(MainBgStr.equalsIgnoreCase("darkGray"))
             {
             	MainTextArea.setBackground(Color.DARK_GRAY);
            }// 8
         	
         	
             else if(MainBgStr.equalsIgnoreCase("magenta"))
             {
             	MainTextArea.setBackground(Color.magenta);
             }// 9
         	
             else if(MainBgStr.equalsIgnoreCase("green"))
             {
             	MainTextArea.setBackground(Color.green);         	
             }// 10
         	
             else if(MainBgStr.equalsIgnoreCase("pink"))
             {
             	MainTextArea.setBackground(Color.pink);
            }// 11
         	
             else if(MainBgStr.equalsIgnoreCase("gray"))
             {
             	MainTextArea.setBackground(Color.gray);
             }// 12
         	
             else 
             {
             	MainTextArea.setBackground(Color.yellow);
             }// 13
         	
     	  
     	} // Object if close
        
// =============== //
        
        if(Check==MainCaretList)
        {
     	   	
        	MainCaretStr=Check.getSelectedItem();
      	   
      	   MainCaretField.setText(MainCaretStr);
      	   
      	 if(MainCaretStr.equalsIgnoreCase("white"))
         {
      	   
     		MainTextArea.setCaretColor(Color.white); 
         } // 1
         
         else if(MainCaretStr.equalsIgnoreCase("black"))
         {
         	MainTextArea.setCaretColor(Color.black);
         }// 2
     	
         else if(MainCaretStr.equalsIgnoreCase("blue"))
         {
         	MainTextArea.setCaretColor(Color.blue);
         }// 3
     	
         else if(MainCaretStr.equalsIgnoreCase("cyan"))
         {
         	MainTextArea.setCaretColor(Color.cyan);
         }// 4
     	
         else if(MainCaretStr.equalsIgnoreCase("red"))
         {
         	MainTextArea.setCaretColor(Color.red);
         }// 5
     	
         else if(MainCaretStr.equalsIgnoreCase("orange"))
         {
         	MainTextArea.setCaretColor(Color.orange);
        }// 6
     	
         else if(MainCaretStr.equalsIgnoreCase("lightGray"))
         {
         	MainTextArea.setCaretColor(Color.lightGray);
        }// 7
     	
         else if(MainCaretStr.equalsIgnoreCase("darkGray"))
         {
         	MainTextArea.setCaretColor(Color.DARK_GRAY);
        }// 8
     	
     	
         else if(MainCaretStr.equalsIgnoreCase("magenta"))
         {
         	MainTextArea.setCaretColor(Color.magenta);
         }// 9
     	
         else if(MainCaretStr.equalsIgnoreCase("green"))
         {
         	MainTextArea.setCaretColor(Color.green);         	
         }// 10
     	
         else if(MainCaretStr.equalsIgnoreCase("pink"))
         {
         	MainTextArea.setCaretColor(Color.pink);
        }// 11
     	
         else if(MainCaretStr.equalsIgnoreCase("gray"))
         {
         	MainTextArea.setCaretColor(Color.gray);
         }// 12
     	
         else 
         {
         	MainTextArea.setCaretColor(Color.yellow);
         }// 13
     	
     	      
		                    	      
	       }//object if close
        
        
 // ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; Number Panel ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;//
        
        
        if(Check==NumberFgList)
        {
        	NumberFgStr=Check.getSelectedItem();
     	   
        	NumberFgField.setText(NumberFgStr);
        	
        	if(NumberFgStr.equalsIgnoreCase("white"))
            {
         	   
        		NumOfLine.setForeground(Color.white); 
            } // 1
            
            else if(NumberFgStr.equalsIgnoreCase("black"))
            {
            	NumOfLine.setForeground(Color.black);
            }// 2
        	
            else if(NumberFgStr.equalsIgnoreCase("blue"))
            {
            	NumOfLine.setForeground(Color.blue);
            }// 3
        	
            else if(NumberFgStr.equalsIgnoreCase("cyan"))
            {
            	NumOfLine.setForeground(Color.cyan);
            }// 4
        	
            else if(NumberFgStr.equalsIgnoreCase("red"))
            {
            	NumOfLine.setForeground(Color.red);
            }// 5
        	
            else if(NumberFgStr.equalsIgnoreCase("orange"))
            {
            	NumOfLine.setForeground(Color.orange);
           }// 6
        	
            else if(NumberFgStr.equalsIgnoreCase("lightGray"))
            {
            	NumOfLine.setForeground(Color.lightGray);
           }// 7
        	
            else if(NumberFgStr.equalsIgnoreCase("darkGray"))
            {
            	NumOfLine.setForeground(Color.DARK_GRAY);
           }// 8
        	
        	
            else if(NumberFgStr.equalsIgnoreCase("magenta"))
            {
            	NumOfLine.setForeground(Color.magenta);
            }// 9
        	
            else if(NumberFgStr.equalsIgnoreCase("green"))
            {
            	NumOfLine.setForeground(Color.green);         	
            }// 10
        	
            else if(NumberFgStr.equalsIgnoreCase("pink"))
            {
            	NumOfLine.setForeground(Color.pink);
           }// 11
        	
            else if(NumberFgStr.equalsIgnoreCase("gray"))
            {
            	NumOfLine.setForeground(Color.gray);
            }// 12
        	
            else 
            {
            	NumOfLine.setForeground(Color.yellow);
            }// 13
        	
     	   
     	   
        } // Object If close
        
                             
   
// ============ //
        
        if(Check==NumberBgList)
        {
     	   
        	NumberBgStr=Check.getSelectedItem();
     	   
     	      NumberBgField.setText(NumberBgStr);
     	   
     	     if(NumberBgStr.equalsIgnoreCase("white"))
             {
          	   
         		NumOfLine.setBackground(Color.white); 
             } // 1
             
             else if(NumberBgStr.equalsIgnoreCase("black"))
             {
             	NumOfLine.setBackground(Color.black);
             }// 2
         	
             else if(NumberBgStr.equalsIgnoreCase("blue"))
             {
             	NumOfLine.setBackground(Color.blue);
             }// 3
         	
             else if(NumberBgStr.equalsIgnoreCase("cyan"))
             {
             	NumOfLine.setBackground(Color.cyan);
             }// 4
         	
             else if(MainBgStr.equalsIgnoreCase("red"))
             {
             	NumOfLine.setBackground(Color.red);
             }// 5
         	
             else if(NumberBgStr.equalsIgnoreCase("orange"))
             {
             	NumOfLine.setBackground(Color.orange);
            }// 6
         	
             else if(NumberBgStr.equalsIgnoreCase("lightGray"))
             {
             	NumOfLine.setBackground(Color.lightGray);
            }// 7
         	
             else if(NumberBgStr.equalsIgnoreCase("darkGray"))
             {
             	NumOfLine.setBackground(Color.DARK_GRAY);
            }// 8
         	
         	
             else if(NumberBgStr.equalsIgnoreCase("magenta"))
             {
             	NumOfLine.setBackground(Color.magenta);
             }// 9
         	
             else if(NumberBgStr.equalsIgnoreCase("green"))
             {
             	NumOfLine.setBackground(Color.green);         	
             }// 10
         	
             else if(NumberBgStr.equalsIgnoreCase("pink"))
             {
             	NumOfLine.setBackground(Color.pink);
            }// 11
         	
             else if(NumberBgStr.equalsIgnoreCase("gray"))
             {
             	NumOfLine.setBackground(Color.gray);
             }// 12
         	
             else 
             {
             	NumOfLine.setBackground(Color.yellow);
             }// 13
         	
     	  
     	} // Object if close
        
		
		
	} // method close

} // class close
