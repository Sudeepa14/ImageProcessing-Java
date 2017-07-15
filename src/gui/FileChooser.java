package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;

public class FileChooser extends JFrame {

	private JPanel contentPane;
	private FileNameExtensionFilter filter;
	private File file;
	private JFileChooser jchooser;

	public FileChooser(String title,String fileType ) {
	
		//JChooser 
		JFileChooser fileChooser = new JFileChooser(); 
		this.jchooser=fileChooser;
		int returnValue = this.jchooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			file = this.jchooser.getSelectedFile();
			System.out.println(file.getAbsolutePath());
		}
		
		//set the title
				fileChooser.setDialogTitle(title);
		
		//filter only images
		if(fileType=="image"){
		     filter = new FileNameExtensionFilter(
			        "JPG & GIF Images", "jpg", "gif");
		     fileChooser.setFileFilter(filter);
		     this.file=fileChooser.getSelectedFile();
		}
		
		
		//select a folder
		else if(fileType=="folder"){
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.setAcceptAllFileFilterUsed(false);
			this.file=fileChooser.getSelectedFile();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(fileChooser, BorderLayout.NORTH);
	}
	public File getFile(){
		return file;
	}
	public void setFile(){
		int returnValue = this.jchooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = this.jchooser.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
		}
	}
	
}
