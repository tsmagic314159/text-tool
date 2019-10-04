package cn.KJ.Assignment1;

import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
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

public class TestEditor {
	static int times=0;
	static ArrayList<Integer> searchList = new ArrayList<Integer>();
	
	public static void main(String[] args) {

		JFrame frame = new JFrame("Text Editor");
		JMenuBar bar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu search = new JMenu("Search");
		JMenu print = new JMenu("Print");
		JMenu currentDate = new JMenu("Date");
		JMenu about = new JMenu("About");
		
		JMenuItem printitem = new JMenuItem("print");
		JMenuItem newitem = new JMenuItem("New");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem searchword = new JMenuItem("Search");
		
		file.add(newitem);
		file.add(open);
		file.add(save);
		file.add(printitem);
		search.add(searchword);
		
		bar.add(file);
		bar.add(search);
		bar.add(print);
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
