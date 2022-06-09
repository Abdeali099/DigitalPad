package ViewOfFont;

import java.awt.Choice;
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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class EditsFont extends JDialog implements ActionListener,ItemListener
{

	 ImageIcon icon;
	 
	 JButton Ok,Cancel;
	 
	 JTextArea MainTextArea,NumOfLine,SampleText;
	 
	 String MyFontFamily="Arial",MyFontStyle="Regular";
	 
	 int MyFontSize=18;
	 
	 JPanel SamplePanel;
	 
// --- For MainTextArea & LineNumberArea -- //
	 
	 JPanel ForMainTextArea,MainSample;

	 JLabel MainFamilyLabel,MainStyleLabel,MainSizeLabel;
	 
	 JTextField MainFamilyField,MainStyleField,MainSizeField;
	 
	 List MainFamily,MainStyle,MainSize,Check;
	 
// --- For LineNumberArea -- //	 
	
public EditsFont(String title,JTextArea MainTextArea,JTextArea NumOfLine)
{
				
	                              setTitle(title);
	                              
	                              setLayout(null);
	                              
	                              this.MainTextArea=MainTextArea;
	                              
	                              this.NumOfLine=NumOfLine;
	                              	                              
// ***************************  Working on  MainTextArea fonts  *************************** //	  
	                              
	// ------------- Step 1 :- Adding Panel Of MainTextArea fonts -----------------//       
	                              
	                                   ForMainTextArea=new JPanel();
	                              
	                                   ForMainTextArea.setLayout(null);
	                                 
	                         ForMainTextArea.setBorder(new TitledBorder("Fonts-View"));	
	                         
	                        // Find Border width // 
	                         
	                         ForMainTextArea.setBackground(Color.white);
	                         
	                          ForMainTextArea.setBounds(0,0,530,300);

 	                                      add(ForMainTextArea);

 // ------------- Step 2 :- Adding 3 choices Of MainTextArea & NumberPanel fonts -----------------//    
 	                                      
 	                                      
 	             // ---- Step 2.1 :- Font Family  ---- //
 	                                      
 	                                     MainFamilyLabel=new JLabel("Font-Family : ");
 	                                     
 	                                      MainFamilyLabel.setBounds(20,20,150,20);
 	                                    
 	                                     ForMainTextArea.add(MainFamilyLabel);  
 	                                     
 	                                     // ----- //
 	                                    MainFamilyField=new JTextField("Arial");
	                                     
	                                      MainFamilyField.setBounds(20,41,150,20);
	                                      
	                                      MainFamilyField.setEditable(false);
	                                      
	                                      MainFamilyField.setBackground(Color.white);
	                                    
	                                     ForMainTextArea.add(MainFamilyField);  
	                                     
	                                     // ----- //
 	                                     
 	                           MainFamily=new List();
 	                           
 	                          MainFamily.setBounds(20,62,150,120);
 	                          
MainFamily.add("Arial");  MainFamily.add("Cooper");  MainFamily.add("Agency FB"); MainFamily.add("Algerian"); MainFamily.add("MT Extra"); MainFamily.add("Georgia"); MainFamily.add("Harrington"); 
 
MainFamily.add("Bahnschrift");  MainFamily.add("MS Serif");  MainFamily.add("Calibri");  MainFamily.add("System");  MainFamily.add("Castellar");  MainFamily.add("Forte"); MainFamily.add("Papyrus");
 	
MainFamily.select(0);
 	                          
 	                            ForMainTextArea.add(MainFamily);
 	                         
 	                             MainFamily.addItemListener(this);
 	                             
 	                       
 	  // ---- Step 2.2 :- Font Style ---- //
                                  
                                  MainStyleLabel=new JLabel("Font-Style : ");
                                  
                                   MainStyleLabel.setBounds(210,20,150,20);
                                 
                                  ForMainTextArea.add(MainStyleLabel);  
                                  
                                  // ----- //
                                 MainStyleField=new JTextField("Regular");
                                 
                                  MainStyleField.setBounds(210,41,150,20);
                                  
                                  MainStyleField.setEditable(false);
                                  
                                  MainStyleField.setBackground(Color.white);
                                
                                 ForMainTextArea.add(MainStyleField);  
                                 
                                 // ----- //
                                  
                        MainStyle=new List();
                        
                       MainStyle.setBounds(210,62,150,120);
                       
MainStyle.add("Regular");  MainStyle.add("Italic");  MainStyle.add("Bold"); MainStyle.add("Bold Italic"); 

MainStyle.select(0);

                       
                         ForMainTextArea.add(MainStyle);
                      
                          MainStyle.addItemListener(this);
                    
// ---- Step 2.3 :- Font Size ---- //
                          
                          MainSizeLabel=new JLabel("Font-Size : ");
                          
                           MainSizeLabel.setBounds(400,20,100,20);
                         
                          ForMainTextArea.add(MainSizeLabel);  
                          
                          // ----- //
                         MainSizeField=new JTextField("18");
                         
                          MainSizeField.setBounds(400,41,100,20);
                          
                          MainSizeField.setEditable(false);
                          
                          MainSizeField.setBackground(Color.white);
                        
                         ForMainTextArea.add(MainSizeField);  
                         
                         // ----- //
                          
                MainSize=new List();
                
               MainSize.setBounds(400,62,100,120);
               
               
               
MainSize.add("8");  MainSize.add("10");  MainSize.add("12"); MainSize.add("14");  MainSize.add("16");  MainSize.add("18");  MainSize.add("22"); MainSize.add("24");
  
MainSize.add("26");  MainSize.add("28");  MainSize.add("36");  MainSize.add("48"); MainSize.add("72");

MainSize.select(5);

                 ForMainTextArea.add(MainSize);
              
                  MainSize.addItemListener(this);

// ***************************Set Sample Panel  Frame *************************** //  
                  
                  SamplePanel=new JPanel();
                  
                  SamplePanel.setLayout(null);
                
            SamplePanel.setBorder(new TitledBorder("Sample"));	
    
                    SamplePanel.setBackground(Color.white);
        
                SamplePanel.setBounds(30,185,290,100);

                ForMainTextArea.add(SamplePanel);   
                
                // -------- //
                
                SampleText=new JTextArea();
                
                SampleText.setEditable(false);
                
                SampleText.setBounds(100,30,100,60);
                
                SampleText.setText("AaBbQqRr");
                                
                SampleText.setFont(new Font(MyFontFamily,Font.PLAIN,MyFontSize));
                
                SamplePanel.add(SampleText);
                
 // ***************************Set Button On Main Panel *************************** //  
               
                Ok=new JButton("Ok");
                
                Cancel=new JButton("Cancel");
                
                Ok.setBounds(330,210,80,20);   Cancel.setBounds(440,210,80,20);
                
                 ForMainTextArea.add(Ok);         ForMainTextArea.add(Cancel);
                 
                 Ok.addActionListener(this);      Cancel.addActionListener(this);
                	                                      
 // ***************************Set Icon for Frame *************************** //
    
										icon=new ImageIcon("src\\symbol.png");
											
										this.setIconImage(icon.getImage());	
} // Constructor close

						
						public void itemStateChanged(ItemEvent e) 
						{
							try
							{
		                 Check=(List)e.getSource(); // It Return "Object" Class So We Have to Change It.
							}
							catch(Exception ae)
							{
								System.out.print("\n\t ==> Error :- " + ae.getMessage());
							}
		                       if(Check==MainFamily)
		                       {
		                    	   MyFontFamily=Check.getSelectedItem();
		                    	   
		                    	   MainFamilyField.setText(MyFontFamily);
		                    	   
		                    	   if(MyFontStyle.equals("Regular"))
		                    	   {
		                    		   SampleText.setFont(new Font(MyFontFamily,Font.PLAIN,MyFontSize));
		                    	   }
		                    	   
		                    	   else if(MyFontStyle.equals("Italic"))
		                    	   {
		                    		   SampleText.setFont(new Font(MyFontFamily,Font.ITALIC,MyFontSize));
		                    	   }
		                       
		                    	   else if(MyFontStyle.equals("Bold"))
		                    	   {
		                    		   SampleText.setFont(new Font(MyFontFamily,Font.BOLD,MyFontSize));
		                    	   }   
		                    	   
		                    	   else
		                    	   {
		                    		   SampleText.setFont(new Font(MyFontFamily,Font.BOLD+Font.ITALIC,MyFontSize));  
		                    	   }
		                    	   
		                       } // Object If close
		                  
		              // ============ //
		                       
		                       if(Check==MainStyle)
		                       {
		                    	   
		                    	   MyFontStyle=Check.getSelectedItem();
		                    	   
		                    	   MainStyleField.setText(MyFontStyle);
		                    	   
		                    	   if(MyFontStyle.equals("Regular"))
		                    	   {
		                    		   SampleText.setFont(new Font(MyFontFamily,Font.PLAIN,MyFontSize));
		                    	   }
		                    	   
		                    	   else if(MyFontStyle.equals("Italic"))
		                    	   {
		                    		   SampleText.setFont(new Font(MyFontFamily,Font.ITALIC,MyFontSize));
		                    	   }
		                       
		                    	   else if(MyFontStyle.equals("Bold"))
		                    	   {
		                    		   SampleText.setFont(new Font(MyFontFamily,Font.BOLD,MyFontSize));
		                    	   }   
		                    	   
		                    	   else
		                    	   {
		                    		   SampleText.setFont(new Font(MyFontFamily,Font.BOLD+Font.ITALIC,MyFontSize));  
		                    	   }
		                    	   
		                    	} // Object if close
		                       
		        // =============== //
		                       
		                       if(Check==MainSize)
		                       {
		                    	   	MyFontSize=Integer.parseInt(Check.getSelectedItem());
		                    	   
		                    	      MainSizeField.setText(""+MyFontSize);
		                    	      
		                    	      if(MyFontStyle.equals("Regular"))
			                    	   {
			                    		   SampleText.setFont(new Font(MyFontFamily,Font.PLAIN,MyFontSize));
			                    	   }
			                    	   
			                    	   else if(MyFontStyle.equals("Italic"))
			                    	   {
			                    		   SampleText.setFont(new Font(MyFontFamily,Font.ITALIC,MyFontSize));
			                    	   }
			                       
			                    	   else if(MyFontStyle.equals("Bold"))
			                    	   {
			                    		   SampleText.setFont(new Font(MyFontFamily,Font.BOLD,MyFontSize));
			                    	   }   
			                    	   
			                    	   else
			                    	   {
			                    		   SampleText.setFont(new Font(MyFontFamily,Font.BOLD+Font.ITALIC,MyFontSize));  
			                    	   }
		                    	      
							                    	      
						 }//Size if close
						
						}// Method close

					
						public void actionPerformed(ActionEvent ae)
						{
							String s=ae.getActionCommand();
					
							 if(s.equalsIgnoreCase("OK"))
							 {
																 
								 if(MyFontStyle.equals("Regular"))
		                    	   {
		                    		   MainTextArea.setFont(new Font(MyFontFamily,Font.PLAIN,MyFontSize));
			                    	   
			                    	    NumOfLine.setFont(new Font(MyFontFamily,Font.PLAIN,MyFontSize));
		                    	   }
		                    	   
		                    	   else if(MyFontStyle.equals("Italic"))
		                    	   {
		                    		   MainTextArea.setFont(new Font(MyFontFamily,Font.ITALIC,MyFontSize));
			                    	   
			                    	    NumOfLine.setFont(new Font(MyFontFamily,Font.ITALIC,MyFontSize));
		                    	   }
		                       
		                    	   else if(MyFontStyle.equals("Bold"))
		                    	   {
		                    		   MainTextArea.setFont(new Font(MyFontFamily,Font.BOLD,MyFontSize));
			                    	   
			                    	    NumOfLine.setFont(new Font(MyFontFamily,Font.BOLD,MyFontSize));
		                    	   }
		                    	   
		                    	   else
		                    	   {
		                    		   MainTextArea.setFont(new Font(MyFontFamily,Font.BOLD+Font.ITALIC,MyFontSize));
			                    	   
			                    	    NumOfLine.setFont(new Font(MyFontFamily,Font.BOLD+Font.ITALIC,MyFontSize));   
		                    	   }
								 
								 this.dispose();
							 }
							 
							 else
							 {
								
								 
				        MyFontFamily="Arial"; MyFontStyle="Regular";  MyFontSize=18;
								   
						MainSizeField.setText(""+MyFontSize); MainStyleField.setText(MyFontStyle); MainFamilyField.setText(MyFontFamily);
								 
						MainTextArea.setFont(new Font(MyFontFamily,Font.PLAIN,MyFontSize));
		                    	   
		                   NumOfLine.setFont(new Font(MyFontFamily,Font.PLAIN,MyFontSize));
		                    	    
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
}
