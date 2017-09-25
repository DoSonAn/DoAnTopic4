package tool;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JToolBar;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.TextArea;

public class tools {

	private JFrame frame;
	private JButton btnNewButton;
	private JTextField textField;
	String email;
	String link;
	private TextArea textArea;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tools window = new tools();
					window.frame.setVisible(true);
					window.frame.setResizable(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public tools() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		// frame.setVisible(true);
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.setBackground(SystemColor.inactiveCaption);
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 546, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		menuBar.setBackground(SystemColor.scrollbar);
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Quản lý");
		menuBar.add(mnNewMenu);

		JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("Xuất file");
		mnNewMenu.add(chckbxmntmNewCheckItem);

		JCheckBoxMenuItem chckbxmntmNewCheckItem_1 = new JCheckBoxMenuItem("Exit");
		mnNewMenu.add(chckbxmntmNewCheckItem_1);

		JMenu mnNewMenu_1 = new JMenu("Chức nang");
		menuBar.add(mnNewMenu_1);

		JCheckBoxMenuItem chckbxmntmNewCheckItem_2 = new JCheckBoxMenuItem("Lọc mail trùng");
		mnNewMenu_1.add(chckbxmntmNewCheckItem_2);

		JMenu mnNewMenu_2 = new JMenu("About");
		menuBar.add(mnNewMenu_2);
		frame.getContentPane().setLayout(null);

		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(SystemColor.scrollbar);
		toolBar.setBounds(0, -2, 530, 32);
		frame.getContentPane().add(toolBar);

		btnNewButton = new JButton("Lấy mail");
		btnNewButton.setIcon(new ImageIcon("img/play.png"));

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String link ="https://sites.google.com/site/huynhhoc/";
				link = textField.getText();
//				if (textField==null){
//					JOptionPane.showMessageDialog(null,"Chua nh?p URL !!");
//				}
//				
				
				URL url;
				String content="";
//				String check = "";
				
				try {
					
					url = new URL(link);
					URLConnection connection = url.openConnection();
					InputStream inputstream = connection.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(inputstream));
					String line = br.readLine();
					
					while(line!=null)
					{
						content = content + line;
						line = br.readLine();
						
						
					}
					br.close();
				} catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
				
				textArea.selectAll();
				textArea.setText("");
				int kt = 0, last = -1;
				int kt1=0,kt2=0;
				do{
					kt = content.indexOf("@", last+1);
					if(kt != -1)
					{
						kt1=kt-1;
						kt2=kt+1;
						while(ktra1(content.charAt(kt1)))
						{
							kt1--;
						}
						while(ktra1(content.charAt(kt2)))
						{
							kt2++;
						}
						String email = content.substring(kt1+1, kt2);
						if(ktraemail(email))
						{
							textArea.append(email+"\n");
						}
						last=kt+1;
					}
					
				}while(kt != -1);
				
			}

		});
		btnNewButton.setBackground(SystemColor.scrollbar);
		toolBar.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Lấy số điện thoại");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link = textField.getText();
				URL url;
				String content="";
				try {
					
					url = new URL(link);
					URLConnection connection = url.openConnection();
					InputStream inputstream = connection.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(inputstream));
					String line = br.readLine();
					
					while(line!=null)
					{
						content = content + line;
						line = br.readLine();
						
						
					}
					br.close();
				} catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
				
				textArea.selectAll();
				textArea.setText("");
				
				int kt = 0, last = -1;
				int kt1=0,kt2=0;
				do{
					kt = content.indexOf("0", last+1);
					if(kt != -1)
					{
						kt1=kt-1;
						kt2=kt+1;
						
						while(ktra2(content.charAt(kt1)))
						{
							kt1--;
						}
						while(ktra2(content.charAt(kt2)))
						{
							kt2++;
						}
						String phone = content.substring(kt1+1, kt2);
						if(ktphonevt10(phone))
						{
							textArea.append("Số Viettel 10 so :\t"+phone+"\n");
						}
						if(ktphonevt11(phone))
						{
							textArea.append("Số Viettel 11 so :\t"+phone+"\n");
						}
						if(ktphonemb10(phone))
						{
							textArea.append("Số Mobifone 10 so :\t"+phone+"\n");
						}
						if(ktphonemb11(phone))
						{
							textArea.append("Số Mobifone 11 so :\t"+phone+"\n");
						}
						if(ktphonevn10(phone))
						{
							textArea.append("Số vinaphone 10 so :\t"+phone+"\n");
						}
						if(ktphonevn11(phone))
						{
							textArea.append("Số Vinaphone 11 so :\t"+phone+"\n");
						}
						
						if(ktphonevnm10(phone))
						{
							textArea.append("Số Vietnamobile 10 so :\t"+phone+"\n");
						}
						if(ktphonevnm11(phone))
						{
							textArea.append("Số Vietnamobile 11 so :\t"+phone+"\n");
						}
						if(ktphoneg10(phone))
						{
							textArea.append("Số Gmobie 10 so :\t"+phone+"\n");
						}
						
						last=kt+1;
					}
					
				}while(kt != -1);
				
			}
		});
		btnNewButton_1.setBackground(SystemColor.scrollbar);
		btnNewButton_1.setIcon(new ImageIcon("img/Phone.png"));
		toolBar.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Xuất ra tập tin");
		btnNewButton_2.setBackground(SystemColor.scrollbar);
		btnNewButton_2.setIcon(new ImageIcon("img/saveicon.png"));
		toolBar.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Lọc email trùng ");
		btnNewButton_3.setBackground(SystemColor.scrollbar);
		btnNewButton_3.setIcon(new ImageIcon("img/loc.png"));
		toolBar.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Reset");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");			
				textArea.selectAll();
				textArea.setText("");
			}
		});
		btnNewButton_4.setBackground(SystemColor.scrollbar);
		btnNewButton_4.setIcon(new ImageIcon("img/xoa.png"));
		toolBar.add(btnNewButton_4);

		JLabel lblNhpUrl = new JLabel("Nhập url :");
		lblNhpUrl.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNhpUrl.setBounds(10, 41, 80, 21);
		frame.getContentPane().add(lblNhpUrl);

		textField = new JTextField();
		textField.setBounds(89, 42, 431, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 73, 530, 2);
		frame.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 32, 530, 2);
		frame.getContentPane().add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(2, -2, 530, 21);
		frame.getContentPane().add(separator_2);

		textArea = new TextArea();
		textArea.setBounds(10, 80, 510, 150);
		frame.getContentPane().add(textArea);
	}

	private static boolean ktra1(char charAt) {
		// TODO Auto-generated method stub
		String s = new String();
		s = charAt + "";
		boolean a = s.matches("[_A-Za-z0-9.]");
		return a;
	}

	private static boolean ktraemail(String s) {
		boolean a = s.matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		return a;
	}
	private static boolean ktra2(char charAt) {
		// TODO Auto-generated method stub
		String s = new String();
		s = charAt + "";
		boolean a = s.matches("[0-9]");
		return a;
	}

	private static boolean ktphonevt10(String s)
	{	
		boolean a = s.matches("^(09[678])[0-9]{7}$");
		return a;
	}
	private static boolean ktphonevt11(String s)
	{	
		boolean a = s.matches("^(016[23456789])[0-9]{7}$");
		return a;
	}
	private static boolean ktphonemb10(String s)
	{	
		boolean a = s.matches("^(09[03])[0-9]{7}$");
		return a;
	}
	private static boolean ktphonemb11(String s)
	{	
		boolean a = s.matches("^(012[01268])[0-9]{7}$");
		return a;
	}
	
	private static boolean ktphonevn10(String s)
	{	
		boolean a = s.matches("^(09[14])[0-9]{7}$");
		return a;
	}
	private static boolean ktphonevn11(String s)
	{	
		boolean a = s.matches("^(012[34579])[0-9]{7}$");
		return a;
	}
	
	private static boolean ktphonevnm10(String s)
	{	
		boolean a = s.matches("^(092)[0-9]{7}$");
		return a;
	}
	private static boolean ktphonevnm11(String s)
	{	
		boolean a = s.matches("^(018[68])[0-9]{7}$");
		return a;
	}
	
	private static boolean ktphoneg10(String s)
	{	
		boolean a = s.matches("^(099|0199)[0-9]{6,7}$");
		return a;
	}
	public static ArrayList remove(ArrayList arrList)
	{
	    HashSet h = new HashSet(arrList);
	    arrList.clear();
	    arrList.addAll(h);
	   
	    return arrList;
	                   
	}
	
}
