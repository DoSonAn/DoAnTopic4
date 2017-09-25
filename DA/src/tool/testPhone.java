package tool;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class testPhone {

	public static void main(String[] args) {
		String link ="http://simviettel.com/sim-luc-quy-mang-mobifone.html";
		URL url;
		String content="";
		String check = "";
		
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
//		System.out.println("10 số !!!");
		do{
			kt = content.indexOf("0", last+1);
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
				String phone = content.substring(kt1+1, kt2);
				
				if(ktphonevt10(phone))
				{
					System.out.println("Số viettel 10 số :"+phone);
					//System.out.println(phone);
				}
				if(ktphonevt11(phone))
				{
					System.out.println("Số viettel 11 số :"+phone);
					//System.out.println(phone);
				}
				if(ktphonemb10(phone))
				{
					System.out.println("Số mobifone 10 số :"+phone);
					//System.out.println(phone);
				}
				if(ktphonemb11(phone))
				{
					System.out.println("Số mobifone 11 số :"+phone);
					//System.out.println(phone);
				}
				last=kt+1;
			}
			
		}while(kt != -1);
		
		
		
//		int k1 = 0, l1 = -1;
//		int kt11=0,kt21=0;
//		System.out.println("11 số !!!");
//		do{
//			k1 = content.indexOf("0", l1+1);
//			if(k1 != -1)
//			{
//				kt11=kt1-1;
//				kt21=kt1+1;
//				
//				while(ktra(content.charAt(kt11)))
//				{
//					kt11--;
//				}
//				while(ktra(content.charAt(kt21)))
//				{
//					kt21++;
//				}
//				String phone = content.substring(kt11+1, kt21);
//				
//				if(ktphonevt11(phone))
//				{
//					
//					System.out.println(phone);
//				}
//				l1=k1+1;
//			}
//			
//		}while(k1 != -1);
	}
	
	private static boolean ktra(char charAt) {
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

}
