package util;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class AnalyzeAnjukeRoomUtil {
	
	/***
	 * 房屋名字:house-title
	 * 租金:span.light.info-tag>em
	 * 户型:.house-info-item>span.info index=0
	 * 面积:span.info-tag index=2
	 * 租赁方式: li.title-label-item.rent
	 * 朝向:li.title-label-item.buy
	 * 楼层:.house-info-item>span.info index=3
	 * 装修程度:.house-info-item>span.info index=4
	 *类型:house-info-item>span.info index=5
	 *小区名字: .house-info-item>a.link index=0 href
	 *房屋配套设施: .peitao-item.has
	 *房屋概况: .auto-general
	 *
	 *-------小区信息----------
	 *小区名字: .comm-title>h1
	 *地址:.sub-hd
	 *类型:dl.basic-parms-mod>dd index=0
	 *物业费:dl.basic-parms-mod>.other-dd index=0
	 *总建筑面积:dl.basic-parms-mod>dd index=2
	 *总户数:dl.basic-parms-mod>.other-dd index=1
	 *建造年代:dl.basic-parms-mod>dd index=4
	 *停车位:dl.basic-parms-mod>.other-dd index=2
	 *容积率:dl.basic-parms-mod>dd index=6
	 *绿化率:dl.basic-parms-mod>.other-dd index=3
	 *开发商:dl.basic-parms-mod>.dd-column index=0
	 *物业公司:dl.basic-parms-mod>.dd-column index=1
	 */
	
	public static Map<String,String> getResult(String htmlContent){
		Map<String,String> map=new HashMap<String, String>();
		Document document=Jsoup.parse(htmlContent);
		System.out.println(document.select("dl.basic-parms-mod>.dd-column").get(1).text());
		return map;
	}

}
