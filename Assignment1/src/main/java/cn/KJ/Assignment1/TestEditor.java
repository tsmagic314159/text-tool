package cn.KJ.Assignment1;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TestEditor {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Text Editor");
		JMenuBar bar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu search = new JMenu("Search");
		JMenu view = new JMenu("View");
		JMenu manage = new JMenu("Manage");
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
		bar.add(manage);
		bar.add(about);
		bar.setPreferredSize(new Dimension(-5,40));
		frame.setJMenuBar(bar);
		
		frame.setSize(800,500);
		frame.setVisible(true);
		
		
		// TODO Auto-generated method stub

	}

}
