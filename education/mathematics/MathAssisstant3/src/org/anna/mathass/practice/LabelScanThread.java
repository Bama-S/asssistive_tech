package org.anna.mathass.practice;

import java.awt.Color;

import javax.swing.JLabel;

import org.anna.mathass.ui.UISettings;
import org.anna.mathass.ui.UIStatus;

public class LabelScanThread extends Thread {
	public JLabel jl[];
	public UIStatus status;
	public LabelScanThread(JLabel[] jl, UIStatus status)
	{
		this.jl=jl;
		this.status=status;
      
	}
	
	@Override
	public void run()
	{  
	   
	   try{
        while(status.Visible)
        {
        	for(int i = 0; i < jl.length && status.Visible; i++)
        	{ 
        		jl[i].setBackground(UISettings.HighlightBGColor);
        		jl[i].setForeground(UISettings.HighlightTextColor);
        		status.focused=i;
        		Thread.sleep(UISettings.scanSpeed);
        		jl[i].setBackground(UISettings.WinBGColor);
        		jl[i].setForeground(UISettings.TextColor);
        		
        	}
        }
	   }catch(Exception e)
	   {}
        return;
	}

}
