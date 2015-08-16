package tk.astris.weco.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class GUI1 extends JFrame {

	private JPanel contentPane;

	public GUI1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Installer");
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GUI2_1 gui = new GUI2_1();
				gui.setVisible(true);
				dispose();
				
			}
		});
		
		JLabel lblYouWillInstall = new JLabel("You will install the following File(s):");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWelcomeToThe))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
					.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblYouWillInstall)
					.addContainerGap(249, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWelcomeToThe)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblYouWillInstall)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnNext)))
		);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
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
		
		for(String s : MainModInstallerTemplate.fileNames){
			textArea.append(s + "\n");
		}
		
	}
}
