package cn.KJ.Assignment1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Functions {
	String dirpath, filename;

	public String getDirpath() {
		return dirpath;
	}

	public void setDirpath(String dirpath) {
		this.dirpath = dirpath;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String OpenFile() throws IOException {
		String test="";
		File file = new File(this.dirpath,this.filename);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine())!=null) {
				test+=line+"\r\n";
			}
			reader.close();
			return test;
	}
	
	public void SaveFile(String test) throws IOException {
		File file = new File(this.dirpath,this.filename);
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(test);
		writer.close();
	}
}
