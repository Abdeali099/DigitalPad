
import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

import FileMenu.*;
import FindFrame.FindFrame;
import ReplaceAllWord.ReplaceAllWord;
import EditMenu.*;
import MainFrame.*;

public class MyNotePadProject extends DigitalPad
{ 	
	MyNotePadProject(String s)
	{
		super(s);
	}

	public static void main(String[] args) 
	{
		DigitalPad note  = new DigitalPad("NoName-DigitalPad");
		note.setLayout(null);
		note.setVisible(true);
		note.setSize(1600,811);
		note.setLocation(0,0);
		note.setBackground(Color.white);
		
 	} // main close

} // class close
