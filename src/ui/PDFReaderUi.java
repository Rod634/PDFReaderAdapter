package ui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PDFReaderUi extends JFrame implements ActionListener{
	
	private ImageIcon img;
	private JPanel panel;
	private JLabel imgLabel;
	private JButton avancar;
	private JButton voltar;
	private int actualPage = 0;
	private int size;
	private BufferedImage[] images;
	private JLabel label;
	
	public PDFReaderUi(BufferedImage[] images) {
		
		this.images = images;
		
		this.size = images.length;
		
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setTitle("PDF Reader");
		getContentPane().setLayout(null);
		
		this.panel = new JPanel();
		this.panel.setBackground(Color.WHITE);
		this.panel.setBounds(0, 0, 591, 800);
		getContentPane().add(this.panel);
		this.panel.setLayout(null);
		
		this.img = new ImageIcon(images[actualPage]);
		this.imgLabel = new JLabel("");
		this.imgLabel.setBounds(0, 0, 591, 800);
		this.panel.add(this.imgLabel);
		this.imgLabel.setIcon(img);
		
		
		this.voltar = new JButton("Voltar");
		this.voltar.addActionListener(this);
		this.voltar.setBounds(163, 820, 97, 25);
		getContentPane().add(this.voltar);
		
		this.avancar = new JButton("Avan\u00E7ar");
		this.avancar.addActionListener(this);
		this.avancar.setBounds(337, 820, 97, 25);
		getContentPane().add(this.avancar);
		
		this.label = new JLabel("1/" + size);
		this.label.setVerticalAlignment(SwingConstants.BOTTOM);
		this.label.setBounds(283, 820, 34, 16);
		getContentPane().add(this.label);
		
		this.setSize(600, 900);
		this.setVisible(true);
	}
	
	private void changePage(int index) {
		this.panel.remove(imgLabel);
		this.img = new ImageIcon(this.images[index]);
		this.imgLabel = new JLabel("");
		this.imgLabel.setBounds(0, 0, 591, 800);
		this.imgLabel.setIcon(img);
		this.panel.add(imgLabel);
		this.label.setText(index + 1 + " / " + size);
		
		this.revalidate();
		this.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == avancar) {
			if(actualPage < size - 1) {
				actualPage++;
				changePage(actualPage);
			}
		}else if(e.getSource() == voltar) {
			if(actualPage > 0) {
				actualPage--;
				changePage(actualPage);
			}
		}
	}

	
}
