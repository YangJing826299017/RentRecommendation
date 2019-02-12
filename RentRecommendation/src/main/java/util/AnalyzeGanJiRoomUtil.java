package util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import entity.Room;

public class AnalyzeGanJiRoomUtil {
	
	private static String prefix="http:";
	
	private static String roomName="p.card-title";
	private static String rentMoney="span.price";

	private static String roomType="span.content";
	private static int roomTypeIndex=0;
	
	private static String totalArea="span.content";
	private static int totalAreaIndex=1;
	
	private static String rentWay="span.unit";
	
    private static String houseOrientation="span.content";//房屋朝向
	private static int houseOrientationIndex=2;

    private static String height="span.content";//楼高
    private static int heightIndex=3;//楼高
    
    private static String decorationDegree="span.content";//装修程度
    private static int decorationDegreeIndex=4;//装修程度
    
    private static String communityName=".er-item.f-fl>span.content>a";//小区名字
    private static int communityNameIndex=0;
    private static String communityUrlAttr="href";

    private static String housingSourceCharacteristics="div.describe";//房源特色
    
    private static String housingAllocation="ul.collocation>.item";//房屋配置 
    
    /**小区信息*/
    private static String communityAddress="span.content";
    private static int communityAddressIndex=1;
    
    /*
    private static String buildArea="dl.basic-parms-mod>dd";//建筑面积
    private static int buildAreaIndex=2;
    */
    private static String plotRatio="span.content";//容积率
    private static int plotRatioIndex=5;
    private static String afforestationRate="span.content";//绿化率
    private static int afforestationRateIndex=7;
    private static String propertyCompany="span.content";//物业公司
    private static int propertyCompanyIndex=11;
    private static String communityBuildYear="span.content";
    private static int communityBuildYearIndex=8;
    private static String numberOfParkingSpaces="span.content";//车位个数
    private static int numberOfParkingSpacesIndex=9;
    private static String communityLiveNumber="span.content";//规划户数
    private static int communityLiveNumberIndex=6;
	
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
	
	
	public static Room getResult(String htmlContent,String roomUrl){
		Room room=new Room();
		Document document=Jsoup.parse(htmlContent);
		room.setRoomUrl(roomUrl);
		room.setRoomName(document.select(roomName).text());
		room.setRentMoney(document.select(rentMoney).text());
		room.setUnit("元/月");
		room.setRentWays(document.select(rentWay).text());
		room.setHouseOrientation(document.select(houseOrientation).get(houseOrientationIndex).text());
		//房间配置
		room.setHousingAllocation(getHousingAllocation(document));
		room.setHousingSourceCharacteristics(document.select(housingSourceCharacteristics).text());
		room.setRoomType(document.select(roomType).get(roomTypeIndex).text());
		room.setDecorationDegree(document.select(decorationDegree).get(decorationDegreeIndex).text());
		room.setRealArea(document.select(totalArea).get(totalAreaIndex).text());
		room.setHeight(document.select(height).get(heightIndex).text());
		room.setTotalArea(document.select(totalArea).get(totalAreaIndex).text());
		room.setCommunityName(document.select(communityName).get(communityNameIndex).text());
		String communityUrl=document.select(communityName).get(communityNameIndex).attr(communityUrlAttr);
		if(communityUrl.startsWith("//")) {
			communityUrl=prefix+communityUrl;
		}
		//---小区信息
		Document communityDocument=getCommunityDocument(communityUrl);
		room.setCommunityUrl(communityUrl);
		room.setCommunityBuildYear(communityDocument.select(communityBuildYear).get(communityBuildYearIndex).text());
		room.setCommunityBuildArea("");
        room.setCommunityPlotRatio(communityDocument.select(plotRatio).get(plotRatioIndex).text());
        room.setCommunityNumberOfParkingSpaces(communityDocument.select(numberOfParkingSpaces).get(numberOfParkingSpacesIndex).text());
        room.setCommunityAfforestationRate(communityDocument.select(afforestationRate).get(afforestationRateIndex).text());
        room.setCommunityPropertyCompany(communityDocument.select(propertyCompany).get(propertyCompanyIndex).text());
        room.setCommunityAddress(communityDocument.select(communityAddress).get(communityAddressIndex).text());
        room.setAddress(communityDocument.select(communityAddress).get(communityAddressIndex).text());
		room.setRoomBuildYear(communityDocument.select(communityBuildYear).get(communityBuildYearIndex).text());
		room.setCommunityLiveNumber(communityDocument.select(communityLiveNumber).get(communityLiveNumberIndex).text());
		return room;
	}
	
	private static Document getCommunityDocument(String communityUrl) {
		try {
			Thread.sleep(1*60*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String htmlContent=HttpUtil.doGet(communityUrl);
		return Jsoup.parse(htmlContent);
	}
	
	private static String getHousingAllocation(Document document) {
		Elements eles=document.select(housingAllocation);
		StringBuilder sb=new StringBuilder();
		for (Element one : eles) {
			if(!one.hasClass("dele")) {
				sb.append(one.select("p").get(1).text()+",");
			}
		}
		return sb.toString().endsWith(",")?sb.substring(0,sb.toString().length()-1):sb.toString();
	}

}
