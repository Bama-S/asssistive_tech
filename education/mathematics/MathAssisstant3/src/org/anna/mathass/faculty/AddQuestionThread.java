package org.anna.mathass.faculty;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Savepoint;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.anna.mathass.res.DataInfo;

public class AddQuestionThread extends Thread {

	boolean blockedForIO = false;
	JLabel msg,quest;
	JTextField value;
	String dirPath,topic,operation,qtype;
	StringBuilder qhtml;
	String finishHtml = "</tr></table></body></html>";
	StringBuilder content;
	String txtValue;
	JButton save;
	
	AddQuestionThread(JLabel msg,JLabel quest,JTextField value,JButton save,
			          String topic,String operation,String qtype)
	{
		this.msg = msg;
		this.quest = quest;
		this.value = value;
		this.topic = topic;
		this.operation = operation;
		this.qtype = qtype;
		this.save = save;
		qhtml = new StringBuilder();
		content = new StringBuilder();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		//Matrix
		
	
			if(topic.equals("matrix"))
			{  
				
				//Addition
				
				
				if(operation.equals("add"))
				{
				if(qtype.equals("practise"))
				{
					dirPath = DataInfo.MATRIX_PRAC_QUES_DIR;
					String filePrefix = "add";
					int r,c,matA[][],matB[][];
					BufferedWriter fwriter;
					qhtml.append("<html><body><table><tr><td>Add the following Matrices</td>");
					quest.setText(qhtml.toString()+finishHtml);
					msg.setText("Matrix Dimension, Rows");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					r = Integer.parseInt(txtValue);
					msg.setText("Matrix Dimension, Cols");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					c = Integer.parseInt(txtValue);
					matA = new int[r][c];
					matB = new int[r][c];
					qhtml.append("<td><table border = '1'>");
					for(int i = 0; i < r; i++)
					{qhtml.append("<tr>");
					for(int j = 0; j < c; j++)
					{
						qhtml.append("<td>a"+(i+1)+(j+1)+"</td>");
					}
					qhtml.append("</tr>");
					}
					
					qhtml.append("</table></td><td> and </td>");
					qhtml.append("<td><table border = '1'>");
					for(int i = 0; i < r; i++)
					{qhtml.append("<tr>");
					for(int j = 0; j < c; j++)
					{
						qhtml.append("<td>b"+(i+1)+(j+1)+"</td>");
					}
					qhtml.append("</tr>");
					}
					qhtml.append("</table></td>"+finishHtml);
					String qstr;
					quest.setText(qstr = qhtml.toString());
					
					content.append(filePrefix+"\n"+r+"\n"+c+"\n");
					for(int i = 0; i < r; i++)
					for(int j = 0; j < c; j++)
					{
						msg.setText("Enter Value of a"+(i+1)+(j+1));
						while(!blockedForIO){
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}blockedForIO = false;
						matA[i][j] = Integer.parseInt(txtValue);
						content.append(matA[i][j]+"\n");
						quest.setText(qstr = qstr.toString().replace("a"+(i+1)+(j+1), ""+matA[i][j]));
					}
					
					    for(int i = 0; i < r; i++)
						for(int j = 0; j < c; j++)
						{
							msg.setText("Enter Value of b"+(i+1)+(j+1));
							while(!blockedForIO){
								try {
									Thread.sleep(50);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}blockedForIO = false;
							matB[i][j] = Integer.parseInt(txtValue);
							content.append(matB[i][j]+"\n");
							quest.setText(qstr = qstr.toString().replace("b"+(i+1)+(j+1), ""+matB[i][j])); 
						}
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					    
				}
				
				if(qtype.equals("learn"))
				{	
					dirPath = DataInfo.MATRIX_LEARN_QUES_DIR;
					String filePrefix = "add";
					int r,c,matA[][],matB[][];
					BufferedWriter fwriter;
					qhtml.append("<html><body><table><tr><td>Add the following Matrices</td>");
					quest.setText(qhtml.toString()+finishHtml);
					msg.setText("Matrix Dimension, Rows");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					r = Integer.parseInt(txtValue);
					msg.setText("Matrix Dimension, Cols");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					c = Integer.parseInt(txtValue);
					matA = new int[r][c];
					matB = new int[r][c];
					qhtml.append("<td><table border = '1'>");
					for(int i = 0; i < r; i++)
					{qhtml.append("<tr>");
					for(int j = 0; j < c; j++)
					{
						qhtml.append("<td>a"+(i+1)+(j+1)+"</td>");
					}
					qhtml.append("</tr>");
					}
					
					qhtml.append("</table></td><td> and </td>");
					qhtml.append("<td><table border = '1'>");
					for(int i = 0; i < r; i++)
					{qhtml.append("<tr>");
					for(int j = 0; j < c; j++)
					{
						qhtml.append("<td>b"+(i+1)+(j+1)+"</td>");
					}
					qhtml.append("</tr>");
					}
					qhtml.append("</table></td>"+finishHtml);
					String qstr;
					quest.setText(qstr = qhtml.toString());
					
					content.append(r+"\n"+c+"\n");
					for(int i = 0; i < r; i++)
					for(int j = 0; j < c; j++)
					{
						msg.setText("Enter Value of a"+(i+1)+(j+1));
						while(!blockedForIO){
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}blockedForIO = false;
						matA[i][j] = Integer.parseInt(txtValue);
						content.append(matA[i][j]+"\n");
						quest.setText(qstr = qstr.toString().replace("a"+(i+1)+(j+1), ""+matA[i][j]));
					}
					
					    for(int i = 0; i < r; i++)
						for(int j = 0; j < c; j++)
						{
							msg.setText("Enter Value of b"+(i+1)+(j+1));
							while(!blockedForIO){
								try {
									Thread.sleep(50);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}blockedForIO = false;
							matB[i][j] = Integer.parseInt(txtValue);
							content.append(matB[i][j]+"\n");
							quest.setText(qstr = qstr.toString().replace("b"+(i+1)+(j+1), ""+matB[i][j])); 
						}
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					    
				}
				}
				
				//Subtraction
				
				if(operation.equals("sub"))
				{
				if(qtype.equals("practise"))
				{
					dirPath = DataInfo.MATRIX_PRAC_QUES_DIR;
					String filePrefix = "sub";
					int r,c,matA[][],matB[][];
					BufferedWriter fwriter;
					qhtml.append("<html><body><table><tr><td>Calculate A - b if A = </td>");
					quest.setText(qhtml.toString()+finishHtml);
					msg.setText("Matrix Dimension, Rows");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					r = Integer.parseInt(txtValue);
					msg.setText("Matrix Dimension, Cols");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					c = Integer.parseInt(txtValue);
					matA = new int[r][c];
					matB = new int[r][c];
					qhtml.append("<td><table border = '1'>");
					for(int i = 0; i < r; i++)
					{qhtml.append("<tr>");
					for(int j = 0; j < c; j++)
					{
						qhtml.append("<td>a"+(i+1)+(j+1)+"</td>");
					}
					qhtml.append("</tr>");
					}
					
					qhtml.append("</table></td><td> and B = </td>");
					qhtml.append("<td><table border = '1'>");
					for(int i = 0; i < r; i++)
					{qhtml.append("<tr>");
					for(int j = 0; j < c; j++)
					{
						qhtml.append("<td>b"+(i+1)+(j+1)+"</td>");
					}
					qhtml.append("</tr>");
					}
					qhtml.append("</table></td>"+finishHtml);
					String qstr;
					quest.setText(qstr = qhtml.toString());
					
					content.append(filePrefix+"\n"+r+"\n"+c+"\n");
					for(int i = 0; i < r; i++)
					for(int j = 0; j < c; j++)
					{
						msg.setText("Enter Value of a"+(i+1)+(j+1));
						while(!blockedForIO){
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}blockedForIO = false;
						matA[i][j] = Integer.parseInt(txtValue);
						content.append(matA[i][j]+"\n");
						quest.setText(qstr = qstr.toString().replace("a"+(i+1)+(j+1), ""+matA[i][j]));
					}
					
					    for(int i = 0; i < r; i++)
						for(int j = 0; j < c; j++)
						{
							msg.setText("Enter Value of b"+(i+1)+(j+1));
							while(!blockedForIO){
								try {
									Thread.sleep(50);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}blockedForIO = false;
							matB[i][j] = Integer.parseInt(txtValue);
							content.append(matB[i][j]+"\n");
							quest.setText(qstr = qstr.toString().replace("b"+(i+1)+(j+1), ""+matB[i][j])); 
						}
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
				}
				if(qtype.equals("learn"))
				{	
					dirPath = DataInfo.MATRIX_LEARN_QUES_DIR;
					String filePrefix = "sub";
					int r,c,matA[][],matB[][];
					BufferedWriter fwriter;
					qhtml.append("<html><body><table><tr><td>Calculate A - b if A = </td>");
					quest.setText(qhtml.toString()+finishHtml);
					msg.setText("Matrix Dimension, Rows");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					r = Integer.parseInt(txtValue);
					msg.setText("Matrix Dimension, Cols");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					c = Integer.parseInt(txtValue);
					matA = new int[r][c];
					matB = new int[r][c];
					qhtml.append("<td><table border = '1'>");
					for(int i = 0; i < r; i++)
					{qhtml.append("<tr>");
					for(int j = 0; j < c; j++)
					{
						qhtml.append("<td>a"+(i+1)+(j+1)+"</td>");
					}
					qhtml.append("</tr>");
					}
					
					qhtml.append("</table></td><td> and B = </td>");
					qhtml.append("<td><table border = '1'>");
					for(int i = 0; i < r; i++)
					{qhtml.append("<tr>");
					for(int j = 0; j < c; j++)
					{
						qhtml.append("<td>b"+(i+1)+(j+1)+"</td>");
					}
					qhtml.append("</tr>");
					}
					qhtml.append("</table></td>"+finishHtml);
					String qstr;
					quest.setText(qstr = qhtml.toString());
					
					content.append(r+"\n"+c+"\n");
					for(int i = 0; i < r; i++)
					for(int j = 0; j < c; j++)
					{
						msg.setText("Enter Value of a"+(i+1)+(j+1));
						while(!blockedForIO){
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}blockedForIO = false;
						matA[i][j] = Integer.parseInt(txtValue);
						content.append(matA[i][j]+"\n");
						quest.setText(qstr = qstr.toString().replace("a"+(i+1)+(j+1), ""+matA[i][j]));
					}
					
					    for(int i = 0; i < r; i++)
						for(int j = 0; j < c; j++)
						{
							msg.setText("Enter Value of b"+(i+1)+(j+1));
							while(!blockedForIO){
								try {
									Thread.sleep(50);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}blockedForIO = false;
							matB[i][j] = Integer.parseInt(txtValue);
							content.append(matB[i][j]+"\n");
							quest.setText(qstr = qstr.toString().replace("b"+(i+1)+(j+1), ""+matB[i][j])); 
						}
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				}
				
				//Multiplication
				
				if(operation.equals("mul"))
				{
				if(qtype.equals("practise"))
				{
					dirPath = DataInfo.MATRIX_PRAC_QUES_DIR;
					String filePrefix = "mul";
					int r1,c1,r2,c2,matA[][],matB[][];
					BufferedWriter fwriter;
					qhtml.append("<html><body><table><tr><td>Multiply the following Matrices</td>");
					quest.setText(qhtml.toString()+finishHtml);
					msg.setText("Dimension of matrix1, row = ");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					r1 = Integer.parseInt(txtValue);
					msg.setText("Dimension of matrix1, col = ");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					c1 = Integer.parseInt(txtValue);
					msg.setText("Dimension of matrix2, row = ");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					r2 = Integer.parseInt(txtValue);
					msg.setText("Dimension of matrix2, col = ");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					c2 = Integer.parseInt(txtValue);
					matA = new int[r1][c1];
					matB = new int[r2][c2];
					qhtml.append("<td><table border = '1'>");
					for(int i = 0; i < r1; i++)
					{qhtml.append("<tr>");
					for(int j = 0; j < c1; j++)
					{
						qhtml.append("<td>a"+(i+1)+(j+1)+"</td>");
					}
					qhtml.append("</tr>");
					}
					
					qhtml.append("</table></td><td> and </td>");
					qhtml.append("<td><table border = '1'>");
					for(int i = 0; i < r2; i++)
					{qhtml.append("<tr>");
					for(int j = 0; j < c2; j++)
					{
						qhtml.append("<td>b"+(i+1)+(j+1)+"</td>");
					}
					qhtml.append("</tr>");
					}
					qhtml.append("</table></td>"+finishHtml);
					String qstr;
					quest.setText(qstr = qhtml.toString());
					
					content.append(filePrefix+"\n"+r1+"\n"+c1+"\n"+r2+"\n"+c2+"\n");
					for(int i = 0; i < r1; i++)
					for(int j = 0; j < c1; j++)
					{
						msg.setText("Enter Value of a"+(i+1)+(j+1));
						while(!blockedForIO){
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}blockedForIO = false;
						matA[i][j] = Integer.parseInt(txtValue);
						content.append(matA[i][j]+"\n");
						quest.setText(qstr = qstr.toString().replace("a"+(i+1)+(j+1), ""+matA[i][j]));
					}
					
					    for(int i = 0; i < r2; i++)
						for(int j = 0; j < c2; j++)
						{
							msg.setText("Enter Value of b"+(i+1)+(j+1));
							while(!blockedForIO){
								try {
									Thread.sleep(50);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}blockedForIO = false;
							matB[i][j] = Integer.parseInt(txtValue);
							content.append(matB[i][j]+"\n");
							quest.setText(qstr = qstr.toString().replace("b"+(i+1)+(j+1), ""+matB[i][j])); 
						}
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
				}
				if(qtype.equals("learn"))
				{
					dirPath = DataInfo.MATRIX_LEARN_QUES_DIR;
					String filePrefix = "mul";
					int r1,c1,r2,c2,matA[][],matB[][];
					BufferedWriter fwriter;
					qhtml.append("<html><body><table><tr><td>Multiply the following Matrices</td>");
					quest.setText(qhtml.toString()+finishHtml);
					msg.setText("Dimension of matrix1, row = ");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					r1 = Integer.parseInt(txtValue);
					msg.setText("Dimension of matrix1, col = ");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					c1 = Integer.parseInt(txtValue);
					msg.setText("Dimension of matrix2, row = ");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					r2 = Integer.parseInt(txtValue);
					msg.setText("Dimension of matrix2, col = ");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					c2 = Integer.parseInt(txtValue);
					matA = new int[r1][c1];
					matB = new int[r2][c2];
					qhtml.append("<td><table border = '1'>");
					for(int i = 0; i < r1; i++)
					{qhtml.append("<tr>");
					for(int j = 0; j < c1; j++)
					{
						qhtml.append("<td>a"+(i+1)+(j+1)+"</td>");
					}
					qhtml.append("</tr>");
					}
					
					qhtml.append("</table></td><td> and </td>");
					qhtml.append("<td><table border = '1'>");
					for(int i = 0; i < r2; i++)
					{qhtml.append("<tr>");
					for(int j = 0; j < c2; j++)
					{
						qhtml.append("<td>b"+(i+1)+(j+1)+"</td>");
					}
					qhtml.append("</tr>");
					}
					qhtml.append("</table></td>"+finishHtml);
					String qstr;
					quest.setText(qstr = qhtml.toString());
					
					content.append(r1+"\n"+c1+"\n"+r2+"\n"+c2+"\n");
					for(int i = 0; i < r1; i++)
					for(int j = 0; j < c1; j++)
					{
						msg.setText("Enter Value of a"+(i+1)+(j+1));
						while(!blockedForIO){
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}blockedForIO = false;
						matA[i][j] = Integer.parseInt(txtValue);
						content.append(matA[i][j]+"\n");
						quest.setText(qstr = qstr.toString().replace("a"+(i+1)+(j+1), ""+matA[i][j]));
					}
					
					    for(int i = 0; i < r2; i++)
						for(int j = 0; j < c2; j++)
						{
							msg.setText("Enter Value of b"+(i+1)+(j+1));
							while(!blockedForIO){
								try {
									Thread.sleep(50);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}blockedForIO = false;
							matB[i][j] = Integer.parseInt(txtValue);
							content.append(matB[i][j]+"\n");
							quest.setText(qstr = qstr.toString().replace("b"+(i+1)+(j+1), ""+matB[i][j])); 
						}
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				}
				
				//Transpose
				
				if(operation.equals("trans"))
				{
				if(qtype.equals("practise"))
				{
					dirPath = DataInfo.MATRIX_PRAC_QUES_DIR;
					String filePrefix = "trans";
					int r,c,matA[][],matB[][];
					BufferedWriter fwriter;
					qhtml.append("<html><body><table><tr><td>Calculate transpose of </td>");
					quest.setText(qhtml.toString()+finishHtml);
					msg.setText("Matrix Dimension, Rows");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					r = Integer.parseInt(txtValue);
					msg.setText("Matrix Dimension, Cols");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					c = Integer.parseInt(txtValue);
					matA = new int[r][c];
					matB = new int[r][c];
					qhtml.append("<td><table border = '1'>");
					for(int i = 0; i < r; i++)
					{qhtml.append("<tr>");
					for(int j = 0; j < c; j++)
					{
						qhtml.append("<td>a"+(i+1)+(j+1)+"</td>");
					}
					qhtml.append("</tr>");
					}
					
					qhtml.append("</table></td>");
					
					qhtml.append("</table></td>"+finishHtml);
					String qstr;
					quest.setText(qstr = qhtml.toString());
					
					content.append(filePrefix+"\n"+r+"\n"+c+"\n");
					for(int i = 0; i < r; i++)
					for(int j = 0; j < c; j++)
					{
						msg.setText("Enter Value of a"+(i+1)+(j+1));
						while(!blockedForIO){
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}blockedForIO = false;
						matA[i][j] = Integer.parseInt(txtValue);
						content.append(matA[i][j]+"\n");
						quest.setText(qstr = qstr.toString().replace("a"+(i+1)+(j+1), ""+matA[i][j]));
					}
					try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			
				}
				if(qtype.equals("learn"))
				{	
					dirPath = DataInfo.MATRIX_LEARN_QUES_DIR;
					String filePrefix = "trans";
					int r,c,matA[][],matB[][];
					BufferedWriter fwriter;
					qhtml.append("<html><body><table><tr><td>Calculate transpose of </td>");
					quest.setText(qhtml.toString()+finishHtml);
					msg.setText("Matrix Dimension, Rows");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					r = Integer.parseInt(txtValue);
					msg.setText("Matrix Dimension, Cols");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					c = Integer.parseInt(txtValue);
					matA = new int[r][c];
					matB = new int[r][c];
					qhtml.append("<td><table border = '1'>");
					for(int i = 0; i < r; i++)
					{qhtml.append("<tr>");
					for(int j = 0; j < c; j++)
					{
						qhtml.append("<td>a"+(i+1)+(j+1)+"</td>");
					}
					qhtml.append("</tr>");
					}
					
					qhtml.append("</table></td>");
					
					qhtml.append("</table></td>"+finishHtml);
					String qstr;
					quest.setText(qstr = qhtml.toString());
					
					content.append(r+"\n"+c+"\n");
					for(int i = 0; i < r; i++)
					for(int j = 0; j < c; j++)
					{
						msg.setText("Enter Value of a"+(i+1)+(j+1));
						while(!blockedForIO){
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}blockedForIO = false;
						matA[i][j] = Integer.parseInt(txtValue);
						content.append(matA[i][j]+"\n");
						quest.setText(qstr = qstr.toString().replace("a"+(i+1)+(j+1), ""+matA[i][j]));
					}
					try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				}
			
                //Equality
				
				if(operation.equals("equ"))
				{
				if(qtype.equals("practise"))
				{
					dirPath = DataInfo.MATRIX_PRAC_QUES_DIR;
					String filePrefix = "equ";
					int r,c;
					char matA[][],matB[][];
					BufferedWriter fwriter;
					qhtml.append("<html><body><table><tr><td>Find X and Y if</td>");
					quest.setText(qhtml.toString()+finishHtml);
					msg.setText("Matrix Dimension, Rows");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					r = Integer.parseInt(txtValue);
					msg.setText("Matrix Dimension, Cols");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					c = Integer.parseInt(txtValue);
					matA = new char[r][c];
					matB = new char[r][c];
					qhtml.append("<td><table border = '1'>");
					for(int i = 0; i < r; i++)
					{qhtml.append("<tr>");
					for(int j = 0; j < c; j++)
					{
						qhtml.append("<td>a"+(i+1)+(j+1)+"</td>");
					}
					qhtml.append("</tr>");
					}
					
					qhtml.append("</table></td><td> and </td>");
					qhtml.append("<td><table border = '1'>");
					for(int i = 0; i < r; i++)
					{qhtml.append("<tr>");
					for(int j = 0; j < c; j++)
					{
						qhtml.append("<td>b"+(i+1)+(j+1)+"</td>");
					}
					qhtml.append("</tr>");
					}
					qhtml.append("</table></td>"+finishHtml);
					String qstr;
					quest.setText(qstr = qhtml.toString());
					
					content.append(filePrefix+"\n"+r+"\n"+c+"\n");
					for(int i = 0; i < r; i++)
					for(int j = 0; j < c; j++)
					{
						msg.setText("Enter Value of a"+(i+1)+(j+1));
						while(!blockedForIO){
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}blockedForIO = false;
						matA[i][j] = txtValue.charAt(0);
						content.append(matA[i][j]+"\n");
						quest.setText(qstr = qstr.toString().replace("a"+(i+1)+(j+1), ""+matA[i][j]));
					}
					
					    for(int i = 0; i < r; i++)
						for(int j = 0; j < c; j++)
						{
							msg.setText("Enter Value of b"+(i+1)+(j+1));
							while(!blockedForIO){
								try {
									Thread.sleep(50);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}blockedForIO = false;
							matB[i][j] = txtValue.charAt(0);
							content.append(matB[i][j]+"\n");
							quest.setText(qstr = qstr.toString().replace("b"+(i+1)+(j+1), ""+matB[i][j])); 
						}
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
				}
				if(qtype.equals("learn"))
				{	
					dirPath = DataInfo.MATRIX_LEARN_QUES_DIR;
					String filePrefix = "equ";
					int r,c;
					char matA[][],matB[][];
					BufferedWriter fwriter;
					qhtml.append("<html><body><table><tr><td>Find X and Y if</td>");
					quest.setText(qhtml.toString()+finishHtml);
					msg.setText("Matrix Dimension, Rows");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					r = Integer.parseInt(txtValue);
					msg.setText("Matrix Dimension, Cols");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					c = Integer.parseInt(txtValue);
					matA = new char[r][c];
					matB = new char[r][c];
					qhtml.append("<td><table border = '1'>");
					for(int i = 0; i < r; i++)
					{qhtml.append("<tr>");
					for(int j = 0; j < c; j++)
					{
						qhtml.append("<td>a"+(i+1)+(j+1)+"</td>");
					}
					qhtml.append("</tr>");
					}
					
					qhtml.append("</table></td><td> and </td>");
					qhtml.append("<td><table border = '1'>");
					for(int i = 0; i < r; i++)
					{qhtml.append("<tr>");
					for(int j = 0; j < c; j++)
					{
						qhtml.append("<td>b"+(i+1)+(j+1)+"</td>");
					}
					qhtml.append("</tr>");
					}
					qhtml.append("</table></td>"+finishHtml);
					String qstr;
					quest.setText(qstr = qhtml.toString());
					
					content.append(r+"\n"+c+"\n");
					for(int i = 0; i < r; i++)
					for(int j = 0; j < c; j++)
					{
						msg.setText("Enter Value of a"+(i+1)+(j+1));
						while(!blockedForIO){
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}blockedForIO = false;
						matA[i][j] = txtValue.charAt(0);
						content.append(matA[i][j]+"\n");
						quest.setText(qstr = qstr.toString().replace("a"+(i+1)+(j+1), ""+matA[i][j]));
					}
					
					    for(int i = 0; i < r; i++)
						for(int j = 0; j < c; j++)
						{
							msg.setText("Enter Value of b"+(i+1)+(j+1));
							while(!blockedForIO){
								try {
									Thread.sleep(50);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}blockedForIO = false;
							matB[i][j] = txtValue.charAt(0);
							content.append(matB[i][j]+"\n");
							quest.setText(qstr = qstr.toString().replace("b"+(i+1)+(j+1), ""+matB[i][j])); 
						}
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					    
				}
				}
				
                 //Negative
				
				if(operation.equals("neg"))
				{
				if(qtype.equals("practise"))
				{
					dirPath = DataInfo.MATRIX_PRAC_QUES_DIR;
					String filePrefix = "neg";
					int r,c,matA[][],matB[][];
					BufferedWriter fwriter;
					qhtml.append("<html><body><table><tr><td>Calculate negetive of </td>");
					quest.setText(qhtml.toString()+finishHtml);
					msg.setText("Matrix Dimension, Rows");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					r = Integer.parseInt(txtValue);
					msg.setText("Matrix Dimension, Cols");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					c = Integer.parseInt(txtValue);
					matA = new int[r][c];
					matB = new int[r][c];
					qhtml.append("<td><table border = '1'>");
					for(int i = 0; i < r; i++)
					{qhtml.append("<tr>");
					for(int j = 0; j < c; j++)
					{
						qhtml.append("<td>a"+(i+1)+(j+1)+"</td>");
					}
					qhtml.append("</tr>");
					}
					
					qhtml.append("</table></td>");
					
					qhtml.append("</table></td>"+finishHtml);
					String qstr;
					quest.setText(qstr = qhtml.toString());
					
					content.append(filePrefix+"\n"+r+"\n"+c+"\n");
					for(int i = 0; i < r; i++)
					for(int j = 0; j < c; j++)
					{
						msg.setText("Enter Value of a"+(i+1)+(j+1));
						while(!blockedForIO){
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}blockedForIO = false;
						matA[i][j] = Integer.parseInt(txtValue);
						content.append(matA[i][j]+"\n");
						quest.setText(qstr = qstr.toString().replace("a"+(i+1)+(j+1), ""+matA[i][j]));
					}
					try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
				}
				if(qtype.equals("learn"))
				{	
					dirPath = DataInfo.MATRIX_LEARN_QUES_DIR;
					String filePrefix = "neg";
					int r,c,matA[][],matB[][];
					BufferedWriter fwriter;
					qhtml.append("<html><body><table><tr><td>Calculate negetive of </td>");
					quest.setText(qhtml.toString()+finishHtml);
					msg.setText("Matrix Dimension, Rows");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					r = Integer.parseInt(txtValue);
					msg.setText("Matrix Dimension, Cols");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					c = Integer.parseInt(txtValue);
					matA = new int[r][c];
					matB = new int[r][c];
					qhtml.append("<td><table border = '1'>");
					for(int i = 0; i < r; i++)
					{qhtml.append("<tr>");
					for(int j = 0; j < c; j++)
					{
						qhtml.append("<td>a"+(i+1)+(j+1)+"</td>");
					}
					qhtml.append("</tr>");
					}
					
					qhtml.append("</table></td>");
					
					qhtml.append("</table></td>"+finishHtml);
					String qstr;
					quest.setText(qstr = qhtml.toString());
					
					content.append(r+"\n"+c+"\n");
					for(int i = 0; i < r; i++)
					for(int j = 0; j < c; j++)
					{
						msg.setText("Enter Value of a"+(i+1)+(j+1));
						while(!blockedForIO){
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}blockedForIO = false;
						matA[i][j] = Integer.parseInt(txtValue);
						content.append(matA[i][j]+"\n");
						quest.setText(qstr = qstr.toString().replace("a"+(i+1)+(j+1), ""+matA[i][j]));
					}
					try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				}
				
                //Scalar multiplication
				
				if(operation.equals("scmul"))
				{
				if(qtype.equals("practise"))
				{
					dirPath = DataInfo.MATRIX_PRAC_QUES_DIR;
					String filePrefix = "smul";
					int r,c,n,matA[][],matB[][];
					BufferedWriter fwriter;
					qhtml.append("<html><body><table><tr><td>Find scalar multiplication of </td>");
					quest.setText(qhtml.toString()+finishHtml);
					msg.setText("Matrix Dimension, Rows");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					r = Integer.parseInt(txtValue);
					msg.setText("Matrix Dimension, Cols");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					c = Integer.parseInt(txtValue);
					msg.setText("Value of N");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					n = Integer.parseInt(txtValue);
					matA = new int[r][c];
					matB = new int[r][c];
					qhtml.append("<td><table border = '1'>");
					for(int i = 0; i < r; i++)
					{qhtml.append("<tr>");
					for(int j = 0; j < c; j++)
					{
						qhtml.append("<td>a"+(i+1)+(j+1)+"</td>");
					}
					qhtml.append("</tr>");
					}
					
					qhtml.append("</table></td><td> and "+n+"</td>"+finishHtml);

					String qstr;
					quest.setText(qstr = qhtml.toString());
					
					content.append(filePrefix+"\n"+r+"\n"+c+"\n");
					for(int i = 0; i < r; i++)
					for(int j = 0; j < c; j++)
					{
						msg.setText("Enter Value of a"+(i+1)+(j+1));
						while(!blockedForIO){
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}blockedForIO = false;
						matA[i][j] = Integer.parseInt(txtValue);
						content.append(matA[i][j]+"\n");
						quest.setText(qstr = qstr.toString().replace("a"+(i+1)+(j+1), ""+matA[i][j]));
					}
					try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				}
				if(qtype.equals("learn"))
				{	
					//System.out.print("correctly called");
					dirPath = DataInfo.MATRIX_LEARN_QUES_DIR;
					String filePrefix = "smul";
					int r,c,n,matA[][],matB[][];
					BufferedWriter fwriter;
					qhtml.append("<html><body><table><tr><td>Find scalar multiplication of </td>");
					quest.setText(qhtml.toString()+finishHtml);
					msg.setText("Matrix Dimension, Rows");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					r = Integer.parseInt(txtValue);
					msg.setText("Matrix Dimension, Cols");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					c = Integer.parseInt(txtValue);
					msg.setText("Value of N");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					n = Integer.parseInt(txtValue);
					matA = new int[r][c];
					matB = new int[r][c];
					qhtml.append("<td><table border = '1'>");
					for(int i = 0; i < r; i++)
					{qhtml.append("<tr>");
					for(int j = 0; j < c; j++)
					{
						qhtml.append("<td>a"+(i+1)+(j+1)+"</td>");
					}
					qhtml.append("</tr>");
					}
					
					qhtml.append("</table></td><td> and "+n+"</td>"+finishHtml);

					String qstr;
					quest.setText(qstr = qhtml.toString());
					
					content.append(r+"\n"+c+"\n");
					for(int i = 0; i < r; i++)
					for(int j = 0; j < c; j++)
					{
						msg.setText("Enter Value of a"+(i+1)+(j+1));
						while(!blockedForIO){
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}blockedForIO = false;
						matA[i][j] = Integer.parseInt(txtValue);
						content.append(matA[i][j]+"\n");
						quest.setText(qstr = qstr.toString().replace("a"+(i+1)+(j+1), ""+matA[i][j]));
					}
					try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				}
			
			}
			if(topic.equals("algebra"))
			{
				
			}
			//coordinate geometry
			if(topic.equals("cogeo"))
			{
				if(operation.equals("dist"))
				{
				if(qtype.equals("practise"))
				{
					dirPath = DataInfo.COORD_GEO_PRAC_QUES_DIR;
					String filePrefix = "dist";
					int x1,x2,y1,y2;
					BufferedWriter fwriter;
					String qstr;
					qstr = qhtml.append("<html>Find distance between following points A(X<sub>1</sub>, Y<sub>1</sub>) and B(X<sub>2</sub>, Y<sub>2</sub>)</html>").toString();
					quest.setText(qhtml.toString());
					msg.setText("<html>Enter Value for X<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>1</sub>", x1+""));
					msg.setText("<html>Enter Value for Y<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>1</sub>", y1+""));
					msg.setText("<html>Enter Value for X<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>2</sub>", x2+""));
					msg.setText("<html>Enter Value for Y<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>2</sub>", y2+""));
			    		content = new StringBuilder(filePrefix+"\n"+x1+"\n"+y1+"\n"+x2+"\n"+y2+"\n");
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					    
				
					
				}
				if(qtype.equals("learn"))
				{	
					dirPath = DataInfo.COORD_GEO_LEARN_QUES_DIR;
					String filePrefix = "dist";
					int x1,x2,y1,y2;
					BufferedWriter fwriter;
					String qstr;
					qstr = qhtml.append("<html>Find distance between following points A(X<sub>1</sub>, Y<sub>1</sub>) and B(X<sub>2</sub>, Y<sub>2</sub>)</html>").toString();
					quest.setText(qhtml.toString());
					msg.setText("<html>Enter Value for X<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>1</sub>", x1+""));
					msg.setText("<html>Enter Value for Y<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>1</sub>", y1+""));
					msg.setText("<html>Enter Value for X<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>2</sub>", x2+""));
					msg.setText("<html>Enter Value for Y<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>2</sub>", y2+""));
			    		content = new StringBuilder(x1+"\n"+y1+"\n"+x2+"\n"+y2+"\n");
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					    
				}
				}
				
				
				//midpoint
				if(operation.equals("midp"))
				{
				if(qtype.equals("practise"))
				{
					dirPath = DataInfo.COORD_GEO_PRAC_QUES_DIR;
					String filePrefix = "midp";
					int x1,x2,y1,y2;
					BufferedWriter fwriter;
					String qstr;
					qstr = qhtml.append("<html>Find the midpoint of A(X<sub>1</sub>, Y<sub>1</sub>) and B(X<sub>2</sub>, Y<sub>2</sub>)</html>").toString();
					quest.setText(qhtml.toString());
					
					
					msg.setText("<html>Enter Value for X<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>1</sub>", x1+""));
					
					
					msg.setText("<html>Enter Value for Y<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>1</sub>", y1+""));
					msg.setText("<html>Enter Value for X<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>2</sub>", x2+""));
					msg.setText("<html>Enter Value for Y<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>2</sub>", y2+""));
			    		content = new StringBuilder(filePrefix+"\n"+x1+"\n"+y1+"\n"+x2+"\n"+y2+"\n");
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				}
				if(qtype.equals("learn"))
				{	
					dirPath = DataInfo.COORD_GEO_LEARN_QUES_DIR;
					String filePrefix = "midp";
					int x1,x2,y1,y2;
					BufferedWriter fwriter;
					String qstr;
					qstr = qhtml.append("<html>Find the midpoint of A(X<sub>1</sub>, Y<sub>1</sub>) and B(X<sub>2</sub>, Y<sub>2</sub>)</html>").toString();
					quest.setText(qhtml.toString());
					
					
					msg.setText("<html>Enter Value for X<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>1</sub>", x1+""));
					
					
					msg.setText("<html>Enter Value for Y<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>1</sub>", y1+""));
					msg.setText("<html>Enter Value for X<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>2</sub>", x2+""));
					msg.setText("<html>Enter Value for Y<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>2</sub>", y2+""));
			    		content = new StringBuilder(x1+"\n"+y1+"\n"+x2+"\n"+y2+"\n");
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					   	    
					   
				}}
				
				//centroid 
									   	    
					 
				
				if(operation.equals("cent"))
				{
				if(qtype.equals("practise"))
				{
					dirPath = DataInfo.COORD_GEO_PRAC_QUES_DIR;
					String filePrefix = "cent";
					int x1,x2,y1,y2,x3,y3;
					BufferedWriter fwriter;
					String qstr;
					qstr = qhtml.append("<html>Find the centroid of A(X<sub>1</sub>, Y<sub>1</sub>) , B(X<sub>2</sub>, Y<sub>2</sub>) and C(X<sub>3</sub>, Y<sub>3</sub>)</html>").toString();
					quest.setText(qhtml.toString());
					
					
					msg.setText("<html>Enter Value for X<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>1</sub>", x1+""));
					
					
					msg.setText("<html>Enter Value for Y<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>1</sub>", y1+""));
					
					msg.setText("<html>Enter Value for X<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>2</sub>", x2+""));
					
					msg.setText("<html>Enter Value for Y<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>2</sub>", y2+""));
			    	
					msg.setText("<html>Enter Value for X<sub>3</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x3 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>3</sub>", x3+""));
					
					msg.setText("<html>Enter Value for Y<sub>3</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y3 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>2</sub>", y3+""));
			    	
					content = new StringBuilder(filePrefix+"\n"+x1+"\n"+y1+"\n"+x2+"\n"+y2+"\n"+x3+"\n"+y3+"\n");
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				}
				if(qtype.equals("learn"))
				{	
					dirPath = DataInfo.COORD_GEO_LEARN_QUES_DIR;
					String filePrefix = "cent";
					int x1,x2,y1,y2,x3,y3;
					BufferedWriter fwriter;
					String qstr;
					qstr = qhtml.append("<html>Find the centroid of A(X<sub>1</sub>, Y<sub>1</sub>) , B(X<sub>2</sub>, Y<sub>2</sub>) and C(X<sub>3</sub>, Y<sub>3</sub>)</html>").toString();
					quest.setText(qhtml.toString());
					
					
					msg.setText("<html>Enter Value for X<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>1</sub>", x1+""));
					
					
					msg.setText("<html>Enter Value for Y<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>1</sub>", y1+""));
					
					msg.setText("<html>Enter Value for X<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>2</sub>", x2+""));
					
					msg.setText("<html>Enter Value for Y<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>2</sub>", y2+""));
			    	
					msg.setText("<html>Enter Value for X<sub>3</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x3 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>3</sub>", x3+""));
					
					msg.setText("<html>Enter Value for Y<sub>3</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y3 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>3</sub>", y3+""));
			    	
					content = new StringBuilder("\n"+x1+"\n"+y1+"\n"+x2+"\n"+y2+"\n"+x3+"\n"+y3+"\n");
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		   
				}

							
				}
				
				// internal segment 
				
				if(operation.equals("intseg"))
				{
				if(qtype.equals("practise"))
				{
					dirPath = DataInfo.COORD_GEO_PRAC_QUES_DIR;
					String filePrefix = "intseg";
					int x1,x2,y1,y2,l,m;
					BufferedWriter fwriter;
					String qstr;
					qstr = qhtml.append("<html>Find the point p internlly segmented of A(X<sub>1</sub>, Y<sub>1</sub>) and  B(X<sub>2</sub>, Y<sub>2</sub>)in ratio (l:m))</html>").toString();
					quest.setText(qhtml.toString());
					
					
					msg.setText("<html>Enter Value for X<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>1</sub>", x1+""));
					
					
					msg.setText("<html>Enter Value for Y<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>1</sub>", y1+""));
					
					msg.setText("<html>Enter Value for X<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>2</sub>", x2+""));
					
					msg.setText("<html>Enter Value for Y<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>2</sub>", y2+""));
			    	
					msg.setText("<html>Enter Value for l");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					l = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("l", l+""));
					
					msg.setText("<html>Enter Value for m");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					m = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("m", m+""));
			    	
					content = new StringBuilder(filePrefix+"\n"+x1+"\n"+y1+"\n"+x2+"\n"+y2+"\n"+l+"\n"+m+"\n");
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				}
				if(qtype.equals("learn"))
				{	
					dirPath = DataInfo.COORD_GEO_LEARN_QUES_DIR;
					String filePrefix = "intseg";
					int x1,x2,y1,y2,l,m;
					BufferedWriter fwriter;
					String qstr;
					qstr = qhtml.append("<html>Find the point p internally segmented of A(X<sub>1</sub>, Y<sub>1</sub>) and B(X<sub>2</sub>, Y<sub>2</sub>)in ratio (l:m))</html>").toString();
					quest.setText(qhtml.toString());
					
					
					msg.setText("<html>Enter Value for X<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>1</sub>", x1+""));
					
					
					msg.setText("<html>Enter Value for Y<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>1</sub>", y1+""));
					
					msg.setText("<html>Enter Value for X<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>2</sub>", x2+""));
					
					msg.setText("<html>Enter Value for Y<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>2</sub>", y2+""));
			    	
					msg.setText("<html>Enter Value for l");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					l= Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("l", l+""));
					
					msg.setText("<html>Enter Value for m");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					m = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("m", m+""));
			    	
					content = new StringBuilder("\n"+x1+"\n"+y1+"\n"+x2+"\n"+y2+"\n"+l+"\n"+m+"\n");
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		   
				}

							
				}
				
				// external segment 
				
				if(operation.equals("extseg"))
				{
				if(qtype.equals("practise"))
				{
					dirPath = DataInfo.COORD_GEO_PRAC_QUES_DIR;
					String filePrefix = "extseg";
					int x1,x2,y1,y2,l,m;
					BufferedWriter fwriter;
					String qstr;
					qstr = qhtml.append("<html>Find the point p externlly segmented of A(X<sub>1</sub>, Y<sub>1</sub>) and  B(X<sub>2</sub>, Y<sub>2</sub>)in ratio (l:m))</html>").toString();
					quest.setText(qhtml.toString());
					
					
					msg.setText("<html>Enter Value for X<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>1</sub>", x1+""));
					
					
					msg.setText("<html>Enter Value for Y<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>1</sub>", y1+""));
					
					msg.setText("<html>Enter Value for X<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>2</sub>", x2+""));
					
					msg.setText("<html>Enter Value for Y<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>2</sub>", y2+""));
			    	
					msg.setText("<html>Enter Value for l");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					l = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("l", l+""));
					
					msg.setText("<html>Enter Value for m");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					m = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("m", m+""));
			    	
					content = new StringBuilder(filePrefix+"\n"+x1+"\n"+y1+"\n"+x2+"\n"+y2+"\n"+l+"\n"+m+"\n");
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				}
				if(qtype.equals("learn"))
				{	
					dirPath = DataInfo.COORD_GEO_LEARN_QUES_DIR;
					String filePrefix = "extseg";
					int x1,x2,y1,y2,l,m;
					BufferedWriter fwriter;
					String qstr;
					qstr = qhtml.append("<html>Find the point p externally segmented of A(X<sub>1</sub>, Y<sub>1</sub>) and B(X<sub>2</sub>, Y<sub>2</sub>)in ratio (l:m))</html>").toString();
					quest.setText(qhtml.toString());
					
					
					msg.setText("<html>Enter Value for X<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>1</sub>", x1+""));
					
					
					msg.setText("<html>Enter Value for Y<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>1</sub>", y1+""));
					
					msg.setText("<html>Enter Value for X<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>2</sub>", x2+""));
					
					msg.setText("<html>Enter Value for Y<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>2</sub>", y2+""));
			    	
					msg.setText("<html>Enter Value for l");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					l= Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("l", l+""));
					
					msg.setText("<html>Enter Value for m");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					m = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("m", m+""));
			    	
					content = new StringBuilder("\n"+x1+"\n"+y1+"\n"+x2+"\n"+y2+"\n"+l+"\n"+m+"\n");
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		   
				}}
				//Area of triangle
				
		 
				
				if(operation.equals("area"))
				{
				if(qtype.equals("practise"))
				{
					dirPath = DataInfo.COORD_GEO_PRAC_QUES_DIR;
					String filePrefix = "cent";
					int x1,x2,y1,y2,x3,y3;
					BufferedWriter fwriter;
					String qstr;
					qstr = qhtml.append("<html>Find the area of triangle A(X<sub>1</sub>, Y<sub>1</sub>) , B(X<sub>2</sub>, Y<sub>2</sub>) and C(X<sub>3</sub>, Y<sub>3</sub>)</html>").toString();
					quest.setText(qhtml.toString());
					
					
					msg.setText("<html>Enter Value for X<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>1</sub>", x1+""));
					
					
					msg.setText("<html>Enter Value for Y<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>1</sub>", y1+""));
					
					msg.setText("<html>Enter Value for X<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>2</sub>", x2+""));
					
					msg.setText("<html>Enter Value for Y<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>2</sub>", y2+""));
			    	
					msg.setText("<html>Enter Value for X<sub>3</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x3 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>3</sub>", x3+""));
					
					msg.setText("<html>Enter Value for Y<sub>3</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y3 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>2</sub>", y3+""));
			    	
					content = new StringBuilder(filePrefix+"\n"+x1+"\n"+y1+"\n"+x2+"\n"+y2+"\n"+x3+"\n"+y3+"\n");
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				}
				if(qtype.equals("learn"))
				{	
					dirPath = DataInfo.COORD_GEO_LEARN_QUES_DIR;
					String filePrefix = "area";
					int x1,x2,y1,y2,x3,y3;
					BufferedWriter fwriter;
					String qstr;
					qstr = qhtml.append("<html>Find the area of triangle ABC,  A(X<sub>1</sub>, Y<sub>1</sub>) , B(X<sub>2</sub>, Y<sub>2</sub>) and C(X<sub>3</sub>, Y<sub>3</sub>)</html>").toString();
					quest.setText(qhtml.toString());
					
					
					msg.setText("<html>Enter Value for X<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>1</sub>", x1+""));
					
					
					msg.setText("<html>Enter Value for Y<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>1</sub>", y1+""));
					
					msg.setText("<html>Enter Value for X<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>2</sub>", x2+""));
					
					msg.setText("<html>Enter Value for Y<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>2</sub>", y2+""));
			    	
					msg.setText("<html>Enter Value for X<sub>3</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x3 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>3</sub>", x3+""));
					
					msg.setText("<html>Enter Value for Y<sub>3</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y3 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>3</sub>", y3+""));
			    	
					content = new StringBuilder("\n"+x1+"\n"+y1+"\n"+x2+"\n"+y2+"\n"+x3+"\n"+y3+"\n");
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		   
				}							
				}
				//slope angle form 
				if(operation.equals("slopeang"))
				{
				if(qtype.equals("practise"))
				{
					dirPath = DataInfo.COORD_GEO_PRAC_QUES_DIR;
					String filePrefix = "slopeang";
					int x;
					BufferedWriter fwriter;
					String qstr;
					qstr = qhtml.append("<html>Find the slope of the line </html>").toString();
					quest.setText(qhtml.toString());
					
					
					msg.setText("<html>Enter Value for l");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X", x+""));
					
					
						content = new StringBuilder(filePrefix+"\n"+x+"\n");
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				}
				if(qtype.equals("learn"))
				{	
					dirPath = DataInfo.COORD_GEO_LEARN_QUES_DIR;
					String filePrefix = "slopeang";
					int x;
					BufferedWriter fwriter;
					String qstr;
					qstr = qhtml.append("<html>Find the slope of line</html>").toString();
					quest.setText(qhtml.toString());
					
					
					msg.setText("<html>Enter Value for x");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X", x+""));
						content = new StringBuilder(x+"\n"+"\n");
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					   	    
					   
				}}
				
				//slope two point
				if(operation.equals("slopetwopoint"))
				{
				if(qtype.equals("practise"))
				{
					dirPath = DataInfo.COORD_GEO_PRAC_QUES_DIR;
					String filePrefix = "slopetwopoint";
					int x1,x2,y1,y2;
					BufferedWriter fwriter;
					String qstr;
					qstr = qhtml.append("<html>Find the slope of line AB where A(X<sub>1</sub>, Y<sub>1</sub>) and B(X<sub>2</sub>, Y<sub>2</sub>)</html>").toString();
					quest.setText(qhtml.toString());
					
					
					msg.setText("<html>Enter Value for X<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>1</sub>", x1+""));
					
					
					msg.setText("<html>Enter Value for Y<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>1</sub>", y1+""));
					msg.setText("<html>Enter Value for X<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>2</sub>", x2+""));
					msg.setText("<html>Enter Value for Y<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>2</sub>", y2+""));
			    		content = new StringBuilder(filePrefix+"\n"+x1+"\n"+y1+"\n"+x2+"\n"+y2+"\n");
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				}
				if(qtype.equals("learn"))
				{	
					dirPath = DataInfo.COORD_GEO_LEARN_QUES_DIR;
					String filePrefix = "slopetwopoint";
					int x1,x2,y1,y2;
					BufferedWriter fwriter;
					String qstr;
					qstr = qhtml.append("<html>Find the slope of AB where A(X<sub>1</sub>, Y<sub>1</sub>) and B(X<sub>2</sub>, Y<sub>2</sub>)</html>").toString();
					quest.setText(qhtml.toString());
					
					
					msg.setText("<html>Enter Value for X<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>1</sub>", x1+""));
					
					
					msg.setText("<html>Enter Value for Y<sub>1</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y1 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>1</sub>", y1+""));
					msg.setText("<html>Enter Value for X<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					x2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("X<sub>2</sub>", x2+""));
					msg.setText("<html>Enter Value for Y<sub>2</sub>");
					while(!blockedForIO){
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}blockedForIO = false;
					y2 = Integer.parseInt(txtValue);
					quest.setText(qstr = qstr.replace("Y<sub>2</sub>", y2+""));
			    		content = new StringBuilder(x1+"\n"+y1+"\n"+x2+"\n"+y2+"\n");
					    try {
						    AddQuestions.content = content.toString();
						    AddQuestions.f = new File(dirPath+filePrefix+new Date().getTime()+".ma");
						    save.setEnabled(true);
						    value.setEditable(false);
					    } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					   	    
					   
				}}



				

			}		
	}
}
