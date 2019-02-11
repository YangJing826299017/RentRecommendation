package util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AnalyzeAnjukePageUtil {
	
	private static String prefix="";
	private static String listItem="div.zu-itemmod";
	
	public static List<String> getResult(String htmlContent){
		List<String> listResult=new ArrayList<String>();
		Document document=Jsoup.parse(htmlContent);
		Elements elements=document.select(listItem);
		for (Element oneElement : elements) {
			String href=oneElement.attr("link");
			listResult.add(prefix+href);
			System.out.println(href);
		}
		return listResult;
	}

}
