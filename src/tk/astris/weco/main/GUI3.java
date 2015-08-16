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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class GUI3 extends JFrame {

	private JPanel contentPane;

	public GUI3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		final JRadioButton rdbtnIAccept = new JRadioButton("I accept");
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GUI2_1 gui = new GUI2_1();
				gui.setVisible(true);
				dispose();
				
			}
		});
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnIAccept.isSelected()){
					GUI4 gui = new GUI4();
					gui.setVisible(true);
					dispose();
				}
				
			}
		});
		
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
					.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(rdbtnIAccept)
					.addContainerGap())
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnIAccept)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
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
		
		for(String s : MainModInstallerTemplate.legalInformation){
			System.out.println(s);
			textArea.append(s + "\n");
		}
		
		
		
	}
}
