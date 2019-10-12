package cn.KJ.Assignment1;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hwpf.extractor.WordExtractor;

public class odt {
	public static String doc2String(FileInputStream fs) throws IOException {
		StringBuilder result = new StringBuilder();
		WordExtractor re = new WordExtractor(fs);
		result.append(re.getText());
		re.close();
		return result.toString();
	}
	public static String doc2String(File file) throws IOException {
		return doc2String(new FileInputStream(file));
	}
	
}
