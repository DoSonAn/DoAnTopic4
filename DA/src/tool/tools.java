package tool;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
import javax.swing.JMenuItem;

import java.awt.Frame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Cursor;

public class tools {

	private JFrame frmTruyXutWebsite;
	private JButton btnNewButton;
	private JTextField txtNhpaCh;
	String email;
	String phone;
	String str2;
	String link;
	private TextArea textArea;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tools window = new tools();
					window.frmTruyXutWebsite.setVisible(true);
					window.frmTruyXutWebsite.setResizable(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

//		String link = "https://sites.google.com/site/huynhhoc/";
//		URL url;
//		String content = "";
//		
//
//		try {
//
//			url = new URL(link);
//			URLConnection connection = url.openConnection();
//			InputStream inputstream = connection.getInputStream();
//			BufferedReader br = new BufferedReader(new InputStreamReader(inputstream));
//			String line = br.readLine();
//
//			while (line != null) {
//				content = content + line;
//				line = br.readLine();
//
//			}
//			br.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}

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
		
		frmTruyXutWebsite = new JFrame();
		frmTruyXutWebsite.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmTruyXutWebsite.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTruyXutWebsite.setState(Frame.ICONIFIED);
		
		
		frmTruyXutWebsite.setLocationByPlatform(true);
		frmTruyXutWebsite.setTitle("Truy xuất website");
		frmTruyXutWebsite.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmTruyXutWebsite.setBackground(SystemColor.inactiveCaption);
		frmTruyXutWebsite.getContentPane().setBackground(SystemColor.menu);
		frmTruyXutWebsite.setBounds(100, 100, 650,450);
		frmTruyXutWebsite.setResizable(false);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		menuBar.setBackground(SystemColor.menu);
		frmTruyXutWebsite.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Quản lý");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmXutFile = new JMenuItem("Xuất file");
		mntmXutFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
//					File f=new File("output.txt");
					FileOutputStream fos=new FileOutputStream("output.txt",false);
					PrintWriter pw = new PrintWriter(fos);
					pw.println(textArea.getText());
					
//					FileWriter fw= new FileWriter(f);
//					fw.write(email);
//					fw.write(textArea.getText());
//					fw.flush();
					textArea.selectAll();
					textArea.setText("Đã ghi vào file OUTPUT.TXT");
//					fw.close();
					pw.close();
				}catch(IOException ex){
					textArea.append("Lỗi ghi file !!");
				}
			}
		});
		mnNewMenu.add(mntmXutFile);
		
		JMenuItem mntmExit = new JMenuItem("Thoát");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmExit);

		JMenu mnNewMenu_1 = new JMenu("Chức năng");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnLcSin = new JMenu("Lọc số điện thoại");
		mnLcSin.setFocusable(false);
		mnNewMenu_1.add(mnLcSin);
		
		JMenuItem mntmLcSin = new JMenuItem("Lọc số điện thoại trùng");
		mntmLcSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link = txtNhpaCh.getText();			
				
				URL url;
				String content="";
				ArrayList<String> al1 = new ArrayList<String>();
				ArrayList<String> al2 = new ArrayList<String>();
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
							al1.add(phone);
//							textArea.append("\t"+phone+"\n");
						}
						if(ktphonevt11(phone))
						{
							al1.add(phone);
//							textArea.append("\t"+phone+"\n");
						}
						if(ktphonemb10(phone))
						{
//							textArea.append("\t"+phone+"\n");
							al1.add(phone);
						}
						if(ktphonemb11(phone))
						{
//							textArea.append("\t"+phone+"\n");
							al1.add(phone);
						}
						if(ktphonevn10(phone))
						{
//							textArea.append("\t"+phone+"\n");
							al1.add(phone);
						}
						if(ktphonevn11(phone))
						{
//							textArea.append("\t"+phone+"\n");
							al1.add(phone);
						}
						
						if(ktphonevnm10(phone))
						{
//							textArea.append("\t"+phone+"\n");
							al1.add(phone);
						}
						if(ktphonevnm11(phone))
						{
//							textArea.append("\t"+phone+"\n");
							al1.add(phone);
						}
						if(ktphoneg10(phone))
						{
//							textArea.append("\t"+phone+"\n");
							al1.add(phone);
						}
						
						last=kt+1;
					}
					
				}while(kt != -1);
				al2 = remove(al1);
				for (String str2 : al2) {
//					System.out.println(str2);
					textArea.append("\t"+str2+"\n");
				}
			}
		});
		mnLcSin.add(mntmLcSin);
		
		JMenuItem mntmLcSViettel = new JMenuItem("Lọc số Viettel");
		mnLcSin.add(mntmLcSViettel);
		
		JMenuItem mntmLcSMobifone = new JMenuItem("Lọc số Mobifone");
		mnLcSin.add(mntmLcSMobifone);
		
		JMenuItem mntmLcSVinanphone = new JMenuItem("Lọc số Vinaphone");
		mnLcSin.add(mntmLcSVinanphone);
		
		JMenuItem mntmLcSVietnam = new JMenuItem("Lọc số Vietnamobile");
		mnLcSin.add(mntmLcSVietnam);
		
		JMenuItem mntmLcSGphone = new JMenuItem("Lọc số Gmobile");
		mnLcSin.add(mntmLcSGphone);
		
		JMenu mnLcMail = new JMenu("Lọc mail");
		mnNewMenu_1.add(mnLcMail);
		
		JMenuItem mntmLcMailTrng = new JMenuItem("Lọc mail trùng");
		mntmLcMailTrng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				link = txtNhpaCh.getText();			
				
				URL url;
				String content="";
				ArrayList<String> al1 = new ArrayList<String>();
				ArrayList<String> al2 = new ArrayList<String>(); 
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
							//System.out.println(email);
							al1.add(email);	// lưu tất cả các email 
						}
						last=kt+1;
					}
					
				}while(kt != -1);
				al2 = remove(al1); 
				for (String str2 : al2) {
//					System.out.println(str2);
					textArea.append("\t"+str2+"\n");
				}
			
			
			}
		});
		mnLcMail.add(mntmLcMailTrng);
		
		JMenuItem mntmLcGmail = new JMenuItem("Lọc Gmail");
		mnLcMail.add(mntmLcGmail);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Lọc Yahoo Mail");
		mnLcMail.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link = txtNhpaCh.getText();			
				
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
						if(ktrayahoomail(email))
						{
							textArea.append(email+"\n");
						}
						if(ktrayahoomail2(email))
						{
							textArea.append("\t"+email+"\n");
						}
						
						last=kt+1;
					}
//					else
//					{
//						textArea.append("Không tìm thấy địa chỉ mail nào !!");
//					}
					
				}while(kt != -1);
			}
		});
		mntmLcGmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				link = txtNhpaCh.getText();			
				
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
						if(ktragmail(email))
						{
							textArea.append("\t"+email+"\n");
						}
					
						last=kt+1;
					}
//					else
//					{
//						textArea.append("Không tìm thấy địa chỉ mail nào !!");
//					}
				}while(kt != -1);
				
			
			}
		});
		mntmLcSGphone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link = txtNhpaCh.getText();
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
				ArrayList<String> al1 = new ArrayList<String>();
				ArrayList<String> al2 = new ArrayList<String>();
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
						if(ktphoneg10(phone))
						{
//							textArea.append("Số Gmobie 10 so :\t"+phone+"\n");
							al1.add(phone);
						}
						
						last=kt+1;
					}
//					else 
//					{
//						textArea.append("Không tìm thấy số Gmobile nào !!");
//					}
				}while(kt != -1);
				al2 = remove(al1);
				for (String str2 : al2) {
//					System.out.println(str2);
					textArea.append("Số Gmobie 10 so :\t"+str2+"\n");
				}
			}
		});
		mntmLcSVietnam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link = txtNhpaCh.getText();
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
				ArrayList<String> al1 = new ArrayList<String>();
				ArrayList<String> al2 = new ArrayList<String>();
				ArrayList<String> al3 = new ArrayList<String>();
				ArrayList<String> al4 = new ArrayList<String>();
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
						if(ktphonevnm10(phone))
						{
//							textArea.append("Số Vietnamobile 10 so :\t"+phone+"\n");
							al1.add(phone);
						}
						if(ktphonevnm11(phone))
						{
							al2.add(phone);
//							textArea.append("Số Vietnamobile 11 so :\t"+phone+"\n");
						}
						last=kt+1;
					}
//					else 
//					{
//						textArea.append("Không tìm thấy số vietnamobile nào !!");
//					}
				}while(kt != -1);
				al3 = remove(al1);
				al4 =remove (al2);
				for (String str2 : al3) {
					textArea.append("Số Vietnamobile 10 so :\t"+str2+"\n");
				}
				for (String str3: al4){
					textArea.append("Số Vietnamobile 11 so :\t"+str3+"\n");
				}
			}
		});
		mntmLcSVinanphone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link = txtNhpaCh.getText();
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
				ArrayList<String> al1 = new ArrayList<String>();
				ArrayList<String> al2 = new ArrayList<String>();
				ArrayList<String> al3 = new ArrayList<String>();
				ArrayList<String> al4 = new ArrayList<String>();
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
						if(ktphonevn10(phone))
						{
							al1.add(phone);
//							textArea.append("Số Vinaphone 10 so :\t"+phone+"\n");
						}
						if(ktphonevn11(phone))
						{
							al2.add(phone);
//							textArea.append("Số Vinaphone 11 so :\t"+phone+"\n");
						}
						last=kt+1;
					}
//					else 
//					{
//						textArea.append("Không tìm thấy số vinaphone nào !!");
//					}
				}while(kt != -1);
				al3 = remove(al1);
				al4 =remove (al2);
				for (String str2 : al3) {
					textArea.append("Số Vinaphone 10 so :\t"+str2+"\n");
				}
				for (String str3: al4){
					textArea.append("Số Vinaphone 11 so :\t"+str3+"\n");
				}
			}
		});
		mntmLcSMobifone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link = txtNhpaCh.getText();
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
				ArrayList<String> al1 = new ArrayList<String>();
				ArrayList<String> al2 = new ArrayList<String>();
				ArrayList<String> al3 = new ArrayList<String>();
				ArrayList<String> al4 = new ArrayList<String>();
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
						if(ktphonemb10(phone))
						{
							al1.add(phone);
//							textArea.append("Số Mobifone 10 so :\t"+phone+"\n");
						}
						if(ktphonemb11(phone))
						{
							al2.add(phone);
//							textArea.append("Số Mobifone 11 so :\t"+phone+"\n");
						}
						last=kt+1;
					}
//					else 
//					{
//						textArea.append("Không tìm thấy số mobifone nào !!");
//					}
				}while(kt != -1);
				al3 = remove(al1);
				al4 =remove (al2);
				for (String str2 : al3) {
					textArea.append("Số Mobifone 10 so :\t"+str2+"\n");
				}
				for (String str3: al4){
					textArea.append("Số Mobifone 11 so :\t"+str3+"\n");
				}
			}
		});
		mntmLcSViettel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link = txtNhpaCh.getText();
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
				ArrayList<String> al1 = new ArrayList<String>();
				ArrayList<String> al2 = new ArrayList<String>();
				ArrayList<String> al3 = new ArrayList<String>();
				ArrayList<String> al4 = new ArrayList<String>();
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
							al1.add(phone);
//							textArea.append("Số Viettel 10 so :\t"+phone+"\n");
						}
						if(ktphonevt11(phone))
						{
							al2.add(phone);
//							textArea.append("Số Viettel 11 so :\t"+phone+"\n");
						}
						
						last=kt+1;
					}
//					else 
//					{
//						textArea.append("Không tìm thấy số viettel nào !!");
//					}
				}while(kt != -1);
				al3 = remove(al1);
				al4 =remove (al2);
				for (String str2 : al3) {
					textArea.append("Số Viettel 10 so :\t"+str2+"\n");
				}
				for (String str3: al4){
					textArea.append("Số Viettel 11 so :\t"+str3+"\n");
				}
				
			}
		});

		JMenu mnNewMenu_2 = new JMenu("About");
		menuBar.add(mnNewMenu_2);

		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(SystemColor.control);

		btnNewButton = new JButton("Lấy mail");
		btnNewButton.setIcon(new ImageIcon("img/play.png"));

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				link = txtNhpaCh.getText();			
				
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
							textArea.append("\t"+email+"\n");
						}
//						else
//						{
//							textArea.append("Không tìm thấy địa chỉ mail nào !!");
//						}
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
				link = txtNhpaCh.getText();
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
							textArea.append("\t"+phone+"\n");
						}
						if(ktphonevt11(phone))
						{
							textArea.append("\t"+phone+"\n");
						}
						if(ktphonemb10(phone))
						{
							textArea.append("\t"+phone+"\n");
						}
						if(ktphonemb11(phone))
						{
							textArea.append("\t"+phone+"\n");
						}
						if(ktphonevn10(phone))
						{
							textArea.append("\t"+phone+"\n");
						}
						if(ktphonevn11(phone))
						{
							textArea.append("\t"+phone+"\n");
						}
						
						if(ktphonevnm10(phone))
						{
							textArea.append("\t"+phone+"\n");
						}
						if(ktphonevnm11(phone))
						{
							textArea.append("\t"+phone+"\n");
						}
						if(ktphoneg10(phone))
						{
							textArea.append("\t"+phone+"\n");
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
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
//					File f=new File("output.txt");
					FileOutputStream fos=new FileOutputStream("output.txt",false);
					PrintWriter pw = new PrintWriter(fos);
					pw.println(textArea.getText());
					
//					FileWriter fw= new FileWriter(f);
//					fw.write(email);
//					fw.write(textArea.getText());
//					fw.flush();
					textArea.selectAll();
					textArea.setText("Đã ghi vào file OUTPUT.TXT");
//					fw.close();
					pw.close();
				}catch(IOException ex){
					textArea.append("Lỗi ghi file !!");
				}
			}
		});
		
		JButton btnLyHnhnh = new JButton("Lấy hình ảnh");
		btnLyHnhnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link = txtNhpaCh.getText();					
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
					kt = content.indexOf("@", last+1);
					if(kt != -1)
					{
						kt1=kt-1;
						kt2=kt+1;
						while(ktra3(content.charAt(kt1)))
						{
							kt1--;
						}
						while(ktra3(content.charAt(kt2)))
						{
							kt2++;
						}
						String img = content.substring(kt1+1, kt2);
						if(ktimg(img))
						{
							textArea.append("\t"+img+"\n");

						}
						last=kt+1;
					}
					
				}while(kt != -1);
			}
		});
		btnLyHnhnh.setBackground(SystemColor.scrollbar);
		btnLyHnhnh.setIcon(new ImageIcon("img/if_button_38_61409.png"));
		toolBar.add(btnLyHnhnh);
		btnNewButton_2.setBackground(SystemColor.scrollbar);
		btnNewButton_2.setIcon(new ImageIcon("img/saveicon.png"));
		toolBar.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Lọc email trùng ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link = txtNhpaCh.getText();			
				
				URL url;
				String content="";
				ArrayList<String> al1 = new ArrayList<String>();// mảng lưu tất cả các email
				ArrayList<String> al2 = new ArrayList<String>(); // mảng lưu những email đã lọc ra
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
							//System.out.println(email);
							al1.add(email);	// lưu tất cả các email 
						}
						last=kt+1;
					}
					
				}while(kt != -1);
				al2 = remove(al1); 
				for (String str2 : al2) {
//					System.out.println(str2);
					textArea.append("\t"+str2+"\n");
				}
				
			}
		});
		btnNewButton_3.setBackground(SystemColor.scrollbar);
		btnNewButton_3.setIcon(new ImageIcon("img/loc.png"));
		toolBar.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Reset");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNhpaCh.setText("");			
				textArea.selectAll();
				textArea.setText("");
			}
		});
		btnNewButton_4.setBackground(SystemColor.scrollbar);
		btnNewButton_4.setIcon(new ImageIcon("img/xoa.png"));
		toolBar.add(btnNewButton_4);

		JLabel lblNhpUrl = new JLabel("Nhập url :");
		lblNhpUrl.setFont(new Font("Tahoma", Font.BOLD, 14));

		txtNhpaCh = new JTextField();
		txtNhpaCh.setToolTipText("");
		txtNhpaCh.setColumns(10);

		JSeparator separator = new JSeparator();

		JSeparator separator_1 = new JSeparator();

		JSeparator separator_2 = new JSeparator();

		textArea = new TextArea();
		textArea.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textArea.setEditable(false);
		GroupLayout groupLayout = new GroupLayout(frmTruyXutWebsite.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(separator_2, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addComponent(lblNhpUrl, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtNhpaCh, GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
					.addGap(59))
				.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
				.addComponent(separator, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
					.addGap(10))
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNhpUrl, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNhpaCh, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
					.addGap(19))
		);
		frmTruyXutWebsite.getContentPane().setLayout(groupLayout);
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
	
	private static boolean ktragmail(String s) {
		boolean a = s.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "gmail.com");
		return a;
	}
	private static boolean ktrayahoomail(String s) {
		boolean a = s.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "yahoo.com.vn");
		return a;
	}
	private static boolean ktrayahoomail2(String s) {
		boolean a = s.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "yahoo.com");
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
	private static boolean ktra3(char charAt) {
		// TODO Auto-generated method stub
		String s = new String();
		s = charAt + "";
		boolean a = s.matches("[a-zA-z0-9]");
		return a;
	}
	private static boolean ktimg(String s)
	{	
		boolean a = s.matches("<img.*?src=[\"](?<src>.*?)[\"](.*/>?)");
		return a;
	}
	public static ArrayList<String> remove(ArrayList<String> arrList) // hàm xóa  trùng
	{
		 HashSet<String> h = new HashSet<String>(arrList);
		    arrList.clear();
		    arrList.addAll(h);
		   
		    return arrList;
	                   
	}
}
