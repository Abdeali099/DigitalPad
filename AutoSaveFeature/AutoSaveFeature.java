package AutoSaveFeature;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class AutoSaveFeature extends JDialog
{
	ImageIcon  icon;
	
	JPanel Main;
	
	JLabel Ask,Note1,Note2;
	
	public JRadioButton Enable;

	public JRadioButton Disable;
	
	public ButtonGroup Bg;
	
	public AutoSaveFeature(String title,JTextArea MainTextArea,JTextArea NumberPanel)
	{
		
		                     setLayout(null);
		                     
		                     setTitle(title);
		
		       // ------------------- Set Panel on Frame --------------//
		                     
		                     Main=new JPanel();
		                     
		                     Main.setBorder(new TitledBorder("Status"));
		                     
		                     Main.setBounds(5,5,340,220);
		                     
		                     Main.setBackground(Color.white);
		                     
		                     Main.setLayout(null);
		                     
		                     add(Main);
		
		      // ------------------- Set Label on Panel --------------//
		
		
		                      Ask=new JLabel("Select Auto-Save Status :- ");
		                      
		                      Ask.setBounds(20,20,270,40);
		
		                      Ask.setFont(new Font("Arial",Font.BOLD,20));
		                      
		                      Main.add(Ask);
		                      
		  // ------------------- Set RadioButton on Panel --------------//
		              		     
		                      Enable=new JRadioButton("Enable");
		                      Disable=new JRadioButton("Disable",true);
		                      
		           Enable.setBounds(20,80,120,40);   Disable.setBounds(140,80,120,40);
		           
		           Enable.setBackground(Color.white);         Disable.setBackground(Color.white);
		           
		           Enable.setFont(new Font("Arial",Font.BOLD,20)); Disable.setFont(new Font("Arial",Font.BOLD,20));
		           
		                    Main.add(Enable);              Main.add(Disable);
		                    
		                               Bg=new ButtonGroup(); // --> All 2 are In one Group
                                   Bg.add(Enable);   Bg.add(Disable);  
                                   
                
              // ------------------- Set Note on Panel --------------//
                         		                 
                                   Note1=new JLabel("* AutoSave will Save File After Every 10 second.");
     		                      
     		                      Note1.setBounds(7,130,280,40);
     		
     		                      Note1.setFont(new Font("Arial",Font.BOLD,12));
     		                      
     		                      Note1.setForeground(Color.red);
     		                      
     		                      Main.add(Note1);
		                      
              // ------------------- Set Note on Panel --------------//
                 
                  Note2=new JLabel("* After \"New & New Window\" Save File Once");
                  
                  Note2.setBounds(7,180,280,40);

                  Note2.setFont(new Font("Arial",Font.BOLD,12));
                  
                  Note2.setForeground(Color.red);
                  
                  Main.add(Note2);
		                      
		
     		                      
     		                      
		// ***************************Set Icon for Frame *************************** //
	    
				icon=new ImageIcon("src\\symbol.png");
					
				this.setIconImage(icon.getImage()); // we Need "Image" Not "icon" so we use Methods in parameter	

		
		
	}

}
