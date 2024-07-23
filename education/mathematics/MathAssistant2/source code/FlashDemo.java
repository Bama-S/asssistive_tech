//package javaapplication2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.*; 
import com.jpackages.jflashplayer.*;

public class FlashDemo extends JFrame
{

	FlashPanel flashPanel;
                 FlashButtonPanel fbp;
	void createFlashPanel()
	 {	
                   FlashPanel.installFlash("6");				
                   String flashVersionRequired = "9";
	try 
	{	
	String flashFilePath = "flash.swf";
	if (!FlashPanel.hasFlashVersion("9")) 
	{
	flashFilePath = "flash.swf";		
	flashVersionRequired = "6";
	}
	FlashPanel.setRequiredFlashVersion(flashVersionRequired);
	flashPanel = new FlashPanel(new File(flashFilePath));					
	}
	 catch (JFlashLibraryLoadFailedException e)
	 {			
	System.out.println("A required library (DLL) is missing or damaged.");
	}
	 catch (FileNotFoundException e) 
	{
	System.out.println("Failed to find SWF file specified.");
	}
	 catch (JFlashInvalidFlashException e) 
	{
	System.out.println("Required version " + flashVersionRequired + " of Flash is not installed.");
	}
	this.getContentPane().add(flashPanel, BorderLayout.CENTER);
	flashPanel.setFlashCallObject(this);		
	//flashPanel.addFlashPanelListener(this);
	}
	public FlashDemo() 
	{
                  fbp=new FlashButtonPanel();
	try 
	{
                  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	}
	 catch (Exception e) 
	{
	e.printStackTrace();
	}	
	this.setTitle("MATH ASSISTANT");
	this.setSize(1310, 640);
	this.getContentPane().setLayout(new BorderLayout());
	createFlashPanel();
	this.getContentPane().add(fbp, BorderLayout.SOUTH);
                  FlashButtonPanel.restart();
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	centerAndDisplay();		
	}

	void centerAndDisplay() 
	{
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	Dimension frameSize = this.getSize();
	if (frameSize.height > screenSize.height) 
	{
	frameSize.height = screenSize.height;
	}
	if (frameSize.width > screenSize.width) 
	{
	frameSize.width = screenSize.width;
	}
	this.setLocation((screenSize.width - frameSize.width) / 2,(screenSize.height - frameSize.height) / 2);
	this.setVisible(true);
	this.toFront();
	}


}
