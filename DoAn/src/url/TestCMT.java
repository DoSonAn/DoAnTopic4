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
		String link ="https://www.lazada.vn/bo-2-bot-ve-sinh-long-may-giat-han-quoc-10397531.html?spm=a2o4n.home.sku-feed-slider-with-banner_461834.18.BMf2bY";
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

		
		String a = content.toString().replaceAll("</div>", "");
	    System.out.println(Arrays.toString(getTagValues(a).toArray())); // Prints [apple, orange, pear]
	}
	
	


	private static final Pattern TAG_REGEX = Pattern.compile("<div class=\"c-rating-total__text-total-review\" data-qaa=\"c-rating-total__text-total-review\">(.+?)></div><div id=\"reviewslist\"    class=\"c-review-list\"    data-qaa=\"c-review-list\"    ");

	private static ArrayList<String> getTagValues(final String str) {
		
	    final ArrayList<String> tagValues = new ArrayList<String>();
	    final Matcher matcher = TAG_REGEX.matcher(str);
	    while (matcher.find()) {
	        tagValues.add(matcher.group(1));
	      
	    }
	    return tagValues;
	}
	
}
