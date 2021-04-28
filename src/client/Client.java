package client;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import target.IDocument;

public class Client implements IDocument {
	
	IDocument adapter;
	
	public Client(IDocument adapter) {
		this.adapter = adapter;
	}

	@Override
	public void open(File file) throws IOException {
		adapter.open(file);
	}

	@Override
	public JFrame getEditor() {
		return adapter.getEditor();
	}

}
