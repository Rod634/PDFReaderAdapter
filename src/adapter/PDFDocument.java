package adapter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import target.IDocument;
import ui.PDFReaderUi;
import util.MyPDFRender;

public class PDFDocument implements IDocument{
	
	private BufferedImage[] images;
	
	public PDFDocument() {
	}

	@Override
	public void open(File file) throws IOException {
		PDDocument doc = PDDocument.load(file);
		PDFRenderer renderer = new MyPDFRender(doc);
		
		this.images = new BufferedImage[doc.getNumberOfPages()];
		
		for(int i = 0; i < doc.getNumberOfPages(); i++) {
			this.images[i] = renderer.renderImage(i);
		}
        doc.close();
	}


	@Override
	public JFrame getEditor() {
		return new PDFReaderUi(images);
	}
}
