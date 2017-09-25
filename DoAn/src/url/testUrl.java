package url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.Content;

public class testUrl {

	
	public static void main(String[] args) {
		String link ="http://rongbay.com/TP-HCM/O-to-c19.html";
		URL url;
		String content="";
		String check = "";
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
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		int kt = 0, last = -1;
		int kt1=0,kt2=0;
		do{
			kt = content.indexOf("@", last+1);
			if(kt != -1)
			{
				kt1=kt-1;
				kt2=kt+1;
				while(ktra(content.charAt(kt1)))
				{
					kt1--;
				}
				while(ktra(content.charAt(kt2)))
				{
					kt2++;
				}
				String email = content.substring(kt1+1, kt2);
				if(KtEmail(email))
				{
					//System.out.println(email);
					al1.add(email);	// lưu tất cả các email 
				}
				last=kt+1;
			}
			
		}while(kt != -1);
		al2 = remove(al1); 
		for (String str2 : al2) {
			System.out.println(str2);
		}
	}
	public static ArrayList remove(ArrayList arrList) // hàm xóa email trùng
	{
	    HashSet h = new HashSet(arrList);
	    arrList.clear();
	    arrList.addAll(h);	   
	    return arrList;
	                   
	}
	private static ArrayList<String> kttrung(ArrayList<String> arr1)
	{
		boolean trung = false;
		ArrayList<String> arr2 = new ArrayList<String>();
		for (String str1 : arr1) {
			for (String str2 : arr2) {
				if(str1.equals(str2))
				{
					trung = true;
				}
				
			}
			if(trung==false)
			{
				arr2.add(str1);
			}
			
		}
		
		return arr2;
	}
	private static boolean ktra(char charAt) {
		// TODO Auto-generated method stub
		String s = new String();
		s = charAt + "";
		boolean a = s.matches("[_A-Za-z0-9.]");
		return a;
	}

	private static boolean KtEmail(String s)
	{	
		boolean a = s.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		//boolean a = s.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "gmail.com"); // kt gmail
		return a;
	}
	private static boolean ktra(String s)
	{
		boolean a = s.matches("[_A-Za-z0-9.]");
		return a;
	}
	
	

}
