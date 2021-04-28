package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import logic.Logica;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.io.File;
import java.io.IOException;


public class InitialUi extends JFrame {
	
	private JButton abrirArquivo;
	private Logica logic;
	
	public InitialUi() {
		
		this.logic = new Logica();
		InitializeUi();
	}

	private void InitializeUi()  {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 432, 253);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PDF Reader");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(152, 29, 135, 61);
		panel.add(lblNewLabel);
		
		this.abrirArquivo = new JButton("Abrir arquivo");
		this.abrirArquivo.setBounds(161, 141, 115, 38);
		panel.add(this.abrirArquivo);
		
		this.abrirArquivo.addActionListener(e ->
		{
		    JFileChooser escolha = new JFileChooser();
		    escolha.setAcceptAllFileFilterUsed(false);
	        FileNameExtensionFilter filter = new FileNameExtensionFilter("Escolha um arquivo em pdf", "pdf");
	        escolha.addChoosableFileFilter(filter);

		    int valid = escolha.showOpenDialog(null);

		    if (valid == JFileChooser.APPROVE_OPTION) {
	    		String path = escolha.getSelectedFile().getAbsolutePath();

	    		File f = new File(path);
	  		  	if(!f.exists() && f.isDirectory()) { 
	  		  		JOptionPane.showMessageDialog(null, "Esse arquivo não existe");
	  		  	}else {
	  		  		try {
						logic.LoadPlugins(f);
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| IOException e1) {
						
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
	  		  	}
		    }
		});
		
		this.setSize(450, 300);
		this.setVisible(true);
	}
}
