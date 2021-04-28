package util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

public class MyPDFRender extends PDFRenderer{
	
	public MyPDFRender(PDDocument document)
    {
        super(document);
    }
}
