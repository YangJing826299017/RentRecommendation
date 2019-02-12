package util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//赶集网房源首页Url:http://sz.ganji.com/zufang/pn1/
public class AnalyzeGanJiPageUtil {
	
	private static String prefix="";
	private static String listItem=".ershoufang-list>dl>dd.title>a";
	
	public static List<String> getResult(String htmlContent) {
		List<String> listResult=new ArrayList<String>();
		Document document=Jsoup.parse(htmlContent);
		Elements elements=document.select(listItem);
		for (Element oneItem : elements) {
			String href=oneItem.attr("href");
			listResult.add(prefix+href);
		}
		return listResult;
	}

}
