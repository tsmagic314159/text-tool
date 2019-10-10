package cn.KJ.Assignment1;
<<<<<<< HEAD
=======

>>>>>>> KYY
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

<<<<<<< HEAD
import com.itextpdf.text.*;
=======
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
>>>>>>> KYY
import com.itextpdf.text.pdf.PdfWriter;

public class PDF {
	public static void writePdf(File file, String text) throws DocumentException, FileNotFoundException {
		Document doc = new Document(PageSize.A4,50,50,50,50);
<<<<<<< HEAD
		PdfWriter.getInstance(doc, new FileOutputStream(file.getPath()+file.getName()+".pdf"));
=======
		PdfWriter.getInstance(doc, new FileOutputStream(file.getPath()+".pdf"));
>>>>>>> KYY
		doc.open();
		doc.add(new Paragraph(text));
		doc.close();
	}
}
