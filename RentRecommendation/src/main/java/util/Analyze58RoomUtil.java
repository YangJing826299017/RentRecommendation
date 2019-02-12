package util;

import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import entity.FiveEightRoom;

public class Analyze58RoomUtil {
    
    private String roomUrl;
    private static String roomName=".c_333.f20";//房间名字
    private static int roomNameIndex=0;//房间名字
    private static String rentMoney;//租金
    private static String unit;//租金单位
    private static List<String> rentWays;//租借方式 [整租/押二付款一]
    private static String houseOrientation;//房屋朝向
    private static String housingAllocation;//房屋配置 
    private static String housingSourceCharacteristics;//房源特色
    private static Map<String,String> busStation;//公交站
    private static Map<String,String> subwayStation;//地铁站
    private static String roomType;//户型N室N房
    private static String decorationDegree;//装修程度
    private static String realArea;//房间实际面积
    private static String height;//楼高
    private static String address;//地址
    private static String description;//描述,以逗号间隔
    
    public static FiveEightRoom getResult(String htmlContent){
        Document document=Jsoup.parse(htmlContent);
        FiveEightRoom room=new FiveEightRoom();
        room.setRoomName(document.select(roomName).get(roomNameIndex).text());
        return room;
    }

}
