package org.anna.mathass.faculty;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultEditorKit.BeepAction;

import org.anna.mathass.ui.Main;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;

public class AddQuestions extends JFrame implements ActionListener , MouseListener {
	Dimension dim;
	JMenu back;
	JLabel questL;
	JPanel questP,controlsP;
	Font fp,fs;
	JLabel jltopic,jlqtype,jloperation,jlcmd;
	JComboBox jctopic,jcqtype,jcoperation;
	JTextField jtcmd;
	String topic,operation,qtype;
	JButton jbsave,jbcancel;
	AddQuestionThread aqt;
	BufferedWriter out;
	static File f;
	static String content;
	AddQuestions()
	{
	super("Add Questions");
	dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	this.setSize(dim);
	this.getContentPane().setLayout(new GridLayout(1,2));
	JLabel jl = new JLabel();
	fp= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+15);
	fs= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+10);
	back = new JMenu("Back");
	questP = new JPanel(new BorderLayout());
	controlsP = new JPanel(new GridLayout(9,2));
	jltopic = new JLabel("Select Topic");
	jltopic.setFont(fs);
	jloperation = new JLabel("Select Operation");
	jloperation.setFont(fs);
	jlqtype = new JLabel("Select Quesion Type");
	jlqtype.setFont(fs);
	jlcmd = new JLabel("Command");
	jlcmd.setFont(fs);
	jctopic = new JComboBox(new String[]{"Select One","Matrix","Coordinate Geometry"/*,"Algebra"*/});
	jctopic.setFont(fs);
	jcqtype = new JComboBox(new String[]{"Select One","Learn","Practise"});
	jcqtype.setFont(fs);
	jcqtype.setEnabled(false);
	jcoperation = new JComboBox(new String[]{"Select one"});
	jcoperation.setEnabled(false);
	jcoperation.setFont(fs);
	jtcmd = new JTextField();
	jtcmd.setEnabled(false);
	jtcmd.setFont(fs);
	jbsave = new JButton("Save");
	jbsave.setFont(fs);
	jbsave.setEnabled(false);
	jbcancel = new JButton("Cancel");
	jbcancel.setFont(fs);
	jbcancel.setEnabled(false);
	
	controlsP.add(jltopic);
	controlsP.add(jctopic);
	controlsP.add(new JLabel("  "));
	controlsP.add(new JLabel("  "));
	controlsP.add(jloperation);
	controlsP.add(jcoperation);
	controlsP.add(new JLabel("  "));
	controlsP.add(new JLabel("  "));
	controlsP.add(jlqtype);
	controlsP.add(jcqtype);
	controlsP.add(new JLabel("  "));
	controlsP.add(new JLabel("  "));
	controlsP.add(jlcmd);
	controlsP.add(jtcmd);
	controlsP.add(new JLabel("  "));
	controlsP.add(new JLabel("  "));
	controlsP.add(jbsave);
	controlsP.add(jbcancel);
	
	questL = new JLabel("Question");
	questL.setHorizontalAlignment(SwingConstants.CENTER);
	JPanel right = new JPanel(new GridLayout(3,1));
	right.add(new JLabel("  "));
	right.add(controlsP);
	right.add(new JLabel("  "));
	questL.setFont(fp);
	questP.add(questL,BorderLayout.CENTER);
	JMenuBar bar = new JMenuBar();
	setJMenuBar(bar);
	bar.add(back);
	add(questP);
	add(right);
	jctopic.addActionListener(this);
	jcoperation.addActionListener(this);
	jcqtype.addActionListener(this);
	jtcmd.addActionListener(this);
	back.addMouseListener(this);
	jbcancel.addMouseListener(this);
	jbsave.addMouseListener(this);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		DefaultComboBoxModel model;
		if(event.getSource().equals(jctopic)&&jctopic.getSelectedIndex()!=0)
		{   
			switch (jctopic.getSelectedIndex()) {
			case 1:
				topic = "matrix";
				model = new DefaultComboBoxModel( new String[]{"Select One",/*"MATRIX FORMATION","ELEMENT IDENTIFICATION","MATRIX CONSTRUCTION",*/"TRANSPOSE OF A MATRIX","EQUALITY OF MATRICES","ADDITION","SUBTRACTION","SCALAR MULTIPLIATION","MATRIX MULTIPLIATION","NEGATIVE OF MATRIX"});
				jcoperation.setModel( model );
				jcoperation.setEnabled(true);
				break;
			case 2:
				topic = "cogeo";
				model = new DefaultComboBoxModel( new String[]{"Select One","DISTANCE","MIDPOINT","CENTROID","INTERNAL SEGMENT","EXTERNAL SEGMENT","AREA OF TRIANGLE","SLOPE(ANGLE)","SLOPE(TWO POINTS)"});
				jcoperation.setModel( model );
				jcoperation.setEnabled(true);
			       break;
			case 3:
				topic = "algebra";
				model = new DefaultComboBoxModel( new String[]{"Select One"});
				jcoperation.setModel( model );
				jcoperation.setEnabled(true);
			    break;
			}
			jbcancel.setEnabled(true);
		}
		if(event.getSource().equals(jcoperation)&&jcoperation.getSelectedIndex()!=0)
		{   
			if(topic.equals("matrix"))
			{
			switch (jcoperation.getSelectedIndex()) {
			case 1:
				operation = "trans";
				jcqtype.setEnabled(true);
				break;
			case 2:
				operation = "equ";
				jcqtype.setEnabled(true);
				break;
			case 3:
				operation = "add";
				jcqtype.setEnabled(true);
				break;
			case 4:
				operation = "sub";
				jcqtype.setEnabled(true);
			       break;
			case 5:
				operation = "scmul";
				jcqtype.setEnabled(true);
			       break;
			case 6:
				operation = "mul";
				jcqtype.setEnabled(true);
			       break;
			case 7:
				operation = "neg";
				jcqtype.setEnabled(true);
			       break;

			}
			}
			else if(topic.equals("cogeo"))
			{
				switch (jcoperation.getSelectedIndex()) {
				case 1:
					operation = "dist";
					jcqtype.setEnabled(true);
					break;
				case 2:
					operation = "midp";
					jcqtype.setEnabled(true);
					break;
				case 3:
					operation = "cent";
					jcqtype.setEnabled(true);
					break;
				case 4:
					operation = "intseg";
					jcqtype.setEnabled(true);
				       break;
				case 5:
					operation = "extseg";
					jcqtype.setEnabled(true);
				       break;
				case 6:
					operation = "area";
					jcqtype.setEnabled(true);
				       break;
				case 7:
					operation = "slopeang";
					jcqtype.setEnabled(true);
				       break;
				case 8:
					operation = "slopetwopoint";
					jcqtype.setEnabled(true);
				       break;

				}	
			}
			jctopic.setEnabled(false);
		}
		if(event.getSource().equals(jcqtype)&&jcqtype.getSelectedIndex()!=0)
		{   
			
			switch (jcqtype.getSelectedIndex()) {
			case 1:
				qtype = "learn";
				break;
			case 2:
				qtype = "practise";
			    break;
			}
			jcqtype.setEnabled(false);
			jcoperation.setEnabled(false);
			aqt = new AddQuestionThread(jlcmd, questL, jtcmd,jbsave,topic,operation,qtype);
			jtcmd.setEnabled(true);
			aqt.start();
		}
		if(event.getSource().equals(jtcmd))
		{   if(!jtcmd.getText().equals(""))
		    {
			aqt.txtValue = jtcmd.getText();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jtcmd.setText("");
			aqt.blockedForIO = true;
		    }
		    else
		    	Toolkit.getDefaultToolkit().beep();
			
		}
	}
	@Override
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource().equals(back))
		{
			new FacultyMain().setVisible(true);
			dispose();
		}
		if(event.getSource().equals(jbcancel))
		{
			dispose();
			new AddQuestions().setVisible(true);
		}
		if(event.getSource().equals(jbsave))
		{
			try {
				out = new BufferedWriter(new FileWriter(f));
				out.write(content);
				out.flush();
				out.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			new AddQuestions().setVisible(true);
			dispose();
		}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
