package util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import entity.Room;

public class AnalyzeAnjukeRoomUtil {
	
	private static String roomName=".house-title";
	private static String roomType=".house-info-item>span.info";
	private static String rentMoney="span.light.info-tag>em";
	private static int roomTypeIndex=0;
	private static String totalArea="span.info-tag";
	private static int totalAreaIndex=2;
	private static String rentWay="li.title-label-item.rent";
    private static String houseOrientation="li.title-label-item.buy";//房屋朝向
    private static String height=".house-info-item>span.info";//楼高
    private static int heightIndex=3;//楼高
    private static String decorationDegree=".house-info-item>span.info";//装修程度
    private static int decorationDegreeIndex=4;//装修程度
    private static String communityName=".house-info-item>a.link";//小区名字
    private static String communityUrlAttr="href";

    private static String housingSourceCharacteristics=".auto-general";//房源特色
    private static String housingAllocation=".peitao-item.has>.peitao-info";//房屋配置 
    
    /**小区信息*/
    private static int communityNameIndex=0;
    private static String communityAddress=".sub-hd";
    private static String buildArea="dl.basic-parms-mod>dd";//建筑面积
    private static int buildAreaIndex=2;
    private static String plotRatio="dl.basic-parms-mod>dd";//容积率
    private static int plotRatioIndex=6;
    private static String afforestationRate="dl.basic-parms-mod>.other-dd";//绿化率
    private static int afforestationRateIndex=3;
    private static String propertyCompany="dl.basic-parms-mod>.dd-column";//物业公司
    private static int propertyCompanyIndex=1;
    private static String communityBuildYear="dl.basic-parms-mod>dd";
    private static int communityBuildYearIndex=4;
    private static String numberOfParkingSpaces="dl.basic-parms-mod>.other-dd";//车位个数
    private static int numberOfParkingSpacesIndex=2;
    private static String communityLiveNumber="dl.basic-parms-mod>dd";//规划户数
    private static int communityLiveNumberIndex=4;

    
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
	
	public static Room getResult(String htmlContent,String roomUrl){
		Room room=new Room();
		Document document=Jsoup.parse(htmlContent);
		room.setRoomUrl(roomUrl);
		room.setRoomName(document.select(roomName).text());
		room.setRentMoney(document.select(rentMoney).text());
		room.setUnit("元/月");
		room.setRentWays(document.select(rentWay).text());
		room.setHouseOrientation(document.select(houseOrientation).text());
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
		//---小区信息
		Document communityDocument=getCommunityDocument(communityUrl);
		room.setCommunityUrl(communityUrl);
		room.setCommunityBuildYear(communityDocument.select(communityBuildYear).get(communityBuildYearIndex).text());
		room.setCommunityBuildArea(communityDocument.select(buildArea).get(buildAreaIndex).text());
        room.setCommunityPlotRatio(communityDocument.select(plotRatio).get(plotRatioIndex).text());
        room.setCommunityNumberOfParkingSpaces(communityDocument.select(numberOfParkingSpaces).get(numberOfParkingSpacesIndex).text());
        room.setCommunityAfforestationRate(communityDocument.select(afforestationRate).get(afforestationRateIndex).text());
        room.setCommunityPropertyCompany(communityDocument.select(propertyCompany).get(propertyCompanyIndex).text());
        room.setCommunityAddress(communityDocument.select(communityAddress).text());
        room.setAddress(communityDocument.select(communityAddress).text());
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
			sb.append(one.text()+",");
		}
		return sb.toString().endsWith(",")?sb.substring(0,sb.toString().length()-1):sb.toString();
	}

}
