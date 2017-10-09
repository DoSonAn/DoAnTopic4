package url;

import java.awt.List;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.AbstractDocument.Content;

public class TestCMT {

	
	public static void main(String[] args) {
		String link ="https://www.thegioididong.com/dtdd/samsung-galaxy-s8-plus";
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
/*		//String strP = "<div class="">(\\S+)</div>";
		Pattern p = Pattern.compile("<div class=\"rc\">(?a)</div>");
	    Matcher m = p.matcher(content);

	    // if we find a match, get the group 
	    if (m.find()) {

	      // get the matching group
	     // String codeGroup = m.group(1);
	      
	      // print the group
	    System.out.println( m.group("a"));

	
	    }
	    
	  */
	    
		//final String str = "<tag>apple</tag><b>hello</b><tag>orange</tag><tag>pear</tag>";
	    System.out.println(Arrays.toString(getTagValues(content).toArray())); // Prints [apple, orange, pear]
	}
	
	


	private static final Pattern TAG_REGEX = Pattern.compile("<div class=\"rc\">(.+?)</div>");

	    private static ArrayList getTagValues(final String str) {
	        final ArrayList tagValues = new ArrayList();
	        final Matcher matcher = TAG_REGEX.matcher(str);
	        while (matcher.find()) {
	            tagValues.add(matcher.group(1));
	        }
	        return tagValues;
	    }
	
}
