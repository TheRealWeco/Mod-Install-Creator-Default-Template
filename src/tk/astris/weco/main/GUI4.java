package tk.astris.weco.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class GUI4 extends JFrame {

	private JPanel contentPane;

	public GUI4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblInstallationProgress = new JLabel("Installation Progress");
		
		final JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		
		final JButton btnFinish = new JButton("Install");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(btnFinish.getText().equals("Install")){
				if(MainModInstallerTemplate.comp1.exists()){
			        String[] cmd = {MainModInstallerTemplate.comp1.toString()};
			        Process p;
					try {
						p = Runtime.getRuntime().exec(cmd);
				        p.waitFor();
					} catch (IOException e2) {
						e2.printStackTrace();
					} catch (InterruptedException e2) {
						e2.printStackTrace();
					}
					progressBar.setValue(progressBar.getValue() + 25);
					MainModInstallerTemplate.comp1.delete();
					
				}
				
				if(MainModInstallerTemplate.comp2.exists()){
			        String[] cmd = {MainModInstallerTemplate.comp2.toString()};
			        Process p;
					try {
						p = Runtime.getRuntime().exec(cmd);
				        p.waitFor();
					} catch (IOException e2) {
						e2.printStackTrace();
					} catch (InterruptedException e2) {
						e2.printStackTrace();
					}
					progressBar.setValue(progressBar.getValue() + 25);
					MainModInstallerTemplate.comp2.delete();
				}
				
				for(String s : MainModInstallerTemplate.fileNames){
					
				try {
					Files.copy(getClass().getResourceAsStream(s), new File(MainModInstallerTemplate.mcMods, s).toPath(), StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				}
				
				MainModInstallerTemplate.dir.delete();
				
				while(progressBar.getValue() != 100){
					progressBar.setValue(progressBar.getValue() + 1);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				
				btnFinish.setText("Finish");
				
				}else{
					
					if(MainModInstallerTemplate.launch){
				        String[] cmd = {"java", "-jar", MainModInstallerTemplate.mcLauncher.toString()};
				        Process p;
						try {
							p = Runtime.getRuntime().exec(cmd);
							setVisible(false);
							p.waitFor();
						} catch (IOException e2) {
							e2.printStackTrace();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
					
					System.exit(0);
					
				}
				
				
				
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblInstallationProgress)
					.addContainerGap())
				.addComponent(btnFinish, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblInstallationProgress)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
					.addComponent(btnFinish))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		
		setTitle(MainModInstallerTemplate.name);
		if(MainModInstallerTemplate.icon != null){
			BufferedImage myImg;
			try {
				myImg = ImageIO.read(MainModInstallerTemplate.icon);
				setIconImage(myImg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		
		
		
	}
}
