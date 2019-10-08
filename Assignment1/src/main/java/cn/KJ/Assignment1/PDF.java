package cn.KJ.Assignment1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

public class PDF {
	public static void writePdf(File file, String text) throws DocumentException, FileNotFoundException {
		Document doc = new Document(PageSize.A4,50,50,50,50);
		PdfWriter.getInstance(doc, new FileOutputStream(file.getPath()+file.getName()+".pdf"));
		doc.open();
		doc.add(new Paragraph(text));
		doc.close();
	}
}
