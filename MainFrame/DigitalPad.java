package MainFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
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
import java.net.URI;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
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

import AboutDigiPad.AboutDigiPad;
import AdvanceMenu.AdvanceFeatureMenu;
import AutoSaveFeature.AutoSaveFeature;
import FileMenu.*;
import FindFrame.FindFrame;
import HelpMenu.HelpMenu;
import ReplaceAllWord.ReplaceAllWord;
import Theme.Theme;
import ViewMenu.ViewMenu;
import ViewOfFont.EditsFont;
import EditMenu.*;

// ------------------------------------------------------------------------------------------------------------------------ 

public class DigitalPad extends JFrame implements ActionListener, KeyListener, Runnable {

    // Step 1 :- Declare All Component//

    public Container cont; // It Have Address Of Main Frame

    public JTextArea MainTextArea, NumOfLine; // MainTextArea->text will written , NumOfLine->Number of Line will
                                              // written here

    public JScrollPane MainScrollPane; // It will Hold Text area. ,MainFrameSP

    public JPanel ForTextArea; // It will Hold Text area.

    public JMenuBar bar; // --> MenuBar area-> It Holds All Menu.

    // ------ //

    FileMenu file; // -> JMEnu class Object Refrence is File
    EditMenu Edit; // -> JMEnu class Object Refrence is Edit
    ViewMenu View; // -> JMEnu class Object Refrence is View
    HelpMenu HelpS;
    AdvanceFeatureMenu Advance; // -> JMEnu class Object Refrence is Advance

    // ------- //

    FindFrame FindWord;

    // ------------ //

    ReplaceAllWord RAW;

    // View MenuItems Class ---//

    EditsFont editFonts;

    Theme editTheme;

    // ----- AutoSave Feature ---//

    AutoSaveFeature AutoSave;

    Thread th;

    public boolean AutoSaveStatus = false;

    public boolean AutoSaveStatusOnFrame = false;

    // ---- About Digipad---- //

    AboutDigiPad AboutPad;

    // ---------//

    ImageIcon icon;

    // ----------//

    JDialog ForFonts, ForMainBG, ForNumberBG, ForSize;

    // --------- //
    int Flag = 0, FlagEx = 0;
    String FoldTemp = "", fnaTemp = ""; // --> It Is for Saving File Only Once After it save Automatic at Same Location
                                        // ..

    // ------ //

    String fold; // :- Folder Of That File Will Be Open
    String fna; // :- FIle Name Which will Open (it Declare here for Modify Title Easily )

    // --------- //

    int n = 0, i = 1; // Lines of file

    String data = ""; // It Has a Data WHich the file is open/Save

    String LiNO = ""; // It Has a Lines WHich the file is open/Save

    // -----------//

    int NoFlag = 0; // :- Addjusting Line Number when It Is A Text

    int NoFlagOpen = 0; // :- Addjusting Line Number when It Is A Open

    // ----------- //

    String foldS; // :- Save -> Directory PAth
    String fnaS; // :- Save -> File Choosen

    // ------------ //

    String CopyText, CopyTextTemp;

    // --------- //

    int PASTEFLAG = 0;

    public DigitalPad(String s) {

        // Step 2 :- Common Step //

        super(s);
        fnaTemp = s;
        cont = getContentPane();
        cont.setLayout(null); // --> If I choose this Then I set Bounds...

        // ---------------------------------------//

        th = new Thread(this);

        // ---------------------------------------//

        // Step 3 :- Add Panel On JFrame Which Contains MainTextArea and NumberArea //

        ForTextArea = new JPanel(); // It Is pannel

        ForTextArea.setBounds(0, 0, 1600, 811);

        ForTextArea.setLayout(null);

        cont.add(ForTextArea); // Add Panel In Frame

        // Step 4 : making Text Area For Line Number //

        NumOfLine = new JTextArea(); // :- It is a textarea

        NumOfLine.setVisible(true);

        NumOfLine.setBackground(Color.white);

        NumOfLine.setForeground(Color.red);

        NumOfLine.setText("  1 ");

        NumOfLine.setFont(new Font("Consolas", Font.PLAIN + Font.CENTER_BASELINE, 18));

        NumOfLine.setEditable(false); // -> Can't Edit

        // Step 5 :- Making Text Area For Main Text and also makin Scroll Pane //

        MainTextArea = new JTextArea();

        MainTextArea.setFont(new Font("Consolas", Font.PLAIN, 18));

        MainScrollPane = new JScrollPane(MainTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        MainTextArea.addKeyListener(this);

        /*
         * MainTextArea.setLineWrap(true); // :- Yt :- use For Line Automatialny goes
         * new line
         * 
         * MainTextArea.setWrapStyleWord(true); //:- Yt
         */

        // MainScrollPane.setViewportView(NumOfLine);

        MainScrollPane.setRowHeaderView(NumOfLine); // ---> It Is Very Important (This Code is Showing Number Of Lines)

        MainScrollPane.setBounds(0, 0, 1600, 811);

        MainScrollPane.setBorder(BorderFactory.createEmptyBorder()); // :- Seen From Yt [ Remove Border]

        ForTextArea.add(MainScrollPane); // Add ScrollPane In Panel

        // ------------------------------------- Extra :- Find MenuItem
        // ------------------------------------- //

        FindWord = new FindFrame(cont, "Find Word", MainTextArea);
        FindWord.setVisible(false);

        // ------------------------------------- Extra :- Replace_All MenuItem
        // ------------------------------------- //

        RAW = new ReplaceAllWord(cont, "Replace All Word", MainTextArea);
        RAW.setVisible(false);

        // -------------------------------------------- Set Icon for Frame
        // -----------------------------//

        icon = new ImageIcon("src\\symbol.png");

        this.setIconImage(icon.getImage());

        this.setResizable(true);

        // -------------------------------------------- View Menu Items : Font
        // -----------------------------//

        editFonts = new EditsFont("Fonts", MainTextArea, NumOfLine);
        editFonts.setVisible(false);

        // -------------------------------------------- View Menu Items : Theme
        // -----------------------------//

        editTheme = new Theme("Theme", MainTextArea, NumOfLine);
        editTheme.setVisible(false);

        // -------------------------------------------- Advance Menu Items : AutoSave
        // -----------------------------//

        AutoSave = new AutoSaveFeature("Auto-Save", MainTextArea, NumOfLine);

        AutoSave.setVisible(false);

        AutoSave.Enable.addActionListener(this);

        AutoSave.Disable.addActionListener(this);

        // -------------------------------------------- Help Menu Items : About
        // -----------------------------//

        AboutPad = new AboutDigiPad();

        AboutPad.setVisible(false);

        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

        // MainFrameSP.add(ForTextArea);

        // cont.add(MainFrameSP);

        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

        // Step 6 :- Adding MenuBar On Frame //

        bar = new JMenuBar();

        setJMenuBar(bar); // --> It Is Not In Container So we can't do "cont.add(bar);"

        bar.setBackground(Color.white);

        // Step 6.1 :- Declare All Menues //

        file = new FileMenu("File"); // :- File Menu...
        Edit = new EditMenu("Edit"); // :- Edit Menu
        View = new ViewMenu("View"); // :- ViewMenu
        Advance = new AdvanceFeatureMenu("Advance"); // :- Advance Menu
        HelpS = new HelpMenu("Help");

        // Step 6.2 :- Add Menues In MenuBar //

        bar.add(file);
        bar.add(Edit);
        bar.add(View);
        bar.add(Advance);
        bar.add(HelpS); // -> This Are Menuse

        // Step 6.3.1 -> Making Shortcuts For File Menu's Items //

        file.ne.setMnemonic(KeyEvent.VK_N); // --> Is : (alt + x ) , Work if :- Menu is Open
        file.ne.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK, true)); // --> Is : (ctrl + x
                                                                                                   // ) , Work if :-all
                                                                                                   // condition

        file.NewWind.setMnemonic(KeyEvent.VK_N); // --> Is : (alt + x ) , Work if :- Menu is Open
        file.NewWind.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK + InputEvent.SHIFT_MASK, true)); // --> Is :
                                                                                                            // (ctrl+
                                                                                                            // shift + x
                                                                                                            // ) , Work
                                                                                                            // if :-all
                                                                                                            // condition

        file.op.setMnemonic(KeyEvent.VK_O); // --> Is : (alt + x ) , Work if :- Menu is Open
        file.op.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK, true)); // --> Is : (ctrl + x
                                                                                                   // ) , Work if :-all
                                                                                                   // condition

        file.sa.setMnemonic(KeyEvent.VK_S); // --> Is : (alt + x ) , Work if :- Menu is Open
        file.sa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK, true)); // --> Is : (ctrl + x
                                                                                                   // ) , Work if :-all
                                                                                                   // condition

        file.sas.setMnemonic(KeyEvent.VK_S); // --> Is : (alt + x ) , Work if :- Menu is Open
        file.sas.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK + InputEvent.SHIFT_MASK, true)); // --> Is :
                                                                                                            // (ctrl +
                                                                                                            // shift + x
                                                                                                            // ) , Work
                                                                                                            // if :-all
                                                                                                            // condition

        file.prn.setMnemonic(KeyEvent.VK_P); // --> Is : (alt + x ) , Work if :- Menu is Open
        file.prn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK, true)); // --> Is : (ctrl +
                                                                                                    // x ) , Work if
                                                                                                    // :-all condition

        file.ex.setMnemonic(KeyEvent.VK_E); // --> Is : (alt + x ) , Work if :- Menu is Open
        file.ex.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK + InputEvent.SHIFT_MASK, true)); // --> Is :
                                                                                                            // (ctrl+
                                                                                                            // shift + x
                                                                                                            // ) , Work
                                                                                                            // if :-all
                                                                                                            // condition

        // Step 6.3.2 -> Making Shortcuts For Edit Menu's Items //

        Edit.Copy.setMnemonic(KeyEvent.VK_C); // --> Is : (alt + x ) , Work if :- Menu is Open
        Edit.Copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK, true)); // --> Is : (ctrl +
                                                                                                     // x ) , Work if
                                                                                                     // :-all condition

        Edit.Paste.setMnemonic(KeyEvent.VK_P); // --> Is : (alt + x ) , Work if :- Menu is Open
        Edit.Paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK, true)); // --> Is : (ctrl+
                                                                                                      // shift + x ) ,
                                                                                                      // Work if :-all
                                                                                                      // condition

        Edit.Cut.setMnemonic(KeyEvent.VK_T); // --> Is : (alt + x ) , Work if :- Menu is Open
        Edit.Cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK, true)); // --> Is : (ctrl +
                                                                                                    // x ) , Work if
                                                                                                    // :-all condition

        Edit.SelectAll.setMnemonic(KeyEvent.VK_A); // --> Is : (alt + x ) , Work if :- Menu is Open
        Edit.SelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK, true)); // --> Is :
                                                                                                          // (ctrl + x )
                                                                                                          // , Work if
                                                                                                          // :-all
                                                                                                          // condition

        Edit.Replace.setMnemonic(KeyEvent.VK_R); // --> Is : (alt + x ) , Work if :- Menu is Open
        Edit.Replace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK, true)); // --> Is :
                                                                                                        // (ctrl + shift
                                                                                                        // + x ) , Work
                                                                                                        // if :-all
                                                                                                        // condition

        Edit.Find.setMnemonic(KeyEvent.VK_F); // --> Is : (alt + x ) , Work if :- Menu is Open
        Edit.Find.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK, true)); // --> Is : (ctrl +
                                                                                                     // x ) , Work if
                                                                                                     // :-all condition

        // Step 6.3.1 -> Making Shortcuts For View Menu's Items //

        View.Fonts.setMnemonic(KeyEvent.VK_F); // --> Is : (alt + x ) , Work if :- Menu is Open
        View.Fonts.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK + InputEvent.SHIFT_MASK, true)); // --> Is :
                                                                                                            // (ctrl+
                                                                                                            // shift + x
                                                                                                            // ) , Work
                                                                                                            // if :-all
                                                                                                            // condition

        View.Theme.setMnemonic(KeyEvent.VK_T); // --> Is : (alt + x ) , Work if :- Menu is Open
        View.Theme.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK + InputEvent.SHIFT_MASK, true)); // --> Is :
                                                                                                            // (ctrl+
                                                                                                            // shift + x
                                                                                                            // ) , Work
                                                                                                            // if :-all
                                                                                                            // condition

        // Step 6.3.1 -> Making Shortcuts For Advance Menu's Items //

        Advance.AutoSave.setMnemonic(KeyEvent.VK_S); // --> Is : (alt + x ) , Work if :- Menu is Open
        Advance.AutoSave.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK + InputEvent.SHIFT_MASK, true)); // --> Is :
                                                                                                           // (ctrl+
                                                                                                           // shift + x
                                                                                                           // ) , Work
                                                                                                           // if :-all
                                                                                                           // condition

        // Step 6.3.2 -> Making Shortcuts For Help Menu's Items //

        Advance.AutoSave.setMnemonic(KeyEvent.VK_S); // --> Is : (alt + x ) , Work if :- Menu is Open
        Advance.AutoSave.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK + InputEvent.SHIFT_MASK, true)); // --> Is :
                                                                                                           // (ctrl+
                                                                                                           // shift + x
                                                                                                           // ) , Work
                                                                                                           // if :-all
                                                                                                           // condition

        Advance.AutoSave.setMnemonic(KeyEvent.VK_S); // --> Is : (alt + x ) , Work if :- Menu is Open
        Advance.AutoSave.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK + InputEvent.SHIFT_MASK, true)); // --> Is :
                                                                                                           // (ctrl+
                                                                                                           // shift + x
                                                                                                           // ) , Work
                                                                                                           // if :-all
                                                                                                           // condition

        // Step 6.3.2 --> Register with Source //

        // File Menu Items //

        file.ex.addActionListener(this);
        file.NewWind.addActionListener(this);
        file.op.addActionListener(this);
        file.ne.addActionListener(this);
        file.sa.addActionListener(this);
        file.sas.addActionListener(this);
        file.prn.addActionListener(this);

        // Edit Menu Items //

        Edit.Copy.addActionListener(this);
        Edit.Paste.addActionListener(this);
        Edit.Cut.addActionListener(this);
        Edit.SelectAll.addActionListener(this);
        Edit.Replace.addActionListener(this);
        Edit.Find.addActionListener(this);

        // View Menu Items //

        View.Fonts.addActionListener(this);
        View.Theme.addActionListener(this);

        // Advance Menu Items //

        Advance.AutoSave.addActionListener(this);

        // Help Menu Items //

        HelpS.Help.addActionListener(this);
        HelpS.About.addActionListener(this);

        // this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // -> Coumplsoury

        this.addWindowListener(new WindowAdapter()

        {

            public void windowClosing(WindowEvent e) {

                Exit();

            }

        });

        th.start();
    } // Constructor close...............................

    public void run() {

        try {
            while (true) {
                Thread.sleep(10000);

                if (AutoSaveStatus == true && AutoSaveStatusOnFrame == true) {
                    // System.out.print("\n\t ==> Working...........");

                    AutoSaveFeature();
                }

                /*
                 * else
                 * {
                 * System.out.print("\n\t ==> It Is Not Working...........");
                 * }
                 */

            }

        } // try close

        catch (Exception ae5) {
            System.out.print("\n\t ==> Error :- " + ae5.getMessage());
        }

    } // run close

    public Void Exit() {

        String MyTitle = this.getTitle();

        if (MyTitle.charAt(0) == '*') {

            AutoSaveStatusOnFrame = false; // To Stop Auto Save

            int select = JOptionPane.showConfirmDialog(this, "Do You Want To Save Changes?", "DigitalPad",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (select == 0) // Selct yes
            {

                try {
                    FileDialog fd = new FileDialog(this, "Save A FILE", FileDialog.SAVE);// -> Sub window open for Save
                    fd.setVisible(true);

                    foldS = fd.getDirectory(); // -> Give Path that place File will save
                    fnaS = fd.getFile();// -> File name which is save..

                    fnaTemp = "NoName-DigitalPad";

                    if (foldS != null && fnaS != null) {
                        FoldTemp = foldS;
                        fnaTemp = fnaS;
                        FoldTemp = foldS; // class Varible

                        String data = MainTextArea.getText(); // -> Collect All data from textarea

                        FileWriter fw = new FileWriter(FoldTemp + "//" + fnaTemp);

                        fw.write(data);
                        fw.close();

                        this.dispose();
                        this.FindWord.dispose();
                        this.AboutPad.dispose();
                        this.RAW.dispose();
                        this.AutoSave.dispose();
                        this.editFonts.dispose();
                        this.editTheme.dispose();
                    } // if close

                    else {
                        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    }

                } // Try close

                catch (Exception e) {
                    System.out.println("\n ERROR : " + e.getMessage());
                } // catch is close..

            } // If (save==yes) close

            // =========================================== //

            else if (select == 1) {
                // this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                this.dispose();

                this.FindWord.dispose();
                this.AboutPad.dispose();

                this.RAW.dispose();
                this.AutoSave.dispose();

                this.editFonts.dispose();
                this.editTheme.dispose();
                // I DO this Cause If I Seclect close than after I select cancel there no to
                // anything so

            }

            else {
                this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }

        } // Title checking if is close

        else {
            this.dispose();

            this.FindWord.dispose();
            this.AboutPad.dispose();

            this.RAW.dispose();
            this.AutoSave.dispose();

            this.editFonts.dispose();
            this.editTheme.dispose();

        }

        return null;

    }

    public void actionPerformed(ActionEvent ae) // ActionListener For :- Button,Label,Menu,MenuItem
    {
        String s = ae.getActionCommand();

        PASTEFLAG = 1;

        // ------- File Menu Items -----//

        if (s.equals("Exit")) {
            // :- Here I Have To Add Option Pane

            String MyTitle = this.getTitle();

            if (MyTitle.charAt(0) == '*') {
                ConfirmationWindow(s);

            }

            else {
                this.dispose();
                this.FindWord.dispose();
                this.AboutPad.dispose();
                this.RAW.dispose();
                this.AutoSave.dispose();
                this.editFonts.dispose();
                this.editTheme.dispose();
            }

        } // if close

        // *********************************************************************************************************************
        // //

        else if (s.equals("New Window")) {
            DigitalPad Pad = new DigitalPad("NoName-DigitalPad");
            Pad.setVisible(true);
            Pad.setSize(1600, 800);
            Pad.setLocation(150, 100);
        }

        // *********************************************************************************************************************
        // //

        else if (s.equals("Open")) {
            AutoSaveStatusOnFrame = false; // To Stop Auto Save On Starting

            NoFlagOpen = 0; // Adjust Line Number
            Flag = 0; // To Rrmove Exception

            String MyTitle = this.getTitle();

            if (MyTitle.charAt(0) == '*') {
                ConfirmationWindow(s);

            }

            else {

                try {
                    FileDialog fd = new FileDialog(this, "Open a File", FileDialog.LOAD); // -> open sub window for open
                                                                                          // files..
                    fd.setVisible(true);

                    foldS = fd.getDirectory(); // -> Give Path of Selected File
                    fnaS = fd.getFile(); // -> Give Selected File Name

                    fnaTemp = "NoName-DigitalPad";

                    if (foldS != null && fnaS != null) {

                        fnaTemp = fnaS;
                        FoldTemp = foldS;

                        this.setTitle(fnaTemp); // ->Set Title of window..

                        NoFlagOpen = 1;

                        File f = new File(foldS, fnaS); // -> Connect The File..

                        AutoSaveStatusOnFrame = true; // To Start AutoSave...

                        FileInputStream fis = new FileInputStream(f);

                        // ----------- //

                        n = 0;
                        i = 1;

                        data = "";

                        LiNO = "";

                        // LiNO=LiNO + "\n";

                        LiNO = LiNO + "  " + i++ + " \n";

                        data = data + "  ";

                        while (n != -1) {
                            n = fis.read();
                            char ch;

                            if (n != -1) {
                                ch = (char) n;

                                data = data + (char) n; // --> Casting int to char

                                if (ch == '\n') {
                                    LiNO = LiNO + "  " + i++ + " \n";
                                    data = data + "  ";
                                } // inner if close

                            } // outer if close

                        } // while close

                        fis.close();

                        MainTextArea.setText(data);

                        NumOfLine.setText(LiNO);

                    } // If close

                } // Try close

                catch (Exception e) {
                    System.out.println(" ERROR : " + e.getMessage());
                } // catch close

            } // Main Else Close

            AutoSaveStatusOnFrame = true; // To Resume Auto Save

        } // Open Item Is done.

        // *********************************************************************************************************************
        // //

        else if (s.equals("New")) {

            String MyTitle = this.getTitle();

            if (MyTitle.charAt(0) == '*') {
                ConfirmationWindow(s);

            }

            else {
                AutoSaveStatusOnFrame = false; // To Stop Auto Save

                fnaTemp = "NoName-DigitalPad";
                MainTextArea.setText("");
                this.setTitle(fnaTemp); // ->Set Title of window..
                NumOfLine.setText("  1 ");
                LiNO = "";
                Flag = 0;
                i = 1;

                NoFlag = 0;
                NoFlagOpen = 0;
            }

        } // close Item is done

        // *********************************************************************************************************************
        // //

        else if (s.equals("Save")) {

            try {
                if (Flag == 0) {
                    FileDialog fd = new FileDialog(this, "Save A FILE", FileDialog.SAVE);// -> Sub window open for Save
                    fd.setVisible(true);

                    foldS = fd.getDirectory(); // -> Give Path that place File will save
                    fnaS = fd.getFile();// -> File name which is save..

                    fnaTemp = "NoName-DigitalPad";

                    if (foldS != null && fnaS != null) {
                        FoldTemp = foldS;
                        fnaTemp = fnaS;
                        FoldTemp = foldS; // class Varible
                        Flag = 1;

                        AutoSaveStatusOnFrame = true; // To First Start Of Auto Save

                    }

                } // if close

                String data = MainTextArea.getText(); // -> Collect All data from textarea

                if (foldS != null && fnaS != null) {

                    FileWriter fw = new FileWriter(FoldTemp + "//" + fnaTemp);

                    AutoSaveStatusOnFrame = true; // To resume

                    this.setTitle(fnaTemp); // ->Set Title of window..

                    fw.write(data);
                    fw.close();

                } // if close

                else {
                    return;
                }

            } // Try close

            catch (Exception e) {
                System.out.println("\n ERROR : " + e.getMessage());
            } // catch is close..

        } // Save Item is done

        // *********************************************************************************************************************
        // //

        else if (s.equals("Save As")) {
            AutoSaveStatusOnFrame = false; // To Stop Auto Save Cause Save To New Place...

            try {
                FileDialog fd = new FileDialog(this, "Save A FILE", FileDialog.SAVE);// -> Sub window open for Save
                fd.setVisible(true);

                foldS = fd.getDirectory(); // -> Give Path that place File will save
                fnaS = fd.getFile();// -> File name which is save..

                fnaTemp = "NoName-DigitalPad";

                if (foldS != null && fnaS != null) {
                    String data = MainTextArea.getText(); // -> Collect All data from textarea

                    FoldTemp = foldS;
                    fnaTemp = fnaS;
                    FoldTemp = foldS;
                    FoldTemp = foldS; // class Varible

                    FileWriter fw = new FileWriter(FoldTemp + "//" + fnaTemp);

                    this.setTitle(fnaTemp); // ->Set Title of window..

                    AutoSaveStatusOnFrame = true;

                    fw.write(data);
                    fw.close();

                } // if close

                else {
                    return;
                }

            } // Try close

            catch (Exception e) {
                System.out.println("\n ERROR : " + e.getMessage());
            } // catch is close..

            AutoSaveStatusOnFrame = true; // To Resume AutoSave

        } // Save As Item Is Close

        else if (s.equals("Print")) {

            try {

                MainTextArea.print();

                // :- Error : Jo aa Na ma pdf Save Na Karie to Null error aave che ae jovu padse
            }

            catch (Exception e) {
                System.out.print(" Error :- " + e.getMessage());
            }

        } // Print close

        // ########################################################################################################################################
        // //

        else if (s.equals("Copy")) {

            CopyText = MainTextArea.getSelectedText(); // Store WHich We Have Selceted

            if (CopyText != null) {
                CopyTextTemp = CopyText;

            }

            else {
                CopyText = CopyText;
            }

        } // copy close

        else if (s.equals("Paste")) {

            // MainTextArea.setCaretColor(Color.red);

            MainTextArea.insert(CopyTextTemp, MainTextArea.getCaretPosition()); // It IS An Important //

        } // Paste close

        else if (s.equals("Cut")) {

            CopyText = MainTextArea.getSelectedText(); // Store WHich We Have Selceted

            if (CopyText != null) {
                CopyTextTemp = CopyText;

            }

            else {
                CopyText = CopyText;
            }

            MainTextArea.replaceRange("", MainTextArea.getSelectionStart(), MainTextArea.getSelectionEnd());

        } // cut close

        else if (s.equals("Select All")) {
            MainTextArea.selectAll();

        } // Select all close

        else if (s.equals("Find")) {
            // AutoSaveStatusOnFrame=false; // To Stop Auto Save
            FindWord.setVisible(true);
            FindWord.setAlwaysOnTop(true);
            FindWord.setSize(350, 150);
            FindWord.setLocation(500, 200);

        } // Find close

        else if (s.equals("Replace All")) {
            // AutoSaveStatusOnFrame=false; // To Stop Auto Save
            RAW.setVisible(true);
            RAW.setAlwaysOnTop(true);
            RAW.setSize(500, 200);
            RAW.setLocation(500, 200);

        } // Replace close

        // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ - View Menu Item
        // -$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

        else if (s.equals("Fonts")) {
            // AutoSaveStatusOnFrame=false; // To Stop Auto Save

            editFonts.setAlwaysOnTop(true);

            editFonts.setVisible(true);

            editFonts.setSize(550, 341);

            editFonts.setLocation(600, 100);

        } // font else if close

        // ----------- 2 MenuItem 2 -----------------------//

        else if (s.equals("Theme")) {
            // AutoSaveStatusOnFrame=false; // To Stop Auto Save

            editTheme.setAlwaysOnTop(true);

            editTheme.setVisible(true);

            editTheme.setSize(550, 500);

            editTheme.setLocation(600, 100);

        }

        // *********************************************************************************************************************//
        // HelpMenuItem

        else if (s.equals("View Help")) {
            Desktop Browser = Desktop.getDesktop();

            try {
                Browser.browse(new URI(
                        "https://www.bing.com/search?q=get+help+with+notepad+in+windows&filters=guid:%224466414-en-dia%22%20lang:%22en%22&form=T00032&ocid=HelpPane-BingIA"));
            }

            catch (Exception ae8) {
                System.out.print("\n\t ==> Error :- " + ae8.getMessage());
            }

        }

        else if (s.equals("About DigitalPad")) {
            AboutPad.setAlwaysOnTop(true);

            AboutPad.setVisible(true);

            AboutPad.setSize(870, 465);

            AboutPad.setLocation(300, 100);

        }
        // ########################################################################################################################################
        // //

        // #################################################### //

        else if (s.equals("Auto Save")) {
            // AutoSaveStatusOnFrame=false; // To Stop Auto Save

            AutoSave.setAlwaysOnTop(true);

            AutoSave.setVisible(true);

            AutoSave.setSize(370, 280);

            AutoSave.setLocation(600, 100);
        }

        else if (AutoSave.Enable.isSelected()) {
            AutoSaveStatus = true;
        }

        else if (AutoSave.Disable.isSelected()) {
            AutoSaveStatus = false;
        }

    }// action get performed is close

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // //

    public void keyPressed(KeyEvent e) {

        int j = 0, k = 0;

        this.setTitle("*" + fnaTemp);

        char ch = e.getKeyChar();

        k = e.getKeyCode();

        // ======= For Auto Complete ================= //

        if (ch == '(' || ch == '{' || ch == '[' || ch == '"' || ch == 39) {

            try {

                Thread.sleep(100);

                int Position = MainTextArea.getCaretPosition();

                try

                {
                    Thread.sleep(100);
                }

                catch (Exception e2) {
                    System.out.print("\n\t ==> Error :- " + e2.getMessage());
                }
                if (ch == '(') {
                    MainTextArea.insert(")", Position);
                    MainTextArea.setCaretPosition(Position);
                }

                else if (ch == '{') {
                    MainTextArea.insert("}", Position);
                    MainTextArea.setCaretPosition(Position);
                }

                else if (ch == '[') {
                    MainTextArea.insert("]", Position);
                    MainTextArea.setCaretPosition(Position);
                }

                else if (ch == '"') {
                    MainTextArea.insert("\"", Position);
                    MainTextArea.setCaretPosition(Position);
                }

                else {
                    MainTextArea.insert("'", Position);
                    MainTextArea.setCaretPosition(Position);
                }

            }

            catch (Exception e1) {
                System.out.print("\n\t ==> Error :- " + e1.getMessage());
            }

        }

        // ------------------------------- Adjust Number After Deleteing Lines
        // ----------------------------------- //

        if (k == 127 || k == 8) {
            NumOfLine.setText(" 1 ");

            LiNO = "  " + 1 + " \n";

            String TempData = MainTextArea.getText();

            int N = 0;
            char TempCH;

            int l = 0;

            i = 2;

            while (l < TempData.length() - 1) {

                TempCH = TempData.charAt(l);

                if (TempCH == '\n') {
                    LiNO = LiNO + "  " + i++ + " \n";

                } // inner if close

                l++;

            } // while close

            NumOfLine.setText(LiNO);
        }

        // ------------------------------------------------------------------ //

        if (ch == '\n') {
            if (NoFlag == 0) // This condition will work only for one time
            {
                if (NoFlagOpen == 0) // This condtion is for that we Not Open any file
                {
                    LiNO = LiNO + "  " + 1;
                }

                else // this is for if open file and after that we edti file than it will use
                {
                    LiNO = LiNO + "  " + ++i + " ";
                }

                LiNO = LiNO + "\n";
                i++;
                NoFlag = 1;

            }

            LiNO = LiNO + "  " + i++ + " \n";
            NumOfLine.setText(LiNO);
        }

    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // //

    public void ConfirmationWindow(String S) {
        AutoSaveStatusOnFrame = false; // To Stop Auto Save

        int select = JOptionPane.showConfirmDialog(this, "Do You Want To Save Changes?", "DigitalPad",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (select == JOptionPane.YES_OPTION && (S.equals("Exit") || S.equals("New") || S.equals("Open"))) {

            try {
                if (FlagEx == 0) {
                    FileDialog fd = new FileDialog(this, "Save A FILE", FileDialog.SAVE);// -> Sub window open for Save
                    fd.setVisible(true);

                    foldS = fd.getDirectory(); // -> Give Path that place File will save
                    fnaS = fd.getFile();// -> File name which is save..

                    fnaTemp = "NoName-DigitalPad";

                    if (foldS != null && fnaS != null) {
                        FoldTemp = foldS;
                        fnaTemp = fnaS;
                        FoldTemp = foldS; // class Varible
                        FlagEx = 1;
                    }

                } // if close

                String data = MainTextArea.getText(); // -> Collect All data from textarea

                if (foldS != null && fnaS != null) {

                    FileWriter fw = new FileWriter(FoldTemp + "//" + fnaTemp);

                    this.setTitle(fnaTemp); // ->Set Title of window..

                    fw.write(data);
                    fw.close();

                } // if close

                else {
                    return;
                }

            } // Try close

            catch (Exception e)

            {
                System.out.println("\n ERROR : " + e.getMessage());
            } // catch is close..

            // To Adjust Work //

            try {
                Thread.sleep(1000);
            }

            catch (Exception e)

            {
                System.out.println("\n ERROR : " + e.getMessage());

            } // catch is close..

            // Above Is For SAve Changes//
            // ************************************* //

            if (S.equals("New")) {
                AutoSaveStatusOnFrame = false; // To Stop Auto Save
                Flag = 0;
                fnaTemp = "NoName-DigitalPad";
                MainTextArea.setText("");
                this.setTitle(fnaTemp); // ->Set Title of window..
                NumOfLine.setText("  1 ");
                LiNO = "";
                i = 1;

                NoFlag = 0;
                NoFlagOpen = 0;

            }

            else if (S.equals("Exit")) {
                this.dispose();

                this.FindWord.dispose();
                this.AboutPad.dispose();

                this.RAW.dispose();
                this.AutoSave.dispose();

                this.editFonts.dispose();
                this.editTheme.dispose();

            }

            else // OPen
            {
                AutoSaveStatusOnFrame = false; // To Stop Auto Save

                NoFlagOpen = 0;

                Flag = 0;

                try {
                    FileDialog fd = new FileDialog(this, "Open a File", FileDialog.LOAD); // -> open sub window for open
                                                                                          // files..
                    fd.setVisible(true);

                    foldS = fd.getDirectory(); // -> Give Path of Selected File
                    fnaS = fd.getFile(); // -> Give Selected File Name

                    fnaTemp = "NoName-DigitalPad";

                    if (foldS != null && fnaS != null) {

                        fnaTemp = fnaS;
                        FoldTemp = foldS;

                        this.setTitle(fnaTemp); // ->Set Title of window..

                        AutoSaveStatusOnFrame = true; // To Resume Auto Save

                        NoFlagOpen = 1;

                        File f = new File(foldS, fnaS); // -> Connect The File..

                        FileInputStream fis = new FileInputStream(f);

                        // ----------- //

                        n = 0;
                        i = 1;

                        data = "";

                        LiNO = "";

                        // LiNO=LiNO + "\n";

                        LiNO = LiNO + "  " + i++ + " \n";

                        data = data + "  ";

                        while (n != -1) {
                            n = fis.read();
                            char ch;

                            if (n != -1) {
                                ch = (char) n;

                                data = data + (char) n; // --> Casting int to char

                                if (ch == '\n') {
                                    LiNO = LiNO + "  " + i++ + " \n";
                                    data = data + "  ";
                                } // inner if close

                            } // outer if close

                        } // while close

                        fis.close();

                        MainTextArea.setText(data);

                        NumOfLine.setText(LiNO);

                    } // If close

                } // Try close

                catch (Exception e) {
                    System.out.println(" ERROR : " + e.getMessage());
                } // catch close

            }

            AutoSaveStatusOnFrame = true; // To Resume Auto Save

        } // Yes Close

        // ----------------------------------------------------------------------------------------------------------------------------//

        else if (select == JOptionPane.NO_OPTION && S.equals("Exit")) {
            this.dispose();

            this.FindWord.dispose();
            this.AboutPad.dispose();

            this.RAW.dispose();
            this.AutoSave.dispose();

            this.editFonts.dispose();
            this.editTheme.dispose();
        }

        else if (select == JOptionPane.NO_OPTION && S.equals("Open")) {
            AutoSaveStatusOnFrame = false; // To Stop Auto Save

            NoFlagOpen = 0;

            Flag = 0;

            try {
                FileDialog fd = new FileDialog(this, "Open a File", FileDialog.LOAD); // -> open sub window for open
                                                                                      // files..
                fd.setVisible(true);

                foldS = fd.getDirectory(); // -> Give Path of Selected File
                fnaS = fd.getFile(); // -> Give Selected File Name

                fnaTemp = "NoName-DigitalPad";

                if (foldS != null && fnaS != null) {

                    fnaTemp = fnaS;
                    FoldTemp = foldS;

                    this.setTitle(fnaTemp); // ->Set Title of window..

                    NoFlagOpen = 1;

                    AutoSaveStatusOnFrame = true; // To Resume Auto Save

                    File f = new File(foldS, fnaS); // -> Connect The File..

                    FileInputStream fis = new FileInputStream(f);

                    // ----------- //

                    n = 0;
                    i = 1;

                    data = "";

                    LiNO = "";

                    // LiNO=LiNO + "\n";

                    LiNO = LiNO + "  " + i++ + " \n";

                    data = data + "  ";

                    while (n != -1) {
                        n = fis.read();
                        char ch;

                        if (n != -1) {
                            ch = (char) n;

                            data = data + (char) n; // --> Casting int to char

                            if (ch == '\n') {
                                LiNO = LiNO + "  " + i++ + " \n";
                                data = data + "  ";
                            } // inner if close

                        } // outer if close

                    } // while close

                    fis.close();

                    MainTextArea.setText(data);

                    NumOfLine.setText(LiNO);

                } // If close

            } // Try close

            catch (Exception e) {
                System.out.println(" ERROR : " + e.getMessage());
            } // catch close

            AutoSaveStatusOnFrame = true; // To Resume Auto Save

        }

        else if (select == JOptionPane.NO_OPTION && S.equals("New")) {
            AutoSaveStatusOnFrame = false; // To Stop Auto Save

            Flag = 0;
            fnaTemp = "NoName-DigitalPad";
            MainTextArea.setText("");
            this.setTitle(fnaTemp); // ->Set Title of window..
            NumOfLine.setText("  1 ");
            LiNO = "";
            i = 1;

            NoFlag = 0;
            NoFlagOpen = 0;
        }

        else {
            S = "Not Do";
        }

    } // Method "ConfirmationWindow"

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

    void AutoSaveFeature() {
        try {
            String data = MainTextArea.getText(); // -> Collect All data from textarea

            if (foldS != null && fnaS != null) {

                FileWriter fw = new FileWriter(FoldTemp + "//" + fnaTemp);

                this.setTitle(fnaTemp); // ->Set Title of window..

                fw.write(data);
                fw.close();

            } // if close

            else {
                return;
            }

        } // Try close

        catch (Exception e) {
            System.out.println("\n ERROR : " + e.getMessage());
        } // catch is close..

    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // //

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    // #########################################################################################################################
    // //

}// PadPad class is close
