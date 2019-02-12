package util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import entity.Room;

//解析乐有家页面
public class AnalyzeLeYouJiaPageUtil {
    
    private static  String prefix="https://shenzhen.leyoujia.com";

	public static  List<String> getResult(String htmlContent){
		Document document=Jsoup.parse(htmlContent);
		//1.筛选出列表中的每一个节点
		Elements elements=document.select(".list-box .item");
		//2.遍历所有节点,转化成实体LeYouJiaRoom
		List<String> list=new ArrayList<String>();
		for(Element one:elements) {
			list.add(parseOneElement(one).getRoomUrl());
		}
		
		return list;
	}
	
	private static Room parseOneElement(Element element) {
		Room room=new Room();
		//1.获取picturePath
		String picturePath=element.select(".img a").attr("href");
		room.setRoomUrl(prefix+picturePath);
		//2.roomName
		String roomName=element.select(".text .tit a").attr("title");
		room.setRoomName(roomName);
		//3.roomType 户型N室N房
		String roomType=element.select(".text .attr span").get(0).text();
		room.setRoomType(roomType);
		//4.totalArea 建筑面积
		String totalArea=element.select(".text .attr span").get(2).text();
		room.setTotalArea(totalArea);
		//5.realArea 房间实际面积
		String realArea=element.select(".text .attr span").get(3).text();
		room.setRealArea(realArea);
		//6.decorationDegree 装修程度
		String decorationDegree=element.select(".text .attr span").get(4).text();
		room.setDecorationDegree(decorationDegree);
		//7.height 楼高
		String height=element.select(".text .attr span").get(5).text();
		room.setHeight(height);
		//8.buildYear 建成时间
		String buildYear=element.select(".text .attr span").get(6).text();
		room.setRoomBuildYear(buildYear);
		//9.address 地址
		String address1=element.select(".text .attr span").get(8).select("a").get(0).html();
		String address2=element.select(".text .attr span").get(8).select("a").get(1).html();
		String address3=element.select(".text .attr span").get(7).select("a").html();
		room.setAddress(address1+"-"+address2+"-"+address3);
		return room;
	}

}
