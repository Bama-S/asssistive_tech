package org.anna.mathass.ui;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.anna.mathass.res.DataInfo;

public class UISettings {
 public static Color WinBGColor = Color.WHITE;
 public static Color TextColor = Color.BLACK;
 public static Color HighlightBGColor = Color.BLUE;
 public static Color HighlightTextColor = Color.WHITE;
 public static String WorkBKBGColor = "WHITE";
 public static String WorkTextColor = "BLACK";
 public static String WorkCurColor = "RED";
 public static int adFontSize = 20;
 public static long scanSpeed = 1000;
 public static String colorNames[] = 
 {"BLACK","WHITE","RED","BLUE","GREEN","CYAN","MAGENTA","YELLOW","GRAY","DARK_GRAY","LIGHT_GRAY","PINK","ORANGE"};
 public static String fontLevel[] = {"5","10","15","20","25","30","35","40"};
 public static String scanSpeeds[] = {"500","1000","1500","2000","2500","3000","3500","4000"};
 private static String MatAssDir = DataInfo.GLOBAL_PARA_DIR;
 private static String UISetFileName = DataInfo.UI_SETTINGS_FILE;
 public static void setSettings
 (int WinBGColor,int TextColor,int WorkBKBGColor,int WorkTextColor,int WorkCurColor,
		 int HighlightBGColor,int HighlightTextColor,String adFontSize, String scanSpeed )
 {   
	 try {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(new File(MatAssDir+UISetFileName))));
		out.write(WinBGColor+"\n"+TextColor+"\n"+WorkBKBGColor+"\n"+WorkTextColor+"\n"+
				  WorkCurColor+"\n"+HighlightBGColor+"\n"+HighlightTextColor+"\n"+adFontSize
				  +"\n"+scanSpeed+"\n");
		out.flush();
		out.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 
 public static void loadSettings()
 {
	 try {
		 BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(MatAssDir+UISetFileName))));
		 UISettings.WinBGColor = getColorObject(Integer.parseInt(br.readLine()));
		 UISettings.TextColor  = getColorObject(Integer.parseInt(br.readLine()));
		 UISettings.WorkBKBGColor = UISettings.colorNames[Integer.parseInt(br.readLine())-1];
		 UISettings.WorkTextColor = UISettings.colorNames[Integer.parseInt(br.readLine())-1];
		 UISettings.WorkCurColor = UISettings.colorNames[Integer.parseInt(br.readLine())-1];
		 UISettings.HighlightBGColor = getColorObject(Integer.parseInt(br.readLine()));
		 UISettings.HighlightTextColor = getColorObject(Integer.parseInt(br.readLine()));
		 UISettings.adFontSize = Integer.parseInt(br.readLine());
		 UISettings.scanSpeed = Integer.parseInt(br.readLine());
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		BufferedWriter out;
		try {
			out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(new File(MatAssDir+UISetFileName))));
			out.write("2\n1\n2\n1\n3\n4\n2\n20\n1000\n");
			out.flush();
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 
 
 public static Color getColorObject(int colorCode)
 {
	 switch(colorCode)
	 {
	 case 1: 
		 return Color.BLACK;
	 case 2: 
		 return Color.WHITE;
	 case 3: 
		 return Color.RED;
	 case 4: 
		 return Color.BLUE;
	 case 5: 
		 return Color.GREEN;
	 case 6: 
		 return Color.CYAN;
	 case 7: 
		 return Color.MAGENTA;
	 case 8: 
		 return Color.YELLOW;
	 case 9: 
		 return Color.GRAY;
	 case 10: 
		 return Color.DARK_GRAY;
	 case 11: 
		 return Color.LIGHT_GRAY;
	 case 12: 
		 return Color.PINK;
	 case 13: 
		 return Color.ORANGE;
	 default: 
		 return null;
	 }
 }
}
