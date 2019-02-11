package util;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class AnalyzeGanJiRoomUtil {
	
	private static String prefix="";
	
	/**
	 * 房子名字:p.card-title 
	 *房租:span.price
	 *户型:span.content index:0
	 *面积:span.content index:1
	 *朝向:span.content index:2
	 *楼高:span.content index:3
	 *装修程度:span.content index:4
	 *小区名字:.er-item.f-fl>span.content>a>span
	 *地址:.er-item.f-fl>span.content index:1
	 *房屋配套:ul.collocation>.item 需要判断这个item是否有.dele 然后p index:1
	 *房屋描述:div.describe
	 *
	 *------小区信息------
	 *需要跳转新的地址
	 *商圈:span.content index:0
	 *详细地址:span.content index:1
	 *建筑类型:span.content index:2
	 *物业费用:span.content index:3
	 *产权类别:span.content index:4
	 *容  积  率:span.content index:5
	 *总  户  数:span.content index:6
	 *绿  化  率:span.content index:7
	 *建筑年代:span.content index:8
	 *停  车  位:span.content index:9
	 *开  发  商:span.content index:10
	 *物业公司:span.content index:11
	 */
	
	
	public static Map<String,String> getResult(String htmlContent){
		Map<String,String> map=new HashMap<String, String>();
		Document document=Jsoup.parse(htmlContent);
		System.out.println(document.select("span.content").get(0).text());
		return null;
	}

}
