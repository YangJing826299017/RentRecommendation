package util;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AnalyzeGanJiPageUtil {
	
	private static String prefix="";
	private static String listItem=".ershoufang-list>dl>dd.title>a";
	
	public static List<String> getResult(String htmlContent) {
		Document document=Jsoup.parse(htmlContent);
		Elements elements=document.select(listItem);
		for (Element oneItem : elements) {
			String href=oneItem.attr("href");
			System.out.println(href);
		}
		return null;
	}

}
