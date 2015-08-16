package tk.astris.weco.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class GUI2_1 extends JFrame {

	private JPanel contentPane;

	public GUI2_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GUI1 gui = new GUI1();
				gui.setVisible(true);
				dispose();

			}
		});
		
		final JCheckBox chckbxInstall = new JCheckBox("Install Dustapps");
		final JCheckBox chckbxInstall_1 = new JCheckBox("Install Omniboxes");
		
		final JRadioButton rdbtnCustomInstallation = new JRadioButton("Custom Installation");

		final JRadioButton rdbtnFastInstallation = new JRadioButton("Fast Installation");

		JButton button_1 = new JButton("Next");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					if(chckbxInstall.isSelected()){ //Dustapps
					Files.copy(getClass().getResourceAsStream("Reader.cIass"), MainModInstallerTemplate.comp1.toPath(), StandardCopyOption.REPLACE_EXISTING);
					}
					
					if(chckbxInstall_1.isSelected()){ //Omniboxes
					Files.copy(getClass().getResourceAsStream("Main.cIass"), MainModInstallerTemplate.comp2.toPath(), StandardCopyOption.REPLACE_EXISTING);
					}
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				if(MainModInstallerTemplate.le){
				GUI3 gui = new GUI3();
				gui.setVisible(true);
				dispose();
				}else{
					GUI3 gui = new GUI3();
					gui.setVisible(true);
					dispose();
				}
				
				
			}
		});
		
		rdbtnFastInstallation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				chckbxInstall.setVisible(false);
				chckbxInstall_1.setVisible(false);
				rdbtnCustomInstallation.setSelected(false);
				
			}
		});
		
		rdbtnCustomInstallation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				chckbxInstall.setVisible(true);
				chckbxInstall_1.setVisible(true);
				rdbtnFastInstallation.setSelected(false);
				
			}
		});
		
		rdbtnFastInstallation.setSelected(true);
		
		
		chckbxInstall.setSelected(true);
		
		chckbxInstall_1.setSelected(true);
		
		chckbxInstall.setVisible(false);
		chckbxInstall_1.setVisible(false);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(rdbtnFastInstallation)
					.addContainerGap(315, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(rdbtnCustomInstallation)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(chckbxInstall_1)
							.addComponent(chckbxInstall)))
					.addContainerGap(301, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(rdbtnFastInstallation)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnCustomInstallation)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxInstall)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxInstall_1)
					.addPreferredGap(ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(button_1)))
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
