package cn.KJ.Assignment1;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import fr.opensagres.xdocreport.converter.ConverterRegistry;
import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.IConverter;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.converter.XDocConverterException;
import fr.opensagres.xdocreport.core.document.DocumentKind;

public class odt {
	public static void odt2pdf(String file) throws FileNotFoundException, XDocConverterException {
		Options options = Options.getFrom(DocumentKind.ODT).to(ConverterTypeTo.PDF);
		IConverter converter = ConverterRegistry.getRegistry().getConverter(options);
		InputStream in= new FileInputStream(new File(file));
		OutputStream out = new FileOutputStream(new File("erw.pdf"));
		converter.convert(in, out, options);
	}
	
}
