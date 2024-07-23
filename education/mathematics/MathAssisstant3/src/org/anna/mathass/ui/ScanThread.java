package org.anna.mathass.ui;

import java.awt.Color;

import javax.swing.*;


public class ScanThread extends Thread {
	JLabel jl[];
	UIStatus status;
	public ScanThread(JLabel[] jl, UIStatus status)
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
        	for(int i = 0; i < jl.length; i++)
        	{ 
        		jl[i].setBackground(UISettings.HighlightBGColor);
        		jl[i].setForeground(UISettings.HighlightTextColor);
        		status.focused=i;
        		Thread.sleep(UISettings.scanSpeed);
        		if(!status.Visible)
        			break;
        		jl[i].setBackground(UISettings.WinBGColor);
        		jl[i].setForeground(UISettings.TextColor);
        		
        	}
        }
	   }catch(Exception e)
	   {}
        return;
	}

}
