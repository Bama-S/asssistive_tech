package org.anna.mathass.practice;

import javax.swing.JLabel;

import org.anna.mathass.ui.UIStatus;

public class StringScanThread extends Thread {
    UIStatus status;
    String scanText[];
    JLabel jl;
	StringScanThread(UIStatus status, JLabel jl, String scanText[])
	{
		this.status = status;
		this.scanText = scanText;
		this.jl = jl;
	}
	public void run()
	{
		try{
	        while(status.Visible)
	        {
	        	for(int i = 0; i < scanText.length && status.Visible; i++)
	        	{ 
	        		jl.setText(scanText[i]);
	        		status.focused=i;
	        		Thread.sleep(1000);
	        	}
	        }
		   }catch(Exception e)
		   {}
	        return;
	}
}
