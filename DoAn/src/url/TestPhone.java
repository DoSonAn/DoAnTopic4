package url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPhone {

	public static void main(String[] args) {
		
		
		
		
		String link ="https://www.thegioididong.com/sim-so-dep?trang=2";
		URL url;
		String content="";
		String check = "";
		String patter= "[0-9]{10,11}";
		
		ArrayList<String> al1 = new ArrayList<String>(); // mảng lưu tất cả các sđt
		ArrayList<String> al2 = new ArrayList<String>(); // mảng lưu những sđt đã lọc ra
		try {  // đọc url
			
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
		}   // hết đọc url
		
		//System.out.println(content);
		
		
		
		int kt = 0, last = -1;
		int kt1=0,kt2=0;
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
				String email = content.substring(kt1+1, kt2);
				if(KtEmail(email))
				{
					//System.out.println(email);
					al1.add(email);// lưu tất cả các sđt 
				}
				last=kt+1;
			}
			
		}while(kt != -1);
		al2 = remove(al1);
		for (String str2 : al2) {
			System.out.println(str2);
		}
	}
	public static ArrayList remove(ArrayList arrList) // xóa những sđt trùng
	{
	    HashSet h = new HashSet(arrList);
	    arrList.clear();
	    arrList.addAll(h);
	   
	    return arrList;
	                   
	}
	private static boolean ktra(char charAt) {
		// TODO Auto-generated method stub
		String s = new String();
		s = charAt + "";
		boolean a = s.matches("[0-9]");
		return a;
	}

	private static boolean KtEmail(String s)
	{	
		boolean a = s.matches("[0-9]{10,11}");
		return a;
	}
	
	
	
}
