package cn.KJ.Assignment1;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.DocumentException;

public class TestEditor implements Printable {
	static int times=0;
	static ArrayList<Integer> searchList = new ArrayList<Integer>();
	static JTextPane area = new JTextPane();
	public static void main(String[] args) {

		JFrame frame = new JFrame("Text Editor");
		JMenuBar bar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu search = new JMenu("Search");
		JMenu currentDate = new JMenu("Date");
		JMenu scpc = new JMenu("SCPC");
		JMenu about = new JMenu("About");
		JMenuItem printitem = new JMenuItem("print");
		JMenuItem newitem = new JMenuItem("New");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem searchword = new JMenuItem("Search");
		JMenuItem save2PDF = new JMenuItem("Save as PDF");
		JMenuItem date = new JMenuItem("date");
		JMenuItem cut = new JMenuItem("Cut");
		JMenuItem copy = new JMenuItem("Copy");
		JMenuItem paste = new JMenuItem("Paste");
		JMenuItem select = new JMenuItem("Select");
		JMenuItem aboutus = new JMenuItem("About Us");
		
		
		file.add(newitem);
		file.add(open);
		file.add(save);
		file.add(printitem);
		file.add(save2PDF);
		search.add(searchword);
		about.add(aboutus);

		
		bar.add(file);
		bar.add(search);

		bar.add(currentDate);
		bar.add(scpc);

		bar.add(about);
		
		currentDate.add(date);
		
		scpc.add(select);
		scpc.add(cut);
		scpc.add(copy);
		scpc.add(paste);
		
		
		bar.setPreferredSize(new Dimension(-5,40));
		frame.setJMenuBar(bar);
		
//		area.setLineWrap(true);
		JScrollPane scrollbar = new JScrollPane(area);
		scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollbar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.add(scrollbar);

		frame.setSize(800,500);
		frame.setVisible(true);
		FileDialog openDia = new FileDialog( frame, "Open", FileDialog.LOAD);
		FileDialog saveDia = new FileDialog(frame, "Save", FileDialog.SAVE);
		JFileChooser pdfSaver = new JFileChooser();
		pdfSaver.setFileFilter(new FileNameExtensionFilter("pdf", ".pdf"));

		
		JFrame searchFrame = new JFrame("Search");
		JPanel searchPanel = new JPanel();
		searchPanel.add(new JLabel("Enter the key word:"));
		JTextField searchField = new JTextField(20);
		searchPanel.add(searchField);
		JButton next = new JButton("next match");
		JButton confirm = new JButton("Confirm");
		searchPanel.add(confirm);
		searchPanel.add(next);
		searchFrame.add(searchPanel);
		searchFrame.setSize(400, 200);
		
		
		JFrame aboutframe = new JFrame("About Us");
		JPanel aboutpanel = new JPanel();
		aboutpanel.add(new JLabel("NZ172 Kang Yuyang 19023466"));
		aboutpanel.add(new JLabel("NZ172 Jia Yimin 19023460"));
		aboutframe.add(aboutpanel);
		aboutframe.setSize(300, 200);


		
		newitem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("");
				
				
			}
		});
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openDia.setVisible(true);
				Functions openit = new Functions();
				openit.setDirpath(openDia.getDirectory());
				openit.setFilename(openDia.getFile());
				try {
					String test = openit.OpenFile();
					area.setText(test);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(frame, "file not found!");
					e1.printStackTrace();
				}
			}
		});
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveDia.setVisible(true);
				Functions saveit = new Functions();
				saveit.setDirpath(saveDia.getDirectory());
				saveit.setFilename(saveDia.getFile());
				try {
					saveit.SaveFile(area.getText().replaceAll("\n", "\r\n"));
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(frame, "file not found!");
					e1.printStackTrace();
				}
			}
		});
		searchword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				searchFrame.setVisible(true);
				searchList.clear();
				times=0;
			}
		});
		
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String key = searchField.getText().toLowerCase();
				String text = area.getText();
				searchList = searchItem(key, text);
				times=0;
				if (searchList.size()==0) {
					JOptionPane.showMessageDialog(searchFrame, "No matches");
				}
				else {
					area.select(searchList.get(times), searchList.get(times)+key.length());
				}
			}
		});
		
		
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String key = searchField.getText().toLowerCase();
				String text = area.getText();
				searchList = searchItem(key, text);
				times=0;
				if (searchList.size()==0) {
					JOptionPane.showMessageDialog(searchFrame, "No matches");
				}
				else {
					area.select(searchList.get(times), searchList.get(times)+key.length());
				}
			}
		});
		
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String key = searchField.getText().toLowerCase();
				if (searchList.size()==0) {
					JOptionPane.showMessageDialog(searchFrame, "No matches");
				}
				else {
					times+=1;
					if (times>(searchList.size()-1)) {
						times=0;
						area.select(searchList.get(times), searchList.get(times)+key.length());
					}
					else {
						
						area.select(searchList.get(times), searchList.get(times)+key.length());
					}
				}
				
			}
		});
		
		save2PDF.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pdfSaver.showDialog(frame, "save as a pdf");
				File file = pdfSaver.getSelectedFile();
				try {
					PDF.writePdf(file, area.getText());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		select.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				area.selectAll();
			}
			
		});
		
		
		
		cut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				area.cut();
			}
			
		});
		
		
		copy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				area.copy();
			}
			
		});
		
		
		paste.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				area.paste();
			}
			
		});
		
		date.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = sdf.format(new Date());
				JPanel tp = new JPanel();
				tp.setLayout(new FlowLayout());
				JTextField tt = new JTextField(20);
				tt.setText(time);
				tp.add(tt);
				
				frame.add(tp,BorderLayout.NORTH);
				frame.validate();
			}
			
		});
		

        aboutus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				aboutframe.setVisible(true);
				searchList.clear();
				times=0;
			}
		});

        
		printitem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PrinterJob job = PrinterJob.getPrinterJob(); 
				job.setPrintable(new TestEditor());
				try {
					
					if (!job.printDialog())
						return; 
					    job.setJobName(" ");
						job.print();
					}
				 catch (PrinterException e1) {
					e1.printStackTrace();
				}
		
				}
			
		});



	

	}


	public int print(Graphics graphics, PageFormat pf, int pn) throws PrinterException {
    	
	      String str = area.getText(); 
	      Graphics2D g2 = (Graphics2D) graphics;
	      g2.setColor(Color.black);
	      double x = pf.getImageableX();
	      double y = pf.getImageableY();	       
	      switch(pn){
	         case 0:
	           Font ft = new Font("Serif", Font.BOLD, 10);
	           g2.setFont(ft);
	           float[] dh   = {5.0f}; 
	           g2.setStroke(new   BasicStroke(0.3f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 5.0f, dh, 0.0f));
	           g2.drawString(str, (float)x, (float)y + ft.getSize2D());	          
	         return PAGE_EXISTS;
	      }
		return pn;
	      
	   }
	
	
	
	
	public static ArrayList<Integer> searchItem(String key, String text) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j<key.length(); j++) {
				if(!(text.charAt(i+j)==key.charAt(j))) {
					break;
				}
				else {
					if (j==key.length()-1) {
						a.add(i);
					}
				}
			}
		}
		return a;
	}
	

	}


