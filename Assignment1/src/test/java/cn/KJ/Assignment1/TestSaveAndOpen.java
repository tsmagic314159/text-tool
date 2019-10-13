package cn.KJ.Assignment1;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class TestSaveAndOpen {

	Functions func = new Functions();
	File file = new File("text.txt");
	
	
	@Before
	public void setup() {
		
		
		func.setDirpath(".");
		func.setFilename(file.getName());
	}

	@Test
	public void testSave() throws IOException {
		String test = "";
		func.SaveFile("qwe");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while ((line = reader.readLine())!=null) {
			test+=line;
		}
		reader.close();
		assertTrue(test.equals("qwe"));
	}
	
	@Test
	public void testOpen() throws IOException {
		String test2 = func.OpenFile();
		assertTrue(test2.equals("qwe\r\n"));
	}

}
