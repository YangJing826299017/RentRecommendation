package util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import entity.LeYouJiaCommunity;
import entity.LeYouJiaRoom;

public class AnalyzeLeYouJiaRoomDeatilUtil {
    
    /**非详细页特有信息*/
    private static String roomName=".tit-conno";//房间名字
    private static String roomType=".intro-box2>span:nth-child(1)";//户型N室N房
    private static String totalArea=".intro-box2>span:nth-child(2)";//建筑面积
    private static String realArea="em.ml20.c333";//房间实际面积
    private static int realAreaIndex=1;
    private static String decorationDegree=".intro-box2>span:nth-child(3)";//装修程度
    private static String height="em.ml20.c333";//楼高
    private static int heightIndex=2;//楼高
    private static String buildYear="em.ml20.c333";//建成时间
    private static int buildYearIndex=4;
    private static String address="a.area-cur";//地址
    private static int addressIndex=2;
    private static String description;//描述,以逗号间隔
    
    /**详细页特有信息*/
    private static String rentMoney="em.total";//租金
    private static int rentMoneyIndex=0;
    private static String rentMoneyUnit="span.price-1";//租金单位
    private static int rentMoneyUnitIndex=0;
    private static List<String> rentWays;//租借方式 [整租/押二付款一]
    private static String roomNumber="";//房源编号
    private static String houseOrientation="em.ml20.c333";//房屋朝向
    private static int houseOrientationIndex=3;
    private static String housingAllocation=".fy-intro-icons>li";//房屋配置 
    private static String housingSourceCharacteristics="p.mb15";//房源特色
    private static String subwayStation=".list-box";//地铁站
    private static int subwayStationIndex=0;//地铁站
    private static Map<String,String> busStation;//公交站
    
    /**小区信息*/
    private static String communityName=".infomation-hd>span>a";//小区名字
    private static String rentNumber="";//在租房屋数量
    private static String saleNumber;//在卖房屋数量
    private static String liveNumber="li.w1>span";//规划户数
    private static int liveNumberIndex=3;
    private static String buildArea="li.w2>span";//建筑面积
    private static int buildAreaIndex=3;
    private static String plotRatio="li.w1>span";//容积率
    private static int plotRatioIndex=5;
    private static String numberOfParkingSpaces="li.w2>span";//车位个数
    private static int numberOfParkingSpacesIndex=5;
    private static String afforestationRate="li.w1>span";//绿化率
    private static int afforestationRateIndex=7;
    private static String propertyCompany="li.w2>span";//物业公司
    private static int propertyCompanyIndex=7;
    
    public static LeYouJiaRoom getResult(String htmlContent){
        LeYouJiaRoom room=new LeYouJiaRoom();
        Document document=Jsoup.parse(htmlContent);
        //1.房间名字
        room.setRoomName(document.select(roomName).attr("title"));
        //2.户型N室N房
        room.setRoomType(document.select(roomType).text());
        //3.建筑面积
        room.setTotalArea(document.select(totalArea).text());
        //4.房间实际面积
        room.setRealArea(document.select(realArea).get(realAreaIndex).text());
        //5.装修程度
        room.setDecorationDegree(document.select(decorationDegree).text());
        //6.楼高
        room.setHeight(document.select(height).get(heightIndex).text());
        //7.建成时间
        room.setBuildYear(document.select(buildYear).get(buildYearIndex).text());
        //8.地址
        room.setAddress(document.select(address).get(addressIndex).text());
        //9.描述,以逗号间隔
        room.setDescription("页面未详细写!");
        //10.租金
        String money=document.select(rentMoney).get(rentMoneyIndex).text();
        room.setRentMoney(money);
        //11.租金单位
        String unit=document.select(rentMoneyUnit).get(rentMoneyUnitIndex).text();
        room.setUnit(unit);
        //13.房屋朝向
        room.setHouseOrientation(document.select(houseOrientation).get(houseOrientationIndex).text());
        //14.房源特色
        room.setHousingSourceCharacteristics(getHousingSourceCharacteristics(document));
        //15.获取租借方式
        room.setRentWays(getRentWays(document));
        //16.房屋配置
        room.setHousingAllocation(getHousingAllocation(document));
        //17.地铁站
        room.setSubwayStation(getSubwayStation(document));
        //18.公交站
        room.setBusStation(getBusStation(document));
        //19.小区信息
        room.setCommunity(getCommunity(document));
        return room;
    }
    
    //获取房源特色
    private static String getHousingSourceCharacteristics(Document document){
        StringBuilder sb=new StringBuilder();
        Elements elements=document.select(housingSourceCharacteristics);
        for (Element element : elements) {
            sb.append(element.html()+"\n");
        }
        return sb.toString();
    }
    
    //获取租借方式
    private static List<String> getRentWays(Document document){
        return null;
    }
    
    //房屋配置
    private static String getHousingAllocation(Document document){
        StringBuilder sb=new StringBuilder();
        Elements elements=document.select(housingAllocation);
        for (Element element : elements) {
            if(!element.hasClass("no")){
                sb.append(element.text()+",");
            }
        }
        return sb.toString().endsWith(",")?sb.toString().substring(0,sb.toString().length()-1):sb.toString();
    }
    
    //获取相近的地铁站
    private static Map<String,String> getSubwayStation(Document document){
        Map<String,String> map=new HashMap<String, String>();
        Element element=document.select(subwayStation).get(subwayStationIndex);
        Elements listA=element.select("a");
        for (Element a : listA) {
            String name=a.select(".item").text();
            String distance=a.select(".range").text();
            map.put(name, distance);
        }
        return map;
    }
    
    //获取相近的公交站
    private static Map<String,String> getBusStation(Document document){
        Map<String,String> map=new HashMap<String, String>();
        return map;
    }
    
    //获取小区信息
    private static LeYouJiaCommunity getCommunity(Document document){
        LeYouJiaCommunity community=new LeYouJiaCommunity();
        //1.小区名字
        community.setCommunityName(document.select(communityName).text());
        //2.在租房屋数量
        community.setRentNumber("");
        //3.在卖房屋数量
        community.setSaleNumber("");
        //4.建造年代
        community.setBuildYear(document.select(buildYear).get(buildYearIndex).text());
        //5.规划户数
        community.setLiveNumber(document.select(liveNumber).get(liveNumberIndex).text());
        //6.建筑面积
        community.setBuildArea(document.select(buildArea).get(buildAreaIndex).text());
        //7.容积率
        community.setPlotRatio(document.select(plotRatio).get(plotRatioIndex).text());
        //8.车位个数
        community.setNumberOfParkingSpaces(document.select(numberOfParkingSpaces).get(numberOfParkingSpacesIndex).text());
        //9.绿化率
        community.setAfforestationRate(document.select(afforestationRate).get(afforestationRateIndex).text());
        //10.物业公司
        community.setPropertyCompany(document.select(propertyCompany).get(propertyCompanyIndex).text());
        return community;
    }

}
