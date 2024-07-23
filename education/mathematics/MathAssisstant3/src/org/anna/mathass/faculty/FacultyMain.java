package org.anna.mathass.faculty;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.anna.mathass.ui.Main;

public class FacultyMain extends JFrame implements ActionListener, MouseListener {
	Dimension dim;
	JMenu settings,addQuestions,signout;
	JMenuItem studentUISettings, changePassword, learn; 
	FacultyMain()
	{
		super("Faculty Home");
		dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(dim);
		settings = new JMenu("Settings");
		addQuestions = new JMenu("Add Questions");
		signout = new JMenu("Logout");
		studentUISettings = new JMenuItem("Student UI Settings");
		changePassword = new JMenuItem("Change Password");
		settings.add(studentUISettings);
		settings.add(changePassword);
		studentUISettings.addActionListener(this);
		changePassword.addActionListener(this);
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(addQuestions);
		bar.add(settings);
		bar.add(signout);
		signout.addMouseListener(this);
		addQuestions.addMouseListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource().equals(studentUISettings))
		{
			new StudUISettings().setVisible(true);
			dispose();
		}
	}
	@Override
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource().equals(addQuestions))
		{
			new AddQuestions().setVisible(true);
			dispose();
		}
		if(event.getSource().equals(signout))
		{
			new Main().setVisible(true);
			dispose();
		}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
