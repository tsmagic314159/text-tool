package cn.KJ.Assignment1;

import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TestEditor {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Text Editor");
		JMenuBar bar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu search = new JMenu("Search");
		JMenu view = new JMenu("View");
		JMenu currentDate = new JMenu("Date");
		JMenu about = new JMenu("About");
		
		JMenuItem printitem = new JMenuItem("print");
		JMenuItem newitem = new JMenuItem("New");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem open = new JMenuItem("Open");
		
		file.add(newitem);
		file.add(open);
		file.add(save);
		file.add(printitem);
		
		bar.add(file);
		bar.add(search);
		bar.add(view);
		bar.add(currentDate);
		bar.add(about);
		
		bar.setPreferredSize(new Dimension(-5,40));
		frame.setJMenuBar(bar);
		JTextArea area = new JTextArea();
		area.setLineWrap(true);
		JScrollPane scrollbar = new JScrollPane(area);
		scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollbar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.add(scrollbar);
		
		frame.setSize(800,500);
		frame.setVisible(true);
		FileDialog openDia = new FileDialog( frame, "Open", FileDialog.LOAD);
		FileDialog saveDia = new FileDialog(frame, "Save", FileDialog.SAVE);
		
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
				saveit.setFilename(saveDia.getFile()+".txt");
				try {
					saveit.SaveFile(area.getText().replaceAll("\n", "\r\n"));
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(frame, "file not found!");
					e1.printStackTrace();
				}
			}
		});
		

	}

}
