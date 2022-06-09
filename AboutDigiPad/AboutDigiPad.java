package AboutDigiPad;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

// cheking at 12 30


public class AboutDigiPad extends JDialog
{

	JPanel MainPanel;
	
	JLabel AboutLabel;
	
	ImageIcon icon,About;
	
	         public AboutDigiPad()
	         {
	        	               setTitle("About-DigitalPad"); 
	        	               
	        	               setLayout(null);
	        	               
	        	               // ************************ Insert panel in Frame *********************** //
	        	               
	        	                                       MainPanel=new JPanel();
	        	                                       
	        	                                       MainPanel.setLayout(null);
	        	                                       
	        	                                       MainPanel.setBackground(Color.white);
	        	                                       
	        	                                       MainPanel.setBounds(10,10,830,400);
	        	                                       
	        	                                       add(MainPanel);
		                       // ************************ Insert Label in Panel For Photo *********************** //
		                       
	        	                                       About=new ImageIcon("src\\AboutCopy.jpg");
	        	                                       
	        	                                       AboutLabel=new JLabel(About);
		                       
	        	                                       AboutLabel.setBounds(20,20,814,380);
		
	        	                                       MainPanel.add(AboutLabel);
	        	                       
	        	      	        	               
	        	           
	        	               // ***************************Set Icon for Frame *************************** //
	        	               
								icon=new ImageIcon("src\\symbol.png");
									
								this.setIconImage(icon.getImage());	
								
								
	        	 
	         } // constructor close


}
