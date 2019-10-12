package cn.KJ.Assignment1;




import java.io.FileInputStream;


import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;


public class pdf2string {
	public static String GetTextFromPdf(String filename) throws Exception {
		         
		  String content = null;    
		           PDDocument pdfdocument = null;
		           
		           FileInputStream is = new FileInputStream(filename);
		           PDFParser parser = new PDFParser(is);
		           
		           parser.parse();        
		           pdfdocument = parser.getPDDocument();     
		           PDFTextStripper stripper = new PDFTextStripper();
		            content = stripper.getText(pdfdocument);
		            return content;    
		            } 

	}
