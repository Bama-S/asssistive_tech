
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class Mind implements MouseListener, KeyListener {
// Declare button's attribure
    public static java.awt.Font btnFont = new java.awt.Font("Elephant",Font.BOLD,30);
    public static Color btnForecolor=Color.YELLOW;
    public static Color btnBackcolor=Color.DARK_GRAY;
    public static int VSPACE=200,HSPACE=300;
    public static int ShapeHeight=100,ShapeWidth=150;
    public static float Shapethick=8.0f;
    public static int scanSlow=2000,scanMedium=1000,scanFast=500;
    
    public static Node scanNode[]=new Node[200];
    public static int scanIndex,currentIndex;
    public static Node currentNode=null,parentNode=null;
   
   
 
    
    public static MindDraw Obj_Drawing; 
    public static MenuPanel Obj_Menupanel;
    public static IconTool Obj_Icontool;
    public static Keyboard Obj_Keyboard;
    public static NodeTool Obj_Nodetool;
    public static ColorTool Obj_Colortool;
    public static TextTool Obj_Texttool;
    public static ShapeTool Obj_Shapetool;
    public static NewNode Obj_Newnode;
    public static Node Obj_node;
    public static View Obj_View;
    public static SaveAs Obj_Saveas;
    public static Save Obj_Save;
    public static Open Obj_Open;
        
    public static JFrame Frame;
    public static Container containpane;
    public static String varFontName;
   // public static int tool;
    public static int varFontStyle = -1,  varFontSize = 0;
    public static int scanSpeed;
    public static char keyChar;

    public static String varIconName;
    public  static Color varColor = null;
    public static int varShape;
    
    public static boolean flagNormalMode = false;
  
    public static boolean flagClick;
    public static boolean   flagEditnode = false,  flagEditchild = false,  flagClearRect;
    
    public static JScrollPane scrollpane;
   
   
    public static Mode Obj_Mode;
    public static EditNode Obj_Editnode;
 

    public void mouseClicked(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {
        flagClick = true;
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void keyPressed(KeyEvent ke) {

        flagClick = true;

    }

    public void keyReleased(KeyEvent ke) {
    }

    public void keyTyped(KeyEvent ke) {
    }

    /**
     * 
     */
    public Mind()
  {
      readConfig();
      init();
      
  }
    public void init() {

      
        Obj_Keyboard = new Keyboard();
        Obj_Icontool = new IconTool();
        Obj_Nodetool = new NodeTool();
        Obj_Editnode= new EditNode();
        Obj_Drawing = new MindDraw();
        Obj_Colortool = new ColorTool();
        Obj_Texttool = new TextTool();
        Obj_Shapetool = new ShapeTool();
        Obj_Newnode = new NewNode();
       Obj_Mode=new Mode();
       Obj_View=new View();
        Obj_Saveas=new SaveAs();
        Obj_Save=new Save();
        Obj_Open=new Open();
       
        
        Obj_Menupanel = new MenuPanel();
        Frame=new JFrame();
        containpane=Frame.getContentPane();
        containpane.add(BorderLayout.NORTH, Obj_Menupanel);
        
        containpane.add(BorderLayout.SOUTH, Obj_Keyboard);

        scrollpane = new JScrollPane(Obj_Drawing, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        containpane.add(BorderLayout.WEST, Obj_Mode);

        containpane.add(BorderLayout.CENTER, scrollpane);

        containpane.addMouseListener(this);
        containpane.addKeyListener(this);
        scrollpane.addMouseListener(this);

        containpane.requestFocus();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
       Frame.setSize(screenSize);
       Frame.setTitle("MANACHITRAM");
       Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       Frame.setVisible(true);
       
    }
        public static void westReset()
    {
        Mind.Obj_Nodetool.setVisible(false);
Mind.Obj_Editnode.setVisible(false);
Mind.Obj_Newnode.setVisible(false);
Mind.Obj_Mode.setVisible(false);
Mind.Obj_View.setVisible(false);
Mind.Obj_Saveas.setVisible(false);
Mind.Obj_Save.setVisible(false);
Mind.Obj_Open.setVisible(false);
    }
    public static void southReset()
    {
       Mind.Obj_Colortool.setVisible(false);
       Mind.Obj_Icontool.setVisible(false);
       Mind.Obj_Texttool.setVisible(false);
       Mind.Obj_Shapetool.setVisible(false);
       
       Mind.Obj_Keyboard.setVisible(false);
       
    }
    public static void main(String args[]){
        new Mind();
        
            }
    public static void play(String fname)
    {
        File soundFile=new File("audio\\"+fname+".wav");
    try

{

    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

    Clip clip = AudioSystem.getClip();

    clip.open(audioIn);
    clip.start();
    
}

catch(Exception m)

{}

    }
    public static void readConfig()
    {
        try
        {
        FileInputStream fis=new FileInputStream("settings.conf");
        Scanner in=new Scanner(fis);
        String bcolor=in.nextLine();
        if(bcolor.equalsIgnoreCase("RED")) {
            btnBackcolor=Color.RED;
        }
     
     else if(bcolor.equalsIgnoreCase("GREEN")) {
            btnBackcolor=Color.GREEN;
        }
     else if(bcolor.equalsIgnoreCase("BLUE")) {
            btnBackcolor=Color.BLUE;
        }
     else if(bcolor.equalsIgnoreCase("BLACK")) {
            btnBackcolor=Color.BLACK;
        }
     else if(bcolor.equalsIgnoreCase("MAGENTA")) {
            btnBackcolor=Color.MAGENTA;
        }
     else if(bcolor.equalsIgnoreCase("ORANGE")) {
            btnBackcolor=Color.ORANGE;
        }
     else if(bcolor.equalsIgnoreCase("YELLOW")) {
            btnBackcolor=Color.YELLOW;
        }
     else if(bcolor.equalsIgnoreCase("CYAN")) {
            btnBackcolor=Color.CYAN;
        }
     else if(bcolor.equalsIgnoreCase("GRAY")) {
            btnBackcolor=Color.GRAY;
        }
     else if(bcolor.equalsIgnoreCase("PINK")) {
            btnBackcolor=Color.PINK;
        }
String fcolor=in.nextLine();
        if(fcolor.equalsIgnoreCase("RED")) {
            btnForecolor=Color.RED;
        }

     else if(fcolor.equalsIgnoreCase("GREEN")) {
            btnForecolor=Color.GREEN;
        }
     else if(fcolor.equalsIgnoreCase("BLUE")) {
            btnForecolor=Color.BLUE;
        }
     else if(fcolor.equalsIgnoreCase("BLACK")) {
            btnForecolor=Color.BLACK;
        }
     else if(fcolor.equalsIgnoreCase("MAGENTA")) {
            btnForecolor=Color.MAGENTA;
        }
     else if(fcolor.equalsIgnoreCase("ORANGE")) {
            btnForecolor=Color.ORANGE;
        }
     else if(fcolor.equalsIgnoreCase("YELLOW")) {
            btnForecolor=Color.YELLOW;
        }
     else if(fcolor.equalsIgnoreCase("CYAN")) {
            btnForecolor=Color.CYAN;
        }
     else if(fcolor.equalsIgnoreCase("GRAY")) {
            btnForecolor=Color.GRAY;
        }
     else if(fcolor.equalsIgnoreCase("PINK")) {
            btnForecolor=Color.PINK;
        }

        String fntname=in.nextLine();
        String fntstyle=in.nextLine();
        int fnts;
        if(fntstyle.equalsIgnoreCase("BOLD")) {
            fnts=1;
        }

     else if(fntstyle.equalsIgnoreCase("ITALIC")) {
            fnts=2;
        }
     else
     {
            fnts=0;
     }
btnFont=new Font(fntname,fnts,Integer.parseInt(in.nextLine()));

   ShapeWidth=Integer.parseInt(in.nextLine());
    ShapeHeight=Integer.parseInt(in.nextLine());
    Shapethick=Float.parseFloat(in.nextLine());
    System.out.println(Shapethick);
    VSPACE=Integer.parseInt(in.nextLine());
    HSPACE=Integer.parseInt(in.nextLine());

    scanSlow=Integer.parseInt(in.nextLine());
   scanMedium=Integer.parseInt(in.nextLine());
   scanFast=Integer.parseInt(in.nextLine());



        }
        catch(Exception e)
        {
System.out.print(e);
        }
    }
    }
