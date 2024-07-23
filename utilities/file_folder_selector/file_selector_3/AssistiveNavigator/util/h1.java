package util;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Robot;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.*;
import java.io.*;

public class h1 implements ActionListener, MouseListener, Runnable  
{
	Point OtherWindow=new Point(600,20);
	Point OurWindow=new Point(200,20);
	Point lastMouseLoc=new Point(0,0); 
	Robot r;
	String buffer="";
	int pos=0;
	int shift=0;
    int IdxOfKeyToScan=0;
	JFrame frame;
	JTextField text;
	JPanel pane=new JPanel();
	JButton buttonList[];
	custom c=new custom();
    String st1="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890`-=[]\\;',./";
    String st2="QWERTYUIOPASDFGHJKLZXCVBNM1234567890`-=[]\\;',./";
	String st3="ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()~_+{}|:\"<>?";
	String st4="QWERTYUIOPASDFGHJKLZXCVBNM!@#$%^&*()~_+{}|:\"<>?";
	int n1=st1.length();
	int n2=st2.length();
	int n3=st3.length();
	int n4=st4.length();
	public boolean threadCanRun = true;

	public h1()
	{
		try
		{
			r=new Robot();         
		}
		catch(Exception ex)
		{

        return;                    
		}
	}
	
	public void KeyBoard()
	{   
		text = new JTextField(20);
		text.setActionCommand(""+ buffer);
		pane.setBackground(Color.BLACK);
		pane.add(text);
		frame = new JFrame();
		frame.setTitle("Onscreen Keyboard");
		frame.getContentPane().add(pane,"Center");
	    frame.setSize(2000,450);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.addMouseListener(this);
 
		buttonList = new JButton[81];
		JButton tempBtn=null;
         for (int i = 0; i < n1; i++) {
			buttonList[i] = new JButton( "" + st1.charAt(i) );
			pane.add(buttonList[i]);
			buttonList[i].addActionListener(this);
			buttonList[i].setBackground(Color.WHITE);
		}
				
		buttonList[47] = new JButton("Space bar");
		tempBtn = buttonList[47];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[48] = new JButton("Enter");
		tempBtn = buttonList[48];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[49] = new JButton("Tab");	
		tempBtn = buttonList[49];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[50] = new JButton("CapsLock");
		tempBtn = buttonList[50];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[51] = new JButton("Home");
		tempBtn = buttonList[51];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[52] = new JButton("Shift");
		tempBtn = buttonList[52];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[53] = new JButton("Find");
		tempBtn = buttonList[53];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[54] = new JButton("Replace");
		tempBtn = buttonList[54];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[55] = new JButton("End");
		tempBtn = buttonList[55];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[56] = new JButton("Clear");
		tempBtn = buttonList[56];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[57] = new JButton("PageUp");
		tempBtn = buttonList[57];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[58] = new JButton("PageDown");
		tempBtn = buttonList[58];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[59] = new JButton("Up");
		tempBtn = buttonList[59];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[60] = new JButton("Down");
		tempBtn = buttonList[60];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[61] = new JButton("Left");
		tempBtn = buttonList[61];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[62] = new JButton("Right");
		tempBtn = buttonList[62];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[63] = new JButton("Undo");
		tempBtn = buttonList[63];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[64] = new JButton("Redo");
		tempBtn = buttonList[64];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[65] = new JButton("Backspace");
		tempBtn = buttonList[65];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[66] = new JButton("Go To");
		tempBtn = buttonList[66];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[67] = new JButton("*New*");
		tempBtn = buttonList[67];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[68] = new JButton("*Open*");
		tempBtn = buttonList[68];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[69] = new JButton("*Save*");
		tempBtn = buttonList[69];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[70] = new JButton("*Close*");
		tempBtn = buttonList[70];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[71] = new JButton("*SelectAll*");
		tempBtn = buttonList[71];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);

		buttonList[72] = new JButton("*Cut*");
		tempBtn = buttonList[72];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);

		buttonList[73] = new JButton("*Copy*");
		tempBtn = buttonList[73];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[74] = new JButton("*Paste*");
		tempBtn = buttonList[74];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);
		
		buttonList[75] = new JButton("*Customize*");
		tempBtn = buttonList[75];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);

		buttonList[76] = new JButton("Close keyboard");
		tempBtn = buttonList[76];
		pane.add(tempBtn);
		tempBtn.addActionListener(this);
		tempBtn.setBackground(Color.WHITE);

       for (int i =77; i < 81; i++) 
       {
        buttonList[i] = new JButton(" ");
        pane.add(buttonList[i]);
        buttonList[i].addActionListener(this);
        buttonList[i].setBackground(Color.WHITE);
       }
	}

	public void KeyBoard1()
	{
      if(c.layoutVal==0 && shift==0)
	  {
	  for (int i = 0; i < n1; i++) {
			buttonList[i].setText("" + st1.charAt(i));
			buttonList[i].setBackground(Color.WHITE);
	  }
	  }
       else if(c.layoutVal==1 && shift==0)
        {
	    for (int i = 0; i < n2; i++) {
			buttonList[i].setText("" + st2.charAt(i));
			buttonList[i].setBackground(Color.WHITE);
		}
		}
		else if(c.layoutVal==0 && shift==1)
        {
	    for (int i = 0; i < n3; i++) {
			buttonList[i].setText("" + st3.charAt(i));
			buttonList[i].setBackground(Color.WHITE);
		}
		}
		else if(c.layoutVal==1 && shift==1)
        {
	    for (int i = 0; i < n4; i++) {
            buttonList[i].setText("" + st4.charAt(i));
			buttonList[i].setBackground(Color.WHITE);
		}
		}
	}

	void setMouseLoc(ActionEvent ae)
	{
		Component comp = (Component)ae.getSource();
	    lastMouseLoc = comp.getLocationOnScreen(); 
		Dimension dim = comp.getSize();
	    lastMouseLoc.x += dim.width/2;
	    lastMouseLoc.y += dim.height/2;
	}
	
	void writeChar(int let)
	{
		r.mouseMove(OtherWindow.x, OtherWindow.y);
		r.mousePress(InputEvent.BUTTON1_MASK);  
		r.mouseRelease(InputEvent.BUTTON1_MASK);
		r.keyPress(let);   
		r.keyRelease(let); 
		r.mouseMove(OurWindow.x, OurWindow.y);
		r.mousePress(InputEvent.BUTTON1_MASK);
		r.mouseRelease(InputEvent.BUTTON1_MASK);
	    r.mouseMove(lastMouseLoc.x, lastMouseLoc.y);
	}

	void writeChar(int ctrlKey, int key)
	{
		r.mouseMove(OtherWindow.x, OtherWindow.y);
		r.mousePress(InputEvent.BUTTON1_MASK);  
		r.mouseRelease(InputEvent.BUTTON1_MASK);
		r.keyPress(ctrlKey);
		r.keyPress(key);
		r.keyRelease(ctrlKey);
		r.keyRelease(key); 
		r.mouseMove(OurWindow.x, OurWindow.y);
		r.mousePress(InputEvent.BUTTON1_MASK);
		r.mouseRelease(InputEvent.BUTTON1_MASK);
	    r.mouseMove(lastMouseLoc.x, lastMouseLoc.y);
	}
	
	void sendFileCloseEvent()
	{
		r.mouseMove(OtherWindow.x, OtherWindow.y);
		r.mousePress(InputEvent.BUTTON1_MASK);  
		r.mouseRelease(InputEvent.BUTTON1_MASK);
		r.keyPress(KeyEvent.VK_ALT);
		r.keyRelease(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_F);
		r.keyPress(KeyEvent.VK_X);
     	r.mouseMove(OurWindow.x, OurWindow.y);
		r.mousePress(InputEvent.BUTTON1_MASK);
		r.mouseRelease(InputEvent.BUTTON1_MASK);
	    r.mouseMove(lastMouseLoc.x, lastMouseLoc.y);
	}
	
	public void startThread()
	{
	   Thread th = new Thread(this);
		threadCanRun = true;
	    th.start();
	}
	
	public void stopThread()
	{
	    threadCanRun = false;
	}
	
	public void run()
	{
           for(int i=0;i<81&&threadCanRun;i++)
	       {
	       buttonList[i].setBackground(Color.WHITE);
           }
			for(int i=1;i<=30&&threadCanRun;i++) {
			if (IdxOfKeyToScan==81)
			{
			IdxOfKeyToScan=0;
			}
		   
            for (IdxOfKeyToScan = 0;IdxOfKeyToScan<81;IdxOfKeyToScan++) 
			{
				if(threadCanRun){
					System.out.println("Keyborad");
                buttonList[IdxOfKeyToScan].setBackground(Color.PINK);
	   			Font f = new Font("Calibre", Font.BOLD, c.fntSize);
				buttonList[IdxOfKeyToScan].setFont(f);
				buttonList[IdxOfKeyToScan].setBackground(c.clr);
								 if(IdxOfKeyToScan>=0 && IdxOfKeyToScan<36) 
                                 {
					              if(c.layoutVal==0 && shift==0)
                                   {
                                    //speech(IdxOfKeyToScan);
                                   }
                                   else if(c.layoutVal==1 && shift==0)
                                   {
                                    //speech1(IdxOfKeyToScan);
                                  }
                                  }
				try{
                Thread.sleep(c.scanSpeed);
				}catch(InterruptedException e) {e.printStackTrace();}
				pos=IdxOfKeyToScan;
                buttonList[pos].setBackground(Color.WHITE);
		        }
			    }
				}

		}
	

   public void ResetScanningThread(int scanPos) {
       for(int i=0;i<81;i++)
	   {
	   buttonList[i].setBackground(Color.WHITE);
       }
    stopThread();
	IdxOfKeyToScan = scanPos;
    Font f = new Font("Calibre", Font.BOLD, c.fntSize);
	buttonList[IdxOfKeyToScan].setFont(f);
    buttonList[scanPos].setBackground(c.clr);
    startThread();
}

public void type(String s)
{
  r.mouseMove(OtherWindow.x, OtherWindow.y); 
  r.mousePress(InputEvent.BUTTON1_MASK);  
  r.mouseRelease(InputEvent.BUTTON1_MASK);
  byte[] bytes = s.getBytes();
  for (byte b : bytes)
   {
     int code = b;
     if (code > 96 && code < 123) code = code - 32;
     r.delay(40);
     r.keyPress(code);
     r.keyRelease(code);
   }
 }


	public void writeAZ(int i)
	{
	    if(c.layoutVal==0) 
		{
		buffer += st1.toLowerCase().charAt(i);
        text.setText(""+ buffer);
        writeChar(st1.charAt(i));
		wpred();
       }
	   else if(c.layoutVal==1)
		{
	    buffer += st2.toLowerCase().charAt(pos);
        text.setText(""+ buffer);
        writeChar(st2.charAt(i));
		wpred();
		}
   }

   	public void write09(int i)
	{
		if(shift==0) 
		{
		buffer += st1.toLowerCase().charAt(i);
        text.setText(""+ buffer);
		writeChar(st1.charAt(i));
       }
	   else if(shift==1)
		{
		buffer += st3.toLowerCase().charAt(i);
        text.setText(""+ buffer);
		writeChar(KeyEvent.VK_SHIFT,st1.charAt(i) );
        }
	}

	public void writesym(int i)
	{
		if(shift==0) 
		{
		buffer += st1.toLowerCase().charAt(i);
        text.setText(""+ buffer);
        writeChar(st1.charAt(i));
       }
	   else if(shift==1)
		{
		buffer += st3.toLowerCase().charAt(i);
        text.setText(""+ buffer);
       	writeChar(KeyEvent.VK_SHIFT,st1.charAt(i) );
        }
	}

public void actionPerformed(ActionEvent e){
if(e.getSource()==buttonList[0]){writeAZ(0);ResetScanningThread(0);}
else if(e.getSource()==buttonList[1]){writeAZ(1);ResetScanningThread(1);}
else if(e.getSource()==buttonList[2]){writeAZ(2);ResetScanningThread(2);}
else if(e.getSource()==buttonList[3]){writeAZ(3);ResetScanningThread(3);}
else if(e.getSource()==buttonList[4]){writeAZ(4);ResetScanningThread(4);}	
else if(e.getSource()==buttonList[5]){writeAZ(5);ResetScanningThread(5);}
else if(e.getSource()==buttonList[6]){writeAZ(6);ResetScanningThread(6);}
else if(e.getSource()==buttonList[7]){writeAZ(7);ResetScanningThread(7);}
else if(e.getSource()==buttonList[8]){writeAZ(8);ResetScanningThread(8);}
else if(e.getSource()==buttonList[9]){writeAZ(9);ResetScanningThread(9);}
else if(e.getSource()==buttonList[10]){writeAZ(10);ResetScanningThread(10);}
else if(e.getSource()==buttonList[11]){writeAZ(11);ResetScanningThread(11);}
else if(e.getSource()==buttonList[12]){writeAZ(12);ResetScanningThread(12);}
else if(e.getSource()==buttonList[13]){writeAZ(13);ResetScanningThread(13);}
else if(e.getSource()==buttonList[14]){writeAZ(14);ResetScanningThread(14);}
else if(e.getSource()==buttonList[15]){writeAZ(15);ResetScanningThread(15);}
else if(e.getSource()==buttonList[16]){writeAZ(16);ResetScanningThread(16);}
else if(e.getSource()==buttonList[17]){writeAZ(17);ResetScanningThread(17);}
else if(e.getSource()==buttonList[18]){writeAZ(18);ResetScanningThread(18);}
else if(e.getSource()==buttonList[19]){writeAZ(19);ResetScanningThread(19);}
else if(e.getSource()==buttonList[20]){writeAZ(20);ResetScanningThread(20);}
else if(e.getSource()==buttonList[21]){writeAZ(21);ResetScanningThread(21);}
else if(e.getSource()==buttonList[22]){writeAZ(22);ResetScanningThread(22);}
else if(e.getSource()==buttonList[23]){writeAZ(23);ResetScanningThread(23);}
else if(e.getSource()==buttonList[24]){writeAZ(24);ResetScanningThread(24);}
else if(e.getSource()==buttonList[25]){writeAZ(25);ResetScanningThread(25);}
else if(e.getSource()==buttonList[26]){write09(26);ResetScanningThread(26);}
else if(e.getSource()==buttonList[27]){write09(27);ResetScanningThread(27);}
else if(e.getSource()==buttonList[28]){write09(28);ResetScanningThread(28);}
else if(e.getSource()==buttonList[29]){write09(29);ResetScanningThread(29);}
else if(e.getSource()==buttonList[30]){write09(30);ResetScanningThread(30);}
else if(e.getSource()==buttonList[31]){write09(31);ResetScanningThread(31);}
else if(e.getSource()==buttonList[32]){write09(32);ResetScanningThread(32);}
else if(e.getSource()==buttonList[33]){write09(33);ResetScanningThread(33);}
else if(e.getSource()==buttonList[34]){write09(34);ResetScanningThread(34);}
else if(e.getSource()==buttonList[35]){write09(35);ResetScanningThread(35);}
else if(e.getSource()==buttonList[36]){writesym(36);ResetScanningThread(36);}
else if(e.getSource()==buttonList[37]){writesym(37);ResetScanningThread(37);}
else if(e.getSource()==buttonList[38]){writesym(38);ResetScanningThread(38);}
else if(e.getSource()==buttonList[39]){writesym(39);ResetScanningThread(39);}
else if(e.getSource()==buttonList[40]){writesym(40);ResetScanningThread(40);}
else if(e.getSource()==buttonList[41]){writesym(41);ResetScanningThread(41);}
else if(e.getSource()==buttonList[42]){writesym(42);ResetScanningThread(42);}
else if(e.getSource()==buttonList[43]){writesym(43);ResetScanningThread(43);}
else if(e.getSource()==buttonList[44]){writesym(44);ResetScanningThread(44);}
else if(e.getSource()==buttonList[45]){writesym(45);ResetScanningThread(45);}
else if(e.getSource()==buttonList[46]){writesym(46);ResetScanningThread(46);}
else if(e.getSource()==buttonList[47]){writeChar(KeyEvent.VK_SPACE);ResetScanningThread(47);}
else if(e.getSource()==buttonList[48]){writeChar(KeyEvent.VK_ENTER);ResetScanningThread(48);}
else if(e.getSource()==buttonList[49]){writeChar(KeyEvent.VK_TAB);ResetScanningThread(49);}
else if(e.getSource()==buttonList[50]){writeChar(KeyEvent.VK_CAPS_LOCK);ResetScanningThread(50);}
else if(e.getSource()==buttonList[51]){writeChar(KeyEvent.VK_HOME);ResetScanningThread(51);}
else if(e.getSource()==buttonList[52]){
if(shift==0){
shift=1;
}
else if(shift==1)
{
shift=0;
}
KeyBoard1();
ResetScanningThread(52);
}
else if(e.getSource()==buttonList[53]){writeChar(KeyEvent.VK_CONTROL,KeyEvent.VK_F);ResetScanningThread(53);}
else if(e.getSource()==buttonList[54]){writeChar(KeyEvent.VK_CONTROL,KeyEvent.VK_H);ResetScanningThread(54);}
else if(e.getSource()==buttonList[55]){writeChar(KeyEvent.VK_END);ResetScanningThread(55);}
else if(e.getSource()==buttonList[56]){buffer="";text.setText(""+buffer);ResetScanningThread(56);}
else if(e.getSource()==buttonList[57]){writeChar(KeyEvent.VK_PAGE_UP);ResetScanningThread(57);}
else if(e.getSource()==buttonList[58]){writeChar(KeyEvent.VK_PAGE_DOWN);ResetScanningThread(58);}
else if(e.getSource()==buttonList[59]){writeChar(KeyEvent.VK_UP);ResetScanningThread(59);}
else if(e.getSource()==buttonList[60]){writeChar(KeyEvent.VK_DOWN);ResetScanningThread(60);}
else if(e.getSource()==buttonList[61]){writeChar(KeyEvent.VK_LEFT);ResetScanningThread(61);}
else if(e.getSource()==buttonList[62]){writeChar(KeyEvent.VK_RIGHT);ResetScanningThread(62);}
else if(e.getSource()==buttonList[63]){writeChar(KeyEvent.VK_Z);ResetScanningThread(63);}
else if(e.getSource()==buttonList[64]){writeChar(KeyEvent.VK_Y);ResetScanningThread(64);}
else if(e.getSource()==buttonList[65]){writeChar(KeyEvent.VK_BACK_SPACE);ResetScanningThread(65);}
else if(e.getSource()==buttonList[66]){writeChar(KeyEvent.VK_CONTROL, KeyEvent.VK_G);ResetScanningThread(66);}
else if(e.getSource()==buttonList[67]){writeChar(KeyEvent.VK_CONTROL, KeyEvent.VK_N);ResetScanningThread(67);}
else if(e.getSource()==buttonList[68]){writeChar(KeyEvent.VK_CONTROL, KeyEvent.VK_O);ResetScanningThread(68);}
else if(e.getSource()==buttonList[69]){writeChar(KeyEvent.VK_CONTROL, KeyEvent.VK_S);ResetScanningThread(69);}
else if(e.getSource()==buttonList[70]){sendFileCloseEvent();ResetScanningThread(70);}
else if(e.getSource()==buttonList[71]){ writeChar(KeyEvent.VK_CONTROL, KeyEvent.VK_A);ResetScanningThread(71);}
else if(e.getSource()==buttonList[72]){writeChar(KeyEvent.VK_CONTROL, KeyEvent.VK_X);ResetScanningThread(72);}
else if(e.getSource()==buttonList[73]){writeChar(KeyEvent.VK_CONTROL, KeyEvent.VK_C);ResetScanningThread(73);}
else if(e.getSource()==buttonList[74]){writeChar(KeyEvent.VK_CONTROL, KeyEvent.VK_V);ResetScanningThread(74);}
else if(e.getSource()==buttonList[75]){
            stopThread();
			frame.setVisible(false);
			c.setframe(this);
			c.startThread();
            ResetScanningThread(75);
}
else 	if(e.getSource()==buttonList[76])
{
stopThread();
}
else if(e.getSource()==buttonList[77])
{
String fn=buttonList[77].getText().toString();
type(fn);
text.setText(fn);
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord(fn));
buffer="";
text.setText(""+buffer);
 ResetScanningThread(77);
}
else if(e.getSource()==buttonList[78])
{
String fn=buttonList[78].getText().toString();
type(fn);
text.setText(fn);
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord(fn));
buffer="";
text.setText(""+buffer);
 ResetScanningThread(78);
}
else if(e.getSource()==buttonList[79])
{
String fn=buttonList[79].getText().toString();
type(fn);
text.setText(fn);
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord(fn));
buffer="";
text.setText(""+buffer);
 ResetScanningThread(79);
}
else if(e.getSource()==buttonList[80])
{
String fn=buttonList[80].getText().toString();
type(fn);
text.setText(fn);
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
//talk.sayPhoneWord(con.getPhoneWord(fn));
buffer="";
text.setText(""+buffer);
 ResetScanningThread(80);
}
}

public void wpred()
{
try
{
 BufferedReader inputFile =new BufferedReader(new FileReader("wordfreq1.txt"));
 String line;
 int max = 4;
 Vector v = new Vector();
 while ((line = inputFile.readLine()) != null)
 {
 StringTokenizer st = new StringTokenizer(line);   
 if (st.countTokens() != 2)
 {
   return;
  }
  String newWord = st.nextToken();
  int newFreq = Integer.parseInt(st.nextToken());
  v.addElement(new Word(newWord, newFreq));
  }  
  inputFile.close(); 
  Word[] w = new Word[v.size()];
  v.copyInto(w);
  Arrays.sort(w, new ByWord());
  String s1;
  String s=text.getText();
  while ((s1=s) != null)
  {
  String s2 = s1.substring(0, s1.length() - 1) + (char)(s1.charAt(s1.length() - 1) + 1);       
  int n1 = Arrays.binarySearch(w, new Word(s1, 0), new ByWord());
  int n2 = Arrays.binarySearch(w, new Word(s2, 0), new ByWord());
  if (n2 < 0) n2 = -n2 - 1;
  if (n2 - n1 > 0)
  {     			
   Word[] w2 = new Word[n2 - n1];
	int i, j;
	for (i = n1, j = 0; i < n2; i++, j++)
	{w2[j] = w[i];}
	Arrays.sort(w2, new ByFreq());
    int n = w2.length > max ? max : w2.length;
	for (i = 0; i < n;i++)
	{		
	 String ss=(w2[i].getWord().toString());
	 buttonList[i+77].setText(w2[i].getWord()+ " ");	
	}
	break;
	}
  }
}
catch (Exception e){}
}
	
public static void main(String []args)
{
	h1 kbm= new h1();
	kbm.KeyBoard();
	kbm.startThread();
}

// public void speech(int pos)
// {
// if(pos==0){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("ae"));
// }
// else if(pos==1){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("bee"));
// }
// else if(pos==2){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("see"));
// }
// else if(pos==3){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("de"));
// }
// else if(pos==4){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("eeh"));
// }	
// else if(pos==5){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("eff"));
// }
// else if(pos==6){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("jae"));
// }
// else if(pos==7){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("ech"));
// }
// else if(pos==8){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("i"));
// }
// else if(pos==9){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("jay"));
// }
// else if(pos==10){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("kae"));
// }
// else if(pos==11){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("ell"));
// }
// else if(pos==12){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("em"));
// }
// else if(pos==13){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("en"));
// }
// else if(pos==14){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("oh"));
// }
// else if(pos==15){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("pee"));
// }
// else if(pos==16){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("kiu"));
// }
// else if(pos==17){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("aar"));
// }
// else if(pos==18){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("yes"));
// }
// else if(pos==19){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("tee"));
// }
// else if(pos==20){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("you"));
// }
// else if(pos==21){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("vee"));
// }
// else if(pos==22){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("doubleu"));
// }
// else if(pos==23){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("ex"));
// }
// else if(pos==24){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("why"));
// }
// else if(pos==25){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("zzed"));
// }
// else if(pos==26){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("won"));
// }
// else if(pos==27){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("too"));
// }
// else if(pos==28){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("three"));
// }
// else if(pos==29){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("fore"));
// }
// else if(pos==30){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("five"));
// }
// else if(pos==31){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("cix"));
// }
// else if(pos==32){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("saven"));
// }
// else if(pos==33){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("ait"));
// }
// else if(pos==34){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("nine"));
// }
// else if(pos==35){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("zeerow"));
// }
// }	

// public void speech1(int pos)
// {	
// if(pos==0){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("kiu"));
// }
// else if(pos==1){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("doubleu"));
// }
// else if(pos==2){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("ee"));
// }
// else if(pos==3){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("aar"));
// }
// else if(pos==4){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("tee"));
// }	
// else if(pos==5){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("why"));
// }
// else if(pos==6){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("you"));
// }
// else if(pos==7){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("i"));
// }
// else if(pos==8){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("oh"));
// }
// else if(pos==9){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("pee"));
// }
// else if(pos==10){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("a"));
// }
// else if(pos==11){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("yes"));
// }
// else if(pos==12){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("de"));
// }
// else if(pos==13){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("eff"));
// }
// else if(pos==14){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("jay"));
// }
// else if(pos==15){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("ech"));
// }
// else if(pos==16){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("jae"));
// }
// else if(pos==17){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("kae"));
// }
// else if(pos==18){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("ell"));
// }
// else if(pos==19){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("zzed"));
// }
// else if(pos==20){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("ex"));
// }
// else if(pos==21){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("see"));
// }
// else if(pos==22){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("vee"));
// }
// else if(pos==23){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("bee"));
// }
// else if(pos==24){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("en"));
// }
// else if(pos==25){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("em"));
// }
// else if(pos==26){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("won"));
// }
// else if(pos==27){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("too"));
// }
// else if(pos==28){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("three"));
// }
// else if(pos==29){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("fore"));
// }
// else if(pos==30){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("five"));
// }
// else if(pos==31){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("cix"));
// }
// else if(pos==32){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("saven"));
// }
// else if(pos==33){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("eit"));
// }
// else if(pos==34){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("nine"));
// }
// else if(pos==35){
// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
// talk.sayPhoneWord(con.getPhoneWord("zeerow"));
// }
// }


public void mouseClicked(MouseEvent e)
{
	
	 if(IdxOfKeyToScan>=0 && IdxOfKeyToScan<26)
		{
		if(c.layoutVal==0) 
		{
		buffer += st1.toLowerCase().charAt(IdxOfKeyToScan);
        text.setText(""+ buffer);
       writeChar(st1.charAt(IdxOfKeyToScan));
	   //wpred();
       }
	   else if(c.layoutVal==1)
		{
		buffer += st2.toLowerCase().charAt(IdxOfKeyToScan);
        text.setText(""+ buffer);
       writeChar(st2.charAt(IdxOfKeyToScan));
	   //wpred();
        }
		}
		else if(IdxOfKeyToScan>=26 && IdxOfKeyToScan<36)
		{
		if(shift==0) 
		{
		buffer += st1.toLowerCase().charAt(IdxOfKeyToScan);
        text.setText(""+ buffer);
       writeChar(st1.charAt(IdxOfKeyToScan));
       }
	   else if(shift==1)
		{
		buffer += st3.toLowerCase().charAt(IdxOfKeyToScan);
        text.setText(""+ buffer);
      	writeChar(KeyEvent.VK_SHIFT,st1.charAt(IdxOfKeyToScan) );
        }
		}
		else if(IdxOfKeyToScan>=36 && IdxOfKeyToScan<47)
		{
		if(shift==0) 
		{
		buffer += st1.toLowerCase().charAt(IdxOfKeyToScan);
        text.setText(""+ buffer);
       writeChar(st1.charAt(IdxOfKeyToScan));
       }
	   else if(shift==1)
		{
		buffer += st3.toLowerCase().charAt(IdxOfKeyToScan);
        text.setText(""+ buffer);
     	writeChar(KeyEvent.VK_SHIFT,st1.charAt(IdxOfKeyToScan) );
        }
		}
         else if(IdxOfKeyToScan==47)
		{
         writeChar(KeyEvent.VK_SPACE);
		 }
         else if(IdxOfKeyToScan==48)
		{
         writeChar(KeyEvent.VK_ENTER);
		}
         else if(IdxOfKeyToScan==49)
		{
         writeChar(KeyEvent.VK_TAB);
		}
        else if(IdxOfKeyToScan==50)
		{
         writeChar(KeyEvent.VK_CAPS_LOCK);
		}
        else if(IdxOfKeyToScan==51)
		{
        writeChar(KeyEvent.VK_HOME);
		}
        else if(IdxOfKeyToScan==52)
		{
       	if(shift==0)
		{
		shift=1;
        }
		else if(shift==1)
		{
         shift=0;
		}
		KeyBoard1();
		}
		else if(IdxOfKeyToScan==53)
		{
        writeChar(KeyEvent.VK_CONTROL,KeyEvent.VK_F);
		}
        else if(IdxOfKeyToScan==54)
		{
                 writeChar(KeyEvent.VK_CONTROL,KeyEvent.VK_H);
		}
        else if(IdxOfKeyToScan==55)
		{
         writeChar(KeyEvent.VK_END);
		}
        else if(IdxOfKeyToScan==56)
		{
         buffer="";
		 text.setText(""+buffer);
		}
        else if(IdxOfKeyToScan==57)
		{
         writeChar(KeyEvent.VK_PAGE_UP);
		}
         else if(IdxOfKeyToScan==58)
		{
        writeChar(KeyEvent.VK_PAGE_DOWN);
		}
         else if(IdxOfKeyToScan==59)
		{
         writeChar(KeyEvent.VK_UP);
		}
         else if(IdxOfKeyToScan==60)
		{
        writeChar(KeyEvent.VK_DOWN);
		}
        else if(IdxOfKeyToScan==61)
		{
         writeChar(KeyEvent.VK_LEFT);
		}
         else if(IdxOfKeyToScan==62)
		{
         writeChar(KeyEvent.VK_RIGHT);
          }
        else if(IdxOfKeyToScan==63)
        {
         writeChar(KeyEvent.VK_Z);
        }
		else if(IdxOfKeyToScan==64)
        {
         writeChar(KeyEvent.VK_Y);
         }
		 else if(IdxOfKeyToScan==65)
        {
         writeChar(KeyEvent.VK_BACK_SPACE);
         }
		 else if(IdxOfKeyToScan==66)
		{
		writeChar(KeyEvent.VK_CONTROL, KeyEvent.VK_G);
		}
        else if(IdxOfKeyToScan==67)
		{
           	writeChar(KeyEvent.VK_CONTROL, KeyEvent.VK_N);
		}
		else if(IdxOfKeyToScan==68)
		{
			writeChar(KeyEvent.VK_CONTROL, KeyEvent.VK_O);
		}
		else if(IdxOfKeyToScan==69)
		{
			writeChar(KeyEvent.VK_CONTROL, KeyEvent.VK_S);
		}
		else if(IdxOfKeyToScan==70)
		{
		sendFileCloseEvent();
		}
        else if(IdxOfKeyToScan==71)
		{
		   writeChar(KeyEvent.VK_CONTROL, KeyEvent.VK_A);
		}
		else if(IdxOfKeyToScan==72)
		{
		 writeChar(KeyEvent.VK_CONTROL, KeyEvent.VK_X);
		}
		else if(IdxOfKeyToScan==73)
		{
		writeChar(KeyEvent.VK_CONTROL, KeyEvent.VK_C);
		}
		else if(IdxOfKeyToScan==74)
		{
         writeChar(KeyEvent.VK_CONTROL, KeyEvent.VK_V);
		}
		else if(IdxOfKeyToScan==75)
		{
            stopThread();
			frame.setVisible(false);
			c.setframe(this);
			c.startThread();
		}
		else	if(IdxOfKeyToScan==76)
		{
		   stopThread();
		}
		else if(IdxOfKeyToScan==77)
        {
		String fn=buttonList[77].getText().toString();
		type(fn);
		text.setText(fn);
		// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
		// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
		// talk.sayPhoneWord(con.getPhoneWord(fn));
		buffer="";
		text.setText(""+buffer);
		}
		else if(IdxOfKeyToScan==78)
		{
		String fn=buttonList[78].getText().toString();
		type(fn);
		text.setText(fn);
		// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
		// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
		// talk.sayPhoneWord(con.getPhoneWord(fn));
		buffer="";
		text.setText(""+buffer);
		}
		else if(IdxOfKeyToScan==79)
		{
		String fn=buttonList[79].getText().toString();
		type(fn);
		text.setText(fn);
		// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
		// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
		// talk.sayPhoneWord(con.getPhoneWord(fn));
		buffer="";
		text.setText(""+buffer);
		}
		else if(IdxOfKeyToScan==80)
		{
		String fn=buttonList[80].getText().toString();
		type(fn);
		text.setText(fn);
		// com.lotontech.speech.Talker talk = new com.lotontech.speech.Talker();
		// com.lotontech.speech.Converter con = new com.lotontech.speech.Converter();
		// talk.sayPhoneWord(con.getPhoneWord(fn));
		buffer="";
		text.setText(""+buffer);
		}
}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
}
