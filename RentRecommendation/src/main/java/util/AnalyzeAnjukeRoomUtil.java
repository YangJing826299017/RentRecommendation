package util;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class AnalyzeAnjukeRoomUtil {
	
	private static String roomName=".house-title";
	private static String roomType=".house-info-item>span.info";
	private static int roomTypeIndex=0;
	private static String totalArea="span.info-tag";
	private static int totalAreaIndex=2;
	private static String rentWay="li.title-label-item.rent";
    private static String houseOrientation="li.title-label-item.buy";//房屋朝向
    private static String height=".house-info-item>span.info";//楼高
    private static int heightIndex=3;//楼高
    private static String decorationDegree=".house-info-item>span.info";//装修程度
    private static int decorationDegreeIndex=4;//装修程度
    /*房屋类型特有**/
    
    private static String housingSourceCharacteristics=".auto-general";//房源特色
    private static String housingAllocation=".peitao-item.has";//房屋配置 
    
    /**小区信息*/
    private static String communityName=".house-info-item>a.link";//小区名字
    private static int communityNameIndex=0;
    private static String communityUrlAttr="href";
    private static String communityAddress=".sub-hd";
    private static String communityType="dl.basic-parms-mod>dd";
    private static int communityTypeIndex=0;
    private static String buildArea="dl.basic-parms-mod>dd";//建筑面积
    private static int buildAreaIndex=2;
    private static String plotRatio="dl.basic-parms-mod>dd";//容积率
    private static int plotRatioIndex=6;
    private static String afforestationRate="dl.basic-parms-mod>.other-dd";//绿化率
    private static int afforestationRateIndex=3;
    private static String propertyCompany="dl.basic-parms-mod>.dd-column";//物业公司
    private static int propertyCompanyIndex=1;

    
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
