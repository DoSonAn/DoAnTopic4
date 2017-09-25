package tool;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Box;
import javax.swing.JToolBar;
import javax.swing.JButton;

public class tls {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tls window = new tls();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public tls() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("Xuất\r\n\r\n");
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Quản lý");
		menuBar.add(mnNewMenu);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("Xuất FILE");
		mnNewMenu.add(chckbxmntmNewCheckItem);
		
		JCheckBoxMenuItem chckbxmntmExit = new JCheckBoxMenuItem("Exit");
		mnNewMenu.add(chckbxmntmExit);
		
		JMenu mnChcNng = new JMenu("Chức năng");
		menuBar.add(mnChcNng);
		
		JMenu menu = new JMenu("New menu");
		mnChcNng.add(menu);
		
		JToolBar toolBar = new JToolBar();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(224, Short.MAX_VALUE))
		);
		
		JButton btnNewButton = new JButton("Lấy mail");
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Lấy phone");
		toolBar.add(btnNewButton_1);
		frame.getContentPane().setLayout(groupLayout);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
